package dominio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import enums.Rol;
import utils.HibernateUtil;

public class UsuarioTest {
	
	@Test
	void createTableTest() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Usuario usuario1 = new Usuario(null,"usuario1", "usuario1", Rol.PRODUCTOR_SEGURO);
		
		session.beginTransaction();
		
		session.persist(usuario1);
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		HibernateUtil.shutdown();
	}
}