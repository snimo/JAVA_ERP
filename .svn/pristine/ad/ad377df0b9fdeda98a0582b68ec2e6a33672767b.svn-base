package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.ObsGeneralesOC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerObsGeneralesOC extends Operation { 

  public TraerObsGeneralesOC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ObsGeneralesOC obsgeneralesoc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       obsgeneralesoc = ObsGeneralesOC.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       obsgeneralesoc = ObsGeneralesOC.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetObsGeneralesOC = getDataSetObsGeneralesOC();
    if (obsgeneralesoc != null) { 
        cargarRegistroObsGeneralesOC(datasetObsGeneralesOC, 
                         obsgeneralesoc.getOIDInteger(),
                         obsgeneralesoc.getCodigo(),
                         obsgeneralesoc.getDescripcion(),
                         obsgeneralesoc.isIncluir_en_oc(),
                         obsgeneralesoc.getOrden(),
                         obsgeneralesoc.isActivo());
    }
    writeCliente(datasetObsGeneralesOC);
  }

  private IDataSet getDataSetObsGeneralesOC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TObsGeneralesOC");
    dataset.fieldDef(new Field("oid_obs_gen_oc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 5000)); 
    dataset.fieldDef(new Field("inc_en_oc", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroObsGeneralesOC(IDataSet dataset, 
                         Integer oid_obs_gen_oc,
                         String codigo,
                         String descripcion,
                         Boolean inc_en_oc,
                         Integer orden,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_obs_gen_oc", oid_obs_gen_oc);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("inc_en_oc", inc_en_oc);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("activo", activo);
  }
}
