package co.edu.unbosque.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.ApartamentoDTO;
import co.edu.unbosque.model.CasaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.util.exception.NoValidCharacterException;
import co.edu.unbosque.util.exception.NoValidLetterException;
import co.edu.unbosque.util.exception.NoValidNegativeNumber;
import co.edu.unbosque.view.Console;

public class Controller {
	private ModelFacade modelFacade;
	private Console con;
	
	public Controller() {
		con = new Console();
		modelFacade = new ModelFacade();
	}
	public void checkNegativeNumber(String check) throws NoValidNegativeNumber {
		int checkInt = Integer.parseInt(check);
		if(checkInt < 0 ) {
			throw new NoValidNegativeNumber();
		}
	}
	public void checkNoValidLetter(String check) throws NoValidLetterException {
		Pattern p = Pattern.compile("[a-zA-z]");
		Matcher m = p.matcher(check);
		if(m.find()) {
			throw new NoValidLetterException();
		}
	}
	public void checkCharacterSpecial(String check) throws NoValidCharacterException{
		Pattern p = Pattern.compile("^[a-zA-z]");
		Matcher m = p.matcher(check);
		if(m.find()) {
			throw new NoValidCharacterException();
		}
	}
	
	public void crear(){
		int indexInt = 0;
		try {
			String index;
			mainloop: while(true) {
				con.imprimirTexto("¿Que desea Crear?");
				con.imprimirTexto("1-> Apartamento \n2-> Casa");
				index = con.leer_linea();
				checkNoValidLetter(index);
				checkCharacterSpecial(index);
				checkNegativeNumber(index);
				indexInt = Integer.parseInt(index);
				
				if(indexInt > 2 || indexInt < 0) {
					con.imprimirTexto("Digite una opción valida entre 1 y 2");
				}else {
					break mainloop;
				}
			}
			con.imprimirTexto("Digite El Indentificador de Vivienda");
			String idViviendaStr = con.leer_linea();
			checkNoValidLetter(idViviendaStr);
			checkCharacterSpecial(idViviendaStr);
			checkNegativeNumber(idViviendaStr);
			int idVivienda = Integer.parseInt(idViviendaStr);
			
			con.imprimirTexto("Digite El Tamaño De la Vivienda");
			String tamViviendaStr = con.leer_linea();
			checkNoValidLetter(tamViviendaStr);
			checkCharacterSpecial(tamViviendaStr);
			checkNegativeNumber(tamViviendaStr);
			int tamVivienda = Integer.parseInt(tamViviendaStr);
			
			con.imprimirTexto("Digite Numero De Pisos de la Vivienda");
			String numPisosStr = con.leer_linea();
			checkNoValidLetter(numPisosStr);
			checkCharacterSpecial(numPisosStr);
			checkNegativeNumber(numPisosStr);
			int numPisos = Integer.parseInt(numPisosStr);
			
			if(indexInt == 1) {
				modelFacade.getApartamentoDAO().create(new ApartamentoDTO(idVivienda, tamVivienda, numPisos));
				con.imprimirTexto("Apartamento: ("+ idVivienda+ ") Creado Con Exito \n");
			}else {
				modelFacade.getCasaDAO().create(new CasaDTO(idVivienda, tamVivienda, numPisos));
				con.imprimirTexto("Casa: ("+ idVivienda+ ") Creada Con Exito \n");
			}
			
		} catch (NoValidNegativeNumber e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidLetterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidCharacterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		}
	}
	
