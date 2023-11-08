package entreprise.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class TPJDBC {

	static String urlBdd = "jdbc:mysql://localhost:3306/scott?characterEncoding=UTF-8";
	static String loginBdd = "root";
	static String passwordBdd = "";


	public static int saisieInt(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextInt();
	}
	public static String saisieString(String msg) {
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
	}
	
	public static List<Departement> findAllDept()
	{
		List<Departement> departements=new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from dept");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement d = new Departement(rs.getInt("deptno"), rs.getString("dname"),rs.getString("loc"));
				departements.add(d);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return departements;
	}

	
	public static Departement findByIdDepartement(Integer id)
	{
		Departement departement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from dept where deptno=?");
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) 
			{
				departement = new Departement(rs.getInt("deptno"), rs.getString("dname"),rs.getString("loc"));

			}
			
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return departement;
	}
	
	public static List<Employe> findAll() 
	{
		List<Employe> employes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from emp employe LEFT JOIN emp manager on employe.mgr = manager.empno ");

			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				Employe manager = null;
				if(rs.getObject("employe.mgr")!=null) 
				{
					manager = new Employe(rs.getInt("manager.empno"),rs.getString("manager.ename"),rs.getString("manager.job"),null,LocalDate.parse(rs.getString("manager.hiredate")),rs.getInt("manager.sal"),rs.getInt("manager.comm"),null);
				}
				
				Departement departement = findByIdDepartement(rs.getInt("employe.deptno"));
				
				Employe emp = new Employe(rs.getInt("employe.empno"),rs.getString("employe.ename"),rs.getString("employe.job"),manager,LocalDate.parse(rs.getString("employe.hiredate")),rs.getInt("employe.sal"),rs.getInt("employe.comm"),departement);
				employes.add(emp);
			}
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return employes;

	}
	public static Employe findById(Integer id) 
	{
		Employe emp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from emp where empno=? ");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				Employe manager = findById(rs.getInt("mgr"));
				emp = new Employe(rs.getInt("empno"),rs.getString("ename"),rs.getString("job"),manager,LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null);
			}
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	public static void insert(Employe emp) 
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
	public static void update(Employe emp) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?");

			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());

			if(emp.getManager()==null) 
			{
				ps.setObject(3, null);
			}
			else 
			{
				ps.setInt(3, emp.getManager().getEmpno());
			}

			ps.setString(4, emp.getHiredate().toString());

			ps.setInt(5, emp.getSal());


			if(emp.getComm()==null) 
			{
				ps.setObject(6, null);
			}
			else 
			{
				ps.setInt(6, emp.getComm());
			}

			if(emp.getDepartement()==null) 
			{
				ps.setObject(7, null);
			}
			else 
			{
				ps.setInt(7, emp.getDepartement().getDeptno());
			}
			ps.setInt(8, emp.getEmpno());

			ps.executeUpdate();
			ps.close();
			conn.close();
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public static void delete(Integer id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from emp where empno=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static Employe findByEnameAndJob(String ename,String job) 
	{
		//Contrairement aux autres fonctions, utilisez ici un Statement pour laisser apparaitre la faille d'injection SQL
		Employe emp=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("SELECT * from emp where ename='"+ename+"' and job='"+job+"' ");
			while(rs.next()) 
			{	
				emp = new Employe(rs.getInt("empno"),rs.getString("ename"),rs.getString("job"),null,LocalDate.parse(rs.getString("hiredate")),rs.getInt("sal"),rs.getInt("comm"),null);	
			}
			rs.close();
			st.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}



	public static void menuPrincipal() 
	{
		System.out.println("Gestion des employés");
		System.out.println("1- Afficher tous les employés");
		System.out.println("2- Rechercher un employé par ID");
		System.out.println("3- Ajouter un employé");
		System.out.println("4- Modifier un employé");
		System.out.println("5- Rechercher un employé par ename et job ");
		System.out.println("6- Supprimer un employé ");
		System.out.println("7- Stop");

		int choix =saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherEmployes();break;
		case 2 : rechercheEmployeID();break;
		case 3 : ajouterEmploye();break;
		case 4 : modifierEmploye();break;
		case 5 : rechercheEmployeEnameEtJob();break;
		case 6 : supprimerEmploye();break;
		case 7 : System.exit(0);
		}
		menuPrincipal();
	}

	public static void supprimerEmploye() {
		afficherEmployes();
		Integer id = saisieInt("Choisir l'employe");
		delete(id);
		
	}
	public static void rechercheEmployeID() {
		//Faire saisir un Integer id
		Integer id = saisieInt("Saisir l'id d'un employe");
		Employe emp = findById(id);
		//Si emp est null, afficher que l'id n'existe pas, sinon afficher l'employé
		if(emp==null) 
		{
			System.out.println("Cet id n'existe pas en base");
		}
		else 
		{
			System.out.println(emp);
		}

	}
	public static void afficherEmployes() {
		List<Employe> employes = findAll();
		//Verifier si la liste est vide, si c'est le cas, afficher qu'elle est vide, sinon afficher chaque employé
		if(employes.isEmpty()) 
		{
			System.out.println("Aucun employé dans la base");
		}
		for(Employe e : employes) 
		{
			System.out.println(e);
		}
	}
	
	
	public static void afficherDepartements() {
		List<Departement> departements = findAllDept();
		//Verifier si la liste est vide, si c'est le cas, afficher qu'elle est vide, sinon afficher chaque employé
		if(departements.isEmpty()) 
		{
			System.out.println("Aucun departement dans la base");
		}
		for(Departement d : departements) 
		{
			System.out.println(d);
		}
	}

	public static void rechercheEmployeEnameEtJob() {
		//Faire saisir ename et job
		String ename=saisieString("Saisir votre ename");
		String job = saisieString("Saisir votre job");
		Employe emp = findByEnameAndJob(ename, job);
		//Verifier si emp est null, si c'est le cas, afficher que cet employé n'existe pas, sinon afficher l'employé

		if(emp==null) 
		{
			System.out.println("Cet employé n'existe pas");
		}
		else {
		System.out.println(emp);
		}
		//**********En faisant vos test, vous devez être capable d'injecter votre propre code SQL pour afficher les informations de KING sans même connaitre son job*************
	}

	public static void ajouterEmploye() {
		//Faire saisir les informations d'un employé (ne pas prendre en compte le manager et le département, laisser null)
		Integer empno = saisieInt("Saisir votre empno");
		String ename  = saisieString("Saisir votre ename");
		String job = saisieString("Saisir votre job");
		String hiredate = saisieString("Saisir votre hiredate");
		int sal = saisieInt("Saisir votre salaire");
		Integer comm=null;
		String choix = saisieString("Avez vous une comm ? y/n");
		if(choix.equals("y")) 
		{
			comm = saisieInt("Saisir comm");
		}
		
		choix = saisieString("Avez vous un departement ? y/n");
		Departement departement = null;
		if(choix.equals("y")) 
		{
			afficherDepartements();
			Integer deptno = saisieInt("Choisir un departement");
			departement = findByIdDepartement(deptno);
		}
		
		choix = saisieString("Avez vous un manager ? y/n");
		Employe manager = null;
		if(choix.equals("y")) 
		{
			afficherEmployes();
			Integer mgr = saisieInt("Choisir un manager");
			manager = findById(mgr);
		}
		
		
		Employe emp=new Employe(empno,ename,job,manager,LocalDate.parse(hiredate),sal,comm,departement);
		insert(emp);

	}
	public static void modifierEmploye() {
		afficherEmployes();
		//Faire saisir l'id d'un des employés (aucune vérification necessaire)
		//Faire saisir les informations d'un employé (ne pas prendre en compte le manager et le département, laisser null)
		Integer empno = saisieInt("Saisir votre empno");
		String ename  = saisieString("Saisir votre ename");
		String job = saisieString("Saisir votre job");
		String hiredate = saisieString("Saisir votre hiredate");
		int sal = saisieInt("Saisir votre salaire");
		Integer comm=null;
		String choix = saisieString("Avez vous une comm ? y/n");
		if(choix.equals("y")) 
		{
			comm = saisieInt("Saisir comm");
		}
		
		choix = saisieString("Avez vous un departement ? y/n");
		Departement departement = null;
		if(choix.equals("y")) 
		{
			afficherDepartements();
			Integer deptno = saisieInt("Choisir un departement");
			departement = findByIdDepartement(deptno);
		}
		
		choix = saisieString("Avez vous un manager ? y/n");
		Employe manager = null;
		if(choix.equals("y")) 
		{
			afficherEmployes();
			Integer mgr = saisieInt("Choisir un manager");
			manager = findById(mgr);
		}
		
		
		Employe emp=new Employe(empno,ename,job,manager,LocalDate.parse(hiredate),sal,comm,departement);
		update(emp);

	}





	public static void main(String[] args) {
		menuPrincipal();
	}
}
