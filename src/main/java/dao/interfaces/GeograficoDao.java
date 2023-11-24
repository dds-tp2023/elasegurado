package dao.interfaces;

import java.util.List;

import dominio.AjusteLocalidad;
import dominio.Localidad;
import dominio.Provincia;

public interface GeograficoDao {

	public abstract List<Provincia> findAllProvincias();
	public abstract Localidad findLocalidadById(Integer id);
	public abstract AjusteLocalidad findAjusteLocalidadVigenteByIdLocalidad(Integer id);
}