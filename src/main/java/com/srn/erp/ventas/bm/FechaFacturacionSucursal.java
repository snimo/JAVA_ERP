package com.srn.erp.ventas.bm;

import java.util.Date;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.da.DBFechaFacturacionSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.ISucursal;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FechaFacturacionSucursal extends ObjetoLogico {

  public FechaFacturacionSucursal() {
  }

  public static String NICKNAME = "ve.FechaFacturacionSucursal";

  private Sucursal sucursal;
  private java.util.Date fecha_anterior;
  private java.util.Date fecha_actual;
  private Boolean activo;

  public Sucursal getSucursal() throws BaseException {
    supportRefresh();
    return sucursal;
  }

  public void setSucursal(Sucursal aSucursal) {
    this.sucursal =  aSucursal;
  }

  public java.util.Date getFecha_anterior() throws BaseException {
    supportRefresh();
    return fecha_anterior;
  }

  public void setFecha_anterior(java.util.Date aFecha_anterior) {
    this.fecha_anterior =  aFecha_anterior;
  }

  public java.util.Date getFecha_actual() throws BaseException {
    supportRefresh();
    return fecha_actual;
  }

  public void setFecha_actual(java.util.Date aFecha_actual) {
    this.fecha_actual =  aFecha_actual;
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

 public static FechaFacturacionSucursal findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (FechaFacturacionSucursal) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static FechaFacturacionSucursal findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (FechaFacturacionSucursal) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(sucursal, "Debe ingresar el Sucursal");
    Validar.noNulo(fecha_actual, "Debe ingresar la fecha de Facturación");
 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static FechaFacturacionSucursal getFechaFacturacion(Sucursal aSucursal,
                                                             ISesion aSesion)
                                                      throws BaseException {
  	if (isFechaFacturacionAutomatica(aSesion))
  		return FechaFacturacionSucursal.getFechaFacturaSucAHoy(aSucursal,aSesion);
  	else
      return DBFechaFacturacionSucursal.getFechaFacturacion(aSucursal,aSesion);

  }

  public static FechaFacturacionSucursal getFechaFacturacion(ISucursal aSucursal,
                                                             ISesion aSesion)
                                                      throws BaseException {
    Sucursal sucursal = Sucursal.findByOid(aSucursal.getOIDInteger(),aSesion);
  	if (isFechaFacturacionAutomatica(aSesion))
  		return FechaFacturacionSucursal.getFechaFacturaSucAHoy(sucursal,aSesion);
  	else
  		return DBFechaFacturacionSucursal.getFechaFacturacion(sucursal,aSesion);

  }
  
  public static boolean isFechaFacturacionAutomatica(ISesion aSesion) throws BaseException {
	   return ValorParametro.findByCodigoParametro("FECHA_FACTURACION_AUTO",aSesion).getBoolean();
  }
  
  private static FechaFacturacionSucursal getFechaFacturaSucAHoy(Sucursal aSucursal,ISesion aSesion) throws BaseException {
  	FechaFacturacionSucursal fecFactSucAHoy = 
  		(FechaFacturacionSucursal)FechaFacturacionSucursal.getNew(FechaFacturacionSucursal.NICKNAME,aSesion);
  	fecFactSucAHoy.setSucursal(aSucursal);
  	fecFactSucAHoy.setFecha_actual(Fecha.getFechaActual());
  	fecFactSucAHoy.setFecha_anterior(Fecha.getFechaActual());
  	return fecFactSucAHoy; 
  }
  
 



}
