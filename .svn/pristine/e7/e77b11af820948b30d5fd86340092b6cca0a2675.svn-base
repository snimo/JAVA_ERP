package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;


public class MatrizValoresVarEsce  { 

	ISesion sesion;
	PeriodoPresupuestario periDesde;
	PeriodoPresupuestario periHasta;
	VarEscenarioCab variableEscenario;
	int secu = 0;
	
	private ISesion getSesion() {
		return this.sesion;
	}
	
	public VarEscenarioCab getVariableEscenario() {
		return this.variableEscenario;
	}
	
	public void setVariableEscenario(VarEscenarioCab aVarEscenarioCab) {
		this.variableEscenario = aVarEscenarioCab;
	}
	
  public MatrizValoresVarEsce(ISesion aSesion) {
  	sesion = aSesion;
  }
  
  public void setPeriodoDesde(PeriodoPresupuestario aPeriodoDesde) {
  	this.periDesde = aPeriodoDesde;
  }
  
  public PeriodoPresupuestario getPeriodoDesde() {
  	return this.periDesde;
  }
  
  public void setPeriodoHasta(PeriodoPresupuestario aPeriodoHasta) {
  	this.periHasta = aPeriodoHasta;
  }
  
  public PeriodoPresupuestario getPeriodoHasta() {
  	return this.periHasta;  
  }
  
