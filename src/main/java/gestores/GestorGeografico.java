package gestores;

public final class GestorGeografico {
	private static GestorGeografico instancia;
	
	private GestorGeografico() {}
	
	public synchronized static GestorGeografico getInstancia() {
		if(instancia == null) instancia = new GestorGeografico();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}