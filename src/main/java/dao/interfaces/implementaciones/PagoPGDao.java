package dao.interfaces.implementaciones;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.PagoDao;
import dominio.Cliente;
import dominio.Cuota;
import dominio.Poliza;
import utils.HibernateUtil;

public class PagoPGDao implements PagoDao {

	@Override
	public boolean clienteTieneCuotasImpagasByIdCliente(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Cliente> query = session.createQuery("select c from Cliente c join fetch c.poliza where c.id = :id", Cliente.class);
		query.setParameter("id", id);
		Cliente cliente = query.getSingleResultOrNull();
		if(cliente != null) {
			for(Poliza p : cliente.getPoliza()) {
				Query<Poliza> query2 = session.createQuery("select p from Poliza p join fetch p.cuotas where p.id = :id", Poliza.class);
				query2.setParameter("id", p.getId());
				p = query2.getSingleResultOrNull();
				if(p != null) {
					for(Cuota c : p.getCuotas()) {
						Query<Cuota> query3 = session.createQuery("select c from Cuota c where c.ultimoDiaPago < :fechaActual and c.estado = 'IMPAGO' and c.id = :idCuota", Cuota.class);
						query3.setParameter("fechaActual", LocalDate.now());
						query3.setParameter("idCuota", c.getId());
						List<Cuota> cuotas = query3.getResultList();
						if(cuotas != null && cuotas.size() > 0) {
							//Existen cuotas impagas con fecha de vencimiento menor a la actual
							return true;
						}
					}
				}
			}
			
		}
		
		session.close();
		
		return false;
	}

}