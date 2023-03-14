package com.srn.erp.Ausentismo.op;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralCodigo;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHGeneralCodigo extends Operation { 

  public TraerGrupoRRHHGeneralCodigo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoRRHHGeneralCodigo gruporrhhgeneralcodigo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       gruporrhhgeneralcodigo = GrupoRRHHGeneralCodigo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       gruporrhhgeneralcodigo = GrupoRRHHGeneralCodigo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoRRHHGeneralCodigo = getDataSetGrupoRRHHGeneralCodigo();
    if (gruporrhhgeneralcodigo != null) { 
        cargarRegistroGrupoRRHHGeneralCodigo(datasetGrupoRRHHGeneralCodigo, 
                         gruporrhhgeneralcodigo.getOIDInteger(),
                         gruporrhhgeneralcodigo.getGrupogeneraldesc(),
                         gruporrhhgeneralcodigo.getTipotabla(),
                         gruporrhhgeneralcodigo.getCodigoexternoelemento(),
                         gruporrhhgeneralcodigo.isActivo());
    }
    writeCliente(datasetGrupoRRHHGeneralCodigo);
  }

  private IDataSet getDataSetGrupoRRHHGeneralCodigo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoRRHHGeneralCodigo");
    dataset.fieldDef(new Field("oid_grupo_gral_cod", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_gral_desc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("tipo_tabla", Field.STRING, 50)); 
    dataset.fieldDef(new Field("cod_ext_elemento", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoRRHHGeneralCodigo(IDataSet dataset, 
                         Integer oid_grupo_gral_cod,
                         GrupoRRHHGeneralDesc oid_grupo_gral_desc,
                         String tipo_tabla,
                         String cod_ext_elemento,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_gral_cod", oid_grupo_gral_cod);
    dataset.fieldValue("oid_grupo_gral_desc", oid_grupo_gral_desc);
    dataset.fieldValue("tipo_tabla", tipo_tabla);
    dataset.fieldValue("cod_ext_elemento", cod_ext_elemento);
    dataset.fieldValue("activo", activo);
  }
}
