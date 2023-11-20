package gestores;

public final class GestorSubsistemaSiniestro {
	private static GestorSubsistemaSiniestro instancia;
	
	private GestorSubsistemaSiniestro() {}
	
	public synchronized static GestorSubsistemaSiniestro getInstancia() {
		if(instancia == null) instancia = new GestorSubsistemaSiniestro();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}