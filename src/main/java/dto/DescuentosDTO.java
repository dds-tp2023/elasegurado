package dto;

public class DescuentosDTO {
	private Double descuentosUnidadesAdicionales;
	private Double descuentoPagoSemestral;
	
	public DescuentosDTO() {}
	
	public DescuentosDTO(Double descuentosUnidadesAdicionales, Double descuentoPagoSemestral) {
		super();
		this.descuentosUnidadesAdicionales = descuentosUnidadesAdicionales;
		this.descuentoPagoSemestral = descuentoPagoSemestral;
	}

	public Double getDescuentosUnidadesAdicionales() {
		return descuentosUnidadesAdicionales;
	}

	public void setDescuentosUnidadesAdicionales(Double descuentosUnidadesAdicionales) {
		this.descuentosUnidadesAdicionales = descuentosUnidadesAdicionales;
	}

	public Double getDescuentoPagoSemestral() {
		return descuentoPagoSemestral;
	}

	public void setDescuentoPagoSemestral(Double descuentoPagoSemestral) {
		this.descuentoPagoSemestral = descuentoPagoSemestral;
	}
}