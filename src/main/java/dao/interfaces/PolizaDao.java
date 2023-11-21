package dao.interfaces;

public interface PolizaDao {
	public abstract boolean existePolizaVigente(String patente, String motor, String chasis);
}