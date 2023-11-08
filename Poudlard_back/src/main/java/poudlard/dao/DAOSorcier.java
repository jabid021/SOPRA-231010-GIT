package poudlard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Animal;
import poudlard.model.Eleve;
import poudlard.model.Maison;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;

public class DAOSorcier implements IDAO<Sorcier,Integer>{
	
	@Override
	public Sorcier findById(Integer id) {
		DAOMaison daoMaison = new DAOMaison();
		
		Sorcier sorcier=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from sorcier where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_sorcier").equals("Eleve")) 
				{
					Animal animal = new Animal(rs.getString("familier_nom"),rs.getString("familier_race"));
					Maison maison = daoMaison.findById(rs.getInt("maison"));
					sorcier = new Eleve(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("promotion"),animal,maison);
				}
				else if (rs.getString("type_sorcier").equals("Professeur")) 
				{
					sorcier = new Professeur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));
				}
			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return sorcier;
	}

	@Override
	public List<Sorcier> findAll() {
		DAOMaison daoMaison = new DAOMaison();
		List<Sorcier> sorciers = new ArrayList();
		Sorcier sorcier=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from sorcier");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_sorcier").equals("Eleve")) 
				{
					Animal animal = new Animal(rs.getString("familier_nom"),rs.getString("familier_race"));
					Maison maison = daoMaison.findById(rs.getInt("maison"));
					sorcier = new Eleve(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("promotion"),animal,maison);
				}
				else if (rs.getString("type_sorcier").equals("Professeur")) 
				{
					sorcier = new Professeur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));
				}
				sorciers.add(sorcier);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return sorciers;
	}

	@Override
	public Sorcier insert(Sorcier sorcier) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO sorcier (login,password,nom,prenom,promotion,familier_nom,familier_race,type_sorcier,maison) VALUES (?,?,?,?,?,?,?,?,?)");

			if(sorcier instanceof Eleve) 
			{
				Eleve eleve = (Eleve) sorcier;
				ps.setString(1, eleve.getLogin());
				ps.setString(2, eleve.getPassword());
				ps.setString(3, eleve.getNom());
				ps.setString(4, eleve.getPrenom());
				ps.setInt(5, eleve.getPromotion());
				ps.setString(6, eleve.getFamilier().getNom());
				ps.setString(7, eleve.getFamilier().getRace());
				ps.setString(8, "Eleve");
				if(eleve.getMaison()==null) 
				{
					ps.setObject(9,null);
				}
				else
				{
					ps.setInt(9, eleve.getMaison().getId());
				}
			}

			else if(sorcier instanceof Professeur) 
			{
				ps.setString(1, sorcier.getLogin());
				ps.setString(2, sorcier.getPassword());
				ps.setString(3, sorcier.getNom());
				ps.setString(4, sorcier.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, "Professeur");
				ps.setObject(9,null);
			}


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
	public Sorcier update(Sorcier sorcier) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE sorcier set login=?,password=?,nom=?,prenom=?,promotion=?,familier_nom=?,familier_race=?,type_sorcier=?,maison=? WHERE id=?");

			if(sorcier instanceof Eleve) 
			{
				Eleve eleve = (Eleve) sorcier;
				ps.setString(1, eleve.getLogin());
				ps.setString(2, eleve.getPassword());
				ps.setString(3, eleve.getNom());
				ps.setString(4, eleve.getPrenom());
				ps.setInt(5, eleve.getPromotion());
				ps.setString(6, eleve.getFamilier().getNom());
				ps.setString(7, eleve.getFamilier().getRace());
				ps.setString(8, "Eleve");
				if(eleve.getMaison()==null) 
				{
					ps.setObject(9,null);
				}
				else
				{
					ps.setInt(9, eleve.getMaison().getId());
				}
				ps.setInt(10, eleve.getId());
			}

			else if(sorcier instanceof Professeur) 
			{
				ps.setString(1, sorcier.getLogin());
				ps.setString(2, sorcier.getPassword());
				ps.setString(3, sorcier.getNom());
				ps.setString(4, sorcier.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, "Professeur");
				ps.setObject(9,null);
				ps.setInt(10, sorcier.getId());
			}


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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM sorcier WHERE id=?");


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

	
	public List<Eleve> findAllEleves() 
	{
		DAOMaison daoMaison = new DAOMaison();
		List<Eleve> sorciers = new ArrayList();
		Eleve sorcier=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from sorcier where type_sorcier='Eleve'");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Animal animal = new Animal(rs.getString("familier_nom"),rs.getString("familier_race"));
				Maison maison = daoMaison.findById(rs.getInt("maison"));
				sorcier = new Eleve(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("promotion"),animal,maison);

				sorciers.add(sorcier);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return sorciers;
	}

	
	public List<Professeur> findAllProfesseurs() 
	{
		List<Professeur> sorciers = new ArrayList();
		Professeur sorcier=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from sorcier where type_sorcier='Professeur'");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				sorcier = new Professeur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));

				sorciers.add(sorcier);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return sorciers;
	}
	

	public Sorcier findByLoginAndPassword(String login,String password) 
	{
		DAOMaison daoMaison = new DAOMaison();
		Sorcier sorcier=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from sorcier where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_sorcier").equals("Eleve")) 
				{
					Animal animal = new Animal(rs.getString("familier_nom"),rs.getString("familier_race"));
					Maison maison = daoMaison.findById(rs.getInt("maison"));
					sorcier = new Eleve(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("promotion"),animal,maison);
				}
				else if (rs.getString("type_sorcier").equals("Professeur")) 
				{
					sorcier = new Professeur(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));
				}

			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return sorcier;
	}
}
