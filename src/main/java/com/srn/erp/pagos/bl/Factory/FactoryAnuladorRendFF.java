package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.pagos.bm.AnuladorRendFF;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.da.DBAnuladorRendFF;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRendFF extends FactoryObjetoLogico { 

  public FactoryAnuladorRendFF() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRendFF anuladorrendff = (AnuladorRendFF) objLog;
    anuladorrendff.setOID(db.getInteger(DBAnuladorRendFF.OID_ANU_REND_FF));
    anuladorrendff.setRendicion_ff(RendicionFondoFijo.findByOidProxy(db.getInteger(DBAnuladorRendFF.OID_REND_FONDO),getSesion()));
    
    // Por comproCab
    anuladorrendff.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorrendff.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorrendff.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorrendff.setLetra(db.getString(DBComproCab.LETRA));
    anuladorrendff.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorrendff.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorrendff.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorrendff.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorrendff.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorrendff.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorrendff.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorrendff.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorrendff.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    anuladorrendff.setImputac(db.getDate(DBComproCab.IMPUTAC));
    

  }
}
