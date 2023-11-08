package hopital.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.dao.IDAOCompte;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;

public class DAOCompteJDBC implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					compte = new Medecin(id,rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(id,rs.getString("login"),rs.getString("password"));
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
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList();
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				comptes.add(compte);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte insert(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,type_compte) VALUES (?,?,?)");
			if(compte instanceof Medecin) 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Medecin");	
			}
			else 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Secretaire");	
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
	public Compte update(Compte compte) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,type_compte=? where id=?");
			if(compte instanceof Medecin) 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Medecin");	
				ps.setInt(4, compte.getId());
			}
			else 
			{
				ps.setString(1, compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3, "Secretaire");	
				ps.setInt(4, compte.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");
		
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

	public Compte findByLoginAndPassword(String login,String password) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
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
		return compte;
	}

}
