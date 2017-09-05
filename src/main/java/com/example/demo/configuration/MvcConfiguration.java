package com.example.demo.configuration;

import com.example.demo.api.DemoApiService;
import com.googlecode.jsonrpc4j.spring.JsonServiceExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @date 2017/8/31 下午2:33
 * @description 开启jsonRpc的配置类
 */
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter{
    @Autowired
    DemoApiService apiService;

    @Bean("/rpc/demo.json")
    @ConditionalOnMissingBean(JsonServiceExporter.class)
    public JsonServiceExporter jsonServiceExporter() {
        JsonServiceExporter result = new JsonServiceExporter();
        result.setService(apiService);
        result.setServiceInterface( DemoApiService.class );
        return result;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/rpc/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                ;
            }
        };
    }
    /**
     * @date 2017/9/4 上午10:26
     * @description 添加controller的异源访问
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*", "null")
                .allowedMethods("*")
                .maxAge(3600)
                .allowCredentials(true);
    }

}
