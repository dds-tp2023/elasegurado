package dao.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.ParametroVehiculoDao;
import dominio.AjusteModelo;
import dominio.Marca;
import dominio.Modelo;
import dominio.SumaAsegurada;
import utils.HibernateUtil;

public class ParametroVehiculoPGDao implements ParametroVehiculoDao {

	@Override
	public List<Marca> findAllMarcas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Marca> marcasAux = session.createQuery("from Marca", Marca.class).list();
		List<Marca> marcas = new ArrayList<Marca>();
		for(Marca unaMarca : marcasAux) {
			Query<Marca> query = session.createQuery("select m from Marca m join fetch m.modelos where m.id = :id", Marca.class);
			query.setParameter("id", unaMarca.getId());
			Marca m = query.getSingleResult();
			marcas.add(m);
		}
		
		session.close();
		
		return marcas;
	}

	@Override
	public AjusteModelo findAjusteModeloVigenteByIdModelo(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Modelo> query = session.createQuery("select m from Modelo m join fetch m.ajustes where m.id = :id", Modelo.class);
		query.setParameter("id", id);
		Modelo m = query.getSingleResult();
		List<AjusteModelo> ajustes = m.getAjustes();
		AjusteModelo ajuste = null;
		for(AjusteModelo a : ajustes) {
			if(LocalDate.now().isAfter(a.getFechaInicioVigencia()) && LocalDate.now().isBefore(a.getFechaFinVigencia()) ) {
				ajuste = a;
			}
		}
		
		session.close();
		
		return ajuste;
	}

	@Override
	public List<SumaAsegurada> findSumasAseguradasByIdModelo(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Modelo> query = session.createQuery("select m from Modelo m join fetch m.sumasAseguradas where m.id = :id", Modelo.class);
		query.setParameter("id", id);
		Modelo m = query.getSingleResult();
		List<SumaAsegurada> sumasAseguradas = m.getSumasAseguradas();
		
		session.close();
		
		return sumasAseguradas;
	}

}