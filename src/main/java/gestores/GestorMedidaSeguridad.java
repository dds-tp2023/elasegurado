package gestores;

public final class GestorMedidaSeguridad {
	private static GestorMedidaSeguridad instancia;
	
	private GestorMedidaSeguridad() {}
	
	public synchronized static GestorMedidaSeguridad getInstancia() {
		if(instancia == null) instancia = new GestorMedidaSeguridad();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}