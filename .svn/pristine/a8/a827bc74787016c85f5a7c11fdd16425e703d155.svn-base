package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ProdHabUbiDepo;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.da.DBProdHabUbiDepo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProdHabUbiDepo extends FactoryObjetoLogico {

  public FactoryProdHabUbiDepo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProdHabUbiDepo prodhabubidepo = (ProdHabUbiDepo) objLog;
    prodhabubidepo.setOID(db.getInteger(DBProdHabUbiDepo.OID_UM_UBI_DEPO));
    prodhabubidepo.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBProdHabUbiDepo.OID_UBI_DEPO),getSesion()));
    prodhabubidepo.setProducto(Producto.findByOidProxy(db.getInteger(DBProdHabUbiDepo.OID_PRODUCTO),getSesion()));
  }
}
