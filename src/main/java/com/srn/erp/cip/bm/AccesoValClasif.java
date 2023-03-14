package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBAccesoValClasif;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class AccesoValClasif extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccesoValClasif() {
	}

	public static String NICKNAME = "cip.AccesoValClasif";

	private String tipo_ingreso;
	private String ley_no_ingreso;
	private Integer min_ent_antes;
	private Integer min_ent_despues;
	private String tipo_egreso;
	private String ley_no_egreso;
	private Boolean antipassback;
	private Boolean cacheo;
	private Boolean activo;
	private ValorClasificadorEntidad valor;

	public String getTipo_ingreso() throws BaseException {
		supportRefresh();
		if (tipo_ingreso != null)
			return tipo_ingreso;
		else
			return "";
	}

	public ValorClasificadorEntidad getValor() throws BaseException {
		supportRefresh();
		return this.valor;
	}

	public void setTipo_ingreso(String aTipo_ingreso) {
		this.tipo_ingreso = aTipo_ingreso;
	}

	public void setValorClasificador(ValorClasificadorEntidad aValor) {
		this.valor = aValor;
	}

	public String getLey_no_ingreso() throws BaseException {
		supportRefresh();
		if (ley_no_ingreso != null)
			return ley_no_ingreso;
		else
			return "";
	}

	public void setLey_no_ingreso(String aLey_no_ingreso) {
		this.ley_no_ingreso = aLey_no_ingreso;
	}

	public Integer getMin_ent_antes() throws BaseException {
		supportRefresh();
		if (min_ent_antes != null)
			return min_ent_antes;
		else
			return 0;
	}

	public void setMin_ent_antes(Integer aMin_ent_antes) {
		this.min_ent_antes = aMin_ent_antes;
	}

	public Integer getMin_ent_despues() throws BaseException {
		supportRefresh();
		if (min_ent_despues != null)
			return min_ent_despues;
		else
			return 0;
	}

	public void setMin_ent_despues(Integer aMin_ent_despues) {
		this.min_ent_despues = aMin_ent_despues;
	}

	public String getTipo_egreso() throws BaseException {
		supportRefresh();
		if (tipo_egreso != null)
			return tipo_egreso;
		else
			return "";
	}

	public void setTipo_egreso(String aTipo_egreso) {
		this.tipo_egreso = aTipo_egreso;
	}

	public String getLey_no_egreso() throws BaseException {
		supportRefresh();
		if (ley_no_egreso != null)
			return ley_no_egreso;
		else
			return "";
	}

	public void setLey_no_egreso(String aLey_no_egreso) {
		this.ley_no_egreso = aLey_no_egreso;
	}

	public Boolean isAntipassback() throws BaseException {
		supportRefresh();
		if (antipassback != null)
			return antipassback;
		else
			return false;
	}

	public void setAntipassback(Boolean aAntipassback) {
		this.antipassback = aAntipassback;
	}

	public Boolean isCacheo() throws BaseException {
		supportRefresh();
		if (cacheo != null)
			return cacheo;
		else
			return false;
	}

	public void setCacheo(Boolean aCacheo) {
		this.cacheo = aCacheo;
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

	public static AccesoValClasif findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AccesoValClasif) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static AccesoValClasif findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AccesoValClasif) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static AccesoValClasif findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AccesoValClasif) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public static AccesoValClasif getAccesoValClasif(ValorClasificadorEntidad valor, ISesion aSesion) throws BaseException {
		if (valor==null)
			return null;
		return DBAccesoValClasif.getAccesoValClasif(valor, aSesion);
	}
	
	public boolean isPermitirIngreso() throws BaseException {
		if (this.getTipo_ingreso()==null) return false;
		if (this.getTipo_ingreso().equals(TipoPermisoCIP.TP_PERMITIDO))
			return true;
		else
			return false;
	}
	
	public boolean isDenegarIngreso() throws BaseException {
		if (this.getTipo_ingreso()==null) return false;
		if (this.getTipo_ingreso().equals(TipoPermisoCIP.TP_DENEGADO))
			return true;
		else
			return false;
	}
	
	
	public boolean isPermitirEgreso() throws BaseException {
		if (this.getTipo_egreso()==null) return false;
		if (this.getTipo_egreso().equals(TipoPermisoCIP.TP_PERMITIDO))
			return true;
		else
			return false;
	}	
	

}
