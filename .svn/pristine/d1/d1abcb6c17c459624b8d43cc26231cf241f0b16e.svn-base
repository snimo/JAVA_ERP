package com.srn.erp.ventas.bm;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.da.DBConfProdPorLP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfProdPorLP extends ObjetoLogico { 

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

public ConfProdPorLP() { 
  }

  public static String NICKNAME = "ve.ConfProdPorLP";

  private Producto producto;
  private ListaPrecios lista_precios;
  private Double porc_rent_sug;

  public Producto getProducto() throws BaseException { 
    supportRefresh();
    return producto;
  }

  public void setProducto(Producto aProducto) { 
    this.producto =  aProducto;
  }

  public ListaPrecios getLista_precios() throws BaseException { 
    supportRefresh();
    return lista_precios;
  }

  public void setLista_precios(ListaPrecios aLista_precios) { 
    this.lista_precios =  aLista_precios;
  }

  public Double getPorc_rent_sug() throws BaseException { 
    supportRefresh();
    return porc_rent_sug;
  }

  public void setPorc_rent_sug(Double aPorc_rent_sug) { 
    this.porc_rent_sug =  aPorc_rent_sug;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConfProdPorLP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfProdPorLP) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConfProdPorLP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfProdPorLP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(producto, "Debe ingresar el Producto");
    Validar.noNulo(lista_precios, "Debe ingresar la Lista de Precios");
 }
 
 public static ConfProdPorLP getConfProdLP(Producto producto,
			ListaPrecios listaPrecios,
			ISesion aSesion)
 	throws BaseException {
	 return DBConfProdPorLP.getConfProdLP(producto,listaPrecios,aSesion);
 }
 

}
