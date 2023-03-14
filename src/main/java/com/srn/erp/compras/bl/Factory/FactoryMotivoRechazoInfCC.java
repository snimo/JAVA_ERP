package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.bm.MotivoRechazoInfCC;
import com.srn.erp.compras.da.DBMotivoRechazoInfCC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoRechazoInfCC extends FactoryObjetoLogico { 

  public FactoryMotivoRechazoInfCC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoRechazoInfCC motivorechazoinfcc = (MotivoRechazoInfCC) objLog;
    motivorechazoinfcc.setOID(db.getInteger(DBMotivoRechazoInfCC.OID_MOT_RECH_CC));
    motivorechazoinfcc.setInf_cc_det(InformeControlCalidadDet.findByOidProxy(db.getInteger(DBMotivoRechazoInfCC.OID_CC_DET),getSesion()));
    motivorechazoinfcc.setCant_mal_uc(db.getDouble(DBMotivoRechazoInfCC.CANT_MAL_UC));
    motivorechazoinfcc.setCant_mal_us(db.getDouble(DBMotivoRechazoInfCC.CANT_MAL_US));
    motivorechazoinfcc.setActivo(db.getBoolean(DBMotivoRechazoInfCC.ACTIVO));
    motivorechazoinfcc.setMotivoRechazoCC(MotivoRechazoCC.findByOidProxy(db.getInteger(DBMotivoRechazoInfCC.OID_MOTIVO),getSesion()));
  }
}
