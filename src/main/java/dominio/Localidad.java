package dominio;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="localidad")
public class Localidad implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_localidad")
	private String nombreLocalidad;
	
	@Column(name="codigo_postal")
	private String codigoPostal;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_provincia", referencedColumnName = "id")
	private Provincia provincia;
	
	@OneToMany
	@JoinColumn(name = "id_localidad", referencedColumnName = "id")
	private List<AjusteLocalidad> ajustes;
	
	public Localidad() {}

	public Localidad(Integer id, String nombreLocalidad, String codigoPostal, Provincia provincia,
			List<AjusteLocalidad> ajustes) {
		super();
		this.id = id;
		this.nombreLocalidad = nombreLocalidad;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.ajustes = ajustes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<AjusteLocalidad> getAjustes() {
		return ajustes;
	}

	public void setAjustes(List<AjusteLocalidad> ajustes) {
		this.ajustes = ajustes;
	}
}