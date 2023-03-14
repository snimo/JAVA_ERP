package com.srn.erp.excelReport.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excelReport.da.DBFuncionReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FuncionReporteExcel extends ObjetoLogico {
	
	private List parametros = new ArrayList();
	private boolean readParametros = true;	

    public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public FuncionReporteExcel() { 
  }

  public static String NICKNAME = "ex.FuncionReporteExcel";

  private ExcelReport reporte;
  private Integer orden;
  private String token_funcion;
  private String comentario;
  private String celda_destino;
  private Boolean activo;
  private String funcion;

  public ExcelReport getReporte() throws BaseException { 
    supportRefresh();
    return reporte;
  }

  public void setReporte(ExcelReport aReporte) { 
    this.reporte =  aReporte;
  }
  
  public String getFuncion() throws BaseException { 
	supportRefresh();
	return funcion;
  }

  public void setFuncion(String aFuncion) { 
	this.funcion =  aFuncion;
  }
  
  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public String getToken_funcion() throws BaseException { 
    supportRefresh();
    return token_funcion;
  }

  public void setToken_funcion(String aToken_funcion) { 
    this.token_funcion =  aToken_funcion;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
  }

  public String getCelda_destino() throws BaseException { 
    supportRefresh();
    return celda_destino;
  }

  public void setCelda_destino(String aCelda_destino) { 
    this.celda_destino =  aCelda_destino;
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

 public static FuncionReporteExcel findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FuncionReporteExcel) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FuncionReporteExcel findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (FuncionReporteExcel) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }  

 public static FuncionReporteExcel findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FuncionReporteExcel) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(reporte, "Debe ingresar el Reporte");
    Validar.noNulo(orden, "Debe ingresar el Orden");
    Validar.noNulo(token_funcion, "Debe ingresar la Función");
    Validar.noNulo(celda_destino, "Debe ingresar la Celda Destino");
 }
 
 public static List getFuncionesReporte(ExcelReport reporte,
         ISesion aSesion) throws BaseException {
	  return DBFuncionReporteExcel.getFuncionesReporte(reporte,aSesion);
 }
 
 public List getParametros() throws BaseException {
		if (this.readParametros) {
		    List listaParametros = ParamFuncionReporteExcel.getParametrosByFuncion(this,getSesion());
		    parametros.addAll(listaParametros);
		    this.readParametros = false;
		}
		return this.parametros;
 }

 public void addParametro(ParamFuncionReporteExcel aParamFuncionReporteExcel) throws BaseException {
	 aParamFuncionReporteExcel.setFuncion(this);
	 parametros.add(aParamFuncionReporteExcel);
 }

 public void afterSave() throws BaseException {
		Iterator iterParametros = parametros.iterator();
		while (iterParametros.hasNext()) {
		      ParamFuncionReporteExcel paramFuncRepoExcel = (ParamFuncionReporteExcel) iterParametros.next();
		      paramFuncRepoExcel.save();
		      paramFuncRepoExcel = null;
		}
		iterParametros = null;
 }


}
