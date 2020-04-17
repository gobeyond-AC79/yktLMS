package cn.imust.yktlms.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * 密码生成
 * 密码加密
 * md5盐值生成
 * @author SERENDIPITY
 */
public class PasswordGenerateUtil {

    /**
     * 散列次数
     */
    private static final Integer HASH_TIME = 2;

    private static final String SALT_TIME = "ykt";

    /**
     * 默认密码是用户名
     * 用当前date作为盐值加密
     * @param userName
     * @return
     */
    public static String passwordGenerate(String userName) {

        String salt = saltGenerate(userName);
        return passwordEncryption(userName,salt,HASH_TIME);
    }

    /**
     * 生成md5盐值
     * @return
     */
    public static String saltGenerate(String userName){
        return SALT_TIME + userName;
    }

    /**
     * 密码加密
     * @param password 输入密码
     * @param salt 盐值
     * @param hashTimes 散列次数
     * @return
     */
    public static String passwordEncryption(String password,String salt,int hashTimes){
        Md5Hash md5Hash = new Md5Hash(password,salt,hashTimes);
        return md5Hash.toString();
    }

    /**
     * 测试生成密码
     */
    /*@Test
    public void test() {
        String password = "123456";
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd");
        String salt = sdFormatter.format(nowTime);
        System.out.println(salt);
        System.out.println(passwordEncryption(password,salt,HASH_TIME));
    }*/

}
