package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBObsCodifPresuCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsCodifPresuCab extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ObsCodifPresuCab() {
	}

	public static String NICKNAME = "ve.ObsCodifPresuCab";

	private CotizacionCab presupuesto;
	private Integer orden;
	private ObsCodifVtas obs_codificada;
	private Boolean activo;

	public CotizacionCab getPresupuesto() throws BaseException {
		supportRefresh();
		return presupuesto;
	}

	public void setPresupuesto(CotizacionCab aPresupuesto) {
		this.presupuesto = aPresupuesto;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public ObsCodifVtas getObs_codificada() throws BaseException {
		supportRefresh();
		return obs_codificada;
	}

	public void setObs_codificada(ObsCodifVtas aObs_codificada) {
		this.obs_codificada = aObs_codificada;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ObsCodifPresuCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifPresuCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsCodifPresuCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsCodifPresuCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(presupuesto, "Debe ingresar el Presupuesto");
		Validar.noNulo(orden, "Debe ingresar el Nro. de Orden");
		Validar.noNulo(obs_codificada, "Debe ingresar la Observación");
	}

	public static List getObsCodifPresuCab(CotizacionCab cotizacion, ISesion aSesion) throws BaseException {
		return DBObsCodifPresuCab.getObsCodifPresuCab(cotizacion, aSesion);
	}

	
}
