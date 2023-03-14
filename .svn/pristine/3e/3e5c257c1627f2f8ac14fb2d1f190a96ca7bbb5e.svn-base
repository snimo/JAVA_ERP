package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBCotizacionDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CotizacionDetAnulacion extends ObjetoLogico {

	public CotizacionDetAnulacion() {
	}

	public static String				NICKNAME		= "ve.CotizacionDetAnulacion";

	private CotizacionCabAnulacion	cotizacion_cab_anu;

	private CotizacionDet						cotizacion_det;

	public CotizacionCabAnulacion getCotizacion_cab_anu() throws BaseException {
		supportRefresh();
		return cotizacion_cab_anu;
	}

	public void setCotizacion_cab_anu(CotizacionCabAnulacion aCotizacion_cab_anu) {
		this.cotizacion_cab_anu = aCotizacion_cab_anu;
	}

	public CotizacionDet getCotizacion_det() throws BaseException {
		supportRefresh();
		return cotizacion_det;
	}

	public void setCotizacion_det(CotizacionDet aCotizacion_det) {
		this.cotizacion_det = aCotizacion_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static CotizacionDetAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CotizacionDetAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CotizacionDetAnulacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CotizacionDetAnulacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cotizacion_cab_anu, "Debe ingresar la Cotización de Anulación");
		Validar.noNulo(cotizacion_det, "Debe ingresar el Detalle de la Cotización");
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

	public static List getDetalles(CotizacionCabAnulacion cotizacionCabAnulacion, ISesion aSesion) throws BaseException {
		return DBCotizacionDetAnulacion.getDetalles(cotizacionCabAnulacion, aSesion);
	}

}
