package cn.imust.yktlms.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper接口
 * @author SERENDIPITY
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //注意该接口不能被扫描到
    //在启动类中通过MapperScan注解指定扫描mapper路径
}
