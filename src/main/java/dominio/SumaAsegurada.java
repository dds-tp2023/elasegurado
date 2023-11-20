package dominio;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="suma_asegurada")
public class SumaAsegurada implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="suma_asegurada")
	private Double sumaAsegurada;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_anio_fabricacion", referencedColumnName = "id", nullable = false)
	private AnioFabricacion anioFabricacion;

	public SumaAsegurada() {}

	public SumaAsegurada(Integer id, Double sumaAsegurada, AnioFabricacion anioFabricacion) {
		super();
		this.id = id;
		this.sumaAsegurada = sumaAsegurada;
		this.anioFabricacion = anioFabricacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public AnioFabricacion getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(AnioFabricacion anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
}