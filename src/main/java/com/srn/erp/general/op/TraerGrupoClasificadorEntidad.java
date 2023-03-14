package com.srn.erp.general.op;

import com.srn.erp.general.bm.GrupoClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoClasificadorEntidad extends Operation {

  public TraerGrupoClasificadorEntidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    GrupoClasificadorEntidad grupoclasificadorentidad = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       grupoclasificadorentidad = GrupoClasificadorEntidad.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       grupoclasificadorentidad = GrupoClasificadorEntidad.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetGrupoClasificadorEntidad = getDataSetGrupoClasificadorEntidad();
    if (grupoclasificadorentidad != null) {
        cargarRegistroGrupoClasificadorEntidad(datasetGrupoClasificadorEntidad,
                         grupoclasificadorentidad.getOIDInteger(),
                         grupoclasificadorentidad.getCodigo(),
                         grupoclasificadorentidad.getDescripcion(),
                         grupoclasificadorentidad.isActivo());
    }
    writeCliente(datasetGrupoClasificadorEntidad);
  }

  private IDataSet getDataSetGrupoClasificadorEntidad() {
    IDataSet dataset = new TDataSet();
    dataset.create("TGrupoClasificadorEntidad");
    dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroGrupoClasificadorEntidad(IDataSet dataset,
                         Integer oid_grupo_clasif,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_grupo_clasif", oid_grupo_clasif);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
