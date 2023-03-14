package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.da.DBSaldoStockPorItemDepoEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class SaldoStockPorItemDepoEst extends ObjetoLogico { 

  @Override
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

public SaldoStockPorItemDepoEst() { 
  }

  public static String NICKNAME = "st.SaldoStockPorItemDepoEst";

  private Deposito deposito;
  private Producto producto;
  private UnidadMedida unidad_medida;
  private EstadoStock estado_stock;
  private ComproCab comprobante;
  private Integer oid_cco_det;
  private Money saldo;
  private Boolean tiene_saldo;

  public Deposito getDeposito() throws BaseException { 
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) { 
    this.deposito =  aDeposito;
  }

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
  }

  public UnidadMedida getUnidad_medida() throws BaseException { 
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) { 
    this.unidad_medida =  aUnidad_medida;
  }

  public EstadoStock getEstado_stock() throws BaseException { 
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) { 
    this.estado_stock =  aEstado_stock;
  }

  public ComproCab getComprobante() throws BaseException { 
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) { 
    this.comprobante =  aComprobante;
  }

  public Integer getOid_cco_det() throws BaseException { 
    supportRefresh();
    return oid_cco_det;
  }

  public void setOid_cco_det(Integer aOid_cco_det) { 
    this.oid_cco_det =  aOid_cco_det;
  }

  public Money getSaldo() throws BaseException { 
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Money aSaldo) { 
    this.saldo =  aSaldo;
  }

  public Boolean isTiene_saldo() throws BaseException { 
    supportRefresh();
    return tiene_saldo;
  }

  public void setTiene_saldo(Boolean aTiene_saldo) { 
    this.tiene_saldo =  aTiene_saldo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static SaldoStockPorItemDepoEst findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SaldoStockPorItemDepoEst) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SaldoStockPorItemDepoEst findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SaldoStockPorItemDepoEst) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
    Validar.noNulo(comprobante, "Debe ingresar el Comprobante");
    Validar.noNulo(oid_cco_det, "Debe ingresat el Oid del Detalle");
    Validar.noNulo(tiene_saldo, "Debe ingresar si tiene o no saldo");
 }
 
 public static SaldoStockPorItemDepoEst getSaldoStockPorItemDepoEst(
		  Deposito deposito,
		  Producto producto,
		  EstadoStock estado,
		  ComproCab comproCab,
		  Integer oidCCODet,
          ISesion aSesion)
         throws BaseException {
	  return DBSaldoStockPorItemDepoEst.getSaldoStockPorItemDepoEst(
			  deposito,producto,estado,comproCab,oidCCODet,aSesion);
 }
 

}
