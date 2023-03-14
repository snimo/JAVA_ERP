package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBRelacionExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class RelacionExcluido extends ObjetoLogico {

	public RelacionExcluido() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "exc.RelacionExcluido";

	private IndividuoExcluido individuo;
	private IndividuoExcluido individuo_rel;
	private Integer secu;
	private String comentario;
	private Boolean activo;
	private PredioExcluido predio;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}
	
	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}
	

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}
	
	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}
	

	public IndividuoExcluido getIndividuo_rel() throws BaseException {
		supportRefresh();
		return individuo_rel;
	}

	public void setIndividuo_rel(IndividuoExcluido aIndividuo_rel) {
		this.individuo_rel = aIndividuo_rel;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		String result = "";
		if (comentario == null)
			return "";
		else {
			result = comentario.replaceAll("\n", "¬c¬n");
			result = result.replaceAll("\r", "");
			return result;
		}
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
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

	public static RelacionExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RelacionExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RelacionExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RelacionExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, "Debe ingresar el Individuo");
		Validar.noNulo(predio, "Debe ingresar el Predio de la Persona relacionada");
	}

	public static List getRelacionesExcluidos(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return DBRelacionExcluido.getRelacionesExcluidos(aIndividuo, aSesion);
	}

	public static RelacionExcluido getRelacionExcluido(IndividuoExcluido individuo, IndividuoExcluido indiRela, ISesion aSesion)
			throws BaseException {
		return DBRelacionExcluido.getRelacionExcluido(individuo, indiRela, aSesion);
	}

	public static RelacionExcluido getRelacionExcluido(IndividuoExcluido individuo, Integer secu, ISesion aSesion) throws BaseException {
		return DBRelacionExcluido.getRelacionExcluido(individuo, secu, aSesion);
	}

	public static List getRelacionesIndividuales(IndividuoExcluido aIndividuo, ISesion aSesion) throws BaseException {
		return DBRelacionExcluido.getRelacionesIndividuales(aIndividuo, aSesion);
	}

}
