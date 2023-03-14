package com.srn.erp.ventas.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnulacionDevolucionDet extends ObjetoLogico {

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

	public AnulacionDevolucionDet() {
	}

	public static String NICKNAME = "ve.AnulacionDevolucionDet";

	private AnulacionDevolucionCab anulador_devolucion_cab;
	private DevolucionVtasDet devolucion_det;

	public AnulacionDevolucionCab getAnulador_devolucion_cab() throws BaseException {
		supportRefresh();
		return anulador_devolucion_cab;
	}

	public void setAnulador_devolucion_cab(AnulacionDevolucionCab aAnulador_devolucion_cab) {
		this.anulador_devolucion_cab = aAnulador_devolucion_cab;
	}

	public DevolucionVtasDet getDevolucion_det() throws BaseException {
		supportRefresh();
		return devolucion_det;
	}

	public void setDevolucion_det(DevolucionVtasDet aDevolucion_det) {
		this.devolucion_det = aDevolucion_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnulacionDevolucionDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnulacionDevolucionDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnulacionDevolucionDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AnulacionDevolucionDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(anulador_devolucion_cab, "Debe ingresar el Anulador");
		Validar.noNulo(devolucion_det, "Debe ingresar la Devolución detalle de Ventas");
	}

	@Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Anular el detalle correspondiente
		Iterator iterAplicParaAnulacion = 
			AplicacionIngDevRto.getAplicacionesActivasIngDevDet(this.getDevolucion_det(), this.getSesion()).iterator();
		while (iterAplicParaAnulacion.hasNext()) {
			AplicacionIngDevRto aplicIngDevRto = (AplicacionIngDevRto) iterAplicParaAnulacion.next();
			aplicIngDevRto.delete();
			aplicIngDevRto.save();
		}
	
		
	}

}
