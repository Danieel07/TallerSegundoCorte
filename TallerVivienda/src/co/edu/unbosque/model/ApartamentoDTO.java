package co.edu.unbosque.model;

public class ApartamentoDTO extends ViviendaDTO {
	
	public ApartamentoDTO() {
	}

	public ApartamentoDTO(int identificadorVivienda, int tamanioVivienda, int numeroPisos) {
		super(identificadorVivienda, tamanioVivienda, numeroPisos);
	}

	@Override
	public String toString() {
		return "[Apartamento: " + super.toString()+" ]";
	}
	
	
}
