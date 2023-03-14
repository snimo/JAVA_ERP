package com.srn.erp.costos.bm;

import java.util.Iterator;

import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProductoGral;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProcesoCostoProductos extends ObjetoLogico { 

  @Override
	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		calculoProcesoCostos();
		
	}
  
  
  private boolean isValidoCalcCosto(ValorClasifEntProdGen valorClasif) throws BaseException {
	  if (!valorClasif.isActivo()) return false;
	  if (valorClasif.getExtensionProdGen()==null) return false;
	  if (valorClasif.getExtensionProdGen().getFormaCalcCosto()==null) return false;
	  return true;
  }
  
  private void calculoProcesoCostos() throws BaseException {
	  
	  // Recorrer todos los Productos
	  Iterator iterValorClasifProdGral = 
		  ValorClasifEntProdGen.getAllValoresClasifProdGrales(this.getSesion()).iterator();
	  while (iterValorClasifProdGral.hasNext()) {
		  ValorClasifEntProdGen valorProdGral = (ValorClasifEntProdGen) iterValorClasifProdGral.next();
		  
		  // Criterio necesarios para calcular el costo
		  if (!isValidoCalcCosto(valorProdGral)) continue;
		  
		  CostoProductoGral costo =
			  valorProdGral.calcNuevoCosto(this.getFec_desde(),this.getFec_hasta(),this.getFecha_costo());
		  if (costo!=null)
			  costo.save();
	  }
	  
	  
  }

@Override
protected void beforeSaveNew() throws BaseException {
	// TODO Auto-generated method stub
	super.beforeSaveNew();
	
	
}

public ProcesoCostoProductos() { 
  }

  public static String NICKNAME = "co.ProcesoCostoProductos";

  private String codigo;
  private java.util.Date fec_ejecucion;
  private String descripcion;
  private String hora_ejecucion;
  private Usuario usuario;
  private java.util.Date fecha_costo;
  private java.util.Date fec_desde;
  private Boolean activo;
  private java.util.Date fec_hasta;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public java.util.Date getFec_ejecucion() throws BaseException { 
    supportRefresh();
    return fec_ejecucion;
  }

  public void setFec_ejecucion(java.util.Date aFec_ejecucion) { 
    this.fec_ejecucion =  aFec_ejecucion;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getHora_ejecucion() throws BaseException { 
    supportRefresh();
    return hora_ejecucion;
  }

  public void setHora_ejecucion(String aHora_ejecucion) { 
    this.hora_ejecucion =  aHora_ejecucion;
  }

  public Usuario getUsuario() throws BaseException { 
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) { 
    this.usuario =  aUsuario;
  }

  public java.util.Date getFecha_costo() throws BaseException { 
    supportRefresh();
    return fecha_costo;
  }

  public void setFecha_costo(java.util.Date aFecha_costo) { 
    this.fecha_costo =  aFecha_costo;
  }

  public java.util.Date getFec_desde() throws BaseException { 
    supportRefresh();
    return fec_desde;
  }

  public void setFec_desde(java.util.Date aFec_desde) { 
    this.fec_desde =  aFec_desde;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public java.util.Date getFec_hasta() throws BaseException { 
    supportRefresh();
    return fec_hasta;
  }

  public void setFec_hasta(java.util.Date aFec_hasta) { 
    this.fec_hasta =  aFec_hasta;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ProcesoCostoProductos findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ProcesoCostoProductos) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ProcesoCostoProductos findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ProcesoCostoProductos) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException {

	if (this.isNew()) {
		String horaActual = Fecha.getHoraActual();
		this.setCodigo(Fecha.getddmmyyyy(Fecha.getFechaActual())+" "+horaActual);
		this.setDescripcion("Costo al "+Fecha.getddmmyyyy(this.getFecha_costo())+" Período del "+
				Fecha.getddmmyyyy(this.getFec_desde())+" al "+
				Fecha.getddmmyyyy(this.getFec_hasta())
				);
		this.setFec_ejecucion(Fecha.getFechaActual());
		this.setHora_ejecucion(horaActual);
		Usuario usuario = 
			Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		this.setUsuario(usuario);
	}
	 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(fec_ejecucion, "Debe ingresar la fecha de Ejecución");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(hora_ejecucion, "Debe ingresar la hora de ejecución");
    Validar.noNulo(usuario, "Debe ingresar el Usuario");
    Validar.noNulo(fecha_costo, "Debe ingresar la fecha de costo");
    Validar.noNulo(fec_desde, "Debe ingresar la fecha desde");
    Validar.noNulo(fec_hasta, "Debe ingresar la fecha hasta");
 }

}
