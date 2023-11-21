package dto;

public class AjusteTipoCoberturaDTO {
	private Integer id;
	private Double valorPorcentual;
	
	public AjusteTipoCoberturaDTO() {}

	public AjusteTipoCoberturaDTO(Integer id, Double valorPorcentual) {
		super();
		this.id = id;
		this.valorPorcentual = valorPorcentual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorPorcentual() {
		return valorPorcentual;
	}

	public void setValorPorcentual(Double valorPorcentual) {
		this.valorPorcentual = valorPorcentual;
	}
}
