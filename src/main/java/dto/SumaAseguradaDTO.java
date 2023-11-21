package dto;

public class SumaAseguradaDTO {
	private Integer id;
	private Double sumaAsegurada;
	private AnioFabricacionDTO anioFabricacion;

	public SumaAseguradaDTO() {}

	public SumaAseguradaDTO(Integer id, Double sumaAsegurada, AnioFabricacionDTO anioFabricacion) {
		super();
		this.id = id;
		this.sumaAsegurada = sumaAsegurada;
		this.anioFabricacion = anioFabricacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public AnioFabricacionDTO getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(AnioFabricacionDTO anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
}