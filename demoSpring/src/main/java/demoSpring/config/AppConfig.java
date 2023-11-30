package demoSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demoSpring.dao.JAPA;

@Configuration
@ComponentScan("demoSpring.dao")

public class AppConfig {

	
	@Bean(name = "demo")
	public JAPA config() 
	{
		JAPA j = new JAPA();
		j.setUrl("localhost://3306");
		j.setLogin("root");
		j.setPassword("");
		return j;
	}

}
