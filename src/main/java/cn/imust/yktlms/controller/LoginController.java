package cn.imust.yktlms.controller;

import cn.imust.yktlms.enums.LoginErrorEnum;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 登录验证
 * 获取验证码
 * @author SERENDIPITY
 */
@Controller
public class LoginController{

    /**
     * session中的验证码
     */
    private String SHIRO_VERIFY_SESSION = "verifySessionCode";
    /**
     * 错误后的跳转地址
     */
    private String ERROR_CODE_URL = "login";

    @Autowired
    private DefaultKaptcha defaultKaptcha;


    /**
     * 登录跳转
     * @return
     * @throws Exception
     */
    @GetMapping("/login")
    public String loginUI()throws Exception {
        return "login";
    }

    /**
     * 登录表单处理
     * @param userName
     * @param userPassword
     * @param verifyCode
     * @param rememberMe
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("userPassword") String userPassword,
                        @RequestParam(value = "verifyCode" , required = false)String verifyCode,
                        @RequestParam(value = "rememberMe" , required = false) boolean rememberMe,
                        Model model,
                        HttpServletRequest request) throws Exception {
        //shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        Subject subject = SecurityUtils.getSubject();
        //获取session中的验证码
        String verCode = (String) subject.getSession().getAttribute(SHIRO_VERIFY_SESSION);
        if ("".equals(verifyCode) || (!verCode.equals(verifyCode))) {
            model.addAttribute("message",LoginErrorEnum.ERROR_KAPTCHA.getMsg());
            return ERROR_CODE_URL;
        }
        try {
            //主体提交登录请求到SecurityManager
            token.setRememberMe(rememberMe);
            subject.login(token);
        }catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg", LoginErrorEnum.ERROR_PASSWORD.getMsg());
        } catch (UnknownAccountException uae) {
            model.addAttribute("msg", LoginErrorEnum.ERROR_ACCOUNT.getMsg());
        } catch (AuthenticationException ae) {
            model.addAttribute("msg", LoginErrorEnum.ERROR_KAPTCHA.getMsg());
        }
        if (subject.isAuthenticated()) {
            model.addAttribute("userName", userName);
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            System.out.println("url:"+savedRequest.getRequestUrl());
            if (!"/".equals(savedRequest.getRequestUrl()) && !"/favicon.ico".equals(savedRequest.getRequestUrl())) {
                return "redirect://192.168.1.7:8080/"+savedRequest.getRequestUrl();
            }else if (savedRequest.getRequestUrl() == null || "/".equals(savedRequest.getRequestUrl()) || "/favicon.ico".equals(savedRequest.getRequestUrl())){
                savedRequest.getRequestUrl();
                if (subject.hasRole("ADMIN")) {
                    return "redirect:/admin/showCourse";
                } else if (subject.hasRole("STUDENT")) {
                    return "redirect:/student/showCourse";
                } else if (subject.hasRole("TEACHER")) {
                    return "redirect:/teacher/showCourse";
                }
            }
        }else {
            return ERROR_CODE_URL;
        }
        return "login";
    }

    /**
     * 验证码生成
     * @param response
     * @param request
     * @throws IOException
     */
    @GetMapping("/getCode")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        byte[] verByte = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute(SHIRO_VERIFY_SESSION,createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge,"jpg",jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }catch (IOException e){
            e.printStackTrace();
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        verByte = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(verByte);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

}