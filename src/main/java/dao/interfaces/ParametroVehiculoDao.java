package dao.interfaces;

import java.util.List;

import dominio.AjusteModelo;
import dominio.AnioFabricacion;
import dominio.Marca;
import dominio.Modelo;
import dominio.SumaAsegurada;

public interface ParametroVehiculoDao {
	public abstract List<Marca> findAllMarcas();
	public abstract AjusteModelo findAjusteModeloVigenteByIdModelo(Integer id);
	public abstract List<SumaAsegurada> findSumasAseguradasByIdModelo(Integer id);
	public abstract Modelo findModeloById(Integer id);
	public abstract AnioFabricacion findAnioFabricacionById(Integer id);
}