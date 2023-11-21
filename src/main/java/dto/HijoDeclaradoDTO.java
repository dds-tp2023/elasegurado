package dto;

import java.time.LocalDate;

public class HijoDeclaradoDTO {
	private LocalDate fechaNacimiento;
	private Integer idSexo;
	private Integer idEstadoCivil;
	
	public HijoDeclaradoDTO() {}

	public HijoDeclaradoDTO(LocalDate fechaNacimiento, Integer idSexo, Integer idEstadoCivil) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.idSexo = idSexo;
		this.idEstadoCivil = idEstadoCivil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}

	public Integer getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}
}