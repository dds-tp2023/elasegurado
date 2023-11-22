package dto;

public class SumaAseguradaDTO {
	private Integer id;
	private String sumaAsegurada;

	public SumaAseguradaDTO() {}

	public SumaAseguradaDTO(Integer id, String sumaAsegurada) {
		super();
		this.id = id;
		this.sumaAsegurada = sumaAsegurada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}
}