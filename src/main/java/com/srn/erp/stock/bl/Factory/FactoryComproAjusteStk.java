package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.da.DBComproAjusteStk;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproAjusteStk extends FactoryObjetoLogico {

  public FactoryComproAjusteStk() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproAjusteStk comproajustestk = (ComproAjusteStk) objLog;
    comproajustestk.setOID(db.getInteger(DBComproAjusteStk.OID_AJU_STK_CAB));
    
    
    // Por comproCab
    comproajustestk.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    comproajustestk.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    comproajustestk.setTcExt(db.getString(DBComproCab.TC_EXT));
    comproajustestk.setLetra(db.getString(DBComproCab.LETRA));
    comproajustestk.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    comproajustestk.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    comproajustestk.setNroext(db.getInteger(DBComproCab.NROEXT));
    comproajustestk.setEmision(db.getDate(DBComproCab.EMISION));
    comproajustestk.setEstado(db.getString(DBComproCab.ESTADO));
    comproajustestk.setComentario(db.getString(DBComproCab.COMENTARIO));
    comproajustestk.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    comproajustestk.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    comproajustestk.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    comproajustestk.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    
    comproajustestk.setTipo_aju_stk(db.getString(DBComproAjusteStk.TIPO_AJU_STK));
    comproajustestk.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproAjusteStk.OID_TALONARIO),getSesion()));
    comproajustestk.setConf_mov_stk_tal(ConfMovStkTalonario.findByOidProxy(db.getInteger(DBComproAjusteStk.OID_CONF_MOV_STK),getSesion()));
    comproajustestk.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBComproAjusteStk.OID_TIPO_CONF_MOV),getSesion()));
    comproajustestk.setCompoStkTalAjuStk(CompoStkTalonarioAjuStk.findByOidProxy(db.getInteger(DBComproAjusteStk.OID_COMPO_STK_AJU),getSesion()));
  }
}
