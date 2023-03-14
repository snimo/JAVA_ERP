package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBVarEscenarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class VarEscenarioDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public VarEscenarioDet() { 
  }

  public static String NICKNAME = "pl.VarEscenarioDet";

  private VarEscenarioCab var_escenario_cab;
  private Integer secu;
  private CompoPresupuestario compo_presu;
  private Boolean activo;
  private Integer nroInternoValCompo;

  public VarEscenarioCab getVar_escenario_cab() throws BaseException { 
    supportRefresh();
    return var_escenario_cab;
  }

  public void setVar_escenario_cab(VarEscenarioCab aVar_escenario_cab) { 
    this.var_escenario_cab =  aVar_escenario_cab;
  }
  
  public Integer getNroInternoValCompo() throws BaseException { 
    supportRefresh();
    return this.nroInternoValCompo;
  }

  public void setNroInternoValCompo(Integer aNroInternoValCompo) { 
    this.nroInternoValCompo =  aNroInternoValCompo;
  }
  

  public Integer getSecu() throws BaseException { 
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) { 
    this.secu =  aSecu;
  }

  public CompoPresupuestario getCompo_presu() throws BaseException { 
    supportRefresh();
    return compo_presu;
  }

  public void setCompo_presu(CompoPresupuestario aCompo_presu) { 
    this.compo_presu =  aCompo_presu;
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

 public static VarEscenarioDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (VarEscenarioDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static VarEscenarioDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (VarEscenarioDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(var_escenario_cab, "Debe ingresar la variable de Escenario");
    Validar.noNulo(secu, "Debe ingresar el Nro. de Orden");
    Validar.noNulo(compo_presu, "Debe ingresar un componente");
 }
 
 public static List getVariablesEscenarioDet(VarEscenarioCab varEscenarioCab,
     ISesion aSesion) throws BaseException {
 	return DBVarEscenarioDet.getVariablesEscenarioDet(varEscenarioCab,aSesion);
 }
 
 public static List getVariablesEscenarioDetOrderByNroInt(VarEscenarioCab varEscenarioCab,
     ISesion aSesion) throws BaseException {
 	return DBVarEscenarioDet.getVariablesEscenarioDetOrderByNroInt(varEscenarioCab,aSesion);
 }

}
