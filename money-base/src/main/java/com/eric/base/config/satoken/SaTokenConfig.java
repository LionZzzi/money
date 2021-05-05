package com.eric.base.config.satoken;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Eric
 * @date 2021/5/2 22:30
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册登录拦截器，并排除登录接口地址
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
