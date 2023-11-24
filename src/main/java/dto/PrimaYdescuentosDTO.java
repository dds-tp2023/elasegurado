package dto;

public class PrimaYdescuentosDTO {
	private PrimaDTO prima;
	private DescuentosDTO descuentos;
	
	public PrimaYdescuentosDTO(PrimaDTO prima, DescuentosDTO descuentos) {
		super();
		this.prima = prima;
		this.descuentos = descuentos;
	}

	public PrimaDTO getPrima() {
		return prima;
	}

	public void setPrima(PrimaDTO prima) {
		this.prima = prima;
	}

	public DescuentosDTO getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(DescuentosDTO descuentos) {
		this.descuentos = descuentos;
	}
}