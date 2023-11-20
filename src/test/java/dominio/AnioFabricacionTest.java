package dominio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import utils.HibernateUtil;

public class AnioFabricacionTest {
	
	@Test
	void createTableTest() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		AnioFabricacion anioFabricacion1= new AnioFabricacion(null, "2023");
		AnioFabricacion anioFabricacion2= new AnioFabricacion(null, "2024");
		
		session.beginTransaction();
		
		session.persist(anioFabricacion1);
		session.persist(anioFabricacion2);
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		HibernateUtil.shutdown();
	}
}