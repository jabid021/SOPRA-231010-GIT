package hopital.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOVisiteJDBC implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		Visite visite = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where numero=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		IDAOPatient daoPatient = Singleton.getInstance().getDaoPatient();
		Visite visite = null;
		List<Visite> visites = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite ");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient patient = daoPatient.findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));
				visites.add(visite);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public Visite insert(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			//Si on veut obtenir l'id incremente par la bdd, on ajoute après notre requete le parametre suivant : Statement.RETURN_GENERATED_KEYS
			PreparedStatement ps = conn.prepareStatement("INSERT into visite (id_patient,id_medecin,prix,date_visite,salle) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setString(4, visite.getDateVisite().toString());
			ps.setInt(5,visite.getSalle());
			ps.executeUpdate();

			//Grace au Statement.RETURN_GENERATED_KEYS, il est maintenant possible de recup via un ResultSet l'id
			ResultSet rs = ps.getGeneratedKeys();
			
			while(rs.next()) 
			{
				int numero = rs.getInt(1);
				visite.setNumero(numero);
			}
			
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Visite update(Visite visite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE visite set id_patient=?,id_medecin=?,prix=?,date_visite=?,salle=? where numero=?");
			ps.setInt(1,visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setString(4, visite.getDateVisite().toString());
			ps.setInt(5,visite.getSalle());
			ps.setInt(6, visite.getNumero());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE from visite where numero=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public List<Visite> findAllByPatient(Patient patient) {
		IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		Visite visite = null;
		List<Visite> visites = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=?");
			ps.setInt(1,patient.getId());
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Medecin medecin = (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));
				visites.add(visite);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}
}
