package hopital.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMapping {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configJPA");

		emf.close();
	}

}
