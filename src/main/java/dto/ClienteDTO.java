package dto;

public class ClienteDTO {
	private Integer id;
	private String nroCliente;
	private String apellido;
	private String nombre;
	private String tipoDocumento;
	private String documento;
	private String pais;
	private String provincia;
	private String localidad;
	private String codigoPostal;
	private String calle;
	private String numero;
	private String dpto;
	private String piso;
	
	public ClienteDTO() {}

	public ClienteDTO(Integer id, String nroCliente, String apellido, String nombre, String tipoDocumento,
			String documento, String pais, String provincia, String localidad, String codigoPostal, String calle,
			String numero, String dpto, String piso) {
		super();
		this.id = id;
		this.nroCliente = nroCliente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
		this.calle = calle;
		this.numero = numero;
		this.dpto = dpto;
		this.piso = piso;
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDpto() {
		return dpto;
	}

	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}
}