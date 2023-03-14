package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPlanifDiaCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class PlanifDiaCacheo extends ObjetoLogico {

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PlanifDiaCacheo() {
	}

	public static String NICKNAME = "cip.PlanifDiaCacheo";

	private GrupoPuerta lunes_entrada;
	private GrupoPuerta lunes_salida;
	private GrupoPuerta martes_entrada;
	private GrupoPuerta martes_salida;
	private GrupoPuerta miercoles_entrada;
	private GrupoPuerta miercoles_salida;
	private GrupoPuerta jueves_entrada;
	private GrupoPuerta jueves_salida;
	private GrupoPuerta viernes_entrada;
	private GrupoPuerta viermes_salida;
	private GrupoPuerta sabado_entrada;
	private GrupoPuerta sabado_salida;
	private GrupoPuerta domingo_entrada;
	private GrupoPuerta domingo_salida;

	public GrupoPuerta getLunes_entrada() throws BaseException {
		supportRefresh();
		return lunes_entrada;
	}

	public void setLunes_entrada(GrupoPuerta aLunes_entrada) {
		this.lunes_entrada = aLunes_entrada;
	}

	public GrupoPuerta getLunes_salida() throws BaseException {
		supportRefresh();
		return lunes_salida;
	}

	public void setLunes_salida(GrupoPuerta aLunes_salida) {
		this.lunes_salida = aLunes_salida;
	}

	public GrupoPuerta getMartes_entrada() throws BaseException {
		supportRefresh();
		return martes_entrada;
	}

	public void setMartes_entrada(GrupoPuerta aMartes_entrada) {
		this.martes_entrada = aMartes_entrada;
	}

	public GrupoPuerta getMartes_salida() throws BaseException {
		supportRefresh();
		return martes_salida;
	}

	public void setMartes_salida(GrupoPuerta aMartes_salida) {
		this.martes_salida = aMartes_salida;
	}

	public GrupoPuerta getMiercoles_entrada() throws BaseException {
		supportRefresh();
		return miercoles_entrada;
	}

	public void setMiercoles_entrada(GrupoPuerta aMiercoles_entrada) {
		this.miercoles_entrada = aMiercoles_entrada;
	}

	public GrupoPuerta getMiercoles_salida() throws BaseException {
		supportRefresh();
		return miercoles_salida;
	}

	public void setMiercoles_salida(GrupoPuerta aMiercoles_salida) {
		this.miercoles_salida = aMiercoles_salida;
	}

	public GrupoPuerta getJueves_entrada() throws BaseException {
		supportRefresh();
		return jueves_entrada;
	}

	public void setJueves_entrada(GrupoPuerta aJueves_entrada) {
		this.jueves_entrada = aJueves_entrada;
	}

	public GrupoPuerta getJueves_salida() throws BaseException {
		supportRefresh();
		return jueves_salida;
	}

	public void setJueves_salida(GrupoPuerta aJueves_salida) {
		this.jueves_salida = aJueves_salida;
	}

	public GrupoPuerta getViernes_entrada() throws BaseException {
		supportRefresh();
		return viernes_entrada;
	}

	public void setViernes_entrada(GrupoPuerta aViernes_entrada) {
		this.viernes_entrada = aViernes_entrada;
	}

	public GrupoPuerta getViermes_salida() throws BaseException {
		supportRefresh();
		return viermes_salida;
	}

	public void setViermes_salida(GrupoPuerta aViermes_salida) {
		this.viermes_salida = aViermes_salida;
	}

	public GrupoPuerta getSabado_entrada() throws BaseException {
		supportRefresh();
		return sabado_entrada;
	}

	public void setSabado_entrada(GrupoPuerta aSabado_entrada) {
		this.sabado_entrada = aSabado_entrada;
	}

	public GrupoPuerta getSabado_salida() throws BaseException {
		supportRefresh();
		return sabado_salida;
	}

	public void setSabado_salida(GrupoPuerta aSabado_salida) {
		this.sabado_salida = aSabado_salida;
	}

	public GrupoPuerta getDomingo_entrada() throws BaseException {
		supportRefresh();
		return domingo_entrada;
	}

	public void setDomingo_entrada(GrupoPuerta aDomingo_entrada) {
		this.domingo_entrada = aDomingo_entrada;
	}

	public GrupoPuerta getDomingo_salida() throws BaseException {
		supportRefresh();
		return domingo_salida;
	}

	public void setDomingo_salida(GrupoPuerta aDomingo_salida) {
		this.domingo_salida = aDomingo_salida;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PlanifDiaCacheo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PlanifDiaCacheo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PlanifDiaCacheo findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PlanifDiaCacheo) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static List getListaPlanifDiaCacheo(ISesion aSesion) throws BaseException {
		return DBPlanifDiaCacheo.getPlanifDiaCacheo(aSesion);
	}
	
	public static PlanifDiaCacheo getPlanifDiaCacheo(ISesion aSesion) throws BaseException {
		List lista = DBPlanifDiaCacheo.getPlanifDiaCacheo(aSesion);
		if (lista.size() == 0)
			return null;
		else
			return (PlanifDiaCacheo) lista.get(0);
	}
	
	public GrupoPuerta getGrupoPuerta(java.util.Date fecha, String entrada_o_salida) throws BaseException {
		if (Fecha.getDiaSemana(fecha)==1) {
			if (entrada_o_salida.equals("E"))
				return this.getDomingo_entrada();
			else
				return this.getDomingo_salida();
		}
		else
		if (Fecha.getDiaSemana(fecha)==2) {
			if (entrada_o_salida.equals("E"))
				return this.getLunes_entrada();
			else
				return this.getLunes_salida();
		}
		else
		if (Fecha.getDiaSemana(fecha)==3) {
			if (entrada_o_salida.equals("E"))
				return this.getMartes_entrada();
			else
				return this.getMartes_salida();
		}			
		else
		if (Fecha.getDiaSemana(fecha)==4) {
			if (entrada_o_salida.equals("E"))
				return this.getMiercoles_entrada();
			else
				return this.getMiercoles_salida();
		}		
		else
		if (Fecha.getDiaSemana(fecha)==5) {
			if (entrada_o_salida.equals("E"))
				return this.getJueves_entrada();
			else
				return this.getJueves_salida();
		}
		else
		if (Fecha.getDiaSemana(fecha)==6) {
			if (entrada_o_salida.equals("E"))
				return this.getViernes_entrada();
			else
				return this.getViermes_salida();
		}		
		else
		if (Fecha.getDiaSemana(fecha)==7) {
			if (entrada_o_salida.equals("E"))
				return this.getSabado_entrada();
			else
				return this.getSabado_salida();
		}		
		return null;	
	}
	
	

}
