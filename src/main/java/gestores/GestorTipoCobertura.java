package gestores;

public final class GestorTipoCobertura {
	private static GestorTipoCobertura instancia;
	
	private GestorTipoCobertura() {}
	
	public synchronized static GestorTipoCobertura getInstancia() {
		if(instancia == null) instancia = new GestorTipoCobertura();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}