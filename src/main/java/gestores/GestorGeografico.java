package gestores;

import java.util.ArrayList;
import java.util.List;
import dao.factory.FactoryDao;
import dao.interfaces.GeograficoDao;
import dominio.Localidad;
import dominio.Provincia;
import dto.LocalidadDTO;
import dto.ProvinciaDTO;

public final class GestorGeografico {
	private static GestorGeografico instancia;
	private FactoryDao factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
	private GeograficoDao geograficoDao = factory.getGeograficoDao();
	
	private GestorGeografico() {
	}
	
	public synchronized static GestorGeografico getInstancia() {
		if (instancia == null)
			instancia = new GestorGeografico();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Este metodo recupera todas las provincias con sus respectivas localidades
	 */
	public List<ProvinciaDTO> findAllProvincias(){
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		geograficoDao = factory.getGeograficoDao();
		List<Provincia> provincias = geograficoDao.findAllProvincias();
		List<ProvinciaDTO> provinciasDTO = new ArrayList<ProvinciaDTO>();
		for(Provincia unaProvincia : provincias) {
			List<LocalidadDTO> localidadesDTO = new ArrayList<LocalidadDTO>();
			for(Localidad unaLocalidad : unaProvincia.getLocalidades()) {
				LocalidadDTO lDto = new LocalidadDTO(unaLocalidad.getId(), unaLocalidad.getNombreLocalidad());
				localidadesDTO.add(lDto);
			}
			ProvinciaDTO pDto = new ProvinciaDTO(unaProvincia.getId(), unaProvincia.getNombreProvincia(), localidadesDTO);
			provinciasDTO.add(pDto);
		}
		return provinciasDTO;
	}
	
}