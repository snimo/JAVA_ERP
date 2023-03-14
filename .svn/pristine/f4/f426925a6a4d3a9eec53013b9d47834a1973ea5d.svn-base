package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.FirmaModeloEvaluacion;
import com.srn.erp.rrhh.bm.LegjoCondModEval;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.bm.ModeloEvalGrados;
import com.srn.erp.rrhh.bm.ObsCodifEvalRango;
import com.srn.erp.rrhh.bm.RangoPtajeObsCodif;
import com.srn.erp.rrhh.bm.ValClasifCondModEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class CopiarModeloEvalRH extends Operation {

	
	int secuCondiciones = 0;
	int secuCompetencias = 0;
	int secuGrados = 0;
	int secuLegajos = 0;
	int secuFirmantes = 0;
	int secuRangoPuntos = 0;
	int secuObsCodif = 0;

	
	public CopiarModeloEvalRH() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidModeloNuevo = mapaDatos.getInteger("oid_modelo_nuevo");
		ModeloEvalCab modeloevalcab = ModeloEvalCab.findByOid(mapaDatos.getInteger("oid_modelo"), getSesion());

		IDataSet datasetModeloEvalCab = getDataSetCondModEvalCab();
		IDataSet datasetCompetencias = this.getDataSetCompetenciasCond();
		IDataSet datasetGrados = this.getDataSetModeloEvalGrados();
		IDataSet datasetLegajos = this.getDataSetLegajos();
		IDataSet datasetLegFirmante = getDataSetLegajoFirmante();
	    IDataSet datasetRangoPuntos = this.getDataSetRangoPuntos();
	    IDataSet datasetObsCodif = this.getDataSetObsCodif();
	    IDataSet dataSetClasif = getDataSetClasifCond();
	    IDataSet datasetValorClasif = getDataSetValClasifCond();
		

		Iterator iterCondModelo = modeloevalcab.getCondiciones().iterator();
		while (iterCondModelo.hasNext()) {
			CondModEvalCab condModEvalCab = (CondModEvalCab) iterCondModelo.next();
			cargarRegistroCondModEvalCab(datasetModeloEvalCab, oidModeloNuevo , condModEvalCab);
			
			
        	HashTableDatos listaValoresClasif = new HashTableDatos();
        	Iterator iterValClasif = condModEvalCab.getValoresClasif().iterator();
        	while (iterValClasif.hasNext()) {
        		ValClasifCondModEval valClasifCondModEval = (ValClasifCondModEval) iterValClasif.next();
        		listaValoresClasif.put(valClasifCondModEval.getValor_clasificador().getOIDInteger(), "");
        	}
        	
        	int secu = 0;
        	Iterator iterClasif = Legajo.getClasificadoresEntidadActivos(this.getSesion()).iterator();
        	while (iterClasif.hasNext()) {
        		ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasif.next();
        		cargarRegistroClasifCond(dataSetClasif, secu, secuCondiciones, clasif);
        		
        		int id = 0;
        		Iterator iterValClasifSel = clasif.getValoresClasificador().iterator();
        		while (iterValClasifSel.hasNext()) {
        			ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) iterValClasifSel.next();
        			
        			boolean sel = false;
        			
        			if (listaValoresClasif.get(valorClasifEnt.getOIDInteger())!=null)
        				sel = true;
        			
        			cargarRegistroValorClasif(datasetValorClasif,id,secuCondiciones,valorClasifEnt,sel);
        			++id;
        		}
        		
        		++secu;
        	}
			
			
			
        	Iterator iterCompetencias = condModEvalCab.getCompetenciasCondicion().iterator();
        	while (iterCompetencias.hasNext()) {
        		ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCompetencias.next();
        		cargarRegistroCompetenciaCond(datasetCompetencias, modeloEvalCompe);
        		
        		Iterator iterGrados = modeloEvalCompe.getGrados().iterator();
        		while (iterGrados.hasNext()) {
        			ModeloEvalGrados modeloEvalGrado = (ModeloEvalGrados) iterGrados.next();
        			cargarRegistroModeloEvalGrados(datasetGrados, modeloEvalGrado);
        		}        		        		
        		
        	}
        	
        	Iterator iterLegCond = condModEvalCab.getLegajos().iterator();
        	while (iterLegCond.hasNext()) {
        		LegjoCondModEval legjoCondModEval = (LegjoCondModEval) iterLegCond.next();
        		cargarRegistroLegajo(datasetLegajos, legjoCondModEval);
        	}
        	
        	Iterator iterLegajosFirmantes = condModEvalCab.getFirmas().iterator();
        	while (iterLegajosFirmantes.hasNext()) {
        		FirmaModeloEvaluacion firmaModeloEvaluacion = (FirmaModeloEvaluacion) iterLegajosFirmantes.next();
        		cargarRegistroLegajoFirmante(datasetLegFirmante,firmaModeloEvaluacion);
        	}
        	
        	Iterator iterRangoPuntos = condModEvalCab.getRangoPuntos().iterator();
        	while (iterRangoPuntos.hasNext()) {
        		RangoPtajeObsCodif rangoPtajeObsCodif = (RangoPtajeObsCodif) iterRangoPuntos.next();
        		cargarRegistroRangoPuntos(datasetRangoPuntos, rangoPtajeObsCodif);
        		
        		Iterator iterObsCodif = rangoPtajeObsCodif.getObsCodif().iterator();
        		while (iterObsCodif.hasNext()) {
        			ObsCodifEvalRango obsCodifEvalRango = (ObsCodifEvalRango) iterObsCodif.next();
        			cargarRegistroObsCodif(datasetObsCodif, obsCodifEvalRango);
        		}
        		
        		
        	}
        	
        	
        	
			
			
			
		}
		
		writeCliente(datasetModeloEvalCab);
		writeCliente(datasetCompetencias);
		writeCliente(datasetGrados);
		writeCliente(datasetLegajos);
		writeCliente(datasetLegFirmante);
		writeCliente(datasetRangoPuntos);
		writeCliente(datasetObsCodif);
		writeCliente(dataSetClasif);
		writeCliente(datasetValorClasif);

	}

	private IDataSet getDataSetCondModEvalCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCondModEvalCab");
		dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mod_eval_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("condicion", Field.STRING, 4000));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroCondModEvalCab(IDataSet dataset, Integer oidNuevoModelo, CondModEvalCab condModEvalCab) throws BaseException {
		--secuCondiciones;
		dataset.append();
		dataset.fieldValue("oid_cond_mod", secuCondiciones);
		dataset.fieldValue("oid_mod_eval_cab", oidNuevoModelo);
		dataset.fieldValue("orden", condModEvalCab.getOrden());
		dataset.fieldValue("condicion", condModEvalCab.getCondicion());
		dataset.fieldValue("activo", condModEvalCab.isActivo());
	}
	
	private IDataSet getDataSetCompetenciasCond() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TCompetenciasCond");
		    dataset.fieldDef(new Field("oid_mod_eval_comp", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("codigo_compe", Field.STRING, 20));
		    dataset.fieldDef(new Field("titulo_compe", Field.STRING, 100));
		    dataset.fieldDef(new Field("definicion_compe", Field.STRING, 4000));
		    dataset.fieldDef(new Field("peso_competencia", Field.CURRENCY, 0));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
	}
	
	  private void cargarRegistroCompetenciaCond(IDataSet dataset, 
			  ModeloEvalCompe modeloEvalCompe) throws BaseException {
		  --secuCompetencias;
		  dataset.append();
		  dataset.fieldValue("oid_mod_eval_comp", secuCompetencias);
		  dataset.fieldValue("oid_cond_mod", secuCondiciones);
		  dataset.fieldValue("oid_competencia", modeloEvalCompe.getCompetencia().getOIDInteger());
		  dataset.fieldValue("orden", modeloEvalCompe.getOrden());
		  dataset.fieldValue("codigo_compe", modeloEvalCompe.getCodigo_compe());
		  dataset.fieldValue("titulo_compe", modeloEvalCompe.getTitulo_compe());
		  dataset.fieldValue("definicion_compe", modeloEvalCompe.getDefinicion_compe());
		  dataset.fieldValue("peso_competencia", modeloEvalCompe.getPeso_competencia());
		  dataset.fieldValue("activo", modeloEvalCompe.isActivo());
	  }
	  
	  private IDataSet getDataSetModeloEvalGrados() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TModeloEvalGrados");
		    dataset.fieldDef(new Field("oid_mov_eva_grados", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_mod_eval_comp", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("nro_grado", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("desc_grados", Field.STRING, 4000)); 
		    dataset.fieldDef(new Field("peso", Field.CURRENCY, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
	  }
	  
	  private void cargarRegistroModeloEvalGrados(IDataSet dataset, ModeloEvalGrados modeloEvalGrados) throws BaseException {
		  	--secuGrados;
		    dataset.append(); 
		    dataset.fieldValue("oid_mov_eva_grados", secuGrados);
		    dataset.fieldValue("oid_mod_eval_comp", secuCompetencias);
		    dataset.fieldValue("nro_grado", modeloEvalGrados.getNro_grado());
		    dataset.fieldValue("desc_grados", modeloEvalGrados.getDesc_grados());
		    dataset.fieldValue("peso", modeloEvalGrados.getPeso());
		    dataset.fieldValue("activo", modeloEvalGrados.isActivo());
	  }
	  
	  private void cargarRegistroLegajo(IDataSet dataset, 
				LegjoCondModEval aLegjoCondModEval) throws BaseException {
		  --secuLegajos;
		  dataset.append();  
		  dataset.fieldValue("oid_leg_cond_mod", secuLegajos);
		  dataset.fieldValue("oid_legajo", aLegjoCondModEval.getLegajo().getOIDInteger());
		  dataset.fieldValue("oid_cond_mod", secuCondiciones);
		  dataset.fieldValue("cod_legajo", aLegjoCondModEval.getLegajo().getCodigo());
		  dataset.fieldValue("desc_legajo", aLegjoCondModEval.getLegajo().getApellidoyNombre());
		  dataset.fieldValue("activo", aLegjoCondModEval.isActivo());
	  }
	  
	  private IDataSet getDataSetLegajos() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TLegajosCond");
		    dataset.fieldDef(new Field("oid_leg_cond_mod", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
		    dataset.fieldDef(new Field("desc_legajo", Field.STRING, 100));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }
	
	  private IDataSet getDataSetLegajoFirmante() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TFirmasCond");
		    dataset.fieldDef(new Field("oid_mov_eval_firm", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("nro_firma", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		    dataset.fieldDef(new Field("oid_legajo_firma", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("cod_legajo_firma", Field.STRING, 50));
		    dataset.fieldDef(new Field("desc_legajo_firma", Field.STRING, 100));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }
	  
	  private void cargarRegistroLegajoFirmante(IDataSet dataset, 
			  FirmaModeloEvaluacion firmaModeloEval) throws BaseException {
		  --secuFirmantes;
		  dataset.append();
		  dataset.fieldValue("oid_mov_eval_firm", secuFirmantes);
		  dataset.fieldValue("oid_cond_mod", secuCondiciones);
		  dataset.fieldValue("nro_firma", firmaModeloEval.getNro_firma());
		  dataset.fieldValue("titulo", firmaModeloEval.getTitulo());
		  dataset.fieldValue("oid_legajo_firma", firmaModeloEval.getLegajo_firma().getOIDInteger());
		  dataset.fieldValue("cod_legajo_firma", firmaModeloEval.getLegajo_firma().getNro_legajo());
		  dataset.fieldValue("desc_legajo_firma", firmaModeloEval.getLegajo_firma().getApellidoyNombre());
		  dataset.fieldValue("activo", firmaModeloEval.isActivo());
	  }
	  
	  private IDataSet getDataSetRangoPuntos() { 
			IDataSet dataset = new TDataSet(); 
			dataset.create("TObsCodigSegunPtos");
			dataset.fieldDef(new Field("oid_mod_obs_codif", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
			dataset.fieldDef(new Field("puntaje_desde", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("puntaje_hasta", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
			return dataset;
	  }
	  
	  private IDataSet getDataSetObsCodif() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TObsCodifEvalRango");
		    dataset.fieldDef(new Field("oid_mod_obs_det", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_mod_obs_codif", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_obs_codif", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("cod_obs_codif", Field.STRING, 20));
		    dataset.fieldDef(new Field("descripcion", Field.STRING, 4000));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }
	  
	  private void cargarRegistroObsCodif(IDataSet dataset, 
			  ObsCodifEvalRango obsCodif) throws BaseException {
		  --secuObsCodif;
		  dataset.append();
		  dataset.fieldValue("oid_mod_obs_det", secuObsCodif);
		  dataset.fieldValue("oid_mod_obs_codif", secuRangoPuntos);
		  dataset.fieldValue("orden", obsCodif.getOrden());
		  dataset.fieldValue("oid_obs_codif", obsCodif.getOid_obs_codif().getOIDInteger());
		  dataset.fieldValue("cod_obs_codif", obsCodif.getOid_obs_codif().getCodigo());
		  dataset.fieldValue("descripcion", obsCodif.getDescripcion());
		  dataset.fieldValue("activo", obsCodif.isActivo());
	  }

	  
	  private void cargarRegistroRangoPuntos(
			  IDataSet dataset, 
	          RangoPtajeObsCodif aRangoPtajeObsCodif) throws BaseException {
		  --secuRangoPuntos;
		  dataset.append(); 
		  dataset.fieldValue("oid_mod_obs_codif", secuRangoPuntos);
		  dataset.fieldValue("oid_cond_mod", secuCondiciones);
		  dataset.fieldValue("puntaje_desde", aRangoPtajeObsCodif.getPuntaje_desde());
		  dataset.fieldValue("puntaje_hasta", aRangoPtajeObsCodif.getPuntaje_hasta());
		  dataset.fieldValue("activo" , aRangoPtajeObsCodif.isActivo());
	  }
	  

	  private IDataSet getDataSetClasifCond() { 
			IDataSet dataset = new TDataSet(); 
			dataset.create("TClasificadoresCond");
			dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
			dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
			dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));
			return dataset;
	  }  

	  private void cargarRegistroClasifCond(IDataSet dataset,int secu, Integer oidCondModEvalCab , ClasificadorEntidad clasificador) throws BaseException {
		  dataset.append(); 
		  dataset.fieldValue("secu", secu); 
		  dataset.fieldValue("oid_cond_mod", oidCondModEvalCab);
		  dataset.fieldValue("oid_clasificador", clasificador.getOIDInteger());
		  dataset.fieldValue("desc_clasificador", clasificador.getDescripcion());
		  
	  }

	  private void cargarRegistroValorClasif(
			  IDataSet dataset , int secu, Integer oidCondModEvalCab , ValorClasificadorEntidad valor, boolean activo) throws BaseException {
		  dataset.append();
		  dataset.fieldValue("secu", secu);
		  dataset.fieldValue("oid_cond_mod", oidCondModEvalCab);
		  dataset.fieldValue("oid_clasificador", valor.getClasificador_entidad().getOIDInteger());
		  dataset.fieldValue("oid_val_clasif", valor.getOIDInteger());
		  dataset.fieldValue("cod_val_clasif", valor.getCodigo());
		  dataset.fieldValue("desc_val_clasif", valor.getDescripcion());
		  dataset.fieldValue("activo", activo);
	  }
	  

	  private IDataSet getDataSetValClasifCond() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TValoresClasificadoresCond");
		    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_cond_mod", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("cod_val_clasif", Field.STRING, 50));
		    dataset.fieldDef(new Field("desc_val_clasif", Field.STRING, 100));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }
	  
}
