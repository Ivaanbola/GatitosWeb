package Singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	private static SessionFactory session;

	static {
		session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSession() {
		return session;
	}
	
}
