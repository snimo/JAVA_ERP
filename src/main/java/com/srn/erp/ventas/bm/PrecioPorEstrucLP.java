package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.da.DBPrecioPorEstrucLP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class PrecioPorEstrucLP extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrecioPorEstrucLP() { 
  }

  public static String NICKNAME = "ve.PrecioPorEstrucLP";

  private ListaPrecios lista_precios;
  private UnidadMedida unidad_medida;
  private Double cantidad;
  private Moneda moneda;
  private Double precio;
  private ValorClasificadorEntidad valor_clasif_art1;
  private ValorClasificadorEntidad valor_clasif_art2;
  private Boolean activo;
  private java.util.Date fecUltAct;

  public ListaPrecios getLista_precios() throws BaseException { 
    supportRefresh();
    return lista_precios;
  }

  public void setLista_precios(ListaPrecios aLista_precios) { 
    this.lista_precios =  aLista_precios;
  }
  
  public ValorClasifEntProdGen getValorClasifProdGral() throws BaseException {
	  return ValorClasifEntProdGen.findByOidProxy(getValor_clasif_art2().getOIDInteger(), this.getSesion());
  }
  
  public java.util.Date getFecUltAct() throws BaseException { 
	supportRefresh();
	return this.fecUltAct;
  }

  public void setFecUltAct(java.util.Date aFecUltAct) { 
	this.fecUltAct =  aFecUltAct;
  }  

  public UnidadMedida getUnidad_medida() throws BaseException { 
    supportRefresh();
    return unidad_medida;
  }

  public void setUnidad_medida(UnidadMedida aUnidad_medida) { 
    this.unidad_medida =  aUnidad_medida;
  }

  public Double getCantidad() throws BaseException { 
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) { 
    this.cantidad =  aCantidad;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public Double getPrecio() throws BaseException { 
    supportRefresh();
    return precio;
  }

  public void setPrecio(Double aPrecio) { 
    this.precio =  aPrecio;
  }

  public ValorClasificadorEntidad getValor_clasif_art1() throws BaseException { 
    supportRefresh();
    return valor_clasif_art1;
  }

  public void setValor_clasif_art1(ValorClasificadorEntidad aValor_clasif_art1) { 
    this.valor_clasif_art1 =  aValor_clasif_art1;
  }

  public ValorClasificadorEntidad getValor_clasif_art2() throws BaseException { 
    supportRefresh();
    return valor_clasif_art2;
  }

  public void setValor_clasif_art2(ValorClasificadorEntidad aValor_clasif_art2) { 
    this.valor_clasif_art2 =  aValor_clasif_art2;
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

 public static PrecioPorEstrucLP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (PrecioPorEstrucLP) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static PrecioPorEstrucLP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PrecioPorEstrucLP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(lista_precios, "Debe ingresar la lista de Precios");
    Validar.noNulo(unidad_medida, "Unidad Medida");
    Validar.noNulo(cantidad, "Debe ingresar la cantidad");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
    Validar.noNulo(valor_clasif_art2, "Debe ingresar el Valor del Clasificador 2");
 }
 
 public static List getPreciosClasifArtPorLP(ListaPrecios listaPrecios,
		 List valoresClasificador,
		 ISesion aSesion) throws BaseException {
 	return DBPrecioPorEstrucLP.getPreciosClasifArtPorLP(listaPrecios,valoresClasificador,aSesion);
 }
 
 public static PrecioPorEstrucLP getPrecioEstrucLPBYClasificadores(ListaPrecios listaPrecio,
		 IValorClasificadorEntidad valClasifEnt1,
     ISesion aSesion)
     throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	condiciones.put(ListaPrecios.NICKNAME,listaPrecio);
	condiciones.put("VALOR_CLASIF_1",valClasifEnt1);
	
  return (PrecioPorEstrucLP) ObjetoLogico.getObjects(PrecioPorEstrucLP.NICKNAME,
	  				DBPrecioPorEstrucLP.SELECT_BY_CLASF_ART_1,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
  }
 
 public static List getConsultaMasivaProductos(
		    ListaPrecios lp,
		    Integer oidProducto,
	  		String descProducto,
	  		String descAbreviada,
	  		String codigoProducto,
	  		TipoProducto tipoProducto,  		
	  		boolean isComprable,
	  		boolean isVendible,
	  		boolean isStockeable,
	  		boolean isProdPropia,
	  		boolean isImportado,
	  		HashTableDatos listaValoresClasif,
	        ISesion aSesion) throws BaseException {
	  	
	  	return DBPrecioPorEstrucLP.getConsultaMasivaProductos(
	  			lp,
	  			oidProducto,
	  			descProducto,
	  			descAbreviada,
	  			codigoProducto,
	  			tipoProducto,
	  			isComprable,
	  			isVendible,
	  			isStockeable,
	  			isProdPropia,
	  			isImportado,
	  			listaValoresClasif,
	  			aSesion);
	  }
 
 
 
  
 
}