	public void eliminar() {
		int indexInt = 0;
		try {
			String index;
			mainloop: while(true) {
				con.imprimirTexto("¿Que Tipo De Vivienda Desea Eliminar?");
				con.imprimirTexto("1-> Apartamento \n2-> Casa");
				index = con.leer_linea();
				checkNoValidLetter(index);
				checkCharacterSpecial(index);
				checkNegativeNumber(index);
				indexInt = Integer.parseInt(index);
				if(indexInt > 2 || indexInt < 0) {
					con.imprimirTexto("Digite una opción valida entre 1 y 2");
				}else {
					break mainloop;
				}
			}
			String indiceStr;
			int indiceInt;
			if(indexInt == 1) {
				con.imprimirTexto(modelFacade.getApartamentoDAO().read());
				con.imprimirTexto("\n");
				con.imprimirTexto("Digite El Indice De la vivienda Que Desea Eliminar");
				indiceStr = con.leer_linea();
				checkNoValidLetter(indiceStr);
				checkCharacterSpecial(indiceStr);
				checkNegativeNumber(indiceStr);
				indiceInt = Integer.parseInt(indiceStr);
				
				if(modelFacade.getApartamentoDAO().delete(indiceInt)) {
					con.imprimirTexto("Vivienda Eliminada con Exito\n");
				}else {
					con.imprimirTexto("Algo Salido Mal\n");
				}
			}else {
				con.imprimirTexto(modelFacade.getCasaDAO().read());
				con.imprimirTexto("\n");
				con.imprimirTexto("Digite El Indice De la vivienda Que Desea Eliminar");
				indiceStr = con.leer_linea();
				checkNoValidLetter(indiceStr);
				checkCharacterSpecial(indiceStr);
				checkNegativeNumber(indiceStr);
				indiceInt = Integer.parseInt(indiceStr);
				if(modelFacade.getCasaDAO().delete(indiceInt)) {
					con.imprimirTexto("Vivienda Eliminada con Exito\n");
				}else {
					con.imprimirTexto("Algo Salido Mal\n");
				}
			}
			
		} catch (NoValidNegativeNumber e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidLetterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidCharacterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		}
	}
	
	public void actualizar() {
		int indexInt = 0;
		try {
			String index;
			mainloop: while(true) {
				con.imprimirTexto("¿Que Tipo De Vivienda Desea Actualizar?");
				con.imprimirTexto("1-> Apartamento \n2-> Casa");
				index = con.leer_linea();
				checkNoValidLetter(index);
				checkCharacterSpecial(index);
				checkNegativeNumber(index);
				indexInt = Integer.parseInt(index);
				if(indexInt > 2 || indexInt < 0) {
					con.imprimirTexto("Digite una opción valida entre 1 y 2");
				}else {
					break mainloop;
				}
			}
			String indiceStr;
			int indiceInt;
			if(indexInt == 1) {
				con.imprimirTexto(modelFacade.getApartamentoDAO().read());
				con.imprimirTexto("\n");
				con.imprimirTexto("Digite El Indice De la vivienda Que Desea Actualizar");
				indiceStr = con.leer_linea();
				checkNoValidLetter(indiceStr);
				checkCharacterSpecial(indiceStr);
				checkNegativeNumber(indiceStr);
				indiceInt = Integer.parseInt(indiceStr);
				
				con.imprimirTexto("Digite El Nuevo Indentificador de la Vivienda");
				String idViviendaStr = con.leer_linea();
				checkNoValidLetter(idViviendaStr);
				checkCharacterSpecial(idViviendaStr);
				checkNegativeNumber(idViviendaStr);
				int idVivienda = Integer.parseInt(idViviendaStr);
				
				con.imprimirTexto("Digite El Nuevo Tamaño De la Vivienda");
				String tamViviendaStr = con.leer_linea();
				checkNoValidLetter(tamViviendaStr);
				checkCharacterSpecial(tamViviendaStr);
				checkNegativeNumber(tamViviendaStr);
				int tamVivienda = Integer.parseInt(tamViviendaStr);
				
				con.imprimirTexto("Digite Numero De Pisos de la Vivienda");
				String numPisosStr = con.leer_linea();
				checkNoValidLetter(numPisosStr);
				checkCharacterSpecial(numPisosStr);
				checkNegativeNumber(numPisosStr);
				int numPisos = Integer.parseInt(numPisosStr);
				
				
				if(modelFacade.getApartamentoDAO().update(indiceInt, new ApartamentoDTO(idVivienda, tamVivienda, numPisos))) {
					con.imprimirTexto("Vivienda Actualizada con Exito\n");
				}else {
					con.imprimirTexto("Algo Salido Mal\n");
				}
			}else {
				con.imprimirTexto(modelFacade.getCasaDAO().read());
				con.imprimirTexto("\n");
				con.imprimirTexto("Digite El Indice De la vivienda Que Desea Actualizar");
				indiceStr = con.leer_linea();
				checkNoValidLetter(indiceStr);
				checkCharacterSpecial(indiceStr);
				checkNegativeNumber(indiceStr);
				indiceInt = Integer.parseInt(indiceStr);
				
				con.imprimirTexto("Digite El Nuevo Indentificador de la Vivienda");
				String idViviendaStr = con.leer_linea();
				checkNoValidLetter(idViviendaStr);
				checkCharacterSpecial(idViviendaStr);
				checkNegativeNumber(idViviendaStr);
				int idVivienda = Integer.parseInt(idViviendaStr);
				
				con.imprimirTexto("Digite El Nuevo Tamaño De la Vivienda");
				String tamViviendaStr = con.leer_linea();
				checkNoValidLetter(tamViviendaStr);
				checkCharacterSpecial(tamViviendaStr);
				checkNegativeNumber(tamViviendaStr);
				int tamVivienda = Integer.parseInt(tamViviendaStr);
				
				con.imprimirTexto("Digite Numero De Pisos de la Vivienda");
				String numPisosStr = con.leer_linea();
				checkNoValidLetter(numPisosStr);
				checkCharacterSpecial(numPisosStr);
				checkNegativeNumber(numPisosStr);
				int numPisos = Integer.parseInt(numPisosStr);
				
				if(modelFacade.getCasaDAO().update(indiceInt, new CasaDTO(idVivienda, tamVivienda, numPisos))) {
					con.imprimirTexto("Vivienda Eliminada con Exito\n");
				}else {
					con.imprimirTexto("Algo Salido Mal\n");
				}
			}
			
		} catch (NoValidNegativeNumber e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidLetterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidCharacterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		}
	}
	
