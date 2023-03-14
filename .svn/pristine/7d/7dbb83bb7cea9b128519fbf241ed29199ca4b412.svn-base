package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.da.DBComproCierreEjercicio;
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

public class FactoryComproCierreEjercicio extends FactoryObjetoLogico { 

  public FactoryComproCierreEjercicio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproCierreEjercicio comprocierreejercicio = (ComproCierreEjercicio) objLog;
    comprocierreejercicio.setOID(db.getInteger(DBComproCierreEjercicio.OID_CIERRE_EJERCICIO));
    
    // Por comproCab
    comprocierreejercicio.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comprocierreejercicio.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comprocierreejercicio.setTcExt(db.getString(DBComproCab.TC_EXT));
    comprocierreejercicio.setLetra(db.getString(DBComproCab.LETRA));
    comprocierreejercicio.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comprocierreejercicio.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comprocierreejercicio.setNroext(db.getInteger(DBComproCab.NROEXT));
    comprocierreejercicio.setEmision(db.getDate(DBComproCab.EMISION));
    comprocierreejercicio.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comprocierreejercicio.setEstado(db.getString(DBComproCab.ESTADO));
    comprocierreejercicio.setComentario(db.getString(DBComproCab.COMENTARIO));
    comprocierreejercicio.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comprocierreejercicio.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comprocierreejercicio.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comprocierreejercicio.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    comprocierreejercicio.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    comprocierreejercicio.setEjercicio(Ejercicio.findByOidProxy(db.getInteger(DBComproCierreEjercicio.OID_EJERCICIO),getSesion()));
    comprocierreejercicio.setCierreDe(db.getString(DBComproCierreEjercicio.CIERRE_DE));

  }
}
