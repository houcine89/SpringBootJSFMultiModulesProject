package com.houcine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Configuration
    public class DefaultView extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers( ViewControllerRegistry registry ) {
            registry.addViewController( "/" ).setViewName( "forward:/index.jsf" );
            registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
            super.addViewControllers( registry );
        }
    }

}
