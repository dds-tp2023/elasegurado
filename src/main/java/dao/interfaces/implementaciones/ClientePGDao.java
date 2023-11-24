package dao.interfaces.implementaciones;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.ClienteDao;
import dominio.Cliente;
import utils.HibernateUtil;

public class ClientePGDao implements ClienteDao {

	@Override
	public Cliente findClienteById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Cliente cliente = session.find(Cliente.class, id);
		
		session.close();
		
		return cliente;
	}

	@Override
	public Cliente findClienteByIdConPolizas(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Cliente> query = session.createQuery("select c from Cliente c join fetch c.poliza where c.id = :id", Cliente.class);
		query.setParameter("id", id);
		Cliente cliente = query.getSingleResultOrNull();
		
		session.close();
		
		return cliente;
	}

	
}