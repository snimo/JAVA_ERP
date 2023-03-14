package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBGradoCompetencia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GradoCompetencia extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GradoCompetencia() {
	}

	public static String NICKNAME = "rh.GradoCompetencia";

	private Competencia competencia;
	private Integer nro_grado;
	private String desc_grados;
	private Double peso_tentativo;
	private Boolean activo;

	public Competencia getCompetencia() throws BaseException {
		supportRefresh();
		return competencia;
	}

	public void setCompetencia(Competencia aCompetencia) {
		this.competencia = aCompetencia;
	}

	public Integer getNro_grado() throws BaseException {
		supportRefresh();
		return nro_grado;
	}

	public void setNro_grado(Integer aNro_grado) {
		this.nro_grado = aNro_grado;
	}

	public String getDesc_grados() throws BaseException {
		supportRefresh();
		return desc_grados;
	}

	public void setDesc_grados(String aDesc_grados) {
		this.desc_grados = aDesc_grados;
	}

	public Double getPeso_tentativo() throws BaseException {
		supportRefresh();
		return peso_tentativo;
	}

	public void setPeso_tentativo(Double aPeso_tentativo) {
		this.peso_tentativo = aPeso_tentativo;
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

	public static GradoCompetencia findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GradoCompetencia) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GradoCompetencia findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GradoCompetencia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(competencia, "Debe ingresar la Competencia");
		Validar.noNulo(nro_grado, "Debe ingresar el Nro. de Grado");
		Validar.noNulo(desc_grados, "Debe ingresar la Definición");
	}
	
	public static List getGradosCompetencias(Competencia competencia,
	          ISesion aSesion) throws BaseException {
		  return DBGradoCompetencia.getGradosCompetencias(competencia,aSesion);
	}

}
