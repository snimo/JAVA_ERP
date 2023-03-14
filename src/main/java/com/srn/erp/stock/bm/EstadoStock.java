package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBEstadoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoStock extends ObjetoLogico {

	public EstadoStock() {
	}

	public static String	NICKNAME	= "st.EstadoStock";

	private String				codigo;

	private String				descripcion;

	private Boolean				activo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static EstadoStock findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoStock) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoStock findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoStock) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoStock findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoStock) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
	}

	public static EstadoStock getEstadoStockLibre(ISesion aSesion) throws BaseException {
		Integer oidEstadoStock = ValorParametro.findByCodigoParametro("ESTADO_STOCK_LIBRE", aSesion).getOidObjNeg();
		EstadoStock estadoStock = EstadoStock.findByOid(oidEstadoStock, aSesion);
		return estadoStock;
	}
	
	public static EstadoStock getEstadoStockReservado(ISesion aSesion) throws BaseException {
		Integer oidEstadoStock = ValorParametro.findByCodigoParametro("ESTADO_STOCK_RESERVADO", aSesion).getOidObjNeg();
		EstadoStock estadoStock = EstadoStock.findByOid(oidEstadoStock, aSesion);
		return estadoStock;
	}
	
	public static EstadoStock getEstadoStockSeparado(ISesion aSesion) throws BaseException {
		Integer oidEstadoStock = ValorParametro.findByCodigoParametro("ESTADO_STOCK_SEPARADO", aSesion).getOidObjNeg();
		EstadoStock estadoStock = EstadoStock.findByOid(oidEstadoStock, aSesion);
		return estadoStock;
	}
	
	

	public static List getAll(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoStock.NICKNAME, DBEstadoStock.SELECT_BY_ALL, null, new ListObserver(),
				aSesion);
	}

}
