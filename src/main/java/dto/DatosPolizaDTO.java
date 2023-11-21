package dto;

import java.util.List;

public class DatosPolizaDTO {
	private Integer idCliente;
	private Integer idLocalidad;
	private Integer idModelo;
	private Integer idAnioFabricacion;
	private String motor;
	private String chasis;
	private String patente;
	private Integer kmPorAnio;
	private List<Integer> idMedidasSeguridad;
	private Integer idCantSiniestros;
	private List<HijoDeclaradoDTO> hijosDeclarados;

	public DatosPolizaDTO() {}

	public DatosPolizaDTO(Integer idCliente, Integer idLocalidad, Integer idModelo, Integer idAnioFabricacion,
			String motor, String chasis, String patente, Integer kmPorAnio, List<Integer> idMedidasSeguridad,
			Integer idCantSiniestros, List<HijoDeclaradoDTO> hijosDeclarados) {
		super();
		this.idCliente = idCliente;
		this.idLocalidad = idLocalidad;
		this.idModelo = idModelo;
		this.idAnioFabricacion = idAnioFabricacion;
		this.motor = motor;
		this.chasis = chasis;
		this.patente = patente;
		this.kmPorAnio = kmPorAnio;
		this.idMedidasSeguridad = idMedidasSeguridad;
		this.idCantSiniestros = idCantSiniestros;
		this.hijosDeclarados = hijosDeclarados;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Integer getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public Integer getIdAnioFabricacion() {
		return idAnioFabricacion;
	}

	public void setIdAnioFabricacion(Integer idAnioFabricacion) {
		this.idAnioFabricacion = idAnioFabricacion;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getKmPorAnio() {
		return kmPorAnio;
	}

	public void setKmPorAnio(Integer kmPorAnio) {
		this.kmPorAnio = kmPorAnio;
	}

	public List<Integer> getIdMedidasSeguridad() {
		return idMedidasSeguridad;
	}

	public void setIdMedidasSeguridad(List<Integer> idMedidasSeguridad) {
		this.idMedidasSeguridad = idMedidasSeguridad;
	}

	public Integer getIdCantSiniestros() {
		return idCantSiniestros;
	}

	public void setIdCantSiniestros(Integer idCantSiniestros) {
		this.idCantSiniestros = idCantSiniestros;
	}

	public List<HijoDeclaradoDTO> getHijosDeclarados() {
		return hijosDeclarados;
	}

	public void setHijosDeclarados(List<HijoDeclaradoDTO> hijosDeclarados) {
		this.hijosDeclarados = hijosDeclarados;
	}
}