package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCtaBancoLiqTarj extends Operation { 

  public TraerCtaBancoLiqTarj() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CtaBancoLiqTarj ctabancoliqtarj = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       ctabancoliqtarj = CtaBancoLiqTarj.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       ctabancoliqtarj = CtaBancoLiqTarj.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCtaBancoLiqTarj = getDataSetCtaBancoLiqTarj();
    if (ctabancoliqtarj != null) { 
        cargarRegistroCtaBancoLiqTarj(datasetCtaBancoLiqTarj, 
                         ctabancoliqtarj.getOIDInteger(),
                         ctabancoliqtarj.getCodigo(),
                         ctabancoliqtarj.getDescripcion(),
                         ctabancoliqtarj.getCod_interfaz(),
                         ctabancoliqtarj.isActivo(),
                         ctabancoliqtarj.getEmpresa()
                         );
    }
    writeCliente(datasetCtaBancoLiqTarj);
  }

  private IDataSet getDataSetCtaBancoLiqTarj() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCtaBancoLiqTarj");
    dataset.fieldDef(new Field("oid_cta_banco", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("cod_interfaz", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroCtaBancoLiqTarj(IDataSet dataset, 
                         Integer oid_cta_banco,
                         String codigo,
                         String descripcion,
                         String cod_interfaz,
                         Boolean activo,
                         EmpresaConciTar empresa) {
    dataset.append(); 
    dataset.fieldValue("oid_cta_banco", oid_cta_banco);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("cod_interfaz", cod_interfaz);
    dataset.fieldValue("activo", activo);
    if (empresa!=null)
    	dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
    else
    	dataset.fieldValue("oid_empresa", "");
  }
}
