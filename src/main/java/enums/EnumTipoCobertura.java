package enums;

public enum EnumTipoCobertura {
	RESP_CIVIL_ROBO_O_INCENDIO_TOTAL{
		@Override
		public String toString() {
			return "RESP. CIVIL, ROBO O INCENDIO TOTAL ";
		}
	}, 
	RESPONSABILIDAD_CIVIL{
		@Override
		public String toString() {
			return "RESPONSABILIDAD CIVIL";
		}
	}, 
	TERCEROS_COMPLETOS{
		@Override
		public String toString() {
			return "TERCEROS COMPLETOS";
		}
	},
	TODO_RIESGO_CON_FRANQUICIA{
		@Override
		public String toString() {
			return "TODO RIESGO CON FRANQUICIA";
		}
	},
	TODO_TOTAL{
		@Override
		public String toString() {
			return "TODO TOTAL";
		}
	}
}