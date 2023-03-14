package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.bancos.da.DBNotaBancaria;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryNotaBancaria extends FactoryObjetoLogico { 

  public FactoryNotaBancaria() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NotaBancaria notabancaria = (NotaBancaria) objLog;
    notabancaria.setOID(db.getInteger(DBNotaBancaria.OID_NC_ND));
    
    // Por comproCab
    notabancaria.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    notabancaria.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    notabancaria.setTcExt(db.getString(DBComproCab.TC_EXT));
    notabancaria.setLetra(db.getString(DBComproCab.LETRA));
    notabancaria.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    notabancaria.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    notabancaria.setNroext(db.getInteger(DBComproCab.NROEXT));
    notabancaria.setEmision(db.getDate(DBComproCab.EMISION));
    notabancaria.setEstado(db.getString(DBComproCab.ESTADO));
    notabancaria.setComentario(db.getString(DBComproCab.COMENTARIO));
    notabancaria.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    notabancaria.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    notabancaria.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    notabancaria.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    
    notabancaria.setCuenta_bancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBNotaBancaria.OID_CTA_BANCARIA),getSesion()));
    notabancaria.setMoneda_cta(Moneda.findByOidProxy(db.getInteger(DBNotaBancaria.OID_MON_CTA),getSesion()));
    notabancaria.setTot_mon_cta(db.getMoney(DBNotaBancaria.TOT_MON_CTA));
    notabancaria.setCotizacion(db.getValorCotizacion(DBNotaBancaria.COTIZACION));
  }
}
