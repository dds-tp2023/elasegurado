package dao.interfaces;

import java.util.List;

import dominio.Poliza;

public interface PolizaDao {
	public abstract boolean existePolizaVigente(String patente, String motor, String chasis);
	public abstract List<Poliza> findPolizasVigentesByIdCliente(Integer id);
	public abstract void save(Poliza poliza);
}