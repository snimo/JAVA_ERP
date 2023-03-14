package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproCab extends FactoryObjetoLogico {

  public FactoryComproCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproCab comprocab = (ComproCab) objLog;
    comprocab.setOID(db.getInteger(DBComproCab.OID_CCO));
    comprocab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comprocab.setTcExt(db.getString(DBComproCab.TC_EXT));
    comprocab.setLetra(db.getString(DBComproCab.LETRA));
    comprocab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comprocab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comprocab.setNroext(db.getInteger(DBComproCab.NROEXT));
    comprocab.setEmision(db.getDate(DBComproCab.EMISION));
    comprocab.setEstado(db.getString(DBComproCab.ESTADO));
    comprocab.setComentario(db.getString(DBComproCab.COMENTARIO));
    comprocab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comprocab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comprocab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comprocab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comprocab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    comprocab.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comprocab.setMotivoComprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_MOTIVO_COMPRO),getSesion()));
    comprocab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    comprocab.setNroInterno(db.getInteger(DBComproCab.NRO_INTERNO));
  }
}
