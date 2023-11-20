package dominio;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="medida_seguridad")
public class MedidaSeguridad implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id_medida_seguridad", referencedColumnName = "id", nullable = false)
	private List<AjusteMedidaSeguridad> ajustes;

	public MedidaSeguridad() {}

	public MedidaSeguridad(Integer id, String nombre, List<AjusteMedidaSeguridad> ajustes) {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AjusteMedidaSeguridad> getAjustes() {
		return ajustes;
	}

	public void setAjustes(List<AjusteMedidaSeguridad> ajustes) {
		this.ajustes = ajustes;
	}
}