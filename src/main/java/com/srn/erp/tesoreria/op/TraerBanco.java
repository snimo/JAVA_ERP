package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.Banco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerBanco extends Operation {

  public TraerBanco() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Banco banco = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       banco = Banco.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       banco = Banco.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetBanco = getDataSetBanco();
    if (banco != null) {
        cargarRegistroBanco(datasetBanco,
                         banco.getOIDInteger(),
                         banco.getCodigo(),
                         banco.getDescripcion(),
                         banco.isActivo());
    }
    writeCliente(datasetBanco);
  }

  private IDataSet getDataSetBanco() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBanco");
    dataset.fieldDef(new Field("oid_banco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroBanco(IDataSet dataset,
                         Integer oid_banco,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_banco", oid_banco);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
