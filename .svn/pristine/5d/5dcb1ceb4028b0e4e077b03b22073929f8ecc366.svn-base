package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBPedidoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PedidoDetAnulacion extends ObjetoLogico {

	public PedidoDetAnulacion() {
	}

	public static String				NICKNAME		= "ve.PedidoDetAnulacion";

	private PedidoCabAnulacion	pedido_cab_anu;

	private PedidoDet						pedido_det;

	public PedidoCabAnulacion getPedido_cab_anu() throws BaseException {
		supportRefresh();
		return pedido_cab_anu;
	}

	public void setPedido_cab_anu(PedidoCabAnulacion aPedido_cab_anu) {
		this.pedido_cab_anu = aPedido_cab_anu;
	}

	public PedidoDet getPedido_det() throws BaseException {
		supportRefresh();
		return pedido_det;
	}

	public void setPedido_det(PedidoDet aPedido_det) {
		this.pedido_det = aPedido_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PedidoDetAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PedidoDetAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PedidoDetAnulacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PedidoDetAnulacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(pedido_cab_anu, "Debe ingresar el Pedido de Anulación");
		Validar.noNulo(pedido_det, "Debe ingresar el Detalle del Pedido");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getDetalles(PedidoCabAnulacion pedidoCabAnulacion, ISesion aSesion) throws BaseException {
		return DBPedidoDetAnulacion.getDetalles(pedidoCabAnulacion, aSesion);
	}

}
