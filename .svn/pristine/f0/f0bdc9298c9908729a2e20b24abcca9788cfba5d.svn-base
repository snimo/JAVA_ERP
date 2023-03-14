package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluNovedadPostu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluNovedadPostu extends ObjetoLogico { 

  public RecluNovedadPostu() { 
  }

  public static String NICKNAME = "rs.RecluNovedadPostu";

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

  private RecluPostulante postulante;
  private java.util.Date fecha;
  private String novedad;
  private Boolean exc_fut_postu;
  private Usuario usuario;
  private Boolean activo;
  private java.util.Date fecVigencia;
  

  public RecluPostulante getPostulante() throws BaseException { 
    supportRefresh();
    return postulante;
  }
  
  public java.util.Date getFecVigencia() throws BaseException { 
	    supportRefresh();
	    return this.fecVigencia;
	  }  

  public void setPostulante(RecluPostulante aPostulante) { 
    this.postulante =  aPostulante;
  }

  
  public void setFecVigencia(java.util.Date aFecVigencia) { 
	    this.fecVigencia =  aFecVigencia;
	  }
  
  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getNovedad() throws BaseException { 
    supportRefresh();
    return novedad;
  }

  public void setNovedad(String aNovedad) { 
    this.novedad =  aNovedad;
  }

  public Boolean isExc_fut_postu() throws BaseException { 
    supportRefresh();
    return exc_fut_postu;
  }

  public void setExc_fut_postu(Boolean aExc_fut_postu) { 
    this.exc_fut_postu =  aExc_fut_postu;
  }

  public Usuario getUsuario() throws BaseException { 
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) { 
    this.usuario =  aUsuario;
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

 public static RecluNovedadPostu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecluNovedadPostu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RecluNovedadPostu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecluNovedadPostu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(postulante, "Debe ingresar el Postulante");
    Validar.noNulo(fecha, "Debe ingresar la Fecha");
    Validar.noNulo(novedad, "Debe ingresar la Novedad");
    Validar.noNulo(exc_fut_postu, "Debe indicar si se Excluye o no en postulaciones");
    Validar.noNulo(usuario, "Debe ingresar el Usuario");
 }
 
 public static List getNovedadesPostulantes(RecluPostulante postulante,
         ISesion aSesion) throws BaseException {
	  return DBRecluNovedadPostu.getNovedadesPostulantes(postulante,aSesion);
 }   

}
