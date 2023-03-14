package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerRazaExcluido extends Operation { 

  public TraerRazaExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RazaExcluido razaexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       razaexcluido = RazaExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       razaexcluido = RazaExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRazaExcluido = getDataSetRazaExcluido();
    if (razaexcluido != null) 
        cargarRegistroRazaExcluido(datasetRazaExcluido, 
                         razaexcluido);
    
    writeCliente(datasetRazaExcluido);
  }

  private IDataSet getDataSetRazaExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRazaExcluido");
    dataset.fieldDef(new Field("oid_raza", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRazaExcluido(IDataSet dataset,
		  				  RazaExcluido raza) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_raza", raza.getOIDInteger());
    dataset.fieldValue("codigo", raza.getCodigo());
    dataset.fieldValue("descripcion", raza.getDescripcion());
    dataset.fieldValue("activo", raza.isActivo());
  }
}
