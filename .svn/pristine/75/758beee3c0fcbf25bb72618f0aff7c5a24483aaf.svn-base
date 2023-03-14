package com.srn.erp.rrhh.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.rrhh.da.DBFiltroLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FiltroLegCab extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getDescripcion();
	}

	public FiltroLegCab() {
	}

	private List valoresFiltro = new ArrayList();
	private boolean readValoresFiltro = true;	
	
	private List perfiles = new ArrayList();
	private boolean readPerfiles = true;	
	
	public static String NICKNAME = "rh.FiltroLegCab";

	private String descripcion;
	private Boolean aplic_cons_rotas;
	private Boolean activo;
	private Boolean aplic_busq_leg;

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isAplic_cons_rotas() throws BaseException {
		supportRefresh();
		return aplic_cons_rotas;
	}
	
	public Boolean isAplic_busq_leg() throws BaseException {
		supportRefresh();
		return aplic_busq_leg;
	}	

	public void setAplic_cons_rotas(Boolean aAplic_cons_rotas) {
		this.aplic_cons_rotas = aAplic_cons_rotas;
	}
	
	public void setAplic_busq_leg(Boolean aAplic_busq_leg) {
		this.aplic_busq_leg = aAplic_busq_leg;
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

	public static FiltroLegCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (FiltroLegCab) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static FiltroLegCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (FiltroLegCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static FiltroLegCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (FiltroLegCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}
	
	public List getValoresActivosFiltro() throws BaseException {
		if (this.readValoresFiltro) {
		    List listaValoresFiltro = FiltroValLegCab.getFiltroValLegCab(this,getSesion());
		    this.valoresFiltro.addAll(listaValoresFiltro);
		    this.readValoresFiltro = false;
		}
		return valoresFiltro;
	}
	
	public List getPerfilesFiltro() throws BaseException {
		if (this.readPerfiles) {
		    List listaPerfiles = PerfilFiltroLegajo.getPerfilesFiltroLegajo(this,getSesion());
		    this.perfiles.addAll(listaPerfiles);
		    this.readPerfiles = false;
		}
		return perfiles;
	}	
	

	public void addValorFiltro(FiltroValLegCab aFiltroValLegCab) throws BaseException {
		aFiltroValLegCab.setFiltro_cab(this);
		valoresFiltro.add(aFiltroValLegCab);
	}
	
	public void addPerfil(PerfilFiltroLegajo aPerfilFiltroLegajo) throws BaseException {
		aPerfilFiltroLegajo.setFiltro_legajo_cab(this);
		perfiles.add(aPerfilFiltroLegajo);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterFiltroValores = this.valoresFiltro.iterator();
		while (iterFiltroValores.hasNext()) {
		      FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterFiltroValores.next();
		      filtroValLegCab.save();
		      filtroValLegCab = null;
		}
		iterFiltroValores = null;
		
		Iterator iterPerfiles = this.perfiles.iterator();
		while (iterPerfiles.hasNext()) {
		      PerfilFiltroLegajo perfilFiltro = (PerfilFiltroLegajo) iterPerfiles.next();
		      perfilFiltro.save();
		      perfilFiltro = null;
		}
		iterPerfiles = null;		
		
	}
	
	public static List getFiltrosLegajosCabConsRotasPlanif(ISesion aSesion) throws BaseException {
		  return DBFiltroLegCab.getFiltrosLegajosCabConsRotasPlanif(aSesion);
	}
	
	public List getValoresFiltroEmpresa() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"EMPRESA",this.getSesion());
	}
	
	public List getValoresFiltroPuesto() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"PUESTO",this.getSesion());
	}	
	
	public List getValoresFiltroSector() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"SECTOR",this.getSesion());
	}	
	
	public List getValoresFiltroEstado() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"ESTADO",this.getSesion());
	}	
	
	public List getValoresFiltroTareas() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"TAREA",this.getSesion());
	}	
	
	public List getValoresFiltroSindicatos() throws BaseException {
		return FiltroValLegCab.getFiltroValLegCab(this,"SINDICATO",this.getSesion());
	}
	
	public static List getFiltrosLegajosCabByUSuario(ISesion aSesion,Usuario usuario) throws BaseException {
		  return DBFiltroLegCab.getFiltrosLegajosCabByUSuario(aSesion,usuario);
	}	
	  	
	
	
	

}
