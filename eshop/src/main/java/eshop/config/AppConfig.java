package eshop.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("eshop.dao")
@EnableTransactionManagement
//@ImportResource("classpath:application-context.xml")
@PropertySource("classpath:infos.properties")

public class AppConfig {

	@Autowired
	private Environment env;
	
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("sql.driver"));
		if(System.getProperty("os.name").equals("Mac OS X")) 
		{
			dataSource.setUrl(env.getProperty("sql.mac.url"));
			dataSource.setUsername(env.getProperty("sql.mac.login"));
			dataSource.setPassword(env.getProperty("sql.mac.password"));
		}
		else 
		{
			dataSource.setUrl(env.getProperty("sql.windows.url"));
			dataSource.setUsername(env.getProperty("sql.windows.login"));
			dataSource.setPassword(env.getProperty("sql.windows.password"));
		}
		
		dataSource.setMaxTotal(Integer.parseInt(env.getProperty("sql.total")));
		return dataSource;
	}


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("eshop.model");
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(this.hibernateProperties());
		return emf;
	}
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}


	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


}
