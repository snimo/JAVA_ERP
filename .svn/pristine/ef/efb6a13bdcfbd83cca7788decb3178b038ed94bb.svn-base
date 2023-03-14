package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBListaPrecioCondPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ListaPrecioCondPago extends ObjetoLogico {

	public ListaPrecioCondPago() {
	}

	public static String	NICKNAME	= "ve.ListaPrecioCondPago";

	private CondicionPago	condicionPago;

	private ListaPrecios	listaPrecio;

	public CondicionPago getCondicionpago() throws BaseException {
		supportRefresh();
		return condicionPago;
	}

	public void setCondicionpago(CondicionPago aCondicionpago) {
		this.condicionPago = aCondicionpago;
	}

	public ListaPrecios getListaprecio() throws BaseException {
		supportRefresh();
		return listaPrecio;
	}

	public void setListaprecio(ListaPrecios aListaprecio) {
		this.listaPrecio = aListaprecio;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ListaPrecioCondPago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ListaPrecioCondPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ListaPrecioCondPago findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ListaPrecioCondPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(condicionPago, "Debe ingresar la condición de Pago");
		Validar.noNulo(listaPrecio, "Debe ingresar la lista de Precios");
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static List getDetallesListaPreciosCondPago(CondicionPago condPago, ISesion aSesion) throws BaseException {
		return DBListaPrecioCondPago.getDetallesListaPreciosCondPago(condPago,aSesion);
	}
	

}
