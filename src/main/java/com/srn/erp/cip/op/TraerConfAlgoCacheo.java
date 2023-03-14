package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AlgoCacheoClasif;
import com.srn.erp.cip.bm.AlgoCacheoEstado;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.FechaExclusionCacheo;
import com.srn.erp.cip.bm.ProbabilidadCacheo;
import com.srn.erp.cip.bm.Rota;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfAlgoCacheo extends Operation {

	private int i = -1;
	private HashTableDatos rotas = new HashTableDatos();
	private boolean firstTimeRotas = true;
	
	public TraerConfAlgoCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		AlgoritmoCacheo algoritmo = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			algoritmo = AlgoritmoCacheo.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			algoritmo = AlgoritmoCacheo.findByCodigo(codigo, getSesion());
		}

		IDataSet dsAlgoritmoCacheo = this.getDataSetAlgoritmoCacheo();
		IDataSet dsAlgoCacheoClasifInc = this.getDataSetAlgoCacheoClasifInc();
		IDataSet dsAlgoCacheoClasifExc = this.getDataSetAlgoCacheoClasifExc();
		IDataSet dsAlgoProbCacheo = this.getDataSetProbCacheoRota();
		IDataSet dsAlgoEstado = this.getDataSetEstadoCacheo();
		IDataSet dsFechaExclusion = this.getDataSetExclusionFecha();

		if (algoritmo != null) {
			cargarRegistro(dsAlgoritmoCacheo, algoritmo);
			cargarRegistroClasifInc(algoritmo,dsAlgoCacheoClasifInc);
			cargarRegistroClasifExc(algoritmo,dsAlgoCacheoClasifExc);
			cargarRegistroProbCacheo(algoritmo,dsAlgoProbCacheo);
			cargarRegistroAlgoEstadoCacheo(algoritmo,dsAlgoEstado);
			cargarRegistroFechaExclusion(algoritmo,dsFechaExclusion);
			
		}

		writeCliente(dsAlgoritmoCacheo);
		writeCliente(dsAlgoCacheoClasifInc);
		writeCliente(dsAlgoCacheoClasifExc);
		writeCliente(dsAlgoProbCacheo);
		writeCliente(dsAlgoEstado);
		writeCliente(dsFechaExclusion);

	}
	
	private void cargarRegistroClasifInc(AlgoritmoCacheo algoritmo,IDataSet dsAlgoCacheoClasifInc) throws BaseException {
		Iterator iterClasifCacheos = 
			algoritmo.getClasifCacheos().iterator();
		while (iterClasifCacheos.hasNext()) {
			AlgoCacheoClasif algoCacheoClasif = (AlgoCacheoClasif) iterClasifCacheos.next();
			if (!algoCacheoClasif.getInc_exc().equals("I")) continue;
			cargarRegistrosCacheoClasifInc(algoCacheoClasif, dsAlgoCacheoClasifInc);
		}
	}

	private void cargarRegistroProbCacheo(AlgoritmoCacheo algoritmo,
			                              IDataSet dsAlgoProbCacheo) throws BaseException {
		
		if (firstTimeRotas) {
			firstTimeRotas = false;
			Iterator iterRotas = 
				Rota.getAllRotas(this.getSesion()).iterator();
			while (iterRotas.hasNext()) {
				Rota rota = (Rota) iterRotas.next();
				if (rota.isActivo())
					rotas.put(rota.getOIDInteger(), rota);
			}
		}
		
		Iterator iterProbCacheos = 
			algoritmo.getProbabilidadesCacheos().iterator();
		while (iterProbCacheos.hasNext()) {
			ProbabilidadCacheo probabilidadCacheo = (ProbabilidadCacheo) iterProbCacheos.next();
			rotas.remove(probabilidadCacheo.getRota().getOIDInteger());
			cargarRegistrosProbCacheo(probabilidadCacheo, dsAlgoProbCacheo);
		}
		
		// Agregar las otras Rotas
		Iterator iterRotas = 
			rotas.values().iterator();
		while (iterRotas.hasNext()) {
			Rota rota = (Rota) iterRotas.next();
			
			dsAlgoProbCacheo.append();
			dsAlgoProbCacheo.fieldValue("oid_prob_cacheo", --i);
			dsAlgoProbCacheo.fieldValue("oid_algo_cacheo", algoritmo.getOIDInteger());
			dsAlgoProbCacheo.fieldValue("oid_rota", rota.getOIDInteger());
			dsAlgoProbCacheo.fieldValue("rota", rota.getDescripcion());
			dsAlgoProbCacheo.fieldValue("porc_ent", "");
			dsAlgoProbCacheo.fieldValue("prob_cach_ent",  "");
			dsAlgoProbCacheo.fieldValue("porc_sal",  "");
			dsAlgoProbCacheo.fieldValue("prob_cach_sal",  "");
			dsAlgoProbCacheo.fieldValue("activo", true);
			
		}
	}
	
	private void cargarRegistroFechaExclusion(AlgoritmoCacheo algoritmo,
            IDataSet dsFechaExclusion) throws BaseException {
		Iterator iterFechaExclusion = 
			algoritmo.getFechasExclusiones().iterator();
		while (iterFechaExclusion.hasNext()) {
			FechaExclusionCacheo fechaExclusionCacheo = (FechaExclusionCacheo) iterFechaExclusion.next();
			cargarRegistrosFechaExclusion(fechaExclusionCacheo, dsFechaExclusion);
		}
	}
	
	private void cargarRegistroAlgoEstadoCacheo(AlgoritmoCacheo algoritmo,
            IDataSet dsAlgoEstadoCacheo) throws BaseException {
		Iterator iterAlgoEstado = 
			algoritmo.getEstadosCacheos().iterator();
		while (iterAlgoEstado.hasNext()) {
			AlgoCacheoEstado algoCacheoEstado = (AlgoCacheoEstado) iterAlgoEstado.next();
			cargarRegistrosAlgoEstado(algoCacheoEstado, dsAlgoEstadoCacheo);
		}
	}
	
	
	private void cargarRegistroClasifExc(AlgoritmoCacheo algoritmo,IDataSet dsAlgoCacheoClasifExc) throws BaseException {
		Iterator iterClasifCacheos = 
			algoritmo.getClasifCacheos().iterator();
		while (iterClasifCacheos.hasNext()) {
			AlgoCacheoClasif algoCacheoClasif = (AlgoCacheoClasif) iterClasifCacheos.next();
			if (!algoCacheoClasif.getInc_exc().equals("E")) continue;
			cargarRegistrosCacheoClasifExc(algoCacheoClasif, dsAlgoCacheoClasifExc);
		}
	}
	

	private IDataSet getDataSetAlgoritmoCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlgoritmoCacheo");
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("filtro_legajo", Field.STRING, 10));
		dataset.fieldDef(new Field("tipo_planif", Field.STRING, 10));
		dataset.fieldDef(new Field("porc_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prob_cach_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_sal", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("prob_cach_sal", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("filtro_estados", Field.STRING, 10));
		dataset.fieldDef(new Field("lunes", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("martes", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("miercoles", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("jueves", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("viernes", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("sabado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("domingo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetProbCacheoRota() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProbCacheoRota");
		dataset.fieldDef(new Field("oid_prob_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("rota", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("prob_cach_ent", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_sal", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("prob_cach_sal", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAlgoCacheoClasifInc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlgoCacheoClasifInc");
		dataset.fieldDef(new Field("oid_cache_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("inc_exc", Field.STRING, 1));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAlgoCacheoClasifExc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlgoCacheoClasifExc");
		dataset.fieldDef(new Field("oid_cache_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_val_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_val_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("inc_exc", Field.STRING, 1));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}	
	
	private IDataSet getDataSetEstadoCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAlgoCacheoEstado");
		dataset.fieldDef(new Field("oid_algo_est", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_estado_cip", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetExclusionFecha() {
		IDataSet dataset = new TDataSet();
		dataset.create("TExclusionFecha");
		dataset.fieldDef(new Field("oid_exc_fec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_algo_cacheo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	private void cargarRegistrosAlgoEstado(AlgoCacheoEstado algoCacheoEstado,IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_algo_est", algoCacheoEstado.getOIDInteger());
		dataset.fieldValue("oid_algo_cacheo", algoCacheoEstado.getAlgoritmo_cacheo().getOIDInteger());
		dataset.fieldValue("oid_estado_cip",  algoCacheoEstado.getEstado().getOIDInteger());
		dataset.fieldValue("activo",  algoCacheoEstado.isActivo());
		dataset.fieldValue("orden",  --i);
	}

	private void cargarRegistrosFechaExclusion(FechaExclusionCacheo fechaExclusionCacheo,IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_exc_fec", fechaExclusionCacheo.getOIDInteger());
		dataset.fieldValue("oid_algo_cacheo", fechaExclusionCacheo.getAlgoritmo().getOIDInteger());
		dataset.fieldValue("fecha",  fechaExclusionCacheo.getFecha());
		dataset.fieldValue("activo",  fechaExclusionCacheo.isActivo());
	}
	
	private void cargarRegistrosProbCacheo(ProbabilidadCacheo probCacheo,IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_prob_cacheo", probCacheo.getOIDInteger());
		dataset.fieldValue("oid_algo_cacheo", probCacheo.getAlgoritmo_cacheo().getOIDInteger());
		dataset.fieldValue("oid_rota", probCacheo.getRota().getOIDInteger());
		dataset.fieldValue("rota", probCacheo.getRota().getDescripcion());
		dataset.fieldValue("porc_ent", probCacheo.getPorc_ent());
		dataset.fieldValue("prob_cach_ent",  probCacheo.getProb_cacheo_ent());
		dataset.fieldValue("porc_sal",  probCacheo.getPorc_sal());
		dataset.fieldValue("prob_cach_sal",  probCacheo.getProb_cacheo_sal());
		dataset.fieldValue("activo", probCacheo.isActivo());
	}
	
	private void cargarRegistrosCacheoClasifInc(AlgoCacheoClasif algoCacheoClasif,IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cache_clasif", algoCacheoClasif.getOIDInteger());
		dataset.fieldValue("oid_algo_cacheo", algoCacheoClasif.getAlgoritmo_cacheo().getOIDInteger());
		dataset.fieldValue("oid_clasificador", algoCacheoClasif.getClasificador().getOIDInteger());
		dataset.fieldValue("oid_val_clasif", algoCacheoClasif.getValor_clasif().getOIDInteger());
		dataset.fieldValue("cod_val_clasif", algoCacheoClasif.getValor_clasif().getCodigo());
		dataset.fieldValue("desc_val_clasif", algoCacheoClasif.getValor_clasif().getDescripcion());
		dataset.fieldValue("inc_exc", algoCacheoClasif.getInc_exc());
		dataset.fieldValue("activo", algoCacheoClasif.isActivo());
		dataset.fieldValue("nro_clasificador", algoCacheoClasif.getClasificador().getNroClasif());
		dataset.fieldValue("orden", --i);
	}
	
	private void cargarRegistrosCacheoClasifExc(AlgoCacheoClasif algoCacheoClasif,IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cache_clasif", algoCacheoClasif.getOIDInteger());
		dataset.fieldValue("oid_algo_cacheo", algoCacheoClasif.getAlgoritmo_cacheo().getOIDInteger());
		dataset.fieldValue("oid_clasificador", algoCacheoClasif.getClasificador().getOIDInteger());
		dataset.fieldValue("oid_val_clasif", algoCacheoClasif.getValor_clasif().getOIDInteger());
		dataset.fieldValue("cod_val_clasif", algoCacheoClasif.getValor_clasif().getCodigo());
		dataset.fieldValue("desc_val_clasif", algoCacheoClasif.getValor_clasif().getDescripcion());
		dataset.fieldValue("inc_exc", algoCacheoClasif.getInc_exc());
		dataset.fieldValue("activo", algoCacheoClasif.isActivo());
		dataset.fieldValue("nro_clasificador", algoCacheoClasif.getClasificador().getNroClasif());
		dataset.fieldValue("orden", --i);
	}	

	private void cargarRegistro(IDataSet dataset, AlgoritmoCacheo algoritmo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_algo_cacheo", algoritmo.getOIDInteger());
		dataset.fieldValue("codigo", algoritmo.getCodigo());
		dataset.fieldValue("descripcion", algoritmo.getDescripcion());
		dataset.fieldValue("filtro_legajo", algoritmo.getFiltro_legajo());
		dataset.fieldValue("tipo_planif", algoritmo.getTipo_planif());
		dataset.fieldValue("porc_ent", algoritmo.getPorc_ent());
		dataset.fieldValue("activo", algoritmo.isActivo());
		dataset.fieldValue("prob_cach_ent", algoritmo.getProb_cach_ent());
		dataset.fieldValue("porc_sal", algoritmo.getPorc_sal());
		dataset.fieldValue("prob_cach_sal", algoritmo.getProb_cach_sal());
		dataset.fieldValue("filtro_estados", algoritmo.getFiltro_estados());
		dataset.fieldValue("lunes", algoritmo.isLunes());
		dataset.fieldValue("martes", algoritmo.isMartes());
		dataset.fieldValue("miercoles", algoritmo.isMiercoles());
		dataset.fieldValue("jueves", algoritmo.isJueves());
		dataset.fieldValue("viernes", algoritmo.isViernes());
		dataset.fieldValue("sabado", algoritmo.isSabado());
		dataset.fieldValue("domingo", algoritmo.isDomingo());
	}

}
