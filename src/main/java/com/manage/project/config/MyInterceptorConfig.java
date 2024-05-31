package com.manage.project.config;

import com.manage.project.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MyInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;
    private List<String> ALLOW_PATH = Stream.of("/","/loginPage","/js/**","/css/**","/font/**",
            "/registerPage","/accountRegister","/loginByAccount","/registerByAccount").collect(Collectors.toList());

    /**
     * 配置拦截器
     * @param registry
     * addInterceptors：
     * addPathPatterns 配置哪些请求进入该拦截器
     * excludePathPattern 配置那些请求不进入拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
                .excludePathPatterns(ALLOW_PATH);
    }

    /**
     * 静态资源的映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/css/**").addResourceLocations("classPath:/static/css/");
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/static/imgs/");
    }
}
