package gestores;

public final class GestorParametroPoliza {
	private static GestorParametroPoliza instancia;
	
	private GestorParametroPoliza() {}
	
	public synchronized static GestorParametroPoliza getInstancia() {
		if(instancia == null) instancia = new GestorParametroPoliza();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}