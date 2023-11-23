package demoHopitalWeb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

@WebServlet("/demo")
public class Demo extends HttpServlet {

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		List<Patient> patients = Singleton.getInstance().getDaoPatient().findAll();
		
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Page demo</h1>");
		response.getWriter().println("<table border>");
		response.getWriter().println("<tr><th>Id</th><th>Nom</th><th>Prenom</th></tr>");
		for(Patient p : patients) 
		{
			response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
		}
		
		response.getWriter().println("</table>");
		response.getWriter().println("<form action='demo' method='post'>");
		response.getWriter().println("<input type='number' name='id' placeholder='Saisir id'>");
		response.getWriter().println("<input type='text' name='nom' placeholder='Saisir nom'>");
		response.getWriter().println("<input type='text' name='prenom' placeholder='Saisir prenom'>");
		response.getWriter().println("<input type='submit' value='GO'>");
		response.getWriter().println("</form>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>"); 	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id= Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Patient p = new Patient(id,nom,prenom);
		Singleton.getInstance().getDaoPatient().insert(p);
		
		request.getRequestDispatcher("/patients.jsp").forward(request, response);
		//response.sendRedirect("demo");
	}

}
