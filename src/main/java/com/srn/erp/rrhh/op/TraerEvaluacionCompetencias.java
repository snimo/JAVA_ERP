package com.srn.erp.rrhh.op;

import java.sql.Types;
import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EvalAspectos;
import com.srn.erp.rrhh.bm.EvalCargaResul;
import com.srn.erp.rrhh.bm.EvalEvaluador;
import com.srn.erp.rrhh.bm.EvalFirma;
import com.srn.erp.rrhh.bm.EvalObsGen;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.FirmaModeloEvaluacion;
import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.bm.ModeloEvalGrados;
import com.srn.erp.rrhh.bm.ObsCodifEvalRH;
import com.srn.erp.rrhh.bm.ObsCodifEvalRango;
import com.srn.erp.rrhh.bm.RangoPtajeObsCodif;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEvaluacionCompetencias extends Operation { 

  public TraerEvaluacionCompetencias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EvaluacionLegajoCab evaluacion = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       evaluacion = evaluacion.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       evaluacion = EvaluacionLegajoCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet dsEvaluacion = this.getDataSetEvaluacionCAB();
    IDataSet dsCompetencias = this.getDataSetCompetencias();
    IDataSet dsOtrasEval = getDataSetOtrasVersiones();
    IDataSet dsAspectosDest = getDataSetAspectosDestacados();
    IDataSet dsAspectosAMej = getDataSetAspectosAMejorar();
    IDataSet dsObsGenRRHH = getDataSetObsGenRRHH();
    IDataSet dsObsCodif = getDataSetObsCodif(); 
    IDataSet dsEvaluadores = getDataSetEvaluadores();
    IDataSet dsFirmas = getDataSetFirmas();
    IDataSet dsModVig = getDataSetModelosVig();
    
    if (evaluacion != null) { 
    	
    	cargarEvaluacionCab(dsEvaluacion, evaluacion);
    	cargarRegistroCompetencia(dsCompetencias,evaluacion);
    	cargarRegistroOtrasVertsiones(dsOtrasEval,evaluacion);
    	cargarRegistrosAspDest(dsAspectosDest,evaluacion);
    	cargarRegistrosAspMej(dsAspectosAMej,evaluacion);
    	cargarRegistrosObsGenRRHH(dsObsGenRRHH,evaluacion);
    	cargarRegistrosObsCodif(dsObsCodif,evaluacion);
    	cargarRegistrosEvaluadores(dsEvaluadores,evaluacion);
    	cargarRegistrosFirmas(dsFirmas,evaluacion);
    	cargarRegistroModeloVig(dsModVig,evaluacion);
    }
    
    writeCliente(dsEvaluacion);
    writeCliente(dsCompetencias);
    writeCliente(dsOtrasEval);
    writeCliente(dsAspectosDest);
    writeCliente(dsAspectosAMej);
    writeCliente(dsObsGenRRHH);
    writeCliente(dsObsCodif);
    writeCliente(dsEvaluadores);
    writeCliente(dsFirmas);
    writeCliente(dsModVig);
    
  }
  
  private void cargarRegistroModeloVig(IDataSet dsModVig,EvaluacionLegajoCab evaluacion) throws BaseException {
	  dsModVig.append();
	  dsModVig.fieldValue("oid_mod_eval_cab" , evaluacion.getModelo_eval_cab().getOIDInteger());
	  dsModVig.fieldValue("titulo", evaluacion.getModelo_eval_cab().getTitulo());
	  dsModVig.fieldValue("desc_abraviada", evaluacion.getModelo_eval_cab().getDesc_abreviada());
	  dsModVig.fieldValue("fec_desde", evaluacion.getModelo_eval_cab().getFec_desde());
	  dsModVig.fieldValue("fec_hasta", evaluacion.getModelo_eval_cab().getFec_hasta());

  }

  private void cargarRegistrosObsCodif(IDataSet dsObsCodif,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  
	  HashTableDatos listaObsCodif = new HashTableDatos();
	  Iterator iterRangoPuntos = evaluacionLegajoCab.getCondModEvalCab().getRangoPuntos().iterator();
	  while (iterRangoPuntos.hasNext()) {
		  RangoPtajeObsCodif rangoPtajeObsCodif = (RangoPtajeObsCodif) iterRangoPuntos.next();
		  if ((rangoPtajeObsCodif.getPuntaje_desde()!=null) && (rangoPtajeObsCodif.getPuntaje_hasta()!=null) && (evaluacionLegajoCab.getPuntaje()!=null)) {
			  if (((double)evaluacionLegajoCab.getPuntajeEntero()>=rangoPtajeObsCodif.getPuntaje_desde().doubleValue() && ((double)evaluacionLegajoCab.getPuntajeEntero()<=rangoPtajeObsCodif.getPuntaje_hasta().doubleValue()))) {
				  Iterator iterObsCodif = rangoPtajeObsCodif.getObsCodif().iterator();
				  while (iterObsCodif.hasNext()) {
					  ObsCodifEvalRango obsCodifEvalRango = (ObsCodifEvalRango) iterObsCodif.next();
					  listaObsCodif.put(obsCodifEvalRango.getOid_obs_codif().getOIDInteger(), obsCodifEvalRango.getOid_obs_codif());
				  }
				  
			  }
		  }
	  }
	  
	  int secu = 0;
	  
	  Iterator iterObsCodif  = listaObsCodif.values().iterator();
	  while (iterObsCodif.hasNext()) {
		  ObsCodifEvalRH obsCodifEvalRH = (ObsCodifEvalRH) iterObsCodif.next();
		  ++secu;
		  dsObsCodif.append();
		  dsObsCodif.fieldValue("orden", secu);
		  dsObsCodif.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
		  dsObsCodif.fieldValue("observacion", obsCodifEvalRH.getDescripcion());
		  
	  }
	  
	  
  }

  private void cargarRegistrosFirmas(IDataSet dsFirmas,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  
	  ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
	  
	  HashTableDatos legajos = new HashTableDatos();
	  
	  Iterator iterFirmas  = evaluacionLegajoCab.getFirmas().iterator();
	  while (iterFirmas.hasNext()) {
		  EvalFirma evalFirma = (EvalFirma) iterFirmas.next();
		  
		  dsFirmas.append();
		  dsFirmas.fieldValue("oid_firma_eval", evalFirma.getOIDInteger());
		  dsFirmas.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
		  dsFirmas.fieldValue("nro_firma", evalFirma.getNro_firma());
		  if (evalFirma.getLegajo_firma()!=null) {
			  dsFirmas.fieldValue("oid_legajo_firma", evalFirma.getLegajo_firma().getOIDInteger());
			  dsFirmas.fieldValue("cod_legajo_firma", evalFirma.getLegajo_firma().getNro_legajo());
			  dsFirmas.fieldValue("desc_legajo_firma", evalFirma.getLegajo_firma().getApellidoyNombre());
			  legajos.put(evalFirma.getLegajo_firma().getOIDInteger(), "");
		  } else {
			  dsFirmas.fieldValue("oid_legajo_firma", "");
			  dsFirmas.fieldValue("cod_legajo_firma", "");
			  dsFirmas.fieldValue("desc_legajo_firma", "");
		  }
		  dsFirmas.fieldValue("firmo", evalFirma.isFirmo());
		  dsFirmas.fieldValue("fec_firma", evalFirma.getFec_firma());
		  dsFirmas.fieldValue("activo", evalFirma.isActivo());
		  ValorClasificadorEntidad valClasifEnt = null;
		  if (evalFirma.getLegajo_firma()!=null)
			  valClasifEnt = evalFirma.getLegajo_firma().getValorClasifEnt(clasifPuesto);
		  if (valClasifEnt!=null)
			  dsFirmas.fieldValue("puesto", valClasifEnt.getDescripcion());
		  else {
			  dsFirmas.fieldValue("puesto", evalFirma.getTitulo());
		  }
		  
	  }
	  
	  int secu = -100000;
	  // Recorrer los firmantes de la condicion del modelo
	  Iterator iterFirmasModelo = evaluacionLegajoCab.getCondModEvalCab().getFirmas().iterator();
	  while (iterFirmasModelo.hasNext()) {
		  FirmaModeloEvaluacion firmaModeloEvaluacion = (FirmaModeloEvaluacion) iterFirmasModelo.next();
		  --secu;
		  if (firmaModeloEvaluacion.getLegajo_firma()!=null) {
			  if (!legajos.containsKey(firmaModeloEvaluacion.getLegajo_firma().getOIDInteger())) {
				  dsFirmas.append();
				  dsFirmas.fieldValue("oid_firma_eval", secu);
				  dsFirmas.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
				  dsFirmas.fieldValue("nro_firma", 999);
				  if (firmaModeloEvaluacion.getLegajo_firma()!=null) {
					  dsFirmas.fieldValue("oid_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getOIDInteger());
					  dsFirmas.fieldValue("cod_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getNro_legajo());
					  dsFirmas.fieldValue("desc_legajo_firma", firmaModeloEvaluacion.getLegajo_firma().getApellidoyNombre());
				  } else {
					  dsFirmas.fieldValue("oid_legajo_firma", "");
					  dsFirmas.fieldValue("cod_legajo_firma", "");
					  dsFirmas.fieldValue("desc_legajo_firma", "");
				  }
				  dsFirmas.fieldValue("firmo", false);
				  dsFirmas.fieldValue("fec_firma", "");
				  dsFirmas.fieldValue("activo", true);
				  ValorClasificadorEntidad valClasifEnt = null;
				  if (firmaModeloEvaluacion.getLegajo_firma()!=null) {
					  valClasifEnt = firmaModeloEvaluacion.getLegajo_firma().getValorClasifEnt(clasifPuesto);
					  if (valClasifEnt!=null)
						  dsFirmas.fieldValue("puesto", valClasifEnt.getDescripcion());
					  else
						  dsFirmas.fieldValue("puesto", "");
					  
				  } else {
					  dsFirmas.fieldValue("puesto", firmaModeloEvaluacion.getTitulo());
				  }
				  
			  }
		  }
			  
	  }
	  
  }
  
  
  
  private void cargarRegistrosEvaluadores(IDataSet dsEvaluadores,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  
	  ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
	  
	  Iterator iterEvaluadores  = evaluacionLegajoCab.getEvaluadores().iterator();
	  while (iterEvaluadores.hasNext()) {
		  EvalEvaluador evalObsGen = (EvalEvaluador) iterEvaluadores.next();
		  
		  dsEvaluadores.append();
		  dsEvaluadores.fieldValue("oid_eval_evaluador", evalObsGen.getOIDInteger());
		  dsEvaluadores.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
		  dsEvaluadores.fieldValue("oid_legajo", evalObsGen.getLegajo().getOIDInteger());
		  dsEvaluadores.fieldValue("cod_legajo", evalObsGen.getLegajo().getNro_legajo());
		  dsEvaluadores.fieldValue("desc_legajo", evalObsGen.getLegajo().getApellidoyNombre());
		  dsEvaluadores.fieldValue("firmado", evalObsGen.isFirmado());
		  dsEvaluadores.fieldValue("fec_firmado", evalObsGen.getFec_firmado());
		  dsEvaluadores.fieldValue("activo", evalObsGen.isActivo());
		  
		  ValorClasificadorEntidad valClasifEnt = evalObsGen.getLegajo().getValorClasifEnt(clasifPuesto);
		  if (valClasifEnt!=null)
			  dsEvaluadores.fieldValue("puesto", valClasifEnt.getDescripcion());
		  else
			  dsEvaluadores.fieldValue("puesto", "");
	  }
  }
  

  
  
  private void cargarRegistrosObsGenRRHH(IDataSet dsObsGenRRHH,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  Iterator iterObsGen = evaluacionLegajoCab.getObsGenerales().iterator();
	  while (iterObsGen.hasNext()) {
		  EvalObsGen evalObsGen = (EvalObsGen) iterObsGen.next();
		  dsObsGenRRHH.append();
		  dsObsGenRRHH.fieldValue("oid_obs_gen", evalObsGen.getOIDInteger());
		  dsObsGenRRHH.fieldValue("oid_eval_cab", evalObsGen.getEvaluacion().getOIDInteger());
		  dsObsGenRRHH.fieldValue("observacion", evalObsGen.getObservacion());
		  dsObsGenRRHH.fieldValue("activo", evalObsGen.isActivo());
	  }
  }
  
  
  
  private void cargarRegistrosAspMej(IDataSet dsAspectosDest,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  Iterator iterAspDest = evaluacionLegajoCab.getAspectos().iterator();
	  while (iterAspDest.hasNext()) {
		  EvalAspectos evalAspectos = (EvalAspectos) iterAspDest.next();
		  if (evalAspectos.getTipo_aspecto().equals(EvalAspectos.ASP_MEJ)) {
			  dsAspectosDest.append();
			  dsAspectosDest.fieldValue("OID_EVAL_ASP", evalAspectos.getOIDInteger());
			  dsAspectosDest.fieldValue("OID_EVAL_CAB", evaluacionLegajoCab.getOIDInteger());
			  dsAspectosDest.fieldValue("TIPO_ASPECTO", evalAspectos.getTipo_aspecto());
			  dsAspectosDest.fieldValue("ACTIVO", evalAspectos.isActivo());
			  dsAspectosDest.fieldValue("ASPECTO", evalAspectos.getAspecto());
		  }
	  }
  }
  
  
  
  
  private void cargarRegistrosAspDest(IDataSet dsAspectosDest,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  Iterator iterAspDest = evaluacionLegajoCab.getAspectos().iterator();
	  while (iterAspDest.hasNext()) {
		  EvalAspectos evalAspectos = (EvalAspectos) iterAspDest.next();
		  if (evalAspectos.getTipo_aspecto().equals(EvalAspectos.ASP_DES)) {
			  dsAspectosDest.append();
			  dsAspectosDest.fieldValue("OID_EVAL_ASP", evalAspectos.getOIDInteger());
			  dsAspectosDest.fieldValue("OID_EVAL_CAB", evaluacionLegajoCab.getOIDInteger());
			  dsAspectosDest.fieldValue("TIPO_ASPECTO", evalAspectos.getTipo_aspecto());
			  dsAspectosDest.fieldValue("ACTIVO", evalAspectos.isActivo());
			  dsAspectosDest.fieldValue("ASPECTO", evalAspectos.getAspecto());
		  }
	  }
  }
  
  private void cargarRegistroOtrasVertsiones(IDataSet dsOtrasEval,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
	  
	  Iterator iterOtrasVersiones = 
		  EvaluacionLegajoCab.getOtrasVersiones(
				  evaluacionLegajoCab.getModelo_eval_cab(), 
				  evaluacionLegajoCab.getLegajo(), 
				  evaluacionLegajoCab, 
				  this.getSesion()).iterator();
	  
	  while (iterOtrasVersiones.hasNext()) {
		  EvaluacionLegajoCab evaluacionLegajoCabOtra = (EvaluacionLegajoCab) iterOtrasVersiones.next();
		  dsOtrasEval.append();
		  dsOtrasEval.fieldValue("oid_eval_cab", evaluacionLegajoCab.getOIDInteger());
		  dsOtrasEval.fieldValue("oid_otra_eval", evaluacionLegajoCabOtra.getOIDInteger());
		  dsOtrasEval.fieldValue("version", evaluacionLegajoCabOtra.getVersion_eval());
		  dsOtrasEval.fieldValue("fec_carga", evaluacionLegajoCabOtra.getFec_alta_carga());
		  if (evaluacionLegajoCabOtra.isActivo())
			  dsOtrasEval.fieldValue("activo" , "");
		  else
			  dsOtrasEval.fieldValue("activo" , "(Anulada)");
		  dsOtrasEval.fieldValue("puntaje" , evaluacionLegajoCabOtra.getPuntajeEntero());
		  dsOtrasEval.fieldValue("vigente", evaluacionLegajoCabOtra.isVigente());
		  
	  }
  }

  private IDataSet getDataSetFirmas() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFirmas");
	    dataset.fieldDef(new Field("oid_firma_eval", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nro_firma", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_legajo_firma", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_legajo_firma", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_legajo_firma", Field.STRING, 100));
	    dataset.fieldDef(new Field("firmo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_firma", Field.DATE, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("puesto", Field.STRING, 100));
	    return dataset;
  }
  
  private IDataSet getDataSetEvaluadores() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TEvaluadores");
	    dataset.fieldDef(new Field("oid_eval_evaluador", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_legajo", Field.STRING, 100));
	    dataset.fieldDef(new Field("firmado", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_firmado", Field.DATE, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("puesto", Field.STRING, 100));
	    return dataset;
  }
  
  
  private IDataSet getDataSetOtrasVersiones() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TOtrasVersiones");
	    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_otra_eval", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("version", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_carga", Field.DATE, 0));
	    dataset.fieldDef(new Field("activo", Field.STRING, 10));
	    dataset.fieldDef(new Field("puntaje", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("vigente", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetObsCodif() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TObsCodif");
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("observacion", Field.STRING, 400));
	    return dataset;
  }
  
  
  private IDataSet getDataSetAspectosDestacados() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAspectosDestacados");
	    dataset.fieldDef(new Field("OID_EVAL_ASP", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("OID_EVAL_CAB", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("TIPO_ASPECTO", Field.STRING, 10));
	    dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("ASPECTO", Field.MEMO, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetAspectosAMejorar() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAspectosAMejorar");
	    dataset.fieldDef(new Field("OID_EVAL_ASP", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("OID_EVAL_CAB", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("TIPO_ASPECTO", Field.STRING, 10));
	    dataset.fieldDef(new Field("ACTIVO", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("ASPECTO", Field.MEMO, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetObsGenRRHH() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TObsGenRRHH");
	    dataset.fieldDef(new Field("oid_obs_gen", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("observacion", Field.STRING, 4000));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetEvaluacionCAB() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEvaluacionCAB");
    dataset.fieldDef(new Field("oid_eval_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("version_eval", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_mod_eval_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_legajo", Field.STRING, 50));
    dataset.fieldDef(new Field("ape_nom_legajo", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_eval", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_puntuacion", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_usu_carga", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_alta_carga", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_usu_modif", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_ult_modif", Field.DATE, 0));
    dataset.fieldDef(new Field("puntaje", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("firmado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_firmado", Field.DATE, 0));
    dataset.fieldDef(new Field("comen_del_evaluado", Field.MEMO, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_empresa", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_empresa", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sector", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sector", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_puesto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_puesto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_puesto", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_estado", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_cond_mod_eval", Field.INTEGER, 0));
    dataset.fieldDef(new Field("vigente", Field.STRING, 2));
    dataset.fieldDef(new Field("oid_val_pue_fut", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_val_pue_fut", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_val_pue_fut", Field.STRING, 255));
    return dataset;
  }
  
  private void cargarEvaluacionCab(IDataSet dsEvaluacionCab,EvaluacionLegajoCab aEvaluacionLegajoCab) throws BaseException {
	  dsEvaluacionCab.append();
	  dsEvaluacionCab.fieldValue("oid_eval_cab", aEvaluacionLegajoCab.getOIDInteger());
	  dsEvaluacionCab.fieldValue("version_eval", aEvaluacionLegajoCab.getVersion_eval());
	  dsEvaluacionCab.fieldValue("oid_mod_eval_cab", aEvaluacionLegajoCab.getModelo_eval_cab().getOIDInteger());
	  dsEvaluacionCab.fieldValue("oid_legajo", aEvaluacionLegajoCab.getLegajo().getOIDInteger());
	  dsEvaluacionCab.fieldValue("cod_legajo", aEvaluacionLegajoCab.getLegajo().getNro_legajo());
	  dsEvaluacionCab.fieldValue("ape_nom_legajo", aEvaluacionLegajoCab.getLegajo().getApellidoyNombre());
	  dsEvaluacionCab.fieldValue("fec_eval", aEvaluacionLegajoCab.getFec_eval());
	  dsEvaluacionCab.fieldValue("fec_puntuacion", aEvaluacionLegajoCab.getFec_puntuacion());
	  if (aEvaluacionLegajoCab.getUsuario_alta()!=null)
		  dsEvaluacionCab.fieldValue("oid_usu_carga", aEvaluacionLegajoCab.getUsuario_alta().getOIDInteger());
	  else
		  dsEvaluacionCab.fieldValue("oid_usu_carga", "");
	  dsEvaluacionCab.fieldValue("fec_alta_carga", aEvaluacionLegajoCab.getFec_alta_carga());
	  if (aEvaluacionLegajoCab.getUsuario_modif()!=null)
		  dsEvaluacionCab.fieldValue("oid_usu_modif", aEvaluacionLegajoCab.getUsuario_modif().getOIDInteger());
	  else
		  dsEvaluacionCab.fieldValue("oid_usu_modif", Types.INTEGER);
	  dsEvaluacionCab.fieldValue("fec_ult_modif", aEvaluacionLegajoCab.getFec_ult_modif());
	  dsEvaluacionCab.fieldValue("puntaje", aEvaluacionLegajoCab.getPuntajeEntero());
	  dsEvaluacionCab.fieldValue("firmado", aEvaluacionLegajoCab.isFirmado());
	  dsEvaluacionCab.fieldValue("fec_firmado", aEvaluacionLegajoCab.getFec_firmado());
	  dsEvaluacionCab.fieldValue("comen_del_evaluado", aEvaluacionLegajoCab.getComen_del_evaluado());
	  dsEvaluacionCab.fieldValue("activo", aEvaluacionLegajoCab.isActivo());
	  
	  
	  ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
	  ClasificadorEntidad clasifSector  = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
	  ClasificadorEntidad clasifPuesto  = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
	  ClasificadorEntidad clasifEstado  = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
	  
	  ValorClasificadorEntidad valorClasifEmpresa = null;
	  ValorClasificadorEntidad valorClasifSector = null;
	  ValorClasificadorEntidad valorClasifPuesto = null;
	  ValorClasificadorEntidad valorClasifEstado = null;
	  
	  
	  EvalValClasifLeg evalValClasifLegEmp = aEvaluacionLegajoCab.getEvalValClasifLeg(clasifEmpresa); 
	  EvalValClasifLeg evalValClasifLegSec = aEvaluacionLegajoCab.getEvalValClasifLeg(clasifSector);
	  EvalValClasifLeg evalValClasifLegPue = aEvaluacionLegajoCab.getEvalValClasifLeg(clasifPuesto);
	  EvalValClasifLeg evalValClasifLegEst = aEvaluacionLegajoCab.getEvalValClasifLeg(clasifEstado);
	  
	  if (evalValClasifLegEmp!=null)
		  valorClasifEmpresa = evalValClasifLegEmp.getValor_clasificador();
	  if (evalValClasifLegSec!=null)
		  valorClasifSector = evalValClasifLegSec.getValor_clasificador();
	  if (evalValClasifLegPue!=null)
		  valorClasifPuesto = evalValClasifLegPue.getValor_clasificador();
	  if (evalValClasifLegEst!=null)
		  valorClasifEstado = evalValClasifLegEst.getValor_clasificador();
	  
	  
	  if (valorClasifEmpresa!=null) {
		  dsEvaluacionCab.fieldValue("oid_empresa", valorClasifEmpresa.getOIDInteger());
		  dsEvaluacionCab.fieldValue("cod_empresa", valorClasifEmpresa.getCodigo());
		  dsEvaluacionCab.fieldValue("desc_empresa", valorClasifEmpresa.getDescripcion());
	  } else {
		  dsEvaluacionCab.fieldValue("oid_empresa", "");
		  dsEvaluacionCab.fieldValue("cod_empresa", "");
		  dsEvaluacionCab.fieldValue("desc_empresa", "");
	  }
	  if (valorClasifSector!=null) {
		  dsEvaluacionCab.fieldValue("oid_sector", valorClasifSector.getOIDInteger());
		  dsEvaluacionCab.fieldValue("cod_sector", valorClasifSector.getCodigo());
		  dsEvaluacionCab.fieldValue("desc_sector", valorClasifSector.getDescripcion());
	  } else {
		  dsEvaluacionCab.fieldValue("oid_sector", "");
		  dsEvaluacionCab.fieldValue("cod_sector", "");
		  dsEvaluacionCab.fieldValue("desc_sector", "");
	  }
	  if (valorClasifPuesto!=null) {
		  dsEvaluacionCab.fieldValue("oid_puesto", valorClasifPuesto.getOIDInteger());
		  dsEvaluacionCab.fieldValue("cod_puesto", valorClasifPuesto.getCodigo());
		  dsEvaluacionCab.fieldValue("desc_puesto", valorClasifPuesto.getDescripcion());
	  } else {
		  dsEvaluacionCab.fieldValue("oid_puesto", "");
		  dsEvaluacionCab.fieldValue("cod_puesto", "");
		  dsEvaluacionCab.fieldValue("desc_puesto", "");
	  }
	  
	  if (valorClasifEstado!=null) {
		  dsEvaluacionCab.fieldValue("oid_estado", valorClasifEstado.getOIDInteger());
		  dsEvaluacionCab.fieldValue("cod_estado", valorClasifEstado.getCodigo());
		  dsEvaluacionCab.fieldValue("desc_estado", valorClasifEstado.getDescripcion());
	  } else {
		  dsEvaluacionCab.fieldValue("oid_estado", "");
		  dsEvaluacionCab.fieldValue("cod_estado", "");
		  dsEvaluacionCab.fieldValue("desc_estado", "");
	  }
	  
	  
	  dsEvaluacionCab.fieldValue("oid_cond_mod_eval",aEvaluacionLegajoCab.getCondModEvalCab().getOIDInteger());
	  if (aEvaluacionLegajoCab.isVigente())
		  dsEvaluacionCab.fieldValue("vigente","SI");
	  else
		  dsEvaluacionCab.fieldValue("vigente","NO");
	  
	  if (aEvaluacionLegajoCab.getValClasifPuestoFuturo()!=null) {
		  dsEvaluacionCab.fieldValue("oid_val_pue_fut", aEvaluacionLegajoCab.getValClasifPuestoFuturo().getOIDInteger());
		  dsEvaluacionCab.fieldValue("cod_val_pue_fut", aEvaluacionLegajoCab.getValClasifPuestoFuturo().getCodigo());
		  dsEvaluacionCab.fieldValue("desc_val_pue_fut", aEvaluacionLegajoCab.getValClasifPuestoFuturo().getDescripcion());
	  } else {
		  dsEvaluacionCab.fieldValue("oid_val_pue_fut", "");
		  dsEvaluacionCab.fieldValue("cod_val_pue_fut", "");
		  dsEvaluacionCab.fieldValue("desc_val_pue_fut", "");		  
	  }
	  
  }
  
  private IDataSet getDataSetModelosVig() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TModelosVigentes");
	    dataset.fieldDef(new Field("oid_mod_eval_cab" , Field.INTEGER, 0));
	    dataset.fieldDef(new Field("titulo", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_abraviada", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
	    dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
	    return dataset;
  }


  private IDataSet getDataSetCompetencias() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCompetenciasEval");
	    dataset.fieldDef(new Field("oid_compe_eval" , Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("orden" , Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_eval_cab" , Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_competencia" , Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_competencia" , Field.STRING, 255));
	    dataset.fieldDef(new Field("nro_grado" , Field.INTEGER, 0));
	    dataset.fieldDef(new Field("porc_cump" , Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("descripcion" , Field.MEMO, 0));
	    return dataset;
  }
  
  private void cargarRegistroCompetencia(IDataSet ds,EvaluacionLegajoCab evaluacion) throws BaseException {
	  
	  int secu = 1;
	  Iterator iterCondCompetencias = evaluacion.getCondModEvalCab().getCompetenciasCondicion().iterator();
	  while (iterCondCompetencias.hasNext()) {
		  ModeloEvalCompe modeloEvalCompe = (ModeloEvalCompe) iterCondCompetencias.next();
		  EvalCargaResul evalCargaResul = evaluacion.getEvalCargaResul(modeloEvalCompe.getCompetencia());
		  
		  ds.append();
		  ds.fieldValue("oid_compe_eval" , modeloEvalCompe.getOIDInteger());
		  ds.fieldValue("orden" , secu);
		  ds.fieldValue("oid_eval_cab" , evaluacion.getOIDInteger());
		  ds.fieldValue("oid_competencia" , modeloEvalCompe.getCompetencia().getOIDInteger());
		  ds.fieldValue("desc_competencia" , modeloEvalCompe.getTitulo_compe());
		  if (evalCargaResul!=null)
			  ds.fieldValue("nro_grado" , evalCargaResul.getNro_grado());
		  else
			  ds.fieldValue("nro_grado" , "");
		  
		  String descripcion = "";
		  ModeloEvalGrados modeloEvalGrados = null; 
		  if (evalCargaResul!=null) {
			  modeloEvalGrados = evaluacion.getCondModEvalCab().getModeloEvalGrados(modeloEvalCompe.getCompetencia(), evalCargaResul.getNro_grado());
			  descripcion = modeloEvalGrados.getDesc_grados(); 
		  }
		  
		  if (modeloEvalGrados!=null)
			  ds.fieldValue("porc_cump", modeloEvalGrados.getPeso());
		  else
			  ds.fieldValue("porc_cump", "");
		  ++secu;
		  
		  
		  
		  ds.fieldValue("descripcion",descripcion );
	  }
	  
	  
  }
  
  
  
  
  
}
