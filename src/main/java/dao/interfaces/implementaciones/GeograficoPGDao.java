package dao.interfaces.implementaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import dao.interfaces.GeograficoDao;
import dominio.Localidad;
import dominio.Provincia;
import dto.LocalidadDTO;
import dto.ProvinciaDTO;
import utils.HibernateUtil;

public class GeograficoPGDao implements GeograficoDao {
	@Override
	public List<ProvinciaDTO> getAllProvinciasConLocalidades() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Provincia> query = session.createQuery("from Provincia", Provincia.class);
		List<Provincia> provincias = query.getResultList();
		List<ProvinciaDTO> provinciasDTO = new ArrayList<ProvinciaDTO>();
		for (Provincia p : provincias) {
			ProvinciaDTO pDto = new ProvinciaDTO();
			pDto.setId(p.getId());
			Query<Provincia> query2 = session.createQuery("select p from Provincia p join fetch p.localidades where p.id = :id", Provincia.class);
			query2.setParameter("id", p.getId());
			Provincia pr = query2.getSingleResult();
			List<LocalidadDTO> listaLocalidadesDTO = new ArrayList<LocalidadDTO>();
			for(Localidad l : pr.getLocalidades()) {
				LocalidadDTO lDto = new LocalidadDTO(l.getId(), l.getNombreLocalidad());
				listaLocalidadesDTO.add(lDto);
			}
			pDto.setLocalidades(listaLocalidadesDTO);
			pDto.setNombreProvincia(p.getNombreProvincia());
			provinciasDTO.add(pDto);
		}
		session.close();
		return provinciasDTO;
	}
}