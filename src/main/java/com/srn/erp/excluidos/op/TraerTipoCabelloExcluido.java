package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.TipoCabelloExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCabelloExcluido extends Operation { 

  public TraerTipoCabelloExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoCabelloExcluido tipocabelloexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipocabelloexcluido = TipoCabelloExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipocabelloexcluido = TipoCabelloExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoCabelloExcluido = getDataSetTipoCabelloExcluido();
    if (tipocabelloexcluido != null) { 
        cargarRegistroTipoCabelloExcluido(datasetTipoCabelloExcluido, 
                         tipocabelloexcluido);
    }
    writeCliente(datasetTipoCabelloExcluido);
  }

  private IDataSet getDataSetTipoCabelloExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoCabelloExcluido");
    dataset.fieldDef(new Field("oid_tipo_cabello", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoCabelloExcluido(IDataSet dataset, 
                         TipoCabelloExcluido tipoCabello) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_cabello", tipoCabello.getOIDInteger());
    dataset.fieldValue("codigo", tipoCabello.getCodigo());
    dataset.fieldValue("descripcion", tipoCabello.getDescripcion());
    dataset.fieldValue("activo", tipoCabello.isActivo());
  }
}
