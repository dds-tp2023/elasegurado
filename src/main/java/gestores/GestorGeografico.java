package gestores;

import java.util.List;
import dao.factory.FactoryDao;
import dao.interfaces.GeograficoDao;
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
	
	public List<ProvinciaDTO> listaProvinciaComboBox() {
		List<ProvinciaDTO> provincias = null;
		return provincias = geograficoDao.getAllProvinciasConLocalidades();
	}
	
}