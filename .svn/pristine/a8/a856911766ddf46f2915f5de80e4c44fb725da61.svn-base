package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.da.DBRendicionFondoFijo;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFondoFijo extends FactoryObjetoLogico {

  public FactoryRendicionFondoFijo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFondoFijo rendFF = (RendicionFondoFijo) objLog;
    rendFF.setOID(db.getInteger(DBRendicionFondoFijo.OID_REND_FONDO));
    
    // Por comproCab
    rendFF.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    rendFF.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    rendFF.setTcExt(db.getString(DBComproCab.TC_EXT));
    rendFF.setLetra(db.getString(DBComproCab.LETRA));
    rendFF.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    rendFF.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    rendFF.setNroext(db.getInteger(DBComproCab.NROEXT));
    rendFF.setEmision(db.getDate(DBComproCab.EMISION));
    rendFF.setImputac(db.getDate(DBComproCab.IMPUTAC));
    rendFF.setEstado(db.getString(DBComproCab.ESTADO));
    rendFF.setComentario(db.getString(DBComproCab.COMENTARIO));
    rendFF.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    rendFF.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    rendFF.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    rendFF.setMotivoComprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_MOTIVO_COMPRO),getSesion()));
    
    
    rendFF.setMoneda(Moneda.findByOidProxy(db.getInteger(DBRendicionFondoFijo.OID_MONEDA),getSesion()));
    rendFF.setCotizacion(db.getValorCotizacion(DBRendicionFondoFijo.COTIZACION));

  }
  
}
