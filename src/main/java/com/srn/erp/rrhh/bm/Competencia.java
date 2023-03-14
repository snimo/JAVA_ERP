package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.rrhh.da.DBCompetencia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Competencia extends ObjetoLogico {

	public Competencia() {
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getTitulo();
	}

	public static String NICKNAME = "rh.Competencia";

	private String codigo;
	private String titulo;
	private String definicion;
	private Boolean activo;
	private String descAbrev;

	private List gradosCompetencias = new ArrayList();
	private boolean readGradosCompetencias = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public String getDescAbrev() throws BaseException {
		supportRefresh();
		if (this.descAbrev==null)
			return "";
		else
			return this.descAbrev;
	}
	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setDescAbrev(String aDescAbrev) {
		this.descAbrev = aDescAbrev;
	}
	

	public String getTitulo() throws BaseException {
		supportRefresh();
		return titulo;
	}

	public void setTitulo(String aTitulo) {
		this.titulo = aTitulo;
	}

	public String getDefinicion() throws BaseException {
		supportRefresh();
		return definicion;
	}

	public void setDefinicion(String aDefinicion) {
		this.definicion = aDefinicion;
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

	public static Competencia findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Competencia) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Competencia findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Competencia) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Competencia findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Competencia) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(titulo, "Debe ingresar el Título");
		Validar.noNulo(definicion, "Debe ingresar la Definición");
	}

	public List getGrados() throws BaseException {
		if (this.readGradosCompetencias) {
			List listaGrados = GradoCompetencia.getGradosCompetencias(this, getSesion());
			gradosCompetencias.addAll(listaGrados);
			this.readGradosCompetencias = false;
		}
		return gradosCompetencias;
	}

	public void addGradoCompetencia(GradoCompetencia aGradoCompetencia) throws BaseException {
		aGradoCompetencia.setCompetencia(this);
		gradosCompetencias.add(aGradoCompetencia);
	}

	public void afterSave() throws BaseException {
		Iterator iterGradosCompetencia = gradosCompetencias.iterator();
		while (iterGradosCompetencia.hasNext()) {
			GradoCompetencia gradoCompetencia = (GradoCompetencia) iterGradosCompetencia.next();
			gradoCompetencia.save();
			gradoCompetencia = null;
		}
		iterGradosCompetencia = null;
	}

	public static List getCompetencias(ModeloEvalCab aModeloEvalCab, ISesion aSesion) throws BaseException {
		return DBCompetencia.getCompetencias(aModeloEvalCab, aSesion);
	}

}
