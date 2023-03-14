package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.MotivoPago;
import com.srn.erp.pagos.da.DBComproOrdenPagoCab;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproOrdenPagoCab extends FactoryObjetoLogico {

  public FactoryComproOrdenPagoCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproOrdenPagoCab comproordenpagocab = (ComproOrdenPagoCab) objLog;
    comproordenpagocab.setOID(db.getInteger(DBComproOrdenPagoCab.OID_CCO));
    
    // Por comproCab
    comproordenpagocab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproordenpagocab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproordenpagocab.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproordenpagocab.setLetra(db.getString(DBComproCab.LETRA));
    comproordenpagocab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproordenpagocab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproordenpagocab.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproordenpagocab.setEmision(db.getDate(DBComproCab.EMISION));
    comproordenpagocab.setEstado(db.getString(DBComproCab.ESTADO));
    comproordenpagocab.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproordenpagocab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproordenpagocab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproordenpagocab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproordenpagocab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    comproordenpagocab.setFecemision(db.getDate(DBComproOrdenPagoCab.FEC_EMISION));
    comproordenpagocab.setMotivopago(MotivoPago.findByOidProxy(db.getInteger(DBComproOrdenPagoCab.OID_MOTIVO_PAGO),getSesion()));
    comproordenpagocab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComproOrdenPagoCab.OID_MONEDA),getSesion()));
    comproordenpagocab.setCotizacion(db.getDouble(DBComproOrdenPagoCab.COTIZACION));
    comproordenpagocab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBComproOrdenPagoCab.OID_PROVEEDOR),getSesion()));
    comproordenpagocab.setPagoACuenta(db.getMoney(DBComproOrdenPagoCab.PAGO_A_CTA));
    comproordenpagocab.setCaja(Caja.findByOidProxy(db.getInteger(DBComproOrdenPagoCab.OID_CAJA),getSesion()));
    comproordenpagocab.setTotalPago(db.getMoney(DBComproOrdenPagoCab.TOTAL_PAGO));
    
    comproordenpagocab.setBruto(db.getMoney(DBComproOrdenPagoCab.BRUTO));
    comproordenpagocab.setDescuento(db.getMoney(DBComproOrdenPagoCab.DESCUENTO));
    comproordenpagocab.setNeto(db.getMoney(DBComproOrdenPagoCab.NETO));
    comproordenpagocab.setRetIVA(db.getMoney(DBComproOrdenPagoCab.RET_IVA));
    comproordenpagocab.setRetGan(db.getMoney(DBComproOrdenPagoCab.RET_GAN));
    comproordenpagocab.setRetIB(db.getMoney(DBComproOrdenPagoCab.RET_IB));
    comproordenpagocab.setRetSUS(db.getMoney(DBComproOrdenPagoCab.RET_SUS));
    comproordenpagocab.setFormaPago(FormaPago.findByOidProxy(db.getInteger(DBComproOrdenPagoCab.OID_FORMA_PAGO),getSesion()));
    

  }
}
