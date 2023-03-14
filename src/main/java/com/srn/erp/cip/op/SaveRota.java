package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.EquivalenciaRotasCIP;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.Rota;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRota extends Operation { 

  public SaveRota() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRotas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Rota rotas = Rota.findByOid(dataset.getInteger("oid_rota"),getSesion());
        rotas.setCodigo(dataset.getString("codigo"));
        rotas.setDescripcion(dataset.getString("descripcion"));
        rotas.setHorario_desde(dataset.getString("horario_desde"));
        rotas.setHorario_hasta(dataset.getString("horario_hasta"));
        rotas.setMin_ent_antes(dataset.getInteger("min_ent_antes"));
        rotas.setActivo(dataset.getBoolean("activo"));
        rotas.setMin_ent_desp(dataset.getInteger("min_ent_desp"));
        rotas.setMin_sal_antes(dataset.getInteger("min_sal_antes"));
        rotas.setTipo_acceso(dataset.getString("tipo_acceso"));
        rotas.setTipo_egreso(dataset.getString("tipo_egreso"));
        rotas.setMin_sal_despues(dataset.getInteger("min_sal_despues"));
        rotas.setLeyendaNoIngresa(dataset.getString("ley_no_ingresa"));
        rotas.setLeyendaNoEgresa(dataset.getString("ley_no_egresa"));
        
        IDataSet dsEquiv = dataset.getDataSet("TEquivalenciaRotasCIP");
        dsEquiv.first();
        while (!dsEquiv.EOF()) {
        	EquivalenciaRotasCIP equiv = 
        		EquivalenciaRotasCIP.findByOid(dsEquiv.getInteger("oid_rota_equiv"), this.getSesion());
        	equiv.setRota(rotas);
        	equiv.setCodigo_externo(dsEquiv.getString("codigo_externo"));
        	equiv.setActivo(dsEquiv.getBoolean("activo"));
        	if (!equiv.isActivo())
        		equiv.delete();
        	
        	rotas.addEquivalenciaRota(equiv);
        	dsEquiv.next();
        }
        
        IDataSet dsMotEntInter = dataset.getDataSet("TMotivoEntradasInterRota");
        dsMotEntInter.first();
        while (!dsMotEntInter.EOF()) {
        	MotivoEntradasInterRota motivoEntradasInterRota =
        		MotivoEntradasInterRota.findByOid(dsMotEntInter.getInteger("oid_mot_rota"), this.getSesion());
        	motivoEntradasInterRota.setRota(rotas);
        	motivoEntradasInterRota.setMotivo(MotivoEntIntermedias.findByOidProxy(dsMotEntInter.getInteger("oid_motivo"), this.getSesion()));
        	motivoEntradasInterRota.setHorario_desde(dsMotEntInter.getString("horario_desde"));
        	motivoEntradasInterRota.setHorario_hasta(dsMotEntInter.getString("horario_hasta"));
        	motivoEntradasInterRota.setActivo(dsMotEntInter.getBoolean("activo"));
        	motivoEntradasInterRota.setAsignacion(dsMotEntInter.getString("asignacion"));
        	if (!motivoEntradasInterRota.isActivo())
        		motivoEntradasInterRota.delete();
        	rotas.addMotivoEntradaIntermedia(motivoEntradasInterRota);
        	dsMotEntInter.next();
        }
        
        
        
        addTransaccion(rotas);
        dataset.next();
    }
  }
  
}
