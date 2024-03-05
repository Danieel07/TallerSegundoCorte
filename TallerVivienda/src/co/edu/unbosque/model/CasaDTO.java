package co.edu.unbosque.model;

public class CasaDTO extends ViviendaDTO{

	public CasaDTO() {

	}

	public CasaDTO(int identificadorVivienda, int tamanioVivienda, int numeroPisos) {
		super(identificadorVivienda, tamanioVivienda, numeroPisos);
	}

	@Override
	public String toString() {
		return "[Casa: " + super.toString()+" ]";
	}
	
	
	
}
