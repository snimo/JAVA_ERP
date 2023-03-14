package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBAutorizacionFactProv;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizacionFactProv extends FactoryObjetoLogico {

  public FactoryAutorizacionFactProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizacionFactProv autorizacionfactprov = (AutorizacionFactProv) objLog;
    autorizacionfactprov.setOID(db.getInteger(DBAutorizacionFactProv.OID_AUTORIZ_FACT));
    autorizacionfactprov.setTranprovVto(TranProvVto.findByOidProxy(db.getInteger(DBAutorizacionFactProv.OID_TRAN_PROV_VTO),getSesion()));
    autorizacionfactprov.setPorcautoriz(db.getMoney(DBAutorizacionFactProv.PORC_AUTORIZ));
    autorizacionfactprov.setMontoautoriz(db.getMoney(DBAutorizacionFactProv.MONTO_AUTORIZ));
    autorizacionfactprov.setUsuario(Usuario.findByOidProxy(db.getInteger(DBAutorizacionFactProv.OID_USUARIO),getSesion()));
    autorizacionfactprov.setFecautoriz(db.getDate(DBAutorizacionFactProv.FEC_AUTORIZ));
    autorizacionfactprov.setActivo(db.getBoolean(DBAutorizacionFactProv.ACTIVO));
    autorizacionfactprov.setEstado(db.getInteger(DBAutorizacionFactProv.ESTADO));
    autorizacionfactprov.setComproCab(ComproCab.findByOidProxyCompro(db.getInteger(DBAutorizacionFactProv.OID_CCO),getSesion()));
  }
}