  public IDataSet getEstructuraDataSet(String tableName) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create(tableName);
		
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
    dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
    dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));
    
    dataset.fieldDef(new Field("agregarValidador", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tablaAValidar", Field.STRING, 50));
    dataset.fieldDef(new Field("campoAValidar", Field.STRING, 50));
    dataset.fieldDef(new Field("scriptValidador", Field.STRING, 5000));
    
    return dataset;  	
  }
  
  private void cargarRegEstrucDS(IDataSet ds,
  															 String tipo,
  															 String nombreFisico,
  															 Integer longitud,
  															 Boolean primaryKey,
  															 Boolean agregarValidador,
  															 String tablaAValidar,
  															 String campoAValidar,
  															 String scriptValidador) {
  	
  	ds.append();
    ds.fieldValue("secu", new Integer(++secu));
    ds.fieldValue("tipo", tipo);
    ds.fieldValue("nombre_fisico", nombreFisico);
    ds.fieldValue("longitud", longitud);
    ds.fieldValue("primaryKey", primaryKey);
    ds.fieldValue("agregarValidador", agregarValidador);
    ds.fieldValue("tablaAValidar", tablaAValidar);
    ds.fieldValue("campoAValidar", campoAValidar);
    ds.fieldValue("scriptValidador", scriptValidador);  	
  	
  }
  
  private String getNombreCampoOIDCompo(VarEscenarioDet varEsceDet) throws BaseException {
  	return "oid_compo_"+varEsceDet.getNroInternoValCompo();
  }
  
  private String getNombreCampoDescCompo(VarEscenarioDet varEsceDet) throws BaseException {
  	return "desc_compo_"+varEsceDet.getNroInternoValCompo();
  }
  
  public IDataSet getDSCamposValoresVarEsce(String aNombreTabla) throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create(aNombreTabla);
    
    // Campos Fisicos Valores de Variables de Escenarios
    
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
  	Iterator iterVarEsceDet = 
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt().iterator();
  	
  	while (iterVarEsceDet.hasNext()) {
  		VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceDet.next();
  		
  		dataset.fieldDef(new Field(getNombreCampoOIDCompo(varEsceDet), Field.INTEGER, 0));
  		dataset.fieldDef(new Field(getNombreCampoDescCompo(varEsceDet), Field.STRING, 255));
    	
  	}
  	
  	if (this.getVariableEscenario().getTipo_periodo()!=null) {
  	   
  		Iterator iterPeriodos = 
  			PeriodoPresupuestario.getPeriodosPresupuestados(this.getVariableEscenario().getTipo_periodo(),
  	   	                                                this.periDesde.getFec_desde(),
  	  	                                                this.periHasta.getFec_hasta(),this.getSesion()).iterator();
  		while (iterPeriodos.hasNext()) {
  			PeriodoPresupuestario peri = (PeriodoPresupuestario) iterPeriodos.next();
  			dataset.fieldDef(new Field(getNombreCampoPeriodo(peri), Field.CURRENCY, 0));
  		}
  		
  	} else {
  		  dataset.fieldDef(new Field("valor", Field.CURRENCY, 0));
  	}
  	
    return dataset;
  }
  
  
  private HashTableDatos getValVarEscGrabados() throws BaseException {
  	HashTableDatos valoresGrabados = new HashTableDatos();
  	List listaValoresVarEsce = 
  		ValorVariableEscenario.getValoresVarByEscenarioCab(this.getVariableEscenario(),this.getSesion());
  	Iterator iterValVarEsc = listaValoresVarEsce.iterator();
  	while (iterValVarEsc.hasNext()) {
  		ValorVariableEscenario valVarEsce = (ValorVariableEscenario) iterValVarEsc.next();
  		valoresGrabados.put(valVarEsce.getClave(),valVarEsce);
  	}
  	return valoresGrabados;
  }
  
  public void cargarDatosValoresVarEsce(IDataSet ds) throws BaseException {
  	
  	
  	// Obtener los valores de variables grabados
  	HashTableDatos valVarEscGrabados = getValVarEscGrabados();
  	
  	// Obtener los componentes con el Nro. de Orden
  	HashTableDatos hashComponentes = new HashTableDatos();
  	
  	List listaVarEsceDet =
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt();
  	
  	Iterator iterVarEsceDet = listaVarEsceDet.iterator();  
  	
  	while (iterVarEsceDet.hasNext()) {
  		VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceDet.next();
  		hashComponentes.put(varEsceDet.getNroInternoValCompo(),varEsceDet.getCompo_presu());    	
  	}
  	
  	
  	List listaPeriods = new ArrayList();
  	if (this.getVariableEscenario().tienePeriodos())
  		listaPeriods =
  			PeriodoPresupuestario.getPeriodosPresupuestados(this.getVariableEscenario().getTipo_periodo(),
  	   	                                                this.periDesde.getFec_desde(),
  	  	                                                this.periHasta.getFec_hasta(),this.getSesion());
  		
  	  	  	
  	List listaCombiValCompo =
  		CombinacionValoresCompo.getCombinacionesValoresCompo(hashComponentes,this.getSesion());
  	
  	int i = 0;
  	Iterator iterCombiValCompo = listaCombiValCompo.iterator();
  	while (iterCombiValCompo.hasNext()) {
  		CombinacionValoresCompo combinacionValorCompo = (CombinacionValoresCompo) iterCombiValCompo.next();
  		
  		
  		StringBuffer armarClaveCompo   = new StringBuffer();
  		
  		// Cargar registro
  		ds.append();
  		ds.fieldValue("secu",new Integer(++i));
  		
  		
  		Iterator iterVarEsceOrderByNroInt =  listaVarEsceDet.iterator();
  		while (iterVarEsceOrderByNroInt.hasNext()) {
  			VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceOrderByNroInt.next();
  			ValorCompoPresu valor = combinacionValorCompo.getValorCompo(varEsceDet.getNroInternoValCompo());
  			ds.fieldValue(getNombreCampoOIDCompo(varEsceDet),valor.getOIDInteger());
  			ds.fieldValue(getNombreCampoDescCompo(varEsceDet),valor.getDescripcion());
  			armarClaveCompo.append(valor.getOIDInteger().toString()+"_");
  		}
  		
    	if (this.getVariableEscenario().getTipo_periodo()!=null) {
   	   
    		Iterator iterPeriodos = listaPeriods.iterator();
    		while (iterPeriodos.hasNext()) {
    			PeriodoPresupuestario periPresu = (PeriodoPresupuestario) iterPeriodos.next();
    			String clave = periPresu.getOIDInteger().toString()+"_"+armarClaveCompo.toString();
    			ValorVariableEscenario valVarEsce = (ValorVariableEscenario)valVarEscGrabados.get(clave);    			
    			if (valVarEsce!=null)
    				ds.fieldValue(getNombreCampoPeriodo(periPresu),valVarEsce.getValor());
    			else
    				ds.fieldValue(getNombreCampoPeriodo(periPresu), "0");
    		}
    	} else {
    		// No tiene periodo asociado
    		String clave = armarClaveCompo.toString();
    		ValorVariableEscenario valVarEsce = (ValorVariableEscenario)valVarEscGrabados.get(clave);
    		if (valVarEsce!=null)
    			ds.fieldValue("valor",valVarEsce.getValor());
    		else
    			ds.fieldValue("valor","0");
    	}
  		
  	}
  	
  	
  }

  
  
  
  public void cargarCamposEstructuraDS(IDataSet ds) throws BaseException {
  	
  	// Crear el campo Secu
  	cargarRegEstrucDS(ds,
  										Field.INTEGER,
  										"secu",
  										new Integer(0),
  										new Boolean(true),
  										new Boolean(false),
  										"",
  										"",
  										"");
  	
  	// Devolver los campos correspondientes a los componentes
  	Iterator iterVarEsceDet = 
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt().iterator();
  	
  	while (iterVarEsceDet.hasNext()) {
  		VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceDet.next();
  		
  		// Campo Correspondientes al OID
    	cargarRegEstrucDS(ds,
					Field.INTEGER,
					getNombreCampoOIDCompo(varEsceDet),
					new Integer(0),
					new Boolean(false),
					new Boolean(false),
					"",
					"",
					"");
  		
  		// Campo Correspondiente al Codigo
    	cargarRegEstrucDS(ds,
					Field.STRING,
					getNombreCampoDescCompo(varEsceDet),
					new Integer(100),
					new Boolean(true),
					new Boolean(false),
					"",
					"",
					"");
    	
  	}
  	
  	// Crear los campos correspondientes a los Periodos
  	if (this.getVariableEscenario().getTipo_periodo()!=null) {
  	   
  		
  		Iterator iterPeriodos = 
  			PeriodoPresupuestario.getPeriodosPresupuestados(this.getVariableEscenario().getTipo_periodo(),
  	   	                                                this.periDesde.getFec_desde(),
  	  	                                                this.periHasta.getFec_hasta(),this.getSesion()).iterator();
  		while (iterPeriodos.hasNext()) {
  			PeriodoPresupuestario peri = (PeriodoPresupuestario) iterPeriodos.next();
      	cargarRegEstrucDS(ds,
  					Field.CURRENCY,
  					getNombreCampoPeriodo(peri),
  					new Integer(0),
  					new Boolean(false),
  					new Boolean(false),
  					"",
  					"",
  					"");
  		}
  		
  	}  	else {
  		cargarRegEstrucDS(ds,
					Field.CURRENCY,
					"valor",
					new Integer(0),
					new Boolean(false),
					new Boolean(false),
					"",
					"",
					"");  		
  	}
  	
  	
  }
  
  private String getNombreCampoPeriodo(PeriodoPresupuestario periodo) {
  	return "valor_peri_"+periodo.getOIDInteger();
  }
  
  public IDataSet getDSColumnasGrillaValores(String aNombreTabla) throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create(aNombreTabla);
    
    // Aspectos Fisicos
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("banda", Field.STRING, 100));
    dataset.fieldDef(new Field("nombre_logico", Field.STRING, 50));
    dataset.fieldDef(new Field("ancho_columna", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo_columna", Field.STRING, 50));
    dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("can_focus", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("formato", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_columna",Field.STRING, 50));
    dataset.fieldDef(new Field("evento_help",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("script_help",Field.STRING, 1000));
    dataset.fieldDef(new Field("agrupar",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_agrupador",Field.INTEGER, 0));
    
    return dataset;
  }
  
  private void cargarRegColGrillaValores(IDataSet ds,
  																			 Integer secu,
  																			 String bandaPrincipal,
  																			 String nombreLogico,
  																			 Integer anchoColumna,
  																			 String nombreFisico,
  																			 String tipoColumna,
  																			 Boolean readOnly,
  																			 Boolean canFocus,
  																			 String formato,
  																			 String nombreColumna,
  																			 Boolean eventoHelp,
  																			 String scriptHelp,
  																			 Boolean agrupar,
  																			 Integer nroAgrupador
  																				) {
  	ds.append();
    ds.fieldValue("secu", secu);
    ds.fieldValue("banda", bandaPrincipal);
    ds.fieldValue("nombre_logico", nombreLogico);
    ds.fieldValue("ancho_columna", anchoColumna);
    ds.fieldValue("nombre_fisico", nombreFisico);
    ds.fieldValue("tipo_columna", tipoColumna);
    ds.fieldValue("read_only", readOnly);
    ds.fieldValue("can_focus", canFocus);
    ds.fieldValue("formato", formato);
    ds.fieldValue("nombre_columna",nombreColumna);
    ds.fieldValue("evento_help",eventoHelp);
    ds.fieldValue("script_help",scriptHelp);
    ds.fieldValue("agrupar",agrupar);
    ds.fieldValue("nro_agrupador",nroAgrupador);
      	
  }
  
  
  public void cargarDatosColGrillaValores(IDataSet ds) throws BaseException {
  	
  	
  	int secu = 0;
  	String BANDA_VARIABLES = "Variables";
  	String BANDA_PERIODOS = "Perídos";
  	
  	// Devolver los campos correspondientes a los componentes
  	Iterator iterVarEsceDet = 
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt().iterator();
  	
  	Boolean agrupar = new Boolean(true);
  	int nroAgrupador = 0;
  	
  	while (iterVarEsceDet.hasNext()) {
  		VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceDet.next();
  		
  		  		
  		if (iterVarEsceDet.hasNext() == false) {
  			// Es el utlimo componente
  			agrupar = new Boolean(false);
  			nroAgrupador = -1;
  		}
  		
  		cargarRegColGrillaValores(ds,
  														  new Integer(++secu),
  														  BANDA_VARIABLES,
  														  varEsceDet.getCompo_presu().getDescripcion(),
  														  new Integer(200),
  														  getNombreCampoDescCompo(varEsceDet),
  														  "",
  														  new Boolean(true),
  														  new Boolean(true),
  														  "",
  														  "",
  														  new Boolean(false),
  														  "",
  														  agrupar,
  														  new Integer(nroAgrupador));
  		
  		++nroAgrupador;
  														  
  	}
  	
  	// Crear los campos correspondientes a los Periodos
  	if (this.getVariableEscenario().getTipo_periodo()!=null) {
  	   
  		
  		Iterator iterPeriodos = 
  			PeriodoPresupuestario.getPeriodosPresupuestados(this.getVariableEscenario().getTipo_periodo(),
  	   	                                                this.periDesde.getFec_desde(),
  	  	                                                this.periHasta.getFec_hasta(),this.getSesion()).iterator();
  		while (iterPeriodos.hasNext()) {
  			PeriodoPresupuestario peri = (PeriodoPresupuestario) iterPeriodos.next();
  			
    		cargarRegColGrillaValores(ds,
					  new Integer(++secu),
					  BANDA_PERIODOS,
					  peri.getCodigo(),
					  new Integer(50),
					  this.getNombreCampoPeriodo(peri),
					  "CurrencyEdit",
					  new Boolean(false),
					  new Boolean(true),
					  "###,###,###,###.####",
					  "",
					  new Boolean(false),
					  "",
					  new Boolean(false),
					  new Integer(-1));
  			
  			
  		}
  		
  	}  	else {
  		cargarRegColGrillaValores(ds,
				  new Integer(++secu),
				  BANDA_PERIODOS,
				  "Valor",
				  new Integer(50),
				  "valor",
				  "CurrencyEdit",
				  new Boolean(false),
				  new Boolean(true),
				  "###,###,###,###.####",
				  "",
				  new Boolean(false),
				  "",
				  new Boolean(false),
				  new Integer(-1));
  		
  	}
  	
  	
  }
  
  public List grabarDatosValoresVarEsce(IDataSet ds) throws BaseException {
  	
  	List listaValoresVarEsce = new ArrayList();
  	
  	// Obtener los componentes con el Nro. de Orden
  	List listaVarEsceDet =
  		this.getVariableEscenario().getVariablesEscenarioDetOrderByNroInt();
  	
  	List listaPeriodos = new ArrayList();
  	
  	if (this.getVariableEscenario().tienePeriodos())
  		listaPeriodos =
  			PeriodoPresupuestario.getPeriodosPresupuestados(this.getVariableEscenario().getTipo_periodo(),
  					this.getPeriodoDesde().getFec_desde(),
  					this.getPeriodoHasta().getFec_hasta(),this.getSesion());
  	
  	ds.first();
  	while (!ds.EOF()) {
  		
  		HashTableDatos valoresCompoConNroInt = new HashTableDatos();
  		Iterator iterVarEsceOrderByNroInt =  listaVarEsceDet.iterator();
  		while (iterVarEsceOrderByNroInt.hasNext()) {
  			
  			// Variables de Escenario Detalle
  			VarEscenarioDet varEsceDet = (VarEscenarioDet) iterVarEsceOrderByNroInt.next();
  			
  			// Obtener el OID del valor del componente presupuestario
  			Integer oidValorCompo = ds.getInteger(getNombreCampoOIDCompo(varEsceDet));
  			ValorCompoPresu valorCompoPresu = ValorCompoPresu.findByOid(oidValorCompo,this.getSesion());
  			valoresCompoConNroInt.put(varEsceDet.getNroInternoValCompo(),valorCompoPresu);
  		}
  		
  		// Procesar si no tiene periodo 
  		if (this.getVariableEscenario().tienePeriodos()==false) 
  			grabarValVarEsceSinPeriodos(ds,valoresCompoConNroInt,listaValoresVarEsce);
  		else 
  			grabarValVarEsceConPeriodos(ds,valoresCompoConNroInt,listaPeriodos,listaValoresVarEsce);
  			  		
  		ds.next();
  	}
  	return listaValoresVarEsce;
  }
  
  private void grabarValVarEsceSinPeriodos(IDataSet ds,
  		                                     HashTableDatos valoresCompoConNroInt,
  		                                     List listaValoresVarEsce) throws BaseException {
  	
  	ValorVariableEscenario valorVarEsce = null;
		if (this.getVariableEscenario().tienePeriodos()==false) {
			valorVarEsce =
				ValorVariableEscenario.getValorByComponentesPeriodos(valoresCompoConNroInt,
          null,
          this.getVariableEscenario(),
          this.getSesion());
			
			if (valorVarEsce!=null) { 
				valorVarEsce.setValor(ds.getMoney("valor"));
			  listaValoresVarEsce.add(valorVarEsce);
			}
			else {
				
				// Crear un valor nuevo
				valorVarEsce = 
					(ValorVariableEscenario) ValorVariableEscenario.getNew(ValorVariableEscenario.NICKNAME,this.getSesion());
				valorVarEsce.setPeriodo(null);
				valorVarEsce.setValor(ds.getMoney("valor"));
				valorVarEsce.setVariableEscenario(this.getVariableEscenario());
				Iterator iterNroInternos = valoresCompoConNroInt.keySet().iterator();
				while (iterNroInternos.hasNext()) {
					Integer nroInterno = (Integer) iterNroInternos.next();
					ValorCompoPresu valorCompo = (ValorCompoPresu)valoresCompoConNroInt.get(nroInterno);
					valorVarEsce.setValorCompoPresu(valorCompo,nroInterno);
				}
				listaValoresVarEsce.add(valorVarEsce);
			}
  	
  }
  	
  }
  
  private void grabarValVarEsceConPeriodos(IDataSet ds,
      HashTableDatos valoresCompoConNroInt,
      List listaPeriodos,
      List listaValoresVarEsce) throws BaseException {
		// Recorrer todos los Periodos
  	ValorVariableEscenario valorVarEsce = null;
		Iterator iterPeriodos = listaPeriodos.iterator();
		while (iterPeriodos.hasNext()) {
			PeriodoPresupuestario periodo = (PeriodoPresupuestario) iterPeriodos.next();
			valorVarEsce = 
				ValorVariableEscenario.getValorByComponentesPeriodos(valoresCompoConNroInt,
						                                                 periodo,
						                                                 this.getVariableEscenario(),
						                                                 this.getSesion());
			if (valorVarEsce!=null) { 
				valorVarEsce.setValor(ds.getMoney(getNombreCampoPeriodo(periodo)));
			  listaValoresVarEsce.add(valorVarEsce);
			}
			else {
				
				// Crear un valor nuevo
				valorVarEsce = 
					(ValorVariableEscenario) ValorVariableEscenario.getNew(ValorVariableEscenario.NICKNAME,this.getSesion());
				valorVarEsce.setPeriodo(periodo);
				valorVarEsce.setValor(ds.getMoney(getNombreCampoPeriodo(periodo)));
				valorVarEsce.setVariableEscenario(this.getVariableEscenario());
				Iterator iterNroInternos = valoresCompoConNroInt.keySet().iterator();
				while (iterNroInternos.hasNext()) {
					Integer nroInterno = (Integer) iterNroInternos.next();
					ValorCompoPresu valorCompo = (ValorCompoPresu)valoresCompoConNroInt.get(nroInterno);
					valorVarEsce.setValorCompoPresu(valorCompo,nroInterno);
				}
				listaValoresVarEsce.add(valorVarEsce);
			}
			
		}

  }
  
  
}
  
  
  
  
  


