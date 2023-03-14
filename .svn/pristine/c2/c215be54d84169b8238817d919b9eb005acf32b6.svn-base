package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluCompePostu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluCompePostu extends ObjetoLogico { 

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

public RecluCompePostu() { 
  }

  public static String NICKNAME = "rs.RecluCompePostu";

  private RecluPostulante postulante;
  private RecluCompetencias competencia;
  private Boolean activo;

  public RecluPostulante getPostulante() throws BaseException { 
    supportRefresh();
    return postulante;
  }

  public void setPostulante(RecluPostulante aPostulante) { 
    this.postulante =  aPostulante;
  }

  public RecluCompetencias getCompetencia() throws BaseException { 
    supportRefresh();
    return competencia;
  }

  public void setCompetencia(RecluCompetencias aCompetencia) { 
    this.competencia =  aCompetencia;
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

 public static RecluCompePostu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluCompePostu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluCompePostu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluCompePostu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(postulante, "Debe ingresar el Postulante");
    Validar.noNulo(competencia, "Debe ingresar la Competencia");
 }
 
 public static List getRecluCompetencias(
		  RecluPostulante postulante,
         ISesion aSesion) throws BaseException {
	  return DBRecluCompePostu.getRecluCompetencias(postulante,aSesion);
 } 

}
