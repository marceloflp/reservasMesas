package br.com.restaurante.reservasMesas.entities.enums;

public enum ReservaStatus {

	COMFIRMADA(1),
	PENDENTE(2),
	CANCELADA(3);
	
	private int code;
	
	private ReservaStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ReservaStatus valueOf(int code) {
		for(ReservaStatus value : ReservaStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ReservaStatus code");
	}
}
