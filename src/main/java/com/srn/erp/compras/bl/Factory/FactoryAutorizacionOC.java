package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AutorizacionOC;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.da.DBAutorizacionOC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizacionOC extends FactoryObjetoLogico { 

  public FactoryAutorizacionOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizacionOC autorizacionoc = (AutorizacionOC) objLog;
    autorizacionoc.setOID(db.getInteger(DBAutorizacionOC.OID_AUTORIZ_OC));
    autorizacionoc.setDecision_autoriz(db.getInteger(DBAutorizacionOC.DECISION_AUTORIZ));
    autorizacionoc.setOrden_de_compra(OrdenDeCompraCab.findByOidProxy(db.getInteger(DBAutorizacionOC.OID_CCO_CPRA),getSesion()));
    autorizacionoc.setUsuario(Usuario.findByOidProxy(db.getInteger(DBAutorizacionOC.OID_USUARIO),getSesion()));
    autorizacionoc.setFec_dec_autoriz(db.getDate(DBAutorizacionOC.FEC_DEC_AUTORIZ));
    autorizacionoc.setComentario(db.getString(DBAutorizacionOC.COMENTARIO));
    autorizacionoc.setDesc_motivo(db.getString(DBAutorizacionOC.DESC_MOTIVO));
    autorizacionoc.setActivo(db.getBoolean(DBAutorizacionOC.ACTIVO));
    autorizacionoc.setTipo_motivo(db.getString(DBAutorizacionOC.TIPO_MOTIVO));
    autorizacionoc.setDetalle_oc(OrdenDeCompraDet.findByOidProxy(db.getInteger(DBAutorizacionOC.OID_OC_DET),getSesion()));
    autorizacionoc.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBAutorizacionOC.OID_ROL_AUTORIZ),getSesion()));
    autorizacionoc.setFec_alta(db.getDate(DBAutorizacionOC.FEC_ALTA));

  }
}
