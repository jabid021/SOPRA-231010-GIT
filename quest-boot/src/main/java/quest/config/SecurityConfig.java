package quest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Bean
	public UserDetailsService inMemmory() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	
		UserBuilder userBuilder = User.withUsername("client");
		userBuilder.password("{noop}123456");
		userBuilder.roles("CLIENT");
		
		UserDetails userDetail = userBuilder.build();
		
		manager.createUser(userDetail);
			
		manager.createUser(User.withUsername("admin")
			.password("{noop}123456")
			.roles("ADMIN", "CLIENT").build());
		
	
		return manager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
		
		http.authorizeHttpRequests(auth -> {
			auth.mvcMatchers("/api/filiere/**").hasRole("ADMIN");
			auth.mvcMatchers("/**").authenticated();
		});
		
		// Désactiver la protection CSRF
		http.csrf(c -> c.disable());
		
		return http.build();
	}
}
