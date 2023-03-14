package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.SolicitarAPedMerc;
import com.srn.erp.stock.da.DBPedMercDep;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryPedMercDep extends FactoryObjetoLogico { 

  public FactoryPedMercDep() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PedMercDep pedidomercaderiadeposito = (PedMercDep) objLog;
    pedidomercaderiadeposito.setOID(db.getInteger(DBPedMercDep.OID_PED_MERC));

    // Por comproCab
    pedidomercaderiadeposito.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    pedidomercaderiadeposito.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    pedidomercaderiadeposito.setTcExt(db.getString(DBComproCab.TC_EXT));
    pedidomercaderiadeposito.setLetra(db.getString(DBComproCab.LETRA));
    pedidomercaderiadeposito.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    pedidomercaderiadeposito.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    pedidomercaderiadeposito.setNroext(db.getInteger(DBComproCab.NROEXT));
    pedidomercaderiadeposito.setEmision(db.getDate(DBComproCab.EMISION));
    pedidomercaderiadeposito.setEstado(db.getString(DBComproCab.ESTADO));
    pedidomercaderiadeposito.setComentario(db.getString(DBComproCab.COMENTARIO));
    pedidomercaderiadeposito.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    pedidomercaderiadeposito.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    pedidomercaderiadeposito.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    pedidomercaderiadeposito.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    pedidomercaderiadeposito.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    pedidomercaderiadeposito.setSolicitar_a(SolicitarAPedMerc.findByOidProxy(db.getInteger(DBPedMercDep.OID_SOL_PED_MERC),getSesion()));
    pedidomercaderiadeposito.setDeposito_entrega(Deposito.findByOidProxy(db.getInteger(DBPedMercDep.OID_DEPO_ENT),getSesion()));

  }
}
