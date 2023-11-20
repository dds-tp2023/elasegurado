package gestores;

import dao.factory.FactoryDao;
import dao.interfaces.ClienteDao;

public class GestorCliente {
	private static GestorCliente instancia;
	private FactoryDao factory;
	private ClienteDao clienteDao;
	
	private GestorCliente() {}
	
	public synchronized static GestorCliente getInstancia() {
		if(instancia == null) instancia = new GestorCliente();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public ClienteDTO getCliente() {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		clienteDao = factory.getClienteDao();
		
		return null;
	}
}