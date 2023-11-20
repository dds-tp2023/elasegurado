package gestores;

public final class GestorPoliza {
	private static GestorPoliza instancia;
	
	private GestorPoliza() {}
	
	public synchronized static GestorPoliza getInstancia() {
		if(instancia == null) instancia = new GestorPoliza();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}