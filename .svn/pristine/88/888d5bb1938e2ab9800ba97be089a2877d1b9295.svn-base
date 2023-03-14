package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBCompoEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoEscenario extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CompoEscenario() { 
  }

  public static String NICKNAME = "pl.CompoEscenario";

  private Escenario escenario;
  private Integer nivel;
  private CompoPresupuestario compo_presu;
  private Boolean activo;

  public Escenario getEscenario() throws BaseException { 
    supportRefresh();
    return this.escenario;
  }

  public void setEscenario(Escenario aEscenario) { 
    this.escenario =  aEscenario;
  }

  public Integer getNivel() throws BaseException { 
    supportRefresh();
    return nivel;
  }

  public void setNivel(Integer aNivel) { 
    this.nivel =  aNivel;
  }

  public CompoPresupuestario getCompoPresupuestario() throws BaseException { 
    supportRefresh();
    return this.compo_presu;
  }

  public void setCompoPresupuestario(CompoPresupuestario aCompoPresu) { 
    this.compo_presu =  aCompoPresu;
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

 public static CompoEscenario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CompoEscenario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CompoEscenario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CompoEscenario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(escenario, "Debe ingresar el escenario");
    Validar.noNulo(nivel, "Debe ingresar el Nivel");
    Validar.noNulo(compo_presu, "Debe ingresar el componente presupuestario");
 }
 
 public static List getDetallesEscenario(Escenario escenario,
     ISesion aSesion) throws BaseException {
 	return DBCompoEscenario.getDetallesByEscenario(escenario,aSesion);
 }
 

}
