package poudlard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Maison;
import poudlard.model.Professeur;

public class DAOMaison implements IDAO<Maison,Integer>{

	@Override
	public Maison findById(Integer id) {
		DAOSorcier daoSorcier = new DAOSorcier();
		Maison maison = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from maison where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Professeur prof = (Professeur) daoSorcier.findById(rs.getInt("professeur"));
				maison = new Maison(rs.getInt("id"), rs.getString("nom"), rs.getInt("points"), prof);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return maison;
	}

	@Override
	public List<Maison> findAll() {
		DAOSorcier daoSorcier = new DAOSorcier();
		List<Maison> maisons = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from maison");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Professeur prof = (Professeur) daoSorcier.findById(rs.getInt("professeur"));
				Maison maison = new Maison(rs.getInt("id"), rs.getString("nom"), rs.getInt("points"), prof);
				maisons.add(maison);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return maisons;
	}

	@Override
	public Maison insert(Maison maison) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO maison (nom, points, professeur) VALUES (?,?,?)");
			ps.setString(1, maison.getNom());
			ps.setInt(2, maison.getPoints());
			ps.setInt(3, maison.getProfesseur().getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	@Override
	public Maison update(Maison maison) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE maison SET nom=?, points=?, professeur=? WHERE id=?");
			ps.setString(1, maison.getNom());
			ps.setInt(2, maison.getPoints());
			ps.setInt(3, maison.getProfesseur().getId());
			ps.setInt(4, maison.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		return null;
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM maison WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
	}

	
	

	
	
}
