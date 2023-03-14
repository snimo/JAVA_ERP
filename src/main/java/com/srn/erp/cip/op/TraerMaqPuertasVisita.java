package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerMaqPuertasVisita extends Operation { 

  public TraerMaqPuertasVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MaqPuertasVisita maqpuertasvisita = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       maqpuertasvisita = MaqPuertasVisita.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       maqpuertasvisita = MaqPuertasVisita.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMaqPuertasVisita = getDataSetMaqPuertasVisita();
    if (maqpuertasvisita != null) 
        cargarRegistroMaqPuertasVisita(datasetMaqPuertasVisita,maqpuertasvisita);
    writeCliente(datasetMaqPuertasVisita);
  }

  private IDataSet getDataSetMaqPuertasVisita() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMaqPuertasVisita");
    dataset.fieldDef(new Field("oid_maq_pue_vis", Field.STRING, 0)); 
    dataset.fieldDef(new Field("maquina", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_puerta_ent", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_puerta_ent", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_puerta_ent", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_puerta_sal", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_puerta_sal", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_puerta_sal", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_puerta", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_puerta", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroMaqPuertasVisita(
		  IDataSet dataset,
		  MaqPuertasVisita maqPuertaVisita) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_maq_pue_vis", maqPuertaVisita.getOIDInteger());
    dataset.fieldValue("maquina", maqPuertaVisita.getMaquina());
    if (maqPuertaVisita.getPuerta_entrada()!=null) {
    	dataset.fieldValue("oid_puerta_ent", maqPuertaVisita.getPuerta_entrada().getOIDInteger());
    	dataset.fieldValue("cod_puerta_ent", maqPuertaVisita.getPuerta_entrada().getCodigo());
    	dataset.fieldValue("desc_puerta_ent", maqPuertaVisita.getPuerta_entrada().getDescripcion());
    } else {
    	dataset.fieldValue("oid_puerta_ent", "");
    	dataset.fieldValue("cod_puerta_ent", "");
    	dataset.fieldValue("desc_puerta_ent", "");
    }
    if (maqPuertaVisita.getPuerta_salida()!=null) {
    	dataset.fieldValue("oid_puerta_sal", maqPuertaVisita.getPuerta_salida().getOIDInteger());
    	dataset.fieldValue("cod_puerta_sal", maqPuertaVisita.getPuerta_salida().getCodigo());
    	dataset.fieldValue("desc_puerta_sal", maqPuertaVisita.getPuerta_salida().getDescripcion());
    } else {
    	dataset.fieldValue("oid_puerta_sal", "");
    	dataset.fieldValue("cod_puerta_sal", "");
    	dataset.fieldValue("desc_puerta_sal", "");
    }
    dataset.fieldValue("activo", maqPuertaVisita.isActivo());
    
    if (maqPuertaVisita.getGrupoPuerta()!=null) {
    	dataset.fieldValue("oid_grupo_puerta", maqPuertaVisita.getGrupoPuerta().getOIDInteger());
    	dataset.fieldValue("cod_grupo_puerta", maqPuertaVisita.getGrupoPuerta().getCodigo());
    	dataset.fieldValue("desc_grupo_puerta", maqPuertaVisita.getGrupoPuerta().getDescripcion());
    } else {
    	dataset.fieldValue("oid_grupo_puerta", "");
    	dataset.fieldValue("cod_grupo_puerta", "");
    	dataset.fieldValue("desc_grupo_puerta", "");
    }
    
    
  }
}
