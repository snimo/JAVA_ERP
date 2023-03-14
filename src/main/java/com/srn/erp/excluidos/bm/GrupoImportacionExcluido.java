package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excluidos.da.DBDispMovilExc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class GrupoImportacionExcluido extends ObjetoLogico {

	public GrupoImportacionExcluido() {
	}

	public static String NICKNAME = "exc.GrupoImportacionExcluido";

	private String codigo;
	private String descripcion;
	private String tipo_individuo;
	private Boolean activo;

	private List importacionPeligridad = new ArrayList();
	private boolean readImportacionPeligrisidad = true;
	
	private List importacionEstados = new ArrayList();
	private boolean readImportacionEstados = true;	
	
	private List importacionMaquinas = new ArrayList();
	private boolean readImportacionMaquinas = true;	
	
	private List importacionSoloEstados = new ArrayList();
	private boolean readImportacionSoloEstados = true;	

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

	public String getTipo_individuo() throws BaseException {
		supportRefresh();
		return tipo_individuo;
	}

	public void setTipo_individuo(String aTipo_individuo) {
		this.tipo_individuo = aTipo_individuo;
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

	public static GrupoImportacionExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoImportacionExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoImportacionExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoImportacionExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoImportacionExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoImportacionExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public List getGruposImpoPeli() throws BaseException {
		if (this.readImportacionPeligrisidad) {
			List listaGrupoImpPeli = GrupoImportacionExcPeli.getGrupoImportacionExcPeli(this, getSesion());
			this.importacionPeligridad.addAll(listaGrupoImpPeli);
			this.readImportacionPeligrisidad = false;
		}
		return this.importacionPeligridad;
	}
	
	public List getImportacionSoloEstados() throws BaseException {
		if (this.readImportacionSoloEstados) {
			List listaImpoSoloEstados = GrupoImportacionSoloEst.getGrupoImpSoloEst(this, getSesion());
			this.importacionSoloEstados.addAll(listaImpoSoloEstados);
			this.readImportacionSoloEstados = false;
		}
		return this.importacionSoloEstados;
	}	
	
	public List getGruposImpoMaquinas() throws BaseException {
		if (this.readImportacionMaquinas) {
			List listaGrupoImpMaq = GrupoImportacionExcMaq.getGrupoImpExcMaq(this, getSesion());
			this.importacionMaquinas.addAll(listaGrupoImpMaq);
			this.readImportacionMaquinas = false;
		}
		return this.importacionMaquinas;
	}	
	
	public List getGruposImpoEst() throws BaseException {
		if (this.readImportacionEstados) {
			List listaGrupoImpEst = GrupoImportacionExcEst.getGruposImpExcEstados(this, getSesion());
			this.importacionEstados.addAll(listaGrupoImpEst);
			this.readImportacionEstados = false;
		}
		return this.importacionEstados;
	}	

	public void addGrupoImpoPeli(GrupoImportacionExcPeli aGrupoImportacionExcPeli) throws BaseException {
		aGrupoImportacionExcPeli.setGrupo_imp_esc(this);
		this.importacionPeligridad.add(aGrupoImportacionExcPeli);
	}
	
	public void addImportacionSoloEstados(GrupoImportacionSoloEst aGrupoImpoSoloEst) throws BaseException {
		aGrupoImpoSoloEst.setGrupo_imp_exc(this);
		this.importacionSoloEstados.add(aGrupoImpoSoloEst);
	}	
	
	public void addGrupoImpoMaqui(GrupoImportacionExcMaq aGrupoImportacionExcMaq) throws BaseException {
		aGrupoImportacionExcMaq.setGrupo_imp_exc(this);
		this.importacionMaquinas.add(aGrupoImportacionExcMaq);
	}	
	
	public void addGrupoImpoEst(GrupoImportacionExcEst aGrupoImportacionExcEst) throws BaseException {
		aGrupoImportacionExcEst.setGrupo_imp_esc(this);
		this.importacionEstados.add(aGrupoImportacionExcEst);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterGrupoImpExcPeli = this.importacionPeligridad.iterator();
		while (iterGrupoImpExcPeli.hasNext()) {
			GrupoImportacionExcPeli grupoImportacionExcPeli = (GrupoImportacionExcPeli) iterGrupoImpExcPeli.next();
			grupoImportacionExcPeli.save();
			grupoImportacionExcPeli = null;
		}
		iterGrupoImpExcPeli = null;
		
		Iterator iterGrupoImpExcEst = this.importacionEstados.iterator();
		while (iterGrupoImpExcEst.hasNext()) {
			GrupoImportacionExcEst grupoImportacionExcEst = (GrupoImportacionExcEst) iterGrupoImpExcEst.next();
			grupoImportacionExcEst.save();
			grupoImportacionExcEst = null;
		}
		iterGrupoImpExcEst = null;		
		
		Iterator iterGrupoImpExcMaq = this.importacionMaquinas.iterator();
		while (iterGrupoImpExcMaq.hasNext()) {
			GrupoImportacionExcMaq grupoImportacionExcMaq = (GrupoImportacionExcMaq) iterGrupoImpExcMaq.next();
			grupoImportacionExcMaq.save();
			grupoImportacionExcMaq = null;
		}
		iterGrupoImpExcMaq = null;		
		
		Iterator iterGrupoSoloEst = this.importacionSoloEstados.iterator();
		while (iterGrupoSoloEst.hasNext()) {
			GrupoImportacionSoloEst grupoImportacionSoloEst = (GrupoImportacionSoloEst) iterGrupoSoloEst.next();
			grupoImportacionSoloEst.save();
			grupoImportacionSoloEst = null;
		}
		iterGrupoSoloEst = null;
		
		Iterator iterDispExc = 
			this.getDispMovExc().iterator();
		while (iterDispExc.hasNext()) {
			DispMovilExc dispMovilExc = (DispMovilExc) iterDispExc.next();
			dispMovilExc.setForzar_sinc_all(true);
			dispMovilExc.save();
			
		}
		
	}
	
	 public List getDispMovExc() throws BaseException {
		  return DispMovilExc.getDispMovExc(this,this.getSesion());
	 }
	
	

}
