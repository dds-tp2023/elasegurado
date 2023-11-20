package dao.interfaces;

import dominio.Usuario;

public interface UsuarioDao {
	public abstract Usuario findUsuario(String nombre,String contrasenia);
}