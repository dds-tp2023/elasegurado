package dao.interfaces;

import java.time.LocalDate;

import dominio.ParametroPoliza;

public interface ParametroPolizaDao {
	public abstract ParametroPoliza findParametroPolizaByDate(LocalDate date);
}