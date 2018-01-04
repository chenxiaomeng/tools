package com.cxm.springmvc;
/**
 * Created by xiaomeng.chen on 2016/12/30.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ImportResource({
        "classpath:spring-test/applicationContext-*.xml"
})
public class TestAppConfig extends WebMvcConfigurerAdapter {
}
