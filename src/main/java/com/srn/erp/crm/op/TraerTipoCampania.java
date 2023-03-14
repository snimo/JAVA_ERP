package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.TipoCampania;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCampania extends Operation { 

  public TraerTipoCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoCampania tipocampania = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipocampania = TipoCampania.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipocampania = TipoCampania.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoCampania = getDataSetTipoCampania();
    if (tipocampania != null) { 
        cargarRegistroTipoCampania(datasetTipoCampania, 
                         tipocampania.getCodigo(),
                         tipocampania.getDescripcion(),
                         tipocampania.isActivo(),
                         tipocampania.getOIDInteger());
    }
    writeCliente(datasetTipoCampania);
  }

  private IDataSet getDataSetTipoCampania() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoCampania");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_tipo_camp", Field.INTEGER, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoCampania(IDataSet dataset, 
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer oid_tipo_camp) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("oid_tipo_camp", oid_tipo_camp);
  }
}
