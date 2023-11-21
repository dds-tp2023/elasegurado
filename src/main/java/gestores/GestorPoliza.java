package gestores;

import java.time.Duration;
import java.time.LocalDate;

import dao.factory.FactoryDao;
import dao.interfaces.PolizaDao;
import dto.DatosPolizaDTO;
import dto.HijoDeclaradoDTO;

public final class GestorPoliza {
	private static GestorPoliza instancia;
	private FactoryDao factory;
	private PolizaDao polizaDao;
	
	private GestorPoliza() {}
	
	public synchronized static GestorPoliza getInstancia() {
		if(instancia == null) instancia = new GestorPoliza();
		return instancia;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private boolean validarDatos(DatosPolizaDTO datos) {
		if(datos.getIdCliente()==null || datos.getIdLocalidad()==null || datos.getIdModelo()==null ||
				datos.getIdAnioFabricacion()==null || datos.getMotor().equals("") || datos.getChasis().equals("") ||
				datos.getKmPorAnio()==null) {
			return false;
		}if(datos.getMotor().length()>20 || datos.getChasis().length()>50 || datos.getPatente().length()>20 ||
				datos.getKmPorAnio().length()>9) {
			return false;
		}
		for(HijoDeclaradoDTO h : datos.getHijosDeclarados()) {
			/*if() return false;
			 * 
			 * Dentro del if hacer una diferencia entre .now() y fechaNacimiento
			 * Si no esta entre 18 y 30 años return false
			 * Comparar por dias
			 */
		}
		return true;
	}
}