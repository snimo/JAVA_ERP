package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.GrupoCondPago;
import com.srn.erp.ventas.da.DBCondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionPago extends FactoryObjetoLogico {

  public FactoryCondicionPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionPago condicionpago = (CondicionPago) objLog;
    condicionpago.setOID(db.getInteger(DBCondicionPago.OID_COND_PAGO));
    condicionpago.setCodigo(db.getString(DBCondicionPago.CODIGO));
    condicionpago.setDescripcion(db.getString(DBCondicionPago.DESCRIPCION));
    condicionpago.setComportamiento(db.getString(DBCondicionPago.COMPORTAMIENTO));
    condicionpago.setCondicion_vta(CondicionVenta.findByOidProxy(db.getInteger(DBCondicionPago.OID_COND_VTA),getSesion()));
    condicionpago.setPorc_desc(db.getPorcentaje(DBCondicionPago.PORC_DTO));
    condicionpago.setPorc_reca(db.getPorcentaje(DBCondicionPago.PORC_RECA));
    condicionpago.setTarjeta_credito(TarjetaCredito.findByOidProxy(db.getInteger(DBCondicionPago.OID_TAR_CREDITO),getSesion()));
    condicionpago.setGrupo_cond_pago(GrupoCondPago.findByOidProxy(db.getInteger(DBCondicionPago.OID_GRUPO_CP),getSesion()));
    condicionpago.setActivo(db.getBoolean(DBCondicionPago.ACTIVO));
    condicionpago.setUsarEnVtas(db.getBoolean(DBCondicionPago.USAR_EN_VTAS).booleanValue());
  }
}
