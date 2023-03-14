package com.srn.erp.ventas.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.costos.bm.CentroCostos;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.da.DBProyecto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Proyecto extends ObjetoLogico implements IEntidadClasificable { 

  public Proyecto() { 
  }

  public static String NICKNAME = "ve.Proyecto";

  private String codigo;
  private String descripcion;
  private Boolean cerrado;
  private Sujeto sujeto;
  private Boolean activo;
  
  private Hashtable listaOidValClasif = new Hashtable();

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

  public Boolean isCerrado() throws BaseException { 
    supportRefresh();
    return cerrado;
  }

  public void setCerrado(Boolean aCerrado) { 
    this.cerrado =  aCerrado;
  }

  public Sujeto getSujeto() throws BaseException { 
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) { 
    this.sujeto =  aSujeto;
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

 public static Proyecto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Proyecto) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static Proyecto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (Proyecto) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static Proyecto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Proyecto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(cerrado, "Debe ingresar si esta cerrado");
 }
 
 public void addOidValorClasif(Integer nroClasif, Integer aValor)  {
		if (aValor == null)
		   listaOidValClasif.put(nroClasif,new Integer(0));
		else
		   listaOidValClasif.put(nroClasif,aValor);
	 }

	 public Integer getOidValorClasif(Integer nroClasif) throws BaseException {
		supportRefresh();
		if (listaOidValClasif.get(nroClasif)!=null)
			return (Integer)listaOidValClasif.get(nroClasif);
		else
			return new Integer(0);
	 }

	 public ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt)
		throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt =
		        (Integer)listaOidValClasif.get(clasifEnt.getNroClasif());
		if (oidValClasifEnt!=null)
		      valClasifEnt =
		          ValorClasificadorEntidad.findByOid(oidValClasifEnt,getSesion());
		return valClasifEnt;
	 }
	 
	 public List getClasifEntidadesActivas() throws BaseException {
		    return ClasificadorEntidad.getClasificadoresEntidadActivos(Proyecto.NICKNAME,true,getSesion());
	 }
	 
	 public static List getClasificadoresEntidadActivos(ISesion aSesion) throws BaseException {
		    return ClasificadorEntidad.getClasificadoresEntidad(Proyecto.NICKNAME,true,aSesion);
	} 
	 
	  public static List getProyectosDelSujeto(Sujeto sujeto,boolean soloActivos,
	          ISesion aSesion) throws BaseException {
		  return DBProyecto.getProyectosDelSujeto(sujeto,soloActivos,aSesion);
	  }
	  
	  public static List getProyectosSinSujeto(boolean soloActivos,
	          ISesion aSesion) throws BaseException {
		  return DBProyecto.getProyectosSinSujeto(soloActivos,aSesion);
	  }
	  
 

}
