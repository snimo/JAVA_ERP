package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.rrhh.da.DBRangoPtajeObsCodif;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RangoPtajeObsCodif extends ObjetoLogico {
	
	private List obsCodifRango = new ArrayList();
	private boolean readObsCodifRango = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RangoPtajeObsCodif() {
	}

	public static String NICKNAME = "rh.RangoPtajeObsCodif";

	private CondModEvalCab cond_modelo;
	private Money puntaje_desde;
	private Money puntaje_hasta;
	private Boolean activo;

	public CondModEvalCab getCond_modelo() throws BaseException {
		supportRefresh();
		return cond_modelo;
	}

	public void setCond_modelo(CondModEvalCab aCond_modelo) {
		this.cond_modelo = aCond_modelo;
	}

	public Money getPuntaje_desde() throws BaseException {
		supportRefresh();
		return puntaje_desde;
	}

	public void setPuntaje_desde(Money aPuntaje_desde) {
		this.puntaje_desde = aPuntaje_desde;
	}

	public Money getPuntaje_hasta() throws BaseException {
		supportRefresh();
		return puntaje_hasta;
	}

	public void setPuntaje_hasta(Money aPuntaje_hasta) {
		this.puntaje_hasta = aPuntaje_hasta;
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

	public static RangoPtajeObsCodif findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RangoPtajeObsCodif) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RangoPtajeObsCodif findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RangoPtajeObsCodif) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	public static RangoPtajeObsCodif findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RangoPtajeObsCodif) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(cond_modelo, "Debe ingresar la Condición");
		Validar.noNulo(puntaje_desde, "Debe ingresar el Puntaje desde");
		Validar.noNulo(puntaje_hasta, "Debe ingresar el Puntaje hasta");
	}
	
	public static List getRangosPtajesObsCodig(
			  CondModEvalCab condModEvalCab,
	          ISesion aSesion) throws BaseException {
		  return DBRangoPtajeObsCodif.getRangosPtajesObsCodig(condModEvalCab,aSesion);
	}
	
	public List getObsCodif() throws BaseException {
		if (this.readObsCodifRango) {
		      List listaObsCodif = ObsCodifEvalRango.getObsCodif(this,getSesion());
		      obsCodifRango.addAll(listaObsCodif);
		      this.readObsCodifRango = false;
		}
		return obsCodifRango;
	}
	
	public void addObsCodif(ObsCodifEvalRango aObsCodifEvalRango) throws BaseException {
		aObsCodifEvalRango.setMod_obs_codif(this);
		obsCodifRango.add(aObsCodifEvalRango);
	}
	
	public void afterSave() throws BaseException {
		Iterator iterObsCodif = this.obsCodifRango.iterator();
		while (iterObsCodif.hasNext()) {
		      ObsCodifEvalRango obsCodif = (ObsCodifEvalRango) iterObsCodif.next();
		      obsCodif.save();
		      obsCodif = null;
		}
		iterObsCodif = null;
	}	
	

}
