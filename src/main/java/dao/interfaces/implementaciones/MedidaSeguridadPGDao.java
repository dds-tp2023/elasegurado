package dao.interfaces.implementaciones;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.MedidaSeguridadDao;
import dominio.AjusteMedidaSeguridad;
import dominio.MedidaSeguridad;
import utils.HibernateUtil;

public class MedidaSeguridadPGDao implements MedidaSeguridadDao {

	@Override
	public MedidaSeguridad findMedidaSeguridadByNombre(String nombre) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<MedidaSeguridad> query = session.createQuery("from MedidaSeguridad ms where ms.nombre = :nombre", MedidaSeguridad.class);
		query.setParameter("nombre", nombre);
		MedidaSeguridad ms = query.getSingleResult();
		
		session.close();
		
		return ms;
	}

	@Override
	public AjusteMedidaSeguridad findAjusteMedidaSeguridadVigenteByIdMedidaSeguridad(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<MedidaSeguridad> query = session.createQuery("select ms from MedidaSeguridad ms join fetch ms.ajustes where ms.id = :id ",MedidaSeguridad.class);
		query.setParameter("id", id);
		MedidaSeguridad medidaSeguridad = query.getSingleResult();
		AjusteMedidaSeguridad ajuste = null;
		for(AjusteMedidaSeguridad a : medidaSeguridad.getAjustes()) {
			if(LocalDate.now().isAfter(a.getFechaInicioVigencia()) && LocalDate.now().isBefore(a.getFechaFinVigencia()) ) {
				ajuste = a;
			}
		}
		return ajuste;
	}
}