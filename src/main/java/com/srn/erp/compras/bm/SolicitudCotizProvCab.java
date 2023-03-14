package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBSolicitudCotizProvCab;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;


public class SolicitudCotizProvCab extends ComproCab {

	public SolicitudCotizProvCab() {
	}

	private List cotizacionesProveedor = new ArrayList();
	private boolean readCotizacionesProveedores = true;

	private List productosACotizar = new ArrayList();
	private boolean readProductosACotizar = true;
	
	private List cotizacionesProveedoresProductos = new ArrayList();
	private boolean readProveedoresProductos = true;

	private ComproCab comprobante;

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public static String NICKNAME = "cp.SolicitudCotizProvCab";

	private java.util.Date fec_tope_ent_sol;

	private String obs_detalladas;

	public java.util.Date getFec_tope_ent_sol() throws BaseException {
		supportRefresh();
		return fec_tope_ent_sol;
	}

	public void setFec_tope_ent_sol(java.util.Date aFec_tope_ent_sol) {
		this.fec_tope_ent_sol = aFec_tope_ent_sol;
	}

	public String getObs_detalladas() throws BaseException {
		supportRefresh();
		return obs_detalladas;
	}

	public void setObs_detalladas(String aObs_detalladas) {
		this.obs_detalladas = aObs_detalladas;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static SolicitudCotizProvCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SolicitudCotizProvCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SolicitudCotizProvCab findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (SolicitudCotizProvCab) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		
		Validar.noNulo(fec_tope_ent_sol, "Debe ingresar la fecha tope");
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}
		beforeSaveComprobante(this);
	}

	public List getCotizacionesProveedores() throws BaseException {
		if (readCotizacionesProveedores) {
			cargarListaFromBD(cotizacionesProveedor,SolicitudCotizProveedor
					.getSolicitudesCotizProveedor(this, getSesion()));
			readCotizacionesProveedores = false;
		}
		return cotizacionesProveedor;
	}

	public List getProductosACotizar() throws BaseException {
		if (readProductosACotizar) {
			cargarListaFromBD(productosACotizar,SolicitudCotizProvDet
					.getSolicitudesCotizProvDet(this, getSesion()));
			readProductosACotizar = false;
		}
		return productosACotizar;
	}
	
	public List getProductosCotizProveedores() throws BaseException {
		if (readProveedoresProductos) {
			cargarListaFromBD(cotizacionesProveedoresProductos,
					SolicitudCotizDetPorProv.getSolicitudesCotizDetPorProveedores(this, getSesion()));
			readProveedoresProductos = false;
		}
		return cotizacionesProveedoresProductos;		
	}

	public void addCotizacionProveedor(
			SolicitudCotizProveedor solicitudCotizProveedor)
			throws BaseException {
		solicitudCotizProveedor.setSolicitud_cotizacion(this);
		cotizacionesProveedor.add(solicitudCotizProveedor);
	}

	public void addProductoACotizar(SolicitudCotizProvDet solicitudCotizProvDet)
			throws BaseException {
		solicitudCotizProvDet.setSolicitud_cotiz_proveedor(this);
		productosACotizar.add(solicitudCotizProvDet);
	}
	
	public void addCotizacionProductoProveedor(SolicitudCotizDetPorProv solCotizDetPorProv) throws BaseException {
		solCotizDetPorProv.setSolicitudCotizacion(this);
		cotizacionesProveedoresProductos.add(solCotizDetPorProv);
	}

	public void afterSave() throws BaseException {
		Iterator iterCotizacionesProveedores = cotizacionesProveedor.iterator();
		while (iterCotizacionesProveedores.hasNext()) {
			SolicitudCotizProveedor solCotizProv = (SolicitudCotizProveedor) iterCotizacionesProveedores
					.next();
			solCotizProv.save();
			solCotizProv = null;
		}
		iterCotizacionesProveedores = null;
		
		Iterator iterProductosACotizar = productosACotizar.iterator();
		while (iterProductosACotizar.hasNext()) {
		  SolicitudCotizProvDet solCotizProvDet = (SolicitudCotizProvDet) iterProductosACotizar.next();
		  solCotizProvDet.save();
		  solCotizProvDet = null;
		}
		iterProductosACotizar = null;
		
		Iterator iterCotizProvProd = cotizacionesProveedoresProductos.iterator();
		while (iterCotizProvProd.hasNext()) {
			SolicitudCotizDetPorProv solCotizDetPorProv = (SolicitudCotizDetPorProv) iterCotizProvProd.next();
			solCotizDetPorProv.save();
			solCotizDetPorProv = null;
		}
		iterCotizProvProd = null;
	}
	
	public SolicitudCotizProveedor getSolicitudCotizProveedor(Integer oid) throws BaseException {
		SolicitudCotizProveedor result = null;
		Iterator iterProveedoresCotiz = getCotizacionesProveedores().iterator();
		while (iterProveedoresCotiz.hasNext()) {
			SolicitudCotizProveedor solCotizProveedor = (SolicitudCotizProveedor) iterProveedoresCotiz.next();
			if (solCotizProveedor.getOID() == oid.intValue()) {
				result = solCotizProveedor;
				break;
			}
		}
		return result;
	}
	
	public SolicitudCotizProvDet getSolicitudCotizProvDet(Integer oid) throws BaseException {
		SolicitudCotizProvDet result = null;
		Iterator iterProveedoresCotizDet = getProductosACotizar().iterator();
		while (iterProveedoresCotizDet.hasNext()) {
			SolicitudCotizProvDet solCotizProveedorDet = (SolicitudCotizProvDet) iterProveedoresCotizDet.next();
			if (solCotizProveedorDet.getOID() == oid.intValue()) {
				result = solCotizProveedorDet;
				break;
			}
		}
		return result;
	}	
	
	public static List getSolicitudesCotizProvCab(HashTableDatos condiciones,ISesion aSesion) throws BaseException {
	  return DBSolicitudCotizProvCab.getSolicitudesCotizProvCab(condiciones,aSesion);
	}	
	
	public static List getSolicitudesCotizProvCab(Proveedor proveedor, Integer nroExt,
	          ISesion aSesion) throws BaseException {
		  return DBSolicitudCotizProvCab.getSolicitudesCotizProvCab(proveedor,nroExt,aSesion);
	}
	
	public static Talonario getSolCotProvCabAltaItem(ISesion aSesion)
	throws BaseException {
		Integer oidSolCotProvCab = ValorParametro.findByCodigoParametro(
		"TAL_SOL_COT_PROV_ALTA", aSesion).getOidObjNeg();
		Talonario talonario = Talonario.findByOid(oidSolCotProvCab, aSesion);
		return talonario;
	}
	
	
}
