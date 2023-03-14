package com.srn.erp.contabilidad.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class GenerarLibroDiario extends Operation {

  List detAsiCierreResul = new ArrayList();
  List detAsiCierrePatri = new ArrayList();
	
  public GenerarLibroDiario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	Ejercicio ejercicio = Ejercicio.findByOid(mapaDatos.getInteger("oid_ejercicio"), this.getSesion());
	String tipoDetalle = mapaDatos.getString("tipo_detalle");
	ejercicio.setUltimaPresentacionLibroDiario(tipoDetalle);
	this.addTransaccion(ejercicio);
	
	generarLibroDiario(ejercicio,tipoDetalle);
		
  }
  
  private boolean isAsientoApertura(ComproContaDet comproContaDet) throws BaseException {
	  if (comproContaDet.getComprobante()==null) 
		  return false;
	  if (comproContaDet.getComprobante().getComprobante()==null) 
		  return false;
	  
	  if (comproContaDet.getComprobante().getComprobante().getTipoCompro()==null) 
		  return false;	  
	  
	  if ((comproContaDet.getComprobante().getComprobante().getTipoCompro().esAsientoDeApertura())
			   &&
			   comproContaDet.getComprobante().getComprobante().isActivo())
		  return true;
	  else
		  return false;
  }
  
  private boolean isAsientoCierre(ComproContaDet comproContaDet) throws BaseException {
	  if ((comproContaDet.getComprobante().getComprobante().getTipoCompro().esAsientoCierre())
			   &&
			   comproContaDet.getComprobante().getComprobante().isActivo())
		  return true;
	  else
		  return false;
  }
  
  private boolean isAsientoCierreResultado(ComproCab comproCab) throws BaseException {
	  
	  ComproCierreEjercicio comproCierreEjer =
		  ComproCierreEjercicio.findByOid(comproCab.getOIDInteger(), this.getSesion());
	  if (comproCierreEjer.isCierreCtasResultado())
		  return true;
	  else
		  return false;
	  
  }
  
    
  private void generarLibroDiario(Ejercicio ejercicio,String tipoDetalle) throws BaseException {
	  
	  HashTableDatos nroAsiPorCompro = new HashTableDatos();
	  int nroAsiento = 1;
	  if (ejercicio.isTieneEjercicioComproAperturaActivo()) 
		  nroAsiento = 2;
	  
	  Iterator iterImpuContaDet =
		  ejercicio.getImpuEjercicioOrderFecOIDCCO().iterator();
	  while (iterImpuContaDet.hasNext()) {
		  ComproContaDet comproContaDet = (ComproContaDet) iterImpuContaDet.next();
		  
		  this.addTransaccion(comproContaDet);
		  
		  if (isAsientoApertura(comproContaDet)) { 
		      comproContaDet.setNroAsiento(1);
			  continue;
		  } else if (isAsientoCierre(comproContaDet)) {
			  			if (isAsientoCierreResultado(comproContaDet.getComprobante().getComprobante()))
			  				detAsiCierreResul.add(comproContaDet);
			  			else
			  				detAsiCierrePatri.add(comproContaDet);
			  			continue;
		  } else {
			  String clave = "";
			  if (tipoDetalle.equals(Ejercicio.LD_DIA_COMPRO))
				  clave =
					  Fecha.getddmmyyyy(comproContaDet.getComprobante().getImputac())+
					  "_"+
					  comproContaDet.getComprobante().getOIDInteger();
			  else
			  if (tipoDetalle.equals(Ejercicio.LD_DIA_TC))
				  clave =
					  Fecha.getddmmyyyy(comproContaDet.getComprobante().getImputac())+
					  "_"+
					  comproContaDet.getComprobante().getComprobante().getTipoCompro().getOIDInteger();
			  if (tipoDetalle.equals(Ejercicio.LD_MES_TC))
				  clave =
					  comproContaDet.getComprobante().getPeriodo().getOIDInteger()+
					  "_"+
					  comproContaDet.getComprobante().getComprobante().getTipoCompro().getOIDInteger();
			  
			  
			  Integer nroAsientoCompro = 
				  (Integer)nroAsiPorCompro.get(clave);
			  if (nroAsientoCompro == null) {
				  nroAsientoCompro = new Integer(nroAsiento);
				  nroAsiPorCompro.put(clave, nroAsientoCompro);
				  nroAsiento++;
			  }
			  comproContaDet.setNroAsiento(nroAsientoCompro);
		  }
	  }
	  
	  // Numerar los Asientos de Cierre Resultado
	  if (detAsiCierreResul.size()>0) {
		  Iterator iterContaDetCierreResu =
			  detAsiCierreResul.iterator();
		  while (iterContaDetCierreResu.hasNext()) {
			  ComproContaDet comproContaDet = (ComproContaDet) iterContaDetCierreResu.next();
			  comproContaDet.setNroAsiento(new Integer(nroAsiento));
		  }
		  ++nroAsiento;
	  }
	  
	  // Numerar los Asientos de Cierre Patrimoniales
	  if (detAsiCierrePatri.size()>0) {
		  Iterator iterContaDetCierrePatri =
			  detAsiCierrePatri.iterator();
		  while (iterContaDetCierrePatri.hasNext()) {
			  ComproContaDet comproContaDet = (ComproContaDet) iterContaDetCierrePatri.next();
			  comproContaDet.setNroAsiento(new Integer(nroAsiento));
		  }
		  ++nroAsiento;
	  }
	  
	  
  }
  
  

}
