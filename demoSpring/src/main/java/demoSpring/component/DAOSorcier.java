package demoSpring.component;

import org.springframework.stereotype.Component;

@Component
public class DAOSorcier implements IDAO{

	public void findById() {
		System.out.println("find by id dans Sorcier");
		
	}

}
