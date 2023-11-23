package dto;

public class ModeloDTO {
	
	private String nombreModelo;
	private String nombreMarca;
	
	public ModeloDTO(String nombreModelo, String nombreMarca) {
		super();
		this.nombreModelo = nombreModelo;
		this.nombreMarca = nombreMarca;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	

}
