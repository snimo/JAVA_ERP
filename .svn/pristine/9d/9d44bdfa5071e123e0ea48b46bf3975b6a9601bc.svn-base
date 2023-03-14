package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.Campania;
import com.srn.erp.crm.bm.EstadoCampania;
import com.srn.erp.crm.bm.TipoCampania;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCampania extends Operation { 

  public TraerCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Campania campania = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       campania = Campania.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       campania = Campania.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCampania = getDataSetCampania();
    if (campania != null) { 
    	
        cargarRegistroCampania(datasetCampania, 
                         campania.getOIDInteger(),
                         campania.getCodigo(),
                         campania.getNombre(),
                         campania.getEstado(),
                         campania.getTipoCampania(),
                         campania.getLista_precios(),
                         campania.getCant_resp_esp(),
                         campania.getFecha_desde(),
                         campania.getFecha_hasta(),
                         campania.getDescripcion(),
                         campania.getComentario(),
                         campania.getUsuario_alta(),
                         campania.getFec_usu_alta(),
                         campania.isActivo());
    }
    writeCliente(datasetCampania);
  }

  private IDataSet getDataSetCampania() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCampania");
    dataset.fieldDef(new Field("oid_campania", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("nombre", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_est_camp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_est_camp", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_est_camp", Field.STRING, 50));
    
    dataset.fieldDef(new Field("oid_tipo_camp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_camp", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_tipo_camp", Field.STRING, 50));    
        
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_precio_cab", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_precio_cab", Field.STRING, 50));
    
    dataset.fieldDef(new Field("cant_resp_esp", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("fec_desde", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 80)); 
    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
    
    dataset.fieldDef(new Field("oid_usu_alta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_usu_alta", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_usu_alta", Field.STRING, 100));
    
    dataset.fieldDef(new Field("fec_alta", Field.DATE, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCampania(IDataSet dataset, 
                         Integer oid_campania,
                         String codigo,
                         String nombre,
                         EstadoCampania estadoCampania,
                         TipoCampania tipoCampania,
                         ListaPrecios listaPrecios,
                         Integer cant_resp_esp,
                         java.util.Date fec_desde,
                         java.util.Date fec_hasta,
                         String descripcion,
                         String comentario,
                         Usuario usuarioAlta,
                         java.util.Date fec_alta,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_campania", oid_campania);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("nombre", nombre);
    
    dataset.fieldValue("oid_est_camp", estadoCampania.getOIDInteger());
    dataset.fieldValue("cod_est_camp", estadoCampania.getCodigo());
    dataset.fieldValue("desc_est_camp", estadoCampania.getDescripcion());
    
    dataset.fieldValue("oid_tipo_camp", tipoCampania.getOIDInteger());
    dataset.fieldValue("cod_tipo_camp", tipoCampania.getCodigo());
    dataset.fieldValue("desc_tipo_camp", tipoCampania.getDescripcion());    
    
    dataset.fieldValue("oid_precio_cab", listaPrecios.getOIDInteger());
    dataset.fieldValue("cod_precio_cab", listaPrecios.getCodigo());
    dataset.fieldValue("desc_precio_cab", listaPrecios.getDescripcion());
    
    dataset.fieldValue("cant_resp_esp", cant_resp_esp);
    dataset.fieldValue("fec_desde",Fecha.getddmmyyyy(fec_desde));
    dataset.fieldValue("fec_hasta", Fecha.getddmmyyyy(fec_hasta));
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comentario", comentario);
    
    dataset.fieldValue("oid_usu_alta", usuarioAlta.getOIDInteger());
    dataset.fieldValue("cod_usu_alta", usuarioAlta.getCodigo());
    dataset.fieldValue("desc_usu_alta", usuarioAlta.getDescripcion());
    
    dataset.fieldValue("fec_alta", Fecha.getddmmyyyy(fec_alta));
    dataset.fieldValue("activo", activo);
  }
}
