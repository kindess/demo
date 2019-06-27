package com.yunze.demo.config;

import com.yunze.demo.interceptor.LoginIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * springboot注册拦截器
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 登出不拦截、静态资源不拦截
        registry.addInterceptor(loginIntercepter()).addPathPatterns("/*")
                .excludePathPatterns("/druid/**")
//                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/**/*.css","/**/*.js");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public LoginIntercepter loginIntercepter(){
        return new LoginIntercepter();
    }
}