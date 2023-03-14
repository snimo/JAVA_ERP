package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientoConcImpu extends Operation {

  public TraerComportamientoConcImpu() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
       Integer oid = mapaDatos.getInteger("oid_conc_impu");
       ConceptoImpuesto concimpu = ConceptoImpuesto.findByOid(oid, getSesion());
       
       IDataSet dsCompo = this.getDataSetComportamiento();
       cargarRegistroComportamiento(dsCompo,concimpu);
       writeCliente(dsCompo);
    
  }

  private IDataSet getDataSetComportamiento() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCompoConcImpu");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroComportamiento(IDataSet dataset,
                         ConceptoImpuesto conceptoImpuesto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", conceptoImpuesto.getOIDInteger());
    dataset.fieldValue("codigo", conceptoImpuesto.getCodigo());
    dataset.fieldValue("descripcion", conceptoImpuesto.getDescripcion());
    dataset.fieldValue("comportamiento", conceptoImpuesto.getImpuesto().getCompo());
  }
}