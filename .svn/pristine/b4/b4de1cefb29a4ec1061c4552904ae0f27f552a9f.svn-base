package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.ObsGeneralesOC;
import com.srn.erp.compras.da.DBObsGeneralesOC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryObsGeneralesOC extends FactoryObjetoLogico { 

  public FactoryObsGeneralesOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsGeneralesOC obsgeneralesoc = (ObsGeneralesOC) objLog;
    obsgeneralesoc.setOID(db.getInteger(DBObsGeneralesOC.OID_OBS_GEN_OC));
    obsgeneralesoc.setCodigo(db.getString(DBObsGeneralesOC.CODIGO));
    obsgeneralesoc.setDescripcion(db.getString(DBObsGeneralesOC.DESCRIPCION));
    obsgeneralesoc.setIncluir_en_oc(db.getBoolean(DBObsGeneralesOC.INC_EN_OC));
    obsgeneralesoc.setOrden(db.getInteger(DBObsGeneralesOC.ORDEN));
    obsgeneralesoc.setActivo(db.getBoolean(DBObsGeneralesOC.ACTIVO));

  }
}
