package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;
import com.srn.erp.ventas.da.DBDefEstrucLPDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDefEstrucLPDet extends FactoryObjetoLogico { 

  public FactoryDefEstrucLPDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DefEstrucLPDet defestruclpdet = (DefEstrucLPDet) objLog;
    defestruclpdet.setOID(db.getInteger(DBDefEstrucLPDet.OID_DEF_DET_LP));
    defestruclpdet.setDef_estruc_lp(DefEstrucLPCab.findByOidProxy(db.getInteger(DBDefEstrucLPDet.OID_DEF_ESTRUC_LP),getSesion()));
    defestruclpdet.setValor_clasif_art_1(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDefEstrucLPDet.OID_CLASIF_ART_1),getSesion()));
    defestruclpdet.setValor_clasif_art_2(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBDefEstrucLPDet.OID_CLASIF_ART_2),getSesion()));
    defestruclpdet.setOrden(db.getInteger(DBDefEstrucLPDet.ORDEN));
    defestruclpdet.setActivo(db.getBoolean(DBDefEstrucLPDet.ACTIVO));

  }
}
