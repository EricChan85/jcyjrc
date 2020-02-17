package org.yjrc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@Configuration
@Import(AppConfig.class)
@ImportResource({"classpath:spring-config.xml"})
public class RootConfig {

}
