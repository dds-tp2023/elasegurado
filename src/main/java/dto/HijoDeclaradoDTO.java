package dto;

import java.time.LocalDate;

public class HijoDeclaradoDTO {
	private LocalDate fechaNacimiento;
	private String sexo;
	private String estadoCivil;
	
	public HijoDeclaradoDTO() {}

	public HijoDeclaradoDTO(LocalDate fechaNacimiento, String sexo, String estadoCivil) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}