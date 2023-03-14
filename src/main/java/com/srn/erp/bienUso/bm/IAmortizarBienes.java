package com.srn.erp.bienUso.bm;

import java.util.List;

import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public interface IAmortizarBienes {	
  public void setSesion(ISesion aSesion);
  public void setPeriodo(Periodo aPeriodo);
  public void setFecImputac(java.util.Date aFecImputac);
  public void amortizar() throws BaseException ;
  public List getComprobantes() throws BaseException;
}
