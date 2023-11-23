package dao.interfaces;

import java.util.List;

import dominio.AjusteTipoCobertura;
import dominio.TipoCobertura;

public interface TipoCoberturaDao {
	public abstract TipoCobertura findTipoCoberturaById(Integer id);

	public abstract List<TipoCobertura> findAllTiposCobertura();

	public abstract AjusteTipoCobertura findAjusteTipoCoberturaVigenteByIdTipoCobertura(Integer id);
}