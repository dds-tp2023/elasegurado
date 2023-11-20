package gestores;

public final class GestorPago {
	private static GestorPago instancia;
	
	private GestorPago() {}
	
	public synchronized static GestorPago getInstancia() {
		if(instancia == null) instancia = new GestorPago();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}