package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ImputacionPagosVarios;
import com.srn.erp.pagos.da.DBImputacionPagosVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryImputacionPagosVarios extends FactoryObjetoLogico { 

  public FactoryImputacionPagosVarios() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ImputacionPagosVarios imputacionpagosvarios = (ImputacionPagosVarios) objLog;
    imputacionpagosvarios.setOID(db.getInteger(DBImputacionPagosVarios.OID_IMPU_OP_VARIAS));
    imputacionpagosvarios.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBImputacionPagosVarios.OID_ANA_IMP),getSesion()));
    imputacionpagosvarios.setComprobante(ComproOrdenPagoCab.findByOidProxy(db.getInteger(DBImputacionPagosVarios.OID_CCO),getSesion()));
    imputacionpagosvarios.setDebe_mon_pago(db.getMoney(DBImputacionPagosVarios.DEBE_MON_PAGO));
    imputacionpagosvarios.setHaber_mon_pago(db.getMoney(DBImputacionPagosVarios.HABER_MON_PAGO));
    imputacionpagosvarios.setDebe_mon_loc(db.getMoney(DBImputacionPagosVarios.DEBE_MON_LOC));
    imputacionpagosvarios.setHaber_mon_loc(db.getMoney(DBImputacionPagosVarios.HABER_MON_LOC));
    imputacionpagosvarios.setComentario(db.getString(DBImputacionPagosVarios.COMENTARIO));
    imputacionpagosvarios.setActivo(db.getBoolean(DBImputacionPagosVarios.ACTIVO));

  }
}
