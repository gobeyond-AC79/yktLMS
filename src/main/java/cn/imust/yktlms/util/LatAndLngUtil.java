package cn.imust.yktlms.util;

import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author SERENDIPITY
 */
public class LatAndLngUtil {

    public JSONObject getCoordinate(String ip)throws Exception {
        if (ip == null) {
            ip = "";
        }
        String key = "6VL8RoiEzGPhE4AxefHHGuRMd3p70YCr";
        try {
            URL url = new URL("http://api.map.baidu.com/location/ip?ak="+key+"&ip="+ip+"&coor=bd09ll");
            InputStream inputStream = url.openStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String result = bufferedReader.readLine();
            if (!StringUtils.hasText(result)) {
                return null;
            }
            JSONObject resultJson = JSONObject.fromObject(result);
            String code = resultJson.get("status").toString();
            if (!"0".equals(code)) {
                return null;
            }
            JSONObject contentJson = JSONObject.fromObject(resultJson.get("content"));
            return JSONObject.fromObject(contentJson.get("point"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
