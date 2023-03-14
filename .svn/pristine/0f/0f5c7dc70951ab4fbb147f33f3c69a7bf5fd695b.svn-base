package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.List;

import framework.request.bl.Utils.BaseException;

public class ArchExcImpTablet {

	private List clientes = new ArrayList();
	private List estados = new ArrayList(); 
	private List peligrosidad = new ArrayList(); 
	private List razas = new ArrayList();
	private List alturas = new ArrayList();
	private List complexion = new ArrayList();
	private List edades = new ArrayList();
	private List colorCabello = new ArrayList();
	private List sexo = new ArrayList();
	
	private PresentacionImpExcluido presentacionImpExcluido = new PresentacionImpExcluido();
	
	public PresentacionImpExcluido getImportacionExcluido()  {
		return this.presentacionImpExcluido;
	}
	
	
	
	public void addPresentacionCliente(PresentacionClienteExcluido presentacionCliente) throws BaseException {
		clientes.add(presentacionCliente);
	}
	
	public void addEstadoExcluido(EstadoExcluido estado) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(estado.getOIDInteger().toString());
		tabla.setCodigo(estado.getCodigo());
		tabla.setDescripcion(estado.getDescripcion());
		estados.add(tabla);
	}	
	
	public void addPeligrosidad(PeligrosidadExcluido peligrosidad) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(peligrosidad.getOIDInteger().toString());
		tabla.setCodigo(peligrosidad.getCodigo());
		tabla.setDescripcion(peligrosidad.getDescripcion());
		this.peligrosidad.add(tabla);
	}	
	
	public void addRaza(RazaExcluido raza) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(raza.getOIDInteger().toString());
		tabla.setCodigo(raza.getCodigo());
		tabla.setDescripcion(raza.getDescripcion());
		razas.add(tabla);
	}	
	
	public void addAltura(AlturaExcluido altura) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(altura.getOIDInteger().toString());
		tabla.setCodigo(altura.getCodigo());
		tabla.setDescripcion(altura.getDescripcion());
		alturas.add(tabla);
	}	
	
	public void addComplexion(ComplexionExcluido complexion) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(complexion.getOIDInteger().toString());
		tabla.setCodigo(complexion.getCodigo());
		tabla.setDescripcion(complexion.getDescripcion());
		this.complexion.add(tabla);
	}	
	
	public void addEdad(EdadExcluido edad) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(edad.getOIDInteger().toString());
		tabla.setCodigo(edad.getCodigo());
		tabla.setDescripcion(edad.getDescripcion());
		edades.add(tabla);
	}	
	
	public void addColorCabello(ColorCabelloExcluido color) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(color.getOIDInteger().toString());
		tabla.setCodigo(color.getCodigo());
		tabla.setDescripcion(color.getDescripcion());
		colorCabello.add(tabla);
	}	
	
	public void addSexo(String codigo,String descripcion) throws BaseException {
		PresentacionTablaExcluido tabla = new PresentacionTablaExcluido();
		tabla.setId(codigo);
		tabla.setCodigo(codigo);
		tabla.setDescripcion(descripcion);
		sexo.add(tabla);
	}	
	
}
