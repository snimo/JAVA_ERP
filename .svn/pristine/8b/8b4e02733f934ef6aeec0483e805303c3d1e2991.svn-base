package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAutorizacionMontoCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AutorizacionMontoCompra extends ObjetoLogico {

	private List		rolesAutorizados			= new ArrayList();

	private boolean	readRolesAutorizados	= true;

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

	public AutorizacionMontoCompra() {
	}

	public static String			NICKNAME	= "cp.AutorizacionMontoCompra";

	private Double						monto_desde;

	private Double						monto_hasta;

	private Integer						secu;

	private AutorizadorCompra	autorizacion_compra;

	private Boolean						cualquier_sector;

	public Double getMonto_desde() throws BaseException {
		supportRefresh();
		return monto_desde;
	}

	public void setMonto_desde(Double aMonto_desde) {
		this.monto_desde = aMonto_desde;
	}

	public Double getMonto_hasta() throws BaseException {
		supportRefresh();
		return monto_hasta;
	}

	public void setMonto_hasta(Double aMonto_hasta) {
		this.monto_hasta = aMonto_hasta;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public AutorizadorCompra getAutorizacion_compra() throws BaseException {
		supportRefresh();
		return autorizacion_compra;
	}

	public void setAutorizacion_compra(AutorizadorCompra aAutorizacion_compra) {
		this.autorizacion_compra = aAutorizacion_compra;
	}

	public Boolean isCualquier_sector() throws BaseException {
		supportRefresh();
		return cualquier_sector;
	}

	public void setCualquier_sector(Boolean aCualquier_sector) {
		this.cualquier_sector = aCualquier_sector;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AutorizacionMontoCompra findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizacionMontoCompra) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AutorizacionMontoCompra findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AutorizacionMontoCompra) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AutorizacionMontoCompra findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AutorizacionMontoCompra) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(monto_desde, "Debe ingresar el monto desde");
		Validar.noNulo(monto_hasta, "Debe ingresar el motno hasta");
		Validar.noNulo(secu, "Debe ingresar el Orden");
		Validar.noNulo(autorizacion_compra, "Debe ingresar la Autorización de Compra");
	}

	public static List getAutorizacionesPorMonto(AutorizadorCompra autorizadorCompra, ISesion aSesion)
			throws BaseException {
		return DBAutorizacionMontoCompra.getAutorizacionesPorMonto(autorizadorCompra, aSesion);
	}

	public List getRolesAutorizaciones() throws BaseException {
		if (readRolesAutorizados) {
			List lista = RolAutorizadorOC.getRolesAutorizacionCompras(this, getSesion());
			rolesAutorizados.addAll(lista);
			readRolesAutorizados = false;
		}
		return rolesAutorizados;
	}

	public void addRolAutorizacion(RolAutorizadorOC rolAutorizadorOC) throws BaseException {
		rolAutorizadorOC.setAutorizacion_monto(this);
		rolesAutorizados.add(rolAutorizadorOC);
	}

	public void afterSave() throws BaseException {

		Iterator iterRolesAutorizados = rolesAutorizados.iterator();
		while (iterRolesAutorizados.hasNext()) {
			RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutorizados.next();
			rolAutorizadorOC.save();
			rolAutorizadorOC = null;
		}
		iterRolesAutorizados = null;
	}

	public static AutorizacionMontoCompra getAutorizMonCpraByMonto(AutorizadorCompra autorizadorCompra, Money monto,
			ISesion aSesion) throws BaseException {
		return DBAutorizacionMontoCompra.getAutorizMonCpraByMonto(autorizadorCompra, monto, aSesion);
	}
	
	 public List getRolesAutorizacionCompras(ISesion aSesion) throws BaseException {
		 return RolAutorizadorOC.getRolesAutorizacionCompras(this,aSesion);
	 }
	 
	 public List getRolesAutorizacionComprasBySector(SectorCompra sectorCompra,ISesion aSesion) throws BaseException {
		 return RolAutorizadorOC.getRolesAutorizacionCompras(this,sectorCompra,aSesion);
	 } 
	 
	

}
