package dto;

import java.time.LocalDate;
import java.util.List;

public class GeneracionPolizaDTO {
	private DatosPolizaDTO datosPoliza;
	private Integer idTipoCobertura;
	private LocalDate fechaInicioVigencia;
	private Integer idFormaPago;
	private Double premio;
	private Double descuentos;
	private List<CuotaDTO> cuotas;
	
	public GeneracionPolizaDTO() {}

	public GeneracionPolizaDTO(DatosPolizaDTO datosPoliza, Integer idTipoCobertura, LocalDate fechaInicioVigencia,
			Integer idFormaPago, Double premio, Double descuentos, List<CuotaDTO> cuotas) {
		super();
		this.datosPoliza = datosPoliza;
		this.idTipoCobertura = idTipoCobertura;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.idFormaPago = idFormaPago;
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

	public Integer getIdTipoCobertura() {
		return idTipoCobertura;
	}

	public void setIdTipoCobertura(Integer idTipoCobertura) {
		this.idTipoCobertura = idTipoCobertura;
	}

	public LocalDate getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Integer getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
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