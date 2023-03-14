package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactSector;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactSector;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsquemaAutorizFactSector extends FactoryObjetoLogico { 

  public FactoryEsquemaAutorizFactSector() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsquemaAutorizFactSector esquemaautorizfactsector = (EsquemaAutorizFactSector) objLog;
    esquemaautorizfactsector.setOID(db.getInteger(DBEsquemaAutorizFactSector.OID_ESQ_AUT_SEC));
    esquemaautorizfactsector.setEsquema_autoriz_factura_monto(EsquemaAutorizFactMonto.findByOidProxy(db.getInteger(DBEsquemaAutorizFactSector.OID_ESQ_AUT_MON),getSesion()));
    esquemaautorizfactsector.setSector_compra(SectorCompra.findByOidProxy(db.getInteger(DBEsquemaAutorizFactSector.OID_SECTOR_COMPRA),getSesion()));
    esquemaautorizfactsector.setRol_autotizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBEsquemaAutorizFactSector.OID_ROL_AUTORIZ),getSesion()));
    esquemaautorizfactsector.setTipo_autoriz(db.getString(DBEsquemaAutorizFactSector.TIPO_AUTORIZ));

  }
}
