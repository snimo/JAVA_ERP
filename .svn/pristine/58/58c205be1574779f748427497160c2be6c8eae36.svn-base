package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.InventarioCab;
import com.srn.erp.stock.da.DBInventarioCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryInventarioCab extends FactoryObjetoLogico { 

  public FactoryInventarioCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InventarioCab inventariocab = (InventarioCab) objLog;
    inventariocab.setOID(db.getInteger(DBInventarioCab.OID_INVENTARIO_CAB));
    
    // Por comproCab
    inventariocab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    inventariocab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    inventariocab.setTcExt(db.getString(DBComproCab.TC_EXT));
    inventariocab.setLetra(db.getString(DBComproCab.LETRA));
    inventariocab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    inventariocab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    inventariocab.setNroext(db.getInteger(DBComproCab.NROEXT));
    inventariocab.setEmision(db.getDate(DBComproCab.EMISION));
    inventariocab.setEstado(db.getString(DBComproCab.ESTADO));
    inventariocab.setComentario(db.getString(DBComproCab.COMENTARIO));
    inventariocab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    inventariocab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    inventariocab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    inventariocab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    
    inventariocab.setDeposito(Deposito.findByOidProxy(db.getInteger(DBInventarioCab.OID_DEPOSITO),getSesion()));
    inventariocab.setFec_inventario(db.getDate(DBInventarioCab.FEC_INVENTARIO));
  }
}
