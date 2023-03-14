package com.srn.erp.cip.bm;

import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PersonalSeguridad extends ObjetoLogico { 

  public PersonalSeguridad() { 
  }

  public static String NICKNAME = "cip.PersonalSeguridad";

  private String codigo;
  private Boolean activo;
  private String apellido;
  private String nombre;
  private TipoDocumento tipo_documento;
  private Boolean cacheo_seg;
  private String nro_docu;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getApellido() throws BaseException { 
    supportRefresh();
    return apellido;
  }

  public void setApellido(String aApellido) { 
    this.apellido =  aApellido;
  }

  public String getNombre() throws BaseException { 
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) { 
    this.nombre =  aNombre;
  }

  public TipoDocumento getTipo_documento() throws BaseException { 
    supportRefresh();
    return tipo_documento;
  }

  public void setTipo_documento(TipoDocumento aTipo_documento) { 
    this.tipo_documento =  aTipo_documento;
  }

  public Boolean isCacheo_seg() throws BaseException { 
    supportRefresh();
    return cacheo_seg;
  }

  public void setCacheo_seg(Boolean aCacheo_seg) { 
    this.cacheo_seg =  aCacheo_seg;
  }

  public String getNro_docu() throws BaseException { 
    supportRefresh();
    return nro_docu;
  }

  public void setNro_docu(String aNro_docu) { 
    this.nro_docu =  aNro_docu;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static PersonalSeguridad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PersonalSeguridad) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static PersonalSeguridad findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (PersonalSeguridad) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static PersonalSeguridad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PersonalSeguridad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(apellido, "Debe ingresar el apellido");
    Validar.noNulo(nombre, "Debe ingresar el nombre");
 }

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

}
