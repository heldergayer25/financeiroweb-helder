package br.com.financeiroweb.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Helder
 *
 *Cria A Session Factory de comunicação com o banco de dados
 *Arquivo de configuração hibernate.cfg.xml
 */
public class HibernateUtil {
		 
	private static SessionFactory configureSessionFactory() throws HibernateException {
	
		Configuration configuration = new Configuration().configure();
	
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
	
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
		return factory;		  
	}	 
	 
	public static SessionFactory getSessionFactory() {
	    return configureSessionFactory();
	}
	
}
