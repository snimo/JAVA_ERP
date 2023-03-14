package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoEstructuraPlanif extends Operation { 

  public TraerGrupoEstructuraPlanif() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoEstructuraPlanif grupoestructuraplanif = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupoestructuraplanif = GrupoEstructuraPlanif.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupoestructuraplanif = GrupoEstructuraPlanif.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoEstructuraPlanif = getDataSetGrupoEstructuraPlanif();
    if (grupoestructuraplanif != null) { 
        cargarRegistroGrupoEstructuraPlanif(datasetGrupoEstructuraPlanif, 
                         										grupoestructuraplanif);
    }
    writeCliente(datasetGrupoEstructuraPlanif);
  }

  private IDataSet getDataSetGrupoEstructuraPlanif() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoEstructuraPlanif");
    dataset.fieldDef(new Field("oid_grupo_est", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroGrupoEstructuraPlanif(IDataSet dataset, 
                         GrupoEstructuraPlanif grupoEstructuraPlanif) throws BaseException {
  	
    dataset.append(); 
    dataset.fieldValue("oid_grupo_est", grupoEstructuraPlanif.getOIDInteger());
    dataset.fieldValue("codigo", grupoEstructuraPlanif.getCodigo());
    dataset.fieldValue("descripcion", grupoEstructuraPlanif.getDescripcion());
    dataset.fieldValue("activo", grupoEstructuraPlanif.isActivo());
    dataset.fieldValue("orden", grupoEstructuraPlanif.getOrden());
    
  }
  
}
