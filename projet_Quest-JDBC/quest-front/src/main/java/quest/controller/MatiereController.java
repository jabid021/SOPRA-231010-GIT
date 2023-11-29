package quest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	private IDAOMatiere daoMatiere = Singleton.getInstance().getDaoMatiere();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll	
		if(request.getParameter("id")==null) 
		{
			List<Matiere> matieres = daoMatiere.findAll();
			request.setAttribute("matieres", matieres);

			request.getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));

				Matiere matiere = daoMatiere.findById(id);
				request.setAttribute("matiere", matiere);

				request.getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoMatiere.deleteById(id);
				response.sendRedirect("matiere");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			Matiere matiere = new Matiere(libelle,quest);

			daoMatiere.save(matiere);
			response.sendRedirect("matiere");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			Matiere matiere = new Matiere(id,libelle,quest);


			daoMatiere.save(matiere);
			response.sendRedirect("matiere");
		}
	}

}
