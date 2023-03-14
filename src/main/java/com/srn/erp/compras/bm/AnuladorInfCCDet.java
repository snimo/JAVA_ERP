package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAnuladorInfCCDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorInfCCDet extends ObjetoLogico {
	
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

	public AnuladorInfCCDet() {
	}

	public static String NICKNAME = "cp.AnuladorInfCCDet";

	private AnuladorInfCC anulador_inf_cc;

	private InformeControlCalidadDet detalle_inf_cc;

	public AnuladorInfCC getAnulador_inf_cc() throws BaseException {
		supportRefresh();
		return anulador_inf_cc;
	}

	public void setAnulador_inf_cc(AnuladorInfCC aAnulador_inf_cc) {
		this.anulador_inf_cc = aAnulador_inf_cc;
	}

	public InformeControlCalidadDet getDetalle_inf_cc() throws BaseException {
		supportRefresh();
		return detalle_inf_cc;
	}

	public void setDetalle_inf_cc(InformeControlCalidadDet aDetalle_inf_cc) {
		this.detalle_inf_cc = aDetalle_inf_cc;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorInfCCDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfCCDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorInfCCDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfCCDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar
				.noNulo(anulador_inf_cc,
						"Debe ingresar el comprobante anulador");
		Validar.noNulo(detalle_inf_cc,
				"Debe ingresar el Detalle del Inf. de CC");
	}

	public static List getDetalles(AnuladorInfCC anulador, ISesion aSesion)
			throws BaseException {
		return DBAnuladorInfCCDet.getDetalles(anulador, aSesion);
	}

}
