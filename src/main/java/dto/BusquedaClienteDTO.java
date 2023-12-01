package dto;

public class BusquedaClienteDTO {
	private String nroCliente;
	private String apellido;
	private String nombre;
	private String tipoDocumento;
	private String documento;
	
	
	public BusquedaClienteDTO() {}


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
	
	
}
