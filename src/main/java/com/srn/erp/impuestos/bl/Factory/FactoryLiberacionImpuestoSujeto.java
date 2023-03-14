package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.LiberacionImpuestoSujeto;
import com.srn.erp.impuestos.da.DBLiberacionImpuestoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLiberacionImpuestoSujeto extends FactoryObjetoLogico { 

  public FactoryLiberacionImpuestoSujeto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LiberacionImpuestoSujeto liberacionimpuestosujeto = (LiberacionImpuestoSujeto) objLog;
    liberacionimpuestosujeto.setOID(db.getInteger(DBLiberacionImpuestoSujeto.OID_LIB_IMPU));
    liberacionimpuestosujeto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBLiberacionImpuestoSujeto.OID_SUJETO),getSesion()));
    liberacionimpuestosujeto.setFec_vig_desde(db.getDate(DBLiberacionImpuestoSujeto.FEC_VIG_DESDE));
    liberacionimpuestosujeto.setFec_vig_hasta(db.getDate(DBLiberacionImpuestoSujeto.FEC_VIG_HASTA));
    liberacionimpuestosujeto.setPorc_lib(db.getPorcentaje(DBLiberacionImpuestoSujeto.PORC_LIB));
    liberacionimpuestosujeto.setNuevo_porc(db.getPorcentaje(DBLiberacionImpuestoSujeto.NUEVO_PORC));
    liberacionimpuestosujeto.setTipo_impuesto(db.getString(DBLiberacionImpuestoSujeto.TIPO_IMPUESTO));
    liberacionimpuestosujeto.setActivo(db.getBoolean(DBLiberacionImpuestoSujeto.ACTIVO));

  }
}
