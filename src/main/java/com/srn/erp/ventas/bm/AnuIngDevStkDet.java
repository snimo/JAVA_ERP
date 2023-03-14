package com.srn.erp.ventas.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuIngDevStkDet extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuIngDevStkDet() {
	}

	public static String NICKNAME = "ve.AnuIngDevStkDet";

	private AnuIngDevStkCab anulacion_ing_dev_stk;
	private IngStockDevVtasDet ingreso_dev_stk_det;

	public AnuIngDevStkCab getAnulacion_ing_dev_stk() throws BaseException {
		supportRefresh();
		return anulacion_ing_dev_stk;
	}

	public void setAnulacion_ing_dev_stk(AnuIngDevStkCab aAnulacion_ing_dev_stk) {
		this.anulacion_ing_dev_stk = aAnulacion_ing_dev_stk;
	}

	public IngStockDevVtasDet getIngreso_dev_stk_det() throws BaseException {
		supportRefresh();
		return ingreso_dev_stk_det;
	}

	public void setIngreso_dev_stk_det(IngStockDevVtasDet aIngreso_dev_stk_det) {
		this.ingreso_dev_stk_det = aIngreso_dev_stk_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuIngDevStkDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuIngDevStkDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuIngDevStkDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnuIngDevStkDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulacion_ing_dev_stk, "Debe ingresar la Anulación");
		Validar.noNulo(ingreso_dev_stk_det, "Debe ingresar la detalle de la Devolución");
	}

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Anular las aplicaciones correspondientes
		Iterator iterAplicAInhabilitar = 
			this.getIngreso_dev_stk_det().getAplicacionesByIngStockDet().iterator();
		while (iterAplicAInhabilitar.hasNext()) {
			AplicacionIngDevStock aplicIngDevStk = (AplicacionIngDevStock) iterAplicAInhabilitar.next();
			aplicIngDevStk.delete();
			aplicIngDevStk.save();
		}
		
	}

}
