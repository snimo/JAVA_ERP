package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.compras.da.DBCotizacionProveedorCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionProveedorCab extends FactoryObjetoLogico { 

  public FactoryCotizacionProveedorCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CotizacionProveedorCab cotizacionproveedorcab = (CotizacionProveedorCab) objLog;
    cotizacionproveedorcab.setOID(db.getInteger(DBCotizacionProveedorCab.OID_COTIZ_PROV_CAB));
    
    // Por comproCab
    cotizacionproveedorcab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    cotizacionproveedorcab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    cotizacionproveedorcab.setTcExt(db.getString(DBComproCab.TC_EXT));
    cotizacionproveedorcab.setLetra(db.getString(DBComproCab.LETRA));
    cotizacionproveedorcab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    cotizacionproveedorcab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    cotizacionproveedorcab.setNroext(db.getInteger(DBComproCab.NROEXT));
    cotizacionproveedorcab.setEmision(db.getDate(DBComproCab.EMISION));
    cotizacionproveedorcab.setEstado(db.getString(DBComproCab.ESTADO));
    cotizacionproveedorcab.setComentario(db.getString(DBComproCab.COMENTARIO));
    cotizacionproveedorcab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    cotizacionproveedorcab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    cotizacionproveedorcab.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    
    cotizacionproveedorcab.setSolicitud_cotiz_prov(SolicitudCotizProvCab.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_SOL_COTIZ_PROV),getSesion()));
    cotizacionproveedorcab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_PROVEEDOR),getSesion()));
    cotizacionproveedorcab.setVigencia_desde(db.getDate(DBCotizacionProveedorCab.VIGENCIA_DESDE));
    cotizacionproveedorcab.setVigencia_hasta(db.getDate(DBCotizacionProveedorCab.VIGENCIA_HASTA));
    cotizacionproveedorcab.setCond_pago_1(CondicionCompra.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_COND_PAGO_1),getSesion()));
    cotizacionproveedorcab.setDto_cond_pago_1(db.getMoney(DBCotizacionProveedorCab.DTO_COND_PAGO_1));
    cotizacionproveedorcab.setCond_pago_2(CondicionCompra.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_COND_PAGO_2),getSesion()));
    cotizacionproveedorcab.setDto_cond_pago_2(db.getMoney(DBCotizacionProveedorCab.DTO_COND_PAGO_2));
    cotizacionproveedorcab.setEstadoAdjudicacion(db.getInteger(DBCotizacionProveedorCab.ESTADO_ADJU));
    cotizacionproveedorcab.setFechaEstadoAdjudicacion(db.getDate(DBCotizacionProveedorCab.FECHA_ESTADO_ADJU));
    cotizacionproveedorcab.setUsuarioAdjudicacion(Usuario.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_USU_ADJU),getSesion()));
    cotizacionproveedorcab.setMotivoDecisionAdjudicacion(MotivoDecisionAdjudicacion.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_MOT_DECISION),getSesion()));
    cotizacionproveedorcab.setComentarioAdjudicacion(db.getString(DBCotizacionProveedorCab.COMEN_ADJU));
    cotizacionproveedorcab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCotizacionProveedorCab.OID_MONEDA),getSesion()));
    cotizacionproveedorcab.setCotizacionAbierta(db.getBoolean(DBCotizacionProveedorCab.COT_ABIERTA));
    
  }
}
