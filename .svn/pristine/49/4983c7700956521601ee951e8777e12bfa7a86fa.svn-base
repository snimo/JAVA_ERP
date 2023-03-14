package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactSector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class EsquemaAutorizFactSector extends ObjetoLogico {

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
		return new Boolean(true);
	}

	public EsquemaAutorizFactSector() {
	}

	public static String						NICKNAME	= "cap.EsquemaAutorizFactSector";

	private EsquemaAutorizFactMonto	esquema_autoriz_factura_monto;

	private SectorCompra						sector_compra;

	private RolAutorizadorCompras		rol_autotizador;

	private String									tipo_autoriz;

	public EsquemaAutorizFactMonto getEsquema_autoriz_factura_monto() throws BaseException {
		supportRefresh();
		return esquema_autoriz_factura_monto;
	}

	public void setEsquema_autoriz_factura_monto(EsquemaAutorizFactMonto aEsquema_autoriz_factura_monto) {
		this.esquema_autoriz_factura_monto = aEsquema_autoriz_factura_monto;
	}

	public SectorCompra getSector_compra() throws BaseException {
		supportRefresh();
		return sector_compra;
	}

	public void setSector_compra(SectorCompra aSector_compra) {
		this.sector_compra = aSector_compra;
	}

	public RolAutorizadorCompras getRol_autotizador() throws BaseException {
		supportRefresh();
		return rol_autotizador;
	}

	public void setRol_autotizador(RolAutorizadorCompras aRol_autotizador) {
		this.rol_autotizador = aRol_autotizador;
	}

	public String getTipo_autoriz() throws BaseException {
		supportRefresh();
		return tipo_autoriz;
	}

	public void setTipo_autoriz(String aTipo_autoriz) {
		this.tipo_autoriz = aTipo_autoriz;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EsquemaAutorizFactSector findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactSector) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizFactSector findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactSector) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(esquema_autoriz_factura_monto, "Debe ingresar el Esquema de Autorización");
		Validar.noNulo(sector_compra, "Debe ingresar el Sector de Compra");
		Validar.noNulo(rol_autotizador, "Debe ingresar el Rol del Autorizador");
		Validar.noNulo(tipo_autoriz, "Debe ingresar el Tipo de Autorización");
	}

	public static List getEsquemasAutorizFactSector(EsquemaAutorizFactMonto esquemaAutorizFactMonto, ISesion aSesion)
			throws BaseException {
		return DBEsquemaAutorizFactSector.getEsquemasAutorizFactSector(esquemaAutorizFactMonto, aSesion);
	}
	
	public static List getEsquemasAutorizFactSector(EsquemaAutorizFactMonto esquemaAutorizFactMonto, SectorCompra sector,ISesion aSesion)
	throws BaseException {
		return DBEsquemaAutorizFactSector.getEsquemasAutorizFactSector(esquemaAutorizFactMonto,sector,aSesion);
	}
	

}
