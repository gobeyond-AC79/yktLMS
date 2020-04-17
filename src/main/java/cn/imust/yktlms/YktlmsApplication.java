package cn.imust.yktlms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类配置
 * @author SERENDIPITY
 */
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("cn.imust.yktlms.mapper")
public class YktlmsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(YktlmsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(YktlmsApplication.class, args);
    }

}
