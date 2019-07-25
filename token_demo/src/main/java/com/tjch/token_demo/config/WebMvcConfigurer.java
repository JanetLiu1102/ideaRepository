package com.tjch.token_demo.config;

import com.tjch.token_demo.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



@Configuration  //适配器
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

	@Bean
    public UserInterceptor getUserInterceptor() {
        return new UserInterceptor();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(getUserInterceptor()).excludePathPatterns()
		.addPathPatterns("/**")                    //拦截所有请求            
        .excludePathPatterns("/user/login");    //对应的不拦截的请求

		super.addInterceptors(registry);
	}
}
