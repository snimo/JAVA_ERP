package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.da.DBInformeControlCalidad;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryInformeControlCalidad extends FactoryObjetoLogico { 

  public FactoryInformeControlCalidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InformeControlCalidad informecontrolcalidad = (InformeControlCalidad) objLog;
    informecontrolcalidad.setOID(db.getInteger(DBInformeControlCalidad.OID_CC));
    
    // Por comproCab
    informecontrolcalidad.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    informecontrolcalidad.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    informecontrolcalidad.setTcExt(db.getString(DBComproCab.TC_EXT));
    informecontrolcalidad.setLetra(db.getString(DBComproCab.LETRA));
    informecontrolcalidad.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    informecontrolcalidad.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    informecontrolcalidad.setNroext(db.getInteger(DBComproCab.NROEXT));
    informecontrolcalidad.setEmision(db.getDate(DBComproCab.EMISION));
    informecontrolcalidad.setEstado(db.getString(DBComproCab.ESTADO));
    informecontrolcalidad.setComentario(db.getString(DBComproCab.COMENTARIO));
    informecontrolcalidad.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    informecontrolcalidad.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    informecontrolcalidad.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    informecontrolcalidad.setImputac(db.getDate(DBComproCab.IMPUTAC));
    
  }
}
