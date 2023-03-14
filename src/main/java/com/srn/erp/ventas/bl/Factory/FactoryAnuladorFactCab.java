package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.AnuladorFactCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.da.DBAnuladorFactCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorFactCab extends FactoryObjetoLogico { 

  public FactoryAnuladorFactCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorFactCab anuladorfactcab = (AnuladorFactCab) objLog;
    anuladorfactcab.setOID(db.getInteger(DBAnuladorFactCab.OID_ANU_FACT_CAB));
    anuladorfactcab.setFactura_cab(FacturaCab.findByOidProxy(db.getInteger(DBAnuladorFactCab.OID_CCO_FACT),getSesion()));
    
    // Por comproCab
    anuladorfactcab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    anuladorfactcab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    anuladorfactcab.setTcExt(db.getString(DBComproCab.TC_EXT));
    anuladorfactcab.setLetra(db.getString(DBComproCab.LETRA));
    anuladorfactcab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    anuladorfactcab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    anuladorfactcab.setNroext(db.getInteger(DBComproCab.NROEXT));
    anuladorfactcab.setEmision(db.getDate(DBComproCab.EMISION));
    anuladorfactcab.setEstado(db.getString(DBComproCab.ESTADO));
    anuladorfactcab.setComentario(db.getString(DBComproCab.COMENTARIO));
    anuladorfactcab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    anuladorfactcab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    anuladorfactcab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    anuladorfactcab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    anuladorfactcab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    
    

  }
}
