package entreprise.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class TestJDBC {
	
	public static String saisieString(String message) 
	{
		Scanner sc  = new Scanner(System.in);
		System.out.println(message);
		return  sc.nextLine();
	}

	//JDBC => Java Data Base Connector 
	
	
	//Sur Windows / Linux => port 3306 et pas de password
	//Sur Mac => port 8889 et password = "root"
	static String urlBdd = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8";
	static String loginBdd = "root";
	static String passwordBdd = "";
	

	public static void demoSelect() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("SELECT * from dept");
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"), rs.getString("dname"),rs.getString("loc"));
				System.out.println(d);
			}
			
			rs.close();
			st.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void demoInsert(Departement d) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO dept (deptno,dname,loc) VALUES ("+d.getDeptno()+",'"+d.getDname()+"','"+d.getLoc()+"')");
			st.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void demoInsertEmploye(Employe e) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			Statement st = conn.createStatement();
			Integer mgr = (e.getManager()==null)?null : e.getManager().getEmpno();
			
			Integer dept;
			if(e.getDepartement()==null) 
			{
				dept=null;
			}
			else 
			{
				dept=e.getDepartement().getDeptno();
			}
			st.executeUpdate("INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES ("+e.getEmpno()+",'"+e.getEname()+"','"+e.getJob()+"',"+mgr+",'"+e.getHiredate()+"',"+e.getSal()+","+e.getComm()+","+dept+")");
			st.close();
			conn.close();
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	
	public static void demoConnectEnameAndJob(String nom,String job) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("SELECT * from emp where ename='"+nom+"' and job='"+job+"' ");
			System.out.println("SELECT * from emp where ename='"+nom+"' and job='"+job+"' ");
			Employe emp=null;
			while(rs.next()) 
			{	
				emp = new Employe(rs.getInt("empno"),rs.getString("ename"),rs.getString("job"),null,LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null);	
			}
			System.out.println(emp);
			rs.close();
			st.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// -----------------------DEMO REQUETES SECURE ! -------------------------------------------
	
	
	
	
	
	public static void demoSelectSECURE() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from dept");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"), rs.getString("dname"),rs.getString("loc"));
				System.out.println(d);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void demoInsertSECURE(Departement d) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept (deptno,dname,loc) VALUES (?,?,?)");
			ps.setInt(1,d.getDeptno());
			ps.setString(2, d.getDname());
			ps.setString(3, d.getLoc());
			
			ps.executeUpdate();
			
			
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void demoInsertEmployeSECURE(Employe emp) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			
			if(emp.getManager()==null) 
			{
				ps.setObject(4, null);
			}
			else 
			{
				ps.setInt(4, emp.getManager().getEmpno());
			}
			
			ps.setString(5, emp.getHiredate().toString());
			
			ps.setInt(6, emp.getSal());
			
			
			if(emp.getComm()==null) 
			{
				ps.setObject(7, null);
			}
			else 
			{
				ps.setInt(7, emp.getComm());
			}
			
			if(emp.getDepartement()==null) 
			{
				ps.setObject(8, null);
			}
			else 
			{
				ps.setInt(8, emp.getDepartement().getDeptno());
			}
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	
	
	public static void demoConnectEnameAndJobSECURE(String nom,String job) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from emp where ename=? and job=? ");
			ps.setString(1, nom);
			ps.setString(2, job);
			
			ResultSet rs =  ps.executeQuery();
			Employe emp=null;
			while(rs.next()) 
			{
				emp = new Employe(rs.getInt("empno"),rs.getString("ename"),rs.getString("job"),null,LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null);
			}
			System.out.println(emp);
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	
		//Departement d = new Departement(60,"Formation","Paris");
		//demoInsert(d);
		//Employe king = new Employe(7839, "King", "President", null, LocalDate.parse("2016-05-01"), 5000, null, null);
		//Employe e = new Employe(7779, "Abid", "Formateur",null, LocalDate.now(), 2000, 500, null);
		
		//System.out.println(e);
		//demoInsertEmployeSECURE(e);
		//demoSelect();
		
		String nom = saisieString("Saisir votre nom");
		String job = saisieString("Saisir votre job");
		
		demoConnectEnameAndJobSECURE(nom,job);
		
		
		
		
		//findByIdEmploye
		//findAllEmploye
		//updateEmploye
		//InsertEmploye
		//deleteEmploye
		
	
		
		
		
	}

}
