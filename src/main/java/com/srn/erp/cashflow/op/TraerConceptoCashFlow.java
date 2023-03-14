package com.srn.erp.cashflow.op;

import java.util.Iterator;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.ConfProgConcCF;
import com.srn.erp.cashflow.bm.EsceConceptoCFHab;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.GrupoConceptoCF;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConceptoCashFlow extends Operation {

	public TraerConceptoCashFlow() {
	}
	
	private int secu = -100000;

	public void execute(MapDatos mapaDatos) throws BaseException {
		ConceptoCashFlow conceptocashflow = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			conceptocashflow = ConceptoCashFlow.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			conceptocashflow = ConceptoCashFlow.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetConceptoCashFlow = getDataSetConceptoCashFlow();
		IDataSet datasetConfProg = getDataSetConfProgConcepto();
		IDataSet datasetEsceHab = getDataSetEscenarioHabilitado();
		
		if (conceptocashflow != null) {
			
			cargarRegistroConceptoCashFlow(
					datasetConceptoCashFlow, 
					conceptocashflow.getOIDInteger(), 
					conceptocashflow.getCodigo(),
					conceptocashflow.getDescripcion(), 
					conceptocashflow.isActivo(), 
					conceptocashflow.getGrupo_concepto());
			
			Iterator iterConfProgConc = 
				conceptocashflow.getConfProgConc().iterator();
			while (iterConfProgConc.hasNext()) {
				ConfProgConcCF confProgConcCF = (ConfProgConcCF) iterConfProgConc.next();
				if (!confProgConcCF.isActivo()) continue;
				cargarRegistroCondifProgConcepto(datasetConfProg, confProgConcCF);
			}
			
			Iterator iterEsceCF = 
				EscenarioCashFlow.getEscenariosCF(this.getSesion()).iterator();
			while (iterEsceCF.hasNext()) {
				EscenarioCashFlow escenarioCF = (EscenarioCashFlow) iterEsceCF.next();
				EsceConceptoCFHab esceConceptoCFHab = 
					EsceConceptoCFHab.getEscenariosConcHab(conceptocashflow, escenarioCF, this.getSesion());
				if (esceConceptoCFHab!=null)
					cargarRegistroEsceHab(datasetEsceHab, esceConceptoCFHab);
				else {
					datasetEsceHab.append();
					datasetEsceHab.fieldValue("oid_esce_conc", --secu);
					datasetEsceHab.fieldValue("oid_concepto", conceptocashflow.getOIDInteger());
					datasetEsceHab.fieldValue("oid_escenario", escenarioCF.getOIDInteger());
					datasetEsceHab.fieldValue("descripcion", escenarioCF.getDescripcion());
					datasetEsceHab.fieldValue("activo", new Boolean(false));
				}
				
			}
			
		}
		
		writeCliente(datasetConceptoCashFlow);
		writeCliente(datasetConfProg);
		writeCliente(datasetEsceHab);
		
	}

	private IDataSet getDataSetConceptoCashFlow() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptoCashFlow");
		dataset.fieldDef(new Field("oid_concepto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_grupo_concepto", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_grupo_concepto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_concepto", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetConfProgConcepto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConfProgConc");
		dataset.fieldDef(new Field("oid_prog_conc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_concepto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_mes", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetEscenarioHabilitado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEscenarioConcepto");
		dataset.fieldDef(new Field("oid_esce_conc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_concepto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	
	private void cargarRegistroCondifProgConcepto(
			IDataSet dataset,
			ConfProgConcCF confProgConcepto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_prog_conc", confProgConcepto.getOIDInteger());
		dataset.fieldValue("oid_concepto", confProgConcepto.getConcepto().getOIDInteger());
		dataset.fieldValue("nro_mes", confProgConcepto.getNro_mes());
		dataset.fieldValue("dia", confProgConcepto.getDia());
		dataset.fieldValue("monto", confProgConcepto.getMonto());
		dataset.fieldValue("oid_moneda", confProgConcepto.getMoneda().getOIDInteger());
		dataset.fieldValue("activo", confProgConcepto.isActivo());
	}
	
	private void cargarRegistroEsceHab(
			IDataSet dataset,
			EsceConceptoCFHab esceHab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_esce_conc", esceHab.getOIDInteger());
		dataset.fieldValue("oid_concepto", esceHab.getConcepto_cf().getOIDInteger());
		dataset.fieldValue("oid_escenario", esceHab.getEscenario_cf().getOIDInteger());
		dataset.fieldValue("descripcion", esceHab.getEscenario_cf().getDescripcion());
		dataset.fieldValue("activo", esceHab.isActivo());
	}
	
	

	private void cargarRegistroConceptoCashFlow(IDataSet dataset, Integer oid_concepto, String codigo, String descripcion, Boolean activo,
			GrupoConceptoCF grupoConcepto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_concepto", oid_concepto);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("oid_grupo_concepto", grupoConcepto.getOIDInteger());
		dataset.fieldValue("cod_grupo_concepto", grupoConcepto.getCodigo());
		dataset.fieldValue("desc_grupo_concepto", grupoConcepto.getDescripcion());
	}
	
}
