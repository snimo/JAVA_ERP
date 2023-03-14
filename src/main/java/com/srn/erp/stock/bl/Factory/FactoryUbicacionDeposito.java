package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.da.DBUbicacionDeposito;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUbicacionDeposito extends FactoryObjetoLogico {

  public FactoryUbicacionDeposito() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UbicacionDeposito ubicaciondeposito = (UbicacionDeposito) objLog;
    ubicaciondeposito.setOID(db.getInteger(DBUbicacionDeposito.OID_UBI_DEPO));
    ubicaciondeposito.setCodigo(db.getString(DBUbicacionDeposito.CODIGO));
    ubicaciondeposito.setOid(db.getInteger(DBUbicacionDeposito.OID));
    ubicaciondeposito.setDescripcion(db.getString(DBUbicacionDeposito.DESCRIPCION));
    ubicaciondeposito.setDeposito(Deposito.findByOidProxy(db.getInteger(DBUbicacionDeposito.OID_DEPOSITO),getSesion()));
    ubicaciondeposito.setOid_padre(db.getInteger(DBUbicacionDeposito.OID_PADRE));
    ubicaciondeposito.setSolo_sku_habi(db.getBoolean(DBUbicacionDeposito.SOLO_SKU_HABI));
    ubicaciondeposito.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBUbicacionDeposito.OID_SUJETO),getSesion()));
    ubicaciondeposito.setTransporte(Transporte.findByOidProxy(db.getInteger(DBUbicacionDeposito.OID_TRANSPORTE),getSesion()));
    ubicaciondeposito.setDeposito_destino(Deposito.findByOidProxy(db.getInteger(DBUbicacionDeposito.OID_DEPO_DEST),getSesion()));
    ubicaciondeposito.setAllow_almacenar(db.getBoolean(DBUbicacionDeposito.ALLOW_ALMACENAR));
    ubicaciondeposito.setTipo(db.getString(DBUbicacionDeposito.TIPO));
    ubicaciondeposito.setSecu(db.getInteger(DBUbicacionDeposito.SECU));
    ubicaciondeposito.setActivo(db.getBoolean(DBUbicacionDeposito.ACTIVO));
    ubicaciondeposito.setEsUbicacionPorDefecto(db.getBoolean(DBUbicacionDeposito.UBI_DEFAULT));
  }
}
