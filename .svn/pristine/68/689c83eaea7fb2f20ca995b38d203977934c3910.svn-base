package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.MotivoDevolucionCliente;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBDevolucionVtasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDevolucionVtasDet extends FactoryObjetoLogico { 

  public FactoryDevolucionVtasDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DevolucionVtasDet devolucionvtasdet = (DevolucionVtasDet) objLog;
    devolucionvtasdet.setOID(db.getInteger(DBDevolucionVtasDet.OID_DEV_DET));
    devolucionvtasdet.setDevolucion_cab(DevolucionVtasCab.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_DEV_CAB),getSesion()));
    devolucionvtasdet.setProducto(Producto.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_PRODUCTO),getSesion()));
    devolucionvtasdet.setObservaciones(db.getString(DBDevolucionVtasDet.OBSERVACIONES));
    devolucionvtasdet.setPend_emitir_nc(db.getBoolean(DBDevolucionVtasDet.PEND_EMITIR_NC));
    devolucionvtasdet.setModif_precio(db.getBoolean(DBDevolucionVtasDet.MODIF_PRECIO));
    devolucionvtasdet.setCantidad_devuelta(db.getDouble(DBDevolucionVtasDet.CANT_DEV));
    devolucionvtasdet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_UM),getSesion()));
    devolucionvtasdet.setPedido_det(PedidoDet.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_PED_DET),getSesion()));
    devolucionvtasdet.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_RTO_DET),getSesion()));
    devolucionvtasdet.setFactura_det(FacturaDet.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_FACT_DET),getSesion()));
    devolucionvtasdet.setActivo(db.getBoolean(DBDevolucionVtasDet.ACTIVO));
    devolucionvtasdet.setMotivo_devolucion(MotivoDevolucionCliente.findByOidProxy(db.getInteger(DBDevolucionVtasDet.OID_MOTIVO_DEV),getSesion()));
    devolucionvtasdet.setCantIngStk(db.getDouble(DBDevolucionVtasDet.CANT_ING_STK));
    devolucionvtasdet.setPendIngStk(db.getBoolean(DBDevolucionVtasDet.PEND_ING_STK));

  }
}
