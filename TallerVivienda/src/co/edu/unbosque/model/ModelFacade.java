package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApartamentoDAO;
import co.edu.unbosque.model.persistence.CasaDAO;

public class ModelFacade {
	private CasaDAO casaDAO;
	private ApartamentoDAO apartamentoDAO;
	
	public ModelFacade() {
		casaDAO = new CasaDAO();
		apartamentoDAO = new ApartamentoDAO();
	}

	public CasaDAO getCasaDAO() {
		return casaDAO;
	}

	public void setCasaDAO(CasaDAO casaDAO) {
		this.casaDAO = casaDAO;
	}

	public ApartamentoDAO getApartamentoDAO() {
		return apartamentoDAO;
	}

	public void setApartamentoDAO(ApartamentoDAO apartamentoDAO) {
		this.apartamentoDAO = apartamentoDAO;
	}
}
