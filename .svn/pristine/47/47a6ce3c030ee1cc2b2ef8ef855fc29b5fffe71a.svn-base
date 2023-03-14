package com.srn.erp.Ausentismo.op;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHDetalleRotas extends Operation { 

  public TraerGrupoRRHHDetalleRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoRRHHDetalle grupodetalle = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupodetalle = GrupoRRHHDetalle.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupodetalle = GrupoRRHHDetalle.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
    if (grupodetalle != null) { 
        cargarRegistroGrupoDetalle(datasetGrupoDetalle, 
                         grupodetalle.getOIDInteger(),
                         grupodetalle.getOid_grupo(),
                         grupodetalle.getCod_ext_1(),
                         grupodetalle.isActivo());
    }
    writeCliente(datasetGrupoDetalle);
  }

  private IDataSet getDataSetGrupoDetalle() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoDetalle");
    dataset.fieldDef(new Field("oid_grupo_det", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_ext_tramo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoDetalle(IDataSet dataset, 
                         Integer oid_grupo_det,
                         Integer oid_grupo,
                         String cod_ext_tramo,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_det", oid_grupo_det);
    dataset.fieldValue("oid_grupo", oid_grupo);
    dataset.fieldValue("cod_ext_tramo", cod_ext_tramo);
    dataset.fieldValue("activo", activo);
  }
}
