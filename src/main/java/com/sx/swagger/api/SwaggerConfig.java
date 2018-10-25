package com.sx.swagger.api;

import com.fasterxml.classmate.TypeResolver;
import com.sx.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * @Author: maxiucheng
 * @Description:
 * @CreateTime: 2018/10/24 23:32
 * @Version:
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TypeResolver typeResolver;

    //展示所有的api
    @Bean
    public Docket createUserInfo() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sx"))
                .paths(PathSelectors.any()).build().alternateTypeRules( //自定义规则 将泛型转换成JSON
                        newRule(typeResolver.resolve(BaseResponse.class),
                                typeResolver.resolve(WildcardType.class)));
        return docket;
    }

    //模块分组
    @Bean
    public Docket userApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("公共模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sx.controller"))//根据包名来区分
                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//根据接口地址来区分
//                .paths(PathSelectors.regex("/normal.*"))
                .build();
    }

    //模块分组
    @Bean
    public Docket customApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试模块")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sx.swagger"))
                .paths(PathSelectors.any())
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//根据接口地址来区分
//                .paths(PathSelectors.regex("/demo.*"))
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
