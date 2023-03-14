package com.srn.erp.ctasAPagar.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.ctasAPagar.da.DBEstadisticaComproProv;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class EstadisticaComproProv extends ObjetoLogico {
	
	private Hashtable					listaOidValClasif	= new Hashtable();

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstadisticaComproProv() {
	}

	public static String NICKNAME = "cp.EstadisticaComproProv";

	private Integer nro_ext;
	private Integer oid_tc;
	private String tc_ext;
	private String letra;
	private Integer lug_emi;
	private Integer oid_proveedor;
	private Integer oid_cond_pago;
	private Integer oid_sector_compra;
	private Integer oid_concepto;
	private String descConcepto;
	private Integer oid_cco;
	private Double importe;
	private Double cotizacion;
	private Integer oid_moneda;
	private String cod_proveedor;
	private String nombre_proveedor;
	private Integer signo;
	private Date emision;
	private Integer oidCtaCte;
	private String descCtaCte;
	private Integer oidCuenta;
	private String descCuenta;
	private String codCuenta;

	public Integer getNro_ext() throws BaseException {
		supportRefresh();
		return nro_ext;
	}
	
	public void setNro_ext(Integer aNro_ext) {
		this.nro_ext = aNro_ext;	
	}
	
	public Date getEmision() throws BaseException {
		supportRefresh();
		return this.emision;
	}

	public void setEmision(Date aEmision) {
		this.emision = aEmision;
	}

	public Integer getOidTipoCtaCte() throws BaseException {
		supportRefresh();
		return this.oidCtaCte;
	}

	public void setOidTipoCtaCte(Integer aOidTipoCtaCte) {
		this.oidCtaCte = aOidTipoCtaCte;
	}

	public String getDescTipoCtaCte() throws BaseException {
		supportRefresh();
		return this.descCtaCte;
	}

	public void setDescTipoCtaCte(String aDescTipoCtaCte) {
		this.descCtaCte = aDescTipoCtaCte;
	}

	public Integer getOid_tc() throws BaseException {
		supportRefresh();
		return oid_tc;
	}

	public void setOid_tc(Integer aOid_tc) {
		this.oid_tc = aOid_tc;
	}

	public String getTc_ext() throws BaseException {
		supportRefresh();
		return tc_ext;
	}

	public void setTc_ext(String aTc_ext) {
		this.tc_ext = aTc_ext;
	}

	public String getLetra() throws BaseException {
		supportRefresh();
		return letra;
	}

	public void setLetra(String aLetra) {
		this.letra = aLetra;
	}

	public Integer getLug_emi() throws BaseException {
		supportRefresh();
		return lug_emi;
	}

	public void setLug_emi(Integer aLug_emi) {
		this.lug_emi = aLug_emi;
	}

	public Integer getOid_Proveedor() throws BaseException {
		supportRefresh();
		return this.oid_proveedor;
	}

	public void setOid_Proveedor(Integer aOid_Proveedor) {
		this.oid_proveedor = aOid_Proveedor;
	}

	public Integer getOid_cond_pago() throws BaseException {
		supportRefresh();
		return oid_cond_pago;
	}

	public void setOid_cond_pago(Integer aOid_cond_pago) {
		this.oid_cond_pago = aOid_cond_pago;
	}

	public Integer getOid_Sector_Compra() throws BaseException {
		supportRefresh();
		return this.oid_sector_compra;
	}

	public void setOid_Sector_Compra(Integer aOid_Sector_Compra) {
		this.oid_sector_compra = aOid_Sector_Compra;
	}

	public Integer getOidConcepto() throws BaseException {
		supportRefresh();
		return this.oid_concepto;
	}

	public void setOidConcepto(Integer aOidConcepto) {
		this.oid_concepto = aOidConcepto;
	}

	public String getDescConcepto() throws BaseException {
		supportRefresh();
		return this.descConcepto;
	}

	public void setDescConcepto(String aDescConcepto) {
		this.descConcepto = aDescConcepto;
	}

	public Integer getOid_cco() throws BaseException {
		supportRefresh();
		return oid_cco;
	}

	public void setOid_cco(Integer aOid_cco) {
		this.oid_cco = aOid_cco;
	}

	public Double getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Double aImporte) {
		this.importe = aImporte;
	}

	public Double getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(Double aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Integer getOid_moneda() throws BaseException {
		supportRefresh();
		return oid_moneda;
	}

	public void setOid_moneda(Integer aOid_moneda) {
		this.oid_moneda = aOid_moneda;
	}

	public String getNombreProveedoryCodigo() throws BaseException {
		return this.getNombre_proveedor() + " - " + this.getCod_proveedor();
	}

	public String getCod_proveedor() throws BaseException {
		supportRefresh();
		return this.cod_proveedor;
	}

	public void setCod_proveedor(String aCod_proveedor) {
		this.cod_proveedor = aCod_proveedor;
	}

	public Integer getOidCuenta() throws BaseException {
		supportRefresh();
		return this.oidCuenta;
	}

	public void setOidCuenta(Integer aOidCuenta) {
		this.oidCuenta = aOidCuenta;
	}
	
	public String getDescCuenta() throws BaseException {
		supportRefresh();
		return this.descCuenta;
	}

	public void setDescCuenta(String aDescCuenta) {
		this.descCuenta = aDescCuenta;
	}
	
	public String getCodCuenta() throws BaseException {
		supportRefresh();
		return this.codCuenta;
	}

	public void setCodCuenta(String aCodCuenta) {
		this.codCuenta = aCodCuenta;
	}

	public String getNombre_proveedor() throws BaseException {
		supportRefresh();
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String aNombre_proveedor) {
		this.nombre_proveedor = aNombre_proveedor;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EstadisticaComproProv findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadisticaComproProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadisticaComproProv findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadisticaComproProv) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static List getEstadisticaComproProv(java.util.Date fechaDesde, java.util.Date fechaHasta,ISesion aSesion)
			throws BaseException {
		return DBEstadisticaComproProv.getEstadisticaComproProv(fechaDesde, fechaHasta, aSesion);
	}

	public String getComprobante() throws BaseException {
		return this.getTc_ext() + "-" + this.getLetra() + "-" + this.getLug_emi().toString() + "-" + this.getNro_ext().toString();
	}
	
	public Integer getOidValorClasif(Integer oidClasificador) {
		Integer oid = (Integer)listaOidValClasif.get(oidClasificador);
		if (oid!=null)
			return oid;
		else
			return new Integer(0);
	}
	

}
