package gestores;

public final class GestorReporte {
	private static GestorReporte instancia;
	
	private GestorReporte() {}
	
	public synchronized static GestorReporte getInstancia() {
		if(instancia == null) instancia = new GestorReporte();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}