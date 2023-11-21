package dao.interfaces.implementaciones;

import org.hibernate.Session;

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

}