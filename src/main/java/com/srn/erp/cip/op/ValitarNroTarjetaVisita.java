package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaLegajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValitarNroTarjetaVisita extends Operation {

	public ValitarNroTarjetaVisita() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nroTarjeta     = mapaDatos.getString("nro_tarjeta");
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		if (tarjetaCIP == null)
			throw new ExceptionValidation(null,"Nro. de Tarjeta para Visita Inexistente.");
		
		if (tarjetaCIP.isParaVisita()==false)
			throw new ExceptionValidation(null,"La tarjeta asignada no fue habilitada para visitas.");
		
		if (tarjetaCIP.getVisita()!=null)
			throw new ExceptionValidation(null,"La tarjeta ya se encuentra asignada a la Visita "+
					                           " Nro. Docu. "+tarjetaCIP.getVisita().getNroDocumento()+" "+
					                           tarjetaCIP.getVisita().getApeyNom());
		
		if (tarjetaCIP.getLegajo()!=null)
			throw new ExceptionValidation(null,"La tarjeta ya se encuentra asignada al Legajo "+
					                           ""+tarjetaCIP.getLegajo().getNro_legajo()+" "+
					                           tarjetaCIP.getLegajo().getApellidoyNombre());
		
		TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(nroTarjeta,this.getSesion());
		if (tarjetaLegajo!=null)
			throw new ExceptionValidation(null,"La tarjeta ya se encuentra asignada al Legajo "+
                    ""+tarjetaLegajo.getLegajo().getNro_legajo()+" "+
                    tarjetaLegajo.getLegajo().getApellidoyNombre());
			
		IDataSet dsTarjetaVisita = getDataSetTarjetaVisita();
		cargarTarjetaVisita(dsTarjetaVisita,tarjetaCIP);
		writeCliente(dsTarjetaVisita);
				
	}
	
	  private IDataSet getDataSetTarjetaVisita() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TTarjetaVisita");
		    dataset.fieldDef(new Field("oid_tarjeta", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 20)); 
		    dataset.fieldDef(new Field("activo", Field.STRING, 50)); 
		    return dataset;
	  }
	  
	  private void cargarTarjetaVisita(IDataSet dsTarjVisita,TarjetaCIP tarjeta) throws BaseException {
		  dsTarjVisita.append();
		  dsTarjVisita.fieldValue("oid_tarjeta", tarjeta.getOIDInteger());
		  dsTarjVisita.fieldValue("nro_tarjeta", tarjeta.getNro_tarjeta());
		  dsTarjVisita.fieldValue("activo", tarjeta.isActivo());
	  }
	

}
