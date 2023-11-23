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
	private String kmPorAnio;
	private List<String> medidasSeguridad;
	private String cantSiniestros;
	private List<HijoDeclaradoDTO> hijosDeclarados;
	private String sumaAsegurada;

	public DatosPolizaDTO() {}

	public DatosPolizaDTO(Integer idCliente, Integer idLocalidad, Integer idModelo, Integer idAnioFabricacion,
			String motor, String chasis, String patente, String kmPorAnio, List<String> medidasSeguridad,
			String cantSiniestros, List<HijoDeclaradoDTO> hijosDeclarados, String sumaAsegurada) {
		super();
		this.idCliente = idCliente;
		this.idLocalidad = idLocalidad;
		this.idModelo = idModelo;
		this.idAnioFabricacion = idAnioFabricacion;
		this.motor = motor;
		this.chasis = chasis;
		this.patente = patente;
		this.kmPorAnio = kmPorAnio;
		this.medidasSeguridad = medidasSeguridad;
		this.cantSiniestros = cantSiniestros;
		this.hijosDeclarados = hijosDeclarados;
		this.sumaAsegurada = sumaAsegurada;
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

	public String getKmPorAnio() {
		return kmPorAnio;
	}

	public void setKmPorAnio(String kmPorAnio) {
		this.kmPorAnio = kmPorAnio;
	}

	public List<String> getMedidasSeguridad() {
		return medidasSeguridad;
	}

	public void setMedidasSeguridad(List<String> medidasSeguridad) {
		this.medidasSeguridad = medidasSeguridad;
	}

	public String getCantSiniestros() {
		return cantSiniestros;
	}

	public void setCantSiniestros(String cantSiniestros) {
		this.cantSiniestros = cantSiniestros;
	}

	public List<HijoDeclaradoDTO> getHijosDeclarados() {
		return hijosDeclarados;
	}

	public void setHijosDeclarados(List<HijoDeclaradoDTO> hijosDeclarados) {
		this.hijosDeclarados = hijosDeclarados;
	}

	public String getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(String sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	
}