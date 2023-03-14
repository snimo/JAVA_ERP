package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfConsGenStock;
import com.srn.erp.stock.da.DBConfConsGenStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfConsGenStock extends FactoryObjetoLogico { 

  public FactoryConfConsGenStock() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfConsGenStock confconsgenstock = (ConfConsGenStock) objLog;
    confconsgenstock.setOID(db.getInteger(DBConfConsGenStock.OID_CONF_CONS_STK));
    confconsgenstock.setCodigo(db.getString(DBConfConsGenStock.CODIGO));
    confconsgenstock.setDescripcion(db.getString(DBConfConsGenStock.DESCRIPCION));
    confconsgenstock.setActivo(db.getBoolean(DBConfConsGenStock.ACTIVO));
    confconsgenstock.setTipo_valor_fila(db.getString(DBConfConsGenStock.TIPO_VALOR_FILA));
    confconsgenstock.setClasif_ent_grupo(ClasificadorEntidad.findByOidProxy(db.getInteger(DBConfConsGenStock.OID_CLASIF_ENT_AGRUP),getSesion()));
    confconsgenstock.setTotalizar(db.getBoolean(DBConfConsGenStock.TOTALIZAR));
    confconsgenstock.setClasif_ent_fila(ClasificadorEntidad.findByOidProxy(db.getInteger(DBConfConsGenStock.OID_CLASIF_ENT_FILA),getSesion()));
    confconsgenstock.setFiltrarProdStockPorCodigo(db.getBoolean(DBConfConsGenStock.FIL_PROD_STK_COD));
    confconsgenstock.setFiltrarProdStockPorDesc(db.getBoolean(DBConfConsGenStock.FIL_PROD_STK_DES));
    confconsgenstock.setConsolidarStock(db.getBoolean(DBConfConsGenStock.CONSOLIDAR_STOCK));
    confconsgenstock.setVerColTotFila(db.getBoolean(DBConfConsGenStock.VER_COL_TOT_FILA));
  }
}
