package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.GrupoModeloCubo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoModeloCubo extends Operation {

  public TraerGrupoModeloCubo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    GrupoModeloCubo grupoModeloCubo = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       grupoModeloCubo = GrupoModeloCubo.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       grupoModeloCubo = GrupoModeloCubo.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetGrupo = getDataSetGrupo();
    if (grupoModeloCubo != null) {
        cargarRegistroGrupo(datasetGrupo,
        		grupoModeloCubo.getOIDInteger(),
        		grupoModeloCubo.getCodigo(),
        		grupoModeloCubo.getDescripcion(),
        		grupoModeloCubo.isActivo());
    }
    writeCliente(datasetGrupo);
  }

  private IDataSet getDataSetGrupo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TGrupoModeloCubo");
    dataset.fieldDef(new Field("oid_grupo_modelo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroGrupo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_grupo_modelo", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
