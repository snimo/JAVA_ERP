package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBRotaPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class RotaPayroll extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RotaPayroll() { 
  }

  public static String NICKNAME = "cip.RotaPayroll";

  private String tracodigo;
  private String tradescrip;
  private String trahoraini;
  private String trahorafin;
  private Boolean activo;

  public String getTracodigo() throws BaseException { 
    supportRefresh();
    return tracodigo;
  }

  public void setTracodigo(String aTracodigo) { 
    this.tracodigo =  aTracodigo;
  }

  public String getTradescrip() throws BaseException { 
    supportRefresh();
    return tradescrip;
  }

  public void setTradescrip(String aTradescrip) { 
    this.tradescrip =  aTradescrip;
  }

  public String getTrahoraini() throws BaseException { 
    supportRefresh();
    return trahoraini;
  }

  public void setTrahoraini(String aTrahoraini) { 
    this.trahoraini =  aTrahoraini;
  }

  public String getTrahorafin() throws BaseException { 
    supportRefresh();
    return trahorafin;
  }

  public void setTrahorafin(String aTrahorafin) { 
    this.trahorafin =  aTrahorafin;
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

 public static RotaPayroll findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RotaPayroll) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RotaPayroll findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RotaPayroll) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static void truncarTablaRotaPayroll(ISesion aSesion)
 throws BaseException {
 	 DBRotaPayroll.truncarTablaRotaPayroll(aSesion);
 }
 

}
