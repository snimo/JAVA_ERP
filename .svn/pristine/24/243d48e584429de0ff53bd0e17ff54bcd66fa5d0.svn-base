package com.srn.erp.turnos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.turnos.da.DBDeudaPorConcTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DeudaPorConcTurno extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DeudaPorConcTurno() {
	}

	public static String NICKNAME = "tu.DeudaPorConcTurno";

	private List conceptos = new ArrayList();
	private boolean readConceptos = true;

	private String descripcion;
	private String comportamiento;
	private Integer max_dias_atraso;
	private Integer cantMaxPeriDeuda;
	private Double max_deuda;
	private Boolean activo;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public Integer getMax_dias_atraso() throws BaseException {
		supportRefresh();
		return max_dias_atraso;
	}

	public void setMax_dias_atraso(Integer aMax_dias_atraso) {
		this.max_dias_atraso = aMax_dias_atraso;
	}
	
	public Integer getCantMaxPeriDeuda() throws BaseException {
		supportRefresh();
		return this.cantMaxPeriDeuda;
	}

	public void setCantMaxPeriDeuda(Integer aCantMaxPeriDeuda) {
		this.cantMaxPeriDeuda = aCantMaxPeriDeuda;
	}
	
	
	public Double getMax_deuda() throws BaseException {
		supportRefresh();
		return max_deuda;
	}

	public void setMax_deuda(Double aMax_deuda) {
		this.max_deuda = aMax_deuda;
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

	public static DeudaPorConcTurno findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (DeudaPorConcTurno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DeudaPorConcTurno findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (DeudaPorConcTurno) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static DeudaPorConcTurno findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (DeudaPorConcTurno) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el comportamiento");
		Validar.noNulo(max_dias_atraso, "Debe ingresar los Días de Atraso");
		Validar.noNulo(max_deuda, "Debe ingresar la Máxima deuda permitida");
	}

	public List getConceptos() throws BaseException {
		if (readConceptos) {
			List listaConceptos = GrupoConceptoTurno.getConceptos(this,
					getSesion());
			conceptos.addAll(listaConceptos);
			readConceptos = false;
		}
		return conceptos;
	}

	public void addGrupoConceptoTurno(GrupoConceptoTurno aGrupoConceptoTurno)
			throws BaseException {
		aGrupoConceptoTurno.setDeuda_por_concepto(this);
		conceptos.add(aGrupoConceptoTurno);
	}

	public void afterSave() throws BaseException {
		Iterator iterConceptos = conceptos.iterator();
		while (iterConceptos.hasNext()) {
			GrupoConceptoTurno grupoConcTurno = (GrupoConceptoTurno) iterConceptos
					.next();
			grupoConcTurno.save();
			grupoConcTurno = null;
		}
		iterConceptos = null;
	}
	
	  public static List getDeudasPorConc(String comportamiento,
	          ISesion aSesion) throws BaseException {
		  return DBDeudaPorConcTurno.getDeudasPorConc(comportamiento,aSesion);
	  }
	

}
