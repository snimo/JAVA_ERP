package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.da.DBEsquemaBonificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaBonificacion extends ObjetoLogico { 

  public EsquemaBonificacion() { 
  }

  public static String NICKNAME = "ve.EsquemaBonificacion";

  private String codigo;
  private String descripcion;
  private java.util.Date fec_vig_desde;
  private ClasificadorEntidad clasificador_entidad;
  private java.util.Date fec_vig_hasta;
  private Boolean activo;
  
  private List esquemasBonificacionValoresClasif = new ArrayList();
  private boolean readesquemasBonificacionValoresClasif = true;
  
  private List esquemasBonificacionProducto = new ArrayList();
  private boolean readEsquemaBonificacionProducto = true;
  
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

  public java.util.Date getFec_vig_desde() throws BaseException { 
    supportRefresh();
    return fec_vig_desde;
  }

  public void setFec_vig_desde(java.util.Date aFec_vig_desde) { 
    this.fec_vig_desde =  aFec_vig_desde;
  }

  public ClasificadorEntidad getClasificador_entidad() throws BaseException { 
    supportRefresh();
    return clasificador_entidad;
  }

  public void setClasificador_entidad(ClasificadorEntidad aClasificador_entidad) { 
    this.clasificador_entidad =  aClasificador_entidad;
  }

  public java.util.Date getFec_vig_hasta() throws BaseException { 
    supportRefresh();
    return fec_vig_hasta;
  }

  public void setFec_vig_hasta(java.util.Date aFec_vig_hasta) { 
    this.fec_vig_hasta =  aFec_vig_hasta;
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

 public static EsquemaBonificacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacion) getObjectByOid(NICKNAME,oid,aSesion);
 } 

 public static EsquemaBonificacion findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (EsquemaBonificacion) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 
 public static EsquemaBonificacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsquemaBonificacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(fec_vig_desde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(clasificador_entidad, "Debe ingresar el Clasificador");
    Validar.noNulo(fec_vig_hasta, "Debe ingresar la Fecha Hasta");
 }
 
 public List getEsquemasBonifClasifProd() throws BaseException {
   if (readesquemasBonificacionValoresClasif) {
	  List listaEsqBonifValClasif = EsquemaBonificacionClasifProd.getEsquemasBonifClasifProd(this,getSesion());
	  esquemasBonificacionValoresClasif.addAll(listaEsqBonifValClasif);
	  readesquemasBonificacionValoresClasif = false;
   }
   return esquemasBonificacionValoresClasif;
 }
 
 public List getEsquemasBonifProducto() throws BaseException {
   if (readEsquemaBonificacionProducto) {
	  List listaEsqBonifProd = EsquemaBonificacionProducto.getEsquemasBonifProducto(this,getSesion());
	  esquemasBonificacionProducto.addAll(listaEsqBonifProd);
	  readEsquemaBonificacionProducto = false;
   }
   return esquemasBonificacionProducto;
 }
 

  public void addEsquemaBonifClasifProd(EsquemaBonificacionClasifProd aEsquemaBonificacionClasifProd) throws BaseException {
	 aEsquemaBonificacionClasifProd.setEsquema_bonificacion(this);
	 esquemasBonificacionValoresClasif.add(aEsquemaBonificacionClasifProd);
  }
  
  public void addEsquemaBonifProducto(EsquemaBonificacionProducto aEsquemaBonificacionProducto) throws BaseException {
	aEsquemaBonificacionProducto.setEsquema_bonificacion(this);
	esquemasBonificacionProducto.add(aEsquemaBonificacionProducto);
  }
  

  public void afterSave() throws BaseException {
	  
	Iterator iterEsqBonifClasifProd = esquemasBonificacionValoresClasif.iterator();
	while (iterEsqBonifClasifProd.hasNext()) {
	  EsquemaBonificacionClasifProd esqBonfClasifProd = (EsquemaBonificacionClasifProd) iterEsqBonifClasifProd.next();
	  esqBonfClasifProd.save();
	  esqBonfClasifProd = null;
	}
	iterEsqBonifClasifProd = null;
	
	Iterator iterEsqBonifProd = esquemasBonificacionProducto.iterator();
	while (iterEsqBonifProd.hasNext()) {
	  EsquemaBonificacionProducto esquemaBonificacionProducto = (EsquemaBonificacionProducto) iterEsqBonifProd.next();
	  esquemaBonificacionProducto.save();
	  esquemaBonificacionProducto = null;
	}
	iterEsqBonifProd = null;	
  }
  
  public static EsquemaBonificacion getEsquemaBonificacionVigAFecha(java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  return DBEsquemaBonificacion.getEsquemaBonificacionVigAFecha(fecha,aSesion);
  }
  
  public EsquemaBonificacionClasifProd getEsquemaClasifProdVig(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		return EsquemaBonificacionClasifProd.getEsquemaClasifProdVig(this, valClasifEnt, fecha, aSesion);
  }
  
  
  public Porcentaje getPorcBonif(Producto producto,Date fecha) throws BaseException {
	  
	if (fecha.before(this.getFec_vig_desde()))
		return null;
	if (fecha.after(this.getFec_vig_hasta()))
	   return null;
	
	Porcentaje porc = null;
	
	// Buscar si exista bonificacion cargada para el producto
	EsquemaBonificacionProducto esqBonifProd = 
		EsquemaBonificacionProducto.getEsquemaBonifPro(this,producto,getSesion());
	if (esqBonifProd!=null) {
		EsquemaBonifProdDet esqBonifProdDet = esqBonifProd.getEsquemaBonifProdDetVigAFecha(fecha);
		if (esqBonifProdDet!=null)
			porc = esqBonifProdDet.getPorcDto();
	}
	
	if (porc == null) {
		// Buscar Bonificacion en los clasificadores
		if (this.getClasificador_entidad() != null) {
			IValorClasificadorEntidad valClasifEnt = this.getClasificador_entidad().getValorClasificador(producto);
			if (valClasifEnt != null) {
				ValorClasificadorEntidad valorClasifEntidad = ValorClasificadorEntidad.findByOid(new Integer(valClasifEnt.getOID()),getSesion());
				if  (valorClasifEntidad!=null) {
				  EsquemaBonificacionClasifProd esqBonifClasifProd = getEsquemaClasifProdVig(valorClasifEntidad,fecha,getSesion());
				  if (esqBonifClasifProd!=null)
					  porc = esqBonifClasifProd.getPorcDto(); 
				}
			}
		}
	}
	
	return porc;  
  }
 

}
