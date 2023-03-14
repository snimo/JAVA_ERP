package com.srn.erp.excelReport.bm;

import java.util.List;

import com.srn.erp.excelReport.da.DBParamFuncionReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ParamFuncionReporteExcel extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ParamFuncionReporteExcel() { 
  }

  public static String NICKNAME = "ex.ParamFuncionReporteExcel";

  private FuncionReporteExcel funcion;
  private Integer orden;
  private String tipo_param;
  private String nombre_param;
  private String nombre_nickname;
  private ObjetoLogico valor_obj_neg;
  private Integer valor_entero;
  private Double valor_decimal;
  private String valor_string;
  private java.util.Date valor_fecha;
  private Boolean valor_boolean;
  private String celda;
  private Boolean activo;

  public FuncionReporteExcel getFuncion() throws BaseException { 
    supportRefresh();
    return funcion;
  }

  public void setFuncion(FuncionReporteExcel aFuncion) { 
    this.funcion =  aFuncion;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public String getTipo_param() throws BaseException { 
    supportRefresh();
    return tipo_param;
  }

  public void setTipo_param(String aTipo_param) { 
    this.tipo_param =  aTipo_param;
  }

  public String getNombre_param() throws BaseException { 
    supportRefresh();
    return nombre_param;
  }

  public void setNombre_param(String aNombre_param) { 
    this.nombre_param =  aNombre_param;
  }

  public String getNombre_nickname() throws BaseException { 
    supportRefresh();
    return nombre_nickname;
  }

  public void setNombre_nickname(String aNombre_nickname) { 
    this.nombre_nickname =  aNombre_nickname;
  }

  public ObjetoLogico getValor_obj_neg() throws BaseException { 
    supportRefresh();
    return valor_obj_neg;
  }

  public void setValor_obj_neg(ObjetoLogico aValor_obj_neg) { 
    this.valor_obj_neg =  aValor_obj_neg;
  }

  public Integer getValor_entero() throws BaseException { 
    supportRefresh();
    return valor_entero;
  }

  public void setValor_entero(Integer aValor_entero) { 
    this.valor_entero =  aValor_entero;
  }

  public Double getValor_decimal() throws BaseException { 
    supportRefresh();
    return valor_decimal;
  }

  public void setValor_decimal(Double aValor_decimal) { 
    this.valor_decimal =  aValor_decimal;
  }

  public String getValor_string() throws BaseException { 
    supportRefresh();
    return valor_string;
  }

  public void setValor_string(String aValor_string) { 
    this.valor_string =  aValor_string;
  }

  public java.util.Date getValor_fecha() throws BaseException { 
    supportRefresh();
    return valor_fecha;
  }

  public void setValor_fecha(java.util.Date aValor_fecha) { 
    this.valor_fecha =  aValor_fecha;
  }

  public Boolean isValor_boolean() throws BaseException { 
    supportRefresh();
    return valor_boolean;
  }

  public void setValor_boolean(Boolean aValor_boolean) { 
    this.valor_boolean =  aValor_boolean;
  }

  public String getCelda() throws BaseException { 
    supportRefresh();
    return celda;
  }

  public void setCelda(String aCelda) { 
    this.celda =  aCelda;
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

 public static ParamFuncionReporteExcel findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ParamFuncionReporteExcel) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ParamFuncionReporteExcel findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ParamFuncionReporteExcel) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(funcion, "Debe ingresar la función");
    Validar.noNulo(orden, "Debe ingresar el Orden");
    Validar.noNulo(tipo_param, "Debe ingresar el Tipo de Parámetro");
    Validar.noNulo(nombre_param, "Debe ingresar el Nombre del Parámetro");
 }
 
 public static List getParametrosByFuncion(FuncionReporteExcel funcionReporte,
         ISesion aSesion) throws BaseException {
	  return DBParamFuncionReporteExcel.getParametrosByFuncion(funcionReporte,aSesion);
 }
 

}
