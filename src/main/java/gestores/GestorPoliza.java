package gestores;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import dao.factory.FactoryDao;
import dao.interfaces.ClienteDao;
import dao.interfaces.GeograficoDao;
import dao.interfaces.MedidaSeguridadDao;
import dao.interfaces.ParametroPolizaDao;
import dao.interfaces.ParametroVehiculoDao;
import dao.interfaces.PolizaDao;
import dao.interfaces.TipoCoberturaDao;
import dominio.AjusteMedidaSeguridad;
import dominio.AnioFabricacion;
import dominio.Cliente;
import dominio.Cuota;
import dominio.HijoDeclarado;
import dominio.Localidad;
import dominio.MedidaSeguridad;
import dominio.Modelo;
import dominio.ParametroPoliza;
import dominio.Poliza;
import dominio.TipoCobertura;
import dto.CuotaDTO;
import dto.DatosPolizaDTO;
import dto.DescuentosDTO;
import dto.GeneracionPolizaDTO;
import dto.HijoDeclaradoDTO;
import dto.PrimaDTO;
import dto.PrimaYdescuentosDTO;
import dto.TipoCoberturaDTO;
import enums.CantidadSiniestros;
import enums.CondicionCliente;
import enums.EstadoCivil;
import enums.EstadoCuota;
import enums.EstadoPoliza;
import enums.FormaPago;
import enums.Sexo;
import excepciones.DatosNoValidosException;
import excepciones.ExistePolizaVigenteException;

public final class GestorPoliza {
	private static GestorPoliza instancia;
	private FactoryDao factory;
	private PolizaDao polizaDao;
	private ClienteDao clienteDao;
	private ParametroPolizaDao parametroPolizaDao;
	private ParametroVehiculoDao parametroVehiculoDao;
	private GeograficoDao geograficoDao;
	private MedidaSeguridadDao medidaSeguridadDao;
	private TipoCoberturaDao tipoCoberturaDao;
	
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
	
	public void generarPoliza(GeneracionPolizaDTO datos) throws DatosNoValidosException, ExistePolizaVigenteException {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		polizaDao = factory.getPolizaDao();
		clienteDao = factory.getClienteDao();
		geograficoDao = factory.getGeograficoDao();
		parametroVehiculoDao = factory.getParametroVehiculoDao();
		parametroPolizaDao = factory.getParametroPolizaDao();
		medidaSeguridadDao = factory.getMedidaSeguridadDao();
		tipoCoberturaDao = factory.getTipoCoberturaDao();
		
		boolean datosValidos = validarDatos(datos);
		if(!datosValidos) throw new DatosNoValidosException("Los datos de póliza ingresados no son válidos:\n");
		boolean existePolizaVigente = false;
		if(datos.getDatosPoliza().getPatente().equals("")) {
			existePolizaVigente = polizaDao.existePolizaVigente(null, datos.getDatosPoliza().getMotor(), datos.getDatosPoliza().getChasis());
		}else {
			existePolizaVigente = polizaDao.existePolizaVigente(datos.getDatosPoliza().getPatente(), datos.getDatosPoliza().getMotor(), datos.getDatosPoliza().getChasis());
		}
		if(existePolizaVigente) throw new ExistePolizaVigenteException("Ya existe una póliza vigente asociado a los siguiente valores:\n");
		
		Cliente cliente = clienteDao.findClienteByIdConPolizas(datos.getDatosPoliza().getIdCliente());
		if(cliente == null) {
			/**
			 * Significa que no tiene polizas asociadas
			 * Hay que saber la cantidad de polizas que tiene un cliente para actualizar su estado
			 */
			cliente = clienteDao.findClienteById(datos.getDatosPoliza().getIdCliente());
			cliente.setPoliza(new ArrayList<Poliza>());
		}
		Localidad localidad = geograficoDao.findLocalidadById(datos.getDatosPoliza().getIdLocalidad());
		Modelo modelo = parametroVehiculoDao.findModeloById(datos.getDatosPoliza().getIdModelo());
		AnioFabricacion anioFabricacion = parametroVehiculoDao.findAnioFabricacionById(datos.getDatosPoliza().getIdAnioFabricacion());
		ParametroPoliza parametroPoliza = parametroPolizaDao.findParametroPolizaByDate(LocalDate.now());
		
		List<MedidaSeguridad> medidasSeguridad = new ArrayList<MedidaSeguridad>();
		if(datos.getDatosPoliza().getMedidasSeguridad().size()!= 0) {
			for(String nombreMedidaSeguridad : datos.getDatosPoliza().getMedidasSeguridad()) {
				MedidaSeguridad medidaSeguirad = medidaSeguridadDao.findMedidaSeguridadByNombre(nombreMedidaSeguridad);
				medidasSeguridad.add(medidaSeguirad);
			}
		}
		
		TipoCobertura tipoCobetura = tipoCoberturaDao.findTipoCoberturaById(datos.getIdTipoCobertura());
		
		List<HijoDeclarado> hijosDeclarados = new ArrayList<HijoDeclarado>();
		if(datos.getDatosPoliza().getHijosDeclarados().size() != 0) {
			for(HijoDeclaradoDTO hijoDeclaradoDTO : datos.getDatosPoliza().getHijosDeclarados()) {
				HijoDeclarado h = new HijoDeclarado();
				h.setFechaNacimiento(hijoDeclaradoDTO.getFechaNacimiento());
				h.setSexo(Sexo.valueOf(hijoDeclaradoDTO.getSexo()));
				h.setEstadoCivil(EstadoCivil.valueOf(hijoDeclaradoDTO.getEstadoCivil()));
				hijosDeclarados.add(h);
			}
		}
		
		List<Cuota> cuotas = new ArrayList<Cuota>();
		for(CuotaDTO unaCuota : datos.getCuotas()) {
			Cuota c = new Cuota();
			c.setEstado(EstadoCuota.IMPAGO);
			c.setMonto(unaCuota.getMonto());
			c.setUltimoDiaPago(unaCuota.getUltimoDiaPago());
			cuotas.add(c);
		}
		
		Poliza poliza = new Poliza();
		poliza.setFechaInicioVigencia(datos.getFechaInicioVigencia());
		poliza.setFechaFinVigencia(datos.getFechaInicioVigencia().plusMonths(6));
		poliza.setFormaPago(FormaPago.valueOf(datos.getFormaPago()));
		poliza.setTipoCobertura(tipoCobetura);
		if(medidasSeguridad.size() != 0) poliza.setMedidasSeguridad(medidasSeguridad);
		poliza.setDomicilioDelRiesgo(localidad);
		poliza.setModelo(modelo);
		poliza.setAnioFabricacion(anioFabricacion);
		poliza.setParametroPoliza(parametroPoliza);
		poliza.setCuotas(cuotas);
		if(hijosDeclarados.size() != 0) poliza.setHijosDeclarados(hijosDeclarados);
		poliza.setMotor(datos.getDatosPoliza().getMotor());
		poliza.setChasis(datos.getDatosPoliza().getChasis());
		if(!datos.getDatosPoliza().getPatente().equals("")) poliza.setPatente(datos.getDatosPoliza().getPatente());
		poliza.setKmPorAnio(Integer.parseInt(datos.getDatosPoliza().getKmPorAnio()));
		poliza.setCantidadSiniestros(CantidadSiniestros.valueOf(datos.getDatosPoliza().getCantSiniestros()));
		poliza.setValorPremio(datos.getPremio());
		poliza.setValorDescuento(datos.getDescuentos());
		poliza.setCliente(cliente);
		poliza.setEstado(EstadoPoliza.GENERADA);
		String nroPoliza = generarNroPoliza(poliza);
		poliza.setNroPoliza(nroPoliza);
		cliente.addPoliza(poliza);
		actualizarCondicionCliente(cliente);
		
		polizaDao.save(poliza);
	}

