package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBFirmaModeloEvaluacion;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FirmaModeloEvaluacion extends ObjetoLogico { 

  public FirmaModeloEvaluacion() { 
  }

  public static String NICKNAME = "rh.FirmaModeloEvaluacion";

  private CondModEvalCab condicion_modelo;
  private Integer nro_firma;
  private String titulo;
  private Legajo legajo_firma;
  private Boolean activo;

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public CondModEvalCab getCondicion_modelo() throws BaseException { 
    supportRefresh();
    return condicion_modelo;
  }

  public void setCondicion_modelo(CondModEvalCab aCondicion_modelo) { 
    this.condicion_modelo =  aCondicion_modelo;
  }

  public Integer getNro_firma() throws BaseException { 
    supportRefresh();
    return nro_firma;
  }

  public void setNro_firma(Integer aNro_firma) { 
    this.nro_firma =  aNro_firma;
  }

  public String getTitulo() throws BaseException { 
    supportRefresh();
    return titulo;
  }

  public void setTitulo(String aTitulo) { 
    this.titulo =  aTitulo;
  }

  public Legajo getLegajo_firma() throws BaseException { 
    supportRefresh();
    return legajo_firma;
  }

  public void setLegajo_firma(Legajo aLegajo_firma) { 
    this.legajo_firma =  aLegajo_firma;
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

 public static FirmaModeloEvaluacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FirmaModeloEvaluacion) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FirmaModeloEvaluacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FirmaModeloEvaluacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(condicion_modelo, "Debe ingresar la condición del Modelo");
    Validar.noNulo(nro_firma, "Debe ingresar el Nro. de Firma");
    Validar.noNulo(titulo, "Debe ingresar el Título");
 }
 
 public static List getFirmasModeloEval(CondModEvalCab condModEvalCab,
         ISesion aSesion) throws BaseException {
	  return DBFirmaModeloEvaluacion.getFirmasModeloEval(condModEvalCab,aSesion);
 }
 

}
