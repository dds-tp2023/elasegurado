package gestores;

public final class GestorRegistroAuditoria {
	private static GestorRegistroAuditoria instancia;
	
	private GestorRegistroAuditoria() {}
	
	public synchronized static GestorRegistroAuditoria getInstancia() {
		if(instancia == null) instancia = new GestorRegistroAuditoria();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}