package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.da.DBConciliacionCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryConciliacionCab extends FactoryObjetoLogico { 

  public FactoryConciliacionCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConciliacionCab conciliacioncab = (ConciliacionCab) objLog;
    conciliacioncab.setOID(db.getInteger(DBConciliacionCab.OID_CONCI_BCO));
    
    conciliacioncab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    conciliacioncab.setTcExt(db.getString(DBComproCab.TC_EXT));
    conciliacioncab.setLetra(db.getString(DBComproCab.LETRA));
    conciliacioncab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    conciliacioncab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    conciliacioncab.setNroext(db.getInteger(DBComproCab.NROEXT));
    conciliacioncab.setEmision(db.getDate(DBComproCab.EMISION));
    conciliacioncab.setImputac(db.getDate(DBComproCab.IMPUTAC));
    conciliacioncab.setEstado(db.getString(DBComproCab.ESTADO));
    conciliacioncab.setComentario(db.getString(DBComproCab.COMENTARIO));
    conciliacioncab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    conciliacioncab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    conciliacioncab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    conciliacioncab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    conciliacioncab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    conciliacioncab.setCodigo(db.getString(DBConciliacionCab.CODIGO));
    conciliacioncab.setConciliado_al(db.getDate(DBConciliacionCab.CONCILIADO_AL));
    conciliacioncab.setFec_desde(db.getDate(DBConciliacionCab.FEC_DESDE));
    conciliacioncab.setDescripcion(db.getString(DBConciliacionCab.DESCRIPCION));
    conciliacioncab.setCuenta_bancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBConciliacionCab.OID_CTA_BANCARIA),getSesion()));
    conciliacioncab.setObs_generales(db.getString(DBConciliacionCab.OBS_GENERALES));
    conciliacioncab.setSaldo_ini_extrac(db.getDouble(DBConciliacionCab.SALDO_INI_EXTRAC));

  }
}
