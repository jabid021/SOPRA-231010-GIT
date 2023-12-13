package quest.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import quest.dao.IDAOUtilisateur;
import quest.model.Roles;
import quest.model.Utilisateur;

//@Service
public class JpaUserDetailsService implements UserDetailsService {

//	@Autowired
	private IDAOUtilisateur daoUtilisateur;

//	@Autowired
	private PasswordEncoder passwordEncoder;

	public JpaUserDetailsService(IDAOUtilisateur daoUtilisateur, PasswordEncoder passwordEncoder) {
		super();
		this.daoUtilisateur = daoUtilisateur;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Utilisateur> optUtilisateur = daoUtilisateur.findByUsername(username);
//			
//		if(optUtilisateur.isEmpty()) {
//			throw new UsernameNotFoundException("L'utilisateur n'existe pas.");
//		}
//		
//		Utilisateur utilisateur = optUtilisateur.get();

		Utilisateur utilisateur = this.daoUtilisateur.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas."));

		UserBuilder userBuilder = User.withUsername(username)
				.password(passwordEncoder.encode(utilisateur.getPassword())).disabled(utilisateur.isDisabled());

		List<String> roles = utilisateur.getRoles().stream().map(Roles::name).toList();

		userBuilder.roles(roles.toArray(new String[0]));

		return userBuilder.build();
	}

}
