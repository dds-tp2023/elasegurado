package dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name="pago")
public class Pago implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nro_poliza")
	private String nroPoliza;
	
	@Column(name="nro_recibo")
	private String nroRecibo;
	
	@Column(name="fecha_hora")
	private LocalDateTime fechaHora;
	
	private Double importe;
	
	private Double vuelto;
	
	@OneToMany
	@JoinColumn(name = "id_pago", referencedColumnName = "id")
	private List<Cuota> cuotas;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	public Pago() {}

	public Pago(Integer id, String nroPoliza, String nroRecibo, LocalDateTime fechaHora, Double importe, Double vuelto,
			List<Cuota> cuotas, Usuario usuario) {
		super();
		this.id = id;
		this.nroPoliza = nroPoliza;
		this.nroRecibo = nroRecibo;
		this.fechaHora = fechaHora;
		this.importe = importe;
		this.vuelto = vuelto;
		this.cuotas = cuotas;
		this.usuario = usuario;
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

	public String getNroRecibo() {
		return nroRecibo;
	}

	public void setNroRecibo(String nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Double getVuelto() {
		return vuelto;
	}

	public void setVuelto(Double vuelto) {
		this.vuelto = vuelto;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}