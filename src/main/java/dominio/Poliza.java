package dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import enums.CantidadSiniestros;
import enums.EstadoPoliza;
import enums.FormaPago;
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
import jakarta.persistence.Table;

@Entity
@Table(name="poliza")
public class Poliza implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nro_poliza")
	private String nroPoliza;
	
	@Column(name="fecha_inicio_vigencia")
	private LocalDate fechaInicioVigencia;
	
	@Column(name="fecha_fin_vigencia")
	private LocalDate fechaFinVigencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pago")
	private FormaPago formaPago;
	
	@Enumerated(EnumType.STRING)
	private EstadoPoliza estado;
	
	private String motor;
	
	private String chasis;

	private String patente;
	
	@Column(name="km_por_anio")
	private Integer kmPorAnio;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cantidad_siniestros")
	private CantidadSiniestros cantidadSiniestros;
	
	@Column(name="valor_premio")
	private Double valorPremio;
	
	@Column(name="valor_descuento")
	private Double valorDescuento;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_poliza", referencedColumnName = "id")
	private List<Cuota> cuotas;
	
	@ManyToMany
	@JoinTable(
			name = "posee",
			joinColumns = @JoinColumn(name = "id_poliza", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_medida_seguridad", referencedColumnName = "id")
	)
	private List<MedidaSeguridad> medidasSeguridad;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_modelo", referencedColumnName = "id", nullable = false)
	private Modelo modelo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_anio_fabricacion", referencedColumnName = "id", nullable = false)
	private AnioFabricacion anioFabricacion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_poliza", referencedColumnName = "id", nullable = false)
	private List<HijoDeclarado> hijosDeclarados;
	
	@OneToMany
	@JoinColumn(name = "id_poliza", referencedColumnName = "id", nullable = false)
	private List<SolicitudPoliza> solicitudesPoliza;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_localidad", referencedColumnName = "id", nullable = false)
	private Localidad domicilioDelRiesgo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_cobertura", referencedColumnName = "id", nullable = false)
	private TipoCobertura tipoCobertura;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_parametro_poliza", referencedColumnName = "id", nullable = false)
	private ParametroPoliza parametroPoliza;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="id_cliente", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	public Poliza() {}

	public Poliza(Integer id, String nroPoliza, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
			FormaPago formaPago, EstadoPoliza estado, String motor, String chasis, String patente, Integer kmPorAnio,
			CantidadSiniestros cantidadSiniestros, Double valorPremio, Double valorDescuento, List<Cuota> cuotas,
			List<MedidaSeguridad> medidasSeguridad, Modelo modelo, AnioFabricacion anioFabricacion,
			List<HijoDeclarado> hijosDeclarados, List<SolicitudPoliza> solicitudesPoliza, Localidad domicilioDelRiesgo,
			TipoCobertura tipoCobertura, ParametroPoliza parametroPoliza, Cliente cliente) {
		super();
		this.id = id;
		this.nroPoliza = nroPoliza;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.formaPago = formaPago;
		this.estado = estado;
		this.motor = motor;
		this.chasis = chasis;
		this.patente = patente;
		this.kmPorAnio = kmPorAnio;
		this.cantidadSiniestros = cantidadSiniestros;
		this.valorPremio = valorPremio;
		this.valorDescuento = valorDescuento;
		this.cuotas = cuotas;
		this.medidasSeguridad = medidasSeguridad;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.hijosDeclarados = hijosDeclarados;
		this.solicitudesPoliza = solicitudesPoliza;
		this.domicilioDelRiesgo = domicilioDelRiesgo;
		this.tipoCobertura = tipoCobertura;
		this.parametroPoliza = parametroPoliza;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroPoliza() {
		return nroPoliza;
	}

	public void setNroPoliza(String nroPoliza) {
		this.nroPoliza = nroPoliza;
	}

	public LocalDate getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(LocalDate fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public LocalDate getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(LocalDate fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public EstadoPoliza getEstado() {
		return estado;
	}

	public void setEstado(EstadoPoliza estado) {
		this.estado = estado;
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

	public Double getValorPremio() {
		return valorPremio;
	}

	public void setValorPremio(Double valorPremio) {
		this.valorPremio = valorPremio;
	}

	public Double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public List<MedidaSeguridad> getMedidasSeguridad() {
		return medidasSeguridad;
	}

	public void setMedidasSeguridad(List<MedidaSeguridad> medidasSeguridad) {
		this.medidasSeguridad = medidasSeguridad;
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

	public List<HijoDeclarado> getHijosDeclarados() {
		return hijosDeclarados;
	}

	public void setHijosDeclarados(List<HijoDeclarado> hijosDeclarados) {
		this.hijosDeclarados = hijosDeclarados;
	}

	public List<SolicitudPoliza> getSolicitudesPoliza() {
		return solicitudesPoliza;
	}

	public void setSolicitudesPoliza(List<SolicitudPoliza> solicitudesPoliza) {
		this.solicitudesPoliza = solicitudesPoliza;
	}

	public Localidad getDomicilioDelRiesgo() {
		return domicilioDelRiesgo;
	}

	public void setDomicilioDelRiesgo(Localidad domicilioDelRiesgo) {
		this.domicilioDelRiesgo = domicilioDelRiesgo;
	}

	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public ParametroPoliza getParametroPoliza() {
		return parametroPoliza;
	}

	public void setParametroPoliza(ParametroPoliza parametroPoliza) {
		this.parametroPoliza = parametroPoliza;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}