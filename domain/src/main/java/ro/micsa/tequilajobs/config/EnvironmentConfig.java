package ro.micsa.tequilajobs.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;

@Configuration
public class EnvironmentConfig implements EnvironmentAware{

    @Resource
    private Environment environment;

    @Bean
    public PropertyPlaceholderConfigurer getCommonPropertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(
                new ClassPathResource("/env/common.properties"),
                new ClassPathResource("/env/" + getActiveProfile() + ".properties"));
        return propertyPlaceholderConfigurer;
    }

    private String getActiveProfile() {
        String[] activeProfiles = environment.getActiveProfiles();
        return profilesDefined(activeProfiles) ? activeProfiles[0] : "test";
    }

    private boolean profilesDefined(String[] profiles) {
        return profiles != null && profiles.length > 0;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
