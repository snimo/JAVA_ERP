package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.da.DBObsCodifVtas;

public class FactoryObsCodifVtas extends FactoryObjetoLogico { 

  public FactoryObsCodifVtas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ObsCodifVtas obscodifvtas = (ObsCodifVtas) objLog;
    obscodifvtas.setOID(db.getInteger(DBObsCodifVtas.OID_OBS_COD));
    obscodifvtas.setCodigo(db.getString(DBObsCodifVtas.CODIGO));
    obscodifvtas.setDescripcion(db.getString(DBObsCodifVtas.DESCRIPCION));
    obscodifvtas.setIncluir(db.getBoolean(DBObsCodifVtas.INCLUIR));
    obscodifvtas.setActivo(db.getBoolean(DBObsCodifVtas.ACTIVO));
    obscodifvtas.setTipo(db.getString(DBObsCodifVtas.TIPO));
    obscodifvtas.setOrden(db.getInteger(DBObsCodifVtas.ORDEN));

  }
}
