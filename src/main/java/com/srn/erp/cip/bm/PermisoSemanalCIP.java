package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PermisoSemanalCIP extends ObjetoLogico {

	public PermisoSemanalCIP() {
	}

	public static String NICKNAME = "cip.PermisoSemanalCIP";
	
	private List motivosAccessoIntermedios = new ArrayList();
	private boolean readMotivosAccesosIntermedios = true;

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private String ent_hora_lun;
	private Integer min_ent_ant_lun;
	private Integer min_ent_des_lun;
	private String tipo_per_ent_lun;
	private String sal_hora_lun;
	private Integer min_sal_ant_lun;
	private Integer min_sal_des_lun;
	private String tipo_per_sal_lun;
	private String ent_hora_mar;
	private Integer min_ent_ant_mar;
	private Integer min_ent_des_mar;
	private String tipo_per_ent_mar;
	private String sal_hora_mar;
	private Integer min_sal_ant_mar;
	private Integer min_sal_des_mar;
	private String tipo_per_sal_mar;
	private String ent_hora_mie;
	private Integer min_ent_ant_mie;
	private Integer min_ent_des_mie;
	private String tipo_per_ent_mie;
	private String sal_hora_mie;
	private Integer min_sal_ant_mie;
	private Integer min_sal_des_mie;
	private String tipo_per_sal_mie;
	private String ent_hora_juv;
	private Integer min_ent_ant_jue;
	private Integer min_ent_des_jue;
	private String tipo_per_ent_jue;
	private String sal_hora_jue;
	private Integer min_sal_ant_jue;
	private Integer min_sal_des_jue;
	private String tipo_per_sal_jue;
	private String ent_hora_vie;
	private Integer min_ent_ant_vie;
	private Integer min_ent_des_vie;
	private String tipo_per_ent_vie;
	private String sal_hora_vie;
	private Integer min_sal_ant_vie;
	private Integer min_sal_des_vie;
	private String tipo_per_sal_vie;
	private String ent_hora_sab;
	private Integer min_ent_ant_sab;
	private Integer min_ent_des_sab;
	private String tipo_per_ent_sab;
	private String sal_hora_sab;
	private Integer min_sal_ant_sab;
	private Integer min_sal_des_sab;
	private String tipo_per_sal_sab;
	private String ent_hor_dom;
	private Integer min_ent_ant_dom;
	private Integer min_ent_des_dom;
	private String tipo_per_ent_dom;
	private String sal_hor_dom;
	private Integer min_sal_ant_dom;
	private Integer min_sal_des_dom;
	private String tipo_per_sal_dom;
	private String lunLeyNoIngresa;
	private String marLeyNoIngresa;
	private String mieLeyNoIngresa;
	private String jueLeyNoIngresa;
	private String vieLeyNoIngresa;
	private String sabLeyNoIngresa;
	private String domLeyNoIngresa;
	private String lunLeyNoEgresa;
	private String marLeyNoEgresa;
	private String mieLeyNoEgresa;
	private String jueLeyNoEgresa;
	private String vieLeyNoEgresa;
	private String sabLeyNoEgresa;
	private String domLeyNoEgresa;
	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getLunLeyNoIngresa() throws BaseException {
		supportRefresh();
		return lunLeyNoIngresa;
	}

	public void setLunLeyNoIngresa(String lunLeyNoIngresa) {
		this.lunLeyNoIngresa = lunLeyNoIngresa;
	}

	public String getMarLeyNoIngresa() throws BaseException {
		supportRefresh();
		return marLeyNoIngresa;
	}

	public void setMarLeyNoIngresa(String marLeyNoIngresa) {
		this.marLeyNoIngresa = marLeyNoIngresa;
	}

	public String getMieLeyNoIngresa() throws BaseException {
		supportRefresh();
		return mieLeyNoIngresa;
	}

	public void setMieLeyNoIngresa(String mieLeyNoIngresa) {
		this.mieLeyNoIngresa = mieLeyNoIngresa;
	}

	public String getJueLeyNoIngresa() throws BaseException {
		supportRefresh();
		return jueLeyNoIngresa;
	}

	public void setJueLeyNoIngresa(String jueLeyNoIngresa) {
		this.jueLeyNoIngresa = jueLeyNoIngresa;
	}

	public String getVieLeyNoIngresa() throws BaseException {
		supportRefresh();
		return vieLeyNoIngresa;
	}

	public void setVieLeyNoIngresa(String vieLeyNoIngresa) {
		this.vieLeyNoIngresa = vieLeyNoIngresa;
	}

	public String getSabLeyNoIngresa() throws BaseException {
		supportRefresh();
		return sabLeyNoIngresa;
	}

	public void setSabLeyNoIngresa(String sabLeyNoIngresa) {
		this.sabLeyNoIngresa = sabLeyNoIngresa;
	}

	public String getDomLeyNoIngresa() throws BaseException {
		supportRefresh();
		return domLeyNoIngresa;
	}

	public void setDomLeyNoIngresa(String domLeyNoIngresa) {
		this.domLeyNoIngresa = domLeyNoIngresa;
	}

	public String getLunLeyNoEgresa() throws BaseException {
		supportRefresh();
		return lunLeyNoEgresa;
	}

	public void setLunLeyNoEgresa(String lunLeyNoEgresa) {
		this.lunLeyNoEgresa = lunLeyNoEgresa;
	}

	public String getMarLeyNoEgresa() throws BaseException {
		supportRefresh();
		return marLeyNoEgresa;
	}

	public void setMarLeyNoEgresa(String marLeyNoEgresa) {
		this.marLeyNoEgresa = marLeyNoEgresa;
	}

	public String getMieLeyNoEgresa() throws BaseException {
		supportRefresh();
		return mieLeyNoEgresa;
	}

	public void setMieLeyNoEgresa(String mieLeyNoEgresa) {
		this.mieLeyNoEgresa = mieLeyNoEgresa;
	}

	public String getJueLeyNoEgresa() throws BaseException {
		supportRefresh();
		return jueLeyNoEgresa;
	}

	public void setJueLeyNoEgresa(String jueLeyNoEgresa) {
		this.jueLeyNoEgresa = jueLeyNoEgresa;
	}

	public String getVieLeyNoEgresa() throws BaseException {
		supportRefresh();
		return vieLeyNoEgresa;
	}

	public void setVieLeyNoEgresa(String vieLeyNoEgresa) {
		this.vieLeyNoEgresa = vieLeyNoEgresa;
	}

	public String getSabLeyNoEgresa() throws BaseException {
		supportRefresh();
		return sabLeyNoEgresa;
	}

	public void setSabLeyNoEgresa(String sabLeyNoEgresa) {
		this.sabLeyNoEgresa = sabLeyNoEgresa;
	}

	public String getDomLeyNoEgresa() throws BaseException {
		supportRefresh();
		return domLeyNoEgresa;
	}

	public void setDomLeyNoEgresa(String domLeyNoEgresa) {
		this.domLeyNoEgresa = domLeyNoEgresa;
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

	public String getEnt_hora_lun() throws BaseException {
		supportRefresh();
		return ent_hora_lun;
	}

	public void setEnt_hora_lun(String aEnt_hora_lun) {
		this.ent_hora_lun = aEnt_hora_lun;
	}

	public Integer getMin_ent_ant_lun() throws BaseException {
		supportRefresh();
		return min_ent_ant_lun;
	}

	public void setMin_ent_ant_lun(Integer aMin_ent_ant_lun) {
		this.min_ent_ant_lun = aMin_ent_ant_lun;
	}

	public Integer getMin_ent_des_lun() throws BaseException {
		supportRefresh();
		return min_ent_des_lun;
	}

	public void setMin_ent_des_lun(Integer aMin_ent_des_lun) {
		this.min_ent_des_lun = aMin_ent_des_lun;
	}

	public String getTipo_per_ent_lun() throws BaseException {
		supportRefresh();
		return tipo_per_ent_lun;
	}

	public void setTipo_per_ent_lun(String aTipo_per_ent_lun) {
		this.tipo_per_ent_lun = aTipo_per_ent_lun;
	}

	public String getSal_hora_lun() throws BaseException {
		supportRefresh();
		return sal_hora_lun;
	}

	public void setSal_hora_lun(String aSal_hora_lun) {
		this.sal_hora_lun = aSal_hora_lun;
	}

	public Integer getMin_sal_ant_lun() throws BaseException {
		supportRefresh();
		return min_sal_ant_lun;
	}

	public void setMin_sal_ant_lun(Integer aMin_sal_ant_lun) {
		this.min_sal_ant_lun = aMin_sal_ant_lun;
	}

	public Integer getMin_sal_des_lun() throws BaseException {
		supportRefresh();
		return min_sal_des_lun;
	}

	public void setMin_sal_des_lun(Integer aMin_sal_des_lun) {
		this.min_sal_des_lun = aMin_sal_des_lun;
	}

	public String getTipo_per_sal_lun() throws BaseException {
		supportRefresh();
		return tipo_per_sal_lun;
	}

	public void setTipo_per_sal_lun(String aTipo_per_sal_lun) {
		this.tipo_per_sal_lun = aTipo_per_sal_lun;
	}

	public String getEnt_hora_mar() throws BaseException {
		supportRefresh();
		return ent_hora_mar;
	}

	public void setEnt_hora_mar(String aEnt_hora_mar) {
		this.ent_hora_mar = aEnt_hora_mar;
	}

	public Integer getMin_ent_ant_mar() throws BaseException {
		supportRefresh();
		return min_ent_ant_mar;
	}

	public void setMin_ent_ant_mar(Integer aMin_ent_ant_mar) {
		this.min_ent_ant_mar = aMin_ent_ant_mar;
	}

	public Integer getMin_ent_des_mar() throws BaseException {
		supportRefresh();
		return min_ent_des_mar;
	}

	public void setMin_ent_des_mar(Integer aMin_ent_des_mar) {
		this.min_ent_des_mar = aMin_ent_des_mar;
	}

	public String getTipo_per_ent_mar() throws BaseException {
		supportRefresh();
		return tipo_per_ent_mar;
	}

	public void setTipo_per_ent_mar(String aTipo_per_ent_mar) {
		this.tipo_per_ent_mar = aTipo_per_ent_mar;
	}

	public String getSal_hora_mar() throws BaseException {
		supportRefresh();
		return sal_hora_mar;
	}

	public void setSal_hora_mar(String aSal_hora_mar) {
		this.sal_hora_mar = aSal_hora_mar;
	}

	public Integer getMin_sal_ant_mar() throws BaseException {
		supportRefresh();
		return min_sal_ant_mar;
	}

	public void setMin_sal_ant_mar(Integer aMin_sal_ant_mar) {
		this.min_sal_ant_mar = aMin_sal_ant_mar;
	}

	public Integer getMin_sal_des_mar() throws BaseException {
		supportRefresh();
		return min_sal_des_mar;
	}

	public void setMin_sal_des_mar(Integer aMin_sal_des_mar) {
		this.min_sal_des_mar = aMin_sal_des_mar;
	}

	public String getTipo_per_sal_mar() throws BaseException {
		supportRefresh();
		return tipo_per_sal_mar;
	}

	public void setTipo_per_sal_mar(String aTipo_per_sal_mar) {
		this.tipo_per_sal_mar = aTipo_per_sal_mar;
	}

	public String getEnt_hora_mie() throws BaseException {
		supportRefresh();
		return ent_hora_mie;
	}

	public void setEnt_hora_mie(String aEnt_hora_mie) {
		this.ent_hora_mie = aEnt_hora_mie;
	}

	public Integer getMin_ent_ant_mie() throws BaseException {
		supportRefresh();
		return min_ent_ant_mie;
	}

	public void setMin_ent_ant_mie(Integer aMin_ent_ant_mie) {
		this.min_ent_ant_mie = aMin_ent_ant_mie;
	}

	public Integer getMin_ent_des_mie() throws BaseException {
		supportRefresh();
		return min_ent_des_mie;
	}

	public void setMin_ent_des_mie(Integer aMin_ent_des_mie) {
		this.min_ent_des_mie = aMin_ent_des_mie;
	}

	public String getTipo_per_ent_mie() throws BaseException {
		supportRefresh();
		return tipo_per_ent_mie;
	}

	public void setTipo_per_ent_mie(String aTipo_per_ent_mie) {
		this.tipo_per_ent_mie = aTipo_per_ent_mie;
	}

	public String getSal_hora_mie() throws BaseException {
		supportRefresh();
		return sal_hora_mie;
	}

	public void setSal_hora_mie(String aSal_hora_mie) {
		this.sal_hora_mie = aSal_hora_mie;
	}

	public Integer getMin_sal_ant_mie() throws BaseException {
		supportRefresh();
		return min_sal_ant_mie;
	}

	public void setMin_sal_ant_mie(Integer aMin_sal_ant_mie) {
		this.min_sal_ant_mie = aMin_sal_ant_mie;
	}

	public Integer getMin_sal_des_mie() throws BaseException {
		supportRefresh();
		return min_sal_des_mie;
	}

	public void setMin_sal_des_mie(Integer aMin_sal_des_mie) {
		this.min_sal_des_mie = aMin_sal_des_mie;
	}

	public String getTipo_per_sal_mie() throws BaseException {
		supportRefresh();
		return tipo_per_sal_mie;
	}

	public void setTipo_per_sal_mie(String aTipo_per_sal_mie) {
		this.tipo_per_sal_mie = aTipo_per_sal_mie;
	}

	public String getEnt_hora_juv() throws BaseException {
		supportRefresh();
		return ent_hora_juv;
	}

	public void setEnt_hora_juv(String aEnt_hora_juv) {
		this.ent_hora_juv = aEnt_hora_juv;
	}

	public Integer getMin_ent_ant_jue() throws BaseException {
		supportRefresh();
		return min_ent_ant_jue;
	}

	public void setMin_ent_ant_jue(Integer aMin_ent_ant_jue) {
		this.min_ent_ant_jue = aMin_ent_ant_jue;
	}

	public Integer getMin_ent_des_jue() throws BaseException {
		supportRefresh();
		return min_ent_des_jue;
	}

	public void setMin_ent_des_jue(Integer aMin_ent_des_jue) {
		this.min_ent_des_jue = aMin_ent_des_jue;
	}

	public String getTipo_per_ent_jue() throws BaseException {
		supportRefresh();
		return tipo_per_ent_jue;
	}

	public void setTipo_per_ent_jue(String aTipo_per_ent_jue) {
		this.tipo_per_ent_jue = aTipo_per_ent_jue;
	}

	public String getSal_hora_jue() throws BaseException {
		supportRefresh();
		return sal_hora_jue;
	}

	public void setSal_hora_jue(String aSal_hora_jue) {
		this.sal_hora_jue = aSal_hora_jue;
	}

	public Integer getMin_sal_ant_jue() throws BaseException {
		supportRefresh();
		return min_sal_ant_jue;
	}

	public void setMin_sal_ant_jue(Integer aMin_sal_ant_jue) {
		this.min_sal_ant_jue = aMin_sal_ant_jue;
	}

	public Integer getMin_sal_des_jue() throws BaseException {
		supportRefresh();
		return min_sal_des_jue;
	}

	public void setMin_sal_des_jue(Integer aMin_sal_des_jue) {
		this.min_sal_des_jue = aMin_sal_des_jue;
	}

	public String getTipo_per_sal_jue() throws BaseException {
		supportRefresh();
		return tipo_per_sal_jue;
	}

	public void setTipo_per_sal_jue(String aTipo_per_sal_jue) {
		this.tipo_per_sal_jue = aTipo_per_sal_jue;
	}

	public String getEnt_hora_vie() throws BaseException {
		supportRefresh();
		return ent_hora_vie;
	}

	public void setEnt_hora_vie(String aEnt_hora_vie) {
		this.ent_hora_vie = aEnt_hora_vie;
	}

	public Integer getMin_ent_ant_vie() throws BaseException {
		supportRefresh();
		return min_ent_ant_vie;
	}

	public void setMin_ent_ant_vie(Integer aMin_ent_ant_vie) {
		this.min_ent_ant_vie = aMin_ent_ant_vie;
	}

	public Integer getMin_ent_des_vie() throws BaseException {
		supportRefresh();
		return min_ent_des_vie;
	}

	public void setMin_ent_des_vie(Integer aMin_ent_des_vie) {
		this.min_ent_des_vie = aMin_ent_des_vie;
	}

	public String getTipo_per_ent_vie() throws BaseException {
		supportRefresh();
		return tipo_per_ent_vie;
	}

	public void setTipo_per_ent_vie(String aTipo_per_ent_vie) {
		this.tipo_per_ent_vie = aTipo_per_ent_vie;
	}

	public String getSal_hora_vie() throws BaseException {
		supportRefresh();
		return sal_hora_vie;
	}

	public void setSal_hora_vie(String aSal_hora_vie) {
		this.sal_hora_vie = aSal_hora_vie;
	}

	public Integer getMin_sal_ant_vie() throws BaseException {
		supportRefresh();
		return min_sal_ant_vie;
	}

	public void setMin_sal_ant_vie(Integer aMin_sal_ant_vie) {
		this.min_sal_ant_vie = aMin_sal_ant_vie;
	}

	public Integer getMin_sal_des_vie() throws BaseException {
		supportRefresh();
		return min_sal_des_vie;
	}

	public void setMin_sal_des_vie(Integer aMin_sal_des_vie) {
		this.min_sal_des_vie = aMin_sal_des_vie;
	}

	public String getTipo_per_sal_vie() throws BaseException {
		supportRefresh();
		return tipo_per_sal_vie;
	}

	public void setTipo_per_sal_vie(String aTipo_per_sal_vie) {
		this.tipo_per_sal_vie = aTipo_per_sal_vie;
	}

	public String getEnt_hora_sab() throws BaseException {
		supportRefresh();
		return ent_hora_sab;
	}

	public void setEnt_hora_sab(String aEnt_hora_sab) {
		this.ent_hora_sab = aEnt_hora_sab;
	}

	public Integer getMin_ent_ant_sab() throws BaseException {
		supportRefresh();
		return min_ent_ant_sab;
	}

	public void setMin_ent_ant_sab(Integer aMin_ent_ant_sab) {
		this.min_ent_ant_sab = aMin_ent_ant_sab;
	}

	public Integer getMin_ent_des_sab() throws BaseException {
		supportRefresh();
		return min_ent_des_sab;
	}

	public void setMin_ent_des_sab(Integer aMin_ent_des_sab) {
		this.min_ent_des_sab = aMin_ent_des_sab;
	}

	public String getTipo_per_ent_sab() throws BaseException {
		supportRefresh();
		return tipo_per_ent_sab;
	}

	public void setTipo_per_ent_sab(String aTipo_per_ent_sab) {
		this.tipo_per_ent_sab = aTipo_per_ent_sab;
	}

	public String getSal_hora_sab() throws BaseException {
		supportRefresh();
		return sal_hora_sab;
	}

	public void setSal_hora_sab(String aSal_hora_sab) {
		this.sal_hora_sab = aSal_hora_sab;
	}

	public Integer getMin_sal_ant_sab() throws BaseException {
		supportRefresh();
		return min_sal_ant_sab;
	}

	public void setMin_sal_ant_sab(Integer aMin_sal_ant_sab) {
		this.min_sal_ant_sab = aMin_sal_ant_sab;
	}

	public Integer getMin_sal_des_sab() throws BaseException {
		supportRefresh();
		return min_sal_des_sab;
	}

	public void setMin_sal_des_sab(Integer aMin_sal_des_sab) {
		this.min_sal_des_sab = aMin_sal_des_sab;
	}

	public String getTipo_per_sal_sab() throws BaseException {
		supportRefresh();
		return tipo_per_sal_sab;
	}

	public void setTipo_per_sal_sab(String aTipo_per_sal_sab) {
		this.tipo_per_sal_sab = aTipo_per_sal_sab;
	}

	public String getEnt_hor_dom() throws BaseException {
		supportRefresh();
		return ent_hor_dom;
	}

	public void setEnt_hor_dom(String aEnt_hor_dom) {
		this.ent_hor_dom = aEnt_hor_dom;
	}

	public Integer getMin_ent_ant_dom() throws BaseException {
		supportRefresh();
		return min_ent_ant_dom;
	}

	public void setMin_ent_ant_dom(Integer aMin_ent_ant_dom) {
		this.min_ent_ant_dom = aMin_ent_ant_dom;
	}

	public Integer getMin_ent_des_dom() throws BaseException {
		supportRefresh();
		return min_ent_des_dom;
	}

	public void setMin_ent_des_dom(Integer aMin_ent_des_dom) {
		this.min_ent_des_dom = aMin_ent_des_dom;
	}

	public String getTipoPermisoSemanalEnt(int dia) throws BaseException {
		if (dia == 1)
			return this.getTipo_per_ent_dom();
		else if (dia == 2)
			return this.getTipo_per_ent_lun();
		else if (dia == 3)
			return this.getTipo_per_ent_mar();		
		else if (dia == 4)
			return this.getTipo_per_ent_mie();		
		else if (dia == 5)
			return this.getTipo_per_ent_jue();		
		else if (dia == 6)
			return this.getTipo_per_ent_vie();		
		else if (dia == 7)
			return this.getTipo_per_ent_sab();		
		else return "";
	}
	
	public String getTipoPermisoSemanalSal(int dia) throws BaseException {
		if (dia == 1)
			return this.getTipo_per_sal_dom();
		else if (dia == 2)
			return this.getTipo_per_sal_lun();
		else if (dia == 3)
			return this.getTipo_per_sal_mar();		
		else if (dia == 4)
			return this.getTipo_per_sal_mie();		
		else if (dia == 5)
			return this.getTipo_per_sal_jue();		
		else if (dia == 6)
			return this.getTipo_per_sal_vie();		
		else if (dia == 7)
			return this.getTipo_per_sal_sab();		
		else return "";
	}	
	
	public String getLeyendaNoIngresa(int dia) throws BaseException {
		if (dia == 1)
			return this.getDomLeyNoIngresa();
		else if (dia == 2)
			return this.getLunLeyNoIngresa();
		else if (dia == 3)
			return this.getMarLeyNoIngresa();		
		else if (dia == 4)
			return this.getMieLeyNoIngresa();		
		else if (dia == 5)
			return this.getJueLeyNoIngresa();		
		else if (dia == 6)
			return this.getVieLeyNoIngresa();		
		else if (dia == 7)
			return this.getSabLeyNoIngresa();		
		else return "";
	}
	
	public String getLeyendaNoEgresa(int dia) throws BaseException {
		if (dia == 1)
			return this.getDomLeyNoEgresa();
		else if (dia == 2)
			return this.getLunLeyNoEgresa();
		else if (dia == 3)
			return this.getMarLeyNoEgresa();		
		else if (dia == 4)
			return this.getMieLeyNoEgresa();		
		else if (dia == 5)
			return this.getJueLeyNoEgresa();		
		else if (dia == 6)
			return this.getVieLeyNoEgresa();		
		else if (dia == 7)
			return this.getSabLeyNoEgresa();		
		else return "";
	}
	
	
	
	
	
	public String getTipo_per_ent_dom() throws BaseException {
		supportRefresh();
		return tipo_per_ent_dom;
	}

	public void setTipo_per_ent_dom(String aTipo_per_ent_dom) {
		this.tipo_per_ent_dom = aTipo_per_ent_dom;
	}

	public String getSal_hor_dom() throws BaseException {
		supportRefresh();
		return sal_hor_dom;
	}

	public void setSal_hor_dom(String aSal_hor_dom) {
		this.sal_hor_dom = aSal_hor_dom;
	}

	public Integer getMin_sal_ant_dom() throws BaseException {
		supportRefresh();
		return min_sal_ant_dom;
	}

	public void setMin_sal_ant_dom(Integer aMin_sal_ant_dom) {
		this.min_sal_ant_dom = aMin_sal_ant_dom;
	}

	public Integer getMin_sal_des_dom() throws BaseException {
		supportRefresh();
		return min_sal_des_dom;
	}

	public void setMin_sal_des_dom(Integer aMin_sal_des_dom) {
		this.min_sal_des_dom = aMin_sal_des_dom;
	}

	public String getTipo_per_sal_dom() throws BaseException {
		supportRefresh();
		return tipo_per_sal_dom;
	}

	public void setTipo_per_sal_dom(String aTipo_per_sal_dom) {
		this.tipo_per_sal_dom = aTipo_per_sal_dom;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PermisoSemanalCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoSemanalCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static PermisoSemanalCIP findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (PermisoSemanalCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static PermisoSemanalCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PermisoSemanalCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipo_per_ent_lun, "Ingrese el Tipo de Permiso Entrada para el Lunes");
		Validar.noNulo(tipo_per_sal_lun, "Ingrese el Tipo de Permiso Salidad para el Lunes");
		Validar.noNulo(tipo_per_ent_mar, "Ingrese el Tipo de Permiso Entrada para el Martes");
		Validar.noNulo(tipo_per_sal_mar, "Ingrese el Tipo de Permiso Salida para el Martes");
		Validar.noNulo(tipo_per_ent_mie, "Ingrese el Tipo de Permiso Entrada para Miércoles");
		Validar.noNulo(tipo_per_sal_mie, "Ingrese el Tipo de Permiso Salida para Miércoles");
		Validar.noNulo(tipo_per_ent_jue, "Ingrese el Tipo de Permiso Entrada para Jueves");
		Validar.noNulo(tipo_per_sal_jue, "Ingrese el Tipo de Permiso Salida para Jueves");
		Validar.noNulo(tipo_per_ent_vie, "Ingrese el Tipo de Permiso Entrada para Viernes");
		Validar.noNulo(tipo_per_sal_vie, "Ingrese el Tipo de Permiso Salida para Viernes");
		Validar.noNulo(tipo_per_ent_sab, "Ingrese el Tipo de Permiso Entrada para Sábado");
		Validar.noNulo(tipo_per_sal_sab, "Ingrese el Tipo de Permiso Salida para Sábado");
		Validar.noNulo(tipo_per_ent_dom, "Ingrese el Tipo de Permiso Entrada para Domingo");
		Validar.noNulo(tipo_per_sal_dom, "Ingrese el Tipo de Permiso Salida para Domingo");
	}
	
	
	public boolean isPuedeIngresar(int dia,int horEnMin) throws BaseException {
		if (dia==1)
			return isPuedeIngresarElDom(horEnMin);
		else if (dia==2)
			return isPuedeIngresarElLun(horEnMin);			
		else if (dia==3)
			return isPuedeIngresarElMar(horEnMin);		
		else if (dia==4)
			return isPuedeIngresarElMie(horEnMin);		
		else if (dia==5)
			return isPuedeIngresarElJue(horEnMin);		
		else if (dia==6)
			return isPuedeIngresarElVie(horEnMin);		
		else if (dia==7)
			return isPuedeIngresarElSab(horEnMin);
		else
			return false;
	}
	
	public boolean isPuedeIngresar(int dia, java.util.Date fechaDia, java.util.Date fecHoraActual , int minEntAntes, int minEntDespues) throws BaseException {
		if (dia==1)
			return isPuedeIngresarElDom(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==2)
			return isPuedeIngresarElLun(fechaDia,fecHoraActual,minEntAntes, minEntDespues);			
		else if (dia==3)
			return isPuedeIngresarElMar(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==4)
			return isPuedeIngresarElMie(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==5)
			return isPuedeIngresarElJue(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==6)
			return isPuedeIngresarElVie(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==7)
			return isPuedeIngresarElSab(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else
			return false;
	}
	
	public boolean isPuedeEgresar(int dia, java.util.Date fechaDia, java.util.Date fecHoraActual , int minEntAntes, int minEntDespues) throws BaseException {
		if (dia==1)
			return isPuedeEgresarElDom(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==2)
			return isPuedeEgresarElLun(fechaDia,fecHoraActual,minEntAntes, minEntDespues);			
		else if (dia==3)
			return isPuedeEgresarElMar(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==4)
			return isPuedeEgresarElMie(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==5)
			return isPuedeEgresarElJue(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==6)
			return isPuedeEgresarElVie(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else if (dia==7)
			return isPuedeEgresarElSab(fechaDia,fecHoraActual,minEntAntes, minEntDespues);
		else
			return false;
	}
	
	
	
	public boolean isPuedeEgresar(int dia,int horEnMin) throws BaseException {
		if (dia==1)
			return isPuedeEgresarElDom(horEnMin);
		else if (dia==2)
			return isPuedeEgresarElLun(horEnMin);			
		else if (dia==3)
			return isPuedeEgresarElMar(horEnMin);		
		else if (dia==4)
			return isPuedeEgresarElMie(horEnMin);		
		else if (dia==5)
			return isPuedeEgresarElJue(horEnMin);		
		else if (dia==6)
			return isPuedeEgresarElVie(horEnMin);		
		else if (dia==7)
			return isPuedeEgresarElSab(horEnMin);
		else
			return false;
	}
	
	
	public boolean isPuedeIngresarElDom(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hor_dom());
		int horaDesde = horaEnMin - this.getMin_ent_ant_dom(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_dom();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElLun(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_lun());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_lun());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_lun())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_lun()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_lun())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_lun());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;

	}
	
	public boolean isPuedeIngresarElMar(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_mar());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_mar());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_mar())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_mar()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_mar())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_mar());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;

	}
	
	public boolean isPuedeIngresarElMie(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_mie());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_mie());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_mie())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_mie()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_mie())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_mie());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;

	}

	public boolean isPuedeIngresarElJue(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_juv());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_juv());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_jue())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_jue()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_jue())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_jue());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElVie(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_vie());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_vie());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_vie())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_vie()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_vie())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_vie());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;
		
	}
	
	public boolean isPuedeIngresarElSab(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hora_sab());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hora_sab());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_sab())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_sab()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_sab())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_sab());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;
		

	}
	
	public boolean isPuedeIngresarElDom(java.util.Date fechaDia,java.util.Date fecHoraActual,int minEntAntes, int minEntDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getEnt_hor_dom());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getEnt_hor_dom());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniDia);
		if (minEntAntes>this.getMin_ent_ant_dom())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_ant_dom()*-1);
		java.util.Date fecHorIniDiaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniDia);
		if (minEntDespues>this.getMin_ent_des_dom())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_des_dom());
		java.util.Date fecHorIniDiaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaEntAnt)) && (!fecHoraActual.after((fecHorIniDiaEntDesp)))) 
			return true;
		else
			return false;
	}
	
	
	
	public boolean isPuedeIngresarElLun(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_lun());
		int horaDesde = horaEnMin - this.getMin_ent_ant_lun(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_lun();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElMar(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_mar());
		int horaDesde = horaEnMin - this.getMin_ent_ant_mar(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_mar();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElMie(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_mie());
		int horaDesde = horaEnMin - this.getMin_ent_ant_mie(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_mie();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElJue(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_juv());
		int horaDesde = horaEnMin - this.getMin_ent_ant_jue(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_jue();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElVie(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_vie());
		int horaDesde = horaEnMin - this.getMin_ent_ant_vie(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_vie();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeIngresarElSab(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getEnt_hora_sab());
		int horaDesde = horaEnMin - this.getMin_ent_ant_sab(); 
		int horaHasta = horaEnMin + this.getMin_ent_des_sab();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}	
	
	
	// Armar lo mismo para la salida
	
	public boolean isPuedeEgresarElDom(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hor_dom());
		int horaDesde = horaEnMin - this.getMin_sal_ant_dom(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_dom();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElLun(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_lun());
		int horaDesde = horaEnMin - this.getMin_sal_ant_lun(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_lun();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElMar(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_mar());
		int horaDesde = horaEnMin - this.getMin_sal_ant_mar(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_mar();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElMie(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_mie());
		int horaDesde = horaEnMin - this.getMin_sal_ant_mie(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_mie();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElJue(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_jue());
		int horaDesde = horaEnMin - this.getMin_sal_ant_jue(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_jue();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElVie(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_vie());
		int horaDesde = horaEnMin - this.getMin_sal_ant_vie(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_vie();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElSab(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getSal_hora_sab());
		int horaDesde = horaEnMin - this.getMin_sal_ant_sab(); 
		int horaHasta = horaEnMin + this.getMin_sal_des_sab();
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}	
	
	
	public List getMotivosAccesosInter() throws BaseException {
		    if (this.readMotivosAccesosIntermedios) {
		      List listaMotivosAccesosInter = MotEntInterPlanifS.getMotEntInterPlanifS(this, this.getSesion());
		      motivosAccessoIntermedios.addAll(listaMotivosAccesosInter);
		      this.readMotivosAccesosIntermedios = false;
		    }
		    return motivosAccessoIntermedios;
	}

	public void addMotivoAccesoInter(MotEntInterPlanifS aMotEntInterPlanifS) throws BaseException {
		aMotEntInterPlanifS.setPermiso_semanal(this);
		motivosAccessoIntermedios.add(aMotEntInterPlanifS);
	}

	public void afterSave() throws BaseException {
		    Iterator iterMotivosAcceInter = this.motivosAccessoIntermedios.iterator();
		    while (iterMotivosAcceInter.hasNext()) {
		      MotEntInterPlanifS motEntInterPlanifS = (MotEntInterPlanifS) iterMotivosAcceInter.next();
		      motEntInterPlanifS.save();
		      motEntInterPlanifS = null;
		    }
		    iterMotivosAcceInter = null;
	}
	
	public List getMotivosAccInter(String dia) throws BaseException {
		return MotEntInterPlanifS.getMotEntInterPlanifS(this, dia, this.getSesion());
	}
	

     // juana
	
	public boolean isPuedeEgresarElLun(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_lun());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_lun());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_lun())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_lun()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_lun())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_lun());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;

	}
	
	public boolean isPuedeEgresarElMar(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_mar());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_mar());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_mar())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_mar()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_mar())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_mar());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;

	}
	
	public boolean isPuedeEgresarElMie(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_mie());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_mie());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_mie())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_mie()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_mie())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_ent_des_mie());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;

	}

	public boolean isPuedeEgresarElJue(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_jue());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_jue());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_jue())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_jue()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_jue())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_jue());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarElVie(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_vie());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_vie());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_vie())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_vie()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_vie())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_vie());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;
		
	}
	
	public boolean isPuedeEgresarElSab(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hora_sab());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hora_sab());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_sab())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_sab()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_ent_des_sab())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_sab());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;
		

	}
	
	public boolean isPuedeEgresarElDom(java.util.Date fechaDia,java.util.Date fecHoraActual,int minSalAntes, int minSalDespues) throws BaseException {
		
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getSal_hor_dom());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getSal_hor_dom());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaDia); 
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniDia = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniDia);
		if (minSalAntes>this.getMin_sal_ant_dom())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_ant_dom()*-1);
		java.util.Date fecHorIniDiaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniDia);
		if (minSalDespues>this.getMin_sal_des_dom())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_des_dom());
		java.util.Date fecHorIniDiaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniDiaSalAnt)) && (!fecHoraActual.after((fecHorIniDiaSalDesp)))) 
			return true;
		else
			return false;
	}
	
	
}
