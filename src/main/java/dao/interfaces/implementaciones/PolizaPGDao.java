package dao.interfaces.implementaciones;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.PolizaDao;
import dominio.Poliza;
import utils.HibernateUtil;

public class PolizaPGDao implements PolizaDao {

	@Override
	public boolean existePolizaVigente(String patente, String motor, String chasis) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Poliza poliza = null;
		if(patente != null) {
			Query<Poliza> query = session.createQuery("from Poliza where p.patente = :patente and p.motor = :motor and p.chasis = :chasis",Poliza.class);
			query.setParameter("patente", patente);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			poliza = query.getSingleResultOrNull();
		}else {
			Query<Poliza> query = session.createQuery("from Poliza where p.motor = :motor and p.chasis = :chasis",Poliza.class);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			poliza = query.getSingleResultOrNull();
		}
		
		session.close();
		
		return poliza != null;
	}

}