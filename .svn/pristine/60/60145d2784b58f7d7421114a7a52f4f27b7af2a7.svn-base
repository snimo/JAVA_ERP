package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAutorizadorCompra;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AutorizadorCompra extends ObjetoLogico {
	
  private List autorizadoresMontoCompras = new ArrayList();
  private boolean readAutorizadoresMontoCompras = true;

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

public AutorizadorCompra() { 
  }

  public static String NICKNAME = "cp.AutorizadorCompra";

  private EsquemaAutorizCompras esquema_autoriz;
  private ValorClasificadorEntidad valor_clasificador;
  private Moneda moneda;

  public EsquemaAutorizCompras getEsquema_autoriz() throws BaseException { 
    supportRefresh();
    return esquema_autoriz;
  }

  public void setEsquema_autoriz(EsquemaAutorizCompras aEsquema_autoriz) { 
    this.esquema_autoriz =  aEsquema_autoriz;
  }

  public ValorClasificadorEntidad getValor_clasificador() throws BaseException { 
    supportRefresh();
    return valor_clasificador;
  }

  public void setValor_clasificador(ValorClasificadorEntidad aValor_clasificador) { 
    this.valor_clasificador =  aValor_clasificador;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AutorizadorCompra findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AutorizadorCompra) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AutorizadorCompra findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (AutorizadorCompra) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 
 public static AutorizadorCompra findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AutorizadorCompra) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(esquema_autoriz, "Debe ingresar el Esquema de Autorización");
    if (this.getEsquema_autoriz().isUsarClasificador())
    	Validar.noNulo(valor_clasificador, "Debe ingresar el Valor de Clasificador");
 }
 
 public static List getAutorizadoresCompras(EsquemaAutorizCompras esquemaAutorizCompras,
         ISesion aSesion) throws BaseException {
   return DBAutorizadorCompra.getAutorizadoresCompras(esquemaAutorizCompras,aSesion);
 }
 
 public List getAutorizacionesPorMontos() throws BaseException {
   if (readAutorizadoresMontoCompras) {
	  List lista = AutorizacionMontoCompra.getAutorizacionesPorMonto(this, getSesion());
	  autorizadoresMontoCompras.addAll(lista);
	  readAutorizadoresMontoCompras = false;
   }	
   return autorizadoresMontoCompras;
 }	
	
	
 public void addAutorizacionPorMonto(
			AutorizacionMontoCompra autorizacionMontoCompra) throws BaseException {
	autorizacionMontoCompra.setAutorizacion_compra(this);
	autorizadoresMontoCompras.add(autorizacionMontoCompra);
 }
	
 public void afterSave() throws BaseException {
		
	Iterator iterAutorizacionPorMontos = autorizadoresMontoCompras.iterator();
	while (iterAutorizacionPorMontos.hasNext()) {
	  AutorizacionMontoCompra autorizacionMontoCompra = (AutorizacionMontoCompra) iterAutorizacionPorMontos.next();
	  autorizacionMontoCompra.save();
	  autorizacionMontoCompra = null;
    }
	iterAutorizacionPorMontos = null;
 } 
 
	public static AutorizadorCompra getAutorizacionCompraByValorClasif(EsquemaAutorizCompras esqAutorizCompras,
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {
		return DBAutorizadorCompra.getAutorizacionComraByValorClasif(esqAutorizCompras,valClasifEnt,aSesion);
	}
	
	public static AutorizadorCompra getAutorizacionCompra(EsquemaAutorizCompras esqAutorizCompras,
			 ISesion aSesion) throws BaseException {
		return DBAutorizadorCompra.getAutorizacionComra(esqAutorizCompras,aSesion);
	}
	
	
	public AutorizacionMontoCompra getAutorizMonCpraByMonto(Money monto,
			ISesion aSesion) throws BaseException {
		return AutorizacionMontoCompra.getAutorizMonCpraByMonto(this, monto, this.getSesion());
	}
	
 

}
