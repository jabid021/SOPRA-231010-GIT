package poudlard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Equipe;
import poudlard.model.Maison;

public class DAOEquipe implements IDAO<Equipe,Integer>{

	@Override
	public Equipe findById(Integer id) {
		DAOMaison daoMaison = new DAOMaison();
		Equipe equipe=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from equipe where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Maison maison = daoMaison.findById(rs.getInt("maison"));
				equipe= new Equipe(rs.getInt("id"),rs.getString("libelle"),maison);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return equipe;
	}

	@Override
	public List<Equipe> findAll() {
		DAOMaison daoMaison = new DAOMaison();
		List<Equipe> equipes = new ArrayList();
		Equipe equipe=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from equipe");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Maison maison = daoMaison.findById(rs.getInt("maison"));
				equipe= new Equipe(rs.getInt("id"),rs.getString("libelle"),maison);

				equipes.add(equipe);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return equipes;
	}

	@Override
	public Equipe insert(Equipe equipe) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO equipe(libelle,maison)VALUES (?,?)");
			ps.setString(1, equipe.getLibelle());
			ps.setInt(2,equipe.getMaison().getId());
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
	public Equipe update(Equipe equipe) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE equipe SET libelle=?, maison=? Where id=?");
			ps.setString(1, equipe.getLibelle());
			ps.setInt(2,equipe.getMaison().getId());
			ps.setInt(3,equipe.getId());

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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM equipe Where id=?");

			ps.setInt(1,id);

			ps.executeUpdate();

			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	
	

	
	
}
