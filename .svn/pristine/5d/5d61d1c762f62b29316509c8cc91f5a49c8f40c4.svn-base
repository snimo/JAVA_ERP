package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ComproAjusteStkAnu;
import com.srn.erp.stock.da.DBComproAjusteStkAnu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproAjusteStkAnu extends FactoryObjetoLogico { 

  public FactoryComproAjusteStkAnu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproAjusteStkAnu comproajustestkanu = (ComproAjusteStkAnu) objLog;
    comproajustestkanu.setOID(db.getInteger(DBComproAjusteStkAnu.OID_AJU_ANU));
    
    // Por comproCab
    comproajustestkanu.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproajustestkanu.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproajustestkanu.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproajustestkanu.setLetra(db.getString(DBComproCab.LETRA));
    comproajustestkanu.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproajustestkanu.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproajustestkanu.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproajustestkanu.setEmision(db.getDate(DBComproCab.EMISION));
    comproajustestkanu.setEstado(db.getString(DBComproCab.ESTADO));
    comproajustestkanu.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproajustestkanu.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproajustestkanu.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproajustestkanu.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproajustestkanu.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    
    comproajustestkanu.setComproajustestk(ComproAjusteStk.findByOidProxy(db.getInteger(DBComproAjusteStkAnu.OID_AJU_STK_CAB),getSesion()));

  }
}
