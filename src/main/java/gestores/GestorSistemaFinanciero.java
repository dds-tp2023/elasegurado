package gestores;

public final class GestorSistemaFinanciero {
	private static GestorSistemaFinanciero instancia;
	
	private GestorSistemaFinanciero() {}
	
	public synchronized static GestorSistemaFinanciero getInstancia() {
		if(instancia == null) instancia = new GestorSistemaFinanciero();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}