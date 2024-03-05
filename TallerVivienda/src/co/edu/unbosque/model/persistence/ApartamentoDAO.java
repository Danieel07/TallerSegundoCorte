package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ApartamentoDTO;

public class ApartamentoDAO implements CRUDOperation {

	private ArrayList<ApartamentoDTO> lista;
	
	public ApartamentoDAO() {
		lista = new ArrayList<>();
	}
	@Override
	public void create(Object o) {
		ApartamentoDTO info=(ApartamentoDTO)o;
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
		ApartamentoDTO info = (ApartamentoDTO)o;
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
		for (ApartamentoDTO apartamentoDTO : lista) {
			salida += "\n" + conteo + "->"+apartamentoDTO.toString();
			conteo++;
		}
		return salida;
	}

}
