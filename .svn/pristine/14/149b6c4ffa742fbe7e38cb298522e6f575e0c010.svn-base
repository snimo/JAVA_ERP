package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AplicFacturadoRemito;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBAplicFacturadoRemito;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicFacturadoRemito extends FactoryObjetoLogico { 

  public FactoryAplicFacturadoRemito() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicFacturadoRemito aplicfacturadoremito = (AplicFacturadoRemito) objLog;
    aplicfacturadoremito.setOID(db.getInteger(DBAplicFacturadoRemito.OID_FACT_REM));
    aplicfacturadoremito.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBAplicFacturadoRemito.OID_REMITO_DET),getSesion()));
    aplicfacturadoremito.setCant_fact(db.getDouble(DBAplicFacturadoRemito.CANT_FACT));
    aplicfacturadoremito.setCompo_compro(db.getString(DBAplicFacturadoRemito.COMPO_COMPRO));
    aplicfacturadoremito.setFactura(FacturaCab.findByOidProxy(db.getInteger(DBAplicFacturadoRemito.OID_CCO_FACT),getSesion()));
    aplicfacturadoremito.setFactura_det(FacturaDet.findByOidProxy(db.getInteger(DBAplicFacturadoRemito.OID_CCO_FACT_DET),getSesion()));
    aplicfacturadoremito.setActivo(db.getBoolean(DBAplicFacturadoRemito.ACTIVO));

  }
}
