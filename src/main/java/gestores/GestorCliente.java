package gestores;

import dao.factory.FactoryDao;
import dao.interfaces.ClienteDao;
import dominio.Cliente;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;
import dto.ClienteDTO;

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
	
	public ClienteDTO findCliente(Integer id) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		clienteDao = factory.getClienteDao();
		Cliente cliente = clienteDao.findClienteById(id);
		ClienteDTO clienteDTO = null;
		if(cliente != null) {
			Localidad l = cliente.getDireccion().getLocalidad();
			Provincia p = l.getProvincia();
			Pais pa = p.getPais();
			
			clienteDTO = new ClienteDTO();
			clienteDTO.setId(cliente.getId());
			clienteDTO.setNroCliente(cliente.getNroCliente());
			clienteDTO.setApellido(cliente.getApellido());
			clienteDTO.setNombre(cliente.getNombre());
			clienteDTO.setTipoDocumento(cliente.getTipoDocumento().toString());
			clienteDTO.setDocumento(cliente.getNroDocumento());
			clienteDTO.setPais(pa.getNombrePais());
			clienteDTO.setProvincia(p.getNombreProvincia());
			clienteDTO.setLocalidad(l.getNombreLocalidad());
			clienteDTO.setCodigoPostal(l.getCodigoPostal());
			clienteDTO.setCalle(cliente.getDireccion().getCalle());
			clienteDTO.setNumero(cliente.getDireccion().getNro());
			clienteDTO.setDpto(cliente.getDireccion().getDpto());
			clienteDTO.setPiso(cliente.getDireccion().getPiso());
		}
		return clienteDTO;
	}
}