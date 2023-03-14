package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.da.DBCaja;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Caja extends ObjetoLogico {

	public Caja() {
	}

	public static String NICKNAME = "te.Caja";

	private String codigo;
	private String descripcion;
	private UnidadOrganizativa unidadOrganizativa;
	private String compo;
	private Boolean activo;
	private String tipoCierreApertura;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getTipoCierreApertura() throws BaseException {
		supportRefresh();
		return tipoCierreApertura;
	}

	public void setTipoCierreApertura(String aTipoCierreApertura) {
		this.tipoCierreApertura = aTipoCierreApertura;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public UnidadOrganizativa getUnidadorganizativa() throws BaseException {
		supportRefresh();
		return unidadOrganizativa;
	}

	public void setUnidadorganizativa(UnidadOrganizativa aUnidadorganizativa) {
		this.unidadOrganizativa = aUnidadorganizativa;
	}

	public String getCompo() throws BaseException {
		supportRefresh();
		return compo;
	}

	public void setCompo(String aCompo) {
		this.compo = aCompo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Caja findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Caja) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Caja findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Caja) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Caja findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Caja) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(unidadOrganizativa, "Debe ingresar la Unidad Organizativa");
		Validar.noNulo(compo, "Debe ingresar el Tipo");
		Validar.noNulo(tipoCierreApertura, "Debe ingresar el Tipo de Cierre de Caja");

	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean activo) throws BaseException {
		this.activo = activo;
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
	public static Hashtable getTipos() {
		TiposCaja tiposCaja = new TiposCaja();
		return tiposCaja.getTipos();
	}

	public static Hashtable getTiposAperCierreCaja() {
		TiposCierreAperturaCaja tiposCierre = new TiposCierreAperturaCaja();
		return tiposCierre.getTipos();
	}

	public boolean isAperturaCierreAutomatica() throws BaseException {
		if (getTipoCierreApertura().equals(TiposCierreAperturaCaja.AUTOMATICO))
			return true;
		else
			return false;
	}

	public boolean isAperturaCierreManual() throws BaseException {
		if (getTipoCierreApertura().equals(TiposCierreAperturaCaja.MANUAL))
			return true;
		else
			return false;
	}

	public java.util.Date getFechaCaja() throws BaseException {
		if (isAperturaCierreAutomatica())
			return Fecha.getFechaActual();
		else {
			CajaCierreApertura cajaCierreApertura = CajaCierreApertura.getAperturaCierreCaja(this, getSesion());
			if (cajaCierreApertura == null)
				return null;
			else
				return cajaCierreApertura.getNuefecaper();
		}
	}

	public static List getCajasOperativasHab(ISesion aSesion) throws BaseException {

		List cajasHabilitadas = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List cajasDeUniOrg = getCajasOperativas(uniOrg, aSesion);
			cajasHabilitadas.addAll(cajasDeUniOrg);
		}
		return cajasHabilitadas;

	}

	private List getCajasHabilitadas(List unidadesOrganizativas) throws BaseException {
		return null;
	}

	public static List getCajas(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBCaja.getCajas(uniOrg, aSesion);
	}

	public boolean isOperativa() throws BaseException {
		return getCompo().equals(TiposCaja.OPERATIVA);
	}

	public static List getCajasOperativas(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		List cajasOperativas = new ArrayList();
		List cajas = getCajas(uniOrg, aSesion);
		Iterator iterCajas = cajas.iterator();
		while (iterCajas.hasNext()) {
			Caja caja = (Caja) iterCajas.next();
			if (caja.isOperativa())
				cajasOperativas.add(caja);
		}
		return cajasOperativas;
	}

	public static Caja getCajaDefFactRemito(ISesion aSesion) throws BaseException {
		Integer oidCaja = ValorParametro.findByCodigoParametro("CAJA_DEFAULT_FACT_REM", aSesion).getOidObjNeg();
		Caja caja = Caja.findByOid(oidCaja, aSesion);
		return caja;
	}

	public static Caja getCajaDefVtaMostrador(ISesion aSesion) throws BaseException {
		Integer oidCaja = ValorParametro.findByCodigoParametro("CAJA_DEF_VTA_MOST", aSesion).getOidObjNeg();
		Caja caja = Caja.findByOid(oidCaja, aSesion);
		return caja;
	}

	public SaldoEfectivo getSaldoEfectivo(TipoValor tipoValor) throws BaseException {
		return SaldoEfectivo.getSaldoEfectivo(this, tipoValor, this.getSesion());
	}

	public List getValoresEnCaja(TipoValor tipoValor) throws BaseException {
		return Valor.getValoresEnCaja(this, null, tipoValor, null, this.getSesion());
	}

	public static List getCajas(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return DBCaja.getCajas(sucursal, aSesion);
	}
	
	public Sucursal getSucursal() throws BaseException {
		return this.getUnidadorganizativa().getSucursal();
	}
	
	public SaldoTipoValor getSaldoTipoValor(TipoValor tipoValor, java.util.Date fecha) throws BaseException {
		return SaldoTipoValor.getSaldoTipoValor(this,fecha,tipoValor,getSesion());
	}
	
	public SaldoTipoValor getSaldoTipoValorAHoy(TipoValor tipoValor) throws BaseException {
		return SaldoTipoValor.getSaldoTipoValorAHoy(this,tipoValor,getSesion());
	}
	
	
	public static List getCajasOperativasActivo(ISesion aSesion) throws BaseException {
		  return DBCaja.getCajasOperativasActivo(aSesion);
	}
	

}
