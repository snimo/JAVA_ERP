package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBFaseCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class FaseCompoOriginal extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public FaseCompoOriginal() { 
  }

  public static String NICKNAME = "cg.FaseCompoOriginal";

  private FaseSubReparto fase;
  private Componente componente;
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

 public static FaseCompoOriginal findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FaseCompoOriginal) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FaseCompoOriginal findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FaseCompoOriginal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(fase, "Debe Ingresar la Fase");
    Validar.noNulo(componente, "Debe Ingresar el Componente");
 }
 
 public static List getComponentesOrigen(FaseSubReparto fase,
         ISesion aSesion) throws BaseException {
	  return DBFaseCompoOriginal.getComponentesOrigen(fase,aSesion);
 }
 
 public static FaseCompoOriginal getFaseCompoOriginal(
		  FaseSubReparto faseSubReparto,
		  Componente componente,
         ISesion aSesion)
         throws BaseException {
	  return DBFaseCompoOriginal.getFaseCompoOriginal(faseSubReparto,componente,aSesion);
 }
  

}
