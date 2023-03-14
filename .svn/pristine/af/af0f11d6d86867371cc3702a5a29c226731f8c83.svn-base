package com.srn.erp.payroll.bm;

import java.util.List;

import com.srn.erp.payroll.da.DBPayEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class PayEstado extends ObjetoLogico { 

  public PayEstado() { 
  }

  public static String NICKNAME = "admRRHH.payEstado";

  private String estado;

  public String getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(String aEstado) { 
    this.estado =  aEstado;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static PayEstado findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PayEstado) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PayEstado findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PayEstado) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 
 
 public static List<PayEstado> findAll(ISesion aSesion) throws BaseException { 
	   return (List<PayEstado>) DBPayEstado.findAll(aSesion);
 } 

 public void beforeSave() throws BaseException { 
 }

public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean isActivo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

}
