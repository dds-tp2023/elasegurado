package dao.interfaces;

import java.util.List;

import dominio.Cliente;
import dto.BusquedaClienteDTO;

public interface ClienteDao {
	public abstract Cliente findClienteById(Integer id);
	public abstract Cliente findClienteByIdConPolizas(Integer id);
	public abstract List<Cliente> buscarClientes(BusquedaClienteDTO criterios);
}