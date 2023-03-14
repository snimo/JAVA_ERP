package com.srn.erp.reclutamiento.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluOperacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluOperacion extends ObjetoLogico {

	public RecluOperacion() {
	}

	public static String NICKNAME = "rs.RecluOperacion";

	private String codigo;
	private String descripcion;
	private Boolean activo;

	private List permisosOperacion = new ArrayList();
	private boolean readPermisosOperacion = true;

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

	public static RecluOperacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluOperacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluOperacion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluOperacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static RecluOperacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluOperacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public List getPermisosOperacion() throws BaseException {
		if (this.readPermisosOperacion) {
			List listaPermisos = RecluPermisosOper.getPermisosOperacion(this, getSesion());
			this.permisosOperacion.addAll(listaPermisos);
			this.readPermisosOperacion = false;
		}
		return this.permisosOperacion;
	}

	public void addPermisoOperacion(RecluPermisosOper aPermiso) throws BaseException {
		aPermiso.setOperacion(this);
		this.permisosOperacion.add(aPermiso);
	}

	public void afterSave() throws BaseException {
		Iterator iterPermisosOper = this.permisosOperacion.iterator();
		while (iterPermisosOper.hasNext()) {
			RecluPermisosOper permiso = (RecluPermisosOper) iterPermisosOper.next();
			permiso.save();
			permiso = null;
		}
		iterPermisosOper = null;
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		  return DBRecluOperacion.getAllActivos(aSesion);
	}
	
	public static List getOperacionesParaVisualizarDelUsuario(ISesion sesion) throws BaseException {
		
		HashTableDatos controlDuplicados = new HashTableDatos();
		
		List datos = new ArrayList();
		
		Iterator iterRecluOperacion = RecluOperacion.getAllActivos(sesion).iterator();
		while (iterRecluOperacion.hasNext()) {
			RecluOperacion recluOperacion = (RecluOperacion) iterRecluOperacion.next();
			Iterator iterPermisosOper = recluOperacion.getPermisosOperacion().iterator();
			while (iterPermisosOper.hasNext()) {
				RecluPermisosOper recluPermisosOper = (RecluPermisosOper) iterPermisosOper.next();
				if (recluPermisosOper.isPermisoTotal() || recluPermisosOper.isSoloVisualizar()) {

					PerfilFuncional perfil = recluPermisosOper.getPerfil_funcional();
					if (perfil.tieneAsignadoElUsuario(sesion.getLogin().getUsuario())) {
							if (controlDuplicados.get(recluOperacion.getOIDInteger())==null) {
								controlDuplicados.put(recluOperacion.getOIDInteger(), "");
								datos.add(recluOperacion);
							}
							
					}
				}
			}
		}
		
		return datos;
	}
	
	public static List getOperacionesParaAccesoTotalDelUsuario(ISesion sesion) throws BaseException {
		
		HashTableDatos controlDuplicados = new HashTableDatos();
		
		List datos = new ArrayList();
		
		Iterator iterRecluOperacion = RecluOperacion.getAllActivos(sesion).iterator();
		while (iterRecluOperacion.hasNext()) {
			RecluOperacion recluOperacion = (RecluOperacion) iterRecluOperacion.next();
			Iterator iterPermisosOper = recluOperacion.getPermisosOperacion().iterator();
			while (iterPermisosOper.hasNext()) {
				RecluPermisosOper recluPermisosOper = (RecluPermisosOper) iterPermisosOper.next();
				if (recluPermisosOper.isPermisoTotal()) {

					PerfilFuncional perfil = recluPermisosOper.getPerfil_funcional();
					if (perfil.tieneAsignadoElUsuario(sesion.getLogin().getUsuario())) {
							if (controlDuplicados.get(recluOperacion.getOIDInteger())==null) {
								controlDuplicados.put(recluOperacion.getOIDInteger(), "");
								datos.add(recluOperacion);
							}
							
					}
				}
			}
		}
		
		return datos;
	}	
	
	
	

}
