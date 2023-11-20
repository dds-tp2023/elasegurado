package dominio;

import java.io.Serializable;
import java.util.List;

import enums.CantidadSiniestros;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="solicitud_poliza")
public class SolicitudPoliza implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nro_solicitud_poliza")
	private String nroSolicitudPoliza;
	
	private String motor;
	
	private String chasis;
	
	private String patente;
	
	@Column(name="km_por_anio")
	private Integer kmPorAnio;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cantidad_siniestros")
	private CantidadSiniestros cantidadSiniestros;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_solicitud_poliza", referencedColumnName = "id")
	private List<HijoDeclarado> hijosDeclarados;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_modelo", referencedColumnName = "id", nullable = false)
	private Modelo modelo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_anio_fabricacion", referencedColumnName = "id", nullable = false)
	private AnioFabricacion anioFabricacion;
	
	@ManyToMany
	@JoinTable(
			name = "asociado_a",
			joinColumns = @JoinColumn(name = "id_solicitud_poliza", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_medida_seguridad", referencedColumnName = "id")
	)
	private List<MedidaSeguridad> medidasSeguridad;
	
	@OneToOne
	@JoinColumn(name = "id_registro_auditoria", referencedColumnName = "id")
	private RegistroAuditoria registroAuditoria;

	public SolicitudPoliza() {}

	public SolicitudPoliza(Integer id, String nroSolicitudPoliza, String motor, String chasis, String patente,
			Integer kmPorAnio, CantidadSiniestros cantidadSiniestros, List<HijoDeclarado> hijosDeclarados,
			Modelo modelo, AnioFabricacion anioFabricacion, List<MedidaSeguridad> medidasSeguridad,
			RegistroAuditoria registroAuditoria) {
		super();
		this.id = id;
		this.nroSolicitudPoliza = nroSolicitudPoliza;
		this.motor = motor;
		this.chasis = chasis;
		this.patente = patente;
		this.kmPorAnio = kmPorAnio;
		this.cantidadSiniestros = cantidadSiniestros;
		this.hijosDeclarados = hijosDeclarados;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.medidasSeguridad = medidasSeguridad;
		this.registroAuditoria = registroAuditoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroSolicitudPoliza() {
		return nroSolicitudPoliza;
	}

	public void setNroSolicitudPoliza(String nroSolicitudPoliza) {
		this.nroSolicitudPoliza = nroSolicitudPoliza;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getKmPorAnio() {
		return kmPorAnio;
	}

	public void setKmPorAnio(Integer kmPorAnio) {
		this.kmPorAnio = kmPorAnio;
	}

	public CantidadSiniestros getCantidadSiniestros() {
		return cantidadSiniestros;
	}

	public void setCantidadSiniestros(CantidadSiniestros cantidadSiniestros) {
		this.cantidadSiniestros = cantidadSiniestros;
	}

	public List<HijoDeclarado> getHijosDeclarados() {
		return hijosDeclarados;
	}

	public void setHijosDeclarados(List<HijoDeclarado> hijosDeclarados) {
		this.hijosDeclarados = hijosDeclarados;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public AnioFabricacion getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(AnioFabricacion anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public List<MedidaSeguridad> getMedidasSeguridad() {
		return medidasSeguridad;
	}

	public void setMedidasSeguridad(List<MedidaSeguridad> medidasSeguridad) {
		this.medidasSeguridad = medidasSeguridad;
	}

	public RegistroAuditoria getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}
}