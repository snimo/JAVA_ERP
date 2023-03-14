package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAsiCierre extends Operation {

  public TraerTiposAsiCierre() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = this.getDataSetTiposAsiCierre();
	cargarRegistro(ds, ComproCierreEjercicio.CIERRE_PATRI, ComproCierreEjercicio.getDescTipoCierre(ComproCierreEjercicio.CIERRE_PATRI));
	cargarRegistro(ds, ComproCierreEjercicio.CIERRE_RESUL, ComproCierreEjercicio.getDescTipoCierre(ComproCierreEjercicio.CIERRE_RESUL));
	writeCliente(ds);

  }

  private IDataSet getDataSetTiposAsiCierre() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposAsiCierre");
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
