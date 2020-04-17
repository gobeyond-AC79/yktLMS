package cn.imust.yktlms.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGenerateUtilTest {

    @Test
    public void test() {
        System.out.println(IdGenerateUtil.getStudentId());
        System.out.println(IdGenerateUtil.getTeacherId());
        System.out.println(IdGenerateUtil.getAdminId());
    }

}