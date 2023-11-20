package dao.factory;

import dao.interfaces.ClienteDao;
import dao.interfaces.GeograficoDao;
import dao.interfaces.InformeDao;
import dao.interfaces.MedidaSeguridadDao;
import dao.interfaces.PagoDao;
import dao.interfaces.ParametroPolizaDao;
import dao.interfaces.ParametroVehiculoDao;
import dao.interfaces.PolizaDao;
import dao.interfaces.RegistroAuditoriaDao;
import dao.interfaces.ReporteDao;
import dao.interfaces.TipoCoberturaDao;
import dao.interfaces.UsuarioDao;
import dao.interfaces.implementaciones.ClientePGDao;
import dao.interfaces.implementaciones.GeograficoPGDao;
import dao.interfaces.implementaciones.InformePGDao;
import dao.interfaces.implementaciones.MedidaSeguridadPGDao;
import dao.interfaces.implementaciones.PagoPGDao;
import dao.interfaces.implementaciones.ParametroPolizaPGDao;
import dao.interfaces.implementaciones.ParametroVehiculoPGDao;
import dao.interfaces.implementaciones.PolizaPGDao;
import dao.interfaces.implementaciones.RegistroAuditoriaPGDao;
import dao.interfaces.implementaciones.ReportePGDao;
import dao.interfaces.implementaciones.TipoCoberturaPGDao;
import dao.interfaces.implementaciones.UsuarioPGDao;

public class PGFactoryDao extends FactoryDao {

	@Override
	public ParametroVehiculoDao getParametroVehiculoDao() {
		return new ParametroVehiculoPGDao();
	}

	@Override
	public ParametroPolizaDao getParametroPolizaDao() {
		return new ParametroPolizaPGDao();
	}

	@Override
	public GeograficoDao getGeograficoDao() {
		return new GeograficoPGDao();
	}

	@Override
	public ClienteDao getClienteDao() {
		return new ClientePGDao();
	}

	@Override
	public RegistroAuditoriaDao getRegistroAuditoriaDao() {
		return new RegistroAuditoriaPGDao();
	}

	@Override
	public TipoCoberturaDao getTipoCoberturaDao() {
		return new TipoCoberturaPGDao();
	}

	@Override
	public PagoDao getPagoDao() {
		return new PagoPGDao();
	}

	@Override
	public InformeDao getInformeDao() {
		return new InformePGDao();
	}

	@Override
	public ReporteDao getReporteDao() {
		return new ReportePGDao();
	}

	@Override
	public UsuarioDao getUsuarioDao() {
		return new UsuarioPGDao();
	}

	@Override
	public PolizaDao getPolizaDao() {
		return new PolizaPGDao();
	}

	@Override
	public MedidaSeguridadDao getMedidaSeguridadDao() {
		return new MedidaSeguridadPGDao();
	}

}