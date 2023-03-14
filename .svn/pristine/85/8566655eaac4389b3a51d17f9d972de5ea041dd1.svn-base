package com.srn.erp.general.op;

import com.srn.erp.general.bm.Pais;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPais extends Operation {

  public TraerPais() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    Pais pais = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       pais = Pais.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       pais = Pais.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetPais = getDataSetPais();
    if (pais != null) {
        cargarRegistroPais(datasetPais,
                         pais.getOIDInteger(),
                         pais.getCodigo(),
                         pais.getDescripcion(),
                         pais.isActivo());
    }
    writeCliente(datasetPais);
  }

  private IDataSet getDataSetPais() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPais");
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 5));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroPais(IDataSet dataset,
                         Integer oid_pais,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_pais", oid_pais);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
