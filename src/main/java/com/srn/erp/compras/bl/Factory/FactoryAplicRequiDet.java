package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AplicRequiDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.da.DBAplicRequiDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicRequiDet extends FactoryObjetoLogico { 

  public FactoryAplicRequiDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicRequiDet aplicrequidet = (AplicRequiDet) objLog;
    aplicrequidet.setOID(db.getInteger(DBAplicRequiDet.OID_DET_OC_REQUI));
    aplicrequidet.setRequisicion_det(RequisicionDet.findByOidProxy(db.getInteger(DBAplicRequiDet.OID_REQ_DET),getSesion()));
    aplicrequidet.setDetalle_oc(OrdenDeCompraDet.findByOidProxy(db.getInteger(DBAplicRequiDet.OID_DET_OC),getSesion()));
    aplicrequidet.setCant_comprada(db.getDouble(DBAplicRequiDet.CANT_COMPRADA));
    aplicrequidet.setActivo(db.getBoolean(DBAplicRequiDet.ACTIVO));
  }
}
