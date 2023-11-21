package dao.interfaces.implementaciones;

import org.hibernate.Session;

import dao.interfaces.TipoCoberturaDao;
import dominio.TipoCobertura;
import utils.HibernateUtil;

public class TipoCoberturaPGDao implements TipoCoberturaDao {

	@Override
	public TipoCobertura findTipoCoberturaById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		TipoCobertura tipoCobertura = session.find(TipoCobertura.class, id);
		
		session.close();
		
		return tipoCobertura;
	}

}