	private void actualizarCondicionCliente(Cliente cliente) {
		//TODO: Consultar condicion cliente
		cliente.setCondicionCliente(CondicionCliente.NORMAL);
	}
	
	private String generarNroPoliza(Poliza poliza) {
		String numeroSucursal = "3528";
		String numeroCliente = poliza.getCliente().getNroCliente().substring(4);
		String numeroRenovacionPoliza = "00";
		
		String nroPoliza = numeroSucursal + numeroCliente + numeroRenovacionPoliza;
		
		return nroPoliza;
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
		if(generacionPoliza.getIdTipoCobertura() == null || generacionPoliza.getFechaInicioVigencia() == null ||
				generacionPoliza.getFormaPago() == null) return false;
		if(generacionPoliza.getFechaInicioVigencia()!=null) {
			Instant instant = Instant.now().plus(1, ChronoUnit.DAYS);//1 dia despues del actual
			Instant instant2 = Instant.now().plus(30, ChronoUnit.DAYS);//1 mes despues del actual
			LocalDate ld = instant.atZone(ZoneOffset.systemDefault()).toLocalDate();
			LocalDate ld2 = instant2.atZone(ZoneOffset.systemDefault()).toLocalDate();
			if(generacionPoliza.getFechaInicioVigencia().isBefore(ld)) return false;
			if(generacionPoliza.getFechaInicioVigencia().isAfter(ld2)) return false;
		}
		return true;
	}
	
