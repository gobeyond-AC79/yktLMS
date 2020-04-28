package cn.imust.yktlms.util;

import java.io.*;

/**
 * @author SERENDIPITY
 * @Date 2020/4/27 9:44
 */
public class SerializeUtil {

    /**
     * 序列化为字符串
     * @param object
     * @return
     * @throws IOException
     */
    public static String serialize(Object object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        String string = byteArrayOutputStream.toString("ISO-8859-1");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return string;
    }

    /**
     * 将字符串反序列化为对象
     * @param string
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object serializeToObject(String string) throws IOException,ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes("ISO-8859-1"));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return object;
    }

}
