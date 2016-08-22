package util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			System.out.println("Configuration instance created");
			config = config.configure();
			System.out.println("Configuration instance configured");
			sessionFactory = config.buildSessionFactory();
			System.out.println("successfully got session factory");
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);

		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
