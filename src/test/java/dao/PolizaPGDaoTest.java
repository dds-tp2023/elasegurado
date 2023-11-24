package dao;

import org.junit.jupiter.api.Test;

import dao.interfaces.PolizaDao;
import dao.interfaces.implementaciones.PolizaPGDao;

public class PolizaPGDaoTest {

	@Test
	public void getPoliza() {
		PolizaDao polizaDao = new PolizaPGDao();
		boolean existePoliza = polizaDao.existePolizaVigente(null, "abcde12345", "qwert6789");
		System.out.println(existePoliza);
	}
}