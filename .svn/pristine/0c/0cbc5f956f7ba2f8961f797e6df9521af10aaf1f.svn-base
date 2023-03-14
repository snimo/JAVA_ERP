package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excluidos.da.DBSeguridadEmpresaPredio;
import com.srn.erp.general.bm.Empresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SeguridadEmpresaPredio extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public SeguridadEmpresaPredio() { 
  }
  
  private List seguEmpesaPredioDet = new ArrayList();
  private boolean readSeguEmpesaPredioDet = true;  

  public static String NICKNAME = "exc.SeguridadEmpresaPredio";

  private PerfilFuncional perfil;
  private Empresa empresa;
  private Boolean activo;

  public PerfilFuncional getPerfil() throws BaseException { 
    supportRefresh();
    return perfil;
  }

  public void setPerfil(PerfilFuncional aPerfil) { 
    this.perfil =  aPerfil;
  }

  public Empresa getEmpresa() throws BaseException { 
    supportRefresh();
    return empresa;
  }

  public void setEmpresa(Empresa aEmpresa) { 
    this.empresa =  aEmpresa;
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

  public static SeguridadEmpresaPredio findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguridadEmpresaPredio) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
  public static SeguridadEmpresaPredio findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SeguridadEmpresaPredio) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 

 public static SeguridadEmpresaPredio findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguridadEmpresaPredio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(perfil, "Debe ingresar el Perfil");
    Validar.noNulo(empresa, "Debe ingresar la Empresa");
 }
 
 public static List getSeguridadEmpresaPredio(
		  PerfilFuncional perfil,
         ISesion aSesion) throws BaseException {
	  return DBSeguridadEmpresaPredio.getSeguridadEmpresaPredio(perfil,aSesion);
 }
 
 public List getSeguEmpresaPredioDet() throws BaseException {
	    if (this.readSeguEmpesaPredioDet) {
	      List listaSeguEmpresaPredioDet = SeguEmpresaPredioDet.getSeguEmpreasPredioDet(this,getSesion());
	      this.seguEmpesaPredioDet.addAll(listaSeguEmpresaPredioDet);
	      this.readSeguEmpesaPredioDet = false;
	    }
	    return this.seguEmpesaPredioDet;
 }

 public void addSeguEmpresaPredioDet(SeguEmpresaPredioDet aSeguEmpresaPredioDet) throws BaseException {
	 aSeguEmpresaPredioDet.setSegu_empresa_predio(this);
	 this.seguEmpesaPredioDet.add(aSeguEmpresaPredioDet);
 }

 public void afterSave() throws BaseException {
	    Iterator iterSeguEmpresaPredioDet = this.seguEmpesaPredioDet.iterator();
	    while (iterSeguEmpresaPredioDet.hasNext()) {
	      SeguEmpresaPredioDet seguEmpresaPredioDet = (SeguEmpresaPredioDet) iterSeguEmpresaPredioDet.next();
	      seguEmpresaPredioDet.save();
	      seguEmpresaPredioDet = null;
	    }
	    iterSeguEmpresaPredioDet = null;
 } 
  

}
