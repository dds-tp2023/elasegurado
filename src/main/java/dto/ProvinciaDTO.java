package dto;

import java.util.List;

public class ProvinciaDTO {
	private Integer id;
	private String nombreProvincia;
	private List<LocalidadDTO> localidades;

	public ProvinciaDTO() {
	}

	public ProvinciaDTO(Integer id, String nombreProvincia, List<LocalidadDTO> localidades) {
		super();
		this.id = id;
		this.nombreProvincia = nombreProvincia;
		this.localidades = localidades;
	}

	public ProvinciaDTO(String nombreProvincia) {
		super();
		this.nombreProvincia = nombreProvincia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvicnia) {
		this.nombreProvincia = nombreProvicnia;
	}

	public List<LocalidadDTO> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<LocalidadDTO> localidades) {
		this.localidades = localidades;
	}

	@Override
	public String toString() {
		return nombreProvincia;
	}

}