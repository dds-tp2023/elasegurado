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
@Table(name="provincia")
public class Provincia implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_provincia")
	private String nombreProvincia;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pais", referencedColumnName = "id")
	private Pais pais;
	
	@OneToMany(mappedBy = "provincia")
	private List<Localidad> localidades;
	
	public Provincia() {}

	public Provincia(Integer id, String nombreProvincia, Pais pais, List<Localidad> localidades) {
		super();
		this.id = id;
		this.nombreProvincia = nombreProvincia;
		this.pais = pais;
		this.localidades = localidades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
}