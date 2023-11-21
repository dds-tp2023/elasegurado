package dto;

public class AnioFabricacionDTO {
	private Integer id;
	private String anio;
	
	public AnioFabricacionDTO() {}
	
	public AnioFabricacionDTO(String anio) {
		super();
		this.anio = anio;
	}

	public AnioFabricacionDTO(Integer id, String anio) {
		super();
		this.id = id;
		this.anio = anio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return anio;
	}
}