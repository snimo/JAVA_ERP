package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.PedidoCabAnulacion;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.PedidoDetAnulacion;
import com.srn.erp.ventas.da.DBPedidoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPedidoDetAnulacion extends FactoryObjetoLogico {

	public FactoryPedidoDetAnulacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		PedidoDetAnulacion pedidodetanulacion = (PedidoDetAnulacion) objLog;
		pedidodetanulacion.setOID(db.getInteger(DBPedidoDetAnulacion.OID_PED_DET_ANU));
		pedidodetanulacion.setPedido_cab_anu(PedidoCabAnulacion.findByOidProxy(db
				.getInteger(DBPedidoDetAnulacion.OID_PED_CAB_ANU), getSesion()));
		pedidodetanulacion.setPedido_det(PedidoDet.findByOidProxy(db.getInteger(DBPedidoDetAnulacion.OID_PEDIDO_DET),
				getSesion()));

	}
}
