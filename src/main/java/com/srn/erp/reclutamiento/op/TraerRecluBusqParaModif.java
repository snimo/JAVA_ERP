package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluBusqParaModif extends Operation { 

  public TraerRecluBusqParaModif() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetBusqueda();
	  RecluBusqueda busqueda = RecluBusqueda.findByOidProxy(mapaDatos.getInteger("oid_busqueda"), this.getSesion());
	  cargarBusqueda(ds,busqueda);
	  writeCliente(ds);
    
  }
  
  private void cargarBusqueda(IDataSet ds, RecluBusqueda busqueda) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_busqueda_act", busqueda.getOIDInteger());
	  ds.fieldValue("fec_inicio_busq", busqueda.getFec_inicio_busq());
	  if (busqueda.getOperacion()!=null)
		  ds.fieldValue("oid_operacion", busqueda.getOperacion().getOIDInteger());
	  else
		  ds.fieldValue("oid_operacion", "");
	  if (busqueda.getPuesto()!=null)
		  ds.fieldValue("oid_puesto_busqueda", busqueda.getPuesto().getOIDInteger());
	  else
		  ds.fieldValue("oid_puesto_busqueda", "");
	  ds.fieldValue("vacantes", busqueda.getCant_vacantes());
	  if (busqueda.getMotivo_busq()!=null)
		  ds.fieldValue("oid_motivo_busq", busqueda.getMotivo_busq().getOIDInteger());
	  else
		  ds.fieldValue("oid_motivo_busq", "");
	  ds.fieldValue("observaciones", busqueda.getObservaciones());
	  if (busqueda.getConvenio()!=null)
		  ds.fieldValue("oid_clase_sindicato", busqueda.getConvenio().getOIDInteger());
	  else
		  ds.fieldValue("oid_clase_sindicato", "");
	  if (busqueda.getSector()!=null)
		  ds.fieldValue("oid_sector", busqueda.getSector().getOIDInteger());
	  else
		  ds.fieldValue("oid_sector", "");
	  ds.fieldValue("sueldo_bruto", busqueda.getSueldo_buto());
	  ds.fieldValue("sexo", busqueda.getSexo());
	  if (busqueda.getEst_aprob_busq()!=null)
		  ds.fieldValue("oid_est_aprob_busq", busqueda.getEst_aprob_busq().getOIDInteger());
	  else
		  ds.fieldValue("oid_est_aprob_busq", "");
	  ds.fieldValue("fec_est_aprob", busqueda.getFec_est_aprob());
	  if (busqueda.getSelector()!=null)
		  ds.fieldValue("oid_selector", busqueda.getSelector().getOIDInteger());
	  else
		  ds.fieldValue("oid_selector", "");
	  if (busqueda.getTipo_contrato()!=null)
		  ds.fieldValue("oid_tipo_contrato", busqueda.getTipo_contrato().getOIDInteger());
	  else
		  ds.fieldValue("oid_tipo_contrato", "");
	  if (busqueda.getMotivoEstado()!=null)
		  ds.fieldValue("oid_mot_est_busq",busqueda.getMotivoEstado().getOIDInteger());
	  else
		  ds.fieldValue("oid_mot_est_busq","");
	  ds.fieldValue("estado_busqueda", busqueda.getEstado_busqueda());	  
	  ds.fieldValue("activo", busqueda.isActivo());
	  ds.fieldValue("fec_cierre", busqueda.getFechaCierre());
  }
  
  private IDataSet getDataSetBusqueda() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TBusqueda");
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_inicio_busq", Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_puesto_busqueda", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("vacantes", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_motivo_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
	    dataset.fieldDef(new Field("oid_clase_sindicato", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("sueldo_bruto", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("sexo", Field.STRING, 1));
	    dataset.fieldDef(new Field("oid_est_aprob_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_est_aprob", Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_selector", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tipo_contrato",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_mot_est_busq",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("estado_busqueda", Field.STRING, 10)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_cierre", Field.DATE, 0));
	    return dataset;
  }  

  
  
  
}



