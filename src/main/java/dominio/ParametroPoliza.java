package dominio;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="parametro_poliza")
public class ParametroPoliza implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fecha_inicio_vigencia")
	private LocalDate fechaInicioVigencia;
	
	@Column(name="fecha_fin_vigencia")
	private LocalDate fechaFinVigencia;
	
	@Column(name="porcentaje_por_cada_diez_mil_km")
	private Double porcentajePorCadaDiezMilKm;
	
	@Column(name="porcentaje_sin_siniestro")
	private Double porcentajeSinSiniestro;
	
	@Column(name="porcentaje_un_siniestro")
	private Double porcentajeUnSiniestro;
	
	@Column(name="porcentaje_dos_siniestro")
	private Double porcentajeDosSiniestro;
	
	@Column(name="porcentaje_mas_de_dos_siniestro")
	private Double porcentajeMasDeDosSiniestro;
	
	@Column(name="porcentaje_por_hijo_registrado")
	private Double porcentajePorHijoRegistrado;
	
	@Column(name="descuento_por_unidad_adicional")
	private Double descuentoPorUnidadAdicional;
	
	@Column(name="valor_derecho_de_emision")
	private Double valorDerechoDeEmision;
	
	@OneToOne
	@JoinColumn(name = "id_registro_auditoria", referencedColumnName = "id")
	private RegistroAuditoria registroAuditoria;

	public ParametroPoliza() {}

	public ParametroPoliza(Integer id, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
			Double porcentajePorCadaDiezMilKm, Double porcentajeSinSiniestro, Double porcentajeUnSiniestro,
			Double porcentajeDosSiniestro, Double porcentajeMasDeDosSiniestro, Double porcentajePorHijoRegistrado,
			Double descuentoPorUnidadAdicional, Double valorDerechoDeEmision, RegistroAuditoria registroAuditoria) {
		super();
		this.id = id;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.porcentajePorCadaDiezMilKm = porcentajePorCadaDiezMilKm;
		this.porcentajeSinSiniestro = porcentajeSinSiniestro;
		this.porcentajeUnSiniestro = porcentajeUnSiniestro;
		this.porcentajeDosSiniestro = porcentajeDosSiniestro;
		this.porcentajeMasDeDosSiniestro = porcentajeMasDeDosSiniestro;
		this.porcentajePorHijoRegistrado = porcentajePorHijoRegistrado;
		this.descuentoPorUnidadAdicional = descuentoPorUnidadAdicional;
		this.valorDerechoDeEmision = valorDerechoDeEmision;
		this.registroAuditoria = registroAuditoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getPorcentajePorCadaDiezMilKm() {
		return porcentajePorCadaDiezMilKm;
	}

	public void setPorcentajePorCadaDiezMilKm(Double porcentajePorCadaDiezMilKm) {
		this.porcentajePorCadaDiezMilKm = porcentajePorCadaDiezMilKm;
	}

	public Double getPorcentajeSinSiniestro() {
		return porcentajeSinSiniestro;
	}

	public void setPorcentajeSinSiniestro(Double porcentajeSinSiniestro) {
		this.porcentajeSinSiniestro = porcentajeSinSiniestro;
	}

	public Double getPorcentajeUnSiniestro() {
		return porcentajeUnSiniestro;
	}

	public void setPorcentajeUnSiniestro(Double porcentajeUnSiniestro) {
		this.porcentajeUnSiniestro = porcentajeUnSiniestro;
	}

	public Double getPorcentajeDosSiniestro() {
		return porcentajeDosSiniestro;
	}

	public void setPorcentajeDosSiniestro(Double porcentajeDosSiniestro) {
		this.porcentajeDosSiniestro = porcentajeDosSiniestro;
	}

	public Double getPorcentajeMasDeDosSiniestro() {
		return porcentajeMasDeDosSiniestro;
	}

	public void setPorcentajeMasDeDosSiniestro(Double porcentajeMasDeDosSiniestro) {
		this.porcentajeMasDeDosSiniestro = porcentajeMasDeDosSiniestro;
	}

	public Double getPorcentajePorHijoRegistrado() {
		return porcentajePorHijoRegistrado;
	}

	public void setPorcentajePorHijoRegistrado(Double porcentajePorHijoRegistrado) {
		this.porcentajePorHijoRegistrado = porcentajePorHijoRegistrado;
	}

	public Double getDescuentoPorUnidadAdicional() {
		return descuentoPorUnidadAdicional;
	}

	public void setDescuentoPorUnidadAdicional(Double descuentoPorUnidadAdicional) {
		this.descuentoPorUnidadAdicional = descuentoPorUnidadAdicional;
	}

	public Double getValorDerechoDeEmision() {
		return valorDerechoDeEmision;
	}

	public void setValorDerechoDeEmision(Double valorDerechoDeEmision) {
		this.valorDerechoDeEmision = valorDerechoDeEmision;
	}

	public RegistroAuditoria getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}
}