package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluDetBusquedas extends Operation { 

  public TraerRecluDetBusquedas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	HashTableDatos parametros = new HashTableDatos();
	  
	IDataSet dsInput = mapaDatos.getDataSet("TInput");
	dsInput.first();
	while (!dsInput.EOF()) {
		
		
		// Buscar
		String buscar = dsInput.getString("buscar");
		if ((buscar!=null) && (buscar.length()>0)) {
			parametros.put("BUSCAR", buscar.toUpperCase());
		}
		
		
		// Filtrar por operacion
		Integer oidOperacion = dsInput.getInteger("oid_operacion");
		if ((oidOperacion!=null) && (oidOperacion.intValue()>0)) {
			RecluOperacion recluOperacion = RecluOperacion.findByOidProxy(oidOperacion, this.getSesion());
			parametros.put(RecluOperacion.NICKNAME, recluOperacion);
		}
		
		// Filtrar por Sector
		Integer oidSector = dsInput.getInteger("oid_sector");
		if ((oidSector!=null) && (oidSector.intValue()>0)) {
			RecluSectores recluSectores = RecluSectores.findByOidProxy(oidSector, this.getSesion());
			parametros.put(RecluSectores.NICKNAME, recluSectores);
		}		
		
		// Filtrar por Selector
		Integer oidSelector = dsInput.getInteger("oid_selector");
		if ((oidSelector!=null) && (oidSelector.intValue()>0)) {
			RecluSelector recluSelector = RecluSelector.findByOidProxy(oidSelector, this.getSesion());
			parametros.put(RecluSelector.NICKNAME, recluSelector);
		}		
		
		// Filtrar por Puesto
		Integer oidPuesto = dsInput.getInteger("oid_puesto");
		if ((oidPuesto!=null) && (oidPuesto.intValue()>0)) {
			RecluPuesto recluPuesto = RecluPuesto.findByOidProxy(oidPuesto, this.getSesion());
			parametros.put(RecluPuesto.NICKNAME, recluPuesto);
		}		
		
		
		if (dsInput.getBoolean("abiertas")) {
			parametros.put(RecluBusqueda.getEstadoBusqAbierta(), "");
		}
		
		if (dsInput.getBoolean("cerradas")) {
			parametros.put(RecluBusqueda.getEstadoBusqCerrada(), "");
			
			java.util.Date fecDesde = dsInput.getDate("fec_desde");
			java.util.Date fecHasta = dsInput.getDate("fec_hasta");
			
			if (fecDesde==null)
				throw new ExceptionValidation(null,"Debe ingresar la fecha Desde");
			
			if (fecHasta==null)
				throw new ExceptionValidation(null,"Debe ingresar la fecha Hasta");			
			
			parametros.put("FEC_DESDE", fecDesde);
			parametros.put("FEC_HASTA", fecHasta);
			
		}		
		
		dsInput.next();
	}
	
	
	
	  
	IDataSet dsBusqueda = this.getDataSetBusqueda();
		
	
	Iterator iterRecluBusqueda = 
			RecluBusqueda.getCondicionesBusquedas(parametros, this.getSesion()).iterator();
	while (iterRecluBusqueda.hasNext()) {
		RecluBusqueda recluBusqueda = (RecluBusqueda) iterRecluBusqueda.next();
		cargarRegistro(dsBusqueda,recluBusqueda);
	}
	
    writeCliente(dsBusqueda);
    
  }
  
  private void cargarRegistro(IDataSet dataset, 
		   					  RecluBusqueda busqueda) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_busqueda_act", busqueda.getOIDInteger());
	  dataset.fieldValue("oid_puesto_busqueda", busqueda.getPuesto().getOIDInteger());
	  if (busqueda.getFec_inicio_busq()!=null)
		  dataset.fieldValue("fec_inicio_busq", busqueda.getFec_inicio_busq());
	  else
		  dataset.fieldValue("fec_inicio_busq", "");
	  dataset.fieldValue("cant_vacantes", busqueda.getCant_vacantes());
	  dataset.fieldValue("cant_vacantes", busqueda.getCant_vacantes());
	  if (busqueda.getMotivo_busq()!=null)
		  dataset.fieldValue("oid_motivo_busq", busqueda.getMotivo_busq().getOIDInteger());
	  else
		  dataset.fieldValue("oid_motivo_busq", "");
	  dataset.fieldValue("observaciones",  busqueda.getObservaciones());
	  if (busqueda.getOperacion()!=null)
		  dataset.fieldValue("oid_operacion", busqueda.getOperacion().getOIDInteger());
	  else
		  dataset.fieldValue("oid_operacion", "");
	  dataset.fieldValue("sueldo_bruto", busqueda.getSueldo_buto());
	  dataset.fieldValue("estado_busqueda", busqueda.getEstado_busqueda());
	  dataset.fieldValue("sexo", busqueda.getSexo());
	  if (busqueda.getTipo_contrato()!=null)
		  dataset.fieldValue("oid_tipo_contrato", busqueda.getTipo_contrato().getOIDInteger());
	  else
		  dataset.fieldValue("oid_tipo_contrato", "");
	  if (busqueda.getSelector()!=null)
		  dataset.fieldValue("oid_selector", busqueda.getSelector().getOIDInteger());
	  else
		  dataset.fieldValue("oid_selector", "");
	  if (busqueda.getEst_aprob_busq()!=null)
		  dataset.fieldValue("oid_est_aprob_busq", busqueda.getEst_aprob_busq().getOIDInteger());
	  else
		  dataset.fieldValue("oid_est_aprob_busq", "");
	  if (busqueda.getSector()!=null)
		  dataset.fieldValue("oid_sector", busqueda.getSector().getOIDInteger());
	  else
		  dataset.fieldValue("oid_sector", "");
	  dataset.fieldValue("fec_est_aprob", busqueda.getFec_est_aprob());
	  if (busqueda.getConvenio()!=null)
		  dataset.fieldValue("oid_convenio", busqueda.getConvenio().getOIDInteger());
	  else
		  dataset.fieldValue("oid_convenio", "");
	  if (busqueda.getMotivoEstado()!=null)
		  dataset.fieldValue("oid_mot_est_busq", busqueda.getMotivoEstado().getOIDInteger());
	  else
		  dataset.fieldValue("oid_mot_est_busq", "");
	  dataset.fieldValue("activo", busqueda.isActivo());
	  
  }
  
  private IDataSet getDataSetBusqueda() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TBusqueda");
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_puesto_busqueda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_inicio_busq", Field.DATE, 0));
		dataset.fieldDef(new Field("cant_vacantes", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
	    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("sueldo_bruto", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("estado_busqueda", Field.STRING, 10));
	    dataset.fieldDef(new Field("sexo", Field.STRING, 1));
	    dataset.fieldDef(new Field("oid_tipo_contrato", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_selector", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_est_aprob_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_est_aprob",Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_convenio", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_mot_est_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));		
	    return dataset;
	  }  
  
  
  
}



