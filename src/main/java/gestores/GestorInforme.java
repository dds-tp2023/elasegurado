package gestores;

public final class GestorInforme {
	private static GestorInforme instancia;
	
	private GestorInforme() {}
	
	public synchronized static GestorInforme getInstancia() {
		if(instancia == null) instancia = new GestorInforme();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}