	public void mostrar() {
		int indexInt = 0;
		try {
			String index;
			mainloop: while(true) {
				con.imprimirTexto("¿Que lista desea Ver?");
				con.imprimirTexto("1-> Apartamento \n2-> Casa");
				index = con.leer_linea();
				checkNoValidLetter(index);
				checkCharacterSpecial(index);
				checkNegativeNumber(index);
				indexInt = Integer.parseInt(index);
				
				if(indexInt > 2 || indexInt < 0) {
					con.imprimirTexto("Digite una opción valida entre 1 y 2");
				}else {
					break mainloop;
				}
			}
			
			if(indexInt == 1) {
				con.imprimirTexto(modelFacade.getApartamentoDAO().read());
				con.imprimirTexto("\n");
			}else {
				con.imprimirTexto(modelFacade.getCasaDAO().read());
				con.imprimirTexto("\n");
			}
			
		} catch (NoValidNegativeNumber e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidLetterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		} catch (NoValidCharacterException e) {
			con.imprimirTexto(e.getMessage());
			con.leer_linea();
		}
	}
	
 	public void menuPrincipal() {
		con.imprimirTexto("Bienvenido a el Registro de Vivienda de Rodriguez y Nieto Inmobiliaria SAS");
		con.imprimirTexto("¿Que Desea Hacer?");
		con.imprimirTexto("1-> Crear");
		con.imprimirTexto("2-> Eliminar");
		con.imprimirTexto("3-> Actualizar");
		con.imprimirTexto("4-> Mostrar");
		con.imprimirTexto("5-> Salir");
	}
	
 	
	public void run() {
		String op = "";
		int opInt = 0;
			mainloop: while (true) {
				menuPrincipal();
				try {
					con.imprimirTexto("Digite La Opción que desea realizar: ");
					op = con.leer_linea();
					checkNoValidLetter(op);
					checkCharacterSpecial(op);
					checkNegativeNumber(op);
					opInt = Integer.parseInt(op);
					
				} catch (NoValidLetterException e) {
					con.imprimirTexto(e.getMessage());
					con.leer_linea();
					continue;
				} catch(NoValidNegativeNumber e) {
					con.imprimirTexto(e.getMessage());
					con.leer_linea();
					continue;
				} catch (NoValidCharacterException e) {
					con.imprimirTexto(e.getMessage());
					con.leer_linea();
					continue;
				}
				switch (opInt) {
				case 1: {
					crear();
					break;
				}
				case 2: {
					eliminar();
					break;
				}
				case 3: {
					actualizar();
					break;
				}
				case 4:{
					mostrar();
					break;
				}
				case 5:{
					break mainloop;
				}
				default: {
					con.imprimirTexto("Opción Fuera de Rango. Por favor elija una opcion dentro del rango (1-5)");
				}
			}
		}
	}
}
