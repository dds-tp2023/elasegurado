package dao.interfaces;

import dominio.AjusteMedidaSeguridad;
import dominio.MedidaSeguridad;

public interface MedidaSeguridadDao {
	public abstract MedidaSeguridad findMedidaSeguridadByNombre(String nombre);
	public abstract AjusteMedidaSeguridad findAjusteMedidaSeguridadVigenteByIdMedidaSeguridad(Integer id);
}