package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivosNovCIP extends ObjetoLogico {

	public MotivosNovCIP() {
	}

	public static String NICKNAME = "cip.MotivosNovCIP";

	private List equivalencias = new ArrayList();
	private boolean readEquivalencias = true;

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean habParaIngresos;
	private Boolean habParaEgresos;
	private String compoExtIngreso;
	private String compoExtEgreso;
	private Integer minEntAnt;
	private Integer minEntDes;
	private boolean anulaRotaDelDia;
	private String horaDesdeIng;
	private String horaHastaIng;
	private String horaDesdeEgr;
	private String horaHastaEgr;
	private Integer horaDesdeIngMin;
	private Integer horaHastaIngMin;
	private Integer horaDesdeEgrMin;
	private Integer horaHastaEgrMin;
	
	public void setHoraDesdeIngMin(Integer aHoraDesdeIngMin) throws BaseException {
		this.horaDesdeIngMin = aHoraDesdeIngMin;
	}
	
	public void setHoraHastaIngMin(Integer aHoraHastaIngMin) throws BaseException {
		this.horaHastaIngMin = aHoraHastaIngMin;
	}
	
	public void setHoraDesdeEgrMin(Integer aHoraDesdeEgrMin) throws BaseException {
		this.horaDesdeEgrMin = aHoraDesdeEgrMin;
	}
	
	public void setHoraHastaEgrMin(Integer aHoraHastaEgrMin) throws BaseException {
		this.horaHastaEgrMin = aHoraHastaEgrMin;
	}
	
	public Integer getHoraDesdeIngMin() throws BaseException {
		supportRefresh();
		if (horaDesdeIngMin!=null)
			return horaDesdeIngMin;
		else
			return new Integer(0);
	}
	
	public Integer getHoraDesdeEgrMin() throws BaseException {
		supportRefresh();
		if (horaDesdeEgrMin!=null)
			return horaDesdeEgrMin;
		else
			return new Integer(0);
	}
	
	
	public Integer getHoraHastaIngMin() throws BaseException {
		supportRefresh();
		if (horaHastaIngMin!=null)
			return horaHastaIngMin;
		else
			return new Integer(0);
	}
	
	public Integer getHoraHastaEgrMin() throws BaseException {
		supportRefresh();
		if (horaHastaEgrMin!=null)
			return horaHastaEgrMin;
		else
			return new Integer(0);
	}
	
	
	public String getCompoExtIngreso() throws BaseException {
		supportRefresh();
		if (compoExtIngreso!=null)
			return compoExtIngreso;
		else
			return "";
	}
	
	public String getHoraDesdeIng() throws BaseException {
		supportRefresh();
		if (this.horaDesdeIng!=null)
			return this.horaDesdeIng;
		else
			return "";
	}
	
	public String getHoraHastaIng() throws BaseException {
		supportRefresh();
		if (this.horaHastaIng!=null)
			return this.horaHastaIng;
		else
			return "";
	}
	
	public String getHoraDesdeEgr() throws BaseException {
		supportRefresh();
		if (this.horaDesdeEgr!=null)
			return this.horaDesdeEgr;
		else
			return "";
	}
	
	public String getHoraHastaEgr() throws BaseException {
		supportRefresh();
		if (this.horaHastaEgr!=null)
			return this.horaHastaEgr;
		else
			return "";
	}
	
	
	
	
	public boolean isAnulaRotaDelDia() throws BaseException {
		supportRefresh();
		return this.anulaRotaDelDia;
	}
	
	
	public Integer getMinEntAnt() throws BaseException {
		supportRefresh();
		if (this.minEntAnt!=null)
			return this.minEntAnt;
		else
			return 0;
	}
	
	public Integer getMinEntDes() throws BaseException {
		supportRefresh();
		if (this.minEntDes!=null)
			return this.minEntDes;
		else
			return 0;
	}

	public void setCompoExtIngreso(String aCompoExtIngreso) {
		this.compoExtIngreso = aCompoExtIngreso;
	}
	
	public void setHoraDesdeIng(String aHoraDesdeIng) {
		this.horaDesdeIng = aHoraDesdeIng;
	}
	
	public void setHoraDesdeEgr(String aHoraDesdeEgr) {
		this.horaDesdeEgr = aHoraDesdeEgr;
	}
	
	public void setHoraHastaIng(String aHoraHastaIng) {
		this.horaHastaIng = aHoraHastaIng;
	}
	
	public void setHoraHastaEgr(String aHoraHastaEgr) {
		this.horaHastaEgr = aHoraHastaEgr;
	}
	
	
	public void setAnulaRotaDelDia(boolean aAnulaRotaDelDia) {
		this.anulaRotaDelDia = aAnulaRotaDelDia;
	}
	
	
	public void setMinEntAnt(Integer aMinEntAnt) {
		this.minEntAnt = aMinEntAnt;
	}
	
	public void setMinEntDes(Integer aMinEntDes) {
		this.minEntDes = aMinEntDes;
	}
	
	
	
	public String getCompoExtEgreso() throws BaseException {
		supportRefresh();
		return compoExtEgreso;
	}

	public void setCompoExtEgreso(String aCompoExtEgreso) {
		this.compoExtEgreso = aCompoExtEgreso;
	}
	
	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public Boolean isHabilitadoParaIngresos() throws BaseException {
		supportRefresh();
		return this.habParaIngresos;
	}

	public void setHabParaIngresos(Boolean aHabParaIngresos) {
		this.habParaIngresos = aHabParaIngresos;
	}
	
	public Boolean isHabilitadoParaEgresos() throws BaseException {
		supportRefresh();
		return this.habParaEgresos;
	}

	public void setHabParaEgresos(Boolean aHabParaEgresos) {
		this.habParaEgresos = aHabParaEgresos;
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

	public static MotivosNovCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivosNovCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static MotivosNovCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (MotivosNovCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static MotivosNovCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (MotivosNovCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		
		try {
			this.horaDesdeIngMin = UtilCIP.getHoraEnMin(this.horaDesdeIng);
		} catch (Exception  e) {
			this.horaDesdeIngMin = 0;
		}
		
		try {
			this.horaHastaIngMin = UtilCIP.getHoraEnMin(this.horaHastaIng);
		} catch (Exception  e) {
			this.horaHastaIngMin = 0;
		}
		
		try {
			this.horaDesdeEgrMin = UtilCIP.getHoraEnMin(this.horaDesdeEgr);
		} catch (Exception  e) {
			this.horaDesdeEgrMin = 0;
		}
		
		try {
			this.horaHastaEgrMin = UtilCIP.getHoraEnMin(this.horaHastaEgr);
		} catch (Exception  e) {
			this.horaHastaEgrMin = 0;
		}
		
		
		
	}

	public List getEquivalencias() throws BaseException {
		if (this.readEquivalencias) {
			List listaEquivalencias = MotivosEquivCIP.getEquivMotivos(this, getSesion());
			equivalencias.addAll(listaEquivalencias);
			readEquivalencias = false;
		}
		return equivalencias;
	}

	public void addEquivalenciaMotivo(MotivosEquivCIP aMotivosEquivCIP) throws BaseException {
		aMotivosEquivCIP.setMotivo(this);
		equivalencias.add(aMotivosEquivCIP);
	}

	public void afterSave() throws BaseException {
		Iterator iterEquivMot = this.equivalencias.iterator();
		while (iterEquivMot.hasNext()) {
			MotivosEquivCIP motivoEquiv = (MotivosEquivCIP) iterEquivMot.next();
			motivoEquiv.save();
			motivoEquiv = null;
		}
		iterEquivMot = null;
	}

}
