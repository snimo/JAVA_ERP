package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluProcTipoFormu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluProcTipoFormu extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public RecluProcTipoFormu() { 
  }

  public static String NICKNAME = "rs.RecluProcTipoFormu";

  private RecluTipoFormuProceso tipo_formulario;
  private RecluProceso proceso;
  private Boolean activo;

  public RecluTipoFormuProceso getTipo_formulario() throws BaseException { 
    supportRefresh();
    return tipo_formulario;
  }

  public void setTipo_formulario(RecluTipoFormuProceso aTipo_formulario) { 
    this.tipo_formulario =  aTipo_formulario;
  }

  public RecluProceso getProceso() throws BaseException { 
    supportRefresh();
    return proceso;
  }

  public void setProceso(RecluProceso aProceso) { 
    this.proceso =  aProceso;
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

 public static RecluProcTipoFormu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluProcTipoFormu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluProcTipoFormu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluProcTipoFormu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tipo_formulario, "Debe ingresar el Tipo de Formulario");
    Validar.noNulo(proceso, "Debe ingresar el Proceso");
 }
 
 public static List getProcesosTipoFormu(RecluTipoFormuProceso tipoFormulario,
         ISesion aSesion) throws BaseException {
	  return DBRecluProcTipoFormu.getProcesosTipoFormu(tipoFormulario,aSesion);
 }  

}
