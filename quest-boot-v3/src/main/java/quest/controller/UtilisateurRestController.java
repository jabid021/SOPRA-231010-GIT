package quest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import quest.controller.dto.ConnexionRequest;
import quest.controller.dto.InscriptionRequest;
import quest.dao.IDAOStagiaire;
import quest.dao.IDAOUtilisateur;
import quest.model.Roles;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

@RestController
@RequestMapping("/api")
public class UtilisateurRestController {

	private IDAOUtilisateur daoUtilisateur;

	private IDAOStagiaire daoStagiaire;

	public UtilisateurRestController(IDAOUtilisateur daoUtilisateur, IDAOStagiaire daoStagiaire) {
		super();
		this.daoUtilisateur = daoUtilisateur;
		this.daoStagiaire = daoStagiaire;
	}

	@PostMapping("/connexion")
	public Utilisateur connexion(@RequestBody ConnexionRequest connexionRequest) {
		Optional<Utilisateur> opt = daoUtilisateur.findByUsernameAndPassword(connexionRequest.getLogin(),
				connexionRequest.getPassword());

		if (opt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return opt.get();
	}

	@GetMapping("/utilisateur")
	public List<Utilisateur> findAll() {
		return daoUtilisateur.findAll();
	}

	@GetMapping("/utilisateur/{id}")
	public Utilisateur findById(@PathVariable Integer id) {
		return daoUtilisateur.findById(id).get();
	}

	@PostMapping("/utilisateur")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = daoUtilisateur.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/utilisateur/{id}")
	public Utilisateur create(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
		if (id != utilisateur.getId() || !daoUtilisateur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		utilisateur = daoUtilisateur.save(utilisateur);

		return utilisateur;
	}

	@DeleteMapping("/utilisateur/{id}")
	public void delete(@PathVariable Integer id) {
		daoUtilisateur.deleteById(id);
	}

	@PostMapping("/utilisateur/inscription")
	public Utilisateur inscription(@RequestBody @Valid InscriptionRequest inscriptionRequest, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Utilisateur utilisateur = new Utilisateur();

		BeanUtils.copyProperties(inscriptionRequest, utilisateur);

		utilisateur.getRoles().add(Roles.USER);

		utilisateur = daoUtilisateur.save(utilisateur);

		Stagiaire stagiaire = new Stagiaire();

		BeanUtils.copyProperties(inscriptionRequest, stagiaire);
		
		stagiaire = daoStagiaire.save(stagiaire);

		return utilisateur;
	}
}
