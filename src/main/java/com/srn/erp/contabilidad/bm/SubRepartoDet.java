package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBSubRepartoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubRepartoDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SubRepartoDet() { 
  }

  public static String NICKNAME = "cg.SubRepartoDet";

  private Integer secu;
  private SubReparto subreparto;
  private FaseSubReparto fase;
  private Boolean activo;

  public Integer getSecu() throws BaseException { 
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) { 
    this.secu =  aSecu;
  }

  public SubReparto getSubreparto() throws BaseException { 
    supportRefresh();
    return subreparto;
  }

  public void setSubreparto(SubReparto aSubreparto) { 
    this.subreparto =  aSubreparto;
  }

  public FaseSubReparto getFase() throws BaseException { 
    supportRefresh();
    return fase;
  }

  public void setFase(FaseSubReparto aFase) { 
    this.fase =  aFase;
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

 public static SubRepartoDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubRepartoDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SubRepartoDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubRepartoDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(secu, "Debe ingresar el Orden");
    Validar.noNulo(subreparto, "Debe ingresar el SubReparto");
    Validar.noNulo(fase, "Debe ingresar la Fase del SubReparto");
 }
 
 public static List getSubRepartosDet(SubReparto subreparto,
         ISesion aSesion) throws BaseException {
	  return DBSubRepartoDet.getSubRepartosDet(subreparto,aSesion);
 }
 

}
