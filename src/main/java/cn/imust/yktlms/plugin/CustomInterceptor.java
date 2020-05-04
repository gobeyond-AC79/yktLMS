package cn.imust.yktlms.plugin;

import cn.imust.yktlms.annotations.CreateTime;
import cn.imust.yktlms.annotations.UpdateTime;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * @author SERENDIPITY
 * @Date 2020/5/4 13:39
 */
@Component
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class,Object.class})})
public class CustomInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        //获取SQL命令
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        //获取参数
        Object parameter = invocation.getArgs()[1];
        //获取私有成员变量
        Field[] declaredFields = parameter.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(CreateTime.class) != null) {
                if (SqlCommandType.INSERT.equals(sqlCommandType)) {  //insert语句插入createtime
                    field.setAccessible(true);
                    field.set(parameter,new Timestamp(System.currentTimeMillis()));
                }
            }
            if (field.getAnnotation(UpdateTime.class) != null) {  //insert或update语句插入updatetime
                if (SqlCommandType.INSERT.equals(sqlCommandType) || SqlCommandType.UPDATE.equals(sqlCommandType)) {
                    field.setAccessible(true);
                    field.set(parameter,new Timestamp(System.currentTimeMillis()));
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
