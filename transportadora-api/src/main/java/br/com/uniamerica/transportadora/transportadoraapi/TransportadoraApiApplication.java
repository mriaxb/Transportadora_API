package br.com.uniamerica.transportadora.transportadoraapi;

import br.com.uniamerica.transportadora.transportadoraapi.configure.WebConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TransportadoraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportadoraApiApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer(){
//		return new WebConfigurer(){
//			@Override
//			public void addCorsMappings(CorsRegistry registry){
//				registry.addMapping("/**").allowedOrigins("*");
//			}
//		};
//	}

}
