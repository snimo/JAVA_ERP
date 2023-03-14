package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.da.DBComproAjusteStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ComproAjusteStkDet extends ObjetoLogico {

  public ComproAjusteStkDet() {
  }

  public static String NICKNAME = "st.ComproAjusteStkDet";

  private List detallesAjuMovStkDet = new ArrayList();
  private boolean readDetallesAjuMovStkDet = true;

  private List detallesPartidasSeries = new ArrayList();
  private boolean readDetallesPartidasSeries = true;

  private ComproAjusteStk ajuste_stock_cab;
  private Producto producto;
  private TipoConfMovStkTalonario tipo_conf_mov;
  private Double cantidad;
  private UnidadMedida um_carga;
  private ConfMovStkTalonario conf_mov_stk;
  private CompoStkTalonarioAjuStk compo_stk_aju;
  private String observaciones;
  private Boolean activo;
  private UbicacionDeposito ubiDepo1;
  private UbicacionDeposito ubiDepo2;
  
  public void setUbiDepo1(UbicacionDeposito ubiDepo1) throws BaseException {
	  this.ubiDepo1 = ubiDepo1;
  }
  
  public void setUbiDepo2(UbicacionDeposito ubiDepo2) throws BaseException {
	  this.ubiDepo2 = ubiDepo2;
  }

  public ComproAjusteStk getAjuste_stock_cab() throws BaseException {
    supportRefresh();
    return ajuste_stock_cab;
  }

  public void setAjuste_stock_cab(ComproAjusteStk aAjuste_stock_cab) {
    this.ajuste_stock_cab =  aAjuste_stock_cab;
  }

  public Producto getProducto() throws BaseException {
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) {
    this.producto =  aProducto;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException {
    supportRefresh();
    return tipo_conf_mov;
  }

  public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) {
    this.tipo_conf_mov =  aTipo_conf_mov;
  }

  public Double getCantidad() throws BaseException {
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) {
    this.cantidad =  aCantidad;
  }

  public UnidadMedida getUm_carga() throws BaseException {
    supportRefresh();
    return um_carga;
  }

  public void setUm_carga(UnidadMedida aUm_carga) {
    this.um_carga =  aUm_carga;
  }

  public ConfMovStkTalonario getConf_mov_stk() throws BaseException {
    supportRefresh();
    return conf_mov_stk;
  }

  public void setConf_mov_stk(ConfMovStkTalonario aConf_mov_stk) {
    this.conf_mov_stk =  aConf_mov_stk;
  }

  public CompoStkTalonarioAjuStk getCompo_stk_aju() throws BaseException {
    supportRefresh();
    return compo_stk_aju;
  }

  public void setCompo_stk_aju(CompoStkTalonarioAjuStk aCompo_stk_aju) {
    this.compo_stk_aju =  aCompo_stk_aju;
  }

  public String getObservaciones() throws BaseException {
    supportRefresh();
    return observaciones;
  }

  public void setObservaciones(String aObservaciones) {
    this.observaciones =  aObservaciones;
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

 public static ComproAjusteStkDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproAjusteStkDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproAjusteStkDet findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ComproAjusteStkDet) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ComproAjusteStkDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproAjusteStkDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(ajuste_stock_cab, "Debe ingresar la Cabecera del Comprobante");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
    Validar.noNulo(um_carga, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(activo, "Debe ingresar si se encuentra o no en modo activo");
    
    if (this.isNew())
        prepararAjusteStkDetMov();
 }
 
 private void prepararAjusteStkDetMov() throws BaseException {
	 Iterator iterMovStkTal = getAjuste_stock_cab().getTipo_conf_mov().getMoviStockTalonarios().iterator();
	 while (iterMovStkTal.hasNext()) {
		 MovStockTalonarioDeposito movStkTalDep = (MovStockTalonarioDeposito) iterMovStkTal.next();
		 prepararMovUbi(movStkTalDep,movStkTalDep.getSecu().intValue());
	 }
 }

 private void prepararMovUbi(MovStockTalonarioDeposito movStkTalDep, int nroUbicacion) throws BaseException {
	 if (!((nroUbicacion>=1) && (nroUbicacion<=2)))
		 throw new ExceptionValidation(null,"El número de movimiento debe estar comprendido entre 1 y 2");
	   AjuStkMovDet ajuStkMovDet = (AjuStkMovDet)AjuStkMovDet.getNew(AjuStkMovDet.NICKNAME,getSesion());	 
     ajuStkMovDet.setDet_compro_aju_stk(this);
     ajuStkMovDet.setDeposito(movStkTalDep.getDeposito());
     ajuStkMovDet.setTipo_movi(movStkTalDep.getTipo_movimiento());
     ajuStkMovDet.setEstado_stock(movStkTalDep.getEstado_stock());
     
     movStkTalDep.getUbiDepoHabTalDefault().getUbicacion_deposito();
     if (nroUbicacion==1) {
    	 ubiDepo1 =
    		 movStkTalDep.getUbiDepoHabTalDefault().getUbicacion_deposito();
       if (this.ubiDepo1==null)
    	   throw new ExceptionValidation(null,"Debe ingresar la ubicación 1 del Depósito");
       ajuStkMovDet.setUbicacion_deposito(ubiDepo1);
     }
     else {
         if (this.ubiDepo2==null)
      	   throw new ExceptionValidation(null,"Debe ingresar la ubicación 2 del Depósito");
         ajuStkMovDet.setUbicacion_deposito(ubiDepo2);
     }
     ajuStkMovDet.setAfecta_stk_fisico(movStkTalDep.isAfectaStockFisico());
     ajuStkMovDet.setActivo(new Boolean(true));
     this.addDetAjuStkMovDet(ajuStkMovDet);
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

  public static List getDetallesComproAjuStk(ComproAjusteStk comproAjuStk,
                                             ISesion aSesion) throws BaseException {
    return  DBComproAjusteStkDet.getDetallesComproAjuStk(comproAjuStk,aSesion);
  }

  public void afterSave() throws BaseException {

    Iterator iterDetAjuStkMovDet = detallesAjuMovStkDet.iterator();
    while (iterDetAjuStkMovDet.hasNext()) {
      AjuStkMovDet ajuStkMovDet = (AjuStkMovDet) iterDetAjuStkMovDet.next();
      ajuStkMovDet.save();
      ajuStkMovDet = null;
    }
    iterDetAjuStkMovDet = null;

    Iterator iterDetPartSerie = detallesPartidasSeries.iterator();
    while (iterDetPartSerie.hasNext()) {
      AjuStkPartSerie ajuStkPartSerie = (AjuStkPartSerie) iterDetPartSerie.next();
      ajuStkPartSerie.save();
      ajuStkPartSerie = null;
    }
    iterDetPartSerie = null;

  }

  public void addDetAjuStkMovDet(AjuStkMovDet ajuStkMovDet) throws BaseException {
    this.detallesAjuMovStkDet.add(ajuStkMovDet);
    ajuStkMovDet.setDet_compro_aju_stk(this);
  }

  public void addDetPartSerie(AjuStkPartSerie ajuStkPartSerie) throws BaseException {
    this.detallesPartidasSeries.add(ajuStkPartSerie);
    ajuStkPartSerie.setAju_stk_det(this);
  }

  public List getDetallesAjuStkMovDet() throws BaseException {
    if (readDetallesAjuMovStkDet==true) {
      cargarListaFromBD(detallesAjuMovStkDet,AjuStkMovDet.getAjustesStkMovDet(this,getSesion()));
      readDetallesAjuMovStkDet = false;
      return detallesAjuMovStkDet;
    }
    else
      return detallesAjuMovStkDet;
  }

  public List getDetallesPartSerie() throws BaseException {
    if (readDetallesPartidasSeries==true) {
      detallesPartidasSeries.addAll(AjuStkPartSerie.getAjustesStkPartSerie(this,getSesion()));
      readDetallesPartidasSeries = false;
      return detallesPartidasSeries;
    }
    else
      return detallesPartidasSeries;
  }

}
