package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBGrupoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoPuerta extends ObjetoLogico {

	public GrupoPuerta() {
	}

	private List grupoPuertasDet = new ArrayList();
	private boolean readGrupoPuertasDet = true;
	
	private List perfiles = new ArrayList();
	private boolean readPerfiles = true;	

	public static String NICKNAME = "cip.GrupoPuerta";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private Boolean esParaCacheo;
	private boolean habParaIngVis;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public boolean isHabParaIngVisita() throws BaseException {
		supportRefresh();
		return this.habParaIngVis;
	}
	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setHabParaIngVisita(boolean aHabParaIngVisita) {
		this.habParaIngVis = aHabParaIngVisita;
	}
	

	public Boolean isParaCacheo() throws BaseException {
		supportRefresh();
		if (this.esParaCacheo == null)
			return false;
		else
			return this.esParaCacheo;
	}

	public void setIsParaCacheo(Boolean aEsParaCacheo) {
		this.esParaCacheo = aEsParaCacheo;
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

	public static GrupoPuerta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoPuerta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoPuerta findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoPuerta) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoPuerta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoPuerta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar le descripción");
	}

	public List getGrupoPuertasDet() throws BaseException {
		if (this.readGrupoPuertasDet) {
			List listaGrupoPuertasDet = GrupoPuertaDet.getGrupoPuertasDet(this, getSesion());
			grupoPuertasDet.addAll(listaGrupoPuertasDet);
			this.readGrupoPuertasDet = false;
		}
		return grupoPuertasDet;
	}
	
	public List getPerfiles() throws BaseException {
		if (this.readPerfiles) {
			List listaPerfiles = PerfilGrupoPuerta.getPerfilGrupoPuerta(this, getSesion());
			this.perfiles.addAll(listaPerfiles);
			this.readPerfiles = false;
		}
		return perfiles;
	}	

	public void addGrupoPuertasDet(GrupoPuertaDet aGrupoPuertaDet) throws BaseException {
		aGrupoPuertaDet.setGrupo_puertas(this);
		this.grupoPuertasDet.add(aGrupoPuertaDet);
	}
	
	public void addPerfilGrupoPuerta(PerfilGrupoPuerta aPerfilGrupoPuerta) throws BaseException {
		aPerfilGrupoPuerta.setGrupo_puerta(this);
		this.perfiles.add(aPerfilGrupoPuerta);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterGrupoPuertasDet = grupoPuertasDet.iterator();
		while (iterGrupoPuertasDet.hasNext()) {
			GrupoPuertaDet grupoPuertasDet = (GrupoPuertaDet) iterGrupoPuertasDet.next();
			grupoPuertasDet.save();
			grupoPuertasDet = null;
		}
		iterGrupoPuertasDet = null;
		
		Iterator iterPerfiles = perfiles.iterator();
		while (iterPerfiles.hasNext()) {
			PerfilGrupoPuerta perfilGrupoPuerta = (PerfilGrupoPuerta) iterPerfiles.next();
			perfilGrupoPuerta.save();
			perfilGrupoPuerta = null;
		}
		iterPerfiles = null;		
		
	}

	public GrupoPuertaDet getGrupoPuertaDet(Puerta puerta) throws BaseException {
		return GrupoPuertaDet.getGrupoPuertaDet(this, puerta, this.getSesion());
	}

	public static List getGrupoPuertasCacheo(ISesion aSesion) throws BaseException {
		return DBGrupoPuerta.getGrupoPuertasCacheo(aSesion);
	}
	
	public static GrupoPuerta getGrupoPuertaEntAlgoCacheo(ISesion aSesion)
	throws BaseException {
		Integer oidGrupoPuerta = ValorParametro.findByCodigoParametro(
				"GRU_PUE_ENT_ALG_CACH", aSesion).getOidObjNeg();
		GrupoPuerta grupo = GrupoPuerta.findByOid(oidGrupoPuerta, aSesion);
		return grupo;
	}
	
	public static GrupoPuerta getGrupoPuertaSalAlgoCacheo(ISesion aSesion)
	throws BaseException {
		Integer oidGrupoPuerta = ValorParametro.findByCodigoParametro(
				"GRU_PUE_SAL_ALG_CACH", aSesion).getOidObjNeg();
		GrupoPuerta grupo = GrupoPuerta.findByOid(oidGrupoPuerta, aSesion);
		return grupo;
	}
	
	public static List getGrupoPuertasHabPermisosUsu(
			String accion,
			String habilitar,
			ISesion aSesion) throws BaseException {
		
		  return DBGrupoPuerta.getGrupoPuertasHabPermisosUsu(accion,habilitar,aSesion);
	}	
	
	
	

}
