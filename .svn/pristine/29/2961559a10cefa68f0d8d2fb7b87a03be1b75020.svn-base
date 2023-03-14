package com.srn.erp.Ausentismo.op;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHGeneralDesc extends Operation { 

  public SaveGrupoRRHHGeneralDesc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoRRHHGeneralDesc"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoRRHHGeneralDesc gruporrhhgeneraldesc = GrupoRRHHGeneralDesc.findByOid(dataset.getInteger("oid_grupo_gral_desc"),getSesion());
        gruporrhhgeneraldesc.setOID(dataset.getInteger("oid_grupo_gral_desc"));
        GrupoRRHHGeneral grupoGeneral = GrupoRRHHGeneral.findByOid(dataset.getInteger("oid_grupo_gral"), this.getSesion());
        gruporrhhgeneraldesc.setGrupogral(grupoGeneral);
        gruporrhhgeneraldesc.setDescripcion(dataset.getString("descripcion"));
        gruporrhhgeneraldesc.setActivo(dataset.getBoolean("activo"));
        addTransaccion(gruporrhhgeneraldesc);
        dataset.next();
    }
  }
  
}