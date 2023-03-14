package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.ConsultaPrecios;
import com.srn.erp.ventas.da.DBConsultaPrecios;

public class FactoryConsultaPrecios extends FactoryObjetoLogico { 

  public FactoryConsultaPrecios() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaPrecios consultaprecios = (ConsultaPrecios) objLog;
    consultaprecios.setOid_precio_cab(db.getInteger(DBConsultaPrecios.OID_PRECIO_CAB));
    consultaprecios.setOid_producto(db.getInteger(DBConsultaPrecios.OID_PRODUCTO));
    consultaprecios.setCod_producto(db.getString(DBConsultaPrecios.COD_PRODUCTO));
    consultaprecios.setDesc_producto(db.getString(DBConsultaPrecios.DESC_PRODUCTO));
    consultaprecios.setCantidad(db.getDouble(DBConsultaPrecios.CANTIDAD));
    consultaprecios.setOid_um(db.getInteger(DBConsultaPrecios.OID_UM));
    consultaprecios.setCod_um(db.getString(DBConsultaPrecios.COD_UM));
    consultaprecios.setOid_moneda(db.getInteger(DBConsultaPrecios.OID_MONEDA));
    consultaprecios.setCod_moneda(db.getString(DBConsultaPrecios.COD_MONEDA));
    consultaprecios.setPrecio(db.getDouble(DBConsultaPrecios.PRECIO));

  }
}
