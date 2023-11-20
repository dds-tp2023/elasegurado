package gestores;

public final class GestorParametroVehiculo {
	private static GestorParametroVehiculo instancia;
	
	private GestorParametroVehiculo() {}
	
	public synchronized static GestorParametroVehiculo getInstancia() {
		if(instancia == null) instancia = new GestorParametroVehiculo();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}