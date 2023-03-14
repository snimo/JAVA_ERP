package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluPermisosOper;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RecluPermisosOper extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RecluPermisosOper() { 
  }

  public static String NICKNAME = "rs.RecluPermisosOper";

  private RecluOperacion operacion;
  private PerfilFuncional perfil_funcional;
  private String tipo_oper;
  private Boolean activo;

  public RecluOperacion getOperacion() throws BaseException { 
    supportRefresh();
    return operacion;
  }

  public void setOperacion(RecluOperacion aOperacion) { 
    this.operacion =  aOperacion;
  }

  public PerfilFuncional getPerfil_funcional() throws BaseException { 
    supportRefresh();
    return perfil_funcional;
  }

  public void setPerfil_funcional(PerfilFuncional aPerfil_funcional) { 
    this.perfil_funcional =  aPerfil_funcional;
  }

  public String getTipo_oper() throws BaseException { 
    supportRefresh();
    return tipo_oper;
  }

  public void setTipo_oper(String aTipo_oper) { 
    this.tipo_oper =  aTipo_oper;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static RecluPermisosOper findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluPermisosOper) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluPermisosOper findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluPermisosOper) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(operacion, "Debe ingresar la Operación");
    Validar.noNulo(perfil_funcional, "Debe ingresar el Perfil");
    Validar.noNulo(tipo_oper, "Debe ingresar el Tipo de Operación");
 }
 
 public static List getPermisosOperacion(RecluOperacion operacion,
         ISesion aSesion) throws BaseException {
	  return DBRecluPermisosOper.getPermisosOperacion(operacion,aSesion);
            
 }
 
 public static String getPermisoSinAcceso() {
	 return "SIN_ACCESO";
 }
 
 public static String getPermisoSoloVisualizar() {
	 return "VISUALIZAR";
 } 
 
 public static String getPermisoAccesoTotal() {
	 return "TOTAL";
 } 
 
 public static HashTableDatos getPermisos() throws BaseException {
	 HashTableDatos datos = new HashTableDatos();
	 datos.put(RecluPermisosOper.getPermisoSinAcceso(), "Sin Acceso");
	 datos.put(RecluPermisosOper.getPermisoSoloVisualizar(), "Visualizar");
	 datos.put(RecluPermisosOper.getPermisoAccesoTotal(), "Total");
	 return datos;
 }
 
 public boolean isSoloVisualizar() throws BaseException {
	 return this.getTipo_oper().equals(getPermisoSoloVisualizar());
 }
 
 public boolean isPermisoTotal() throws BaseException {
	 return this.getTipo_oper().equals(getPermisoAccesoTotal());
 } 
 
 public boolean isSinAcceso() throws BaseException {
	 return this.getTipo_oper().equals(getPermisoSinAcceso());
 } 

}
