package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotAccInterClasifLeg;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class MotAccInterClasifLeg extends ObjetoLogico {

	public MotAccInterClasifLeg() {
	}

	public static String NICKNAME = "cip.MotAccInterClasifLeg";

	private MotivoEntIntermedias motivo;
	private ValorClasificadorEntidad valorClasificador;
	private Boolean activo;

	public MotivoEntIntermedias getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotivoEntIntermedias aMotivo) {
		this.motivo = aMotivo;
	}

	public ValorClasificadorEntidad getValorclasificador() throws BaseException {
		supportRefresh();
		return valorClasificador;
	}

	public void setValorclasificador(ValorClasificadorEntidad aValorclasificador) {
		this.valorClasificador = aValorclasificador;
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

	public static MotAccInterClasifLeg findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (MotAccInterClasifLeg) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotAccInterClasifLeg findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (MotAccInterClasifLeg) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(motivo, "Debe ingresar el Motivo");
		Validar.noNulo(valorClasificador,
				"Debe ingresar el valor del clasificador");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBMotAccInterClasifLeg.getAllActivos(aSesion);
	}

	public static MotAccInterClasifLeg getMotAccInterClasifLeg(
			ValorClasificadorEntidad valor, MotivoEntIntermedias motivo,
			ISesion aSesion) throws BaseException {
		return DBMotAccInterClasifLeg.getMotAccInterClasifLeg(valor, motivo,
				aSesion);
	}

}
