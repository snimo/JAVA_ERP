package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.SubGrupoCategAcceso;
import com.srn.erp.cip.da.DBCategAccesoCIP;

public class FactoryCategAccesoCIP extends FactoryObjetoLogico { 

  public FactoryCategAccesoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategAccesoCIP categaccesocip = (CategAccesoCIP) objLog;
    categaccesocip.setOID(db.getInteger(DBCategAccesoCIP.OID_CATEG_ACCESO));
    categaccesocip.setCodigo(db.getString(DBCategAccesoCIP.CODIGO));
    categaccesocip.setDescripcion(db.getString(DBCategAccesoCIP.DESCRIPCION));
    categaccesocip.setActivo(db.getBoolean(DBCategAccesoCIP.ACTIVO));
    categaccesocip.setSubGrupoCategAcceso(SubGrupoCategAcceso.findByOidProxy(db.getInteger(DBCategAccesoCIP.OID_SUB_GRUPO), this.getSesion()));
  }
  
}
