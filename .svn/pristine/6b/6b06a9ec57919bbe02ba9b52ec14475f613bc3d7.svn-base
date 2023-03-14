package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoTipoUPC extends Operation { 

  public SaveGrupoTipoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoTipoUPC"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoTipoUPC grupotipoupc = GrupoTipoUPC.findByOid(dataset.getInteger("oid_grupo_tipo_upc"),getSesion());
        grupotipoupc.setOID(dataset.getInteger("oid_grupo_tipo_upc"));
        grupotipoupc.setCodigo(dataset.getString("codigo"));
        grupotipoupc.setDescripcion(dataset.getString("descripcion"));
        grupotipoupc.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsDetalle = dataset.getDataSet("TGrupoTipoUPCDet");
        dsDetalle.first();
        while (!dsDetalle.EOF()) {
          GrupoTipoUPCDet grupotipoupcdet = GrupoTipoUPCDet.findByOid(dsDetalle.getInteger("oid_grupo_det"),getSesion());
          grupotipoupcdet.setGrupo_tipo_upc(grupotipoupc);
          grupotipoupcdet.setTipo_upc(TipoUPC.findByOidProxy(dsDetalle.getInteger("oid_tipo_upc"),this.getSesion()));
          grupotipoupcdet.setActivo(dsDetalle.getBoolean("activo"));
          if (grupotipoupcdet.isActivo().booleanValue()==false)
          	grupotipoupcdet.delete();
          grupotipoupc.addDetalle(grupotipoupcdet);
        	dsDetalle.next();
        }
        
        addTransaccion(grupotipoupc);
        dataset.next();
    }
  }
  
}
