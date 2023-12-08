package dto;

import java.time.LocalDate;

public class CuotaDTO {
	private Integer nroCuota;
	private Double monto;
	private LocalDate ultimoDiaPago;

	public CuotaDTO() {}

	public CuotaDTO(Integer nroCuota, Double monto, LocalDate ultimoDiaPago) {
		super();
		this.nroCuota = nroCuota;
		this.monto = monto;
		this.ultimoDiaPago = ultimoDiaPago;
	}

	public Integer getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDate getUltimoDiaPago() {
		return ultimoDiaPago;
	}

	public void setUltimoDiaPago(LocalDate ultimoDiaPago) {
		this.ultimoDiaPago = ultimoDiaPago;
	}
}