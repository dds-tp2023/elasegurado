package dao.interfaces.implementaciones;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.interfaces.UsuarioDao;
import dominio.Usuario;
import utils.HibernateUtil;

public class UsuarioPGDao implements UsuarioDao {

	@Override
	public Usuario findUsuario(String nombre, String contrasenia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query<Usuario> query = session.createQuery("from Usuario where contrasenia = :contrasenia and nombreUsuario = :nombre", Usuario.class);
		query.setParameter("contrasenia", contrasenia);
		query.setParameter("nombre", nombre);
		List<Usuario> usuarios = query.getResultList();
		session.close();
		if (usuarios.size() == 1) {
		    Usuario usuario = usuarios.get(0);
		    return usuario;
		} else return null;
	}

}