package cn.edu.whut.springbear.course.common.util.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Spring-_-Bear
 * @datetime 2022-10-19 09:31
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("course")
                .apiInfo(webApiInfo())
                .select()
                // 只显示 api 路径下的页面
                // .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("在线课堂 - API 文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("Spring-_-Bear", "https://springbear2020.cn", "springbear2020@163.com"))
                .build();
    }
}
