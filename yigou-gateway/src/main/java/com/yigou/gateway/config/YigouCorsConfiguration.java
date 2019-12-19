package com.yigou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author Xiaowu77
 * @version 1.0
 * @date 2019/11/28 15:24
 */
@Configuration
public class YigouCorsConfiguration {
    @Bean
    public CorsFilter corsFilter(){

        //初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();

        //允许跨域的域名，如果要携带cookie，不能写*。*代表允许所有域名访问http://www.manage.com
        configuration.addAllowedOrigin("http://manage.yigou.com");
        configuration.addAllowedOrigin("http://www.yigou.com");
        configuration.addAllowedOrigin("http://api.yigou.com");
        configuration.setAllowCredentials(true);//允许携带cookie
        configuration.addAllowedMethod("*");//所有请求方法 get post put delect...
        configuration.addAllowedHeader("*");//允许携带任何头信息

        //初始化cors配置源
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**",configuration);

        //返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(configurationSource);
    }
}
