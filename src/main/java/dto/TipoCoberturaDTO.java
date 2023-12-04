package dto;

public class TipoCoberturaDTO {
	private Integer id;
	private String nombre;
	private AjusteTipoCoberturaDTO ajuste;

	public TipoCoberturaDTO() {}

	public TipoCoberturaDTO(Integer id, String nombre, AjusteTipoCoberturaDTO ajuste) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ajuste = ajuste;
	}

	
	
	public TipoCoberturaDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AjusteTipoCoberturaDTO getAjuste() {
		return ajuste;
	}

	public void setAjuste(AjusteTipoCoberturaDTO ajuste) {
		this.ajuste = ajuste;
	}

	@Override
	public String toString() {
		return nombre.toString();
	}
}