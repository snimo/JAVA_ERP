package com.srn.erp.ventas.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ReservaPedidoDet extends ObjetoLogico {
	
    public static String NICKNAME = "ve.ReservaPedidoDet";

	public ReservaPedidoDet() {
	}

	private Decimal						cant_um_ori_res;

	public String getNickName() {
		return NICKNAME;
	}

	
	public Decimal getCant_um_ori_res() throws BaseException {
		supportRefresh();
		return cant_um_ori_res;
	}

	public void setCant_um_ori_res(Decimal aCant_um_ori_res) {
		this.cant_um_ori_res = aCant_um_ori_res;
	}


	public void beforeSave() throws BaseException {

		Validar.noNulo(cant_um_ori_res, "Debe ingresar la cantidad de la reserva/desreserva");
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() {
		return null;
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public String getCodigo() {
		return "";
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		return "";
	}
	
	public static ReservaPedidoDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ReservaPedidoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReservaPedidoDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ReservaPedidoDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	


}
