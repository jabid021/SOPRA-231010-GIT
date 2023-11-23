package hopital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.dao.jdbc.DAOCompteJDBC;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	private DAOCompteJDBC daoCompte = new DAOCompteJDBC();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("disconnect")==null) 
		{
			if(request.getSession().getAttribute("connected")==null) 
			{
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}
			else 
			{
				if(request.getSession().getAttribute("connected") instanceof Medecin) 
				{
					request.getRequestDispatcher("/menuMedecin.jsp").forward(request, response);
				}
				else if(request.getSession().getAttribute("connected") instanceof Secretaire) 
				{
					request.getRequestDispatcher("/menuSecretaire.jsp").forward(request, response);
				}
			}
			
		}
		
		else 
		{
			request.getSession().invalidate();
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte compte = daoCompte.findByLoginAndPassword(login, password);
	
		
		if(compte instanceof Medecin) 
		{
			request.getSession().setAttribute("connected", compte);
			request.getRequestDispatcher("/menuMedecin.jsp").forward(request, response);
		}
		else if(compte instanceof Secretaire) 
		{
			request.getSession().setAttribute("connected", compte);
			request.getRequestDispatcher("/menuSecretaire.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		
		
		
	}

}
