package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.da.DBRecibo;
import com.srn.erp.ventas.bm.Cobrador;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRecibo extends FactoryObjetoLogico { 

  public FactoryRecibo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Recibo recibo = (Recibo) objLog;
    recibo.setOID(db.getInteger(DBRecibo.OID_RECIBO));
    
    // Por comproCab
    recibo.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    recibo.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    recibo.setTcExt(db.getString(DBComproCab.TC_EXT));
    recibo.setLetra(db.getString(DBComproCab.LETRA));
    recibo.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    recibo.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    recibo.setNroext(db.getInteger(DBComproCab.NROEXT));
    recibo.setEmision(db.getDate(DBComproCab.EMISION));
    recibo.setImputac(db.getDate(DBComproCab.IMPUTAC));
    recibo.setEstado(db.getString(DBComproCab.ESTADO));
    recibo.setComentario(db.getString(DBComproCab.COMENTARIO));
    recibo.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    recibo.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    recibo.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    recibo.setMotivoComprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_MOTIVO_COMPRO),getSesion()));
    
    recibo.setCobrador(Cobrador.findByOidProxy(db.getInteger(DBRecibo.OID_COBRADOR),getSesion()));
    recibo.setCaja(Caja.findByOidProxy(db.getInteger(DBRecibo.OID_CAJA),getSesion()));
    recibo.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBRecibo.OID_SUJETO),getSesion()));
    recibo.setCotizacion(db.getValorCotizacion(DBRecibo.COTIZACION));
    recibo.setTot_mon_ori(db.getMoney(DBRecibo.TOT_MON_ORI));
    recibo.setTot_mon_loc(db.getMoney(DBRecibo.TOT_MON_LOC));
    recibo.setReemplaza_recibo(db.getBoolean(DBRecibo.REEMPLAZA_RECIBO));
    recibo.setMoneda(Moneda.findByOidProxy(db.getInteger(DBRecibo.OID_MONEDA),getSesion()));
    recibo.setNro_rec_ori(db.getString(DBRecibo.NRO_REC_ORI));
    recibo.setTipoOper(db.getString(DBRecibo.TIPO_OPER));
    recibo.setEnConcepto(db.getString(DBRecibo.EN_CONCEPTO));
    
  }
}
