package cn.imust.yktlms.util;

import	java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 用户名生成
 * 类似于stu+年份后两位+月份+4位随机数
 * @author SERENDIPITY
 */
public class IdGenerateUtil {

    /**
     * 定义学号用户名前缀是stu
     */
    private static final String STUDENT_KEY = "stu";

    /**
     * 定义教工号前缀是teach
     */
    private static final String TEACHER_KEY = "teach";

    /**
     * 定义管理员前缀是admin
     */
    private static final String ADMIN_KEY = "admin";

    /**
     * 定义课程号前缀cou
     */
    private static final String COURSE_KEY = "cou";

    /**
     * 定义作业号前缀work
     */
    private static final String WORK_KEY = "work";

    private static Random rand;
    static {
        rand = new Random();
    }

    private IdGenerateUtil() {

    }

    /**
     * 根据生成学号
     * @return
     */
    public static String getStudentId() {
        return getIdString(STUDENT_KEY);
    }

    /**
     * 根据生成教师工号
     * @return
     */
    public static String getTeacherId() {
        return getIdString(TEACHER_KEY);
    }

    /**
     * 生成管理员id
     * @return
     */
    public static String getAdminId() {
        return getIdString(ADMIN_KEY);
    }

    /**
     * 生成课程号
     * @return
     */
    public static String getCourseId() {
        return getIdString(COURSE_KEY);
    }

    /**
     * 生成作业号
     * @return
     */
    public static String getHomeworkId() {
        return getIdString(WORK_KEY);
    }

    /**
     * 生成对应角色的id
     * @param teacherKey
     * @return
     */
    private static String getIdString(String teacherKey) {
        StringBuffer sb = new StringBuffer();
        synchronized (sb) {
            for (int i = 1; i <= 2; i++) {
                if (i <=1 ) {
                    sb.append(teacherKey);
                }else{
                    sb.append(getNum());
                }
            }
        }
        return sb.toString();
    }

    /**
     * 生成七位数
     * @return
     */
    public static String getNum() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyMM");
        String datetime = sdf.format(new Date(System.currentTimeMillis()));
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 5; i++) {
            if (i <= 1) {
                sb.append(datetime);
            }else {
                sb.append(getRadomInt(0,9));
            }
        }
        return sb.toString();
    }

    public static int getRadomInt(int min,int max) {
        return rand.nextInt(max-min+1)+min;
    }
}
