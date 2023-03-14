package com.srn.erp.compras.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.compras.da.DBAutorizadorRequisicion;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AutorizadorRequisicion extends ObjetoLogico { 

  public static final String TIPO_AUTORIZ_SUFICIENTE = "SUFICIENTE";
  public static final String TIPO_AUTORIZ_NECESARIO  = "NECESARIO";
		
  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public AutorizadorRequisicion() { 
  }

  public static String NICKNAME = "cp.AutorizadorRequisicion";

  private EsquemaAutorizCompras esquema_autorizacion;
  private SectorCompra sector_emisor;
  private RolAutorizadorCompras rol_autorizador;
  private ValorClasificadorEntidad valor_clasificador;
  private String tipoAutoriz;
  private Boolean activo;

  public EsquemaAutorizCompras getEsquema_autorizacion() throws BaseException { 
    supportRefresh();
    return esquema_autorizacion;
  }
  
  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
	  supportRefresh();
		return activo;
  }
  
  public void setActivo(Boolean aActivo) throws BaseException {
	  this.activo = aActivo;
  }
	
	  

  public void setEsquema_autorizacion(EsquemaAutorizCompras aEsquema_autorizacion) { 
    this.esquema_autorizacion =  aEsquema_autorizacion;
  }

  public String getTipoAutoriz() throws BaseException { 
	 supportRefresh();
	 return tipoAutoriz;
  }

  public void setTipoAutoriz(String aTipoAutoriz) { 
	this.tipoAutoriz =  aTipoAutoriz;
  }  

  public SectorCompra getSector_emisor() throws BaseException { 
    supportRefresh();
    return sector_emisor;
  }

  public void setSector_emisor(SectorCompra aSector_emisor) { 
    this.sector_emisor =  aSector_emisor;
  }

  public RolAutorizadorCompras getRol_autorizador() throws BaseException { 
    supportRefresh();
    return rol_autorizador;
  }

  public void setRol_autorizador(RolAutorizadorCompras aRol_autorizador) { 
    this.rol_autorizador =  aRol_autorizador;
  }

  public ValorClasificadorEntidad getValor_clasificador() throws BaseException { 
    supportRefresh();
    return valor_clasificador;
  }

  public void setValor_clasificador(ValorClasificadorEntidad aValor_clasificador) { 
    this.valor_clasificador =  aValor_clasificador;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AutorizadorRequisicion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AutorizadorRequisicion) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AutorizadorRequisicion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AutorizadorRequisicion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(esquema_autorizacion, "Debe ingresar el esquema de Autorización");
    Validar.noNulo(sector_emisor, "Debe ingresar el Sector Compra");
    Validar.noNulo(rol_autorizador, "Debe ingresar el Rol Autorizador");
    Validar.noNulo(valor_clasificador, "Debe ingresar el Valor de Clasificador de Entidad");
    Validar.noNulo(tipoAutoriz, "Debe ingresar el Tipo de Autorización");
 }
 
 public static List getAutorizadoresRequisicion(EsquemaAutorizCompras esquemaAutorizCompras,
         ISesion aSesion) throws BaseException {
	  return DBAutorizadorRequisicion.getAutorizadoresRequisicion(esquemaAutorizCompras,aSesion);
 } 
 
 public static Hashtable getTiposAutorizaciones() throws BaseException {
	 Hashtable tipos = new Hashtable();
	 tipos.put(TIPO_AUTORIZ_SUFICIENTE,"Suficiente");
	 tipos.put(TIPO_AUTORIZ_NECESARIO,"Necesaria");
	 return tipos;
 }
 
   public static List getAutorizadoresRequisicion(
			EsquemaAutorizCompras esquemaAutorizCompras, 
			SectorCompra sectorEmisor,
			IValorClasificadorEntidad valClasifEnt,
			ISesion aSesion)
			throws BaseException {		   
		return DBAutorizadorRequisicion.getAutorizadoresRequisicion(esquemaAutorizCompras,
																	sectorEmisor,
																	valClasifEnt,
																	aSesion);

   } 

}
