package co.edu.unbosque.model;

public class ViviendaDTO {
	private int identificadorVivienda;
	private int tamanioVivienda;
	private int numeroPisos;
	
	public ViviendaDTO() {
	}

	public ViviendaDTO(int identificadorVivienda, int tamanioVivienda, int numeroPisos) {
		super();
		this.identificadorVivienda = identificadorVivienda;
		this.tamanioVivienda = tamanioVivienda;
		this.numeroPisos = numeroPisos;
	}

	public int getIdentificadorVivienda() {
		return identificadorVivienda;
	}

	public void setIdentificadorVivienda(int identificadorVivienda) {
		this.identificadorVivienda = identificadorVivienda;
	}

	public int getTamanioVivienda() {
		return tamanioVivienda;
	}

	public void setTamanioVivienda(int tamanioVivienda) {
		this.tamanioVivienda = tamanioVivienda;
	}

	public int getNumeroPisos() {
		return numeroPisos;
	}

	public void setNumeroPisos(int numeroPisos) {
		this.numeroPisos = numeroPisos;
	}

	@Override
	public String toString() {
		return ""+ identificadorVivienda + " | Tamaño: " + tamanioVivienda
				+ " M² |  Pisos: " + numeroPisos;
	}
	
}
