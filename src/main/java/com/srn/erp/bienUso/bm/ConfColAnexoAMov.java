package com.srn.erp.bienUso.bm;

import java.util.List;

import com.srn.erp.bienUso.da.DBConfColAnexoAMov;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfColAnexoAMov extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ConfColAnexoAMov() { 
  }

  public static String NICKNAME = "bu.ConfColAnexoAMov";

  private ConfColAnexoA conf_col_aneoxo;
  private String tipo_mov;
  private Boolean activo;

  public ConfColAnexoA getConf_col_aneoxo() throws BaseException { 
    supportRefresh();
    return conf_col_aneoxo;
  }

  public void setConf_col_aneoxo(ConfColAnexoA aConf_col_aneoxo) { 
    this.conf_col_aneoxo =  aConf_col_aneoxo;
  }

  public String getTipo_mov() throws BaseException { 
    supportRefresh();
    return tipo_mov;
  }

  public void setTipo_mov(String aTipo_mov) { 
    this.tipo_mov =  aTipo_mov;
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

 public static ConfColAnexoAMov findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfColAnexoAMov) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConfColAnexoAMov findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfColAnexoAMov) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(conf_col_aneoxo, "Debe ingresar la columna");
    Validar.noNulo(tipo_mov, "Debe ingresar el tipo de Movimiento");
    Validar.noNulo(activo, "Debe ingresar si esta activado");
 }
 
 public static List getConfColAnexoAMov(ConfColAnexoA condColAnexoA,
         ISesion aSesion) throws BaseException {
	 return DBConfColAnexoAMov.getConfColAnexoAMov(condColAnexoA,aSesion);
 }
 

}
