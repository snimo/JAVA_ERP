package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarValorCompo extends Operation {

  public ValidarValorCompo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Componente componente = null;
    Integer oidCompo      = mapaDatos.getInteger("oid_compo");
    componente            = Componente.findByOid(oidCompo, getSesion());


    String codigo         = mapaDatos.getString("codigo");
    IObjetoLogico valorCompo = componente.getValorCompo(codigo);

    IDataSet datasetValCompo = getDataSetValCompo();

    if (valorCompo!=null) {
      cargarRegistroValCompo(datasetValCompo,
                             valorCompo.getOIDInteger(),
                             valorCompo.getCodigo(),
                             valorCompo.getDescripcion(),
                             valorCompo.isActivo()
                             );
    }

    writeCliente(datasetValCompo);
  }

  private IDataSet getDataSetValCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValidarValCompo");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroValCompo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo",codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);


  }


}
