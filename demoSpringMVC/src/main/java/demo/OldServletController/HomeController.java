package demo.OldServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Oldhome")
public class HomeController extends HttpServlet {

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		String prenom = request.getParameter("prenom");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(prenom + " - "+ id);
		
		request.setAttribute("exemple",prenom + " - "+ id);
		
		request.getRequestDispatcher("/WEB-INF/demoData.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		String prenom = request.getParameter("prenom");
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(prenom + " - "+ id);
	}

}
