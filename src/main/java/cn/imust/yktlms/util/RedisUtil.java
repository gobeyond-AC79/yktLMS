package cn.imust.yktlms.util;

import cn.imust.yktlms.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @author SERENDIPITY
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key
     * @param time 时间（秒）
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key,time, TimeUnit.MINUTES);
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key获取过期时间
     * @param key 不能为null
     * @return 返回0代表永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return true存在 || false不存在
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存  可以传一个值或者多个
     * @param key
     */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 将缓存放入并设置时间
     * @param key
     * @param attendance
     * @param time
     * @return
     */
    public boolean stringSet(String key, Attendance attendance, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key,attendance,time,TimeUnit.MINUTES);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取全部缓存
     * @return
     */
    public List<Attendance> getRedis() {
        Set<String> keys = redisTemplate.keys("*");
        ArrayList<Attendance> list = new ArrayList<>();
        for (String key:keys) {
            Object value = redisTemplate.opsForValue().get(key);
            list.add((Attendance) value);
        }
        return list;
    }

}
