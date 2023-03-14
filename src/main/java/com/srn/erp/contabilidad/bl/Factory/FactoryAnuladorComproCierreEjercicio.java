package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.da.DBAnuladorComproCierreEjercicio;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorComproCierreEjercicio extends FactoryObjetoLogico { 

  public FactoryAnuladorComproCierreEjercicio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

	AnuladorComproCierreEjercicio anuladorComproCierreEjercicio = (AnuladorComproCierreEjercicio) objLog;
    anuladorComproCierreEjercicio.setOID(db.getInteger(DBAnuladorComproCierreEjercicio.OID_ANU_COMPRO_CIERRE_EJER));
    anuladorComproCierreEjercicio.setComproCierreEjercicio(ComproCierreEjercicio.findByOidProxy(db.getInteger(DBAnuladorComproCierreEjercicio.OID_CIERRE_EJERCICIO),getSesion()));
    
    // Por comproCab
    anuladorComproCierreEjercicio.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorComproCierreEjercicio.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorComproCierreEjercicio.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorComproCierreEjercicio.setLetra(db.getString(DBComproCab.LETRA));
    anuladorComproCierreEjercicio.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorComproCierreEjercicio.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorComproCierreEjercicio.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorComproCierreEjercicio.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorComproCierreEjercicio.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorComproCierreEjercicio.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorComproCierreEjercicio.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorComproCierreEjercicio.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorComproCierreEjercicio.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorComproCierreEjercicio.setImputac(db.getDate(DBComproCab.IMPUTAC));
		

  }
}
