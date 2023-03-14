package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TransferenciaValores;
import com.srn.erp.tesoreria.da.DBTransferenciaValores;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryTransferenciaValores extends FactoryObjetoLogico { 

  public FactoryTransferenciaValores() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TransferenciaValores transferencia = (TransferenciaValores) objLog;
    transferencia.setOID(db.getInteger(DBTransferenciaValores.OID_TRANSF_VAL));
    
    // Por comproCab
    transferencia.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    transferencia.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    transferencia.setTcExt(db.getString(DBComproCab.TC_EXT));
    transferencia.setLetra(db.getString(DBComproCab.LETRA));
    transferencia.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    transferencia.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    transferencia.setNroext(db.getInteger(DBComproCab.NROEXT));
    transferencia.setEmision(db.getDate(DBComproCab.EMISION));
    transferencia.setImputac(db.getDate(DBComproCab.IMPUTAC));
    transferencia.setEstado(db.getString(DBComproCab.ESTADO));
    transferencia.setComentario(db.getString(DBComproCab.COMENTARIO));
    transferencia.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    transferencia.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    transferencia.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    transferencia.setMotivoComprobante(MotivoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_MOTIVO_COMPRO),getSesion()));
    
    transferencia.setCajaOrigen(Caja.findByOidProxy(db.getInteger(DBTransferenciaValores.OID_CAJA_ORIGEN),getSesion()));
    transferencia.setCajaDestino(Caja.findByOidProxy(db.getInteger(DBTransferenciaValores.OID_CAJA_DESTINO),getSesion()));
    
  }
}
