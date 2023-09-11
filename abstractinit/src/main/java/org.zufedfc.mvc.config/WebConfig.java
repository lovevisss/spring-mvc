package org.zufedfc.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.zufedfc.mvc.intercepter.MyIntercepter;

@Configuration
@ComponentScan(basePackages = {"org.zufedfc.mvc.controller"})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
//    1.扫描controller

//    2.视图解析器
    @Bean
    public ITemplateResolver templateResolver(){
        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(applicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setOrder(1);
        return viewResolver;
    }

//    3.默认静态资源处理器

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
    }

//    4.拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

//    5.view controller

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/usingcontroller").setViewName("hello");
        WebMvcConfigurer.super.addViewControllers(registry);
    }

//    6.文件上传
//    7.异常处理
}
