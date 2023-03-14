package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.da.DBMovStockTalonarioDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MovStockTalonarioDeposito extends ObjetoLogico {

  public static String ENTRADA = "ENTRADA";
  public static String SALIDA = "SALIDA";
	
  public MovStockTalonarioDeposito() {
  }

  public static String NICKNAME = "st.MovStockTalonarioDeposito";

  private TipoConfMovStkTalonario tipo_conf_mov;
  private Integer secu;
  private Deposito deposito;
  private EstadoStock estado_stock;
  private String tipo_movimiento;
  private Boolean afectaStockFisico;
  private Boolean activo;

  private List ubicacionesHabilitadas = new ArrayList();
  private boolean readUbicacionesHabilitadas = true;


  public void setAfectaStockFisico(Boolean aAfectaStockFisico) throws BaseException {
    this.afectaStockFisico = aAfectaStockFisico;
  }

  public Boolean isAfectaStockFisico() throws BaseException {
    return afectaStockFisico;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException {
    supportRefresh();
    return tipo_conf_mov;
  }

  public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) {
    this.tipo_conf_mov =  aTipo_conf_mov;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }
  
  public Integer getSignoStock() throws BaseException {
	  if (getTipo_movimiento().equals(ENTRADA))
		  return new Integer(1);
	  else
		  return new Integer(-1);
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
  }

  public String getTipo_movimiento() throws BaseException {
    supportRefresh();
    return tipo_movimiento;
  }

  public void setTipo_movimiento(String aTipo_movimiento) {
    this.tipo_movimiento =  aTipo_movimiento;
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

 public static MovStockTalonarioDeposito findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (MovStockTalonarioDeposito) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static MovStockTalonarioDeposito findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (MovStockTalonarioDeposito) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static MovStockTalonarioDeposito findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (MovStockTalonarioDeposito) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(secu, "Debe ingresar la secuencia");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de stock");
    Validar.noNulo(tipo_movimiento, "Debe ingresar el Tipo de Movimiento");
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

  public static List getMovStockByTipo(TipoConfMovStkTalonario tipoConfMovStkTalonario,
                                       ISesion aSesion) throws BaseException {
    return DBMovStockTalonarioDeposito.getMovStockByTipo(tipoConfMovStkTalonario,aSesion);
  }

  public List getUbicacionesHabilitadas() throws BaseException {
    if (readUbicacionesHabilitadas) {
      List listaUbiHabilitadas = UbiDepoHabTalonario.getUbicacionesHabilitadas(this,getSesion());
      ubicacionesHabilitadas.addAll(listaUbiHabilitadas);
      readUbicacionesHabilitadas = false;
    }
    return ubicacionesHabilitadas;
  }

  public void addUbicacionHabilitada(UbiDepoHabTalonario ubiDepoHabTalonario) throws BaseException {
    ubiDepoHabTalonario.setMov_stk_tal(this);
    ubicacionesHabilitadas.add(ubiDepoHabTalonario);
  }

  public void afterSave() throws BaseException {
    Iterator iterUbicacionesHabilitadas = ubicacionesHabilitadas.iterator();
    while (iterUbicacionesHabilitadas.hasNext()) {
      UbiDepoHabTalonario ubiHab = (UbiDepoHabTalonario) iterUbicacionesHabilitadas.next();
      ubiHab.save();
      ubiHab = null;
    }
    iterUbicacionesHabilitadas = null;
  }

  public static MovStockTalonarioDeposito getMovStockTalonarioDeposito(
              TipoConfMovStkTalonario tipoConfMovStkTalonario,
              Deposito deposito,
              ISesion aSesion)
              throws BaseException {
    return DBMovStockTalonarioDeposito.getMovStockTalonarioDeposito(tipoConfMovStkTalonario,deposito,aSesion);
  }

  public UbiDepoHabTalonario getUbiDepoHabTalDefault() throws BaseException {
    UbiDepoHabTalonario ubiDepoHabTalDef = null;
    Iterator iterUbiDepoHabTal =
        getUbicacionesHabilitadas().iterator();
    while (iterUbiDepoHabTal.hasNext()) {
      UbiDepoHabTalonario ubiDepoHabTal =
          (UbiDepoHabTalonario) iterUbiDepoHabTal.next();
      if (ubiDepoHabTal.isUsar_por_defecto().booleanValue()) {
        ubiDepoHabTalDef = ubiDepoHabTal;
        break;
      }
    }
    return ubiDepoHabTalDef;
  }
  
  public UbiDepoHabTalonario getUbiDepoHabTalDefault(Producto producto) throws BaseException {
	    UbiDepoHabTalonario ubiDepoHabTalDef = null;
	    Iterator iterUbiDepoHabTal =
	        getUbicacionesHabilitadas().iterator();
	    while (iterUbiDepoHabTal.hasNext()) {
	      UbiDepoHabTalonario ubiDepoHabTal =
	          (UbiDepoHabTalonario) iterUbiDepoHabTal.next();
	      if (ubiDepoHabTal.isUsar_por_defecto().booleanValue()) {
	    	if (getUbiHabMovProducto(ubiDepoHabTal.getUbicacion_deposito(),producto)==false) continue;
	        ubiDepoHabTalDef = ubiDepoHabTal;
	        break;
	      }
	    }
	    return ubiDepoHabTalDef;
	  }  
  
  public boolean getUbicacionHabilitadaMov(UbicacionDeposito ubicacionDeposito) throws BaseException {
	  if (ubicacionDeposito == null)
		  return false;
	  UbiDepoHabTalonario ubiDepHab = UbiDepoHabTalonario.getUbiDepoHabTalonario(this,ubicacionDeposito,getSesion());
	  if (ubiDepHab==null)
		  return false;
	  else if (!ubiDepHab.isActivo().booleanValue())
		  return false;
	  else {
		  if (!ubiDepHab.isHabilitado().booleanValue())
			  return false;
		  if (ubiDepHab.getUbicacion_deposito().isAllow_almacenar()!=null)
		  	if (!ubiDepHab.getUbicacion_deposito().isAllow_almacenar().booleanValue()) 
		  		return false;
	  }
	  return true;
  }
  
  public boolean getUbiHabMovProducto(UbicacionDeposito ubicacionDeposito,
		  							  Producto producto) throws BaseException {
	  boolean ok = getUbicacionHabilitadaMov(ubicacionDeposito);
	  if (ubicacionDeposito.isSolo_sku_habi()!=null)
	  	if (ubicacionDeposito.isSolo_sku_habi().booleanValue()) {
	  		if (ubicacionDeposito.getProductoHabilitado(producto)==null)
	  			return false;
	  }
	  return ok;
  }




}
