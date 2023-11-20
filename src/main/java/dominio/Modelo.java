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
@Table(name="modelo")
public class Modelo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_modelo")
	private String nombreModelo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_marca", referencedColumnName = "id")
	private Marca marca;
	
	@OneToMany
	@JoinColumn(name = "id_modelo", referencedColumnName = "id", nullable = false)
	private List<SumaAsegurada> sumasAseguradas;
	
	@OneToMany
	@JoinColumn(name = "id_modelo", referencedColumnName = "id", nullable = false)
	private List<AjusteModelo> ajustes;

	public Modelo() {}

	public Modelo(Integer id, String nombreModelo, Marca marca, List<SumaAsegurada> sumasAseguradas,
			List<AjusteModelo> ajustes) {
		super();
		this.id = id;
		this.nombreModelo = nombreModelo;
		this.marca = marca;
		this.sumasAseguradas = sumasAseguradas;
		this.ajustes = ajustes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<SumaAsegurada> getSumasAseguradas() {
		return sumasAseguradas;
	}

	public void setSumasAseguradas(List<SumaAsegurada> sumasAseguradas) {
		this.sumasAseguradas = sumasAseguradas;
	}

	public List<AjusteModelo> getAjustes() {
		return ajustes;
	}

	public void setAjustes(List<AjusteModelo> ajustes) {
		this.ajustes = ajustes;
	}
}