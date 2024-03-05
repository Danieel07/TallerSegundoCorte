package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CasaDTO;

public class CasaDAO implements CRUDOperation{

	private ArrayList<CasaDTO> lista;
	
	public CasaDAO() {
		lista = new ArrayList<>();
	}
	@Override
	public void create(Object o) {
		CasaDTO info = (CasaDTO)o;
		lista.add(info);
	}

	@Override
	public boolean delete(int index) {
		if(index < 0|| index >= lista.size()) {
			return false;
		}else {
			lista.remove(index);
			return true;
		}
	}

	@Override
	public boolean update(int index, Object o) {
		CasaDTO info = (CasaDTO)o;
		if(index < 0|| index >= lista.size()) {
			return false;
		}else {
			lista.get(index).setIdentificadorVivienda(info.getIdentificadorVivienda());
			lista.get(index).setNumeroPisos(info.getNumeroPisos());
			lista.get(index).setTamanioVivienda(info.getTamanioVivienda());
			return true;
		}
	}

	@Override
	public String read() {
		String salida = "";
		int conteo = 0;
		for (CasaDTO casaDTO : lista) {
			salida += "\n" + conteo + "->"+casaDTO.toString();
			conteo++;
		}
		return salida;
	}

}
