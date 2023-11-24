package dao.interfaces;

import dominio.Cliente;

public interface ClienteDao {
	public abstract Cliente findClienteById(Integer id);
	public abstract Cliente findClienteByIdConPolizas(Integer id);
}