package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBUniOrgTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UniOrgTalonario extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public UniOrgTalonario() { 
  }

  public static String NICKNAME = "ge.UniOrgTalonario";

  private Talonario talonario;
  private UnidadOrganizativa unidad_organizativa;
  private Boolean activo;

  public Talonario getTalonario() throws BaseException { 
    supportRefresh();
    return talonario;
  }

  public void setTalonario(Talonario aTalonario) { 
    this.talonario =  aTalonario;
  }

  public UnidadOrganizativa getUnidad_organizativa() throws BaseException { 
    supportRefresh();
    return unidad_organizativa;
  }

  public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) { 
    this.unidad_organizativa =  aUnidad_organizativa;
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

 public static UniOrgTalonario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UniOrgTalonario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static UniOrgTalonario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UniOrgTalonario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(talonario, "Debe ingresar el Talonario");
    Validar.noNulo(unidad_organizativa, "Debe ingresar la Unidad Organizativa");
 }
 
 public static List getUnidadesOrgTalonario(Talonario talonario,
     ISesion aSesion) throws BaseException {
 	return DBUniOrgTalonario.getUnidadesOrgTalonario(talonario,aSesion);
 }
 

}
