package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.da.DBSolicitudCotizProvCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactorySolicitudCotizProvCab extends FactoryObjetoLogico { 

  public FactorySolicitudCotizProvCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SolicitudCotizProvCab solicitudcotizprovcab = (SolicitudCotizProvCab) objLog;
    solicitudcotizprovcab.setOID(db.getInteger(DBSolicitudCotizProvCab.OID_CCO_SOL_COTIZ));
    
    // Por comproCab
    solicitudcotizprovcab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    solicitudcotizprovcab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    solicitudcotizprovcab.setTcExt(db.getString(DBComproCab.TC_EXT));
    solicitudcotizprovcab.setLetra(db.getString(DBComproCab.LETRA));
    solicitudcotizprovcab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    solicitudcotizprovcab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    solicitudcotizprovcab.setNroext(db.getInteger(DBComproCab.NROEXT));
    solicitudcotizprovcab.setEmision(db.getDate(DBComproCab.EMISION));
    solicitudcotizprovcab.setEstado(db.getString(DBComproCab.ESTADO));
    solicitudcotizprovcab.setComentario(db.getString(DBComproCab.COMENTARIO));
    solicitudcotizprovcab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    solicitudcotizprovcab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    solicitudcotizprovcab.setActivo(db.getBoolean(DBComproCab.ACTIVO));      
    solicitudcotizprovcab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    solicitudcotizprovcab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    solicitudcotizprovcab.setFec_tope_ent_sol(db.getDate(DBSolicitudCotizProvCab.FEC_TOPE_ENT_SOL));
    solicitudcotizprovcab.setObs_detalladas(db.getString(DBSolicitudCotizProvCab.OBS_DETALLADAS));
  }
}
