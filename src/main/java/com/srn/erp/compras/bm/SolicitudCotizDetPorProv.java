package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBSolicitudCotizDetPorProv;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SolicitudCotizDetPorProv extends ObjetoLogico { 

  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SolicitudCotizDetPorProv() { 
  }

  public static String NICKNAME = "cp.SolicitudCotizDetPorProv";

  private SolicitudCotizProveedor solicitud_cotiz_prov;
  private SolicitudCotizProvDet solicitud_cotiz_det;
  private Double cant_a_cotizar;
  private UnidadMedida oid_um_cpra;
  private Boolean cotizar;
  private String obs_art_prov;
  private SolicitudCotizProvCab solicitudCotizacion; 

  public SolicitudCotizProveedor getSolicitud_cotiz_prov() throws BaseException { 
    supportRefresh();
    return solicitud_cotiz_prov;
  }

  public void setSolicitud_cotiz_prov(SolicitudCotizProveedor aSolicitud_cotiz_prov) { 
    this.solicitud_cotiz_prov =  aSolicitud_cotiz_prov;
  }
  
  public SolicitudCotizProvCab getSolicitudCotizacion() throws BaseException {
	  supportRefresh();
	  return solicitudCotizacion;
  }
  
  public void setSolicitudCotizacion(SolicitudCotizProvCab aSolicitudCotizacion) throws BaseException {
	  this.solicitudCotizacion = aSolicitudCotizacion;
  }

  public SolicitudCotizProvDet getSolicitud_cotiz_det() throws BaseException { 
    supportRefresh();
    return solicitud_cotiz_det;
  }

  public void setSolicitud_cotiz_det(SolicitudCotizProvDet aSolicitud_cotiz_det) { 
    this.solicitud_cotiz_det =  aSolicitud_cotiz_det;
  }

  public Double getCant_a_cotizar() throws BaseException { 
    supportRefresh();
    return cant_a_cotizar;
  }

  public void setCant_a_cotizar(Double aCant_a_cotizar) { 
    this.cant_a_cotizar =  aCant_a_cotizar;
  }

  public UnidadMedida getOid_um_cpra() throws BaseException { 
    supportRefresh();
    return oid_um_cpra;
  }

  public void setOid_um_cpra(UnidadMedida aOid_um_cpra) { 
    this.oid_um_cpra =  aOid_um_cpra;
  }

  public Boolean isCotizar() throws BaseException { 
    supportRefresh();
    return cotizar;
  }

  public void setCotizar(Boolean aCotizar) { 
    this.cotizar =  aCotizar;
  }

  public String getObs_art_prov() throws BaseException { 
    supportRefresh();
    return obs_art_prov;
  }

  public void setObs_art_prov(String aObs_art_prov) { 
    this.obs_art_prov =  aObs_art_prov;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static SolicitudCotizDetPorProv findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SolicitudCotizDetPorProv) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SolicitudCotizDetPorProv findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SolicitudCotizDetPorProv) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static SolicitudCotizDetPorProv findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SolicitudCotizDetPorProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(solicitud_cotiz_prov, "Debe ingresar la Cotización");
    Validar.noNulo(solicitud_cotiz_det, "Debe ingresar el Detalle de la Cotización");
    Validar.noNulo(cant_a_cotizar, "Debe ingresar la cantidad a Cotizar");
    Validar.noNulo(oid_um_cpra, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(cotizar, "Debe ingresar si hay que cotizar el item");
 }
 
 public static List getSolicitudesCotizDetPorProveedores(SolicitudCotizProvCab solicitudCotizacion,
         ISesion aSesion) throws BaseException {
	  return DBSolicitudCotizDetPorProv.getSolicitudesCotizDetPorProveedores(solicitudCotizacion,aSesion);
 }
 
 public static List getSolicitudesCotizDetPorProveedores(SolicitudCotizProveedor solCotizProv,
         ISesion aSesion) throws BaseException {
	  return DBSolicitudCotizDetPorProv.getSolicitudesCotizDetPorProveedores(solCotizProv,aSesion);
 }  
 

}
