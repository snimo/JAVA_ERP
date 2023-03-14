package com.srn.erp.compras.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.compras.da.DBEstadisticaOC;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class EstadisticaOC extends ObjetoLogico { 

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

	public EstadisticaOC() { 
  }

  public static String NICKNAME = "cp.EstadisticaOC";

  private Integer nro_ext;
  private Integer oid_tc;
  private String tc_ext;
  private String letra;
  private Integer lug_emi;
  private Integer oid_proveedor;
  private Integer oid_cond_pago;
  private Integer oid_sector_compra;
  private Integer oid_cco_det;
  private Integer oid_cco;
  private Integer oid_producto;
  private Integer oid_um;
  private Integer cant;
  private Double precio;
  private Double cotizacion;
  private Integer oid_moneda;
  private String cod_producto;
  private String desc_producto;
  private String cod_proveedor;
  private String nombre_proveedor;
  private Integer signo;
  private Date emision;
  
  private Hashtable					listaOidValClasif	= new Hashtable();

  public Integer getNro_ext() throws BaseException { 
    supportRefresh();
    return nro_ext;
  }
  
	public void addOidValorClasif(Integer oidClasif, Integer aValor) {
		if (aValor == null)
			listaOidValClasif.put(oidClasif, new Integer(0));
		else
			listaOidValClasif.put(oidClasif, aValor);
	}
	
	public Integer getOidValorClasif(Integer oidClasificador) {
		Integer oid = (Integer)listaOidValClasif.get(oidClasificador);
		if (oid!=null)
			return oid;
		else
			return new Integer(0);
	}
  
  public void setNro_ext(Integer aNro_ext) { 
    this.nro_ext =  aNro_ext;
  }
  
  public Date getEmision() throws BaseException { 
    supportRefresh();
    return this.emision;
  }

  public void setEmision(Date aEmision) { 
    this.emision =  aEmision;
  }
  

  public Integer getOid_tc() throws BaseException { 
    supportRefresh();
    return oid_tc;
  }

  public void setOid_tc(Integer aOid_tc) { 
    this.oid_tc =  aOid_tc;
  }

  public String getTc_ext() throws BaseException { 
    supportRefresh();
    return tc_ext;
  }

  public void setTc_ext(String aTc_ext) { 
    this.tc_ext =  aTc_ext;
  }

  public String getLetra() throws BaseException { 
    supportRefresh();
    return letra;
  }

  public void setLetra(String aLetra) { 
    this.letra =  aLetra;
  }

  public Integer getLug_emi() throws BaseException { 
    supportRefresh();
    return lug_emi;
  }

  public void setLug_emi(Integer aLug_emi) { 
    this.lug_emi =  aLug_emi;
  }

  public Integer getOid_Proveedor() throws BaseException { 
    supportRefresh();
    return this.oid_proveedor;
  }

  public void setOid_Proveedor(Integer aOid_Proveedor) { 
    this.oid_proveedor =  aOid_Proveedor;
  }

  public Integer getOid_cond_pago() throws BaseException { 
    supportRefresh();
    return oid_cond_pago;
  }

  public void setOid_cond_pago(Integer aOid_cond_pago) { 
    this.oid_cond_pago =  aOid_cond_pago;
  }

  public Integer getOid_Sector_Compra() throws BaseException { 
    supportRefresh();
    return this.oid_sector_compra;
  }

  public void setOid_Sector_Compra(Integer aOid_Sector_Compra) { 
    this.oid_sector_compra =  aOid_Sector_Compra;
  }

  public Integer getOid_cco_det() throws BaseException { 
    supportRefresh();
    return this.oid_cco_det;
  }

  public void setOid_cco_det(Integer aOid_cco_det) { 
    this.oid_cco_det =  aOid_cco_det;
  }

  public Integer getOid_cco() throws BaseException { 
    supportRefresh();
    return oid_cco;
  }

  public void setOid_cco(Integer aOid_cco) { 
    this.oid_cco =  aOid_cco;
  }

  public Integer getOid_producto() throws BaseException { 
    supportRefresh();
    return oid_producto;
  }

  public void setOid_producto(Integer aOid_producto) { 
    this.oid_producto =  aOid_producto;
  }

  public Integer getOid_um() throws BaseException { 
    supportRefresh();
    return oid_um;
  }

  public void setOid_um(Integer aOid_um) { 
    this.oid_um =  aOid_um;
  }

  public Integer getCant() throws BaseException { 
    supportRefresh();
    return cant;
  }

  public void setCant(Integer aCant) { 
    this.cant =  aCant;
  }

  public Double getPrecio() throws BaseException { 
    supportRefresh();
    return precio;
  }

  public void setPrecio(Double aPrecio) { 
    this.precio =  aPrecio;
  }

  public Double getCotizacion() throws BaseException { 
    supportRefresh();
    return cotizacion;
  }

  public void setCotizacion(Double aCotizacion) { 
    this.cotizacion =  aCotizacion;
  }

  public Integer getOid_moneda() throws BaseException { 
    supportRefresh();
    return oid_moneda;
  }

  public void setOid_moneda(Integer aOid_moneda) { 
    this.oid_moneda =  aOid_moneda;
  }

  public String getCod_producto() throws BaseException { 
    supportRefresh();
    return cod_producto;
  }

  public void setCod_producto(String aCod_producto) { 
    this.cod_producto =  aCod_producto;
  }

  public String getDesc_producto() throws BaseException { 
    supportRefresh();
    return desc_producto;
  }
  
  public String getDescProductoyCodigo() throws BaseException {
  	return this.getDesc_producto()+" - "+this.getCod_producto();
  }
  
  public String getNombreProveedoryCodigo() throws BaseException {
  	return this.getNombre_proveedor() +" - "+this.getCod_proveedor();
  }
  

  public void setDesc_producto(String aDesc_producto) { 
    this.desc_producto =  aDesc_producto;
  }

  public String getCod_proveedor() throws BaseException { 
    supportRefresh();
    return this.cod_proveedor;
  }

  public void setCod_proveedor(String aCod_proveedor) { 
    this.cod_proveedor =  aCod_proveedor;
  }

  public String getNombre_proveedor() throws BaseException { 
    supportRefresh();
    return nombre_proveedor;
  }

  public void setNombre_proveedor(String aNombre_proveedor) { 
    this.nombre_proveedor =  aNombre_proveedor;
  }

  public Integer getSigno() throws BaseException { 
    supportRefresh();
    return signo;
  }

  public void setSigno(Integer aSigno) { 
    this.signo =  aSigno;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static EstadisticaOC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstadisticaOC) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EstadisticaOC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstadisticaOC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getEstadisticaOC(
		 java.util.Date fechaDesde,
		 java.util.Date fechaHasta,
		 List listaClasif,
		 ISesion aSesion) throws BaseException {
	 return DBEstadisticaOC.getEstadisticaOC(fechaDesde,fechaHasta,listaClasif,aSesion);
 }
 
 public String getComprobante() throws BaseException {
	 return this.getTc_ext()+"-"+this.getLetra()+"-"+this.getLug_emi().toString()+"-"+this.getNro_ext().toString();
 }
 
 

}
