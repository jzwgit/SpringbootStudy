package com.jzw.ch03_mvc.conf;

import com.jzw.ch03_mvc.interceptor.SessionHandlerInterceptor;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfigurer implements WebMvcConfigurer {
    //拦截器
    public void addInterceptors(InterceptorRegistry registry){
        //增加一个拦截器，检查会话，URL以admin开头的都使用这个拦截器
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }

    //跨域访问配置
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
        .allowedMethods("")
        .allowedOrigins("")
        .allowCredentials(true)
        .allowedHeaders();
    }

    //格式化
    public void addFormatters(FormatterRegistry registry){
        //添加格式化日期类
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    //URI到视图的映射
    public void addViewControllers(ViewControllerRegistry registry){
        //对访问index.html的请求，设置返回的视图为index.btl
        registry.addViewController("/index.html").setViewName("/index.btl");
        /*
         * 以上代码等同于
         * @RequestMapping("/)
         * public String index(){
         *  retrun "/index.btl";
         * }
         */

        //所有以.do 结尾的请求重定向到/index.html请求
        registry.addRedirectViewController("/**/*.do","/index.html");
    }

    //更多全局定制接口
    // ... ...
}
