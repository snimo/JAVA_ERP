package com.srn.erp.excluidos.op;


import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstAlgunaVez;
import com.srn.erp.excluidos.bm.SeguExcEstadoActual;
import com.srn.erp.excluidos.bm.SeguExcPeligrosidad;
import com.srn.erp.excluidos.bm.SeguExcPredio;
import com.srn.erp.excluidos.bm.SeguExcTipoIndi;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSeguPerfilExcluido extends Operation { 

  public SaveSeguPerfilExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSeguPerfilExcluido"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SeguPerfilExcluido seguperfilexcluido = SeguPerfilExcluido.findByOid(dataset.getInteger("oid_segu_perfil"),getSesion());
        seguperfilexcluido.setOID(dataset.getInteger("oid_segu_perfil"));
        seguperfilexcluido.setCodigo(dataset.getString("codigo"));
        seguperfilexcluido.setDescripcion(dataset.getString("descripcion"));
        seguperfilexcluido.setActivo(dataset.getBoolean("activo"));
        addTransaccion(seguperfilexcluido);
        
        IDataSet dsTiposInd = dataset.getDataSet("TTiposIndividuos");
        dsTiposInd.first();
        while (!dsTiposInd.EOF()) {
        	String tipo = dsTiposInd.getString("tipo_individuo");
        	SeguExcTipoIndi seguExcTipoIndi = SeguExcTipoIndi.getSeguExcTipoIndi(seguperfilexcluido, tipo, this.getSesion());
        	if (seguExcTipoIndi == null) {
        		seguExcTipoIndi = (SeguExcTipoIndi) SeguExcTipoIndi.getNew(SeguExcTipoIndi.NICKNAME, this.getSesion());
        		seguExcTipoIndi.setOid_segu_perfil(seguperfilexcluido);
        		seguExcTipoIndi.setActivo(true);
        		seguExcTipoIndi.setTipo_individuo(tipo);
        		
        	}
        	seguExcTipoIndi.setVisualiza(dsTiposInd.getBoolean("visualiza"));
        	seguExcTipoIndi.setAlta(dsTiposInd.getBoolean("alta"));
        	seguExcTipoIndi.setBaja(dsTiposInd.getBoolean("baja"));
        	seguExcTipoIndi.setModifica(dsTiposInd.getBoolean("modifica"));
        	
        	seguperfilexcluido.addTipoIndividuo(seguExcTipoIndi);
        	
        	dsTiposInd.next();
        }
        
        
        IDataSet dsEstadosActuales = dataset.getDataSet("TEstadosActuales");
        dsEstadosActuales.first();
        while (!dsEstadosActuales.EOF()) {
        	EstadoExcluido estadoExcluido = EstadoExcluido.findByOidProxy(dsEstadosActuales.getInteger("oid_estado"), this.getSesion());
        	
        	SeguExcEstadoActual seguExcEstadoActual = SeguExcEstadoActual.getSeguExcEstadoActual(seguperfilexcluido, estadoExcluido, this.getSesion());
        	if (seguExcEstadoActual == null) {
        		seguExcEstadoActual = (SeguExcEstadoActual) SeguExcEstadoActual.getNew(SeguExcEstadoActual.NICKNAME, this.getSesion());
        		seguExcEstadoActual.setPerfil(seguperfilexcluido);
        		seguExcEstadoActual.setActivo(true);
        		seguExcEstadoActual.setEstado(estadoExcluido);
        		
        	}
        	seguExcEstadoActual.setVisualiza(dsEstadosActuales.getBoolean("visualiza"));
        	seguExcEstadoActual.setAlta(dsEstadosActuales.getBoolean("alta"));
        	seguExcEstadoActual.setBaja(dsEstadosActuales.getBoolean("baja"));
        	seguExcEstadoActual.setModifica(dsEstadosActuales.getBoolean("modifica"));
        	
        	seguperfilexcluido.addEstadoActual(seguExcEstadoActual);
        	
        	dsEstadosActuales.next();
        }        
        
        
        IDataSet dsPeligrosidades = dataset.getDataSet("TPeligrosidad");
        dsPeligrosidades.first();
        while (!dsPeligrosidades.EOF()) {
        	PeligrosidadExcluido peligrosidad = PeligrosidadExcluido.findByOidProxy(dsPeligrosidades.getInteger("oid_peligrosidad"), this.getSesion());
        	
        	SeguExcPeligrosidad seguExcPeligrosidad = SeguExcPeligrosidad.getSeguExcPeligrosidad(seguperfilexcluido, peligrosidad, this.getSesion());
        	if (seguExcPeligrosidad == null) {
        		seguExcPeligrosidad = (SeguExcPeligrosidad) SeguExcPeligrosidad.getNew(SeguExcPeligrosidad.NICKNAME, this.getSesion());
        		seguExcPeligrosidad.setPerfil(seguperfilexcluido);
        		seguExcPeligrosidad.setActivo(true);
        		seguExcPeligrosidad.setPeligrosidad(peligrosidad);
        		
        	}
        	seguExcPeligrosidad.setVisualiza(dsPeligrosidades.getBoolean("visualiza"));
        	seguExcPeligrosidad.setAlta(dsPeligrosidades.getBoolean("alta"));
        	seguExcPeligrosidad.setBaja(dsPeligrosidades.getBoolean("baja"));
        	seguExcPeligrosidad.setModifica(dsPeligrosidades.getBoolean("modifica"));
        	
        	seguperfilexcluido.addPeligrosidad(seguExcPeligrosidad);
        	
        	dsPeligrosidades.next();
        }        
        
        
        IDataSet dsPredio = dataset.getDataSet("TPredio");
        dsPredio.first();
        while (!dsPredio.EOF()) {
        	PredioExcluido predioExcluido = PredioExcluido.findByOidProxy(dsPredio.getInteger("oid_predio"), this.getSesion());
        	
        	SeguExcPredio seguExcPredio = SeguExcPredio.getSeguExcPredio(seguperfilexcluido, predioExcluido, this.getSesion());
        	if (seguExcPredio == null) {
        		seguExcPredio = (SeguExcPredio) SeguExcPredio.getNew(SeguExcPredio.NICKNAME, this.getSesion());
        		seguExcPredio.setPerfil(seguperfilexcluido);
        		seguExcPredio.setActivo(true);
        		seguExcPredio.setPredio(predioExcluido);
        		
        	}
        	seguExcPredio.setVisualiza(dsPredio.getBoolean("visualiza"));
        	seguExcPredio.setAlta(dsPredio.getBoolean("alta"));
        	seguExcPredio.setBaja(dsPredio.getBoolean("baja"));
        	seguExcPredio.setModifica(dsPredio.getBoolean("modifica"));
        	
        	seguperfilexcluido.addPredio(seguExcPredio);
        	
        	dsPredio.next();
        }        
        
        
        IDataSet dsEstadoExcAlgunaVez = dataset.getDataSet("TEstadosExcluyentes");
        dsEstadoExcAlgunaVez.first();
        while (!dsEstadoExcAlgunaVez.EOF()) {
        	EstadoExcluido estadoExcluido = EstadoExcluido.findByOidProxy(dsEstadoExcAlgunaVez.getInteger("oid_estado"), this.getSesion());
        	
        	SeguExcEstAlgunaVez seguExcEstAlgunaVez = SeguExcEstAlgunaVez.getExcEstAlgunaVez(seguperfilexcluido, estadoExcluido, this.getSesion());
        	if (seguExcEstAlgunaVez == null) {
        		seguExcEstAlgunaVez = (SeguExcEstAlgunaVez) SeguExcEstAlgunaVez.getNew(SeguExcEstAlgunaVez.NICKNAME, this.getSesion());
        		seguExcEstAlgunaVez.setPerfil(seguperfilexcluido);
        		seguExcEstAlgunaVez.setActivo(true);
        		seguExcEstAlgunaVez.setEstado(estadoExcluido);
        		
        	}
        	seguExcEstAlgunaVez.setVisualiza(dsEstadoExcAlgunaVez.getBoolean("visualiza"));
        	seguExcEstAlgunaVez.setAlta(dsEstadoExcAlgunaVez.getBoolean("alta"));
        	seguExcEstAlgunaVez.setBaja(dsEstadoExcAlgunaVez.getBoolean("baja"));
        	seguExcEstAlgunaVez.setModifica(dsEstadoExcAlgunaVez.getBoolean("modifica"));
        	
        	seguperfilexcluido.addEstadoAlgunaVez(seguExcEstAlgunaVez);
        	
        	dsEstadoExcAlgunaVez.next();
        }        
        
        
        
        dataset.next();
    }
  }
  
}
