package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBCategAccesoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategAccesoCIP extends ObjetoLogico {

	public CategAccesoCIP() {
	}

	public static String NICKNAME = "cip.CategAccesoCIP";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private SubGrupoCategAcceso subgrupo; 
	
	private List categAccesosPuertas        = new ArrayList();
	private boolean readCategAccesosPuertas = true;	
	
	private List perfilesHabilitadores        = new ArrayList();
	private boolean readPerfilesHabilitadores = true;	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public SubGrupoCategAcceso getSubGrupo() throws BaseException {
		supportRefresh();
		return this.subgrupo;
	}

	public void setSubGrupoCategAcceso(SubGrupoCategAcceso aSubGrupoCategAcceso) {
		this.subgrupo = aSubGrupoCategAcceso;
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

	public static CategAccesoCIP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (CategAccesoCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static CategAccesoCIP findByOidProxy(Integer oid, ISesion aSesion)
	throws BaseException {
		return (CategAccesoCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static CategAccesoCIP findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (CategAccesoCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar un Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(this.subgrupo, "Debe ingresar el SubGrupo");
	}
	
	public List getCategAccesosPuertas() throws BaseException {
		if (this.readCategAccesosPuertas) {
		      List listaCategAccesosPuertas = CategAccesoPuertaCIP.getCategAccesoPuertas(this,getSesion());
		      this.categAccesosPuertas.addAll(listaCategAccesosPuertas);
		      this.readCategAccesosPuertas = false;
		}
		return this.categAccesosPuertas;
	}
	
	public List getPerfilesHabilitadores() throws BaseException {
		if (this.readPerfilesHabilitadores) {
		      List listaPerfilesHabilitadores = HabilitadorCategAcc.getHabilitadoresCategAccesoInt(this,getSesion());
		      this.perfilesHabilitadores.addAll(listaPerfilesHabilitadores);
		      this.readPerfilesHabilitadores = false;
		}
		return this.perfilesHabilitadores;
	}
	

	public void addCategAccesoPuerta(CategAccesoPuertaCIP aCategAccesoPuertaCIP) throws BaseException {
		aCategAccesoPuertaCIP.setCategoria(this);
		categAccesosPuertas.add(aCategAccesoPuertaCIP);
	}
	
	public void addPerfilHabilitador(HabilitadorCategAcc aHabilitadorCategAcc) throws BaseException {
		aHabilitadorCategAcc.setCategoria_acceso(this);
		perfilesHabilitadores.add(aHabilitadorCategAcc);
	}
	

	public void afterSave() throws BaseException {
		
		 Iterator iterCategAccesosPuertasCIP = this.categAccesosPuertas.iterator();
		 while (iterCategAccesosPuertasCIP.hasNext()) {
		      CategAccesoPuertaCIP categAccesoPuertaCIP = (CategAccesoPuertaCIP) iterCategAccesosPuertasCIP.next();
		      categAccesoPuertaCIP.save();
		      categAccesoPuertaCIP = null;
		 }
		 iterCategAccesosPuertasCIP = null;
		 
		 Iterator iterPerfilesHabilitadores = this.perfilesHabilitadores.iterator();
		 while (iterPerfilesHabilitadores.hasNext()) {
		      HabilitadorCategAcc habilitadorCategAcc = (HabilitadorCategAcc) iterPerfilesHabilitadores.next();
		      habilitadorCategAcc.save();
		      habilitadorCategAcc = null;
		 }
		 iterPerfilesHabilitadores = null;
		 
	}
	
	public static List getAllActivos(
	            ISesion aSesion) throws BaseException {
	   return DBCategAccesoCIP.getAllActivos(aSesion);
	}
	
	public  boolean isTieneAccesoDeEntradaAPuerta(
			Puerta puerta)
			throws BaseException {
		
		if( CategAccesoPuertaCIP.getCategAccesoEntradaPuerta(this,puerta,this.getSesion())==null)
			return false;
		else
			return true;
	}
	
	public  boolean isTieneAccesoDeSalidaAPuerta(
			Puerta puerta)
			throws BaseException {
		
		if( CategAccesoPuertaCIP.getCategAccesoSalidaPuerta(this,puerta,this.getSesion())==null)
			return false;
		else
			return true;
	}
	
	
	public static List getCategAccPuedeOtorgar(
			  Usuario usuario,
	          ISesion aSesion) throws BaseException {
			  return DBCategAccesoCIP.getCategAccPuedeOtorgar(usuario,aSesion);
	}
	
	public static List getCategAccesosByLegajo(
			  Legajo legajo,
	          ISesion aSesion) throws BaseException {
			  return DBCategAccesoCIP.getCategAccesosByLegajo(legajo,aSesion);
	}
	
	
}
