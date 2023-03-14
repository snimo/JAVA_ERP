package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproSubReparto;
import com.srn.erp.contabilidad.bm.SubReparto;
import com.srn.erp.contabilidad.da.DBComproSubReparto;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproSubReparto extends FactoryObjetoLogico { 

  public FactoryComproSubReparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproSubReparto comprosubreparto = (ComproSubReparto) objLog;
    comprosubreparto.setOID(db.getInteger(DBComproSubReparto.OID_COMPRO_SUB));
    
    // Por comproCab
    comprosubreparto.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comprosubreparto.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comprosubreparto.setTcExt(db.getString(DBComproCab.TC_EXT));
    comprosubreparto.setLetra(db.getString(DBComproCab.LETRA));
    comprosubreparto.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comprosubreparto.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comprosubreparto.setNroext(db.getInteger(DBComproCab.NROEXT));
    comprosubreparto.setEmision(db.getDate(DBComproCab.EMISION));
    comprosubreparto.setImputac(db.getDate(DBComproCab.IMPUTAC));
    comprosubreparto.setEstado(db.getString(DBComproCab.ESTADO));
    comprosubreparto.setComentario(db.getString(DBComproCab.COMENTARIO));
    comprosubreparto.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comprosubreparto.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comprosubreparto.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comprosubreparto.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    comprosubreparto.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    comprosubreparto.setCod_ejecucion(db.getString(DBComproSubReparto.COD_EJECUCION));
    comprosubreparto.setDesc_ejecucion(db.getString(DBComproSubReparto.DESC_EJECUCION));
    comprosubreparto.setFec_desde(db.getDate(DBComproSubReparto.FEC_DESDE));
    comprosubreparto.setFec_hasta(db.getDate(DBComproSubReparto.FEC_HASTA));
    comprosubreparto.setSubReparto(SubReparto.findByOidProxy(db.getInteger(DBComproSubReparto.OID_SUB_REPARTO),getSesion()));
  }
}
