package com.springboot.tongyuyan.selfhelp.config.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Autowired MyInterceptor myInterceptor;

    @Override
    public void   addInterceptors(InterceptorRegistry registry ){
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/appLogin/**","/wxpay/**","/wxlogin").excludePathPatterns("/wxpay/**");
    }
}
