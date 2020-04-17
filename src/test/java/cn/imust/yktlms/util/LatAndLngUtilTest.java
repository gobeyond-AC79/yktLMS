package cn.imust.yktlms.util;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LatAndLngUtilTest {

    @Test
    void test() throws Exception {
        LatAndLngUtil util = new LatAndLngUtil();
        JSONObject coordinate = util.getCoordinate("192.168.1.9");
        System.out.println(coordinate);
    }
}