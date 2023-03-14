package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluTipoFormuProceso extends ObjetoLogico {

	public RecluTipoFormuProceso() {
	}

	private List procesos = new ArrayList();
	private boolean readProcesos = true;

	public static String NICKNAME = "rs.RecluTipoFormuProceso";

	private String codigo;
	private String descripcion;
	private Boolean activo;

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

	public static RecluTipoFormuProceso findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluTipoFormuProceso) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluTipoFormuProceso findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluTipoFormuProceso) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecluTipoFormuProceso findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluTipoFormuProceso) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public void addProceso(RecluProcTipoFormu aRecluProcTipoFormu) throws BaseException {
		aRecluProcTipoFormu.setTipo_formulario(this);
		this.procesos.add(aRecluProcTipoFormu);
	}

	public void afterSave() throws BaseException {
		Iterator iterProcesos = this.procesos.iterator();
		while (iterProcesos.hasNext()) {
			RecluProcTipoFormu recluProcTipoFormu = (RecluProcTipoFormu) iterProcesos.next();
			recluProcTipoFormu.save();
			recluProcTipoFormu = null;
		}
		iterProcesos = null;
	}
	
	  public List getProcesos() throws BaseException {
		    if (this.readProcesos) {
		      List listaProcesos = RecluProcTipoFormu.getProcesosTipoFormu(this,getSesion());
		      this.procesos.addAll(listaProcesos);
		      this.readProcesos = false;
		    }
		    return this.procesos;
		  }	

}
