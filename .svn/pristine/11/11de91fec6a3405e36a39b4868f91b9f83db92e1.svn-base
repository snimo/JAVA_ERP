package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import java.util.List;

import com.srn.erp.contabilidad.da.DBFaseValCompoDest;

public class FaseValCompoDest extends ObjetoLogico { 

  public FaseValCompoDest() { 
  }

  public static String NICKNAME = "cg.FaseValCompoDest";

  private FaseSubReparto fase;
  private IObjetoLogico valor_compo;
  private DriverSubreparto driver;
  private Boolean activo;

  public FaseSubReparto getFase() throws BaseException { 
    supportRefresh();
    return fase;
  }

  public void setFase(FaseSubReparto aFase) { 
    this.fase =  aFase;
  }

  public IObjetoLogico getValor_compo() throws BaseException { 
    supportRefresh();
    return valor_compo;
  }

  public void setValor_compo(IObjetoLogico aValor_compo) { 
    this.valor_compo =  aValor_compo;
  }

  public DriverSubreparto getDriver() throws BaseException { 
    supportRefresh();
    return driver;
  }

  public void setDriver(DriverSubreparto aDriver) { 
    this.driver =  aDriver;
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

 public static FaseValCompoDest findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FaseValCompoDest) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FaseValCompoDest findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FaseValCompoDest) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(fase, "Debe Ingresar la Fase");
    Validar.noNulo(valor_compo, "Debe Ingresar un Valor de componente");
    Validar.noNulo(driver, "Debe ingresar el Driver");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getValoresCompoDestino(FaseSubReparto fase,
         ISesion aSesion) throws BaseException {
	  return DBFaseValCompoDest.getValoresCompoDestino(fase,aSesion);
 }
 
 public static FaseValCompoDest getFaseValCompoDest(
		  FaseSubReparto fase,
		  IObjetoLogico valorCompo,
         ISesion aSesion)
         throws BaseException {
	  return DBFaseValCompoDest.getFaseValCompoDest(fase,valorCompo,aSesion);
 }
 
 
 

}
