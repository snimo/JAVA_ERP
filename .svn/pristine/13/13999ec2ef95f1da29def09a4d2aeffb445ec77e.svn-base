package com.srn.erp.excluidos.bm;

import com.srn.erp.excluidos.da.DBEstadoIndividuoPredio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoIndividuoPredio extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public EstadoIndividuoPredio() { 
  }

  public static String NICKNAME = "exc.EstadoIndividuoPredio";

  private PredioExcluido predio;
  private IndividuoExcluido individuo;
  private EstadoExcluido estado;
  private EstadoExcluido estado_anterior;
  private java.util.Date fec_estado;
  private java.util.Date fec_hora_estado;
  private java.util.Date fec_estado_ant;
  private java.util.Date fec_hor_estado_ant;
  private NovedadExcluido novedad;
  private Boolean activo;

  public PredioExcluido getPredio() throws BaseException { 
    supportRefresh();
    return predio;
  }

  public void setPredio(PredioExcluido aPredio) { 
    this.predio =  aPredio;
  }

  public IndividuoExcluido getIndividuo() throws BaseException { 
    supportRefresh();
    return individuo;
  }

  public void setIndividuo(IndividuoExcluido aIndividuo) { 
    this.individuo =  aIndividuo;
  }

  public EstadoExcluido getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(EstadoExcluido aEstado) { 
    this.estado =  aEstado;
  }

  public EstadoExcluido getEstado_anterior() throws BaseException { 
    supportRefresh();
    return estado_anterior;
  }

  public void setEstado_anterior(EstadoExcluido aEstado_anterior) { 
    this.estado_anterior =  aEstado_anterior;
  }

  public java.util.Date getFec_estado() throws BaseException { 
    supportRefresh();
    return fec_estado;
  }

  public void setFec_estado(java.util.Date aFec_estado) { 
    this.fec_estado =  aFec_estado;
  }

  public java.util.Date getFec_hora_estado() throws BaseException { 
    supportRefresh();
    return fec_hora_estado;
  }

  public void setFec_hora_estado(java.util.Date aFec_hora_estado) { 
    this.fec_hora_estado =  aFec_hora_estado;
  }

  public java.util.Date getFec_estado_ant() throws BaseException { 
    supportRefresh();
    return fec_estado_ant;
  }

  public void setFec_estado_ant(java.util.Date aFec_estado_ant) { 
    this.fec_estado_ant =  aFec_estado_ant;
  }

  public java.util.Date getFec_hor_estado_ant() throws BaseException { 
    supportRefresh();
    return fec_hor_estado_ant;
  }

  public void setFec_hor_estado_ant(java.util.Date aFec_hor_estado_ant) { 
    this.fec_hor_estado_ant =  aFec_hor_estado_ant;
  }

  public NovedadExcluido getNovedad() throws BaseException { 
    supportRefresh();
    return novedad;
  }

  public void setNovedad(NovedadExcluido aNovedad) { 
    this.novedad =  aNovedad;
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

 public static EstadoIndividuoPredio findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstadoIndividuoPredio) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EstadoIndividuoPredio findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstadoIndividuoPredio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(predio, "Debe ingresar el Predio");
    Validar.noNulo(individuo, "Debe ingresar el Individuo");
 }
 
 public static EstadoIndividuoPredio getEstadoIndividuoPredio(
		  PredioExcluido predio,
		  IndividuoExcluido individuo,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBEstadoIndividuoPredio.getEstadoIndividuoPredio(predio,individuo,aSesion);
	  
 }  

}
