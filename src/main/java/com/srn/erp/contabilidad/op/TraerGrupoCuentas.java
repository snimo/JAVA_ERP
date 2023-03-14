package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoCuentas extends Operation { 

  public TraerGrupoCuentas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoCuentas grupocuentas = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupocuentas = GrupoCuentas.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupocuentas = GrupoCuentas.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoCuentas = getDataSetGrupoCuentas();
    if (grupocuentas != null) { 
        cargarRegistroGrupoCuentas(datasetGrupoCuentas, 
                         grupocuentas.getOIDInteger(),
                         grupocuentas.getCodigo(),
                         grupocuentas.getDescripcion(),
                         grupocuentas.isActivo());
    }
    writeCliente(datasetGrupoCuentas);
  }

  private IDataSet getDataSetGrupoCuentas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoCuentas");
    dataset.fieldDef(new Field("oid_grupo_cta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoCuentas(IDataSet dataset, 
                         Integer oid_grupo_cta,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_cta", oid_grupo_cta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
