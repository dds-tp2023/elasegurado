package dto;

import java.util.List;

public class ModeloVehiculoDTO {
	private Integer id;
	private String nombreModelo;
	private AjusteModeloDTO ajuste;
	private List<AnioFabricacionDTO> aniosFabricacion;
	
	public ModeloVehiculoDTO() {}
	
	public ModeloVehiculoDTO(String nombreModelo) {
		super();
		this.nombreModelo = nombreModelo;
	}

	public ModeloVehiculoDTO(Integer id, String nombreModelo, AjusteModeloDTO ajuste, List<AnioFabricacionDTO> aniosFabricacion) {
		super();
		this.id = id;
		this.nombreModelo = nombreModelo;
		this.ajuste = ajuste;
		this.aniosFabricacion = aniosFabricacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	
	public AjusteModeloDTO getAjuste() {
		return ajuste;
	}

	public void setAjuste(AjusteModeloDTO ajuste) {
		this.ajuste = ajuste;
	}

	public List<AnioFabricacionDTO> getAniosFabricacion() {
		return aniosFabricacion;
	}

	public void setAniosFabricacion(List<AnioFabricacionDTO> aniosFabricacion) {
		this.aniosFabricacion = aniosFabricacion;
	}

	@Override
	public String toString() {
		return nombreModelo;
	}
}