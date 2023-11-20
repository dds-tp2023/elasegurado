package dominio;

import java.io.Serializable;
import java.time.LocalDate;

import enums.EstadoCuota;
import enums.EstadoPagoCuota;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuota")
public class Cuota implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nro_cuota")
	private Integer nroCuota;
	
	private Double monto;
	
	@Column(name="ultimo_dia_de_pago")
	private LocalDate ultimoDiaPago;
	
	@Enumerated(EnumType.STRING)
	private EstadoCuota estado;
	
	@Column(name="bonificacion_pago_adelantado")
	private Double bonificacionPagoAdelantado;
	
	@Column(name="recargo_mora")
	private Double recargoMora;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_pago_cuota")
	private EstadoPagoCuota estadoPagoCuota;
	
	@Column(name="mes_abonado")
	private String mesAbonado;
	
	@Column(name="anio_abonado")
	private String anioAbonado;

	public Cuota() {}

	public Cuota(Integer id, Integer nroCuota, Double monto, LocalDate ultimoDiaPago, EstadoCuota estado,
			Double bonificacionPagoAdelantado, Double recargoMora, EstadoPagoCuota estadoPagoCuota, String mesAbonado,
			String anioAbonado) {
		super();
		this.id = id;
		this.nroCuota = nroCuota;
		this.monto = monto;
		this.ultimoDiaPago = ultimoDiaPago;
		this.estado = estado;
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
		this.recargoMora = recargoMora;
		this.estadoPagoCuota = estadoPagoCuota;
		this.mesAbonado = mesAbonado;
		this.anioAbonado = anioAbonado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDate getUltimoDiaPago() {
		return ultimoDiaPago;
	}

	public void setUltimoDiaPago(LocalDate ultimoDiaPago) {
		this.ultimoDiaPago = ultimoDiaPago;
	}

	public EstadoCuota getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuota estado) {
		this.estado = estado;
	}

	public Double getBonificacionPagoAdelantado() {
		return bonificacionPagoAdelantado;
	}

	public void setBonificacionPagoAdelantado(Double bonificacionPagoAdelantado) {
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
	}

	public Double getRecargoMora() {
		return recargoMora;
	}

	public void setRecargoMora(Double recargoMora) {
		this.recargoMora = recargoMora;
	}

	public EstadoPagoCuota getEstadoPagoCuota() {
		return estadoPagoCuota;
	}

	public void setEstadoPagoCuota(EstadoPagoCuota estadoPagoCuota) {
		this.estadoPagoCuota = estadoPagoCuota;
	}

	public String getMesAbonado() {
		return mesAbonado;
	}

	public void setMesAbonado(String mesAbonado) {
		this.mesAbonado = mesAbonado;
	}

	public String getAnioAbonado() {
		return anioAbonado;
	}

	public void setAnioAbonado(String anioAbonado) {
		this.anioAbonado = anioAbonado;
	}
}