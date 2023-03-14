package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.da.DBComproAperturaEjercicio;
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

public class FactoryComproAperturaEjercicio extends FactoryObjetoLogico { 

  public FactoryComproAperturaEjercicio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproAperturaEjercicio comproAperturaEjercicio = (ComproAperturaEjercicio) objLog;
    comproAperturaEjercicio.setOID(db.getInteger(DBComproAperturaEjercicio.OID_APERTURA_EJERCICIO));
    
    // Por comproCab
    comproAperturaEjercicio.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproAperturaEjercicio.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproAperturaEjercicio.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproAperturaEjercicio.setLetra(db.getString(DBComproCab.LETRA));
    comproAperturaEjercicio.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproAperturaEjercicio.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproAperturaEjercicio.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproAperturaEjercicio.setEmision(db.getDate(DBComproCab.EMISION));
    comproAperturaEjercicio.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comproAperturaEjercicio.setEstado(db.getString(DBComproCab.ESTADO));
    comproAperturaEjercicio.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproAperturaEjercicio.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproAperturaEjercicio.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproAperturaEjercicio.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproAperturaEjercicio.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    comproAperturaEjercicio.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    comproAperturaEjercicio.setEjercicio(Ejercicio.findByOidProxy(db.getInteger(DBComproAperturaEjercicio.OID_EJERCICIO),getSesion()));

  }
}
