package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.ctasAPagar.bm.AutorizRolesFactProv;
import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;
import com.srn.erp.ctasAPagar.da.DBAutorizRolesFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizRolesFactProv extends FactoryObjetoLogico { 

  public FactoryAutorizRolesFactProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizRolesFactProv autorizrolesfactprov = (AutorizRolesFactProv) objLog;
    autorizrolesfactprov.setOID(db.getInteger(DBAutorizRolesFactProv.OID_AUTORIZ_FP_ROL));
    autorizrolesfactprov.setAutorizacion_fact_prov(AutorizacionFactProv.findByOidProxy(db.getInteger(DBAutorizRolesFactProv.OID_AUTORIZ_FACT),getSesion()));
    autorizrolesfactprov.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBAutorizRolesFactProv.OID_ROL_AUTORIZ),getSesion()));
    autorizrolesfactprov.setFec_lta(db.getDate(DBAutorizRolesFactProv.FEC_ALTA));
    autorizrolesfactprov.setTipo_autoriz(db.getString(DBAutorizRolesFactProv.TIPO_AUTORIZ));
    autorizrolesfactprov.setFecha_resp_aut(db.getDate(DBAutorizRolesFactProv.FEC_RESP_AUT));
    autorizrolesfactprov.setPorc_aut_rec(db.getDouble(DBAutorizRolesFactProv.PORC_AUT_REC));
    autorizrolesfactprov.setMonto_aut_rec(db.getDouble(DBAutorizRolesFactProv.MONTO_AUT_REC));
    autorizrolesfactprov.setEstado(db.getInteger(DBAutorizRolesFactProv.ESTADO));
    autorizrolesfactprov.setMotivoAutorizacion(db.getString(DBAutorizRolesFactProv.MOTIVO_AUTORIZACION));
    autorizrolesfactprov.setUsuario(Usuario.findByOidProxy(db.getInteger(DBAutorizRolesFactProv.OID_USUARIO),getSesion()));
  }
}
