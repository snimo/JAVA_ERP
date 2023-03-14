package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.AnuladorRecibo;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.da.DBAnuladorRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRecibo extends FactoryObjetoLogico { 

  public FactoryAnuladorRecibo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRecibo anuladorrecibo = (AnuladorRecibo) objLog;
    anuladorrecibo.setOID(db.getInteger(DBAnuladorRecibo.OID_ANU_REC_CAB));
    anuladorrecibo.setRecibo(Recibo.findByOidProxy(db.getInteger(DBAnuladorRecibo.OID_RECIBO),getSesion()));
    
    // Por comproCab
    anuladorrecibo.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorrecibo.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorrecibo.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorrecibo.setLetra(db.getString(DBComproCab.LETRA));
    anuladorrecibo.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorrecibo.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorrecibo.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorrecibo.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorrecibo.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorrecibo.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorrecibo.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorrecibo.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorrecibo.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorrecibo.setImputac(db.getDate(DBComproCab.IMPUTAC));
		

  }
}
