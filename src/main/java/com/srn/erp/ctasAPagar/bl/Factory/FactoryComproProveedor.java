package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.da.DBComproProveedor;
import com.srn.erp.ctasAPagar.da.DBComproProveedorBase;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProveedor extends FactoryObjetoLogico {

  public FactoryComproProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProveedor comproproveedor = (ComproProveedor) objLog;
    comproproveedor.setOID(db.getInteger(DBComproProveedor.OID_CCO));
    
    // Por comproCab
    comproproveedor.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproproveedor.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproproveedor.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproproveedor.setLetra(db.getString(DBComproCab.LETRA));
    comproproveedor.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproproveedor.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproproveedor.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproproveedor.setEmision(db.getDate(DBComproCab.EMISION));
    comproproveedor.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comproproveedor.setEstado(db.getString(DBComproCab.ESTADO));
    comproproveedor.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproproveedor.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproproveedor.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproproveedor.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproproveedor.setMotivoComprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_MOTIVO_COMPRO),getSesion()));
    
    comproproveedor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBComproProveedor.PROVEEDOR),getSesion()));
    comproproveedor.setTotMonedaOri(db.getMoney(DBComproProveedor.TOT_MON_ORI));
    comproproveedor.setTotMonedaLoc(db.getMoney(DBComproProveedor.TOT_MON_LOC));
    comproproveedor.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComproProveedor.OID_MONEDA),getSesion()));
    comproproveedor.setFecbase(db.getDate(DBComproProveedor.FEC_BASE));
    comproproveedor.setMaxMontoAutOri(db.getMoney(DBComproProveedor.MAX_MONTO_AUT_ORI));
    comproproveedor.setAutorizada(db.getBoolean(DBComproProveedor.AUTORIZADA));
    comproproveedor.setCondpagoAlt2(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_COND_PAGO_CC),getSesion()));
    comproproveedor.setCondPagoAlt1(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_COND_PAGO_AL1),getSesion()));
    comproproveedor.setCondpagoAlt2(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_CONC_PAGO_AL2),getSesion()));
    comproproveedor.setDescCondPagoCC(db.getMoney(DBComproProveedor.DESC_CP_CC));
    comproproveedor.setDescCondPagoAlt1(db.getMoney(DBComproProveedor.DESC_CP_AL1));
    comproproveedor.setDescCondPagoAlt2(db.getMoney(DBComproProveedor.DESC_CP_AL2));
    comproproveedor.setNetoGravadoMonOri(db.getMoney(DBComproProveedor.NETO_GRAVADO_MON_ORI));
    comproproveedor.setNetoNoGravadoMonOri(db.getMoney(DBComproProveedor.NETO_NO_GRAVADO_MON_ORI));
    comproproveedor.setNetoGravadoMonLoc(db.getMoney(DBComproProveedor.NETO_GRAVADO_MON_LOC));
    comproproveedor.setNetoNoGravadoMonLoc(db.getMoney(DBComproProveedor.NETO_NO_GRAVADO_MON_LOC));    
    comproproveedor.setSectorCompra(SectorCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_SECTOR_COMPRA),getSesion()));
    comproproveedor.setCotizacion(db.getValorCotizacion(DBComproProveedor.COTIZACION));
    comproproveedor.setAnticipoPagado(db.getBoolean(DBComproProveedorBase.ANTICIPO_PAGADO));
    comproproveedor.setSaldoAnticipoProveedor(db.getMoney(DBComproProveedorBase.SALDO_ANT_PROV));
    
    comproproveedor.setTipoCtaCteProv(TipoCtaCteProv.findByOidProxy(db.getInteger(DBComproProveedorBase.OID_TIPO_CTA_PROV),getSesion()));
    comproproveedor.setValorCotizExt1(db.getValorCotizacion(DBComproProveedorBase.COTIZ_MON_EXT_1));
    comproproveedor.setValorCotizExt2(db.getValorCotizacion(DBComproProveedorBase.COTIZ_MON_EXT_2));
    
    comproproveedor.setCondPagoCC(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedorBase.OID_COND_PAGO_CC),getSesion()));
    comproproveedor.setTipoFactura(db.getString(DBComproProveedor.TIPO_FACTURA));
    comproproveedor.setSigno(db.getInteger(DBComproProveedor.SIGNO));
    comproproveedor.setEsEstadistica(db.getBoolean(DBComproProveedorBase.ES_ESTADISTICA));
    
  }
}
