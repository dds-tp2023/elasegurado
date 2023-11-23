package dao;

import org.junit.jupiter.api.Test;

import dao.interfaces.ClienteDao;
import dao.interfaces.implementaciones.ClientePGDao;
import dominio.Cliente;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;

public class ClientePGDaoTest {

	@Test
	void findCliente() {
		ClienteDao dao = new ClientePGDao();
		Cliente cliente = dao.findClienteById(1);
		System.out.println("nombre:"+cliente.getNombre());
		Localidad l = cliente.getDireccion().getLocalidad();
		Provincia p = l.getProvincia();
		Pais pais = p.getPais();
		System.out.println("localidad:"+l.getNombreLocalidad());
		System.out.println("provincia:"+p.getNombreProvincia());
		System.out.println("pais:"+pais.getNombrePais());
	}
}