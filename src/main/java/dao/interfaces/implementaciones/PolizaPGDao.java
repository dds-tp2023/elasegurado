package dao.interfaces.implementaciones;

import java.time.LocalDate;

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
		LocalDate date = LocalDate.now();
		if(patente != null) {
			String hql = "from Poliza p where p.patente = :patente and p.motor = :motor and p.chasis = :chasis and p.fechaInicioVigencia <= :date1 and p.fechaFinVigencia >= :date2";
			Query<Poliza> query = session.createQuery(hql,Poliza.class);
			query.setParameter("patente", patente);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			query.setParameter("date1", date);
			query.setParameter("date2", date);
			poliza = query.getSingleResultOrNull();
		}else {
			String hql = "from Poliza p where p.motor = :motor and p.chasis = :chasis and p.fechaInicioVigencia <= :date1 and p.fechaFinVigencia >= :date2";
			Query<Poliza> query = session.createQuery(hql,Poliza.class);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			query.setParameter("date1", date);
			query.setParameter("date2", date);
			poliza = query.getSingleResultOrNull();
		}
		
		session.close();
		
		return poliza != null;
	}

}