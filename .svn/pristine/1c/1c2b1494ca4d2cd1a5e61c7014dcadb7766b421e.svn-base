package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefEstrucLPCab extends Operation { 

  public TraerDefEstrucLPCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DefEstrucLPCab defestruclpcab = null;
    
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       defestruclpcab = DefEstrucLPCab.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       defestruclpcab = DefEstrucLPCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetDefEstrucLPCab = getDataSetDefEstrucLPCab();
    IDataSet datasetDefEstrucLPDet = getDataSetDefEstrucLPDet();
    
    if (defestruclpcab != null) { 
        cargarRegistroDefEstrucLPCab(datasetDefEstrucLPCab, 
                         defestruclpcab.getOIDInteger(),
                         defestruclpcab.getCodigo(),
                         defestruclpcab.getDescripcion(),
                         defestruclpcab.isActivo());
        
        Iterator iterDefEstrucLPDet = 
        	defestruclpcab.getDefEstrucLPDet().iterator();
        while (iterDefEstrucLPDet.hasNext()) {
        	DefEstrucLPDet defEstrucLPDet =
        		(DefEstrucLPDet)iterDefEstrucLPDet.next();
        	cargarRegistroDefEstrucLPDet(datasetDefEstrucLPDet,defEstrucLPDet);
        }
        
        
    }
    
    writeCliente(datasetDefEstrucLPCab);
    writeCliente(datasetDefEstrucLPDet);
  }

  private IDataSet getDataSetDefEstrucLPCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDefEstrucLPCab");
    dataset.fieldDef(new Field("oid_def_estruc_lp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroDefEstrucLPCab(IDataSet dataset, 
                         Integer oid_def_estruc_lp,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_def_estruc_lp", oid_def_estruc_lp);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetDefEstrucLPDet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDefEstrucLPDet");
    dataset.fieldDef(new Field("oid_def_det_lp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_def_estruc_lp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_clasif_art_1", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_art_1", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_art_1", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_clasif_art_2", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_art_2", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_art_2", Field.STRING, 100));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroDefEstrucLPDet(IDataSet dataset, 
  		                                      DefEstrucLPDet defEstrucLPDet) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_def_det_lp", defEstrucLPDet.getOIDInteger());
    dataset.fieldValue("oid_def_estruc_lp", defEstrucLPDet.getDef_estruc_lp().getOIDInteger());
    dataset.fieldValue("oid_clasif_art_1", defEstrucLPDet.getValor_clasif_art_1().getOIDInteger());
    dataset.fieldValue("cod_clasif_art_1", defEstrucLPDet.getValor_clasif_art_1().getCodigo());
    dataset.fieldValue("desc_clasif_art_1", defEstrucLPDet.getValor_clasif_art_1().getDescripcion());
    dataset.fieldValue("oid_clasif_art_2", defEstrucLPDet.getValor_clasif_art_2().getOIDInteger());
    dataset.fieldValue("cod_clasif_art_2", defEstrucLPDet.getValor_clasif_art_2().getCodigo());
    dataset.fieldValue("desc_clasif_art_2", defEstrucLPDet.getValor_clasif_art_2().getDescripcion());
    dataset.fieldValue("orden", defEstrucLPDet.getOrden());
    dataset.fieldValue("activo", defEstrucLPDet.isActivo());
  }  
  
}
