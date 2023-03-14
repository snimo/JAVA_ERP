package com.srn.erp.general.op;

import com.srn.erp.general.bm.GrupoClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoClasificadorEntidad extends Operation {

  public SaveGrupoClasificadorEntidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TGrupoClasificadorEntidad");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        GrupoClasificadorEntidad grupoclasificadorentidad = GrupoClasificadorEntidad.findByOid(dataset.getInteger("oid_grupo_clasif"),getSesion());
        grupoclasificadorentidad.setOID(dataset.getInteger("oid_grupo_clasif"));
        grupoclasificadorentidad.setCodigo(dataset.getString("codigo"));
        grupoclasificadorentidad.setDescripcion(dataset.getString("descripcion"));
        grupoclasificadorentidad.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupoclasificadorentidad);
        dataset.next();
    }
  }

}
