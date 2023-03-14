package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAnuladorRequisicionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorRequisicionDet extends ObjetoLogico {

	@Override
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

	public AnuladorRequisicionDet() {
	}

	public static String NICKNAME = "cp.AnuladorRequisicionDet";

	private AnuladorRequisicionCab anulador_req_cab;
	private RequisicionDet requisicion_det;

	public AnuladorRequisicionCab getAnulador_req_cab() throws BaseException {
		supportRefresh();
		return anulador_req_cab;
	}

	public void setAnulador_req_cab(AnuladorRequisicionCab aAnulador_req_cab) {
		this.anulador_req_cab = aAnulador_req_cab;
	}

	public RequisicionDet getRequisicion_det() throws BaseException {
		supportRefresh();
		return requisicion_det;
	}

	public void setRequisicion_det(RequisicionDet aRequisicion_det) {
		this.requisicion_det = aRequisicion_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorRequisicionDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorRequisicionDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorRequisicionDet findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (AnuladorRequisicionDet) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_req_cab, "Debe ingresar el Anulador");
		Validar.noNulo(requisicion_det,"Debe ingresar el Detalle de Requisición");
	}

	public static List getDetalles(
			AnuladorRequisicionCab anuladorRequisicionCab, ISesion aSesion)
			throws BaseException {
		return DBAnuladorRequisicionDet.getDetalles(anuladorRequisicionCab,
				aSesion);
	}

}
