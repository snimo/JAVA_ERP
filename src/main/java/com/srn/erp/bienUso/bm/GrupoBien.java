package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoBien extends ObjetoLogico { 

  public GrupoBien() { 
  }

  public static String NICKNAME = "bu.GrupoBien";

  private String codigo;
  private String descripcion;
  private Boolean amortiza;
  private CuentaImputable ai_vo;
  private CuentaImputable ai_aa;
  private CuentaImputable ai_rvo;
  private CuentaImputable ai_raa;
  private Boolean activo;
  
  private List sistemasVidaUtil = new ArrayList();
  

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
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

  public Boolean isAmortiza() throws BaseException { 
    supportRefresh();
    return amortiza;
  }

  public void setAmortiza(Boolean aAmortiza) { 
    this.amortiza =  aAmortiza;
  }

  public CuentaImputable getAi_vo() throws BaseException { 
    supportRefresh();
    return ai_vo;
  }

  public void setAi_vo(CuentaImputable aAi_vo) { 
    this.ai_vo =  aAi_vo;
  }

  public CuentaImputable getAi_aa() throws BaseException { 
    supportRefresh();
    return ai_aa;
  }

  public void setAi_aa(CuentaImputable aAi_aa) { 
    this.ai_aa =  aAi_aa;
  }

  public CuentaImputable getAi_rvo() throws BaseException { 
    supportRefresh();
    return ai_rvo;
  }

  public void setAi_rvo(CuentaImputable aAi_rvo) { 
    this.ai_rvo =  aAi_rvo;
  }

  public CuentaImputable getAi_raa() throws BaseException { 
    supportRefresh();
    return ai_raa;
  }

  public void setAi_raa(CuentaImputable aAi_raa) { 
    this.ai_raa =  aAi_raa;
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

 public static GrupoBien findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoBien) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoBien findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (GrupoBien) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static GrupoBien findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoBien) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(ai_vo, "Debe ingresar la Cuenta Valor Origen");
    Validar.noNulo(ai_aa, "Debe ingresar la Cuenta Amort. Acum.");
    Validar.noNulo(ai_rvo, "Debe ingresar la Cuenta Rev. Valor Origen");
    Validar.noNulo(ai_raa, "Debe ingresar la Cuenta Rev. Amort. Acum.");
 }
 
 public void addVidaUtilGrupo(VidaUtilGrupo vidaUtilGrupo) throws BaseException {
   vidaUtilGrupo.setGrupo_bien(this);
   sistemasVidaUtil.add(vidaUtilGrupo);
 }

  public void afterSave() throws BaseException {
	Iterator iterVidaUtilGrupos = sistemasVidaUtil.iterator();
	while (iterVidaUtilGrupos.hasNext()) {
	  VidaUtilGrupo vidaUtilGrupo = (VidaUtilGrupo) iterVidaUtilGrupos.next();
	  vidaUtilGrupo.save();
	  vidaUtilGrupo = null;
	}
	iterVidaUtilGrupos = null;
  }
  
  
  public VidaUtilGrupo getVidaUtilGrupo(SistemaValuacion sistemaValuacion) throws BaseException {
	 return VidaUtilGrupo.getVidaUtilGrupo(this,sistemaValuacion,getSesion());
  }
  

}
