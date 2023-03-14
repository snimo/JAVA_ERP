package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBFaseValorCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FaseValorCompoOriginal extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public FaseValorCompoOriginal() { 
  }

  public static String NICKNAME = "cg.FaseValorCompoOriginal";

  private FaseSubReparto fase;
  private Componente componente;
  private IObjetoLogico valor_componente;
  private Boolean activo;

  public FaseSubReparto getFase() throws BaseException { 
    supportRefresh();
    return fase;
  }

  public void setFase(FaseSubReparto aFase) { 
    this.fase =  aFase;
  }

  public Componente getComponente() throws BaseException { 
    supportRefresh();
    return componente;
  }

  public void setComponente(Componente aComponente) { 
    this.componente =  aComponente;
  }

  public IObjetoLogico getValor_componente() throws BaseException { 
    supportRefresh();
    return valor_componente;
  }

  public void setValor_componente(IObjetoLogico aValor_componente) { 
    this.valor_componente =  aValor_componente;
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

 public static FaseValorCompoOriginal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FaseValorCompoOriginal) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FaseValorCompoOriginal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FaseValorCompoOriginal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(fase, "Debe Ingresar la Fase");
    Validar.noNulo(componente, "Debe Ingresar el Componente");
    Validar.noNulo(valor_componente, "Debe Ingresar el Valor de Componente");
 }
 
 public static List getValoresCompo(FaseSubReparto fase,
		  Componente componente,
         ISesion aSesion) throws BaseException {
	  return DBFaseValorCompoOriginal.getValoresCompo(fase,componente,aSesion);
 }
 
 public static FaseValorCompoOriginal getFaseValorCompoOri(
		  FaseSubReparto fase,
		  Componente componente,
		  IObjetoLogico valorCompo,
         ISesion aSesion)
         throws BaseException {
	  return DBFaseValorCompoOriginal.getFaseValorCompoOri(fase,componente,valorCompo,aSesion);
 }

 

}
