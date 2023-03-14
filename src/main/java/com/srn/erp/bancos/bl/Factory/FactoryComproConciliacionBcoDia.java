package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.ComproConciliacionBcoDia;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproConciliacionBcoDia extends FactoryObjetoLogico { 

  public FactoryComproConciliacionBcoDia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproConciliacionBcoDia comproConciBcoDia = (ComproConciliacionBcoDia) objLog;
    comproConciBcoDia.setOID(db.getInteger(DBComproCab.OID_CCO));    
    comproConciBcoDia.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproConciBcoDia.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproConciBcoDia.setLetra(db.getString(DBComproCab.LETRA));
    comproConciBcoDia.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproConciBcoDia.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproConciBcoDia.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproConciBcoDia.setEmision(db.getDate(DBComproCab.EMISION));
    comproConciBcoDia.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comproConciBcoDia.setEstado(db.getString(DBComproCab.ESTADO));
    comproConciBcoDia.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproConciBcoDia.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproConciBcoDia.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproConciBcoDia.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproConciBcoDia.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    comproConciBcoDia.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    

  }
}
