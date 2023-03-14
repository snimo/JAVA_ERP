package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoArchCTar extends Operation { 

  public TraerTipoArchCTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoArchConciTar tipoarchconcitar = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoarchconcitar = TipoArchConciTar.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoarchconcitar = TipoArchConciTar.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoArchConciTar = getDataSetTipoArchConciTar();
    if (tipoarchconcitar != null) { 
        cargarRegistroTipoArchConciTar(datasetTipoArchConciTar, 
                         tipoarchconcitar.getOIDInteger(),
                         tipoarchconcitar.getCodigo(),
                         tipoarchconcitar.getDescripcion(),
                         tipoarchconcitar.getComportamiento(),
                         tipoarchconcitar.getAnt_ult_folder_emp(),
                         tipoarchconcitar.getUlt_folder_tipo(),
                         tipoarchconcitar.isActivo(),
                         tipoarchconcitar.getCodArchImpTarj()
                         );
    }
    writeCliente(datasetTipoArchConciTar);
  }

  private IDataSet getDataSetTipoArchConciTar() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoArchConciTar");
    dataset.fieldDef(new Field("oid_tipo_archivo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("ant_ult_folder_emp", Field.STRING, 255)); 
    dataset.fieldDef(new Field("ult_folder_tipo", Field.STRING, 255)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("cod_arch_imp_tarj", Field.STRING, 10));
    return dataset;
  }

  private void cargarRegistroTipoArchConciTar(IDataSet dataset, 
                         Integer oid_tipo_archivo,
                         String codigo,
                         String descripcion,
                         String comportamiento,
                         String ant_ult_folder_emp,
                         String ult_folder_tipo,
                         Boolean activo,
                         String codArchImpTarj) {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_archivo", oid_tipo_archivo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("ant_ult_folder_emp", ant_ult_folder_emp);
    dataset.fieldValue("ult_folder_tipo", ult_folder_tipo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("cod_arch_imp_tarj", codArchImpTarj);
  }
}
