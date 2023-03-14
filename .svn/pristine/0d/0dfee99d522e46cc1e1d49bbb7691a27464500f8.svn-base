package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.da.DBTipoConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class TipoConfMovStkTalonario extends ObjetoLogico {

	public static final String CONTROL_CALIDAD = "CC";
	public static final String RECEPCION_MERC = "RM";
	public static final String AJUSTE_STOCK = "AS";
	public static final String CONTROL_CALIDAD_OK = "CCOK";
	public static final String CONTROL_CALIDAD_MAL = "CCMAL";
	public static final String DEVOLUCION_A_PROVEEDOR = "DEPRO";
	public static final String FACT_VTA_MOS = "FVTAM";
	public static final String NOTA_CREDITO = "NC";
	public static final String FACT_PEDIDO = "FACPE";
	public static final String NDI_CLIE = "NDICLIE";
	public static final String NCI_CLIE = "NCICLIE";
	public static final String NDCLIE = "NDCLIE";
	public static final String NCCLIE = "NCCLIE";
	public static final String SINDES = "SINDES";
	public static final String DEVOLUCION_VTAS = "DEVVTA";
	public static final String TRANSFERENCIA_INTERNAS = "TRINT";
	
	
	

	public TipoConfMovStkTalonario() {
	}

	public static String NICKNAME = "st.TipoConfMovStkTalonario";

	private ConfMovStkTalonario conf_mov_stk;

	private String codigo;

	private String descripcion;

	private Boolean activo;

	private String tipoMovimiento;

	private List movimientosStockTalonario = new ArrayList();

	private boolean readMovimientosStockTalonario = true;

	public ConfMovStkTalonario getConf_mov_stk() throws BaseException {
		supportRefresh();
		return conf_mov_stk;
	}

	public void setConf_mov_stk(ConfMovStkTalonario aConf_mov_stk) {
		this.conf_mov_stk = aConf_mov_stk;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public void setTipoMovimiento(String aTipoMovimiento) throws BaseException {
		this.tipoMovimiento = aTipoMovimiento;
	}

	public String getTipoMovimiento() throws BaseException {
		supportRefresh();
		return tipoMovimiento;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TipoConfMovStkTalonario findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TipoConfMovStkTalonario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoConfMovStkTalonario findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (TipoConfMovStkTalonario) getObjectByOidProxy(NICKNAME, oid,
				aSesion);
	}

	public static TipoConfMovStkTalonario findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (TipoConfMovStkTalonario) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(conf_mov_stk, "Debe ingresar el Talonario");
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(tipoMovimiento,"Debe ingresar el Tipo de Movimiento");
		
	}

	public static List getTiposMovimientos(
			ConfMovStkTalonario confMovStkTalonario, ISesion aSesion)
			throws BaseException {
		return DBTipoConfMovStkTalonario.getTiposMovimientos(
				confMovStkTalonario, aSesion);
	}

	public List getMoviStockTalonarios() throws BaseException {
		if (readMovimientosStockTalonario) {
			List listaMovStockTalonarios = MovStockTalonarioDeposito
					.getMovStockByTipo(this, getSesion());
			movimientosStockTalonario.addAll(listaMovStockTalonarios);
			readMovimientosStockTalonario = false;
		}
		return movimientosStockTalonario;
	}

	public void addMoviStockTalonario(
			MovStockTalonarioDeposito movStockTalonarioDeposito)
			throws BaseException {
		movStockTalonarioDeposito.setTipo_conf_mov(this);
		movimientosStockTalonario.add(movStockTalonarioDeposito);
	}

	public void afterSave() throws BaseException {
		Iterator iterMovStockTalo = movimientosStockTalonario.iterator();
		while (iterMovStockTalo.hasNext()) {
			MovStockTalonarioDeposito movStockTalonarioDeposito = (MovStockTalonarioDeposito) iterMovStockTalo
					.next();
			movStockTalonarioDeposito.save();
			movStockTalonarioDeposito = null;
		}
		iterMovStockTalo = null;
	}
	
	public static HashTableDatos getTiposMovimientos() throws BaseException {
		HashTableDatos tiposMovimientos = new HashTableDatos();
		tiposMovimientos.put(CONTROL_CALIDAD,"Control de calidad");
		tiposMovimientos.put(RECEPCION_MERC,"Recepción de Mercadería");
		tiposMovimientos.put(AJUSTE_STOCK,"Ajuste de Stock");
		tiposMovimientos.put(CONTROL_CALIDAD_OK,"Control Calidad OK");
		tiposMovimientos.put(CONTROL_CALIDAD_MAL,"Control Calidad Mal");
		tiposMovimientos.put(DEVOLUCION_A_PROVEEDOR,"Devolución a Proveedor");
		tiposMovimientos.put(FACT_VTA_MOS,"Facturación Vta. Mostrador");
		tiposMovimientos.put(NOTA_CREDITO,"Nota de Crédito");
		tiposMovimientos.put(FACT_PEDIDO,"Facturaión Pedido");
		tiposMovimientos.put(NDI_CLIE,"Nota Debito Interna Cliente");
		tiposMovimientos.put(NCI_CLIE,"Nota Credito Interna Cliente");
		tiposMovimientos.put(NDCLIE, "Nota Debito Cliente");
		tiposMovimientos.put(NCCLIE, "Nota Credito Cliente");
		tiposMovimientos.put(SINDES, "Sin Despacho");
		tiposMovimientos.put(DEVOLUCION_VTAS, "Devolución Ventas");
		tiposMovimientos.put(TRANSFERENCIA_INTERNAS,"Transferencias Internas");
		return tiposMovimientos; 
	}
	
	public static List getTiposMovimientosByTipo(ConfMovStkTalonario confMovStkTalonario,
			 	   String tipoMov,	
			       ISesion aSesion) throws BaseException {
      return DBTipoConfMovStkTalonario.getTiposMovimientosByTipo(confMovStkTalonario,tipoMov,aSesion);
	}
	
	 public static List getTiposMovimientosByTipoCC(ConfMovStkTalonario confMovStkTalonario,
			  ISesion aSesion) throws BaseException {
		  return DBTipoConfMovStkTalonario.getTiposMovimientosByTipoCC(confMovStkTalonario,aSesion);
	  } 
	  
	  public static List getTiposMovimientosByTipoInfRec(ConfMovStkTalonario confMovStkTalonario,
			  ISesion aSesion) throws BaseException {
		  return DBTipoConfMovStkTalonario.getTiposMovimientosByTipoInfRec(confMovStkTalonario,aSesion);
	  }   	
	  
	  public static List getTiposMovimientosByTipoCCOK(ConfMovStkTalonario confMovStkTalonario,
			  	ISesion aSesion) throws BaseException {
		  return DBTipoConfMovStkTalonario.getTiposMovimientosByTipoCCOK(confMovStkTalonario,aSesion);
	  }
	  
	  public static List getTiposMovimientosByTipoCCMal(ConfMovStkTalonario confMovStkTalonario,
			  ISesion aSesion) throws BaseException {
		  return DBTipoConfMovStkTalonario.getTiposMovimientosByTipoCCMal(confMovStkTalonario,aSesion);
	  }
	  
	  public boolean isTipoMovSinDespacho() throws BaseException {
		  if (this.getTipoMovimiento().equals(SINDES))
			  return true;
		  else
			  return false;
	  }
	  	  
	

}
