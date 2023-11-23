package dao;

import org.junit.jupiter.api.Test;

import dao.interfaces.UsuarioDao;
import dao.interfaces.implementaciones.UsuarioPGDao;
import dominio.Usuario;

public class UsuarioPGDaoTest {

	@Test
	void findUsuario() {
		UsuarioDao dao = new UsuarioPGDao();
		Usuario usuario = dao.findUsuario("usuario1", "usuario1");
		System.out.println("nombre:"+usuario.getNombreUsuario());
		System.out.println("contraseña:"+usuario.getContrasenia());
		System.out.println("rol:"+usuario.getRol());
	}
}