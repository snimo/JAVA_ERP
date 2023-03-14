package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBGrupoImportacionExcPeli;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoImportacionExcPeli extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoImportacionExcPeli() {
	}

	public static String NICKNAME = "exc.GrupoImportacionExcPeli";

	private GrupoImportacionExcluido grupo_imp_esc;
	private PredioExcluido predio;
	private PeligrosidadExcluido peligrosidad;
	private Boolean activo;

	public GrupoImportacionExcluido getGrupo_imp_esc() throws BaseException {
		supportRefresh();
		return grupo_imp_esc;
	}

	public void setGrupo_imp_esc(GrupoImportacionExcluido aGrupo_imp_esc) {
		this.grupo_imp_esc = aGrupo_imp_esc;
	}

	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}

	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}

	public PeligrosidadExcluido getPeligrosidad() throws BaseException {
		supportRefresh();
		return peligrosidad;
	}

	public void setPeligrosidad(PeligrosidadExcluido aPeligrosidad) {
		this.peligrosidad = aPeligrosidad;
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

	public static GrupoImportacionExcPeli findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoImportacionExcPeli) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoImportacionExcPeli findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoImportacionExcPeli) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(grupo_imp_esc, "Debe ingresar el Grupo de Importación");
		Validar.noNulo(predio, "Debe ingresar el Predio");
		Validar.noNulo(peligrosidad, "Debe ingresar la Peligrosidad");
	}

	public static List getGrupoImportacionExcPeli(GrupoImportacionExcluido grupoImportacion, ISesion aSesion) throws BaseException {
		return DBGrupoImportacionExcPeli.getGrupoImportacionExcPeli(grupoImportacion, aSesion);
	}

}
