package com.srn.erp.legales.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.legales.da.DBRequeridoSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RequeridoSeclo extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RequeridoSeclo() {
	}

	public static String NICKNAME = "leg.RequeridoSeclo";

	private Seclo seclo;
	private ValorClasificadorEntidad valor_clasif_empresa;
	private Boolean activo;

	public Seclo getSeclo() throws BaseException {
		supportRefresh();
		return seclo;
	}

	public void setSeclo(Seclo aSeclo) {
		this.seclo = aSeclo;
	}

	public ValorClasificadorEntidad getValor_clasif_empresa() throws BaseException {
		supportRefresh();
		return valor_clasif_empresa;
	}

	public void setValor_clasif_empresa(ValorClasificadorEntidad aValor_clasif_empresa) {
		this.valor_clasif_empresa = aValor_clasif_empresa;
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

	public static RequeridoSeclo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RequeridoSeclo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RequeridoSeclo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RequeridoSeclo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(seclo, "Debe ingresar el Seclo");
		Validar.noNulo(valor_clasif_empresa, "Debe ingresar la Empresa");
	}

	public static List getRequeridos(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return DBRequeridoSeclo.getRequeridos(aSeclo, aSesion);
	}

}
