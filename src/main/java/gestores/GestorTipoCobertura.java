package gestores;

import java.util.ArrayList;
import java.util.List;

import dao.factory.FactoryDao;
import dao.interfaces.TipoCoberturaDao;
import dominio.AjusteModelo;
import dominio.AjusteTipoCobertura;
import dominio.Marca;
import dominio.Modelo;
import dominio.TipoCobertura;
import dto.AjusteModeloDTO;
import dto.AjusteTipoCoberturaDTO;
import dto.AnioFabricacionDTO;
import dto.MarcaVehiculoDTO;
import dto.ModeloVehiculoDTO;
import dto.TipoCoberturaDTO;
import enums.EnumTipoCobertura;

public final class GestorTipoCobertura {
	private static GestorTipoCobertura instancia;
	private FactoryDao factory;
	private TipoCoberturaDao tipoCoberturaDao;
	
	private GestorTipoCobertura() {}
	
	public synchronized static GestorTipoCobertura getInstancia() {
		if(instancia == null) instancia = new GestorTipoCobertura();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public List<TipoCoberturaDTO> findAllTipoCobertura(){
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		tipoCoberturaDao = factory.getTipoCoberturaDao();
		List<TipoCobertura> tiposCoberturas = tipoCoberturaDao.findAllTiposCobertura();
		List<TipoCoberturaDTO> tiposCoberturaDTO = new ArrayList<TipoCoberturaDTO>();
		for(TipoCobertura unaCobertura : tiposCoberturas) {
			AjusteTipoCoberturaDTO ajusteTipoCoberturaDTO = findAjusteTipoCoberturaVigenteByIdTipoCobertura(unaCobertura.getId());
			TipoCoberturaDTO tipoCoberturaDTO = new TipoCoberturaDTO(unaCobertura.getId(), unaCobertura.getNombre().toString(), ajusteTipoCoberturaDTO);
			tiposCoberturaDTO.add(tipoCoberturaDTO);
		}
		return tiposCoberturaDTO;
	}

	private AjusteTipoCoberturaDTO findAjusteTipoCoberturaVigenteByIdTipoCobertura(Integer id) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		tipoCoberturaDao = factory.getTipoCoberturaDao();
		AjusteTipoCobertura ajuste = tipoCoberturaDao.findAjusteTipoCoberturaVigenteByIdTipoCobertura(id);
		AjusteTipoCoberturaDTO ajusteDTO = new AjusteTipoCoberturaDTO(ajuste.getId(), ajuste.getValorPorcentual());
		return ajusteDTO;
	}
	
}