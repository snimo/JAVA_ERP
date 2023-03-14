package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstAlgunaVez;
import com.srn.erp.excluidos.bm.SeguExcEstadoActual;
import com.srn.erp.excluidos.bm.SeguExcPeligrosidad;
import com.srn.erp.excluidos.bm.SeguExcPredio;
import com.srn.erp.excluidos.bm.SeguExcTipoIndi;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSeguPerfilExcluido extends Operation { 

  public TraerSeguPerfilExcluido() { 
  }
  
  private int i = 0;

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SeguPerfilExcluido seguperfilexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       seguperfilexcluido = SeguPerfilExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       seguperfilexcluido = SeguPerfilExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSeguPerfilExcluido = getDataSetSeguPerfilExcluido();
    IDataSet datasetTipoIndividuos = getDataSetTiposIndividuos();
    IDataSet datasetEstadosActuales = getDataSetEstadosActuales();
    IDataSet datasetPeligrosidad = getDataSetPeligrosidad();
    IDataSet datasetPredio = getDataSetPredio();
    IDataSet datasetEstEcluyente = getDataSetEstadosExcluyentes();
    
    if (seguperfilexcluido != null) { 
    	
        cargarRegistroSeguPerfilExcluido(datasetSeguPerfilExcluido, 
                         seguperfilexcluido.getOIDInteger(),
                         seguperfilexcluido.getCodigo(),
                         seguperfilexcluido.getDescripcion(),
                         seguperfilexcluido.isActivo());
        
        cargarTiposIndividuos(datasetTipoIndividuos,seguperfilexcluido,IndividuoExcluido.TI_EMPLEADO);        
        cargarTiposIndividuos(datasetTipoIndividuos,seguperfilexcluido,IndividuoExcluido.TI_EXTERNO);
        
        Iterator iterEstadosActuales = 
        		EstadoExcluido.getAllActivos(this.getSesion()).iterator();
        while (iterEstadosActuales.hasNext()) {
        	EstadoExcluido estado = (EstadoExcluido) iterEstadosActuales.next();
        	cargarEstadoActual(datasetEstadosActuales,seguperfilexcluido,estado);
        }
        
        Iterator iterPeligrosidades = 
        		PeligrosidadExcluido.getAllActivos(this.getSesion()).iterator();
        while (iterPeligrosidades.hasNext()) {
        	PeligrosidadExcluido peligrosidad = (PeligrosidadExcluido) iterPeligrosidades.next();
        	cargarPeligrosidad(datasetPeligrosidad,seguperfilexcluido,peligrosidad);
        }        
        
        Iterator iterPredios = 
        		PredioExcluido.getAllActivos(this.getSesion()).iterator();
        while (iterPredios.hasNext()) {
        	PredioExcluido predioExcluido = (PredioExcluido) iterPredios.next();
        	cargarPredio(datasetPredio,seguperfilexcluido,predioExcluido);
        } 
        
        Iterator iterEstadosExcluyentes = 
        		EstadoExcluido.getAllActivos(this.getSesion()).iterator();
        while (iterEstadosExcluyentes.hasNext()) {
        	EstadoExcluido estado = (EstadoExcluido) iterEstadosExcluyentes.next();
        	cargarEstadoExcluyentes(datasetEstEcluyente,seguperfilexcluido,estado);
        }        
        
        
        
        
    }
    
    writeCliente(datasetSeguPerfilExcluido);
    writeCliente(datasetTipoIndividuos);
    writeCliente(datasetEstadosActuales);
    writeCliente(datasetPeligrosidad);
    writeCliente(datasetPredio);
    writeCliente(datasetEstEcluyente);
    
  }
  
  private void cargarPeligrosidad(IDataSet dsPeligrosidad,SeguPerfilExcluido seguPerfilExcluido, PeligrosidadExcluido peligrosidad) throws BaseException {
	  
	  SeguExcPeligrosidad seguExcPeligrosidad = 
			  SeguExcPeligrosidad.getSeguExcPeligrosidad(seguPerfilExcluido, peligrosidad, this.getSesion());
	  
	  dsPeligrosidad.append();
	  dsPeligrosidad.fieldValue("oid_segu_peligro", ++i);
	  dsPeligrosidad.fieldValue("oid_segu_perfil", seguPerfilExcluido.getOIDInteger());
	  dsPeligrosidad.fieldValue("oid_peligrosidad", peligrosidad.getOIDInteger());
	  dsPeligrosidad.fieldValue("desc_peligrosidad", peligrosidad.getDescripcion());
	  if (seguExcPeligrosidad!=null) {
		  dsPeligrosidad.fieldValue("visualiza", seguExcPeligrosidad.isVisualiza());
		  dsPeligrosidad.fieldValue("alta", seguExcPeligrosidad.isAlta());
		  dsPeligrosidad.fieldValue("baja", seguExcPeligrosidad.isBaja());
		  dsPeligrosidad.fieldValue("modifica", seguExcPeligrosidad.isModifica());
	  } else {
		  dsPeligrosidad.fieldValue("visualiza", false);
		  dsPeligrosidad.fieldValue("alta", false);
		  dsPeligrosidad.fieldValue("baja", false);
		  dsPeligrosidad.fieldValue("modifica", false);		  
	  }
	  dsPeligrosidad.fieldValue("activo", true);	  
  }  
  
  
  private void cargarPredio(IDataSet dsPredio,SeguPerfilExcluido seguPerfilExcluido, PredioExcluido predio) throws BaseException {
	  
	  SeguExcPredio seguExcPredio = 
			  SeguExcPredio.getSeguExcPredio(seguPerfilExcluido, predio , this.getSesion());
	  
	  dsPredio.append();
	  dsPredio.fieldValue("oid_segu_predio", ++i);
	  dsPredio.fieldValue("oid_segu_perfil", seguPerfilExcluido.getOIDInteger());
	  dsPredio.fieldValue("oid_predio", predio.getOIDInteger());
	  dsPredio.fieldValue("desc_predio", predio.getDescripcion());
	  if (seguExcPredio!=null) {
		  dsPredio.fieldValue("visualiza", seguExcPredio.isVisualiza());
		  dsPredio.fieldValue("alta", seguExcPredio.isAlta());
		  dsPredio.fieldValue("baja", seguExcPredio.isBaja());
		  dsPredio.fieldValue("modifica", seguExcPredio.isModifica());
	  } else {
		  dsPredio.fieldValue("visualiza", false);
		  dsPredio.fieldValue("alta", false);
		  dsPredio.fieldValue("baja", false);
		  dsPredio.fieldValue("modifica", false);		  
	  }
	  dsPredio.fieldValue("activo", true);	  
  }  
  
  private void cargarEstadoExcluyentes(IDataSet dsEstado,SeguPerfilExcluido seguPerfilExcluido, EstadoExcluido estado) throws BaseException {
	  
	  SeguExcEstAlgunaVez seguExcEstAlgunaVez = 
			  SeguExcEstAlgunaVez.getExcEstAlgunaVez(seguPerfilExcluido, estado, this.getSesion());
	  
	  dsEstado.append();
	  dsEstado.fieldValue("oid_segu_excluir", ++i);
	  dsEstado.fieldValue("oid_segu_perfil", seguPerfilExcluido.getOIDInteger());
	  dsEstado.fieldValue("oid_estado", estado.getOIDInteger());
	  dsEstado.fieldValue("desc_estado", estado.getDescripcion());
	  if (seguExcEstAlgunaVez!=null) {
		  dsEstado.fieldValue("visualiza", seguExcEstAlgunaVez.isVisualiza());
		  dsEstado.fieldValue("alta", seguExcEstAlgunaVez.isAlta());
		  dsEstado.fieldValue("baja", seguExcEstAlgunaVez.isBaja());
		  dsEstado.fieldValue("modifica", seguExcEstAlgunaVez.isModifica());
	  } else {
		  dsEstado.fieldValue("visualiza", false);
		  dsEstado.fieldValue("alta", false);
		  dsEstado.fieldValue("baja", false);
		  dsEstado.fieldValue("modifica", false);		  
	  }
	  dsEstado.fieldValue("activo", true);	  
  }  
  	  
  private void cargarEstadoActual(IDataSet dsEstado,SeguPerfilExcluido seguPerfilExcluido, EstadoExcluido estado) throws BaseException {
	  
	  SeguExcEstadoActual seguExcEstadoActual = 
			  SeguExcEstadoActual.getSeguExcEstadoActual(seguPerfilExcluido, estado, this.getSesion());
	  
	  dsEstado.append();
	  dsEstado.fieldValue("oid_segu_est_act", ++i);
	  dsEstado.fieldValue("oid_segu_perfil", seguPerfilExcluido.getOIDInteger());
	  dsEstado.fieldValue("oid_estado", estado.getOIDInteger());
	  dsEstado.fieldValue("desc_estado", estado.getDescripcion());
	  if (seguExcEstadoActual!=null) {
		  dsEstado.fieldValue("visualiza", seguExcEstadoActual.isVisualiza());
		  dsEstado.fieldValue("alta", seguExcEstadoActual.isAlta());
		  dsEstado.fieldValue("baja", seguExcEstadoActual.isBaja());
		  dsEstado.fieldValue("modifica", seguExcEstadoActual.isModifica());
	  } else {
		  dsEstado.fieldValue("visualiza", false);
		  dsEstado.fieldValue("alta", false);
		  dsEstado.fieldValue("baja", false);
		  dsEstado.fieldValue("modifica", false);		  
	  }
	  dsEstado.fieldValue("activo", true);	  
  }

  private IDataSet getDataSetSeguPerfilExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSeguPerfilExcluido");
    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarTiposIndividuos(IDataSet dsTipo,SeguPerfilExcluido seguperfilexcluido,String tipoIndividuo) throws BaseException {
	  dsTipo.append();
	  dsTipo.fieldValue("oid_segu_tipo_ind", (++i));
	  dsTipo.fieldValue("oid_segu_perfil", seguperfilexcluido.getOIDInteger());
	  dsTipo.fieldValue("tipo_individuo", tipoIndividuo);
	  
	  SeguExcTipoIndi seguExcTipoIndi = SeguExcTipoIndi.getSeguExcTipoIndi(seguperfilexcluido, tipoIndividuo, this.getSesion()); 
	  
	  if (seguExcTipoIndi!=null) {
		  dsTipo.fieldValue("visualiza", seguExcTipoIndi.isVisualiza());
		  dsTipo.fieldValue("alta", seguExcTipoIndi.isAlta());
		  dsTipo.fieldValue("baja", seguExcTipoIndi.isBaja());
		  dsTipo.fieldValue("modifica", seguExcTipoIndi.isModifica());
		  dsTipo.fieldValue("activo", true);
	  } else {
		  dsTipo.fieldValue("visualiza", false);
		  dsTipo.fieldValue("alta", false);
		  dsTipo.fieldValue("baja", false);
		  dsTipo.fieldValue("modifica", false);
		  dsTipo.fieldValue("activo", true);		  
	  }
  }
  
  
  private IDataSet getDataSetTiposIndividuos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TTiposIndividuos");
	    dataset.fieldDef(new Field("oid_segu_tipo_ind", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("tipo_individuo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("visualiza", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("baja", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("modifica", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }  
  
  
  private IDataSet getDataSetEstadosActuales() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TEstadosActuales");
	    dataset.fieldDef(new Field("oid_segu_est_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
	    dataset.fieldDef(new Field("visualiza", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("baja", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("modifica", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetEstadosExcluyentes() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TEstadosExcluyentes");
	    dataset.fieldDef(new Field("oid_segu_excluir", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_estado", Field.STRING, 100));
	    dataset.fieldDef(new Field("visualiza", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("baja", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("modifica", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }   
  
  private IDataSet getDataSetPeligrosidad() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPeligrosidad");
	    dataset.fieldDef(new Field("oid_segu_peligro", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_peligrosidad", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_peligrosidad", Field.STRING, 100));
	    dataset.fieldDef(new Field("visualiza", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("baja", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("modifica", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }  
  
  
  private IDataSet getDataSetPredio() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPredio");
	    dataset.fieldDef(new Field("oid_segu_predio", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_segu_perfil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_predio", Field.STRING, 100));
	    dataset.fieldDef(new Field("visualiza", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("alta", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("baja", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("modifica", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }  

  private void cargarRegistroSeguPerfilExcluido(IDataSet dataset, 
                         Integer oid_segu_perfil,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_segu_perfil", oid_segu_perfil);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
