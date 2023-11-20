package dominio;

import java.io.Serializable;
import java.util.List;

import enums.EnumTipoCobertura;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_cobertura")
public class TipoCobertura implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private EnumTipoCobertura nombre;
	
	@OneToMany
	@JoinColumn(name = "id_tipo_cobertura", referencedColumnName = "id", nullable = false)
	private List<AjusteTipoCobertura> ajustes;

	public TipoCobertura() {}

	public TipoCobertura(Integer id, EnumTipoCobertura nombre, List<AjusteTipoCobertura> ajustes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ajustes = ajustes;
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

	public List<AjusteTipoCobertura> getAjustes() {
		return ajustes;
	}

	public void setAjustes(List<AjusteTipoCobertura> ajustes) {
		this.ajustes = ajustes;
	}
}