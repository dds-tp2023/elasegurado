package dao.interfaces.implementaciones;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.ParametroPolizaDao;
import dominio.ParametroPoliza;
import utils.HibernateUtil;

public class ParametroPolizaPGDao implements ParametroPolizaDao {

	@Override
	public ParametroPoliza findParametroPolizaByDate(LocalDate date) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from ParametroPoliza p where p.fechaInicioVigencia <= :date1 and p.fechaFinVigencia >= :date2";
		Query<ParametroPoliza> query = session.createQuery(hql, ParametroPoliza.class);
		query.setParameter("date1", date);
		query.setParameter("date2", date);
		ParametroPoliza p = query.getSingleResultOrNull();
		
		session.close();
		
		return p;
	}
}