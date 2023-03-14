package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoByNro extends Operation {

  public TraerCompoByNro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Componente componente = null;
    String nickName = mapaDatos.getString("nickname");
    Integer nroClasificador = mapaDatos.getInteger("nro_clasificador");

    componente = Componente.getComponente(nickName,nroClasificador,getSesion());

    IDataSet datasetComponente = getDataSetComponente();

    if (componente != null)
        cargarRegistroComponente(datasetComponente,
                         componente.getOIDInteger(),
                         componente.getCodigo(),
                         componente.getDescripcion(),
                         componente.getTipo(),
                         componente.isActivo(),
                         componente.getNombreNickName(),
                         componente.getNroClasificador()
                         );

    writeCliente(datasetComponente);
  }

  private IDataSet getDataSetComponente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComponenteClasif");
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 6));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroComponente(IDataSet dataset,
                         Integer oid_compo,
                         String codigo,
                         String descripcion,
                         String tipo,
                         Boolean activo,
                         String nombreNickname,
                         Integer nroClasificador) {
    dataset.append();
    dataset.fieldValue("oid_compo", oid_compo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("activo", activo);
    if (nombreNickname!=null)
      dataset.fieldValue("nombre_nickname", nombreNickname);
    else
      dataset.fieldValue("nombre_nickname", "");
    if (nroClasificador!=null)
      dataset.fieldValue("nro_clasificador", nroClasificador);
    else
      dataset.fieldValue("nro_clasificador", "");
  }


}
