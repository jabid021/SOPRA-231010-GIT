package demoSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import demoSpring.component.JAPA;

@Configuration
@ComponentScan("demoSpring.component")
public class AppConfig {

	//Par defaut, Spring va creer un bean de type JAPA sous le nom "config" (nom de la methode)
	//Avec @Bean(name="x"), on peut changer le nom de cet objet => ctx.getBean("x")
	@Bean(name="nouveauNomDuBean")
	public JAPA config() 
	{
		JAPA j = new JAPA();
		j.setUrl("localhost://3306");
		j.setLogin("root");
		j.setPassword("");
		return j;
	}
}
