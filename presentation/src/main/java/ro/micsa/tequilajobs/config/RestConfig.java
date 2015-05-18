package ro.micsa.tequilajobs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "ro.micsa.tequilajobs")
@EnableWebMvc
public class RestConfig {

}