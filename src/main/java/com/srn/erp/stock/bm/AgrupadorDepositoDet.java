package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBAgrupadorDepositoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AgrupadorDepositoDet extends ObjetoLogico { 

  public AgrupadorDepositoDet() { 
  }

  public static String NICKNAME = "st.AgrupadorDepositoDet";

  private AgrupadorDeposito agrupador_deposito;
  private Deposito deposito;
  private Boolean activo;

  public AgrupadorDeposito getAgrupador_deposito() throws BaseException { 
    supportRefresh();
    return agrupador_deposito;
  }

  public void setAgrupador_deposito(AgrupadorDeposito aAgrupador_deposito) { 
    this.agrupador_deposito =  aAgrupador_deposito;
  }

  public Deposito getDeposito() throws BaseException { 
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) { 
    this.deposito =  aDeposito;
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

 public static AgrupadorDepositoDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AgrupadorDepositoDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AgrupadorDepositoDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AgrupadorDepositoDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(agrupador_deposito, "Debe ingresar el Agrupador");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getDetallesAgrupadorDeposito(AgrupadorDeposito aAgrupadorDeposito,
     ISesion aSesion) throws BaseException {
 	return DBAgrupadorDepositoDet.getDetallesAgrupadorDeposito(aAgrupadorDeposito,aSesion);
 }
 

}
