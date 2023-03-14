package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.DefinicionRepositorioReal;
import com.srn.erp.presupuesto.bm.RepositorioReal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstrucTablaRepoReal extends Operation { 

	//public String BANDA_PRINCIPAL = "";
	private int secu = 0;
	
  public TraerEstrucTablaRepoReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet dsEstrucTablaValRepoReal 		= this.getDSEstrucTablaRepoReal();
    IDataSet dsColumnasGrillaValores    = this.getDSColumnasGrillaValores();
    IDataSet dsBeforePostTable = this.getDSEventoBeforePostTable();
    
    RepositorioReal repoReal = 
    	RepositorioReal.findByOidProxy(mapaDatos.getInteger("oid_repo_real"),this.getSesion());
    
    cargarEstrucTabValRepoReal(dsEstrucTablaValRepoReal,repoReal);
    cargarColumnasGrillasValores(dsColumnasGrillaValores,repoReal);
    cargarEventoBeforePost(dsBeforePostTable,repoReal);
    
    writeCliente(dsEstrucTablaValRepoReal);    
    writeCliente(dsColumnasGrillaValores);
    writeCliente(dsBeforePostTable);
    
  }
  
  private IDataSet getDSEstrucTablaRepoReal() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstrucTablaRepoDatosReales");
    
    // Aspectos Fisicos
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
    
  private IDataSet getDSColumnasGrillaValores() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TColumnasGrillaValores");
    
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
    dataset.fieldDef(new Field("script_help",Field.STRING, 5000));
    
    return dataset;
  }
  
  private void cargarColumnasGrillaTipoPeriodo(IDataSet ds,
    																					 DefinicionRepositorioReal defRepoReal) throws BaseException {

    ++secu;
    String campoFisicoCodigo = "";
		ds.append();
    ds.fieldValue("secu", secu);
    ds.fieldValue("banda", defRepoReal.getDescripcion());
    ds.fieldValue("nombre_logico", "Fecha");
    ds.fieldValue("ancho_columna", 50);
    campoFisicoCodigo = "fecha_"+defRepoReal.getOIDInteger();
    ds.fieldValue("nombre_fisico", campoFisicoCodigo);
    ds.fieldValue("tipo_columna", "Date");
    ds.fieldValue("read_only", new Boolean(false));
    ds.fieldValue("can_focus", new Boolean(true));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","colName_"+defRepoReal.getOIDInteger()+"secu");
    ds.fieldValue("evento_help",new Boolean(false));
    ds.fieldValue("script_help","");
  }
  
  private void cargarColumnasGrillaActivo(IDataSet ds) throws BaseException {

  	++secu;
  	String campoFisicoCodigo = "activo";
  	ds.append();
  	ds.fieldValue("secu", secu);
  	ds.fieldValue("banda", "Activo");
  	ds.fieldValue("nombre_logico", "Valor");
  	ds.fieldValue("ancho_columna", 15);
  	campoFisicoCodigo = "activo";
  	ds.fieldValue("nombre_fisico", campoFisicoCodigo);
  	ds.fieldValue("tipo_columna", "CheckBox");
  	ds.fieldValue("read_only", new Boolean(false));
  	ds.fieldValue("can_focus", new Boolean(true));
  	ds.fieldValue("formato", "");
  	ds.fieldValue("nombre_columna","activo");
  	ds.fieldValue("evento_help",new Boolean(false));
  	ds.fieldValue("script_help","");
  }
  
  
  private void cargarColumnasGrillaMetrica(IDataSet ds,
			 DefinicionRepositorioReal defRepoReal) throws BaseException {

  	++secu;
  	String campoFisicoCodigo = "";
  	ds.append();
  	ds.fieldValue("secu", secu);
  	ds.fieldValue("banda", "Métricas");
  	ds.fieldValue("nombre_logico", defRepoReal.getDescripcion());
  	ds.fieldValue("ancho_columna", 50);
  	campoFisicoCodigo = "metrica_"+defRepoReal.getOIDInteger();
  	ds.fieldValue("nombre_fisico", campoFisicoCodigo);
  	ds.fieldValue("tipo_columna", "CurrencyEdit");
  	ds.fieldValue("read_only", new Boolean(false));
  	ds.fieldValue("can_focus", new Boolean(true));
  	ds.fieldValue("formato", "###,###,###,###,###.####");
  	ds.fieldValue("nombre_columna","colName_"+defRepoReal.getOIDInteger()+"_"+secu);
  	ds.fieldValue("evento_help",new Boolean(false));
  	ds.fieldValue("script_help","");
  }
  

  
  private void cargarColumnasGrillaComponente(IDataSet ds,
  																						DefinicionRepositorioReal defRepoReal) throws BaseException {

    ++secu;
    String campoFisicoCodigo = "";
		ds.append();
    ds.fieldValue("secu", secu);
    ds.fieldValue("banda", defRepoReal.getDescripcion());
    ds.fieldValue("nombre_logico", "Cód. "+defRepoReal.getDescripcion());
    ds.fieldValue("ancho_columna", 50);
    campoFisicoCodigo = "cod_val_compo_real_"+defRepoReal.getOIDInteger();
    ds.fieldValue("nombre_fisico", campoFisicoCodigo);
    ds.fieldValue("tipo_columna", "ButtonEdit");
    ds.fieldValue("read_only", new Boolean(false));
    ds.fieldValue("can_focus", new Boolean(true));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","colName_"+defRepoReal.getOIDInteger()+"_"+secu);
    ds.fieldValue("evento_help",new Boolean(true));
    ds.fieldValue("script_help","begin "+
    		                        "HelpValCompoReal.AsignarCodigoA := TValoresRepositorioReal.FieldName('"+campoFisicoCodigo+"'); "+
    														"HelpValCompoReal.clearParams(); "+ 
    														"HelpValCompoReal.addParam('oid_compo_presu',"+
    														defRepoReal.getCompo_presupuestario().getOIDInteger().toString()+
    														"); "+
    														"HelpValCompoReal.Mostrar(); " +
    														"end.");
    
    ++secu;
    String campoFisicoDesc = "";
		ds.append();
    ds.fieldValue("secu", secu);
    ds.fieldValue("banda", defRepoReal.getDescripcion());
    ds.fieldValue("nombre_logico", "Desc. "+defRepoReal.getDescripcion());
    ds.fieldValue("ancho_columna", 50);
    campoFisicoDesc = "desc_val_compo_real_"+defRepoReal.getOIDInteger();
    ds.fieldValue("nombre_fisico", campoFisicoDesc);
    ds.fieldValue("tipo_columna", "");
    ds.fieldValue("read_only", new Boolean(true));
    ds.fieldValue("can_focus", new Boolean(false));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","colName_"+defRepoReal.getOIDInteger()+"_"+secu);
    ds.fieldValue("evento_help",new Boolean(false));
    ds.fieldValue("script_help","");
    
  	
  }
  
  private void cargarColumnasGrillaValRepoReal(
		  							IDataSet ds,
		  							DefinicionRepositorioReal defRepoReal) throws BaseException {
  	
  	if (defRepoReal.isComponente()) 
  		cargarColumnasGrillaComponente(ds,defRepoReal);
  	else
    	if (defRepoReal.isTipoPeriodo()) 
    		cargarColumnasGrillaTipoPeriodo(ds,defRepoReal);
    	else
      	if (defRepoReal.isMetrica()) 
      		cargarColumnasGrillaMetrica(ds,defRepoReal);
  	
  	
  }
  
  private void cargarColumnasGrillasValores(
		  IDataSet ds,
		  RepositorioReal repoReal) throws BaseException {

  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		cargarColumnasGrillaValRepoReal(ds,defRepoReal);
  		
  	}
  	
  	cargarColumnasGrillaActivo(ds);
  	
  
  }
  
  private void cargarEventoBeforePost(IDataSet ds,
  		                                RepositorioReal repoReal) throws BaseException {
  	
  	StringBuffer scriptBeforePost = new StringBuffer("");
  	scriptBeforePost.append("begin ");
  	
  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		if (defRepoReal.isObligatorio()) {
  			
  			String campoCodigo = "cod_val_compo_real_"+defRepoReal.getOIDInteger();
  			scriptBeforePost.append(" if (DataSet.FieldName('"+campoCodigo+"').AsString='') ");
  			scriptBeforePost.append("    then raiseexception(erCustomError, 'Debe ingresar: "+defRepoReal.getDescripcion()+"'); ");
  			
  		}
  		
  	}
  	scriptBeforePost.append("end. ");
  	
  	ds.append();
  	ds.fieldValue("script", scriptBeforePost.toString()); 
  	
  }
  
  private void agregarCamposNroRelacion(IDataSet ds) {
  	
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.INTEGER);
  	ds.fieldValue("nombre_fisico", "nro_rel");
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(true));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.INTEGER);
  	ds.fieldValue("nombre_fisico", "nro_rel_padre");
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.BOOLEAN);
  	ds.fieldValue("nombre_fisico", "activo");
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
  	
  }
  

  private void agregarCamposMetrica(IDataSet ds,
			 DefinicionRepositorioReal defRepoReal) {
  	
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.CURRENCY);
  	ds.fieldValue("nombre_fisico", "metrica_"+defRepoReal.getOIDInteger());
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
  }
  
  private void agregarCamposTipoPeriodo(IDataSet ds,
			 DefinicionRepositorioReal defRepoReal) {
  	
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.DATE);
  	ds.fieldValue("nombre_fisico", "fecha_"+defRepoReal.getOIDInteger());
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
  	
  }
  
  private void agregarCamposComponente(IDataSet ds,
  																		 DefinicionRepositorioReal defRepoReal) throws BaseException {
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.INTEGER);
  	String campoOidValCompoReal = "oid_val_compo_real_"+defRepoReal.getOIDInteger();
  	String descValCompoReal = "desc_val_compo_real_"+defRepoReal.getOIDInteger();
  	ds.fieldValue("nombre_fisico", campoOidValCompoReal);
  	ds.fieldValue("longitud", 0);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");
  	
  	
		// Generar Campo CODIGO Validador Valor componente real
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.STRING);
  	ds.fieldValue("nombre_fisico", "cod_val_compo_real_"+defRepoReal.getOIDInteger());
  	ds.fieldValue("longitud", 50);
  	ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(true));
    ds.fieldValue("tablaAValidar", "TValoresRepositorioReal");
    ds.fieldValue("campoAValidar", "cod_val_compo_real_"+defRepoReal.getOIDInteger());
    ds.fieldValue("scriptValidador", " begin " +
    																 "    operacion.inicioOperacion; "+
    																 "    operacion.setOper('ValCodigoValorCompoReal'); "+
    																 "    operacion.addAtribute('oid_compo_presu',IntToStr("+defRepoReal.getCompo_presupuestario().getOIDInteger()+"));"+
    																 "    operacion.addAtribute('codigo',Sender.AsString); "+
    																 "    operacion.execute; "+
    																 "    if (not TValCompoReal.isEmpty) "+
    																 "       then begin"+
    																 "            TValoresRepositorioReal.FieldName('"+campoOidValCompoReal+"').AsInteger    := TValCompoReal.FieldName('oid_val_compo_real').AsInteger;" +
    																 "            TValoresRepositorioReal.FieldName('"+descValCompoReal+"').AsString  := TValCompoReal.FieldName('descripcion').AsString;" + 
    																 "            end;"+
    																 " end.");
    
  	
		// Generar Campo DESCRIPCION Validador Valor componente real
		++secu;
  	ds.append();
  	ds.fieldValue("secu", new Integer(secu));
  	ds.fieldValue("tipo", Field.STRING);
  	
  	ds.fieldValue("nombre_fisico", descValCompoReal);
  	ds.fieldValue("longitud", 255);
  	ds.fieldValue("primaryKey", new Boolean(false));
  	ds.fieldValue("agregarValidador", new Boolean(false));
  	ds.fieldValue("tablaAValidar", "");
  	ds.fieldValue("campoAValidar", "");
  	ds.fieldValue("scriptValidador", "");  	
  	
  }
  
  private void cargarEstrucCampoTablaValRepoReal(
  		IDataSet ds,
  		DefinicionRepositorioReal defRepoReal) throws BaseException {
  	
  		if (defRepoReal.isComponente()) 
  			agregarCamposComponente(ds,defRepoReal);
  		else
  			if (defRepoReal.isTipoPeriodo())
  				agregarCamposTipoPeriodo(ds,defRepoReal);
    		else
    			if (defRepoReal.isMetrica())
    				agregarCamposMetrica(ds,defRepoReal);
  			
  }
  		
  		
  private void cargarEstrucTabValRepoReal(
  		  			 IDataSet ds,
  		  			 RepositorioReal repoReal) throws BaseException {
  	
  	agregarCamposNroRelacion(ds);
  	
  	Iterator iterDefinicionesRepoReal =  repoReal.getDefinicionesRepoReal().iterator();
  	while (iterDefinicionesRepoReal.hasNext()) {
  		
  		DefinicionRepositorioReal defRepoReal = 
  			(DefinicionRepositorioReal) iterDefinicionesRepoReal.next();
  		
  		cargarEstrucCampoTablaValRepoReal(ds,defRepoReal);
  		
  	}
  	
  }
  
  private IDataSet getDSEventoBeforePostTable() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEventoBeforePost");
    dataset.fieldDef(new Field("script", Field.STRING, 5000));
    return dataset;
  }
  
  
    
  
  
  
}
