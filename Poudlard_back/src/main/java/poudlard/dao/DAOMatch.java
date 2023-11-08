package poudlard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import poudlard.model.Equipe;
import poudlard.model.Match;

public class DAOMatch implements IDAO<Match,Integer>{

	@Override
	public Match findById(Integer id) {
		DAOEquipe daoEquipe  = new DAOEquipe();
		Match match=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from rencontre where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Equipe equipeDomicile=daoEquipe.findById(rs.getInt("equipe_dom"));
				Equipe equipeExterieur=daoEquipe.findById(rs.getInt("equipe_ext"));
				match = new Match(rs.getInt("id"),rs.getInt("score_dom"),rs.getInt("score_ext"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("horaire")),equipeExterieur,equipeDomicile);

			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return match;
	}

	@Override
	public List<Match> findAll() {
		DAOEquipe daoEquipe  = new DAOEquipe();
		List<Match> matchs = new ArrayList();
		Match match=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from rencontre");
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Equipe equipeDomicile=daoEquipe.findById(rs.getInt("equipe_dom"));
				Equipe equipeExterieur=daoEquipe.findById(rs.getInt("equipe_ext"));
				match = new Match(rs.getInt("id"),rs.getInt("score_dom"),rs.getInt("score_ext"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("horaire")),equipeExterieur,equipeDomicile);

				matchs.add(match);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return matchs;
	}

	@Override
	public Match insert(Match match) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO rencontre (score_dom, score_ext,jour,horaire,equipe_dom,equipe_ext) VALUES (?,?,?,?,?,?)");

			if(match.getScoreDom()==null) {
				ps.setObject(1,null);
			}else {
				ps.setInt(1, match.getScoreDom());
			}
			if(match.getScoreExt()==null) {
				ps.setObject(2,null);
			}else {
				ps.setInt(2, match.getScoreExt());
			}

			ps.setString(3, match.getRencontre().toString());
			ps.setString(4, match.getHoraire().toString());
			ps.setInt(5, match.getDomicile().getId());
			ps.setInt(6, match.getExterieur().getId());

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
	public Match update(Match match) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE rencontre set score_dom= ?, score_ext=?,jour=?,horaire=?,equipe_dom=?,equipe_ext=? WHERE id=?");


			if(match.getScoreDom()==null) {
				ps.setObject(1,null);
			}else {
				ps.setInt(1, match.getScoreDom());
			}
			if(match.getScoreExt()==null) {
				ps.setObject(2,null);
			}else {
				ps.setInt(2, match.getScoreExt());
			}
			ps.setString(3, match.getRencontre().toString());
			ps.setString(4, match.getHoraire().toString());
			ps.setInt(5, match.getDomicile().getId());
			ps.setInt(6, match.getExterieur().getId());
			ps.setInt(7, match.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM rencontre WHERE id=?");


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
