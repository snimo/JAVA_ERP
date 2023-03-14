package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBCotizacionProveedorDet;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CotizacionProveedorDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public CotizacionProveedorDet() { 
  }

  public static String NICKNAME = "cp.CotizacionProveedorDet";

  private CotizacionProveedorCab cotizacion_proveedor;
  private SolicitudCotizDetPorProv cotizacion_det_prov;
  private UnidadMedida unidad_medida;
  private Double cant_presu;
  private Moneda moneda;
  private Money precio;
  private java.util.Date fec_ent;
  private String comentario;
  private CondicionCompra cond_pago_1;
  private Double dto_cond_pago_1;
  private CondicionCompra cond_pago_2;
  private Double dto_cond_pago_2;
  private Boolean anulado;
  private Producto producto;
  private Integer nroItem;

  public CotizacionProveedorCab getCotizacion_proveedor() throws BaseException { 
    supportRefresh();
    return cotizacion_proveedor;
  }
  
  public void setNroItem(Integer aNroItem) throws BaseException {
	 this.nroItem = aNroItem;	  
  }
  
  public Integer getNroItem() throws BaseException {
	  supportRefresh();
	  return nroItem;
  }

  public void setCotizacion_proveedor(CotizacionProveedorCab aCotizacion_proveedor) { 
    this.cotizacion_proveedor =  aCotizacion_proveedor;
  }
  
  public Producto getProducto() throws BaseException {
	  supportRefresh();
	  return producto;
  }
  
  public void setProducto(Producto aProducto) throws BaseException {
	this.producto = aProducto;  
  }

  public SolicitudCotizDetPorProv getCotizacion_det_prov() throws BaseException { 
    supportRefresh();
    return cotizacion_det_prov;
  }

  public void setCotizacion_det_prov(SolicitudCotizDetPorProv aCotizacion_det_prov) { 
    this.cotizacion_det_prov =  aCotizacion_det_prov;
  }

  public UnidadMedida getUnidad_medida() throws BaseException { 
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) { 
    this.unidad_medida =  aUnidad_medida;
  }

  public Double getCant_presu() throws BaseException { 
    supportRefresh();
    return cant_presu;
  }

  public void setCant_presu(Double aCant_presu) { 
    this.cant_presu =  aCant_presu;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public Money getPrecio() throws BaseException { 
    supportRefresh();
    return precio;
  }

  public void setPrecio(Money aPrecio) { 
    this.precio =  aPrecio;
  }

  public java.util.Date getFec_ent() throws BaseException { 
    supportRefresh();
    return fec_ent;
  }

  public void setFec_ent(java.util.Date aFec_ent) { 
    this.fec_ent =  aFec_ent;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
  }

  public CondicionCompra getCond_pago_1() throws BaseException { 
    supportRefresh();
    return cond_pago_1;
  }

  public void setCond_pago_1(CondicionCompra aCond_pago_1) { 
    this.cond_pago_1 =  aCond_pago_1;
  }

  public Double getDto_cond_pago_1() throws BaseException { 
    supportRefresh();
    return dto_cond_pago_1;
  }

  public void setDto_cond_pago_1(Double aDto_cond_pago_1) { 
    this.dto_cond_pago_1 =  aDto_cond_pago_1;
  }

  public CondicionCompra getCond_pago_2() throws BaseException { 
    supportRefresh();
    return cond_pago_2;
  }

  public void setCond_pago_2(CondicionCompra aCond_pago_2) { 
    this.cond_pago_2 =  aCond_pago_2;
  }

  public Double getDto_cond_pago_2() throws BaseException { 
    supportRefresh();
    return dto_cond_pago_2;
  }

  public void setDto_cond_pago_2(Double aDto_cond_pago_2) { 
    this.dto_cond_pago_2 =  aDto_cond_pago_2;
  }

  public Boolean isAnulado() throws BaseException { 
    supportRefresh();
    return anulado;
  }

  public void setAnulado(Boolean aAnulado) { 
    this.anulado =  aAnulado;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CotizacionProveedorDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CotizacionProveedorDet) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static CotizacionProveedorDet findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (CotizacionProveedorDet) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static CotizacionProveedorDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CotizacionProveedorDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(cotizacion_proveedor, "Debe ingresar la Cotización");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(cant_presu, "Debe ingresar la cantidad");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
    Validar.noNulo(precio, "Debe ingresar el Precio");
    Validar.noNulo(fec_ent, "Debe ingresar la Fecha de Entrega");
 }
 
 public static List getCotizacionesProveedoresDet(CotizacionProveedorCab cotizProvCab,
         ISesion aSesion) throws BaseException {
	  return DBCotizacionProveedorDet.getCotizacionesProveedoresDet(cotizProvCab,aSesion);
 }
  

}
