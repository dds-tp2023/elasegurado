package dao.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.interfaces.PolizaDao;
import dominio.Poliza;
import jakarta.persistence.PersistenceException;
import utils.HibernateUtil;

public class PolizaPGDao implements PolizaDao {

	@Override
	public boolean existePolizaVigente(String patente, String motor, String chasis) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Poliza poliza = null;
		LocalDate date = LocalDate.now().plusDays(1);
		if(patente != null) {
			String hql = "from Poliza p where p.patente = :patente and p.motor = :motor and p.chasis = :chasis and :date between p.fechaInicioVigencia and p.fechaFinVigencia";
			Query<Poliza> query = session.createQuery(hql,Poliza.class);
			query.setParameter("patente", patente);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			query.setParameter("date", date);
			poliza = query.getSingleResultOrNull();
		}else {
			String hql = "from Poliza p where p.motor = :motor and p.chasis = :chasis and :date between p.fechaInicioVigencia and p.fechaFinVigencia";
			Query<Poliza> query = session.createQuery(hql,Poliza.class);
			query.setParameter("motor", motor);
			query.setParameter("chasis", chasis);
			query.setParameter("date", date);
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

	@Override
	public void save(Poliza poliza) {
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        Transaction transaction = session.beginTransaction();

		        try {
		        	session.merge(poliza.getCliente());
		        	session.merge(poliza);
		        	//session.persist(poliza);
		            session.flush();
		            transaction.commit();
		        } 
		        catch (PersistenceException e) {
					transaction.rollback();
				}
		}	
	}

	@Override
	public List<Poliza> findPolizasUltimosDosAñosByIdCliente(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		//Se buscan todas las polizas que esten en el rango de 2 años del cliente
		String hql = "select p from Poliza p where p.cliente.id = :id and (:fecha = p.fechaInicioVigencia or :fecha < p.fechaInicioVigencia or :fecha between p.fechaInicioVigencia and p.fechaFinVigencia)"; 
		Query<Poliza> query = session.createQuery(hql, Poliza.class);
		query.setParameter("id", id);
		query.setParameter("fecha", LocalDate.now().minusYears(2));
		List<Poliza> polizas  = query.getResultList();
		
		session.close();
		
		return polizas;
	}
}