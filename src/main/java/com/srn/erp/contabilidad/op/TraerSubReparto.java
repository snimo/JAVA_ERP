package com.srn.erp.contabilidad.op;


import java.util.Iterator;

import com.srn.erp.contabilidad.bm.SubReparto;
import com.srn.erp.contabilidad.bm.SubRepartoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSubReparto extends Operation { 

  public TraerSubReparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SubReparto subreparto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       subreparto = SubReparto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       subreparto = SubReparto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSubReparto = getDataSetSubReparto();
    IDataSet datasetSubRepartoDet = getDataSetSubRepartoDet();
    
    if (subreparto != null) {
    	
        cargarRegistroSubReparto(datasetSubReparto, 
                         subreparto.getOIDInteger(),
                         subreparto.getCodigo(),
                         subreparto.getDescripcion(),
                         subreparto.isActivo());
        
        Iterator iterSubRepDet =
        	subreparto.getSubRepartosDet().iterator();
        while (iterSubRepDet.hasNext()) {
        	SubRepartoDet subRepartoDet = (SubRepartoDet) iterSubRepDet.next();
        	cargarRegistroSubRepartoDet(datasetSubRepartoDet,subRepartoDet);
        }
        
    }
    
    writeCliente(datasetSubReparto);
    writeCliente(datasetSubRepartoDet);
    
  }

  private IDataSet getDataSetSubReparto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSubReparto");
    dataset.fieldDef(new Field("oid_subreparto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetSubRepartoDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TSubRepartoDet");
	    dataset.fieldDef(new Field("oid_sub_det", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_subreparto", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_fase", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_fase", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }  

  private void cargarRegistroSubReparto(IDataSet dataset, 
                         Integer oid_subreparto,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_subreparto", oid_subreparto);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private void cargarRegistroSubRepartoDet(IDataSet dataset, 
                                           SubRepartoDet subRepDet) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_sub_det", subRepDet.getOIDInteger());
	  dataset.fieldValue("secu", subRepDet.getSecu());
	  dataset.fieldValue("oid_subreparto", subRepDet.getSubreparto().getOIDInteger());
	  dataset.fieldValue("oid_fase", subRepDet.getFase().getOIDInteger());
	  dataset.fieldValue("cod_fase", subRepDet.getFase().getCodigo());
	  dataset.fieldValue("desc_fase", subRepDet.getFase().getDescripcion());
	  dataset.fieldValue("activo", subRepDet.isActivo());
  }
  
  
}
