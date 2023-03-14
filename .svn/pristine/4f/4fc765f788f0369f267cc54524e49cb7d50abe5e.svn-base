package com.srn.erp.compras.bm;

import java.util.List;

import com.srn.erp.compras.da.DBConsultaEstadoRequisiciones;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConsultaEstadoRequisiciones extends ObjetoLogico { 

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

public ConsultaEstadoRequisiciones() { 
  }

  public static String NICKNAME = "cp.ConsultaEstadoRequisiciones";

  private TipoComprobante tipo_comprobante;
  private String tc_ext;
  private String letra;
  private LugarEmision lugar_emi;
  private Integer nro_lugar_emi;
  private Integer nroExt;
  private String comen_requi;
  private Usuario usuario;
  private SectorCompra sectorCompra;
  private Talonario talonario;
  private Sucursal sucursal;
  private Integer oid_req_det;
  private Producto producto;
  private String cod_producto;
  private String desc_producto;
  private String desc_adic_sku;
  private Integer nro_renglon;
  private Double cant_solictada;
  private Double cant_comprada;
  private UnidadMedida unidad_medida;
  private java.util.Date fec_emision;
  private java.util.Date fec_requerida;
  private Integer decision_autoriz;
  private Boolean anulada;
  private Boolean solo_cotizar;
  private String comen_detalle;
  private Boolean pend_sol_cotiz;
  private Boolean pendCompra;
  
  public Boolean isPendCompra() throws BaseException { 
	    supportRefresh();
	    return pendCompra;
  }

  public void setPendCompra(Boolean aPendCompra) { 
	this.pendCompra = aPendCompra;
  }
  
  public TipoComprobante getTipo_comprobante() throws BaseException { 
    supportRefresh();
    return tipo_comprobante;
  }

  public void setTipo_comprobante(TipoComprobante aTipo_comprobante) { 
    this.tipo_comprobante =  aTipo_comprobante;
  }

  public String getTc_ext() throws BaseException { 
    supportRefresh();
    return tc_ext;
  }

  public void setTc_ext(String aTc_ext) { 
    this.tc_ext =  aTc_ext;
  }

  public Integer getNroExt() throws BaseException { 
	supportRefresh();
	return nroExt;
  }

  public void setSectorCompra(SectorCompra aSectorCompra) { 
	    this.sectorCompra =  aSectorCompra;
 }

  public SectorCompra getSectorCompra() throws BaseException { 
	supportRefresh();
	return sectorCompra;
  }  
  
  public void setNroExt(Integer aNroExt) { 
	this.nroExt =  aNroExt;
  }  
  
  public String getLetra() throws BaseException { 
    supportRefresh();
    return letra;
  }

  public void setLetra(String aLetra) { 
    this.letra =  aLetra;
  }

  public LugarEmision getLugar_emi() throws BaseException { 
    supportRefresh();
    return lugar_emi;
  }

  public void setLugar_emi(LugarEmision aLugar_emi) { 
    this.lugar_emi =  aLugar_emi;
  }

  public Integer getNro_lugar_emi() throws BaseException { 
    supportRefresh();
    return nro_lugar_emi;
  }

  public void setNro_lugar_emi(Integer aNro_lugar_emi) { 
    this.nro_lugar_emi =  aNro_lugar_emi;
  }

  public String getComen_requi() throws BaseException { 
    supportRefresh();
    return comen_requi;
  }

  public void setComen_requi(String aComen_requi) { 
    this.comen_requi =  aComen_requi;
  }

  public Usuario getUsuario() throws BaseException { 
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) { 
    this.usuario =  aUsuario;
  }

  public Talonario getTalonario() throws BaseException { 
    supportRefresh();
    return talonario;
  }

  public void setTalonario(Talonario aTalonario) { 
    this.talonario =  aTalonario;
  }

  public Sucursal getSucursal() throws BaseException { 
    supportRefresh();
    return sucursal;
  }

  public void setSucursal(Sucursal aSucursal) { 
    this.sucursal =  aSucursal;
  }

  public Integer getOid_req_det() throws BaseException { 
    supportRefresh();
    return oid_req_det;
  }

  public void setOid_req_det(Integer aOid_req_det) { 
    this.oid_req_det =  aOid_req_det;
  }

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
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

  public void setDesc_producto(String aDesc_producto) { 
    this.desc_producto =  aDesc_producto;
  }

  public String getDesc_adic_sku() throws BaseException { 
    supportRefresh();
    return desc_adic_sku;
  }

  public void setDesc_adic_sku(String aDesc_adic_sku) { 
    this.desc_adic_sku =  aDesc_adic_sku;
  }

  public Integer getNro_renglon() throws BaseException { 
    supportRefresh();
    return nro_renglon;
  }

  public void setNro_renglon(Integer aNro_renglon) { 
    this.nro_renglon =  aNro_renglon;
  }

  public Double getCant_solicitada() throws BaseException { 
    supportRefresh();
    return cant_solictada;
  }

  public void setCant_solictada(Double aCant_solictada) { 
    this.cant_solictada =  aCant_solictada;
  }

  public Double getCant_comprada() throws BaseException { 
    supportRefresh();
    return cant_comprada;
  }

  public void setCant_comprada(Double aCant_comprada) { 
    this.cant_comprada =  aCant_comprada;
  }

  public UnidadMedida getUnidad_medida() throws BaseException { 
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) { 
    this.unidad_medida =  aUnidad_medida;
  }

  public java.util.Date getFec_emision() throws BaseException { 
    supportRefresh();
    return fec_emision;
  }

  public void setFec_emision(java.util.Date aFec_emision) { 
    this.fec_emision =  aFec_emision;
  }

  public java.util.Date getFec_requerida() throws BaseException { 
    supportRefresh();
    return fec_requerida;
  }

  public void setFec_requerida(java.util.Date aFec_requerida) { 
    this.fec_requerida =  aFec_requerida;
  }

  public Integer getDecision_autoriz() throws BaseException { 
    supportRefresh();
    return decision_autoriz;
  }

  public void setDecision_autoriz(Integer aDecision_autoriz) { 
    this.decision_autoriz =  aDecision_autoriz;
  }

  public Boolean isAnulada() throws BaseException { 
    supportRefresh();
    return anulada;
  }

  public void setAnulada(Boolean aAnulada) { 
    this.anulada =  aAnulada;
  }

  public Boolean isSolo_cotizar() throws BaseException { 
    supportRefresh();
    return solo_cotizar;
  }

  public void setSolo_cotizar(Boolean aSolo_cotizar) { 
    this.solo_cotizar =  aSolo_cotizar;
  }

  public String getComen_detalle() throws BaseException { 
    supportRefresh();
    return comen_detalle;
  }

  public void setComen_detalle(String aComen_detalle) { 
    this.comen_detalle =  aComen_detalle;
  }

  public Boolean isPend_sol_cotiz() throws BaseException { 
    supportRefresh();
    return pend_sol_cotiz;
  }

  public void setPend_sol_cotiz(Boolean aPend_sol_cotiz) { 
    this.pend_sol_cotiz =  aPend_sol_cotiz;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConsultaEstadoRequisiciones findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConsultaEstadoRequisiciones) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConsultaEstadoRequisiciones findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConsultaEstadoRequisiciones) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getEstadosRequisiciones(HashTableDatos condiciones, ISesion aSesion)
	throws BaseException {
	 return DBConsultaEstadoRequisiciones.getEstadosRequisiciones(condiciones,aSesion);
 }
 
 public static boolean usaClasificadorComprasParaRequisicion(ISesion aSesion) throws BaseException {
	ValorParametro valorParamUsaClasifCompras = ValorParametro.findByCodigoParametro("USAR_CLASIF_GCOMPRAS_REQUI",aSesion);
	return valorParamUsaClasifCompras.getBoolean();
 }

 public static ClasificadorEntidad getClasifGrupoCompras(ISesion aSesion) throws BaseException {
	ValorParametro valorClasifGrupoCompras = ValorParametro.findByCodigoParametro("CLASIF_GRUPO_COMP_EN_REQUI",aSesion);
	ClasificadorEntidad clasifEntidad = ClasificadorEntidad.findByOid(valorClasifGrupoCompras.getOidObjNeg(),aSesion);
	return clasifEntidad;
 } 
 
 public Double getcantPendCompra() throws BaseException {
	 if (!isPendCompra().booleanValue())
		 return new Double(0);
	 else {
	   CalculadorMoney calcCantPendCompra = new CalculadorMoney(new NumeroBase(getCant_solicitada()));
	   calcCantPendCompra.restar(new NumeroBase(getCant_comprada()));
	   return new Double(calcCantPendCompra.getResultMoney().doubleValue());
	 }
 }
 
}
