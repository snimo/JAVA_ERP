package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AplicacionRetiroProveedor;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.da.DBAplicacionRetiroProveedor;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionRetiroProveedor extends FactoryObjetoLogico { 

  public FactoryAplicacionRetiroProveedor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionRetiroProveedor aplicacionretiroproveedor = (AplicacionRetiroProveedor) objLog;
    aplicacionretiroproveedor.setOID(db.getInteger(DBAplicacionRetiroProveedor.OID_APLIC_RET_PROV));
    aplicacionretiroproveedor.setControl_calidad_det(InformeControlCalidadDet.findByOidProxy(db.getInteger(DBAplicacionRetiroProveedor.OID_CC_DET),getSesion()));
    aplicacionretiroproveedor.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBAplicacionRetiroProveedor.OID_REMITO_DET),getSesion()));
    aplicacionretiroproveedor.setCant_um_stk(db.getDouble(DBAplicacionRetiroProveedor.CANT_UM_STK));
    aplicacionretiroproveedor.setOid_um_stk(UnidadMedida.findByOidProxy(db.getInteger(DBAplicacionRetiroProveedor.OID_UM_STK),getSesion()));
    aplicacionretiroproveedor.setCant_um_cpra(db.getDouble(DBAplicacionRetiroProveedor.CANT_UM_CPRA));
    aplicacionretiroproveedor.setOid_um_cpra(UnidadMedida.findByOidProxy(db.getInteger(DBAplicacionRetiroProveedor.OID_UM_CPRA),getSesion()));

  }
}
