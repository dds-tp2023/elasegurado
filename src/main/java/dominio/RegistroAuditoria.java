package dominio;

import java.io.Serializable;
import java.time.LocalDate;

import enums.AccionAuditoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="registro_auditoria")
public class RegistroAuditoria implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fecha_modificacion")
	private LocalDate fechaModificacion;
	
	@Enumerated(EnumType.STRING)
	private AccionAuditoria accion;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_usuario", referencedColumnName = "id",nullable = false)
	private Usuario usuario;
	
	public RegistroAuditoria() {}

	public RegistroAuditoria(Integer id, LocalDate fechaModificacion, AccionAuditoria accion, Usuario usuario) {
		super();
		this.id = id;
		this.fechaModificacion = fechaModificacion;
		this.accion = accion;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDate fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public AccionAuditoria getAccion() {
		return accion;
	}

	public void setAccion(AccionAuditoria accion) {
		this.accion = accion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}