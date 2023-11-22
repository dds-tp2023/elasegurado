package dto;

public class AnioFabricacionDTO {
	private Integer id;
	private String anio;
	private SumaAseguradaDTO sumaAseguradaDTO;
	
	public AnioFabricacionDTO() {}
	
	public AnioFabricacionDTO(String anio) {
		super();
		this.anio = anio;
	}

	public AnioFabricacionDTO(Integer id, String anio, SumaAseguradaDTO sumaAseguradaDTO) {
		super();
		this.id = id;
		this.anio = anio;
		this.sumaAseguradaDTO = sumaAseguradaDTO;
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

	public SumaAseguradaDTO getSumaAseguradaDTO() {
		return sumaAseguradaDTO;
	}

	public void setSumaAseguradaDTO(SumaAseguradaDTO sumaAseguradaDTO) {
		this.sumaAseguradaDTO = sumaAseguradaDTO;
	}

	@Override
	public String toString() {
		return anio;
	}
}