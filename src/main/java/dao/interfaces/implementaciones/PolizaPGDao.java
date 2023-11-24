package dao.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.interfaces.PolizaDao;
import dominio.Cliente;
import dominio.Poliza;
import jakarta.persistence.PersistenceException;
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

	@Override
	public List<Poliza> findPolizasVigentesByIdCliente(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Poliza> query = session.createQuery("select p from Poliza p where p.fechaInicioVigencia <= :date1 and p.fechaFinVigencia >= :date2 and p.cliente.id = :id", Poliza.class);
		query.setParameter("date1", LocalDate.now());
		query.setParameter("date2", LocalDate.now());
		query.setParameter("id", id);
		List<Poliza> polizas = query.getResultList();
		
		session.close();
		
		return polizas;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void save(Poliza poliza) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        Transaction transaction = session.beginTransaction();

		        try {
		            session.saveOrUpdate(poliza);
		            transaction.commit();
		        } 
		        catch (PersistenceException e) {
					transaction.rollback();
				}
		}	
	}

}