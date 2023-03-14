package com.srn.erp.general.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ImpresoraFiscal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposDriversFiscales extends Operation {

  public TraerTiposDriversFiscales() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int oid = 0;
    IDataSet dataset = getDataSetTipo();
    List lista = ImpresoraFiscal.getTiposDrivers();
    Iterator iterLista = lista.iterator();
    while (iterLista.hasNext()) {
      String codImpFis = (String) iterLista.next();
      cargarRegistroTipo(dataset,new Integer(++oid),codImpFis,codImpFis,new Boolean(true));
    }
    writeCliente(dataset);
  }

  private IDataSet getDataSetTipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposDriversFiscales");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
