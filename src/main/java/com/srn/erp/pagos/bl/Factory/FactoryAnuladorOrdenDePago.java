package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.pagos.bm.AnuladorOrdenDePago;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.da.DBAnuladorOrdenDePago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorOrdenDePago extends FactoryObjetoLogico { 

  public FactoryAnuladorOrdenDePago() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorOrdenDePago anuladorOP = (AnuladorOrdenDePago) objLog;
    anuladorOP.setOID(db.getInteger(DBAnuladorOrdenDePago.OID_ANU_OP_CAB));
    anuladorOP.setOrdenDePago(ComproOrdenPagoCab.findByOidProxy(db.getInteger(DBAnuladorOrdenDePago.OID_OP),getSesion()));
    
    // Por comproCab
    anuladorOP.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorOP.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorOP.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorOP.setLetra(db.getString(DBComproCab.LETRA));
    anuladorOP.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorOP.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorOP.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorOP.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorOP.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorOP.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorOP.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorOP.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorOP.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorOP.setImputac(db.getDate(DBComproCab.IMPUTAC));
		

  }
}
