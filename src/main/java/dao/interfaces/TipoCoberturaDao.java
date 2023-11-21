package dao.interfaces;

import dominio.TipoCobertura;

public interface TipoCoberturaDao {
	public abstract TipoCobertura findTipoCoberturaById(Integer id);
}