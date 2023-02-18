package br.com.uniamerica.transportadora.transportadoraapi.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfigurer extends WebMvcConfigurerAdapter {

    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**").allowedMethods("*");
    }

}
