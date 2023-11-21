package dto;

import enums.EnumTipoCobertura;

public class TipoCoberturaDTO {
	private Integer id;
	private EnumTipoCobertura nombre;
	private AjusteTipoCoberturaDTO ajuste;

	public TipoCoberturaDTO() {}

	public TipoCoberturaDTO(Integer id, EnumTipoCobertura nombre, AjusteTipoCoberturaDTO ajuste) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ajuste = ajuste;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnumTipoCobertura getNombre() {
		return nombre;
	}

	public void setNombre(EnumTipoCobertura nombre) {
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