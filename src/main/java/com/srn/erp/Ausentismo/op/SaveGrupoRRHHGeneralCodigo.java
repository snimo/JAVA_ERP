package com.srn.erp.Ausentismo.op;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralCodigo;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHGeneralCodigo extends Operation { 

  public SaveGrupoRRHHGeneralCodigo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoRRHHGeneralCodigo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoRRHHGeneralCodigo gruporrhhgeneralcodigo = GrupoRRHHGeneralCodigo.findByOid(dataset.getInteger("oid_grupo_gral_cod"),getSesion());
        gruporrhhgeneralcodigo.setOID(dataset.getInteger("oid_grupo_gral_cod"));
        GrupoRRHHGeneralDesc grupoGeneralDesc = GrupoRRHHGeneralDesc.findByOid(dataset.getInteger("oid_grupo_gral_desc"), this.getSesion());
        gruporrhhgeneralcodigo.setGrupogeneraldesc(grupoGeneralDesc);
        gruporrhhgeneralcodigo.setTipotabla(dataset.getString("tipo_tabla"));
        gruporrhhgeneralcodigo.setCodigoexternoelemento(dataset.getString("cod_ext_elemento"));
        gruporrhhgeneralcodigo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(gruporrhhgeneralcodigo);
        dataset.next();
    }
  }
  
}
