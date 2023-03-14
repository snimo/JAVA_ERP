package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluCompeBusqAct;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluCompeBusqAct extends ObjetoLogico { 

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

public RecluCompeBusqAct() { 
  }

  public static String NICKNAME = "rs.RecluCompeBusqAct";

  private RecluCompetencias competencia;
  private RecluBusqueda busqueda;
  private Boolean activo;

  public RecluCompetencias getCompetencia() throws BaseException { 
    supportRefresh();
    return competencia;
  }

  public void setCompetencia(RecluCompetencias aCompetencia) { 
    this.competencia =  aCompetencia;
  }

  public RecluBusqueda getBusqueda() throws BaseException { 
    supportRefresh();
    return busqueda;
  }

  public void setBusqueda(RecluBusqueda aBusqueda) { 
    this.busqueda =  aBusqueda;
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

 public static RecluCompeBusqAct findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluCompeBusqAct) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluCompeBusqAct findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluCompeBusqAct) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(competencia, "Debe ingresar la Competencia");
    Validar.noNulo(busqueda, "Debe ingresar la Busqueda");
 }
 
 public static List getCompetenciasBusqueda(RecluBusqueda busqueda,
         ISesion aSesion) throws BaseException {
	  return DBRecluCompeBusqAct.getCompetenciasBusqueda(busqueda,aSesion);
 } 

}
