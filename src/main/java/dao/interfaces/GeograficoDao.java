package dao.interfaces;

import java.util.List;

import dominio.Provincia;

public interface GeograficoDao {

	public abstract List<Provincia> findAllProvincias();
}