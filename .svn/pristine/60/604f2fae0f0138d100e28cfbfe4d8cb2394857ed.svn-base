package com.srn.erp.presupuesto.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCombiValCompoEsce extends Operation { 

	int secu = -1;
	List listaNodosPadresActual = new ArrayList();
	List listaNodosPadresAnterior = new ArrayList();
	
	private static final int IMAGEN_RAMA = 0;
	private static final int IMAGEN_ACTIVADO = 1;
	
	public TraerCombiValCompoEsce() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

  	IDataSet dsValoresEscenario = this.getDSValoresEscenario();
  	Integer oidEscenario = mapaDatos.getInteger("oid_escenario");
  	
  	String raizPadre = "RAIZ";
  	listaNodosPadresAnterior.add(raizPadre);
  	int cantCompo = 1;
  	
  	IDataSet dsCompoEsce = mapaDatos.getDataSet("TCompoEscenario");
  	dsCompoEsce.first();
  	while (!dsCompoEsce.EOF()) {
  		
  		//dsCompoEsce
  		boolean ultimoCompo = false;
  		if (cantCompo == dsCompoEsce.getCount())
  			ultimoCompo = true;
  		
  		CompoPresupuestario compoPresu = 
  			CompoPresupuestario.findByOid(dsCompoEsce.getInteger("oid_compo_presu"),this.getSesion());
  		
  		Iterator iterValores = compoPresu.getValores().iterator();
  		while (iterValores.hasNext()) {
  			
  			ValorCompoPresu valorCompoPresu = (ValorCompoPresu) iterValores.next();
  			if (!valorCompoPresu.isActivo().booleanValue()) continue;
  			
  			// Agregar Nodo
  			agregarNodo(valorCompoPresu,
  					        dsValoresEscenario,
  					        oidEscenario,
  					        listaNodosPadresAnterior,
  					        ultimoCompo);  			
  			
  		}
  		
  		listaNodosPadresAnterior.clear();
  		listaNodosPadresAnterior.addAll(listaNodosPadresActual);
  		listaNodosPadresActual.clear();
  		
  		dsCompoEsce.next();
  		++cantCompo;
  	}
  	
    writeCliente(dsValoresEscenario);    
    
  }
  
  private void agregarNodo(ValorCompoPresu valorCompoPresu,
  												 IDataSet ds, 
  												 Integer oidEscenario,
  												 List listaNodosPadres,
  												 boolean ultimoCompo) throws BaseException {
  	
  	Iterator iterNodosPadres = listaNodosPadres.iterator();
  	while (iterNodosPadres.hasNext()) {
  		String relacionPadre = (String) iterNodosPadres.next();
  		String claveUnicaNodo = getClaveValor(valorCompoPresu)+"_"+relacionPadre;
  		
    	--secu;
    	ds.append();
    	ds.fieldValue("oid_val_escenario",new Integer(secu));
    	ds.fieldValue("oid_escenario",oidEscenario);
    	ds.fieldValue("descripcion",valorCompoPresu.getDescripcion());
    	ds.fieldValue("oid_compo_presu",valorCompoPresu.getCompoPresupuestario().getOIDInteger());
    	ds.fieldValue("oid_valor_compo", valorCompoPresu.getOIDInteger());
    	ds.fieldValue("nro_relacion",claveUnicaNodo);
    	ds.fieldValue("nro_relacion_padre",relacionPadre);
    	ds.fieldValue("activo",new Boolean(true));
    	if (ultimoCompo)
    		ds.fieldValue("nro_imagen",IMAGEN_ACTIVADO);
    	else
    		ds.fieldValue("nro_imagen",IMAGEN_RAMA);
    	ds.fieldValue("ult_compo",new Boolean(ultimoCompo));
    	
    	listaNodosPadresActual.add(claveUnicaNodo);
    	
    	
  	}
  	
  }
  
  private String getClaveValor(ValorCompoPresu valorCompoPresu) throws BaseException {
  	return valorCompoPresu.getCompoPresupuestario().getCodigo()+"_"+ valorCompoPresu.getOIDInteger().toString();
  }
  
  private IDataSet getDSValoresEscenario() throws BaseException {
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresEscenario");
    
    dataset.fieldDef(new Field("oid_val_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_compo_presu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor_compo",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_relacion",Field.STRING, 100));
    dataset.fieldDef(new Field("nro_relacion_padre",Field.STRING, 100));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_imagen",Field.INTEGER, 0));
    dataset.fieldDef(new Field("ult_compo",Field.BOOLEAN, 0));
    
    return dataset;
  }
    
    
  
}
