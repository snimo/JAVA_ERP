package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerZonaCIP extends Operation { 

  public TraerZonaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ZonaCIP zonacip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       zonacip = ZonaCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       zonacip = ZonaCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetZonaCIP = getDataSetZonaCIP();
    if (zonacip != null) 
        cargarRegistroZonaCIP(datasetZonaCIP,zonacip);
    
    writeCliente(datasetZonaCIP);
  }

  private IDataSet getDataSetZonaCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TZonaCIP");
    dataset.fieldDef(new Field("oid_zona", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("color", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_tipo_zona", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("capacidad_max", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("alarma_de_cap", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("bloquear_exc_cap", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("estado_zona", Field.STRING, 20)); 
    dataset.fieldDef(new Field("ubicacion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_grupo_usu_alar", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_maq_alar", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("mens_alar_cap_max", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_ring_max_cap", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("es_externa", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("controla_anti_ent", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("controla_anti_sal", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroZonaCIP(IDataSet dataset, ZonaCIP zona) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_zona", zona.getOIDInteger());
    dataset.fieldValue("codigo", zona.getCodigo());
    dataset.fieldValue("activo", zona.isActivo());
    dataset.fieldValue("color", zona.getColor());
    dataset.fieldValue("descripcion", zona.getDescripcion());
    if (zona.getOid_tipo_zona()!=null)
    	dataset.fieldValue("oid_tipo_zona", zona.getOid_tipo_zona().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_zona", "");
    dataset.fieldValue("capacidad_max", zona.getCapacidad_max());
    dataset.fieldValue("alarma_de_cap", zona.getAlarma_de_cap());
    dataset.fieldValue("bloquear_exc_cap", zona.isBloquear_exc_cap());
    dataset.fieldValue("estado_zona", zona.getEstado_zona());
    dataset.fieldValue("ubicacion", zona.getUbicacion());
    if (zona.getGrupo_usu_alar()!=null)
    	dataset.fieldValue("oid_grupo_usu_alar", zona.getGrupo_usu_alar().getOIDInteger());
    else
    	dataset.fieldValue("oid_grupo_usu_alar", "");
    if (zona.getGrupo_maq_alar()!=null)
    	dataset.fieldValue("oid_grupo_maq_alar", zona.getGrupo_maq_alar().getOIDInteger());
    else
    	dataset.fieldValue("oid_grupo_maq_alar", "");
    dataset.fieldValue("mens_alar_cap_max", zona.getMens_alar_cap_max());
    if (zona.getRing_max_cap()!=null)
    	dataset.fieldValue("oid_ring_max_cap", zona.getRing_max_cap().getOIDInteger());
    else
    	dataset.fieldValue("oid_ring_max_cap", "");
    dataset.fieldValue("es_externa" , zona.esExterna());
    dataset.fieldValue("controla_anti_ent" ,zona.isControlaAntiEnt());
    dataset.fieldValue("controla_anti_sal",zona.isControlaAntiSal());
  }
  
}
