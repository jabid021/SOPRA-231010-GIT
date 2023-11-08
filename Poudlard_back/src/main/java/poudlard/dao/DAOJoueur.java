package poudlard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Eleve;
import poudlard.model.Equipe;
import poudlard.model.Joueur;
import poudlard.model.Poste;

public class DAOJoueur implements IDAO<Joueur,Integer>{

	@Override
	public Joueur findById(Integer id) {
		DAOEquipe daoEquipe  = new DAOEquipe();
		DAOSorcier daoSorcier = new DAOSorcier();
		
		Joueur joueur=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from joueur where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			// id capitaine admission poste eleve equipe
			while(rs.next())
			{
				Eleve eleve = (Eleve) daoSorcier.findById(rs.getInt("eleve"));
				Equipe equipe = daoEquipe.findById(rs.getInt("equipe"));
				Poste poste = Poste.valueOf(rs.getString("Poste"));
				LocalDate date = rs.getDate("admission").toLocalDate();

				joueur = new Joueur(rs.getInt("id"), rs.getBoolean("capitaine"), date, eleve, equipe, poste);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return joueur;
	}

	@Override
	public List<Joueur> findAll() {
		DAOEquipe daoEquipe  = new DAOEquipe();
		DAOSorcier daoSorcier = new DAOSorcier();
		List<Joueur> joueurs = new ArrayList();
		Joueur joueur=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from joueur");
			ResultSet rs = ps.executeQuery();

			// id capitaine admission poste eleve equipe
			while(rs.next())
			{
				Eleve eleve = (Eleve) daoSorcier.findById(rs.getInt("eleve"));
				Equipe equipe = daoEquipe.findById(rs.getInt("equipe"));
				Poste poste = Poste.valueOf(rs.getString("Poste"));
				LocalDate date = rs.getDate("admission").toLocalDate();

				joueur = new Joueur(rs.getInt("id"), rs.getBoolean("capitaine"), date, eleve, equipe, poste);

				joueurs.add(joueur);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return joueurs;
	}

	@Override
	public Joueur insert(Joueur joueur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO joueur (capitaine,admission,poste,eleve,equipe) VALUES (?,?,?,?,?)");



			ps.setBoolean(1, joueur.isCapitaine());
			ps.setString(2, joueur.getAdmission().toString());
			ps.setString(3, joueur.getPoste().toString());
			ps.setInt(4, joueur.getEleve().getId());
			ps.setInt(5, joueur.getEquipe().getId());


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
	public Joueur update(Joueur joueur) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE joueur set capitaine=?,admission=?,poste=?,eleve=?,equipe=? where id =?");



			ps.setBoolean(1, joueur.isCapitaine());
			ps.setString(2, joueur.getAdmission().toString());
			ps.setString(3, joueur.getPoste().toString());
			ps.setInt(4, joueur.getEleve().getId());
			ps.setInt(5, joueur.getEquipe().getId());
			ps.setInt(6, joueur.getId());



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
			PreparedStatement ps = conn.prepareStatement("DELETE from joueur where id = ?");

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

	
	

	
	
}
