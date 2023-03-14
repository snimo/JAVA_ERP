package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBRequisicionCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRequisicionCab extends FactoryObjetoLogico { 

  public FactoryRequisicionCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RequisicionCab requisicioncab = (RequisicionCab) objLog;
    requisicioncab.setOID(db.getInteger(DBRequisicionCab.OID_CCO_REQUI));
    
    // Por comproCab
    requisicioncab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    requisicioncab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    requisicioncab.setTcExt(db.getString(DBComproCab.TC_EXT));
    requisicioncab.setLetra(db.getString(DBComproCab.LETRA));
    requisicioncab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    requisicioncab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    requisicioncab.setNroext(db.getInteger(DBComproCab.NROEXT));
    requisicioncab.setEmision(db.getDate(DBComproCab.EMISION));
    requisicioncab.setEstado(db.getString(DBComproCab.ESTADO));
    requisicioncab.setComentario(db.getString(DBComproCab.COMENTARIO));
    requisicioncab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    requisicioncab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    requisicioncab.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    
    requisicioncab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBRequisicionCab.OID_USUARIO),getSesion()));
    requisicioncab.setSectorCompra(SectorCompra.findByOidProxy(db.getInteger(DBRequisicionCab.SECTOR_COMPRA),getSesion()));
  }
}
