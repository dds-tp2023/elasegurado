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

public abstract class FactoryDao {
	public static final int PG_FACTORY = 1;
	public static final int MYSQL_FACTORY = 2;
	public static final int TXT_FACTORY = 3;
	
	public static FactoryDao getFactory(int claveFactory) {
		switch(claveFactory) {
			case PG_FACTORY:
				return new PGFactoryDao();
			default: return new PGFactoryDao();
		}
	}
	
	public abstract ParametroVehiculoDao getParametroVehiculoDao();
	public abstract ParametroPolizaDao getParametroPolizaDao();
	public abstract GeograficoDao getGeograficoDao();
	public abstract ClienteDao getClienteDao();
	public abstract RegistroAuditoriaDao getRegistroAuditoriaDao();
	public abstract TipoCoberturaDao getTipoCoberturaDao();
	public abstract PagoDao getPagoDao();
	public abstract InformeDao getInformeDao();
	public abstract ReporteDao getReporteDao();
	public abstract UsuarioDao getUsuarioDao();
	public abstract PolizaDao getPolizaDao();
	public abstract MedidaSeguridadDao getMedidaSeguridadDao();
}