package dto;

import java.time.LocalDate;

public class CuotaDTO {
	private Double monto;
	private LocalDate ultimoDiaPago;

	public CuotaDTO() {}

	public CuotaDTO(Double monto, LocalDate ultimoDiaPago) {
		super();
		this.monto = monto;
		this.ultimoDiaPago = ultimoDiaPago;
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