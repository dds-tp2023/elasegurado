package dao;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dao.interfaces.ParametroPolizaDao;
import dao.interfaces.implementaciones.ParametroPolizaPGDao;
import dominio.ParametroPoliza;

public class ParametroPolizaPGDaoTest {
	@Test
	void findParametroPolizaByDate() {
		ParametroPolizaDao dao = new ParametroPolizaPGDao();
		ParametroPoliza p = dao.findParametroPolizaByDate(LocalDate.now());
		System.out.println("ID:"+p.getId());
		System.out.println("Fecha Inicio Vigencia:"+p.getFechaInicioVigencia());
		System.out.println("Fecha Fin Vigencia:"+p.getFechaFinVigencia());
	}
}