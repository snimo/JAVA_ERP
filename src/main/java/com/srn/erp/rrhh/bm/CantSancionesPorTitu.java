package com.srn.erp.rrhh.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CantSancionesPorTitu {

	private int[] cantidades = new int[10];

	private String[] claves = new String[10];

	private HashTableDatos[] claveConOID = new HashTableDatos[10];

	public CantSancionesPorTitu() {
		for (int i = 0; i < cantidades.length; ++i) {
			cantidades[i] = 0;
			claves[i] = "";
			claveConOID[i] = new HashTableDatos();
		}
	}
	
	public void initCantidades() {
		for (int i = 0; i < cantidades.length; ++i) {
			cantidades[i] = 0;
		}
	}

	public void add(String titulo, SancionesLegajo sancionLegajo) throws BaseException {
		int indice = getBuscarClave(titulo);
		if (indice == -1) {
			indice = getBuscarVacio();
			cantidades[indice] = 1;
			claves[indice] = titulo;
			claveConOID[indice].put("SAN_"+sancionLegajo.getOIDInteger(), "");
		} else {
			if (claveConOID[indice].containsKey("SAN_"+sancionLegajo.getOIDInteger())) return;
			cantidades[indice] = cantidades[indice] + 1;
			claveConOID[indice].put("SAN_"+sancionLegajo.getOIDInteger(), "");
		}
	}
	
	public void add(String titulo, NovedadLegajo novedadLegajo) throws BaseException {
		int indice = getBuscarClave(titulo);
		if (indice == -1) {
			indice = getBuscarVacio();
			cantidades[indice] = 1;
			claves[indice] = titulo;
			claveConOID[indice].put("NOV_"+novedadLegajo.getOIDInteger(), "");
		} else {
			if (claveConOID[indice].containsKey("NOV_"+novedadLegajo.getOIDInteger())) return;
			cantidades[indice] = cantidades[indice] + 1;
			claveConOID[indice].put("NOV_"+novedadLegajo.getOIDInteger(), "");
		}
	}
	

	private int getBuscarClave(String clave) throws BaseException {
		for (int i = 0; i < cantidades.length; ++i) {
			if (claves[i].equals(clave))
				return i;
		}
		return -1;
	}

	private int getBuscarVacio() throws BaseException {
		for (int i = 0; i < cantidades.length; ++i) {
			if ((cantidades[i] == 0) && (claves[i].equals("")))
				return i;
		}
		return -1;
	}

	public int getCantTitulos() throws BaseException {
		int cantEle = 0;
		for (int i = 0; i < cantidades.length; ++i) {
			if ((cantidades[i] != 0) && (!claves[i].equals("")))
				++cantEle;
		}
		return cantEle;
	}

	public String getTitulo(int indice) throws BaseException {
		return claves[indice];
	}

	public Integer getCantidad(int indice) throws BaseException {
		return cantidades[indice];
	}

}
