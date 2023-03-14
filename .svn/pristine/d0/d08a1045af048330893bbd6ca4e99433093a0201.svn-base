package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class RelacionSujetoTurno extends ObjetoLogico {
	
  public static final String RELACION_VI = "Vigente";
  public static final String RELACION_NP = "No Paga";
  public static final String RELACION_BA = "Baja";
  public static final String RELACION_LI = "Licencia";
  
  

  public RelacionSujetoTurno() { 
  }

  public static String NICKNAME = "tu.RelacionSujetoTurno";

  private String codigo;
  private String descripcion;
  private String comportamiento;
  private Boolean activo;
  private Boolean noPermitirTurno;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public Boolean isNoPermitirTurno() throws BaseException { 
	supportRefresh();
	return this.noPermitirTurno;
  }

  public void setNoPermitirTurno(Boolean aNoPermitirTurno) { 
	this.noPermitirTurno =  aNoPermitirTurno;
  }
  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getComportamiento() throws BaseException { 
    supportRefresh();
    return comportamiento;
  }

  public void setComportamiento(String aComportamiento) { 
    this.comportamiento =  aComportamiento;
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

 public static RelacionSujetoTurno findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RelacionSujetoTurno) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static RelacionSujetoTurno findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (RelacionSujetoTurno) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static RelacionSujetoTurno findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RelacionSujetoTurno) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
 }
 
 public static HashTableDatos getRelaciones() throws BaseException {
	 HashTableDatos condiciones = new HashTableDatos();
	 
	 condiciones.put(RELACION_VI,"Vigente");
	 condiciones.put(RELACION_NP,"No Paga");
	 condiciones.put(RELACION_BA,"Baja");
	 condiciones.put(RELACION_LI,"Licencia");
	 
	 return condiciones;
 }
 
	public static RelacionSujetoTurno getRelacionSujetoTurno(ISesion aSesion)
	throws BaseException {
		Integer oidCateg = ValorParametro.findByCodigoParametro(
				"RELA_VIG_SUJ_TURNO", aSesion).getOidObjNeg();
		RelacionSujetoTurno relacion = RelacionSujetoTurno.findByOid(oidCateg, aSesion);
		return relacion;
	}
 
 
 

}
