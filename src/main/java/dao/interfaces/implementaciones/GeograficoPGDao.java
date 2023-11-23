package dao.interfaces.implementaciones;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import dao.interfaces.GeograficoDao;
import dominio.Localidad;
import dominio.Provincia;
import utils.HibernateUtil;

public class GeograficoPGDao implements GeograficoDao {
	
	/**
	 * Este metodo retorna todas las provincias con sus respectivas localidades
	 */
	@Override
	public List<Provincia> findAllProvincias() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Provincia> provinciasAux = session.createQuery("from Provincia", Provincia.class).list();
		List<Provincia> provincias = new ArrayList<Provincia>();
		for(Provincia unaProvincia : provinciasAux) {
			Query<Provincia> query = session.createQuery("select p from Provincia p join fetch p.localidades where p.id = :id", Provincia.class);
			query.setParameter("id", unaProvincia.getId());
			Provincia p = query.getSingleResult();
			provincias.add(p);
		}
		session.close();
		return provincias;
		
	}

	@Override
	public Localidad findLocalidadById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Localidad localidad = session.find(Localidad.class, id);
		
		session.close();
		
		return localidad;
	}
}