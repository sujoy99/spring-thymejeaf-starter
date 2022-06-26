package com.starter.demo.config;

import com.starter.demo.interceptor.GeneralInterceptor;
import com.starter.demo.interceptor.StudentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private GeneralInterceptor generalInterceptor;

    @Autowired
    private StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalInterceptor).excludePathPatterns("/student/**");
        registry.addInterceptor(studentInterceptor).order(1).addPathPatterns("/student/**").excludePathPatterns("/student/count");
    }
}
