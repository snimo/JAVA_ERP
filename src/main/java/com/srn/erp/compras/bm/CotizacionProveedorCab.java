package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBCotizacionProveedorCab;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CotizacionProveedorCab extends ComproCab { 

  public static final int ESTADO_EN_EVALUACION = 1;
  public static final int ESTADO_ADJUDICADA = 2;
  public static final int ESTADO_NO_ADJUDICADA = 3;
  public static final int ESTADO_SOLO_COTIZAR = 4;
  
	
  public CotizacionProveedorCab() { 
  }

  public static String NICKNAME = "cp.CotizacionProveedorCab";

  private SolicitudCotizProvCab solicitud_cotiz_prov;
  private Proveedor proveedor;
  private java.util.Date vigencia_desde;
  private java.util.Date vigencia_hasta;
  private CondicionCompra cond_pago_1;
  private Money dto_cond_pago_1;
  private CondicionCompra cond_pago_2;
  private Money dto_cond_pago_2;
  private Integer estadoAdjudicacion;
  private java.util.Date fechaEstadoAdjudicacion;
  private Usuario usuarioAdjudicacion;
  private MotivoDecisionAdjudicacion motDecAdju;
  private String comentarioAdju;
  private Moneda moneda;
  private boolean cotizacionAbierta;
  
    
  private ComproCab comprobante;
  
  
  public void setMoneda(Moneda aMoneda) throws BaseException {
	  this.moneda = aMoneda;
  }
  
  public Moneda getMoneda() throws BaseException {
	  supportRefresh();
	  return moneda;
  }
  
  public void setCotizacionAbierta(boolean aCotizacionAbierta) throws BaseException {
	  this.cotizacionAbierta = aCotizacionAbierta;
  }
  
  public boolean isCotizacionAbierta() throws BaseException {
	  supportRefresh();
	  return this.cotizacionAbierta;
  }
  
  
  public void setEstadoAdjudicacion(Integer aEstadoAdjudicacion) throws BaseException {
	  this.estadoAdjudicacion = aEstadoAdjudicacion;
  }
  
  public Integer getEstadoAdjudicacion() throws BaseException {
	  supportRefresh();
	  return estadoAdjudicacion;
  }
  
  public void setFechaEstadoAdjudicacion(java.util.Date aFechaEstadoAdjudicacion) throws BaseException {
	  this.fechaEstadoAdjudicacion = aFechaEstadoAdjudicacion;
  }
  
  public java.util.Date getFechaEstadoAdjudicacion() throws BaseException {
	  supportRefresh();
	  return fechaEstadoAdjudicacion;
  }
  
  public void setUsuarioAdjudicacion(Usuario aUsuarioAdjudicacion) throws BaseException {
	  this.usuarioAdjudicacion = aUsuarioAdjudicacion;
  }
  
  public Usuario getUsuarioAdjudicacion() throws BaseException {
	  supportRefresh();
	  return usuarioAdjudicacion;
  }
  
  public void setMotivoDecisionAdjudicacion(MotivoDecisionAdjudicacion aMotivo) throws BaseException {
	  this.motDecAdju = aMotivo;
  }
  
  public MotivoDecisionAdjudicacion getMotivoDecisionAdjudicacion() throws BaseException {
	  supportRefresh();
	  return this.motDecAdju;
  }
  
  public void setComentarioAdjudicacion(String aComentario) throws BaseException {
	  this.comentarioAdju = aComentario;
  }
  
  public String getComentarioAdjudicacion() throws BaseException {
	  supportRefresh();
	  return comentarioAdju;
  }
  
  public ComproCab getComprobante() throws BaseException {
		return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
  }  
  
  private List detallesCotizaciones = new ArrayList();
  private boolean readDetallesCotizaciones = true;
  

  public SolicitudCotizProvCab getSolicitud_cotiz_prov() throws BaseException { 
    supportRefresh();
    return solicitud_cotiz_prov;
  }

  public void setSolicitud_cotiz_prov(SolicitudCotizProvCab aSolicitud_cotiz_prov) { 
    this.solicitud_cotiz_prov =  aSolicitud_cotiz_prov;
  }

  public Proveedor getProveedor() throws BaseException { 
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) { 
    this.proveedor =  aProveedor;
  }

  public java.util.Date getVigencia_desde() throws BaseException { 
    supportRefresh();
    return vigencia_desde;
  }

  public void setVigencia_desde(java.util.Date aVigencia_desde) { 
    this.vigencia_desde =  aVigencia_desde;
  }

  public java.util.Date getVigencia_hasta() throws BaseException { 
    supportRefresh();
    return vigencia_hasta;
  }

  public void setVigencia_hasta(java.util.Date aVigencia_hasta) { 
    this.vigencia_hasta =  aVigencia_hasta;
  }

  public CondicionCompra getCond_pago_1() throws BaseException { 
    supportRefresh();
    return cond_pago_1;
  }

  public void setCond_pago_1(CondicionCompra aCond_pago_1) { 
    this.cond_pago_1 =  aCond_pago_1;
  }

  public Money getDto_cond_pago_1() throws BaseException { 
    supportRefresh();
    return dto_cond_pago_1;
  }

  public void setDto_cond_pago_1(Money aDto_cond_pago_1) { 
    this.dto_cond_pago_1 =  aDto_cond_pago_1;
  }

  public CondicionCompra getCond_pago_2() throws BaseException { 
    supportRefresh();
    return cond_pago_2;
  }

  public void setCond_pago_2(CondicionCompra aCond_pago_2) { 
    this.cond_pago_2 =  aCond_pago_2;
  }

  public Money getDto_cond_pago_2() throws BaseException { 
    supportRefresh();
    return dto_cond_pago_2;
  }

  public void setDto_cond_pago_2(Money aDto_cond_pago_2) { 
    this.dto_cond_pago_2 =  aDto_cond_pago_2;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CotizacionProveedorCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CotizacionProveedorCab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CotizacionProveedorCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (CotizacionProveedorCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }  
 
 public void beforeSave() throws BaseException { 	 
	super.beforeSave();
    Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
    Validar.noNulo(vigencia_desde, "Debe ingresar la Fecha de Vigencia Desde");
    Validar.noNulo(vigencia_hasta, "Debe ingresar la Fecha de Vigencia Hasta");
    Validar.noNulo(cond_pago_1, "Debe ingresar la condición de Pago");
    Validar.noNulo(moneda,"Debe ingresar la Moneda");
    
	if (this.isNew()) {
		this.setComprobante(this);
		this.setEstado(ComproCab.ESTADO_ALTA);
		this.setActivo(new Boolean(true));
	}
	beforeSaveComprobante(this);
    
 }

public List getDetallesCotizaciones() throws BaseException {
    if (readDetallesCotizaciones) {
      List listaDetallesCotizaciones = CotizacionProveedorDet.getCotizacionesProveedoresDet(this,getSesion());
      detallesCotizaciones.addAll(listaDetallesCotizaciones);
      readDetallesCotizaciones = false;
    }
    return detallesCotizaciones;
  }

  public void addDetalle(CotizacionProveedorDet cotizProvDet) throws BaseException {
	  cotizProvDet.setCotizacion_proveedor(this);
    detallesCotizaciones.add(cotizProvDet);
  }

  public void afterSave() throws BaseException {
    Iterator iterDetallesCotizacion = detallesCotizaciones.iterator();
    while (iterDetallesCotizacion.hasNext()) {
      CotizacionProveedorDet cotizacionProveedorDet = (CotizacionProveedorDet) iterDetallesCotizacion.next();
      cotizacionProveedorDet.save();
      cotizacionProveedorDet = null;
    }
    iterDetallesCotizacion = null;
  }
  
  public static List getCotizacionesProvCab(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return DBCotizacionProveedorCab.getCotizacionesProvCab(condiciones,aSesion);
  }

protected void onNew() throws BaseException {
	// TODO Auto-generated method stub
	super.onNew();
	this.estadoAdjudicacion = new Integer(ESTADO_EN_EVALUACION);
	this.usuarioAdjudicacion = getSesion().getLogin().getUsuario();
	this.fechaEstadoAdjudicacion = Fecha.getFechaActual();
} 

  public static HashTableDatos getEstadosCotizacion() throws BaseException {
	  HashTableDatos estados = new HashTableDatos();
	  estados.put(new Integer(ESTADO_EN_EVALUACION),"En evaluación");
	  estados.put(new Integer(ESTADO_ADJUDICADA),"Adjudicada");
	  estados.put(new Integer(ESTADO_NO_ADJUDICADA),"No Adjudicada");
	  estados.put(new Integer(ESTADO_SOLO_COTIZAR),"Solo Cotizar");
	  return estados;
	  
  }
  
  public boolean isEnEvaluacion() throws BaseException {
	  if (this.getEstadoAdjudicacion().intValue() == ESTADO_EN_EVALUACION)
		  return true;
	  else
		  return false;
  }
  
  public boolean isSoloCotizar() throws BaseException {
	  if (this.getEstadoAdjudicacion().intValue() == ESTADO_SOLO_COTIZAR)
		  return true;
	  else
		  return false;
  }  
  
  public boolean isAdjudicado() throws BaseException {
	  if (this.getEstadoAdjudicacion().intValue() == ESTADO_ADJUDICADA)
		  return true;
	  else
		  return false;
  } 
  
  public boolean isNoAdjudicado() throws BaseException {
	  if (this.getEstadoAdjudicacion().intValue() == ESTADO_NO_ADJUDICADA)
		  return true;
	  else
		  return false;
  }   
  
  public void adjudicar() throws BaseException {
	  
	  if (!this.isActivo().booleanValue())
		  throw new ExceptionValidation(null,"El comprobante "+this.getCodigo()+" se encuentra anulado");
	  
	  if (!((isEnEvaluacion() || isSoloCotizar())))
		  throw new ExceptionValidation(null,"El comprobante "+this.getCodigo()+" se encuentra en estado "+getDescEstadoCotiz()+".El mismo no puede ajudicarse.");
	  
	  setEstadoAdjudicacion(new Integer(ESTADO_ADJUDICADA));
	  setUsuarioAdjudicacion(getSesion().getLogin().getUsuario());
	  setFechaEstadoAdjudicacion(Fecha.getFechaActual());
	  
  }
  
  public void noAdjudicar() throws BaseException {
	  
	  if (!this.isActivo().booleanValue())
		  throw new ExceptionValidation(null,"El comprobante "+this.getCodigo()+" se encuentra anulado");
	    
	  setEstadoAdjudicacion(new Integer(ESTADO_NO_ADJUDICADA));
	  setUsuarioAdjudicacion(getSesion().getLogin().getUsuario());
	  setFechaEstadoAdjudicacion(Fecha.getFechaActual());
	  
  }  
  
  public String getDescEstadoCotiz() throws BaseException {
	  HashTableDatos estados = getEstadosCotizacion();
	  String descripcion  = (String)estados.get(getEstadoAdjudicacion());
	  return descripcion;
  }
  
 		  
  
  
  

}