	private DescuentosDTO calcularDecuentos(String formaPago, Integer idCliente, Double prima) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		parametroPolizaDao = factory.getParametroPolizaDao();
		polizaDao = factory.getPolizaDao();
		Double descuentosPagoSemestral = 0.0;
		ParametroPoliza p = parametroPolizaDao.findParametroPolizaByDate(LocalDate.now());
		if(formaPago.equals(FormaPago.SEMESTRAL.toString())) descuentosPagoSemestral = p.getDescuentoPorPagoSemestral();
		Integer cantPolizasVigentes = polizaDao.findPolizasVigentesByIdCliente(idCliente).size();
		DescuentosDTO descuentosDTO = new DescuentosDTO();
		descuentosDTO.setDescuentoPagoSemestral(prima*descuentosPagoSemestral);
		descuentosDTO.setDescuentosUnidadesAdicionales(cantPolizasVigentes*p.getDescuentoPorUnidadAdicional());
		return descuentosDTO;
	}
	
	private Double calcularDerechosDeEmision() {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		parametroPolizaDao = factory.getParametroPolizaDao();
		ParametroPoliza p = parametroPolizaDao.findParametroPolizaByDate(LocalDate.now());
		Double derechosEmision = p.getValorDerechoDeEmision();
		return derechosEmision;
	}
	
	private Double calcularPremio(Integer idLocalidad, Integer idModelo, Integer cantKmPorAnio,
		List<String> medidasSeguridad,String cantSiniestros,Integer cantHijosDeclarados	) {
		factory = FactoryDao.getFactory(FactoryDao.PG_FACTORY);
		geograficoDao = factory.getGeograficoDao();
		parametroVehiculoDao = factory.getParametroVehiculoDao();
		parametroPolizaDao = factory.getParametroPolizaDao();
		medidaSeguridadDao = factory.getMedidaSeguridadDao();
		
		ParametroPoliza parametroPoliza = parametroPolizaDao.findParametroPolizaByDate(LocalDate.now());
		
		Double porcentajeAjusteDomicilio = geograficoDao.findAjusteLocalidadVigenteByIdLocalidad(idLocalidad).getValorPorcentual();
		
		Double porcentajeAjusteModelo = parametroVehiculoDao.findAjusteModeloVigenteByIdModelo(idModelo).getValorPorcentual();
		
		Double porcentajeAjustePorCadaDiezMilKm = parametroPoliza.getPorcentajePorCadaDiezMilKm();//Usar con la cantKmPorAnio pasado por parametro
		
		Double porcentajeMedidasSeguridad = 0.0;
		for(String unaMedida : medidasSeguridad) {
			MedidaSeguridad ms = medidaSeguridadDao.findMedidaSeguridadByNombre(unaMedida);
			AjusteMedidaSeguridad ajusteMedidaSeguridad = medidaSeguridadDao.findAjusteMedidaSeguridadVigenteByIdMedidaSeguridad(ms.getId());
			porcentajeMedidasSeguridad += ajusteMedidaSeguridad.getValorPorcentual();
		}
		
		Double porcentajeCantSiniestros = 0.0;
		if(cantSiniestros.equals(CantidadSiniestros.NINGUNO.toString())) porcentajeCantSiniestros = parametroPoliza.getPorcentajeSinSiniestro();
		if(cantSiniestros.equals(CantidadSiniestros.UNO.toString())) porcentajeCantSiniestros = parametroPoliza.getPorcentajeUnSiniestro();
		if(cantSiniestros.equals(CantidadSiniestros.DOS.toString())) porcentajeCantSiniestros = parametroPoliza.getPorcentajeDosSiniestro();
		if(cantSiniestros.equals(CantidadSiniestros.MAS_DE_DOS.toString())) porcentajeCantSiniestros = parametroPoliza.getPorcentajeMasDeDosSiniestro();
		
		Double porcentajeCantHijosDeclarados = parametroPoliza.getPorcentajePorHijoRegistrado() * cantHijosDeclarados;
		
		Double premio = 60000.0;//Valor fijo de ejemplo, no hacemos un algoritmo
		
		return premio;
	}
	
	private PrimaDTO calcularPrima(Integer idLocalidad, Integer idModelo, Integer cantKmPorAnio,
			List<String> medidasSeguridad,String cantSiniestros,Integer cantHijosDeclarados) {
		Double derechosEmision = calcularDerechosDeEmision();
		Double premio = calcularPremio(idLocalidad, idModelo, cantKmPorAnio, medidasSeguridad, cantSiniestros, cantHijosDeclarados);
		PrimaDTO prima = new PrimaDTO(premio, derechosEmision);
		return prima;
	}
	
	public PrimaYdescuentosDTO calcularPrimaYdescuentos(String formaPago, Integer idCliente,Integer idLocalidad, Integer idModelo, Integer cantKmPorAnio,
			List<String> medidasSeguridad,String cantSiniestros,Integer cantHijosDeclarados) {
		PrimaDTO prima = calcularPrima(idLocalidad, idModelo, cantKmPorAnio, medidasSeguridad, cantSiniestros, cantHijosDeclarados);
		Double valorPrima = prima.getValorDerechosEmision() + prima.getValorPremio();
		DescuentosDTO descuentos = calcularDecuentos(formaPago, idCliente, valorPrima);
		PrimaYdescuentosDTO primaYdescuentos = new PrimaYdescuentosDTO(prima, descuentos);
		return primaYdescuentos;
	}
}