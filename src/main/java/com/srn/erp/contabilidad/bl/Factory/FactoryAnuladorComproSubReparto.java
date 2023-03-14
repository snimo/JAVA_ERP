package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorComproSubReparto;
import com.srn.erp.contabilidad.bm.ComproSubReparto;
import com.srn.erp.contabilidad.da.DBAnuladorComproSubReparto;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorComproSubReparto extends FactoryObjetoLogico { 

  public FactoryAnuladorComproSubReparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorComproSubReparto anuladorSub = (AnuladorComproSubReparto) objLog;
    anuladorSub.setOID(db.getInteger(DBAnuladorComproSubReparto.OID_ANU_COMPRO_SUBREP));
    anuladorSub.setComproSubReparto(ComproSubReparto.findByOidProxy(db.getInteger(DBAnuladorComproSubReparto.OID_COMPRO_SUBREP),getSesion()));
    
    // Por comproCab
    anuladorSub.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorSub.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorSub.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorSub.setLetra(db.getString(DBComproCab.LETRA));
    anuladorSub.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorSub.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorSub.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorSub.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorSub.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorSub.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorSub.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorSub.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorSub.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorSub.setImputac(db.getDate(DBComproCab.IMPUTAC));
		

  }
}
