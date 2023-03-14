package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBDispMovilExc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DispMovilExc extends ObjetoLogico { 

  public DispMovilExc() { 
  }

  public static String NICKNAME = "exc.DispMovilExc";

  private String codigo;
  private String descripcion;
  private GrupoImportacionExcluido grupo_importacion;
  private String fec_hor_ult_sinc_ol;
  private Boolean forzar_sinc_all;
  private Integer ult_nro_lote_inf;
  private Boolean forzar_simpre_sinc;
  private Boolean activo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public Boolean isForzarSiempreSinc() throws BaseException { 
	    supportRefresh();
	    return this.forzar_simpre_sinc;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }
  
  public void setForzarSiempresSinc(Boolean aForzarSiempreSinc) { 
	    this.forzar_simpre_sinc =  aForzarSiempreSinc;
	  }
  

  public GrupoImportacionExcluido getGrupo_importacion() throws BaseException { 
    supportRefresh();
    return grupo_importacion;
  }

  public void setGrupo_importacion(GrupoImportacionExcluido aGrupo_importacion) { 
    this.grupo_importacion =  aGrupo_importacion;
  }

  public String getFec_hor_ult_sinc_ol() throws BaseException { 
    supportRefresh();
    return fec_hor_ult_sinc_ol;
  }

  public void setFec_hor_ult_sinc_ol(String aFec_hor_ult_sinc_ol) { 
    this.fec_hor_ult_sinc_ol =  aFec_hor_ult_sinc_ol;
  }

  public Boolean isForzar_sinc_all() throws BaseException { 
    supportRefresh();
    return forzar_sinc_all;
  }

  public void setForzar_sinc_all(Boolean aForzar_sinc_all) { 
    this.forzar_sinc_all =  aForzar_sinc_all;
  }

  public Integer getUlt_nro_lote_inf() throws BaseException { 
    supportRefresh();
    return ult_nro_lote_inf;
  }

  public void setUlt_nro_lote_inf(Integer aUlt_nro_lote_inf) { 
    this.ult_nro_lote_inf =  aUlt_nro_lote_inf;
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

 public static DispMovilExc findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DispMovilExc) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static DispMovilExc findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (DispMovilExc) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static DispMovilExc findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DispMovilExc) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(grupo_importacion, "Debe ingresar el Grupo de Importación");
 }
 
 public static List getDispMovExc(
		  GrupoImportacionExcluido grupoImportacion,
         ISesion aSesion) throws BaseException {
	  return DBDispMovilExc.getDispMovExc(grupoImportacion,aSesion);
 }
 

}
