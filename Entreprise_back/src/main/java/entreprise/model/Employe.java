package entreprise.model;

import java.time.LocalDate;

public class Employe {
	private Integer empno;
	private String ename;
	private String job;
	private Employe manager;
	private LocalDate hiredate;
	private int sal;
	private Integer comm;
	private Departement departement;
	
	public Employe(Integer empno, String ename, String job, Employe manager,LocalDate hiredate, int sal, Integer comm,
			Departement departement) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.manager=manager;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.departement = departement;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Integer getComm() {
		return comm;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employe [empno=" + empno + ", ename=" + ename + ", job=" + job + ", manager=" + manager + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", departement=" + departement + "]";
	}

	
	
	
	
	

}
