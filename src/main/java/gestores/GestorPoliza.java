package gestores;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import dao.factory.FactoryDao;
import dao.interfaces.PolizaDao;
import dto.DatosPolizaDTO;
import dto.GeneracionPolizaDTO;
import dto.HijoDeclaradoDTO;
import excepciones.DatosNoValidosException;
import excepciones.ExistePolizaVigenteException;

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
	
	public boolean confirmarDatosPoliza(DatosPolizaDTO datos) throws DatosNoValidosException, ExistePolizaVigenteException {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		polizaDao = factory.getPolizaDao();
		boolean datosValidos = validarDatos(datos);
		if(!datosValidos) throw new DatosNoValidosException("Los datos de póliza ingresados no son válidos:\n");
		boolean existePolizaVigente = false;
		if(datos.getPatente().equals("")) {
			existePolizaVigente = polizaDao.existePolizaVigente(null, datos.getMotor(), datos.getChasis());
		}else {
			existePolizaVigente = polizaDao.existePolizaVigente(datos.getPatente(), datos.getMotor(), datos.getChasis());
		}
		if(existePolizaVigente) throw new ExistePolizaVigenteException("Ya existe una póliza vigente asociado a los siguiente valores:\n");
		return true;
	}
	
	private boolean validarDatos(DatosPolizaDTO datos) {
		if(datos.getIdCliente()==null || datos.getIdLocalidad()==null || datos.getIdModelo()==null ||
				datos.getIdAnioFabricacion()==null || datos.getMotor().equals("") || datos.getChasis().equals("") ||
				datos.getKmPorAnio().equals("")) {
			return false;
		}if(datos.getMotor().length()>20 || datos.getChasis().length()>50 || datos.getPatente().length()>20 ||
				datos.getKmPorAnio().length()>9) {
			return false;
		}
		for(HijoDeclaradoDTO h : datos.getHijosDeclarados()) {
			long anios = ChronoUnit.YEARS.between(h.getFechaNacimiento(), LocalDate.now());
			if(anios < 18 || anios > 30) return false;
		}
		try {
			int numero = Integer.parseInt(datos.getKmPorAnio());
            // Verifica que el número sea no negativo
            return numero >= 0;
		}catch (NumberFormatException e) {
            // Si ocurre una excepción, el string no es un número entero
            return false;
        }
	}
	
	private boolean validarDatos(GeneracionPolizaDTO generacionPoliza) {
		if(!validarDatos(generacionPoliza.getDatosPoliza())) return false;
		if(generacionPoliza.getTipoCobertura() == null || generacionPoliza.getFechaInicioVigencia() == null ||
				generacionPoliza.getFormaPago() == null) return false;
		if(generacionPoliza.getFechaInicioVigencia()!=null) {
			Instant instant = Instant.now().plus(1, ChronoUnit.DAYS);//1 dia despues del actual
			Instant instant2 = Instant.now().plus(1, ChronoUnit.MONTHS);//1 mes despues del actual
			LocalDate ld = instant.atZone(ZoneOffset.systemDefault()).toLocalDate();
			LocalDate ld2 = instant2.atZone(ZoneOffset.systemDefault()).toLocalDate();
			if(generacionPoliza.getFechaInicioVigencia().isBefore(ld)) return false;
			if(generacionPoliza.getFechaInicioVigencia().isBefore(ld2)) return false;
		}
		return true;
	}
}