package dao.interfaces;

import java.util.List;

import dominio.AjusteModelo;
import dominio.Marca;
import dominio.SumaAsegurada;

public interface ParametroVehiculoDao {
	public abstract List<Marca> findAllMarcas();
	public abstract AjusteModelo findAjusteModeloVigenteByIdModelo(Integer id);
	public abstract List<SumaAsegurada> findSumasAseguradasByIdModelo(Integer id);
}