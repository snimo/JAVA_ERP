package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBUnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;
import com.srn.erp.tesoreria.da.DBCuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UnidadOrganizativa extends ObjetoLogico {

	public UnidadOrganizativa() {
	}

	public static String						NICKNAME	= "ge.UnidadOrganizativa";

	private String									codigo;

	private String									descripcion;

	private TipoUnidadOrganizativa	tipoUnidadOrganizativa;

	private Boolean									activo;

	private Sucursal								sucursal;

	public void setSucursal(Sucursal aSucursal) throws BaseException {
		this.sucursal = aSucursal;
	}

	public Sucursal getSucursal() throws BaseException {
		supportRefresh();
		return sucursal;
	}

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

	public TipoUnidadOrganizativa getTipounidadorganizativa() throws BaseException {
		supportRefresh();
		return tipoUnidadOrganizativa;
	}

	public void setTipounidadorganizativa(TipoUnidadOrganizativa aTipounidadorganizativa) {
		this.tipoUnidadOrganizativa = aTipounidadorganizativa;
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

	public static UnidadOrganizativa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (UnidadOrganizativa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static UnidadOrganizativa findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (UnidadOrganizativa) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static UnidadOrganizativa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (UnidadOrganizativa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(tipoUnidadOrganizativa, "Debe ingresar el Tipo de Unidad Organizativa");
		Validar.noNulo(sucursal, "Debe ingresar la Sucursal");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("La Unidad Organizativa debe estar en modo activo");
	}

	public static List getUnidadesOrganizativas(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return DBUnidadOrganizativa.getUnidadesOrganizativas(sucursal, aSesion);
	}

	public static List getUnidadesOrganizativasSistBancos(ISesion aSesion) throws BaseException {
		return DBUnidadOrganizativa.getUnidadesOrganizativasSistBancos(aSesion);
	}

	public List getCuentasHabSistBancos() throws BaseException {
		return CuentaSistemaBanco.getCuentasByUniOrg(this, this.getSesion());
	}

}
