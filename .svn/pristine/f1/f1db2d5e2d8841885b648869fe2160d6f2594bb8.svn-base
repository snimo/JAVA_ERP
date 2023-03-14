package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBPedMercDepoDet;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPedMercDepoDet extends FactoryObjetoLogico {

	public FactoryPedMercDepoDet() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		PedMercDepoDet pedmercdepodet = (PedMercDepoDet) objLog;
		pedmercdepodet.setOID(db.getInteger(DBPedMercDepoDet.OID_PED_MERC_DET));
		pedmercdepodet.setPedido_mercaderia(PedMercDep.findByOidProxy(db.getInteger(DBPedMercDepoDet.OID_PED_MERC), getSesion()));
		pedmercdepodet.setProducto(Producto.findByOidProxy(db.getInteger(DBPedMercDepoDet.OID_PRODUCTO), getSesion()));
		pedmercdepodet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBPedMercDepoDet.OID_UM), getSesion()));
		pedmercdepodet.setCantidad(db.getDouble(DBPedMercDepoDet.CANTIDAD));
		pedmercdepodet.setObservacion(db.getString(DBPedMercDepoDet.OBSERVACION));
		pedmercdepodet.setFec_necesidad(db.getDate(DBPedMercDepoDet.FEC_NECESIDAD));
		pedmercdepodet.setPedido(PedidoCab.findByOidProxy(db.getInteger(DBPedMercDepoDet.OID_CCO_PED), getSesion()));
		pedmercdepodet.setPedido_det(PedidoDet.findByOidProxy(db.getInteger(DBPedMercDepoDet.OID_PED_DET), getSesion()));
		pedmercdepodet.setActivo(db.getBoolean(DBPedMercDepoDet.ACTIVO));
		pedmercdepodet.setCantEnviada(db.getDouble(DBPedMercDepoDet.CANT_ENVIADA));
		pedmercdepodet.setPendEnvio(db.getBoolean(DBPedMercDepoDet.PEND_ENVIO));
		pedmercdepodet.setCantRecepcionada(db.getDouble(DBPedMercDepoDet.CANT_RECEP));
		pedmercdepodet.setPendRecep(db.getBoolean(DBPedMercDepoDet.PEND_RECEP));

	}
}
