package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Banco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpBancos extends Operation {

  public TraerHelpBancos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    IDataSet ds = getDataSetBancos();
    traerBancos(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerBancos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    HashTableDatos condiciones = new HashTableDatos();

    if (mapaDatos.containsKey("codigo"))
      condiciones.put("codigo",mapaDatos.getString("codigo"));

    if (mapaDatos.containsKey("descripcion"))
      condiciones.put("descripcion",mapaDatos.getString("descripcion"));

    Iterator iterBancos =
        Banco.getHelpBancos(condiciones,getSesion()).iterator();
    while (iterBancos.hasNext()) {
      Banco banco = (Banco) iterBancos.next();
      cargarRegistroBanco(dataSet,
                          banco.getOIDInteger(),
                          banco.getCodigo(),
                          banco.getDescripcion(),
                          banco.isActivo());
    }

  }

  private IDataSet getDataSetBancos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TBancos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 80));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroBanco(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion,
                                       Boolean activo) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo",activo);
  }

}
