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

public class TraerHelpValoresComponente extends Operation {

  public TraerHelpValoresComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

  	String tableName = mapaDatos.getString("tableName");
    IDataSet dataset = getDataSet(tableName);

  	Componente componente = Componente.findByOid(mapaDatos.getInteger("oid_compo"),this.getSesion());
  	Iterator iterValoresCompo = componente.getValoresCompo().iterator();
  	while (iterValoresCompo.hasNext()) {
  		IObjetoLogico objLog = (IObjetoLogico) iterValoresCompo.next();
      cargarRegistroDataSet(dataset,
          objLog.getOIDInteger().intValue(),
          objLog.getCodigo(),
          objLog.getDescripcion(),
          objLog.isActivo().booleanValue());
  	}

    // devolver el dataset al cliente
    writeCliente(dataset);

  }

  private IDataSet getDataSet(String tableName) {
    IDataSet dataset = new TDataSet();
    dataset.create(tableName);
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroDataSet(IDataSet dataset,
                                     int oid,
                                     String codigo,
                                     String descripcion,
                                     boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", new Boolean(activo));
  }

}
