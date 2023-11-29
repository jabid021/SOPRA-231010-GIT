package quest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import quest.context.Singleton;


public class StartListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Tomcat STOP");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("Tomcat START");
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
      
       Singleton.getInstance();
    }
	
}
