package com.srn.erp.excelReport.bm;

import java.util.List;

import com.srn.erp.excelReport.da.DBUsuarioReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class UsuarioReporteExcel extends ObjetoLogico { 

  public UsuarioReporteExcel() { 
  }

  public static String NICKNAME = "ex.UsuarioReporteExcel";

  private ExcelReport reporte;
  private Boolean lectura;
  private Boolean modificacion;
  private Boolean grabacion;
  private Boolean activo;
  private Usuario usuario;

  public ExcelReport getReporte() throws BaseException { 
    supportRefresh();
    return reporte;
  }

  public void setReporte(ExcelReport aReporte) { 
    this.reporte =  aReporte;
  }

  public Boolean isLectura() throws BaseException { 
    supportRefresh();
    return lectura;
  }

  public void setLectura(Boolean aLectura) { 
    this.lectura =  aLectura;
  }

  public Boolean isModificacion() throws BaseException { 
    supportRefresh();
    return modificacion;
  }

  public void setModificacion(Boolean aModificacion) { 
    this.modificacion =  aModificacion;
  }

  public Boolean isGrabacion() throws BaseException { 
    supportRefresh();
    return grabacion;
  }

  public void setGrabacion(Boolean aGrabacion) { 
    this.grabacion =  aGrabacion;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public Usuario getUsuario() throws BaseException { 
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) { 
    this.usuario =  aUsuario;
  }

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getNickName() { 
    return NICKNAME; 
  } 

 public static UsuarioReporteExcel findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UsuarioReporteExcel) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static UsuarioReporteExcel findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UsuarioReporteExcel) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(reporte, "Debe ingresar el Reporte");
    Validar.noNulo(usuario, "Debe ingresar el Usuario");
 }
 
 public static UsuarioReporteExcel getUsuarioReporteExcel(ExcelReport excel,
		  Usuario usuario,
          ISesion aSesion)
          throws BaseException {
	  
	  return DBUsuarioReporteExcel.getUsuarioReporteExcel(excel,usuario,aSesion);
	  
 }
 
 public static List getUsuariosReporte(ExcelReport excel,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBUsuarioReporteExcel.getUsuariosReporte(excel,aSesion);
 }
 
 

}
