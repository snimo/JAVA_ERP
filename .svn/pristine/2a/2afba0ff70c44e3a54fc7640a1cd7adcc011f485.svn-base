package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.ClasificacionOportunidad;
import com.srn.erp.crm.bm.EstadoOportunidad;
import com.srn.erp.crm.bm.MotivoEstadoOportunidad;
import com.srn.erp.crm.bm.Oportunidad;
import com.srn.erp.crm.bm.SensacionCierreOportunidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOportunidad extends Operation { 

  public TraerOportunidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Oportunidad oportunidad = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       oportunidad = Oportunidad.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       oportunidad = Oportunidad.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetOportunidad = getDataSetOportunidad();
    if (oportunidad != null) { 
        cargarRegistroOportunidad(datasetOportunidad, 
                         oportunidad.getOIDInteger(),
                         oportunidad.getCodigo(),
                         oportunidad.getTema(),
                         oportunidad.getSujeto_potencial(),
                         oportunidad.getListaprecios(),
                         oportunidad.getTipo_resultado(),
                         oportunidad.getMoneda(),
                         oportunidad.getEstimacion_ingreso(),
                         oportunidad.getEstimacion_egreso(),
                         oportunidad.getFecha_alta(),
                         oportunidad.getUsuario_alta(),
                         oportunidad.getProbabilidad(),
                         oportunidad.getEst_fec_cierre(),
                         oportunidad.getSensacion_cierre(),
                         oportunidad.getDescripcion(),
                         oportunidad.getUsuario_owner(),
                         oportunidad.getEstado_oportunidad(),
                         oportunidad.getCampania(),
                         oportunidad.getSujeto_generador(),
                         oportunidad.getVendedor_tecnico(),
                         oportunidad.getVendedor_comercial(),
                         oportunidad.getMotivo(),
                         oportunidad.getClasificacion(),
                         oportunidad.isActivo());
    }
    writeCliente(datasetOportunidad);
  }

  private IDataSet getDataSetOportunidad() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TOportunidad");
    dataset.fieldDef(new Field("oid_oportunidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));    
    dataset.fieldDef(new Field("tema", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_suj_pot", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_suj_pot", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_pot", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_precio_cab", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_precio_cab", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_resultado", Field.STRING, 10)); 
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("est_ing", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("est_egr", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("fec_alta", Field.DATE, 0)); 
    dataset.fieldDef(new Field("oid_usu_alta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_usu_alta", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_usu_alta", Field.STRING, 100));    
    dataset.fieldDef(new Field("probabilidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("est_fec_cierre", Field.DATE, 0)); 
    dataset.fieldDef(new Field("oid_sensa_cierre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sensa_cierre", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sensa_cierre", Field.STRING, 100));    
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_usu_owner", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_usu_owner", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_usu_owner", Field.STRING, 1000));
    dataset.fieldDef(new Field("oid_estado_opor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_estado_opor", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_estado_opor", Field.STRING, 100));    
    dataset.fieldDef(new Field("oid_campania", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_campania", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_campania", Field.STRING, 100));    
    dataset.fieldDef(new Field("oid_suj_gen_opor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_suj_gen_opor", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_gen_opor", Field.STRING, 50));    
    dataset.fieldDef(new Field("oid_vend_tec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vend_tec", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_vend_tec", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_vend_comer", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vend_comer", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_vend_comer", Field.STRING, 100));    
    dataset.fieldDef(new Field("oid_est_mot_opor", Field.INTEGER, 0));    
    dataset.fieldDef(new Field("cod_est_mot_opor", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_est_mot_opor", Field.STRING, 100));        
    dataset.fieldDef(new Field("oid_clasif_opor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_clasif_opor", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_opor", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroOportunidad(IDataSet dataset, 
                         Integer oid_oportunidad,
                         String codigo,
                         String tema,
                         Sujeto sujetoPotencial,
                         ListaPrecios listaPrecios,
                         String tipo_resultado,
                         Moneda moneda,
                         Money est_ing,
                         Money est_egr,
                         java.util.Date fec_alta,
                         Usuario usuarioAlta,
                         Integer probabilidad,
                         java.util.Date est_fec_cierre,
                         SensacionCierreOportunidad sensacionCierre,
                         String descripcion,
                         Usuario usuarioOwner,
                         EstadoOportunidad estadoOportunidad,
                         Campania campania,
                         Sujeto sujetoGenerado,
                         Vendedor vendedorTecnico,
                         Vendedor vendedorComercial,
                         MotivoEstadoOportunidad motivoEstado,
                         ClasificacionOportunidad clasificacion,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_oportunidad", oid_oportunidad);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("tema", tema);
    dataset.fieldValue("oid_suj_pot", sujetoPotencial.getOIDInteger());
    dataset.fieldValue("cod_suj_pot", sujetoPotencial.getCodigo());
    dataset.fieldValue("desc_suj_pot", sujetoPotencial.getRazon_social());
    if (listaPrecios!=null) {
      dataset.fieldValue("oid_precio_cab", listaPrecios.getOIDInteger());
      dataset.fieldValue("cod_precio_cab", listaPrecios.getCodigo());
      dataset.fieldValue("desc_precio_cab", listaPrecios.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_precio_cab", 0);
      dataset.fieldValue("cod_precio_cab", "");
      dataset.fieldValue("desc_precio_cab", "");    	
    }
    dataset.fieldValue("tipo_resultado", tipo_resultado);
    if (moneda!=null)
      dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda", 0); 	    	
    dataset.fieldValue("est_ing", est_ing);
    dataset.fieldValue("est_egr", est_egr);
    dataset.fieldValue("fec_alta",Fecha.getddmmyyyy(fec_alta));
    dataset.fieldValue("oid_usu_alta", usuarioAlta.getOIDInteger());
    dataset.fieldValue("cod_usu_alta", usuarioAlta.getCodigo());
    dataset.fieldValue("desc_usu_alta", usuarioAlta.getDescripcion());    
    dataset.fieldValue("probabilidad", probabilidad);
    dataset.fieldValue("est_fec_cierre", Fecha.getddmmyyyy(est_fec_cierre));
    if (sensacionCierre!=null) {
      dataset.fieldValue("oid_sensa_cierre", sensacionCierre.getOIDInteger());
      dataset.fieldValue("cod_sensa_cierre", sensacionCierre.getCodigo());
      dataset.fieldValue("desc_sensa_cierre", sensacionCierre.getDescripcion());
    } else {
      dataset.fieldValue("oid_sensa_cierre", 0);
      dataset.fieldValue("cod_sensa_cierre", "");
      dataset.fieldValue("desc_sensa_cierre", "");    	
    }    
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_usu_owner", usuarioOwner.getOIDInteger());
    dataset.fieldValue("cod_usu_owner", usuarioOwner.getCodigo());
    dataset.fieldValue("desc_usu_owner", usuarioOwner.getDescripcion());
    
    if (estadoOportunidad!=null) {
      dataset.fieldValue("oid_estado_opor", estadoOportunidad.getOIDInteger());
      dataset.fieldValue("cod_estado_opor", estadoOportunidad.getCodigo());
      dataset.fieldValue("desc_estado_opor", estadoOportunidad.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_estado_opor", 0);
        dataset.fieldValue("cod_estado_opor", "");
        dataset.fieldValue("desc_estado_opor", "");    	
    }
    
    if (campania!=null) {
      dataset.fieldValue("oid_campania", campania.getOIDInteger());
      dataset.fieldValue("cod_campania", campania.getCodigo());
      dataset.fieldValue("desc_campania", campania.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_campania", 0);
      dataset.fieldValue("cod_campania", "");
      dataset.fieldValue("desc_campania", "");    	
    }
    
    if (sujetoGenerado!=null) {
      dataset.fieldValue("oid_suj_gen_opor", sujetoGenerado.getOIDInteger());
      dataset.fieldValue("cod_suj_gen_opor", sujetoGenerado.getCodigo());
      dataset.fieldValue("desc_suj_gen_opor", sujetoGenerado.getDescripcion());      
    }
    else {
      dataset.fieldValue("oid_suj_gen_opor", 0);
      dataset.fieldValue("cod_suj_gen_opor", "");
      dataset.fieldValue("desc_suj_gen_opor", "");    	
    }
    if (vendedorTecnico!=null) {
      dataset.fieldValue("oid_vend_tec", vendedorTecnico.getOIDInteger());
      dataset.fieldValue("cod_vend_tec", vendedorTecnico.getCodigo());
      dataset.fieldValue("desc_vend_tec", vendedorTecnico.getDescripcion());
    } else {
      dataset.fieldValue("oid_vend_tec", 0);
      dataset.fieldValue("cod_vend_tec", "");
      dataset.fieldValue("desc_vend_tec", "");    	
    }
    
    if (vendedorComercial!=null) {
      dataset.fieldValue("oid_vend_comer", vendedorComercial.getOIDInteger());
      dataset.fieldValue("cod_vend_comer", vendedorComercial.getCodigo());
      dataset.fieldValue("desc_vend_comer", vendedorComercial.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_vend_comer", 0);
      dataset.fieldValue("cod_vend_comer", "");
      dataset.fieldValue("desc_vend_comer", "");    	
    }
    
    if (motivoEstado!=null) {
      dataset.fieldValue("oid_est_mot_opor", motivoEstado.getOIDInteger());
      dataset.fieldValue("cod_est_mot_opor", motivoEstado.getCodigo());
      dataset.fieldValue("desc_est_mot_opor", motivoEstado.getDescripcion());
    }
    else{
      dataset.fieldValue("oid_est_mot_opor", 0);
      dataset.fieldValue("cod_est_mot_opor", "");
      dataset.fieldValue("desc_est_mot_opor", "");    	
    }
    
    if (clasificacion!=null) {
      dataset.fieldValue("oid_clasif_opor", clasificacion.getOIDInteger());
      dataset.fieldValue("cod_clasif_opor", clasificacion.getCodigo());
      dataset.fieldValue("desc_clasif_opor", clasificacion.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_clasif_opor", 0);
      dataset.fieldValue("cod_clasif_opor", "");
      dataset.fieldValue("desc_clasif_opor", "");    	
    }
    dataset.fieldValue("activo", activo);
  }
}
