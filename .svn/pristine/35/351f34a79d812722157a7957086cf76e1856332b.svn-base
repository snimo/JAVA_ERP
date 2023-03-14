package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBSeguEmpresaPredioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SeguEmpresaPredioDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SeguEmpresaPredioDet() { 
  }

  public static String NICKNAME = "exc.SeguEmpresaPredioDet";

  private SeguridadEmpresaPredio segu_empresa_predio;
  private PredioExcluido predio;
  private PerfilFuncional perfil_act;
  private Boolean vis_dif_importes;
  private Boolean vis_vehiculos;
  private Boolean vis_obs_generales;
  private Boolean vis_novedades;
  private Boolean vis_arch_adjuntos;
  private Boolean vis_pers_rel;
  private Boolean permitir_alta;
  private Boolean ver_nros_de_actas;
  private Boolean activo;

  public SeguridadEmpresaPredio getSegu_empresa_predio() throws BaseException { 
    supportRefresh();
    return segu_empresa_predio;
  }

  public void setSegu_empresa_predio(SeguridadEmpresaPredio aSegu_empresa_predio) { 
    this.segu_empresa_predio =  aSegu_empresa_predio;
  }

  public PredioExcluido getPredio() throws BaseException { 
    supportRefresh();
    return predio;
  }

  public void setPredio(PredioExcluido aPredio) { 
    this.predio =  aPredio;
  }

  public PerfilFuncional getPerfil_act() throws BaseException { 
    supportRefresh();
    return perfil_act;
  }

  public void setPerfil_act(PerfilFuncional aPerfil_act) { 
    this.perfil_act =  aPerfil_act;
  }

  public Boolean isVis_dif_importes() throws BaseException { 
    supportRefresh();
    return vis_dif_importes;
  }

  public void setVis_dif_importes(Boolean aVis_dif_importes) { 
    this.vis_dif_importes =  aVis_dif_importes;
  }

  public Boolean isVis_vehiculos() throws BaseException { 
    supportRefresh();
    return vis_vehiculos;
  }

  public void setVis_vehiculos(Boolean aVis_vehiculos) { 
    this.vis_vehiculos =  aVis_vehiculos;
  }

  public Boolean isVis_obs_generales() throws BaseException { 
    supportRefresh();
    return vis_obs_generales;
  }

  public void setVis_obs_generales(Boolean aVis_obs_generales) { 
    this.vis_obs_generales =  aVis_obs_generales;
  }

  public Boolean isVis_novedades() throws BaseException { 
    supportRefresh();
    return vis_novedades;
  }

  public void setVis_novedades(Boolean aVis_novedades) { 
    this.vis_novedades =  aVis_novedades;
  }

  public Boolean isVis_arch_adjuntos() throws BaseException { 
    supportRefresh();
    return vis_arch_adjuntos;
  }

  public void setVis_arch_adjuntos(Boolean aVis_arch_adjuntos) { 
    this.vis_arch_adjuntos =  aVis_arch_adjuntos;
  }

  public Boolean isVis_pers_rel() throws BaseException { 
    supportRefresh();
    return vis_pers_rel;
  }

  public void setVis_pers_rel(Boolean aVis_pers_rel) { 
    this.vis_pers_rel =  aVis_pers_rel;
  }

  public Boolean isPermitir_alta() throws BaseException { 
    supportRefresh();
    return permitir_alta;
  }

  public void setPermitir_alta(Boolean aPermitir_alta) { 
    this.permitir_alta =  aPermitir_alta;
  }

  public Boolean isVer_nros_de_actas() throws BaseException { 
    supportRefresh();
    return ver_nros_de_actas;
  }

  public void setVer_nros_de_actas(Boolean aVer_nros_de_actas) { 
    this.ver_nros_de_actas =  aVer_nros_de_actas;
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

 public static SeguEmpresaPredioDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SeguEmpresaPredioDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SeguEmpresaPredioDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SeguEmpresaPredioDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(segu_empresa_predio, "Debe ingresar la Seguridad");
 }
 
 public static List getSeguEmpreasPredioDet(
		  SeguridadEmpresaPredio seguEmpresaPredio,
         ISesion aSesion) throws BaseException {
	  return DBSeguEmpresaPredioDet.getSeguEmpreasPredioDet(seguEmpresaPredio,aSesion);
 } 

}
