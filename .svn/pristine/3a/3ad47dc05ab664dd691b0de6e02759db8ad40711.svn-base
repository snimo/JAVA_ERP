package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AgrupadorDeposito extends ObjetoLogico { 

  public AgrupadorDeposito() { 
  }
  
  private List detallesDepositos = new ArrayList();
  private boolean readDetallesDepositos = true;
 

  public static String NICKNAME = "st.AgrupadorDeposito";

  private String codigo;
  private String descripcion;
  private Boolean activo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
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

 public static AgrupadorDeposito findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AgrupadorDeposito) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static AgrupadorDeposito findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (AgrupadorDeposito) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static AgrupadorDeposito findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AgrupadorDeposito) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getAgrupadoresDepositoDet() throws BaseException {
   if (this.readDetallesDepositos) {
     List listaAgrupadoresDepoDet = AgrupadorDepositoDet.getDetallesAgrupadorDeposito(this,getSesion());
     this.detallesDepositos.addAll(listaAgrupadoresDepoDet);
     this.readDetallesDepositos = false;
   }
   return this.detallesDepositos;
 }

 public void addAgrupadorDepositoDet(AgrupadorDepositoDet aAgrupadorDepositoDet) throws BaseException {
	 aAgrupadorDepositoDet.setAgrupador_deposito(this);
   this.detallesDepositos.add(aAgrupadorDepositoDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterAgrupadorDepositosDet = this.detallesDepositos.iterator();
   while (iterAgrupadorDepositosDet.hasNext()) {
     AgrupadorDepositoDet agrupadorDepositoDet = (AgrupadorDepositoDet) iterAgrupadorDepositosDet.next();
     agrupadorDepositoDet.save();
     agrupadorDepositoDet = null;
   }
   iterAgrupadorDepositosDet = null;
 }
 
 public static AgrupadorDeposito getAgruDepoDefaultAnalisisCompras(ISesion aSesion) throws BaseException {
	Integer oidAgrupadorDeposito =
	       ValorParametro.findByCodigoParametro("AGRUP_DEPDEF_DETPED_PARA_OC ",aSesion).getOidObjNeg();
	AgrupadorDeposito agrupadorDeposito = AgrupadorDeposito.findByOid(oidAgrupadorDeposito,aSesion);
	return agrupadorDeposito;
 }
 
 public Money getSaldoLibreStock(Producto producto) throws BaseException {
	 CalculadorMoney totStockLibre = new CalculadorMoney(new Money(0));
	 Iterator iterAgrupadorDet = this.getAgrupadoresDepositoDet().iterator();
	 while (iterAgrupadorDet.hasNext()) {
		 
		 AgrupadorDepositoDet agrupadorDepositoDet = (AgrupadorDepositoDet) iterAgrupadorDet.next();
		 SaldoStkProdPorEstado saldoStkProdPorEstdo = 
			 producto.getSaldoStkProdPorEstado(agrupadorDepositoDet.getDeposito(), EstadoStock.getEstadoStockLibre(this.getSesion()));
		 
		 if (saldoStkProdPorEstdo!=null)
			 totStockLibre.sumar(new Money(saldoStkProdPorEstdo.getSaldo().doubleValue()));
		 
	 }
	 return totStockLibre.getResultMoney();
 }
 

}
