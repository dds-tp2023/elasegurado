package dto;

import java.util.List;

public class MarcaVehiculoDTO {
	private Integer id;
	private String nombreMarca;
	private List<ModeloVehiculoDTO> modelos;
	
	public MarcaVehiculoDTO() {}

	public MarcaVehiculoDTO(String nombreMarca) {
		super();
		this.nombreMarca = nombreMarca;
	}
	
	public MarcaVehiculoDTO(Integer id, String nombreMarca, List<ModeloVehiculoDTO> modelos) {
		super();
		this.id = id;
		this.nombreMarca = nombreMarca;
		this.modelos = modelos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public List<ModeloVehiculoDTO> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloVehiculoDTO> modelos) {
		this.modelos = modelos;
	}

	@Override
	public String toString() {
		return nombreMarca;
	}
}