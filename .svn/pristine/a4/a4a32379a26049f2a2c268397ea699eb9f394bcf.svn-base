package com.srn.erp.produccion.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.produccion.da.DBRecetaCab;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecetaCab extends ObjetoLogico { 

  public RecetaCab() { 
  }

  public static String NICKNAME = "pr.RecetaCab";

  private String codigo;
  private String descripcion;
  private Producto produco;
  private Double base_calculo;
  private UnidadMedida oid_um;
  private String alternativa;
  private Boolean activo;
  
  private List recetasDet = new ArrayList();
  private boolean readRecetasDet = true;
  

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

  public Producto getProduco() throws BaseException { 
    supportRefresh();
    return produco;
  }

  public void setProduco(Producto aProduco) { 
    this.produco =  aProduco;
  }

  public Double getBase_calculo() throws BaseException { 
    supportRefresh();
    return base_calculo;
  }

  public void setBase_calculo(Double aBase_calculo) { 
    this.base_calculo =  aBase_calculo;
  }

  public UnidadMedida getOid_um() throws BaseException { 
    supportRefresh();
    return oid_um;
  }

  public void setOid_um(UnidadMedida aOid_um) { 
    this.oid_um =  aOid_um;
  }

  public String getAlternativa() throws BaseException { 
    supportRefresh();
    return alternativa;
  }

  public void setAlternativa(String aAlternativa) { 
    this.alternativa =  aAlternativa;
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

 public static RecetaCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecetaCab) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static RecetaCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (RecetaCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static RecetaCab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RecetaCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(produco, "Debe ingresar el Producto");
    Validar.noNulo(base_calculo, "Debe ingresar la Base de Cálculo");
    Validar.noNulo(oid_um, "Debe ingresar la Unidad de Medida");
    Validar.noNulo(alternativa, "Debe ingresar la alternativa");
 }
 
 public List getRecetasDet() throws BaseException {
   if (readRecetasDet) {
     List listaRecetasDet = RecetaDet.getRecetasDet(this,getSesion());
     recetasDet.addAll(listaRecetasDet);
     readRecetasDet = false;
   }
   return recetasDet;
 }

 public void addRecetaDet(RecetaDet recetaDet) throws BaseException {
   recetaDet.setReceta_cab(this);
   recetasDet.add(recetaDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterRecetasDet = recetasDet.iterator();
   while (iterRecetasDet.hasNext()) {
     RecetaDet recetaDet = (RecetaDet) iterRecetasDet.next();
     recetaDet.save();
     recetaDet = null;
   }
   iterRecetasDet = null;
 }
 
 public static RecetaCab getRecetaByProductoAlternativa(
		  Producto producto,
		  String alternativa,
          ISesion aSesion)
          throws BaseException {
	  
	  return DBRecetaCab.getRecetaByProductoAlternativa(producto,alternativa,aSesion);
	  
 }
 
 public static List getRecetasByProducto(Producto producto,
         ISesion aSesion)
         throws BaseException {
	  
	  return DBRecetaCab.getRecetasByProducto(producto,aSesion);
 }
 

}
