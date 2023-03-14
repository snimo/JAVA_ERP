	package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ManejadorPlan {
	
	private int secu = 0;
	
	List listaBandas = new ArrayList();
	List listaFilas = new ArrayList();
	List listaFiltros = new ArrayList();
	
	public void addBanda(ElementoBandaPlan elementoBandaPlan) {	
		listaBandas.add(elementoBandaPlan);
	}
	
	public void addFila(ElementoFilaPlan elementoFilaPlan) {
		listaFilas.add(elementoFilaPlan);
	}
	
	public List getBandas() {
		Collections.sort(this.listaBandas);
		return listaBandas;
	}
	
	public List getFilas() {
		Collections.sort(this.listaFilas);
		return listaFilas;
	}
	
	public void addFiltro(ElementoFiltroPlan aElementoFiltroPlan) {
		listaFiltros.add(aElementoFiltroPlan);
	}
	
	public List getFiltros() {
		Collections.sort(this.listaFiltros);
		return listaFiltros;
	}
	
	public IDataSet getDSCamposTablaEstrucPlan() throws BaseException {
		IDataSet dataset = new TDataSet(); 
    dataset.create("TCamposTablaEstrucPlan");
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nombre_campo", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_dato", Field.STRING, 100));
    dataset.fieldDef(new Field("tamanio", Field.INTEGER, 100));
    return dataset;
	}
	
	public IDataSet getDSCamposCompoTablaEstrucPlan() throws BaseException {
		IDataSet dataset = new TDataSet(); 
    dataset.create("TEstructuraPlan");
    
    dataset.fieldDef(new Field("habilitado",Field.BOOLEAN, 0));
		Iterator iterFilas = this.getFilas().iterator();
		while (iterFilas.hasNext()) {
			ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) iterFilas.next();
			dataset.fieldDef(new Field(elementoFilaPlan.getCampoTabla(),Field.STRING, 255));
		}
		
    return dataset;
	}	
	
	public void llenarTablaPlanConValCompo(IDataSet ds) throws BaseException {
				
		List listaFilas = this.getFilas();
		
		if (listaFilas.size() == 0) return;
		//Tomar el elemeno fila
		ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) listaFilas.get(0);
		CompoPresupuestario compoPresu = elementoFilaPlan.getCompoPresu();
						
		// Devolver todos los valores correspondiente al componente
		Iterator iterValCompoPresu = compoPresu.getValores().iterator();
		while (iterValCompoPresu.hasNext()) {
			ValorCompoPresu valCompoPresu = (ValorCompoPresu) iterValCompoPresu.next();			
			//String valor = elementoFilaPlan.getValorCompoPresuParaPlan(valCompoPresu);
			Map mapaValoresPresu = new LinkedHashMap();
			mapaValoresPresu.put(elementoFilaPlan,valCompoPresu);
			elementoFilaPlan.setNroIntPosCol(1);
			obtenerValoresPresuProxCompo(ds,listaFilas,1,mapaValoresPresu);
		}
			
	}
	
	private void obtenerValoresPresuProxCompo(IDataSet ds,
			                                      List listaFilas,
			                                      int nroFila,
			                                      Map valCompoPresuPadres) throws BaseException {
				
		if ((listaFilas.size()-1)<nroFila) {
			// Enviar al cliente los valores si ya se recorrieron todos los elementos
			ds.append();
			ds.fieldValue("habilitado",new Boolean(false));
			Iterator iterFila = valCompoPresuPadres.keySet().iterator();
			while (iterFila.hasNext()) {
				ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) iterFila.next();
				ValorCompoPresu valCompoPresu = (ValorCompoPresu) valCompoPresuPadres.get(elementoFilaPlan);
				ds.fieldValue(elementoFilaPlan.getCampoTabla(),elementoFilaPlan.getValorCompoPresuParaPlan(valCompoPresu));
			}			
			return;
		}
		
		ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) listaFilas.get(nroFila);
		CompoPresupuestario compoPresu = elementoFilaPlan.getCompoPresu();
		
		// Si el componente presupuestario ya existe en un componente Padre
		// devolver solamente el Valor
		List listaValCompoPresuAnt = new ArrayList();
		Iterator iterProcesarFilasAnt = valCompoPresuPadres.keySet().iterator();
		while (iterProcesarFilasAnt.hasNext()) {
			ElementoFilaPlan elementoFilaPlanAnt = (ElementoFilaPlan) iterProcesarFilasAnt.next();
			
			if (elementoFilaPlanAnt.getNroIntPosCol() == 1) {
				ValorCompoPresu valCompoPresuAnt = (ValorCompoPresu)valCompoPresuPadres.get(elementoFilaPlanAnt);
				listaValCompoPresuAnt.add(valCompoPresuAnt);
			}
				
			if (elementoFilaPlanAnt.getNroIntPosCol() < nroFila) {
				ValorCompoPresu valCompoPresuAnt = (ValorCompoPresu)valCompoPresuPadres.get(elementoFilaPlanAnt);
				listaValCompoPresuAnt.add(valCompoPresuAnt);
				if (elementoFilaPlanAnt.getCompoPresu().getOID() == compoPresu.getOID()) {
					valCompoPresuPadres.put(elementoFilaPlan,valCompoPresuAnt);
					elementoFilaPlan.setNroIntPosCol(nroFila);
					obtenerValoresPresuProxCompo(ds,listaFilas,nroFila+1,valCompoPresuPadres);
					return;
				}
			}
		}
				
		// Devolver todos los valores correspondiente al componente
		Iterator iterValCompoPresu = compoPresu.getValores(listaValCompoPresuAnt).iterator();
		while (iterValCompoPresu.hasNext()) {
			ValorCompoPresu valCompoPresu = (ValorCompoPresu) iterValCompoPresu.next();			
			valCompoPresuPadres.put(elementoFilaPlan,valCompoPresu);
			elementoFilaPlan.setNroIntPosCol(nroFila);
			obtenerValoresPresuProxCompo(ds,listaFilas,nroFila+1,valCompoPresuPadres);
		}
		
		
		
	}
	
	
	private void cargarDSCamposTablaEstrucPlan(IDataSet ds,
																						 Integer orden,
																						 String nombreCampo,
																						 String tipoDato,
																						 Integer tamanio) throws BaseException {
		ds.append();
    ds.fieldValue("orden", orden);
    ds.fieldValue("nombre_campo", nombreCampo);
    ds.fieldValue("tipo_dato", tipoDato);
    ds.fieldValue("tamanio", tamanio);
    
	}
	
	public IDataSet getDSColumnasGrillaPlan() throws BaseException {
		IDataSet dataset = new TDataSet(); 
    dataset.create("TColumnasGrillaPlan");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_pos", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_campo",Field.INTEGER, 0));
    dataset.fieldDef(new Field("titulo",Field.STRING, 100));
    dataset.fieldDef(new Field("nro_banda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("agrupar",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("filtro",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("busquedaIncremental",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("permitirOrdenar",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ordenarPorDefecto",Field.STRING, 50));
    dataset.fieldDef(new Field("ancho_columna",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("campo_tabla",Field.STRING, 100));
    dataset.fieldDef(new Field("formato",Field.STRING, 100));
    dataset.fieldDef(new Field("formula",Field.STRING, 500));
    dataset.fieldDef(new Field("color",Field.STRING, 50));
    return dataset;
	}
	
	private void cargarColumnasGrillaPlan(IDataSet ds,
																				Integer secu,
																				Integer nroPos,
																				Integer tipoCampo,
																				String titulo,
																				Integer nroBanda,
																				Boolean agrupar,
																				Boolean filtro,
																				Boolean busqInc,
																				Boolean permitirOrdenar,
																				String ordenPorDefecto,
																				Integer anchoColumna,
																				CompoPresupuestario compoPresu,
																				String campoTabla,
																				String formato,
																				String formula,
																				String color) throws BaseException {
		
  	ds.append();
  	ds.fieldValue("secu", secu); 
  	ds.fieldValue("nro_pos", nroPos);
  	ds.fieldValue("tipo_campo", tipoCampo);
  	ds.fieldValue("titulo", titulo);
  	ds.fieldValue("nro_banda", nroBanda);
  	ds.fieldValue("agrupar", agrupar);
  	ds.fieldValue("filtro", filtro);
  	ds.fieldValue("busquedaIncremental", busqInc);
  	ds.fieldValue("permitirOrdenar", permitirOrdenar);
  	ds.fieldValue("ordenarPorDefecto", ordenPorDefecto);
  	ds.fieldValue("ancho_columna", anchoColumna);
  	ds.fieldValue("oid_compo_presu", compoPresu.getOIDInteger());
  	ds.fieldValue("campo_tabla", campoTabla);
  	ds.fieldValue("formato", formato);
  	ds.fieldValue("formula", formula);
  	ds.fieldValue("color", color);
		
		
	}
																				
	
	public void enviarColumnasCompoGrillaPlan(IDataSet ds) throws BaseException {
		Iterator iterFilas = this.getFilas().iterator();
		while (iterFilas.hasNext()) {
			ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) iterFilas.next();
			++secu;
			cargarColumnasGrillaPlan(ds,
															 new Integer(secu),
															 new Integer(elementoFilaPlan.getNroPosCol()),
															 new Integer(elementoFilaPlan.getTipoCampo()),
															 elementoFilaPlan.getTitulo(),
															 new Integer(elementoFilaPlan.getNroBanda()),
															 new Boolean(elementoFilaPlan.isAgrupar()),
															 new Boolean(elementoFilaPlan.isFiltros()),
															 new Boolean(elementoFilaPlan.isBusquedaInc()),
															 new Boolean(elementoFilaPlan.isPermitirCambiarOrden()),
															 elementoFilaPlan.getOrdenPorDefecto(),
															 new Integer(elementoFilaPlan.getAnchoColumna()),
															 elementoFilaPlan.getCompoPresu(),
															 elementoFilaPlan.getCampoTabla(),
															 elementoFilaPlan.getFormato(),
															 elementoFilaPlan.getFormula(),
															 elementoFilaPlan.getColor());
															 
															 
															 
															 
		}
	}
	
	public void enviarCampoCompoTablaPlan(IDataSet ds) throws BaseException {
		
		
		
		Iterator iterFilas = this.getFilas().iterator();
		while (iterFilas.hasNext()) {
			ElementoFilaPlan elementoFilaPlan = (ElementoFilaPlan) iterFilas.next();
			cargarDSCamposTablaEstrucPlan(ds,
																new Integer(elementoFilaPlan.getNroPosCol()),
																elementoFilaPlan.getCampoTabla(),
																elementoFilaPlan.getTipoDatoCampoTabla(),
																elementoFilaPlan.getSizeCampoTable());
		}
	}
	
	
	
}
