package dto;

import java.time.LocalDate;
import java.util.List;

public class GeneracionPolizaDTO {
	private DatosPolizaDTO datosPoliza;
	private String tipoCobertura;
	private LocalDate fechaInicioVigencia;
	private String formaPago;
	private Double premio;
	private Double descuentos;
	private List<CuotaDTO> cuotas;
	
	public GeneracionPolizaDTO() {}

	public GeneracionPolizaDTO(DatosPolizaDTO datosPoliza, String tipoCobertura, LocalDate fechaInicioVigencia,
			String formaPago, Double premio, Double descuentos, List<CuotaDTO> cuotas) {
		super();
		this.datosPoliza = datosPoliza;
		this.tipoCobertura = tipoCobertura;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.formaPago = formaPago;
		this.premio = premio;
		this.descuentos = descuentos;
		this.cuotas = cuotas;
	}

	public DatosPolizaDTO getDatosPoliza() {
		return datosPoliza;
	}

	public void setDatosPoliza(DatosPolizaDTO datosPoliza) {
		this.datosPoliza = datosPoliza;
	}

	public String getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(String tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public LocalDate getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Double getPremio() {
		return premio;
	}

	public void setPremio(Double premio) {
		this.premio = premio;
	}

	public Double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}

	public List<CuotaDTO> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<CuotaDTO> cuotas) {
		this.cuotas = cuotas;
	}
}