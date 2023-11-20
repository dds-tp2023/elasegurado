package dto;

import enums.Rol;

public class UsuarioDTO {
	private Integer id;
	private String nombreUsuario;
	private Rol rol;
	
	public UsuarioDTO() {}

	public UsuarioDTO(Integer id, String nombreUsuario, Rol rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}