package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresComponente extends Operation {

  public TraerValoresComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException  {

    IDataSet dataSetValoresCompo = getDataSetValoresComponente();
    Componente componente        =
        Componente.findByOid(mapaDatos.getInteger("oid_componente"),getSesion());

    Iterator iterValoresCompo = componente.getValoresCompo().iterator();
    while (iterValoresCompo.hasNext()) {
      IObjetoLogico objLog = (IObjetoLogico) iterValoresCompo.next();
      cargarRegistroValorComponente(dataSetValoresCompo,
                                    objLog.getOIDInteger().intValue(),
                                    objLog.getCodigo(),
                                    objLog.getDescripcion());

    }

    writeCliente(dataSetValoresCompo);
  }

  private IDataSet getDataSetValoresComponente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresComponente");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroValorComponente(IDataSet dataset,
                                             int oidValorCompo,
                                             String codigo,
                                             String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oidValorCompo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
