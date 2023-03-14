package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ComproAjusteStkDet;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBComproAjusteStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproAjusteStkDet extends FactoryObjetoLogico {

  public FactoryComproAjusteStkDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproAjusteStkDet comproajustestkdet = (ComproAjusteStkDet) objLog;
    comproajustestkdet.setOID(db.getInteger(DBComproAjusteStkDet.OID_AJU_STK_DET));
    comproajustestkdet.setAjuste_stock_cab(ComproAjusteStk.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_AJU_STK_CAB),getSesion()));
    comproajustestkdet.setProducto(Producto.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_PRODUCTO),getSesion()));
    comproajustestkdet.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_TIPO_CONF_MOV),getSesion()));
    comproajustestkdet.setCantidad(db.getDouble(DBComproAjusteStkDet.CANTIDAD));
    comproajustestkdet.setUm_carga(UnidadMedida.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_UM_CARGA),getSesion()));
    comproajustestkdet.setConf_mov_stk(ConfMovStkTalonario.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_CONF_MOV_STK),getSesion()));
    comproajustestkdet.setCompo_stk_aju(CompoStkTalonarioAjuStk.findByOidProxy(db.getInteger(DBComproAjusteStkDet.OID_COMPO_STK_AJU),getSesion()));
    comproajustestkdet.setObservaciones(db.getString(DBComproAjusteStkDet.OBSERVACIONES));
    comproajustestkdet.setActivo(db.getBoolean(DBComproAjusteStkDet.ACTIVO));

  }
}
