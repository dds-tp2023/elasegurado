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
@Table(name = "ajuste_localidad")
public class AjusteLocalidad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fecha_inicio_vigencia")
	private LocalDate fechaInicioVigencia;
	
	@Column(name="fecha_fin_vigencia")
	private LocalDate fechaFinVigencia;
	
	@Column(name="valor_porcentual")
	private Double valorPorcentual;
	
	@OneToOne
	@JoinColumn(name="id_registro_auditoria", referencedColumnName = "id")
	private RegistroAuditoria registroAuditoria;
	
	public AjusteLocalidad() {}
	
	public AjusteLocalidad(Integer id, LocalDate fechaInicioVigencia, LocalDate fechaFinVigencia,
			Double valorPorcentual, RegistroAuditoria registroAuditoria) {
		super();
		this.id = id;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.valorPorcentual = valorPorcentual;
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

	public Double getValorPorcentual() {
		return valorPorcentual;
	}

	public void setValorPorcentual(Double valorPorcentual) {
		this.valorPorcentual = valorPorcentual;
	}

	public RegistroAuditoria getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoria registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}
}