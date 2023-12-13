package dao.interfaces.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.ClienteDao;
import dominio.Cliente;
import dominio.Poliza;
import dto.BusquedaClienteDTO;
import enums.TipoDocumento;
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
		
		Query<Poliza> query = session.createQuery("select p from Poliza p where p.cliente.id = :id", Poliza.class);
		query.setParameter("id", id);
		List<Poliza> polizas = query.getResultList();
		if(polizas.isEmpty()) {
			Cliente cliente = findClienteById(id);
			cliente.setPoliza(new ArrayList<Poliza>());
			session.close();
			return cliente;
		}else {
			Query<Cliente> query2 = session.createQuery("select c from Cliente c join fetch c.poliza where c.id = :id", Cliente.class);
			query2.setParameter("id", id);
			Cliente cliente = query2.getSingleResultOrNull();
			
			session.close();
			return cliente;
		}
	}

	@Override
	public List<Cliente> buscarClientes(BusquedaClienteDTO criterios) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		/*
		 * Se busca sobre clientes no eliminados
		 * El enunciado dice buscar sobre clientes ACTIVO solamente
		 * Pero se estaria descartando los clientes con condicion NORMAL o PLATA
		 */
		String consulta = "select c from Cliente c where c.eliminado = false and c.apellido like :apellido and c.nombre like :nombre ";
		if(!criterios.getNroCliente().equals(""))consulta+="and c.nroCliente = :nroCliente ";
		if(!criterios.getTipoDocumento().equals("SELECCIONAR"))consulta+="and c.tipoDocumento = :tipoDocumento ";
		if(!criterios.getDocumento().equals(""))consulta+="and c.nroDocumento = :nroDocumento ";
		
		Query<Cliente> query = session.createQuery(consulta, Cliente.class);
		
		
		query.setParameter("apellido", criterios.getApellido()+"%");
		query.setParameter("nombre", criterios.getNombre()+"%");
		if(!criterios.getNroCliente().equals(""))query.setParameter("nroCliente", criterios.getNroCliente());
		if(!criterios.getTipoDocumento().equals("SELECCIONAR"))query.setParameter("tipoDocumento",TipoDocumento.valueOf(criterios.getTipoDocumento()));
		if(!criterios.getDocumento().equals(""))query.setParameter("nroDocumento", criterios.getDocumento());
		
		List<Cliente> clientes = query.getResultList();
		session.close();
		return clientes;
	}	
}