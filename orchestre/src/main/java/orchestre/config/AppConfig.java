package orchestre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

@Configuration
@ComponentScan({"orchestre.model","orchestre.aspect"})
@EnableAspectJAutoProxy

//@ImportResource("classpath:application-context.xml")
public class AppConfig {

	@Bean
	public IMusicien guitariste()
	{
		Guitariste g = new Guitariste();
		g.setPrenom("Jordaninou");
		return g;
	}
	
	@Bean
	public IMusicien pianiste()
	{
		Pianiste p = new Pianiste();
		p.setPrenom("Erico");
		return p;
	}
	
	@Bean
	public IMusicien musicien()
	{
		Flutiste f = new Flutiste();
		f.setPrenom("Olivier");
		return f;
	}
	

}
