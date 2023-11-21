package enums;

public enum CondicionIVA { 
	CONSUMIDOR_FINAL{
		@Override
		public String toString() {
			return "CONSUMIDOR FINAL";
		}
	}, 
	RESPONSABLE_INSCRIPTO{
		@Override
		public String toString() {
			return "RESPONSABLE INSCRIPTO";
		}
	}, 
	SUJETO_EXENTO{
		@Override
		public String toString() {
			return "SUJETO EXENTO";
		}
	};
}