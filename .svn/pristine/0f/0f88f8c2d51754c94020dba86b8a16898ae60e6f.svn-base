package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CondicionCompraDet;
import com.srn.erp.compras.da.DBCondicionCompraDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionCompraDet extends FactoryObjetoLogico {

  public FactoryCondicionCompraDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionCompraDet condicioncompradet = (CondicionCompraDet) objLog;
    condicioncompradet.setOID(db.getInteger(DBCondicionCompraDet.OID_COND_CP_DET));
    condicioncompradet.setCondicioncompra(CondicionCompra.findByOidProxy(db.getInteger(DBCondicionCompraDet.OID_COND_COMPRA),getSesion()));
    condicioncompradet.setUnidadvenc(db.getString(DBCondicionCompraDet.UNIDAD_CUOTA_VENC));
    condicioncompradet.setCantidad(db.getInteger(DBCondicionCompraDet.CANTIDAD));
    condicioncompradet.setNrocuota(db.getInteger(DBCondicionCompraDet.NRO_CUOTA));
    condicioncompradet.setPorcentaje(db.getDouble(DBCondicionCompraDet.PORC));
    condicioncompradet.setActivo(db.getBoolean(DBCondicionCompraDet.ACTIVO));

  }
}
