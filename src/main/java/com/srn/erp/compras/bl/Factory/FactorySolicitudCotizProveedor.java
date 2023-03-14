package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.bm.SolicitudCotizProveedor;
import com.srn.erp.compras.da.DBSolicitudCotizProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactorySolicitudCotizProveedor extends FactoryObjetoLogico {

  public FactorySolicitudCotizProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SolicitudCotizProveedor solicitudCotizProv = (SolicitudCotizProveedor) objLog;
    solicitudCotizProv.setOID(db.getInteger(DBSolicitudCotizProveedor.OID_SOL_COTIZ_PROV));
    solicitudCotizProv.setSolicitud_cotizacion(SolicitudCotizProvCab.findByOidProxy(db.getInteger(DBSolicitudCotizProveedor.OID_CCO_SOL_COTIZ),getSesion()));
    solicitudCotizProv.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBSolicitudCotizProveedor.OID_PROVEEDOR),getSesion()));
    solicitudCotizProv.setImpresa(db.getBoolean(DBSolicitudCotizProveedor.IMPRESA));
    solicitudCotizProv.setUsuario_impresion(Usuario.findByOidProxy(db.getInteger(DBSolicitudCotizProveedor.OID_USU_IMP),getSesion()));
    solicitudCotizProv.setFec_impresion(db.getDate(DBSolicitudCotizProveedor.FEC_IMPRESION));
    solicitudCotizProv.setEnviada(db.getBoolean(DBSolicitudCotizProveedor.ENVIADA));
    solicitudCotizProv.setFec_envio_sol(db.getDate(DBSolicitudCotizProveedor.FEC_ENVIO_SOL));
    solicitudCotizProv.setConf_recep_sol(db.getBoolean(DBSolicitudCotizProveedor.CONF_RECEP_SOL));
    solicitudCotizProv.setFec_recep_conf_sol(db.getDate(DBSolicitudCotizProveedor.FEC_RECEP_CONF_SOL));
    solicitudCotizProv.setProv_ent_sol((db.getBoolean(DBSolicitudCotizProveedor.PROV_ENT_SOL)));
    solicitudCotizProv.setFec_rec_sol_cotiz(db.getDate(DBSolicitudCotizProveedor.FEC_REC_SOL_COTIZ));
    solicitudCotizProv.setPresu_recibido(db.getBoolean(DBSolicitudCotizProveedor.PRESU_RECIBIDO));
    solicitudCotizProv.setFec_presu_recibido(db.getDate(DBSolicitudCotizProveedor.FEC_PRESU_RECIBIDO));
  }
}
