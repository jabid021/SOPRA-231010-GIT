package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	@Autowired
	private IDAOStagiaire daoStagiaire;
	@Autowired
	private IDAOFiliere daoFiliere;
	
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll	
		if(request.getParameter("id")==null) 
		{
			List<Stagiaire> stagiaires = daoStagiaire.findAll();
			List<Filiere> filieres = daoFiliere.findAll();
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			
			request.getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Stagiaire stagiaire = daoStagiaire.findById(id).get();
				List<Filiere> filieres = daoFiliere.findAll();
				
				request.setAttribute("stagiaire", stagiaire);
				request.setAttribute("filieres", filieres);

				request.getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoStagiaire.deleteById(id);
				response.sendRedirect("stagiaire");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("id")==null) 
		{
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			
			Stagiaire stagiaire = new Stagiaire(nom, prenom, email, filiere);
			
			daoStagiaire.save(stagiaire);
			response.sendRedirect("stagiaire");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			
			Stagiaire stagiaire = new Stagiaire(id,nom, prenom, email, filiere);
			stagiaire.setVersion(version);
			
			daoStagiaire.save(stagiaire);
			response.sendRedirect("stagiaire");
		}
	}

}
