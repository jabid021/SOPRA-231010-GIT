package quest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import quest.dao.IDAOUtilisateur;
import quest.service.JpaUserDetailsService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Bean
	public UserDetailsService jpaUserDetailsService(IDAOUtilisateur daoUtilisateur, PasswordEncoder passwordEncoder) {
		return new JpaUserDetailsService(daoUtilisateur, passwordEncoder);
	}

//	@Bean
//	public UserDetailsService inMemmory() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	
//		UserBuilder userBuilder = User.withUsername("client");
//		userBuilder.password("{noop}123456");
//		userBuilder.roles("CLIENT");
//		
//		UserDetails userDetail = userBuilder.build();
//		
//		manager.createUser(userDetail);
//			
//		manager.createUser(User.withUsername("admin")
//			.password("{noop}123456")
//			.roles("ADMIN", "CLIENT").build());
//		
//	
//		return manager;
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());

		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/**").permitAll();
//			auth.requestMatchers("/api/filiere/**").hasRole("ADMIN");
//			auth.requestMatchers("/**").authenticated();
		});

		// Désactiver la protection CSRF
		http.csrf(c -> c.disable());

		// Configurer les CORS (Cross-Origine Resources Sharing)
		http.cors(c -> {
			CorsConfigurationSource source = request -> {
				CorsConfiguration config = new CorsConfiguration();

				// On autorise tout le monde
				config.setAllowedOrigins(List.of("*"));

				// On autorise toutes les commandes HTTP (GET, POST, PUT, ...)
				config.setAllowedMethods(List.of("*"));

				// On autorise toutes les en-têtes HTTP
				config.setAllowedHeaders(List.of("*"));

				return config;
			};

			c.configurationSource(source);
		});

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Pas d'encadage sur les mots de passe - PAS BIEN
//		return NoOpPasswordEncoder.getInstance();

//		System.out.println(new BCryptPasswordEncoder().encode("123456"));

		// Encodage Blowfish
		return new BCryptPasswordEncoder();
	}
}
