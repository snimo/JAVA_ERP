package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;
import com.srn.erp.ventas.da.DBEsquemaBonificacionProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaBonificacionProducto extends FactoryObjetoLogico { 

  public FactoryEsquemaBonificacionProducto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaBonificacionProducto esquemabonificacionproducto = (EsquemaBonificacionProducto) objLog;
    esquemabonificacionproducto.setOID(db.getInteger(DBEsquemaBonificacionProducto.OID_ESQ_BONIF_PROD));
    esquemabonificacionproducto.setEsquema_bonificacion(EsquemaBonificacion.findByOidProxy(db.getInteger(DBEsquemaBonificacionProducto.OID_ESQ_BONIF),getSesion()));
    esquemabonificacionproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBEsquemaBonificacionProducto.OID_PRODUCTO),getSesion()));
    esquemabonificacionproducto.setActivo(db.getBoolean(DBEsquemaBonificacionProducto.ACTIVO));

  }
}
