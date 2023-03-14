package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AlgoCacheoClasif;
import com.srn.erp.cip.bm.AlgoCacheoEstado;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.FechaExclusionCacheo;
import com.srn.erp.cip.bm.ProbabilidadCacheo;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfAlgoCacheo extends Operation { 

  public SaveConfAlgoCacheo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAlgoritmoCacheo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AlgoritmoCacheo algoritmo = AlgoritmoCacheo.findByOid(dataset.getInteger("oid_algo_cacheo"),getSesion());
        algoritmo.setCodigo(dataset.getString("codigo"));
        algoritmo.setDescripcion(dataset.getString("descripcion"));
        algoritmo.setFiltro_legajo(dataset.getString("filtro_legajo"));
        algoritmo.setTipo_planif(dataset.getString("tipo_planif"));
        algoritmo.setPorc_ent(dataset.getDouble("porc_ent"));
        algoritmo.setProb_cach_ent(dataset.getDouble("prob_cach_ent"));
        algoritmo.setPorc_sal(dataset.getDouble("porc_sal"));
        algoritmo.setProb_cach_sal(dataset.getDouble("prob_cach_sal"));
        algoritmo.setFiltro_estados(dataset.getString("filtro_estados"));
        algoritmo.setActivo(dataset.getBoolean("activo"));
        algoritmo.setLunes(dataset.getBoolean("lunes"));
        algoritmo.setMartes(dataset.getBoolean("martes"));
        algoritmo.setMiercoles(dataset.getBoolean("miercoles"));
        algoritmo.setJueves(dataset.getBoolean("jueves"));
        algoritmo.setViernes(dataset.getBoolean("viernes"));
        algoritmo.setSabado(dataset.getBoolean("sabado"));
        algoritmo.setDomingo(dataset.getBoolean("domingo"));
        if (!algoritmo.isActivo())
        	algoritmo.delete();
        
        IDataSet dsAlgoCacheoClasifInc = dataset.getDataSet("TAlgoCacheoClasifInc");
        dsAlgoCacheoClasifInc.first();
        while (!dsAlgoCacheoClasifInc.EOF()) {
        	AlgoCacheoClasif algoCacheoClasif =
        		AlgoCacheoClasif.findByOid(dsAlgoCacheoClasifInc.getInteger("oid_cache_clasif"), this.getSesion());
        	algoCacheoClasif.setAlgoritmo_cacheo(algoritmo);
        	algoCacheoClasif.setClasificador(ClasificadorEntidad.findByOidProxy(dsAlgoCacheoClasifInc.getInteger("oid_clasificador"), this.getSesion()));
        	algoCacheoClasif.setValor_clasif(ValorClasificadorEntidad.findByOidProxy(dsAlgoCacheoClasifInc.getInteger("oid_val_clasif"), this.getSesion()));
        	algoCacheoClasif.setInc_exc("I");
        	algoCacheoClasif.setActivo(dsAlgoCacheoClasifInc.getBoolean("activo"));
        	algoritmo.addClasifCacheo(algoCacheoClasif);
        	
        	dsAlgoCacheoClasifInc.next();
        }
        
        IDataSet dsAlgoCacheoClasifExc = dataset.getDataSet("TAlgoCacheoClasifExc");
        dsAlgoCacheoClasifExc.first();
        while (!dsAlgoCacheoClasifExc.EOF()) {
        	AlgoCacheoClasif algoCacheoClasif =
        		AlgoCacheoClasif.findByOid(dsAlgoCacheoClasifExc.getInteger("oid_cache_clasif"), this.getSesion());
        	algoCacheoClasif.setAlgoritmo_cacheo(algoritmo);
        	algoCacheoClasif.setClasificador(ClasificadorEntidad.findByOidProxy(dsAlgoCacheoClasifExc.getInteger("oid_clasificador"), this.getSesion()));
        	algoCacheoClasif.setValor_clasif(ValorClasificadorEntidad.findByOidProxy(dsAlgoCacheoClasifExc.getInteger("oid_val_clasif"), this.getSesion()));
        	algoCacheoClasif.setInc_exc("E");
        	algoCacheoClasif.setActivo(dsAlgoCacheoClasifExc.getBoolean("activo"));
        	if (!algoCacheoClasif.isActivo())
        		algoCacheoClasif.delete();
        	algoritmo.addClasifCacheo(algoCacheoClasif);
        	
        	dsAlgoCacheoClasifExc.next();
        }
        
        IDataSet dsProbCacheoRota = dataset.getDataSet("TProbCacheoRota");
        dsProbCacheoRota.first();
        while (!dsProbCacheoRota.EOF()) {
        	ProbabilidadCacheo probCacheo =
        		ProbabilidadCacheo.findByOid(dsProbCacheoRota.getInteger("oid_prob_cacheo"), this.getSesion());
        	probCacheo.setAlgoritmo_cacheo(algoritmo);
        	probCacheo.setRota(Rota.findByOidProxy(dsProbCacheoRota.getInteger("oid_rota"), this.getSesion()));
        	probCacheo.setPorc_ent(dsProbCacheoRota.getDouble("porc_ent"));
        	probCacheo.setProb_cacheo_ent(dsProbCacheoRota.getDouble("prob_cach_ent"));
        	probCacheo.setPorc_sal(dsProbCacheoRota.getDouble("porc_sal"));
        	probCacheo.setProb_cacheo_sal(dsProbCacheoRota.getDouble("prob_cach_sal"));
        	probCacheo.setActivo(dsProbCacheoRota.getBoolean("activo"));
        	if (!probCacheo.isActivo())
        		probCacheo.delete();
        	
        	algoritmo.addProbabilidadCacheo(probCacheo);
        	
        	dsProbCacheoRota.next();
        }
        
        IDataSet dsAlgoCacheoEstado = dataset.getDataSet("TAlgoCacheoEstado");
        dsAlgoCacheoEstado.first();
        while (!dsAlgoCacheoEstado.EOF()) {
        	AlgoCacheoEstado algoCacheoEstado =
        		AlgoCacheoEstado.findByOid(dsAlgoCacheoEstado.getInteger("oid_algo_est"), this.getSesion());
        	algoCacheoEstado.setAlgoritmo_cacheo(algoritmo);
        	algoCacheoEstado.setEstado(EstadoCIP.findByOidProxy(dsAlgoCacheoEstado.getInteger("oid_estado_cip"), this.getSesion()));
        	algoCacheoEstado.setActivo(dsAlgoCacheoEstado.getBoolean("activo"));
        	if (!algoCacheoEstado.isActivo())
        		algoCacheoEstado.delete();
        	algoritmo.addEstadoCacheo(algoCacheoEstado);
        	dsAlgoCacheoEstado.next();
        }
        
        
        IDataSet dsExclusionFecha = dataset.getDataSet("TExclusionFecha");
        dsExclusionFecha.first();
        while (!dsExclusionFecha.EOF()) {
        	
        	FechaExclusionCacheo fecExclusionCacheo =
        		FechaExclusionCacheo.findByOid(dsExclusionFecha.getInteger("oid_exc_fec"), this.getSesion());
        	fecExclusionCacheo.setAlgoritmo(algoritmo);
        	fecExclusionCacheo.setFecha(dsExclusionFecha.getDate("fecha"));
        	fecExclusionCacheo.setActivo(dsExclusionFecha.getBoolean("activo"));
        	if (!fecExclusionCacheo.isActivo()) fecExclusionCacheo.delete();
        	algoritmo.addFechaExclusion(fecExclusionCacheo);
        	dsExclusionFecha.next();
        }        
        
        addTransaccion(algoritmo);
        dataset.next();
    }
  }
  
}
