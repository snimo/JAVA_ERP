package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.da.DBGrupoTipoUPC;

public class FactoryGrupoTipoUPC extends FactoryObjetoLogico { 

  public FactoryGrupoTipoUPC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoTipoUPC grupotipoupc = (GrupoTipoUPC) objLog;
    grupotipoupc.setOID(db.getInteger(DBGrupoTipoUPC.OID_GRUPO_TIPO_UPC));
    grupotipoupc.setCodigo(db.getString(DBGrupoTipoUPC.CODIGO));
    grupotipoupc.setDescripcion(db.getString(DBGrupoTipoUPC.DESCRIPCION));
    grupotipoupc.setActivo(db.getBoolean(DBGrupoTipoUPC.ACTIVO));

  }
}
