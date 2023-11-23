package hopital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.dao.jdbc.DAOPatientJDBC;
import hopital.model.Patient;

//annotations
@WebServlet("/patient")
public class PatientController extends HttpServlet {
	
	private DAOPatientJDBC daoPatient = new DAOPatientJDBC();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//findAll	
		if(request.getParameter("id")==null) 
		{
			List<Patient> patientsBdd = daoPatient.findAll();
			request.setAttribute("patients", patientsBdd);
			
			request.getRequestDispatcher("/patients.jsp").forward(request, response);
		}
		else 
		{
			//findById pour aller vers la page de modif
			if(request.getParameter("delete")==null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				
				Patient patientBdd = daoPatient.findById(id);
				
				request.setAttribute("patient", patientBdd);
			
				request.getRequestDispatcher("/updatePatient.jsp").forward(request, response);
			}
			//delete
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				daoPatient.delete(id);
				response.sendRedirect("patient");
			}
		}
			
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//insert
		if(request.getParameter("insert")!=null) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			
			Patient patient = new Patient(id,nom,prenom);
			daoPatient.insert(patient);
			response.sendRedirect("patient");
		}
		//update
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			
			Patient patient = new Patient(id,nom,prenom);
			daoPatient.update(patient);
			response.sendRedirect("patient");
		}
	
		
			
	}

	
}
