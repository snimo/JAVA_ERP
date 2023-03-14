package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorComproAperturaEjercicio;
import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
import com.srn.erp.contabilidad.da.DBAnuladorComproAperturaEjercicio;
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

public class FactoryAnuladorComproAperturaEjercicio extends FactoryObjetoLogico { 

  public FactoryAnuladorComproAperturaEjercicio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

	AnuladorComproAperturaEjercicio anuladorComproAperturaEjercicio = (AnuladorComproAperturaEjercicio) objLog;
	anuladorComproAperturaEjercicio.setOID(db.getInteger(DBAnuladorComproAperturaEjercicio.OID_ANU_COMPRO_APER_EJER));
	anuladorComproAperturaEjercicio.setComproAperturaEjercicio(ComproAperturaEjercicio.findByOidProxy(db.getInteger(DBAnuladorComproAperturaEjercicio.OID_APER_EJERCICIO),getSesion()));
    
    // Por comproCab
	anuladorComproAperturaEjercicio.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
	anuladorComproAperturaEjercicio.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
	anuladorComproAperturaEjercicio.setTcExt(db.getString(DBComproCab.TC_EXT));
	anuladorComproAperturaEjercicio.setLetra(db.getString(DBComproCab.LETRA));
	anuladorComproAperturaEjercicio.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
	anuladorComproAperturaEjercicio.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
	anuladorComproAperturaEjercicio.setNroext(db.getInteger(DBComproCab.NROEXT));
	anuladorComproAperturaEjercicio.setEmision(db.getDate(DBComproCab.EMISION));
	anuladorComproAperturaEjercicio.setEstado(db.getString(DBComproCab.ESTADO));
	anuladorComproAperturaEjercicio.setComentario(db.getString(DBComproCab.COMENTARIO));
	anuladorComproAperturaEjercicio.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
	anuladorComproAperturaEjercicio.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
	anuladorComproAperturaEjercicio.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
	anuladorComproAperturaEjercicio.setImputac(db.getDate(DBComproCab.IMPUTAC));
		

  }
}
