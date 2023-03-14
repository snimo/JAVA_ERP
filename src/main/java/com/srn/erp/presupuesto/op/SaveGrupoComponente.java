package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.GrupoComponente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoComponente extends Operation { 

  public SaveGrupoComponente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoComponente"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoComponente grupocomponente = GrupoComponente.findByOid(dataset.getInteger("oid_grupo_compo"),getSesion());
        grupocomponente.setOID(dataset.getInteger("oid_grupo_compo"));
        grupocomponente.setCodigo(dataset.getString("codigo"));
        grupocomponente.setDescripcion(dataset.getString("descripcion"));
        grupocomponente.setActivo(dataset.getBoolean("activo"));
        addTransaccion(grupocomponente);
        dataset.next();
    }
  }
  
}
