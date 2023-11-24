package dto;

public class PrimaDTO {
	private Double valorPremio;
	private Double valorDerechosEmision;
	
	public PrimaDTO(Double valorPremio, Double valorDerechosEmision) {
		super();
		this.valorPremio = valorPremio;
		this.valorDerechosEmision = valorDerechosEmision;
	}

	public Double getValorPremio() {
		return valorPremio;
	}

	public void setValorPremio(Double valorPremio) {
		this.valorPremio = valorPremio;
	}

	public Double getValorDerechosEmision() {
		return valorDerechosEmision;
	}

	public void setValorDerechosEmision(Double valorDerechosEmision) {
		this.valorDerechosEmision = valorDerechosEmision;
	}
}