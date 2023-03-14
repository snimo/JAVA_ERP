package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.da.DBProvincia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProvincia extends FactoryObjetoLogico {

  public FactoryProvincia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Provincia provincia = (Provincia) objLog;
    provincia.setOID(db.getInteger(DBProvincia.OID_PROVINCIA));
    provincia.setCodigo(db.getString(DBProvincia.CODIGO));
    provincia.setDescripcion(db.getString(DBProvincia.DESCRIPCION));
    provincia.setActivo(db.getBoolean(DBProvincia.ACTIVO));
    provincia.setEsBuenosAires(db.getBoolean(DBProvincia.ES_BS_AS).booleanValue());
    provincia.setEsCapitalFederal(db.getBoolean(DBProvincia.ES_CAP_FED).booleanValue());
    provincia.setCalcPercIBBA(db.getBoolean(DBProvincia.CALC_PERC_IB_BA).booleanValue());
    
  }
}
