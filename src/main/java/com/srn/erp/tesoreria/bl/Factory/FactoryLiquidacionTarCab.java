package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBLiquidacionTarCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryLiquidacionTarCab extends FactoryObjetoLogico { 

  public FactoryLiquidacionTarCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LiquidacionTarCab liquidaciontarcab = (LiquidacionTarCab) objLog;
    
    // Por comproCab
    liquidaciontarcab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    liquidaciontarcab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    liquidaciontarcab.setTcExt(db.getString(DBComproCab.TC_EXT));
    liquidaciontarcab.setLetra(db.getString(DBComproCab.LETRA));
    liquidaciontarcab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    liquidaciontarcab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    liquidaciontarcab.setNroext(db.getInteger(DBComproCab.NROEXT));
    liquidaciontarcab.setEmision(db.getDate(DBComproCab.EMISION));
    liquidaciontarcab.setEstado(db.getString(DBComproCab.ESTADO));
    liquidaciontarcab.setComentario(db.getString(DBComproCab.COMENTARIO));
    liquidaciontarcab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    liquidaciontarcab.setImputac(db.getDate(DBComproCab.IMPUTAC));
    liquidaciontarcab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    liquidaciontarcab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    liquidaciontarcab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    liquidaciontarcab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    liquidaciontarcab.setOID(db.getInteger(DBLiquidacionTarCab.OID_LIQUI_TAR));
    liquidaciontarcab.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_TIPO_VALOR),getSesion()));
    liquidaciontarcab.setCompo_tipo_valor(db.getString(DBLiquidacionTarCab.COMPO_TIPO_VALOR));
    liquidaciontarcab.setTarjeta_credito(TarjetaCredito.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_TAR_CREDITO),getSesion()));
    liquidaciontarcab.setBanco(Banco.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_BANCO),getSesion()));
    liquidaciontarcab.setFec_desde(db.getDate(DBLiquidacionTarCab.FEC_DESDE));
    liquidaciontarcab.setFec_hasta(db.getDate(DBLiquidacionTarCab.FEC_HASTA));
    liquidaciontarcab.setFec_vto(db.getDate(DBLiquidacionTarCab.FEC_VTO));
    liquidaciontarcab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_MONEDA),getSesion()));
    liquidaciontarcab.setCotizacion(db.getValorCotizacion(DBLiquidacionTarCab.COTIZACION));
    liquidaciontarcab.setImporte(db.getMoney(DBLiquidacionTarCab.IMPORTE));
    liquidaciontarcab.setConcepto_liq_tar(ConceptoLiqTarjeta.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_CONC_LIQ_TC),getSesion()));
    liquidaciontarcab.setCaja(Caja.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_CAJA),getSesion()));
    liquidaciontarcab.setValor(Valor.findByOidProxy(db.getInteger(DBLiquidacionTarCab.OID_VALOR),getSesion()));
    
  }
  
}
