package com.hulunbuir.clam.evening;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.hulunbuir.clam.parent.tool.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.hulunbuir.clam.evening",
        "com.hulunbuir.clam.parent",
        "com.hulunbuir.clam.common",
        "com.hulunbuir.clam.distributed",
        "com.hulunbuir.clam.route.config",
})
@EnableDubboConfiguration
@Slf4j
public class HulunBuirEveningApplication {

    public static void main(String[] args) {
        log.info("开始启动-->{}", DateUtils.getDateTimes());
        SpringApplication.run(HulunBuirEveningApplication.class, args);
        log.info("启动成功-->{}", DateUtils.getDateTimes());
    }

    /**
     * 配置Security不需要登录验证
     * @author wangjunming
     * @since 2020/2/12 21:10
     */
    @Configuration
    public static class SecurityAdminConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }
    }

}
