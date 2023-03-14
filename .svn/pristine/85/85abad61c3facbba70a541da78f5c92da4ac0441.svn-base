package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.RequisicionDetAutorizacion;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.da.DBRequisicionDetAutorizacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRequisicionDetAutorizacion extends FactoryObjetoLogico { 

  public FactoryRequisicionDetAutorizacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RequisicionDetAutorizacion requisiciondetautorizacion = (RequisicionDetAutorizacion) objLog;
    requisiciondetautorizacion.setOID(db.getInteger(DBRequisicionDetAutorizacion.OID_REQ_AUTORIZ));
    requisiciondetautorizacion.setRequesicion_detalle(RequisicionDet.findByOidProxy(db.getInteger(DBRequisicionDetAutorizacion.OID_REQ_DET),getSesion()));
    requisiciondetautorizacion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBRequisicionDetAutorizacion.OID_USUARIO),getSesion()));
    requisiciondetautorizacion.setDecision_autoriz(db.getInteger(DBRequisicionDetAutorizacion.DECISION_AUTORIZ));
    requisiciondetautorizacion.setFec_decision(db.getDate(DBRequisicionDetAutorizacion.FEC_DECISION));
    requisiciondetautorizacion.setComentario(db.getString(DBRequisicionDetAutorizacion.COMENTARIO));
    requisiciondetautorizacion.setTipo_autorizacion(db.getString(DBRequisicionDetAutorizacion.TIPO_AUTORIZACION));
    requisiciondetautorizacion.setRolAutorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBRequisicionDetAutorizacion.OID_ROL_AUTORIZ),getSesion()));
  }
}
