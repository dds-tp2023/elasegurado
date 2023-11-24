package dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.CondicionCliente;
import enums.CondicionIVA;
import enums.EstadoCivil;
import enums.Sexo;
import enums.TipoDocumento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nro_cliente")
	private String nroCliente;
	
	private String apellido;
	
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_documento")
	private TipoDocumento tipoDocumento;
	
	@Column(name="nro_documento")
	private String nroDocumento;
	
	private String cuil;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="condicion_de_iva")
	private CondicionIVA condicionDeIva;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_civil")
	private EstadoCivil estadoCivil;
	
	private String profesion;
	
	@Column(name="anio_registro")
	private LocalDate anioRegistro;
	
	@Enumerated(EnumType.STRING)
	@Column(name="condicion")
	private CondicionCliente condicionCliente;
	
	private Boolean eliminado;
	
	@OneToMany(mappedBy="cliente",cascade = CascadeType.ALL)
	private List<Poliza> poliza;
	
	@OneToOne(cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name="id_direccion", referencedColumnName = "id")
	private Direccion direccion;
	
	public Cliente() {}

	public Cliente(Integer id, String nroCliente, String apellido, String nombre, TipoDocumento tipoDocumento,
			String nroDocumento, String cuil, Sexo sexo, LocalDate fechaNacimiento, CondicionIVA condicionDeIva,
			String email, EstadoCivil estadoCivil, String profesion, LocalDate anioRegistro,
			CondicionCliente condicionCliente, Boolean eliminado, List<Poliza> poliza, Direccion direccion) {
		super();
		this.id = id;
		this.nroCliente = nroCliente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.cuil = cuil;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.condicionDeIva = condicionDeIva;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.profesion = profesion;
		this.anioRegistro = anioRegistro;
		this.condicionCliente = condicionCliente;
		this.eliminado = eliminado;
		this.poliza = poliza;
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CondicionIVA getCondicionDeIva() {
		return condicionDeIva;
	}

	public void setCondicionDeIva(CondicionIVA condicionDeIva) {
		this.condicionDeIva = condicionDeIva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public LocalDate getAnioRegistro() {
		return anioRegistro;
	}

	public void setAnioRegistro(LocalDate anioRegistro) {
		this.anioRegistro = anioRegistro;
	}

	public CondicionCliente getCondicionCliente() {
		return condicionCliente;
	}

	public void setCondicionCliente(CondicionCliente condicionCliente) {
		this.condicionCliente = condicionCliente;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public List<Poliza> getPoliza() {
		return poliza;
	}

	public void setPoliza(List<Poliza> poliza) {
		this.poliza = poliza;
	}
	
	public void addPoliza(Poliza p) {
		this.poliza.add(p);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}