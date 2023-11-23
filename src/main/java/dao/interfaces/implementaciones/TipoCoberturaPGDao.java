package dao.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.TipoCoberturaDao;
import dominio.AjusteModelo;
import dominio.AjusteTipoCobertura;
import dominio.Modelo;
import dominio.Provincia;
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

	@Override
	public List<TipoCobertura> findAllTiposCobertura() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<TipoCobertura> tiposCoberturaAux = session.createQuery("from TipoCobertura", TipoCobertura.class).list();
		List<TipoCobertura> tiposCobertura = new ArrayList<TipoCobertura>();
		for(TipoCobertura unaCobertura : tiposCoberturaAux) {
			Query<TipoCobertura> query = session.createQuery("select tc from TipoCobertura tc join fetch tc.ajustes where tc.id = :id", TipoCobertura.class);
			query.setParameter("id", unaCobertura.getId());
			TipoCobertura tc = query.getSingleResult();
			tiposCobertura.add(tc);
		}
		session.close();
		return tiposCobertura;
		
	}

	@Override
	public AjusteTipoCobertura findAjusteTipoCoberturaVigenteByIdTipoCobertura(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<TipoCobertura> query = session.createQuery("select tc from TipoCobertura tc join fetch tc.ajustes where tc.id = :id", TipoCobertura.class);
		query.setParameter("id", id);
		TipoCobertura tc = query.getSingleResult();
		List<AjusteTipoCobertura> ajustes = tc.getAjustes();
		AjusteTipoCobertura ajuste = null;
		for(AjusteTipoCobertura a : ajustes) {
			if(LocalDate.now().isAfter(a.getFechaInicioVigencia()) && LocalDate.now().isBefore(a.getFechaFinVigencia()) ) {
				ajuste = a;
			}
		}
		
		session.close();
		
		return ajuste;
	}
	
	

}