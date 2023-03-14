package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.da.DBCtaHabMotivoPagosVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoPago extends ObjetoLogico {

  public MotivoPago() {
  }

  public static String NICKNAME = "pag.MotivoPago";

  private String codigo;
  private String descripcion;
  private String compo;
  private Boolean activo;
  
  private List ctasHabilitadas = new ArrayList();
  private boolean readCtasHabilitadas = true;

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

  public String getCompo() throws BaseException {
    supportRefresh();
    return compo;
  }

  public void setCompo(String aCompo) {
    this.compo =  aCompo;
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

 public static MotivoPago findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (MotivoPago) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static MotivoPago findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (MotivoPago) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static MotivoPago findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (MotivoPago) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

      Validar.noNulo(codigo, "Debe ingresar un código");
      Validar.noNulo(descripcion, "Debe ingresar la Descripción");
      Validar.noNulo(compo, "Debe ingresar el Tipo ");

 }

 public static Hashtable getComportamientos() throws BaseException {
   CompoMotivosPago compoMotivosPago = new CompoMotivosPago();
   return compoMotivosPago.getComportamientos();
 }
 
 public List getCtasHabPagosVarios() throws BaseException {
	if (this.readCtasHabilitadas) {
	      List listaCtasHabPagosVarios = CtaHabMotivoPagosVarios.getCtasHabilitadasMotivosPagos(this,getSesion());
	      ctasHabilitadas.addAll(listaCtasHabPagosVarios);
	      readCtasHabilitadas = false;
	 }
	 return ctasHabilitadas;
 }

 public void addCtaHabPagosVarios(CtaHabMotivoPagosVarios aCtaHabPagosVarios) throws BaseException {
	 aCtaHabPagosVarios.setMotivo_pago(this);
	 ctasHabilitadas.add(aCtaHabPagosVarios);
 }

 public void afterSave() throws BaseException {
	 Iterator iterCtasHabPagosVarios = ctasHabilitadas.iterator();
	 while (iterCtasHabPagosVarios.hasNext()) {
	      CtaHabMotivoPagosVarios ctaHabPagVar = 
	      	(CtaHabMotivoPagosVarios) iterCtasHabPagosVarios.next();
	      ctaHabPagVar.save();
	      ctaHabPagVar = null;
	    }
	 iterCtasHabPagosVarios = null;
 }
 
 public CtaHabMotivoPagosVarios getCtaHabMotPago(
		  Cuenta cuenta)
        throws BaseException {
	  
	  return CtaHabMotivoPagosVarios.getCtaHabMotPago(this,cuenta,this.getSesion());
 }
 
 public boolean isPagosVarios() throws BaseException {
	 if (this.getCompo().equals(CompoMotivosPago.PAGOS_VARIOS))
		 return true;
	 else
		 return false;
 }
 
 public boolean isPagosAProveedores() throws BaseException {
	 if (this.getCompo().equals(CompoMotivosPago.PAGO_A_PROV))
		 return true;
	 else
		 return false;
 }
 
 

}
