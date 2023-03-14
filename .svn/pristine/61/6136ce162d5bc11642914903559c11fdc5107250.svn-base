package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.compras.da.DBAcuerdoLP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAcuerdoLP extends FactoryObjetoLogico { 

  public FactoryAcuerdoLP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  
    AcuerdoLP acuerdolp = (AcuerdoLP) objLog;
    acuerdolp.setOID(db.getInteger(DBAcuerdoLP.OID_ACUERDO_LP));
    acuerdolp.setTipo_acuerdo(TipoAcuerdo.findByOidProxy(db.getInteger(DBAcuerdoLP.OID_TIPO_ACUERDO),getSesion()));
    acuerdolp.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBAcuerdoLP.OID_PROVEEDOR),getSesion()));
    acuerdolp.setActivo(db.getBoolean(DBAcuerdoLP.ACTIVO));
    acuerdolp.setDescripcion(db.getString(DBAcuerdoLP.DESCRIPCION));
    
  }
}
