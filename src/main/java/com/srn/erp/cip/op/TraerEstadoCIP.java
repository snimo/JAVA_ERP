package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoEstado;
import com.srn.erp.cip.bm.EquivalenciaEstadoCIP;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.MotEntInterEst;
import com.srn.erp.cip.bm.MotivoEntIntermedias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoCIP extends Operation {

	public TraerEstadoCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EstadoCIP estadocip = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			estadocip = EstadoCIP.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			estadocip = EstadoCIP.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEstadoCIP = getDataSetEstadoCIP();
		IDataSet datasetEquivEstCIP = getDataSetEquivalenciaEstadoCIP();
		IDataSet datasetAccInter = getDataSetMotAccesosIntermedios();
		IDataSet datasetCategAccesos = this.getDataSetCategAccesoEstado();

		if (estadocip != null) {

			cargarRegistroEstadoCIP(datasetEstadoCIP, estadocip.getOIDInteger(), estadocip.getCodigo(), estadocip.getDescripcion(),
					estadocip.getTipo_ingreso(), estadocip.getTipo_egreso(), estadocip.isActivo(), estadocip.getLeyendaIngDenegado(),
					estadocip.getLeyendaEgrDenegado(), estadocip.isActivarAntiPassBack(), estadocip.isSusceptibleCacheo() ,
					estadocip.getMinEntAntEntrada() , estadocip.getMinEntDesEntrada());

			Iterator iterEquiv = estadocip.getEquivalencias().iterator();
			while (iterEquiv.hasNext()) {
				EquivalenciaEstadoCIP equivEstadoCIP = (EquivalenciaEstadoCIP) iterEquiv.next();
				cargarRegistroEquivalenciaEstadoCIP(datasetEquivEstCIP, equivEstadoCIP);
			}
			
			traerMotivosAccesosIntermedios(datasetAccInter,estadocip);
			traerCategoriasAccesos(datasetCategAccesos,estadocip);

		}

		writeCliente(datasetEstadoCIP);
		writeCliente(datasetEquivEstCIP);
		writeCliente(datasetAccInter);
		writeCliente(datasetCategAccesos);
		
	}
	
	private void traerCategoriasAccesos(IDataSet datasetCategAccesos,
			                            EstadoCIP estadocip) throws BaseException {
		
		  int secu = 1;
		  boolean activo = false;
		 
		  Iterator iterCategAccesoCIP = 
			  CategAccesoCIP.getAllActivos(this.getSesion()).iterator();
		  while (iterCategAccesoCIP.hasNext()) {
			  CategAccesoCIP categAccesoCIP = (CategAccesoCIP) iterCategAccesoCIP.next();
			  
			  CategAccesoEstado categAccesoEstado =
				  CategAccesoEstado.getCategAccesoEstado(estadocip, categAccesoCIP, this.getSesion());
			  
			  if (categAccesoEstado!=null)
				  	activo = true;
				  else
					activo = false;
			  
			  cargarAccesoEstado(
					  datasetCategAccesos, 
					  secu, 
					  estadocip.getOIDInteger(),
					  categAccesoCIP,
					  activo);
					  
			  ++secu;
		  }
		
		
	}
	
	  private void traerMotivosAccesosIntermedios(
			  IDataSet datasetMotivosLeg,
			  EstadoCIP estado) throws BaseException {
		  int secu = 1;
		  
		  Iterator iterMotivoEntIntermedias = 
			  MotivoEntIntermedias.getMotivoEntIntermedias(this.getSesion()).iterator();
		  while (iterMotivoEntIntermedias.hasNext()) {
			  MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) iterMotivoEntIntermedias.next();
			  ++secu;
			  datasetMotivosLeg.append();
			  datasetMotivosLeg.fieldValue("secu", secu);
			  datasetMotivosLeg.fieldValue("oid_estado", estado.getOID());
			  MotEntInterEst motEntInterEst =
				  MotEntInterEst.getMotEntInterEstado(motivoEntIntermedias, estado, this.getSesion());
			  
			  if (motEntInterEst!=null) 		  
				  datasetMotivosLeg.fieldValue("habilitado", true);
			  else
				  datasetMotivosLeg.fieldValue("habilitado", false);
			  
			  datasetMotivosLeg.fieldValue("oid_motivo", motivoEntIntermedias.getOIDInteger());
			  datasetMotivosLeg.fieldValue("desc_motivo", motivoEntIntermedias.getDescripcion());
		  }
	  }
	  
	  private IDataSet getDataSetMotAccesosIntermedios() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TMotAccesosIntermedios");
		    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
			dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));		
			dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
			dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));		
		    return dataset;
	  }
	  
	private IDataSet getDataSetCategAccesoEstado() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TCatAccesoEstado");
		    dataset.fieldDef(new Field("oid_acc_est", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_categ_acceso", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("desc_categ_acceso", Field.STRING, 100));
		    dataset.fieldDef(new Field("activo" , Field.BOOLEAN, 0));
		    return dataset;
	}
	
	private void cargarAccesoEstado(
			IDataSet dsEstado,
			int oidAccesoEstado,
			int oidEstado,
			CategAccesoCIP categoria,
			boolean activo) throws BaseException {
		
		dsEstado.append();
		dsEstado.fieldValue("oid_acc_est", oidAccesoEstado);
		dsEstado.fieldValue("oid_estado", oidEstado);
		dsEstado.fieldValue("oid_categ_acceso", categoria.getOIDInteger());
		dsEstado.fieldValue("desc_categ_acceso", categoria.getDescripcion());
		dsEstado.fieldValue("activo", activo);
	}
			
	  
	private IDataSet getDataSetEstadoCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoCIP");
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_ingreso", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_egreso", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ley_ing_denegado", Field.STRING, 50));
		dataset.fieldDef(new Field("ley_egr_denegado", Field.STRING, 50));
		dataset.fieldDef(new Field("act_anti_pass_back", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_suscep_cacheo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("min_ent_ant_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_ent", Field.INTEGER, 0));

		return dataset;
	}

	private void cargarRegistroEstadoCIP(IDataSet dataset, Integer oid_estado, String codigo, String descripcion, String tipo_ingreso,
			String tipo_egreso, Boolean activo, String leyendaIngDenegado, String leyendaEgrDenegado, Boolean activarAntiPassBack,
			Boolean esSusceptibleCacheo, Integer minEntAntes , Integer minEntDespues) {
		dataset.append();
		dataset.fieldValue("oid_estado", oid_estado);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("tipo_ingreso", tipo_ingreso);
		dataset.fieldValue("tipo_egreso", tipo_egreso);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("ley_ing_denegado", leyendaIngDenegado);
		dataset.fieldValue("ley_egr_denegado", leyendaEgrDenegado);
		dataset.fieldValue("act_anti_pass_back", activarAntiPassBack);
		dataset.fieldValue("es_suscep_cacheo", esSusceptibleCacheo);
		dataset.fieldValue("min_ent_ant_ent", minEntAntes);
		dataset.fieldValue("min_ent_des_ent", minEntDespues);
		
	}

	private IDataSet getDataSetEquivalenciaEstadoCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEquivalenciaEstadoCIP");
		dataset.fieldDef(new Field("oid_equiv_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_externo", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEquivalenciaEstadoCIP(IDataSet dataset, EquivalenciaEstadoCIP equivEstadoCIP) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_equiv_estado", equivEstadoCIP.getOIDInteger());
		dataset.fieldValue("oid_estado", equivEstadoCIP.getEstado().getOIDInteger());
		dataset.fieldValue("codigo_externo", equivEstadoCIP.getCodigo_externo());
		dataset.fieldValue("activo", equivEstadoCIP.isActivo());
	}

}
