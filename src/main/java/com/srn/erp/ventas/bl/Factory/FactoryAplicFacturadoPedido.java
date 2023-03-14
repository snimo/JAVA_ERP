package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AplicFacturadoPedido;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.da.DBAplicFacturadoPedido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicFacturadoPedido extends FactoryObjetoLogico { 

  public FactoryAplicFacturadoPedido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicFacturadoPedido aplicfacturadopedido = (AplicFacturadoPedido) objLog;
    aplicfacturadopedido.setOID(db.getInteger(DBAplicFacturadoPedido.OID_PED_FACT));
    aplicfacturadopedido.setPedido_det(PedidoDet.findByOidProxy(db.getInteger(DBAplicFacturadoPedido.OID_PED_DET),getSesion()));
    aplicfacturadopedido.setCant_fact(db.getDouble(DBAplicFacturadoPedido.CANT_FACT));
    aplicfacturadopedido.setCompo_compro(db.getString(DBAplicFacturadoPedido.COMPO_COMPRO));
    aplicfacturadopedido.setFactura(FacturaCab.findByOidProxy(db.getInteger(DBAplicFacturadoPedido.OID_CCO_FACT),getSesion()));
    aplicfacturadopedido.setFactura_det(FacturaDet.findByOidProxy(db.getInteger(DBAplicFacturadoPedido.OID_CCO_FACT_DET),getSesion()));
    aplicfacturadopedido.setActivo(db.getBoolean(DBAplicFacturadoPedido.ACTIVO));

  }
}
