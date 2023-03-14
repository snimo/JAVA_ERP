package com.srn.erp.presupuesto.op;


import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoEscenario;
import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.bm.ValorEscenario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEscenario extends Operation { 

  public TraerEscenario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Escenario escenario = Escenario.findByOid(mapaDatos.getInteger("oid"), getSesion());
  	
  	IDataSet dsEscenario = this.getDSEscenario();
  	IDataSet dsCompoEsce = this.getDSCompoEscenario();
  	IDataSet dsValorEsce = this.getDSValoresEscenario();
  	
  	cargarEscenario(dsEscenario,escenario);
  	
  	Iterator iterCompoEsce = escenario.getDetallesCompoEsce().iterator();
  	while (iterCompoEsce.hasNext()) {
  		CompoEscenario compoEscenario = (CompoEscenario) iterCompoEsce.next();
  		cargarCompoEscenario(dsCompoEsce,compoEscenario);
  	}
  	
  	Iterator iterValoresEsce = escenario.getValores().iterator();
  	while (iterValoresEsce.hasNext()) {
  		ValorEscenario valorEscenario = (ValorEscenario) iterValoresEsce.next();
  		cargarValorEscenario(dsValorEsce,valorEscenario);
  	}
  	
  	
    writeCliente(dsEscenario);
    writeCliente(dsCompoEsce);
    writeCliente(dsValorEsce);
    
  }

  private IDataSet getDSEscenario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEscenario");
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarEscenario(IDataSet dataset, 
                               Escenario escenario) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_escenario", escenario.getOIDInteger());
    dataset.fieldValue("codigo", escenario.getCodigo());
    dataset.fieldValue("descripcion", escenario.getDescripcion());
    dataset.fieldValue("activo", escenario.isActivo());
  }
  
  private IDataSet getDSCompoEscenario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompoEscenario");
    dataset.fieldDef(new Field("oid_compo_esce", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nivel", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_compo_presu", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_compo_presu", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarCompoEscenario(IDataSet dataset, 
                                    CompoEscenario compoEscenario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_esce", compoEscenario.getOIDInteger());
    dataset.fieldValue("oid_escenario", compoEscenario.getEscenario().getOIDInteger());
    dataset.fieldValue("nivel", compoEscenario.getNivel());
    dataset.fieldValue("oid_compo_presu", compoEscenario.getCompoPresupuestario().getOIDInteger());
    dataset.fieldValue("cod_compo_presu", compoEscenario.getCompoPresupuestario().getCodigo());
    dataset.fieldValue("desc_compo_presu", compoEscenario.getCompoPresupuestario().getDescripcion());
    dataset.fieldValue("activo", compoEscenario.isActivo());
  }
  
  private IDataSet getDSValoresEscenario() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValoresEscenario");
    dataset.fieldDef(new Field("oid_val_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_compo_presu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor_compo",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_relacion",Field.STRING, 50));
    dataset.fieldDef(new Field("nro_relacion_padre",Field.STRING, 50));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_imagen",Field.INTEGER, 0));
    dataset.fieldDef(new Field("ult_compo",Field.BOOLEAN, 0));
    return dataset;
  }
  
  private void cargarValorEscenario(IDataSet dataset, 
      ValorEscenario valorEscenario) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_val_escenario", valorEscenario.getOIDInteger());
  	dataset.fieldValue("oid_escenario", valorEscenario.getEscenario().getOIDInteger());
  	dataset.fieldValue("descripcion", valorEscenario.getDescripcion());
  	dataset.fieldValue("oid_compo_presu",valorEscenario.getCompo_presu().getOIDInteger());
  	dataset.fieldValue("oid_valor_compo",valorEscenario.getValor_compo().getOIDInteger());
  	dataset.fieldValue("nro_relacion",valorEscenario.getNro_relacion());
  	dataset.fieldValue("nro_relacion_padre",valorEscenario.getNro_relacion_padre());
  	dataset.fieldValue("activo",valorEscenario.isActivo());
  	if (valorEscenario.isActivo().booleanValue())
  		dataset.fieldValue("nro_imagen",new Integer(1));
  	else
  		dataset.fieldValue("nro_imagen",new Integer(2));
  	dataset.fieldValue("ult_compo",valorEscenario.isUltimoNivel());
}
  
  
}
