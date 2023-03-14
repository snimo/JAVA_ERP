package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBArchLoteConciDet;
import com.srn.erp.conciTarjeta.da.DBCabModeloLiq;
import com.srn.erp.conciTarjeta.da.DBDetTarConciEnt;
import com.srn.erp.conciTarjeta.da.DBEmpresaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EmpresaConciTar extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EmpresaConciTar() {
	}

	public static String NICKNAME = "ctar.EmpresaConciTar";

	private String razon_social;
	private String cuit;
	private String codComercio;
	private Boolean activo;
	private Integer ultNroConci;
	private String codEmpArchImpTarj;
	private String tipoAsiCob;
	private String tipoAsiLiq;
	private String codEmpInterfaz;
	private String tipoDocuAsiCobranza;
	private String unidadContaAsiCobranza;
	private String tipoDocuAsiLiquidacion;
	private String unidadContaAsiLiquidacion;

	public String getRazon_social() throws BaseException {
		supportRefresh();
		return razon_social;
	}

	public String getUnidadContaAsiLiq() throws BaseException {
		supportRefresh();
		if (this.unidadContaAsiLiquidacion != null)
			return this.unidadContaAsiLiquidacion;
		else
			return "";
	}

	public String getTipoDocuAsiCobranza() throws BaseException {
		supportRefresh();
		if (this.tipoDocuAsiCobranza != null)
			return this.tipoDocuAsiCobranza;
		else
			return "";
	}

	public void setTipoDocuAsiCobranza(String aTipoDocuAsiCobranza) {
		this.tipoDocuAsiCobranza = aTipoDocuAsiCobranza;
	}

	public void setUnidadContaAsiLiq(String aUniContaAsiLiqui) {
		this.unidadContaAsiLiquidacion = aUniContaAsiLiqui;
	}

	public String getUniContaAsiCobranza() throws BaseException {
		this.supportRefresh();
		if (this.unidadContaAsiCobranza != null)
			return this.unidadContaAsiCobranza;
		else
			return "";
	}

	public String getTipoDocuAsiLiquidacion() throws BaseException {
		supportRefresh();
		if (this.tipoDocuAsiLiquidacion != null)
			return this.tipoDocuAsiLiquidacion;
		else
			return "";
	}

	public void setTipoDocuAsiLiquidacion(String aTipoDocuAsiLiq) throws BaseException {
		this.tipoDocuAsiLiquidacion = aTipoDocuAsiLiq;
	}

	public void setUniContaAsiCobranza(String aUniContaAsiCobranza) throws BaseException {
		this.unidadContaAsiCobranza = aUniContaAsiCobranza;
	}

	public String getCodEmpInterfaz() throws BaseException {
		supportRefresh();
		if (this.codEmpInterfaz != null)
			return this.codEmpInterfaz;
		else
			return "";
	}

	public void setCodEmpInterfaz(String aCodEmpInterfaz) throws BaseException {
		this.codEmpInterfaz = aCodEmpInterfaz;
	}

	public String getTipoAsiCob() throws BaseException {
		supportRefresh();
		if (this.tipoAsiCob != null)
			return this.tipoAsiCob;
		else
			return "";
	}

	public String getTipoAsiLiq() throws BaseException {
		supportRefresh();
		if (this.tipoAsiLiq != null)
			return this.tipoAsiLiq;
		else
			return "";
	}

	public String getCodEmpArchImpTarj() throws BaseException {
		supportRefresh();
		return this.codEmpArchImpTarj;
	}

	public Integer getUltNroConci() throws BaseException {
		supportRefresh();
		return this.ultNroConci;
	}

	public String getCodComercio() throws BaseException {
		supportRefresh();
		return this.codComercio;
	}

	public void setRazon_social(String aRazon_social) {
		this.razon_social = aRazon_social;
	}

	public void setTipoAsiCob(String aTipoAsiCob) {
		this.tipoAsiCob = aTipoAsiCob;
	}

	public void setTipoAsiLiq(String aTipoAsiLiq) {
		this.tipoAsiLiq = aTipoAsiLiq;
	}

	public void setCodEmpArchImpTarj(String aCodEmpArchImpTarj) {
		this.codEmpArchImpTarj = aCodEmpArchImpTarj;
	}

	public void setUltNroconci(Integer aUltNroConci) {
		this.ultNroConci = aUltNroConci;
	}

	public void setCodComercio(String aCodComercio) {
		this.codComercio = aCodComercio;
	}

	public String getCuit() throws BaseException {
		supportRefresh();
		return cuit;
	}

	public void setCuit(String aCuit) {
		this.cuit = aCuit;
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

	public static EmpresaConciTar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaConciTar) getObjectByOid(NICKNAME, oid, aSesion);
	}
	

	public static EmpresaConciTar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EmpresaConciTar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EmpresaConciTar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EmpresaConciTar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.razon_social, "Debe ingresar la Razón Social");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBEmpresaConciTar.getAllActivos(aSesion);
	}

	public static EmpresaConciTar getEmpresa(String codComercio, ISesion aSesion) throws BaseException {
		return DBEmpresaConciTar.getEmpresa(codComercio, aSesion);
	}

	public int getProxNroConci() throws BaseException {
		return DBEmpresaConciTar.getProxNroConciliacion(this, this.getSesion());
	}

	public List getMarcadosPOSNETPreConciPorEmpresaUsu(Usuario usuario) throws BaseException {
		return ArchLoteConciDet.getMarcadosPorEmpresaUsu(this, usuario, this.getSesion());
	}

	public List getMarcadosEntiTarjPorEmpresaUsu(Usuario usuario, ISesion aSesion) throws BaseException {
		return DetTarConciEnt.getMarcadosPorEmpresaUsu(this, usuario, this.getSesion());
	}

	public List getPreconciliadosPorEmpresaUsu(Usuario usuario) throws BaseException {
		return DBArchLoteConciDet.getPreconciliadosPorEmpresaUsu(this, usuario, this.getSesion());
	}

	public List getPreconciliadosByNro(Integer nroConciliacion) throws BaseException {
		return DBDetTarConciEnt.getPreconciliadosByNro(this, nroConciliacion, this.getSesion());
	}

	public List getTarjEntidadesPendPreconci(String tarjeta) throws BaseException {

		return DetTarConciEnt.getTarjPendPreconci(this, tarjeta, this.getSesion());

	}

	public List getTarjConciliadas(Integer nroConciliacion) throws BaseException {
		return DBDetTarConciEnt.getTarjConciliadas(this, nroConciliacion, this.getSesion());
	}

	public List getListaCabModLiq() throws BaseException {
		return DBCabModeloLiq.getCabModLiq(this, this.getSesion());
	}

}
