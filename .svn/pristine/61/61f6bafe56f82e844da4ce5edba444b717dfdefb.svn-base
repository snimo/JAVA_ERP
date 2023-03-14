package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasACobrar.da.DBAplicacionComproClie;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionComproClie extends FactoryObjetoLogico {

  public FactoryAplicacionComproClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionComproClie aplicacionComproClie = (AplicacionComproClie) objLog;
    aplicacionComproClie.setOID(db.getInteger(DBAplicacionComproClie.OID_CCO));
    
    // Por comproCab
    aplicacionComproClie.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    aplicacionComproClie.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    aplicacionComproClie.setTcExt(db.getString(DBComproCab.TC_EXT));
    aplicacionComproClie.setLetra(db.getString(DBComproCab.LETRA));
    aplicacionComproClie.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    aplicacionComproClie.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    aplicacionComproClie.setNroext(db.getInteger(DBComproCab.NROEXT));
    aplicacionComproClie.setEmision(db.getDate(DBComproCab.EMISION));
    aplicacionComproClie.setImputac(db.getDate(DBComproCab.IMPUTAC));
    aplicacionComproClie.setEstado(db.getString(DBComproCab.ESTADO));
    aplicacionComproClie.setComentario(db.getString(DBComproCab.COMENTARIO));
    aplicacionComproClie.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    aplicacionComproClie.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    aplicacionComproClie.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    aplicacionComproClie.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    aplicacionComproClie.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    aplicacionComproClie.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBAplicacionComproClie.SUJETO),getSesion()));
    aplicacionComproClie.setAllowDesaplicar(db.getBoolean(DBAplicacionComproClie.ALLOW_DESAPLICAR));
  }
}
