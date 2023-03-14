package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.*;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveModeloEvalCab extends Operation { 

  public SaveModeloEvalCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TModeloEvalCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ModeloEvalCab modeloevalcab = ModeloEvalCab.findByOid(dataset.getInteger("oid_mod_eval_cab"),getSesion());
        modeloevalcab.setOID(dataset.getInteger("oid_mod_eval_cab"));
        modeloevalcab.setTitulo(dataset.getString("titulo"));
        modeloevalcab.setDesc_abreviada(dataset.getString("desc_abreviada"));
        modeloevalcab.setFec_desde(dataset.getDate("fec_desde"));
        modeloevalcab.setFec_hasta(dataset.getDate("fec_hasta"));
        modeloevalcab.setVigente(dataset.getBoolean("vigente"));
        modeloevalcab.setActivo(dataset.getBoolean("activo"));
        modeloevalcab.setTipo(dataset.getString("tipo"));
        
        IDataSet dsCondModelo = dataset.getDataSet("TCondModEvalCab");
        dsCondModelo.first();
        while (!dsCondModelo.EOF()) {
        	CondModEvalCab condModEvalCab = CondModEvalCab.findByOid(dsCondModelo.getInteger("oid_cond_mod"), this.getSesion());
        	condModEvalCab.setModelo_eval_cab(modeloevalcab);
        	condModEvalCab.setOrden(dsCondModelo.getInteger("orden"));
        	condModEvalCab.setCondicion(dsCondModelo.getString("condicion"));
        	condModEvalCab.setActivo(dsCondModelo.getBoolean("activo"));
        	modeloevalcab.addCondicion(condModEvalCab);
        	
        	
        	IDataSet dsCompetenciasCond = dsCondModelo.getDataSet("TCompetenciasCond");
        	dsCompetenciasCond.first();
        	while (!dsCompetenciasCond.EOF()) {
        		ModeloEvalCompe modeloEvalCompe = ModeloEvalCompe.findByOid(dsCompetenciasCond.getInteger("oid_mod_eval_comp"), this.getSesion());
        		modeloEvalCompe.setCondicion_modelo(condModEvalCab);
        		modeloEvalCompe.setCompetencia(Competencia.findByOidProxy(dsCompetenciasCond.getInteger("oid_competencia"), this.getSesion()));
        		modeloEvalCompe.setOrden(dsCompetenciasCond.getInteger("orden"));
        		modeloEvalCompe.setCodigo_compe(dsCompetenciasCond.getString("codigo_compe"));
        		modeloEvalCompe.setTitulo_compe(dsCompetenciasCond.getString("titulo_compe"));
        		modeloEvalCompe.setDefinicion_compe(dsCompetenciasCond.getString("definicion_compe"));
        		modeloEvalCompe.setPeso_competencia(dsCompetenciasCond.getMoney("peso_competencia"));
        		modeloEvalCompe.setActivo(dsCompetenciasCond.getBoolean("activo"));
        		condModEvalCab.addCondModEvalCab(modeloEvalCompe);
        		
        		IDataSet dsGrados = dsCompetenciasCond.getDataSet("TModeloEvalGrados");
        		dsGrados.first();
        		while (!dsGrados.EOF()) {
        			ModeloEvalGrados modeloEvalGrados = ModeloEvalGrados.findByOid(dsGrados.getInteger("oid_mov_eva_grados"), this.getSesion());
        			modeloEvalGrados.setModelo_evaluacion(modeloEvalCompe.findByOidProxy(dsGrados.getInteger("oid_mod_eval_comp"), this.getSesion()));
        			modeloEvalGrados.setNro_grado(dsGrados.getInteger("nro_grado"));
        			modeloEvalGrados.setDesc_grados(dsGrados.getString("desc_grados"));
        			modeloEvalGrados.setPeso(dsGrados.getMoney("peso"));
        			modeloEvalGrados.setActivo(dsGrados.getBoolean("activo"));
        			modeloEvalCompe.addGrado(modeloEvalGrados);
        			dsGrados.next();
        		}
        		
        		
        		dsCompetenciasCond.next();
        	}
        	
        	
        	// Grabar las Firmas
        	IDataSet dsLegajosFirmas = dsCondModelo.getDataSet("TFirmasCond");
        	dsLegajosFirmas.first();
        	while (!dsLegajosFirmas.EOF()) {
        		FirmaModeloEvaluacion firmaModeloEvaluacion = 
        			FirmaModeloEvaluacion.findByOid(dsLegajosFirmas.getInteger("oid_mov_eval_firm"), this.getSesion()); 
        		firmaModeloEvaluacion.setCondicion_modelo(condModEvalCab);
        		firmaModeloEvaluacion.setNro_firma(dsLegajosFirmas.getInteger("nro_firma"));
        		firmaModeloEvaluacion.setTitulo(dsLegajosFirmas.getString("titulo"));
        		firmaModeloEvaluacion.setLegajo_firma(Legajo.findByOidProxy(dsLegajosFirmas.getInteger("oid_legajo_firma"), this.getSesion()));
        		firmaModeloEvaluacion.setActivo(dsLegajosFirmas.getBoolean("activo"));
        		
        		condModEvalCab.addFirma(firmaModeloEvaluacion);
        		dsLegajosFirmas.next();
        	}
        	
        	// Gragar los Legajos
        	IDataSet dsLegajosCond = dsCondModelo.getDataSet("TLegajosCond");
        	dsLegajosCond.first();
        	while (!dsLegajosCond.EOF()) {
        		LegjoCondModEval legjoCondModEval = (LegjoCondModEval) LegjoCondModEval.findByOid(dsLegajosCond.getInteger("oid_leg_cond_mod"), this.getSesion());
        		legjoCondModEval.setLegajo(Legajo.findByOidProxy(dsLegajosCond.getInteger("oid_legajo"), this.getSesion()));
        		legjoCondModEval.setCondicion_modelo(condModEvalCab);
        		legjoCondModEval.setActivo(dsLegajosCond.getBoolean("activo"));
        		condModEvalCab.addLegajo(legjoCondModEval);
        		dsLegajosCond.next();
        	}
        	
        	// Gragar los rangos de puntos
        	IDataSet dsRangoPuntos = dsCondModelo.getDataSet("TObsCodigSegunPtos");
        	dsRangoPuntos.first();
        	while (!dsRangoPuntos.EOF()) {
        		RangoPtajeObsCodif rangoPtajeObsCodif = (RangoPtajeObsCodif) RangoPtajeObsCodif.findByOid(dsRangoPuntos.getInteger("oid_mod_obs_codif"), this.getSesion());
        		rangoPtajeObsCodif.setCond_modelo(condModEvalCab);
        		rangoPtajeObsCodif.setPuntaje_desde(dsRangoPuntos.getMoney("puntaje_desde"));
        		rangoPtajeObsCodif.setPuntaje_hasta(dsRangoPuntos.getMoney("puntaje_hasta"));
        		rangoPtajeObsCodif.setActivo(dsRangoPuntos.getBoolean("activo"));
        		
        		IDataSet dsObsCodif = dsRangoPuntos.getDataSet("TObsCodifEvalRango");
        		dsObsCodif.first();
        		while (!dsObsCodif.EOF()) {
        			ObsCodifEvalRango obsCodifEvalRango = ObsCodifEvalRango.findByOid(dsObsCodif.getInteger("oid_mod_obs_det"), this.getSesion());
        			obsCodifEvalRango.setMod_obs_codif(rangoPtajeObsCodif);
        			obsCodifEvalRango.setOid_obs_codif(ObsCodifEvalRH.findByOidProxy(dsObsCodif.getInteger("oid_obs_codif"), this.getSesion()));
        			obsCodifEvalRango.setDescripcion(dsObsCodif.getString("descripcion"));
        			obsCodifEvalRango.setActivo(dsObsCodif.getBoolean("activo"));
        			rangoPtajeObsCodif.addObsCodif(obsCodifEvalRango);
        			dsObsCodif.next();
        		}
        		
        		condModEvalCab.addRangoPunto(rangoPtajeObsCodif);
        		dsRangoPuntos.next();
        	}
        	
        	
        	
        	// Recorrer los clasificadores
        	IDataSet dsClasifCond = dsCondModelo.getDataSet("TClasificadoresCond");
        	dsClasifCond.first();
        	while (!dsClasifCond.EOF()) {
        		
        		ClasificadorEntidad clasificadorEnt = 
        			ClasificadorEntidad.findByOidProxy(dsClasifCond.getInteger("oid_clasificador"), this.getSesion());
        		
        		IDataSet dsValoresClasif = dsClasifCond.getDataSet("TValoresClasificadoresCond");
        		dsValoresClasif.first();
        		while (!dsValoresClasif.EOF()) {
        			
        			ValorClasificadorEntidad valorClasifEnt =
        				ValorClasificadorEntidad.findByOidProxy(dsValoresClasif.getInteger("oid_val_clasif"), this.getSesion());
        			
        			ValClasifCondModEval valClasifCondModEval =
        				ValClasifCondModEval.getValorClasificador(condModEvalCab, clasificadorEnt, valorClasifEnt, this.getSesion());
        			
            		if (dsValoresClasif.getBoolean("activo")) {
            			
            			if (valClasifCondModEval==null) {
            				valClasifCondModEval = (ValClasifCondModEval) ValClasifCondModEval.getNew(ValClasifCondModEval.NICKNAME, this.getSesion());
            				valClasifCondModEval.setClasificador(clasificadorEnt);
            				valClasifCondModEval.setValor_clasificador(valorClasifEnt);
            				valClasifCondModEval.setActivo(true);
            				valClasifCondModEval.setCondicion_modelo(condModEvalCab);
            				condModEvalCab.addValorClasificador(valClasifCondModEval);
            			} else {
            				valClasifCondModEval.setActivo(true);
            				condModEvalCab.addValorClasificador(valClasifCondModEval);
            			}
            			
            		} else {
            			
            			if (valClasifCondModEval!=null) {
            				valClasifCondModEval.setActivo(false);
            				condModEvalCab.addValorClasificador(valClasifCondModEval);
            			}
            		}
        			
        			
        			dsValoresClasif.next();
        		}
        		
        		
        		
        		dsClasifCond.next();
        	}
        	
        	
        	dsCondModelo.next();
        }
        
        addTransaccion(modeloevalcab);
        dataset.next();
    }
  }
  
}
