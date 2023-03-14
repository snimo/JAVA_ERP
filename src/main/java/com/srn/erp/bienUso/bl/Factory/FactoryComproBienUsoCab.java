package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ComproBienUsoCab;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.da.DBComproBienUsoCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproBienUsoCab extends FactoryObjetoLogico { 

  public FactoryComproBienUsoCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproBienUsoCab comproBienUsoCab = (ComproBienUsoCab) objLog;
    comproBienUsoCab.setOID(db.getInteger(DBComproBienUsoCab.OID_CCO_BU));
    
    // Por comproCab
    comproBienUsoCab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproBienUsoCab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproBienUsoCab.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproBienUsoCab.setLetra(db.getString(DBComproCab.LETRA));
    comproBienUsoCab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproBienUsoCab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproBienUsoCab.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproBienUsoCab.setEmision(db.getDate(DBComproCab.EMISION));
    comproBienUsoCab.setEstado(db.getString(DBComproCab.ESTADO));
    comproBienUsoCab.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproBienUsoCab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproBienUsoCab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproBienUsoCab.setActivo(db.getBoolean(DBComproCab.ACTIVO));      
    
    
    comproBienUsoCab.setSub_bien(SubBien.findByOidProxy(db.getInteger(DBComproBienUsoCab.OID_BIEN_ALTA),getSesion()));
    comproBienUsoCab.setTipo_mov(db.getString(DBComproBienUsoCab.TIPO_MOV));
    comproBienUsoCab.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBComproBienUsoCab.OID_PERI),getSesion()));
    comproBienUsoCab.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBComproBienUsoCab.OID_SIST_VAL),getSesion()));
  }
}
