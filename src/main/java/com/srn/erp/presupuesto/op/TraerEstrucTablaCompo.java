package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstrucTablaCompo extends Operation { 

	public String BANDA_PRINCIPAL = "";
	
  public TraerEstrucTablaCompo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet dsEstrucTablaCompoPresu 		= this.getDSEstrucTablaCompoPresu();
    IDataSet dsColumnasGrillaValores    = this.getDSColumnasGrillaValores();
    IDataSet dsDatosCompo               = this.getDSDatosCompo(); 
    
    CompoPresupuestario compoPresu = 
    	CompoPresupuestario.findByOidProxy(mapaDatos.getInteger("oid_compo_presu"),this.getSesion());
    
    BANDA_PRINCIPAL = compoPresu.getDescripcion();
    
    cargarEstrucTabCompoPresu(dsEstrucTablaCompoPresu,compoPresu);
    cargarColumnasGrillasValores(dsColumnasGrillaValores,compoPresu);
    cargarDatosCompo(dsDatosCompo,compoPresu);
    
    writeCliente(dsEstrucTablaCompoPresu);    
    writeCliente(dsColumnasGrillaValores);
    writeCliente(dsDatosCompo);
    
  }
  
  private IDataSet getDSEstrucTablaCompoPresu() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstrucTablaCompoPresu");
    
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
    dataset.fieldDef(new Field("script_help",Field.STRING, 1000));
    
    return dataset;
  }
  
  private IDataSet getDSDatosCompo() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDatosCompo");
    
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }  
  
  private void cargarColumnasGrillasValores(
		  IDataSet ds,
		  CompoPresupuestario compoPresu) throws BaseException {
	
	  // Código del Valor presupuestario 
	  ds.append();
    ds.fieldValue("secu", 1);
    ds.fieldValue("banda", BANDA_PRINCIPAL);
    ds.fieldValue("nombre_logico", "Código");
    ds.fieldValue("ancho_columna", 50);
    ds.fieldValue("nombre_fisico", "codigo");
    ds.fieldValue("tipo_columna", "");
    ds.fieldValue("read_only", new Boolean(false));
    ds.fieldValue("can_focus", new Boolean(true));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","");
    ds.fieldValue("evento_help",new Boolean(false));
    ds.fieldValue("script_help","");
        
    
	  // Descripción del Valor presupuestario 
	  ds.append();
    ds.fieldValue("secu", 2);
    ds.fieldValue("banda", BANDA_PRINCIPAL);
    ds.fieldValue("nombre_logico", "Descripción");
    ds.fieldValue("ancho_columna", 100);
    ds.fieldValue("nombre_fisico", "descripcion");
    ds.fieldValue("tipo_columna", "");
    ds.fieldValue("read_only", new Boolean(false));
    ds.fieldValue("can_focus", new Boolean(true));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","");
    ds.fieldValue("evento_help",new Boolean(false));
    ds.fieldValue("script_help","");
        
	  // Activo
	  ds.append();
    ds.fieldValue("secu", 3);
    ds.fieldValue("banda", BANDA_PRINCIPAL);
    ds.fieldValue("nombre_logico", "Activo");
    ds.fieldValue("ancho_columna", 30);
    ds.fieldValue("nombre_fisico", "activo");
    ds.fieldValue("tipo_columna", "CheckBox");
    ds.fieldValue("read_only", new Boolean(false));
    ds.fieldValue("can_focus", new Boolean(true));
    ds.fieldValue("formato", "");
    ds.fieldValue("nombre_columna","");
    ds.fieldValue("evento_help",new Boolean(false));
    ds.fieldValue("script_help","");
    
    
    // AGREGAR CODIGO PARA INSERTAR A PARTIR DE AQUI LOS ATRIBUTOS DEL COMPONENTE PRESUPUESTARIO
    int secu = 3;
  	Iterator iterDefAtri = compoPresu.getDefAtributos().iterator();
  	while (iterDefAtri.hasNext()) {
  		
  		AtriCompoPresu atriCompoPresu = (AtriCompoPresu) iterDefAtri.next();
  		if (!atriCompoPresu.isActivo().booleanValue()) continue;
  		
    	if (atriCompoPresu.isCompoCodigoDescripcion()) {
        
    		// Codigo del atributo componente presupuestario
        ++secu;
    		ds.append();
        ds.fieldValue("secu", secu + atriCompoPresu.getNro_orden().intValue());
        ds.fieldValue("banda", atriCompoPresu.getCompo_presu_atri().getDescripcion());
        ds.fieldValue("nombre_logico", "Cód. "+atriCompoPresu.getNombre_logico());
        ds.fieldValue("ancho_columna", 50);
        ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoCodigoCompo());
        ds.fieldValue("tipo_columna", "ButtonEdit");
        ds.fieldValue("read_only", new Boolean(false));
        ds.fieldValue("can_focus", new Boolean(true));
        ds.fieldValue("formato", "");
        ds.fieldValue("nombre_columna","colName_"+atriCompoPresu.getOIDInteger());
        ds.fieldValue("evento_help",new Boolean(true));
        ds.fieldValue("script_help","begin "+
        		                        "HelpValCompoPresu.AsignarCodigoA := TValoresCompoPresu.FieldName('"+atriCompoPresu.getCampoCodigoCompo()+"'); "+
        														"HelpValCompoPresu.clearParams(); "+ 
        														"HelpValCompoPresu.addParam('oid_compo_presu',"+
        														atriCompoPresu.getCompo_presu_atri().getOIDInteger().toString()+
        														"); "+
        														"HelpValCompoPresu.Mostrar(); " +
        														"end.");
        

    		// Descripcion del atributo componente presupuestario
        ++secu;
    		ds.append();
        ds.fieldValue("secu", secu + atriCompoPresu.getNro_orden().intValue());
        ds.fieldValue("banda", atriCompoPresu.getCompo_presu_atri().getDescripcion());
        ds.fieldValue("nombre_logico", "Desc. "+atriCompoPresu.getNombre_logico());
        ds.fieldValue("ancho_columna", 50);
        ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoDescCompo());
        ds.fieldValue("tipo_columna", "");
        ds.fieldValue("read_only", new Boolean(true));
        ds.fieldValue("can_focus", new Boolean(false));
        ds.fieldValue("formato", "");
        ds.fieldValue("nombre_columna","");
        ds.fieldValue("evento_help",new Boolean(false));
        ds.fieldValue("script_help","");
        
        
    	} else {
    		
    		++secu;
    		ds.append();
        ds.fieldValue("secu", secu + atriCompoPresu.getNro_orden().intValue());
        ds.fieldValue("banda", atriCompoPresu.getDescripcion());
        ds.fieldValue("nombre_logico", atriCompoPresu.getNombre_logico());
        ds.fieldValue("ancho_columna", 50);
        ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoTabla());
        
        if (atriCompoPresu.isCompoDecimal()) 
        		ds.fieldValue("tipo_columna", "CurrencyEdit");
        else
          if (atriCompoPresu.isCompoEntero()) 
        		ds.fieldValue("tipo_columna", "CurrencyEdit");
          else
            if (atriCompoPresu.isCompoFecha()) 
          		ds.fieldValue("tipo_columna", "DateEdit");
            else
            	ds.fieldValue("tipo_columna", "");
        
        ds.fieldValue("read_only", new Boolean(false));
        ds.fieldValue("can_focus", new Boolean(true));
        ds.fieldValue("formato", atriCompoPresu.getFormato());
        ds.fieldValue("nombre_columna","");
        ds.fieldValue("evento_help",new Boolean(false));
        ds.fieldValue("script_help","");
        
    	}
    	
  	}
    
    
  
  }
  

  private void cargarDatosCompo(
    		  IDataSet ds,
    		  CompoPresupuestario compoPresupuestario) throws BaseException {
  	
  	ds.append();
  	ds.fieldValue("oid_compo_presu", compoPresupuestario.getOIDInteger());
  	ds.fieldValue("codigo", compoPresupuestario.getCodigo());
  	ds.fieldValue("descripcion", compoPresupuestario.getDescripcion());
  	
  }
  		
  		
  private void cargarEstrucTabCompoPresu(
  		  IDataSet ds,
  		  CompoPresupuestario compoPresupuestario) throws BaseException {
  	
  	// OID correspondiente el valor del componente presupuestario 
  	ds.append();
    ds.fieldValue("secu", 1);
    ds.fieldValue("tipo", Field.INTEGER);
    ds.fieldValue("nombre_fisico", "oid_val_compo");
    ds.fieldValue("longitud", 0);
    ds.fieldValue("primaryKey", new Boolean(true));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    
    
    // OID Correspondiente al componente presupuestario
  	ds.append();
    ds.fieldValue("secu", 2);
    ds.fieldValue("tipo", Field.INTEGER);
    ds.fieldValue("nombre_fisico", "oid_compo_presu");
    ds.fieldValue("longitud", 0);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    // Código del componentes presupuestario
  	ds.append();
    ds.fieldValue("secu", 3);
    ds.fieldValue("tipo", Field.STRING);
    ds.fieldValue("nombre_fisico", "codigo");
    ds.fieldValue("longitud", 50);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    // Descripción del componente presupuestario
  	ds.append();
    ds.fieldValue("secu", 4);
    ds.fieldValue("tipo", Field.STRING);
    ds.fieldValue("nombre_fisico", "descripcion");
    ds.fieldValue("longitud", 100);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    // Nro. de relación
  	ds.append();
    ds.fieldValue("secu", 5);
    ds.fieldValue("tipo", Field.INTEGER);
    ds.fieldValue("nombre_fisico", "nro_rel");
    ds.fieldValue("longitud", 0);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    // Nro. de relación Padre
  	ds.append();
    ds.fieldValue("secu", 5);
    ds.fieldValue("tipo", Field.INTEGER);
    ds.fieldValue("nombre_fisico", "nro_rel_padre");
    ds.fieldValue("longitud", 0);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    // Activo
  	ds.append();
    ds.fieldValue("secu", 6);
    ds.fieldValue("tipo", Field.BOOLEAN);
    ds.fieldValue("nombre_fisico", "activo");
    ds.fieldValue("longitud", 0);
    ds.fieldValue("primaryKey", new Boolean(false));
    ds.fieldValue("agregarValidador", new Boolean(false));
    ds.fieldValue("tablaAValidar", "");
    ds.fieldValue("campoAValidar", "");
    ds.fieldValue("scriptValidador", "");
    
    cargarDefCamposAtributos(ds,7,compoPresupuestario);
    
  }
  
  private void cargarDefCamposAtributos(IDataSet ds,
  																			int primerSecu,
  																			CompoPresupuestario compoPresu) throws BaseException {
  	
  	Iterator iterDefAtri = compoPresu.getDefAtributos().iterator();
  	while (iterDefAtri.hasNext()) {
  		AtriCompoPresu atriCompoPresu = (AtriCompoPresu) iterDefAtri.next();
  		if (!atriCompoPresu.isActivo().booleanValue()) continue;
  		
  		ds.append();
      ds.fieldValue("secu", primerSecu);
      ds.fieldValue("tipo", atriCompoPresu.getTipoCampo());
      ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoTabla());
      ds.fieldValue("longitud", atriCompoPresu.getSizeCampo());
      ds.fieldValue("primaryKey", new Boolean(false));
      ds.fieldValue("agregarValidador", new Boolean(false));
      ds.fieldValue("tablaAValidar", "");
      ds.fieldValue("campoAValidar", "");
      ds.fieldValue("scriptValidador", "");
      
  		
    	if (atriCompoPresu.isCompoCodigoDescripcion()) {
        
    		// Codigo del atributo componente presupuestario
        ++primerSecu;
    		ds.append();
        ds.fieldValue("secu", primerSecu);
        ds.fieldValue("tipo", Field.STRING);
        ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoCodigoCompo());
        ds.fieldValue("longitud", 50);
        ds.fieldValue("primaryKey", new Boolean(false));
        ds.fieldValue("agregarValidador", new Boolean(true));
        ds.fieldValue("tablaAValidar", "TValoresCompoPresu");
        ds.fieldValue("campoAValidar", atriCompoPresu.getCampoCodigoCompo());
        ds.fieldValue("scriptValidador", "begin " +
        																 " operacion.inicioOperacion; "+
        																 " operacion.setOper('ValCodigoValorCompoPresu'); "+
        																 " operacion.addAtribute('oid_compo_presu',IntToStr("+atriCompoPresu.getCompo_presu_atri().getOIDInteger()+"));"+
        																 " operacion.addAtribute('codigo',Sender.AsString); "+
        																 " operacion.execute; "+
        																 " if (not TValCompoPresu.isEmpty) "+
        																 "    then begin"+
        																 "         TValoresCompoPresu.FieldName('"+atriCompoPresu.getCampoTabla()+"').AsInteger    := TValCompoPresu.FieldName('oid_val_compo_presu').AsInteger;" +
        																 "         TValoresCompoPresu.FieldName('"+atriCompoPresu.getCampoDescCompo()+"').AsString  := TValCompoPresu.FieldName('descripcion').AsString;" + 
        																 "         end;"+
        																 "end.");

    		// Descripcion del atributo componente presupuestario
        ++primerSecu;
    		ds.append();
        ds.fieldValue("secu", primerSecu);
        ds.fieldValue("tipo", Field.STRING);
        ds.fieldValue("nombre_fisico", atriCompoPresu.getCampoDescCompo());
        ds.fieldValue("longitud", 100);
        ds.fieldValue("primaryKey", new Boolean(false));
        ds.fieldValue("agregarValidador", new Boolean(false));
        ds.fieldValue("tablaAValidar", "");
        ds.fieldValue("campoAValidar", "");
        ds.fieldValue("scriptValidador", "");
        
    		
    	} 
    	
   		++primerSecu;
  	}
  	
  }
  
  
  
  
}
