package gestores;

import java.util.ArrayList;
import java.util.List;

import dao.factory.FactoryDao;
import dao.interfaces.ParametroVehiculoDao;
import dominio.AjusteModelo;
import dominio.Marca;
import dominio.Modelo;
import dominio.SumaAsegurada;
import dto.AjusteModeloDTO;
import dto.AnioFabricacionDTO;
import dto.MarcaVehiculoDTO;
import dto.ModeloVehiculoDTO;
import dto.SumaAseguradaDTO;

public final class GestorParametroVehiculo {
	private static GestorParametroVehiculo instancia;
	private FactoryDao factory;
	private ParametroVehiculoDao parametroVehiculoDao;
	
	private GestorParametroVehiculo() {}
	
	public synchronized static GestorParametroVehiculo getInstancia() {
		if(instancia == null) instancia = new GestorParametroVehiculo();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Se busca todas las marcas, y cada marca tiene sus modelos, cada modelo tiene el ajuste
	 * de modelo vigente y ademas las sumas aseguradas con los anios de fabricacion del modelo
	 * 
	 */
	public List<MarcaVehiculoDTO> findAllMarcas(){
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		parametroVehiculoDao = factory.getParametroVehiculoDao();
		List<Marca> marcas = parametroVehiculoDao.findAllMarcas();
		List<MarcaVehiculoDTO> marcasDTO = new ArrayList<MarcaVehiculoDTO>();
		for(Marca unaMarca : marcas) {
			List<ModeloVehiculoDTO> modelosDTO = new ArrayList<ModeloVehiculoDTO>(); 
			for(Modelo unModelo : unaMarca.getModelos()) {
				AjusteModeloDTO ajusteDTO = findAjusteModeloVigenteByIdModelo(unModelo.getId());
				List<AnioFabricacionDTO> aniosFabricacionDTO = findAniosFabricacionByIdModelo(unModelo.getId());
				ModeloVehiculoDTO m = new ModeloVehiculoDTO(unModelo.getId(), unModelo.getNombreModelo(),ajusteDTO,aniosFabricacionDTO);
				modelosDTO.add(m);
			}
			MarcaVehiculoDTO ma = new MarcaVehiculoDTO(unaMarca.getId(), unaMarca.getNombreMarca(), modelosDTO);
			marcasDTO.add(ma);
		}
		return marcasDTO;
	}
	
	private AjusteModeloDTO findAjusteModeloVigenteByIdModelo(Integer id) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		parametroVehiculoDao = factory.getParametroVehiculoDao();
		AjusteModelo ajuste = parametroVehiculoDao.findAjusteModeloVigenteByIdModelo(id);
		AjusteModeloDTO ajusteDTO = new AjusteModeloDTO(ajuste.getId(), ajuste.getValorPorcentual());
		return ajusteDTO;
	}
	
	private List<AnioFabricacionDTO> findAniosFabricacionByIdModelo(Integer id){
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		parametroVehiculoDao = factory.getParametroVehiculoDao();
		List<SumaAsegurada> sumasAseguradas = parametroVehiculoDao.findSumasAseguradasByIdModelo(id);
		List<AnioFabricacionDTO> aniosFabricacionDTO = new ArrayList<AnioFabricacionDTO>();
		for(SumaAsegurada s : sumasAseguradas) {
			SumaAseguradaDTO sumaAseguradaDTO = new SumaAseguradaDTO(s.getId(), s.getSumaAsegurada().toString());
			AnioFabricacionDTO a = new AnioFabricacionDTO(s.getAnioFabricacion().getId(), s.getAnioFabricacion().getAnio(),sumaAseguradaDTO);
			aniosFabricacionDTO.add(a);
		}
		return aniosFabricacionDTO;
	}
}