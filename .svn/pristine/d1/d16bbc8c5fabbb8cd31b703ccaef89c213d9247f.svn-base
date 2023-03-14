package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluConvenio;
import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;
import com.srn.erp.reclutamiento.bm.RecluMotiEstBusq;
import com.srn.erp.reclutamiento.bm.RecluMotivoBusqueda;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;
import com.srn.erp.reclutamiento.bm.RecluTipoContrato;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveRecluAltaBusqueda extends Operation { 

  public SaveRecluAltaBusqueda() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TBusqueda"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	  
	IDataSet ds = this.getDataSetBusqueda();  
	  
    dataset.first(); 
      while (!dataset.EOF()) { 
    	RecluBusqueda recluBusqueda = null;
    	if (dataset.getInteger("oid_busqueda_act")!=null)
    		recluBusqueda = RecluBusqueda.findByOid(dataset.getInteger("oid_busqueda_act"), this.getSesion());
    			else
    		recluBusqueda = (RecluBusqueda)RecluBusqueda.getNew(RecluBusqueda.NICKNAME, this.getSesion());
    	recluBusqueda.setFec_alta(Util.getFechaActual(this.getSesion()));
    	recluBusqueda.setPuesto(RecluPuesto.findByOidProxy(dataset.getInteger("oid_puesto_busqueda"), this.getSesion()));
    	recluBusqueda.setFec_inicio_busq(dataset.getDate("fec_inicio_busq"));
    	recluBusqueda.setCant_vacantes(dataset.getInteger("vacantes"));
    	recluBusqueda.setMotivo_busq(RecluMotivoBusqueda.findByOidProxy(dataset.getInteger("oid_motivo_busq"), this.getSesion()));
    	recluBusqueda.setObservaciones(dataset.getString("observaciones"));
    	recluBusqueda.setOperacion(RecluOperacion.findByOidProxy(dataset.getInteger("oid_operacion"), this.getSesion()));
    	recluBusqueda.setSueldo_buto(dataset.getMoney("sueldo_bruto"));
    	
    	recluBusqueda.setEstado_busqueda(dataset.getString("estado_busqueda"));
    	recluBusqueda.setSexo(dataset.getString("sexo"));
    	recluBusqueda.setTipo_contrato(RecluTipoContrato.findByOidProxy(dataset.getInteger("oid_tipo_contrato"), this.getSesion()));
    	recluBusqueda.setSelector(RecluSelector.findByOidProxy(dataset.getInteger("oid_selector"), this.getSesion()));
    	recluBusqueda.setEst_aprob_busq(RecluEstAprobBusq.findByOidProxy(dataset.getInteger("oid_est_aprob_busq"), this.getSesion()));
    	recluBusqueda.setSector(RecluSectores.findByOidProxy(dataset.getInteger("oid_sector"), this.getSesion()));
    	recluBusqueda.setFec_est_aprob(dataset.getDate("fec_est_aprob"));
    	recluBusqueda.setMotivoEstado(RecluMotiEstBusq.findByOidProxy(dataset.getInteger("oid_mot_est_busq"), this.getSesion()));
    	recluBusqueda.setConvenio(RecluConvenio.findByOidProxy(dataset.getInteger("oid_clase_sindicato"), this.getSesion()));
    	recluBusqueda.setActivo(dataset.getBoolean("activo"));
    	if ((recluBusqueda.getEstado_busqueda()!=null) && (recluBusqueda.getEstado_busqueda().equals(RecluBusqueda.getEstadoBusqCerrada())))
    		recluBusqueda.setFechaCierre(Util.getFechaActual(this.getSesion()));
    	else
    		recluBusqueda.setFechaCierre(null);
    	
    	// Recorro los candidatos de la Busqueda y si encuentro un estado no apto no permito cerrarla
    	if (recluBusqueda.getEstadoBusqCerrada().equals(recluBusqueda.getEstado_busqueda())) {
        	Iterator iterCandidatos = recluBusqueda.getCandidatos().iterator();
        	while (iterCandidatos.hasNext()) {
        		RecluCandidatoBusq recluCandidatoBusq = (RecluCandidatoBusq) iterCandidatos.next();
        		
        		if (!recluCandidatoBusq.getEstado_busqueda().isPuedeCerrarBusqueda())
        			throw new ExceptionValidation(null,"No se puede cerrar las búsqueda porque el candidato "+
        										 recluCandidatoBusq.getOid_postulante().getApe_y_nom()+" se encuentra en estado '"+recluCandidatoBusq.getEstado_busqueda().getDescripcion()+"'");
        		
        	}
    		
    	}
    	
    	
    	// Agregar a la Busquedas en forma automatica los procesos
    	int nroOrden = 0;
    	Iterator iterProcActivos = RecluProceso.getProcesosActivos(this.getSesion()).iterator();
    	while (iterProcActivos.hasNext()) {
    		RecluProceso proceso = (RecluProceso) iterProcActivos.next();
    	    		
    		++nroOrden;
    		RecluProcDefEnBusq recluProcDefEnBusq = (RecluProcDefEnBusq) RecluProcDefEnBusq.getNew(RecluProcDefEnBusq.NICKNAME, this.getSesion());
    		recluProcDefEnBusq.setBusqueda(recluBusqueda);
    		recluProcDefEnBusq.setOrden(nroOrden);
    		recluProcDefEnBusq.setProceso(proceso);
    		recluProcDefEnBusq.setFecha_asigno(Util.getFechaActual(this.getSesion()));
    		recluProcDefEnBusq.setConceptoProceso(proceso.getConceptoProcesoDefault());
    		recluProcDefEnBusq.setTipoFormulario(null);
    		recluProcDefEnBusq.setActivo(true);
    		recluBusqueda.addDefinicionProceso(recluProcDefEnBusq);
    		
    		
    	}
    	
    	recluBusqueda.save();
    	
    	cargarRegistro(ds, recluBusqueda.getOIDInteger());
    	
        dataset.next();
    }
      
    writeCliente(ds);  
  }
  
  private IDataSet getDataSetBusqueda() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TAltaBusqueda");
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    return dataset;
	  }

  private void cargarRegistro(IDataSet dataset,
	                         Integer oidBusquedaAct) {
	    dataset.append();
	    dataset.fieldValue("oid_busqueda_act", oidBusquedaAct);
  }  
  
}
