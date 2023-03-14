package com.srn.erp.stock.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.da.DBFactConvProdGral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class FactConvProdGral extends ObjetoLogico { 

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

public FactConvProdGral() { 
  }

  public static String NICKNAME = "st.FactConvProdGral";

  private ValorClasificadorEntidad valClasifEnt;
  private UnidadMedida unidad_origen;
  private UnidadMedida unidad_destino;
  private Money fact_conv;

  public ValorClasificadorEntidad getValClasifEnt() throws BaseException { 
    supportRefresh();
    return this.valClasifEnt;
  }

  public void setValClasifEnt(ValorClasificadorEntidad aValClasifEnt) { 
    this.valClasifEnt =  aValClasifEnt;
  }

  public UnidadMedida getUnidad_origen() throws BaseException { 
    supportRefresh();
    return unidad_origen;
  }

  public void setUnidad_origen(UnidadMedida aUnidad_origen) { 
    this.unidad_origen =  aUnidad_origen;
  }

  public UnidadMedida getUnidad_destino() throws BaseException { 
    supportRefresh();
    return unidad_destino;
  }

  public void setUnidad_destino(UnidadMedida aUnidad_destino) { 
    this.unidad_destino =  aUnidad_destino;
  }

  public Money getFact_conv() throws BaseException { 
    supportRefresh();
    return fact_conv;
  }

  public void setFact_conv(Money aFact_conv) { 
    this.fact_conv =  aFact_conv;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static FactConvProdGral findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FactConvProdGral) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static FactConvProdGral findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (FactConvProdGral) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 

 public static FactConvProdGral findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FactConvProdGral) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(this.valClasifEnt, "Debe ingresar el Producto General");
    Validar.noNulo(unidad_origen, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(unidad_destino, "Debe ingresar la Unidad de Medida Destino");
 }
 
 public static List getFactoresConv(ValorClasificadorEntidad valClasifEnt,
         ISesion aSesion) throws BaseException {
	  return DBFactConvProdGral.getFactoresConv(valClasifEnt,aSesion);
 }
 
 public static FactConvProdGral getFactorConv(ValorClasificadorEntidad valClasifEnt,
		  UnidadMedida umOri,
		  UnidadMedida umDest,
         ISesion aSesion) throws BaseException {
	  return DBFactConvProdGral.getFactorConv(valClasifEnt,umOri,umDest,aSesion);
 }
 
	public void afterSave() throws BaseException {

		super.afterSave();
		
		/*
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
		
		if (valClasifEntProdGral!=null) {
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				ConversionUMProducto convUMProd = producto.getFactConvUMOriUMDest(this.getUnidad_origen(),this.getUnidad_destino());
				if (convUMProd == null) 
					convUMProd = (ConversionUMProducto) ConversionUMProducto.getNew(ConversionUMProducto.NICKNAME, this.getSesion());
				convUMProd.setProducto(producto);
				convUMProd.setUnidad_medida_dest(this.getUnidad_destino());
				convUMProd.setUnidad_medida_origen(this.getUnidad_origen());
				if (this.getFact_conv()!=null)
					convUMProd.setFact_conv(this.getFact_conv().doubleValue());
				else
					convUMProd.setFact_conv(null);
				convUMProd.save();
			}
		}
		*/
		
	}

	@Override
	public void afterSaveDelete() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveDelete();
		
		/*
		
		ValorClasifEntProdGen valClasifEntProdGral = ValorClasifEntProdGen.findByOid(this.getValClasifEnt().getOIDInteger(), this.getSesion());
		
		if (valClasifEntProdGral!=null) {
			Iterator iterProductos = valClasifEntProdGral.getProductos().iterator();
			while (iterProductos.hasNext()) {
				Producto producto = (Producto) iterProductos.next();
				ConversionUMProducto convUMProd = producto.getFactConvUMOriUMDest(this.getUnidad_origen(),this.getUnidad_destino());
				if (convUMProd != null) {
					convUMProd.delete();
					convUMProd.save();
				}
			}
		}
		
		*/
		
		
	}
 
 

}
