package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.da.DBSancionesRRHH;

public class FactorySancionesRRHH extends FactoryObjetoLogico { 

  public FactorySancionesRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SancionesRRHH sancionesrrhh = (SancionesRRHH) objLog;
    sancionesrrhh.setOID(db.getInteger(DBSancionesRRHH.OID_MOT_SANCION));
    sancionesrrhh.setCodigo(db.getString(DBSancionesRRHH.CODIGO));
    sancionesrrhh.setDescripcion(db.getString(DBSancionesRRHH.DESCRIPCION));
    sancionesrrhh.setActivo(db.getBoolean(DBSancionesRRHH.ACTIVO));
    sancionesrrhh.setExcluirEnPlanifRotas(db.getBoolean(DBSancionesRRHH.EXC_PLANIF_ROTAS));

  }
}
