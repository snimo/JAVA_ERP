package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorInfRec;
import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.da.DBAnuladorInfRec;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorInfRec extends FactoryObjetoLogico { 

  public FactoryAnuladorInfRec() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorInfRec anuladorinfrec = (AnuladorInfRec) objLog;
    anuladorinfrec.setOID(db.getInteger(DBAnuladorInfRec.OID_ANU_INF_REC));
    
    // Por comproCab
    anuladorinfrec.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorinfrec.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorinfrec.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorinfrec.setLetra(db.getString(DBComproCab.LETRA));
    anuladorinfrec.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorinfrec.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorinfrec.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorinfrec.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorinfrec.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorinfrec.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorinfrec.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorinfrec.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorinfrec.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorinfrec.setImputac(db.getDate(DBComproCab.IMPUTAC));
    
    
    anuladorinfrec.setInforme_recepcion(InformeRecepcion.findByOidProxy(db.getInteger(DBAnuladorInfRec.OID_INF_REC),getSesion()));

  }
}
