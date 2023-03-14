package com.srn.erp.general.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposValorClasificador extends Operation {

  public TraerTiposValorClasificador() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {    
    IDataSet datasetTipoValClasif = getDataSetTipoValClasif();
    cargarRegistroTipoValClasif(datasetTipoValClasif,new Integer(1),ValorClasificadorEntidad.TIPO_TITULO,"Título");
    cargarRegistroTipoValClasif(datasetTipoValClasif,new Integer(2),ValorClasificadorEntidad.TIPO_RANGO,"Rango");
    writeCliente(datasetTipoValClasif);
  }

  private IDataSet getDataSetTipoValClasif() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposValClasif");
    dataset.fieldDef(new Field("oid_tipo_val_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroTipoValClasif(IDataSet dataset,
                         Integer oidTipoValClasif,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid_tipo_val_clasif", oidTipoValClasif);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
