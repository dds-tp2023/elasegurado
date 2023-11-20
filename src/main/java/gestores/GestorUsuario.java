package gestores;

import dao.factory.FactoryDao;
import dao.interfaces.UsuarioDao;
import dominio.Usuario;
import dto.UsuarioDTO;

public final class GestorUsuario {
	private	static GestorUsuario instancia;
	private FactoryDao factory;
	private UsuarioDao usuarioDao;
	
	private GestorUsuario() {}
	
	public synchronized static GestorUsuario getInstancia() {
		if(instancia == null) instancia = new GestorUsuario();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public UsuarioDTO autenticar(String nombreUsuario, String contrasenia) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		usuarioDao = factory.getUsuarioDao();
		Usuario usuario = usuarioDao.findUsuario(nombreUsuario, contrasenia);
		UsuarioDTO usuarioDTO = null;
		if(usuario != null) {
			usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombreUsuario(), usuario.getRol());
		}
		return usuarioDTO;
	}
}