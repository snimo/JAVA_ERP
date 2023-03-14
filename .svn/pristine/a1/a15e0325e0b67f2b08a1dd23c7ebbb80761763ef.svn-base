package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.AplicPedDepoRto;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBAplicPedDepoRto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicPedDepoRto extends FactoryObjetoLogico { 

  public FactoryAplicPedDepoRto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicPedDepoRto aplicpeddeporto = (AplicPedDepoRto) objLog;
    aplicpeddeporto.setOID(db.getInteger(DBAplicPedDepoRto.OID_APLIC_PED_RTO));
    aplicpeddeporto.setPedido_merc_det(PedMercDepoDet.findByOidProxy(db.getInteger(DBAplicPedDepoRto.OID_PED_MERC_DET),getSesion()));
    aplicpeddeporto.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBAplicPedDepoRto.OID_REMITO_DET),getSesion()));
    aplicpeddeporto.setCant_enviada(db.getDouble(DBAplicPedDepoRto.CANT_ENVIADA));
    aplicpeddeporto.setUm(UnidadMedida.findByOidProxy(db.getInteger(DBAplicPedDepoRto.OID_UM),getSesion()));
    aplicpeddeporto.setActivo(db.getBoolean(DBAplicPedDepoRto.ACTIVO));

  }
}
