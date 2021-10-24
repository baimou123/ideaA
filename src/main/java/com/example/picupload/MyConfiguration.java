package com.example.picupload;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MyConfiguration implements WebMvcConfigurer {
    /**
     * 虚拟路径配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/Document/**").addResourceLocations("file:/D:/test/");
        registry.addResourceHandler("/imgfile/**").addResourceLocations("file:/D:\\xunipic");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
