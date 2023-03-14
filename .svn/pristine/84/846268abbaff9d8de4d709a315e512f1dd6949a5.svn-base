package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.da.DBObsCodifVtasSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsCodifVtasSucursal extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ObsCodifVtasSucursal() {
	}

	public static String NICKNAME = "ve.ObsCodifVtasSucursal";

	private ObsCodifVtas codigo_observacion;
	private Sucursal sucursal;
	private Boolean activo;

	public ObsCodifVtas getCodigo_observacion() throws BaseException {
		supportRefresh();
		return codigo_observacion;
	}

	public void setCodigo_observacion(ObsCodifVtas aCodigo_observacion) {
		this.codigo_observacion = aCodigo_observacion;
	}

	public Sucursal getSucursal() throws BaseException {
		supportRefresh();
		return sucursal;
	}

	public void setSucursal(Sucursal aSucursal) {
		this.sucursal = aSucursal;
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

	public static ObsCodifVtasSucursal findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsCodifVtasSucursal) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsCodifVtasSucursal findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsCodifVtasSucursal) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo_observacion, "Debe ingresar el Código");
		Validar.noNulo(sucursal, "Debe ingresar la Sucursal");
	}

	public static List getObsCodSucursal(ObsCodifVtas obsCod, ISesion aSesion) throws BaseException {
		return DBObsCodifVtasSucursal.getObsCodSucursal(obsCod, aSesion);
	}

}
