package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConcLiqTarjeta extends Operation {

  public TraerConcLiqTarjeta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  	IDataSet ds = this.getDataSetConcLiqTar();
	  	Iterator iterConcLiqTar = 
	  		ConceptoLiqTarjeta.getAllConceptosActivos(this.getSesion()).iterator();
	  	while (iterConcLiqTar.hasNext()) {
	  		ConceptoLiqTarjeta conceptoLiquidacion = (ConceptoLiqTarjeta) iterConcLiqTar.next();
	  		cargarRegistroCaja(ds, conceptoLiquidacion);
	  	}
	  	writeCliente(ds);
  }

  private IDataSet getDataSetConcLiqTar() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConceptoLiqTarjeta");
    dataset.fieldDef(new Field("oid_conc_liq_tar", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroCaja(IDataSet dataset,
                         		  ConceptoLiqTarjeta conceptoLiquidacion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conc_liq_tar", conceptoLiquidacion.getOIDInteger());
    dataset.fieldValue("codigo", conceptoLiquidacion.getCodigo());
    dataset.fieldValue("descripcion", conceptoLiquidacion.getDescripcion());
  }
}
