package com.srn.erp.cip.op;


import java.util.Iterator;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePlanifrotasLeg extends Operation { 

  HashTableDatos codRotas = new HashTableDatos();	
	
  public SavePlanifrotasLeg() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	cargarRotas();
    IDataSet dataset = mapaDatos.getDataSet("TPlanifRotas");
    java.util.Date fecha = mapaDatos.getDate("fecha");
    int dias = mapaDatos.getInteger("dias");
    procesarRegistros(dataset,fecha,dias); 
  } 

  private void procesarRegistros(IDataSet dataset,java.util.Date fecha,int dias) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	Legajo legajo = Legajo.findByOidProxy(dataset.getInteger("oid_legajo"), this.getSesion());
    	
      java.util.Date fechaPlanif = Fecha.getFechaDiaAnterior(fecha); 	
  	  for (int i=1;i<=dias;++i) {
  		  
		  fechaPlanif 		= Fecha.getFechaMasDias(fechaPlanif, 1);
		  String campoFecha = "_"+Fecha.getddmmyyyy(fechaPlanif).replaceAll("/", "_");
		  String codRota 	= dataset.getString(campoFecha);

		  LegajoRotaFecha legFecRota = 
			  LegajoRotaFecha.getLegajoFechaRota(legajo, fechaPlanif , this.getSesion());
		  if ((codRota==null) || ((codRota!=null) && (codRota.length()==0))) {
			  if (legFecRota!=null) {
				  legFecRota.delete();
				  this.addTransaccion(legFecRota);
			  }
			  continue;
		  } else {
			  if (legFecRota == null)
				  legFecRota = (LegajoRotaFecha) LegajoRotaFecha.getNew(LegajoRotaFecha.NICKNAME, this.getSesion());
			  legFecRota.setLegajo(legajo);
			  legFecRota.setFecha(fechaPlanif);
			  legFecRota.setActivo(new Boolean(true));
			  legFecRota.setRota(getRotaByCodigo(codRota));
			  this.addTransaccion(legFecRota);
			  continue;
		  }
			  
	  }
    	
    	  
        dataset.next();
    }
  }
  
  private void cargarRotas() throws BaseException {
	  Iterator iterRotas = 
		  Rota.getAllRotas(this.getSesion()).iterator();
	  while (iterRotas.hasNext()) {
		  Rota rota = (Rota) iterRotas.next();
		  this.codRotas.put(rota.getCodigo(), rota);
	  }
  }
  
  private Rota getRotaByCodigo(String codigo) throws BaseException {
	  return (Rota)this.codRotas.get(codigo);
  }
  
}
