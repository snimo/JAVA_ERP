package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBEmpresaPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class EmpresaPayroll extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public EmpresaPayroll() { 
  }

  public static String NICKNAME = "cip.EmpresaPayroll";

  private String empresa;
  private String nombre;
  private Boolean activo;

  public String getEmpresa() throws BaseException { 
    supportRefresh();
    return empresa;
  }

  public void setEmpresa(String aEmpresa) { 
    this.empresa =  aEmpresa;
  }

  public String getNombre() throws BaseException { 
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) { 
    this.nombre =  aNombre;
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

 public static EmpresaPayroll findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EmpresaPayroll) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EmpresaPayroll findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EmpresaPayroll) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static void truncarTablaEmpresaPayroll(ISesion aSesion)
 throws BaseException {
	 DBEmpresaPayroll.truncarTablaEmpresaPayroll(aSesion);
 }
 
 public static List getAll(ISesion aSesion) throws BaseException {
		return DBEmpresaPayroll.getAll(aSesion);
 }

}
