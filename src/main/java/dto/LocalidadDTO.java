package dto;

public class LocalidadDTO {
	
	private Integer id;
	private String nombreLocalidad;
	public Integer getId() {
		return id;
	}
	
	public LocalidadDTO(Integer id, String nombreLocalidad) {
		super();
		this.id = id;
		this.nombreLocalidad = nombreLocalidad;
	}

	public LocalidadDTO(String nombreLocalidad) {
		super();
		this.nombreLocalidad = nombreLocalidad;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	@Override
	public String toString() {
		return nombreLocalidad;
	}
	
	
	

}
