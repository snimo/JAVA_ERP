package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.da.DBAsientoManual;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class FactoryAsientoManual extends FactoryObjetoLogico {

  public FactoryAsientoManual() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AsientoManual asientomanual = (AsientoManual) objLog;
    asientomanual.setOID(db.getInteger(DBAsientoManual.OID_CCO));
    
    // Por comproCab
    asientomanual.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    asientomanual.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    asientomanual.setTcExt(db.getString(DBComproCab.TC_EXT));
    asientomanual.setLetra(db.getString(DBComproCab.LETRA));
    asientomanual.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    asientomanual.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    asientomanual.setNroext(db.getInteger(DBComproCab.NROEXT));
    asientomanual.setEmision(db.getDate(DBComproCab.EMISION));
    asientomanual.setImputac(db.getDate(DBComproCab.IMPUTAC));
    asientomanual.setEstado(db.getString(DBComproCab.ESTADO));
    asientomanual.setComentario(db.getString(DBComproCab.COMENTARIO));
    asientomanual.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    asientomanual.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    asientomanual.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    
    
    asientomanual.setNoContaOtrasMonedas(db.getBoolean(DBAsientoManual.NO_CONTA_OTRAS_MON));
    asientomanual.setMoneda(Moneda.findByOidProxy(db.getInteger(DBAsientoManual.OID_MONEDA),getSesion()));
    asientomanual.setCotizacion(new ValorCotizacion(db.getDouble(DBAsientoManual.COTIZACION)));
    asientomanual.setTipoCambio(TipoCambio.findByOidProxy(db.getInteger(DBAsientoManual.OID_TIPO_CAMBIO),getSesion()));
    asientomanual.setComproConta(ComproConta.findByOidProxy(db.getInteger(DBAsientoManual.OID_CCO),getSesion()));
    asientomanual.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBAsientoManual.OID_CCO),getSesion()));
  }
}
