package enums;

public enum CantidadSiniestros {
	NINGUNO, 
	UNO, 
	DOS, 
	MAS_DE_DOS {
		@Override
		public String toString() {
			return "MÁS DE DOS";
		}
	}
}