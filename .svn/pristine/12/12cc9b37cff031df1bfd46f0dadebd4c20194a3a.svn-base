package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBAnuladorInfRecDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorInfRecDet extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		
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

	public AnuladorInfRecDet() {
	}

	public static String NICKNAME = "cp.AnuladorInfRecDet";

	private AnuladorInfRec anulador_inf_rec;

	private InformeRecepcionDet inf_rec_det;

	public AnuladorInfRec getAnulador_inf_rec() throws BaseException {
		supportRefresh();
		return anulador_inf_rec;
	}

	public void setAnulador_inf_rec(AnuladorInfRec aAnulador_inf_rec) {
		this.anulador_inf_rec = aAnulador_inf_rec;
	}

	public InformeRecepcionDet getInf_rec_det() throws BaseException {
		supportRefresh();
		return inf_rec_det;
	}

	public void setInf_rec_det(InformeRecepcionDet aInf_rec_det) {
		this.inf_rec_det = aInf_rec_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorInfRecDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfRecDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorInfRecDet findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AnuladorInfRecDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_inf_rec, "Debe ingresar el Anulador");
		Validar.noNulo(inf_rec_det,
				"Debe ingresar el Detalle del Inf. de Recepción");
	}

	public static List getDetAnuInfRec(AnuladorInfRec anuladorInfRec,
			ISesion aSesion) throws BaseException {
		return DBAnuladorInfRecDet.getDetAnuInfRec(anuladorInfRec, aSesion);
	}

}
