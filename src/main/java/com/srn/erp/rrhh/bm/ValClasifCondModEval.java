package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBValClasifCondModEval;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValClasifCondModEval extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ValClasifCondModEval() { 
  }

  public static String NICKNAME = "rh.ValClasifCondModEval";

  private ClasificadorEntidad clasificador;
  private ValorClasificadorEntidad valor_clasificador;
  private CondModEvalCab condicion_modelo;
  private Boolean activo;

  public ClasificadorEntidad getClasificador() throws BaseException { 
    supportRefresh();
    return clasificador;
  }

  public void setClasificador(ClasificadorEntidad aClasificador) { 
    this.clasificador =  aClasificador;
  }

  public ValorClasificadorEntidad getValor_clasificador() throws BaseException { 
    supportRefresh();
    return valor_clasificador;
  }

  public void setValor_clasificador(ValorClasificadorEntidad aValor_clasificador) { 
    this.valor_clasificador =  aValor_clasificador;
  }

  public CondModEvalCab getCondicion_modelo() throws BaseException { 
    supportRefresh();
    return condicion_modelo;
  }

  public void setCondicion_modelo(CondModEvalCab aCondicion_modelo) { 
    this.condicion_modelo =  aCondicion_modelo;
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

 public static ValClasifCondModEval findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValClasifCondModEval) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ValClasifCondModEval findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValClasifCondModEval) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(clasificador, "Debe ingresar el clasificador");
    Validar.noNulo(valor_clasificador, "Debe ingresar el Valor del Clasificador");
    Validar.noNulo(condicion_modelo, "Debe ingresar la condición del Modelo");
 }
 
 public static ValClasifCondModEval getValorClasificador(
		  CondModEvalCab CondModEvalCab,
		  ClasificadorEntidad clasificador,
		  ValorClasificadorEntidad valorClasifEnt,
         ISesion aSesion)
         throws BaseException {
	  if (valorClasifEnt == null) return null;
	  return DBValClasifCondModEval.getValorClasificador(CondModEvalCab,clasificador,valorClasifEnt,aSesion);
 }
 
 public static List getValoresClasifByCondicion(CondModEvalCab condModEvalCab,
         ISesion aSesion) throws BaseException {
	  return DBValClasifCondModEval.getValoresClasifByCondicion(condModEvalCab,aSesion);
 }
 
 public static int getCantValoresClasif(Object aCondiciones, ISesion aSesion) throws BaseException {
	 return DBValClasifCondModEval.getCantValoresClasif(aCondiciones, aSesion);
 }
 

}
