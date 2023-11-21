package dto;

public class AjusteModeloDTO {
	private Integer id;
	private Double valorPorcentual;

	public AjusteModeloDTO() {}

	public AjusteModeloDTO(Integer id, Double valorPorcentual) {
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