package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCaracterExcluido extends Operation { 

  public TraerCaracterExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CaracterExcluido caracterexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       caracterexcluido = CaracterExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       caracterexcluido = CaracterExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCaracterExcluido = getDataSetCaracterExcluido();
    if (caracterexcluido != null)  
        cargarRegistroCaracterExcluido(datasetCaracterExcluido,caracterexcluido);
    
    writeCliente(datasetCaracterExcluido);
  }

  private IDataSet getDataSetCaracterExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCaracterExcluido");
    dataset.fieldDef(new Field("oid_caracter", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCaracterExcluido(IDataSet dataset, 
                         CaracterExcluido caracter) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_caracter", caracter.getOIDInteger());
    dataset.fieldValue("codigo", caracter.getCodigo());
    dataset.fieldValue("descripcion", caracter.getDescripcion());
    dataset.fieldValue("activo", caracter.isActivo());
  }
}
