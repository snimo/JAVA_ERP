package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.OtrasDireccionesProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.da.DBOtrasDireccionesProveedor;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOtrasDireccionesProveedor extends FactoryObjetoLogico { 

  public FactoryOtrasDireccionesProveedor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OtrasDireccionesProveedor otrasdireccionesproveedor = (OtrasDireccionesProveedor) objLog;
    otrasdireccionesproveedor.setOID(db.getInteger(DBOtrasDireccionesProveedor.OID_DIRECCION));
    otrasdireccionesproveedor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBOtrasDireccionesProveedor.OID_PROVEEDOR),getSesion()));
    otrasdireccionesproveedor.setCodigo(db.getString(DBOtrasDireccionesProveedor.CODIGO));
    otrasdireccionesproveedor.setCalle_y_nro(db.getString(DBOtrasDireccionesProveedor.CALLE_Y_NRO));
    otrasdireccionesproveedor.setLocalidad(db.getString(DBOtrasDireccionesProveedor.LOCALIDAD));
    otrasdireccionesproveedor.setCodigo_postal(db.getString(DBOtrasDireccionesProveedor.CODIGO_POSTAL));
    otrasdireccionesproveedor.setTipo_unidad(TipoUnidadEdilicia.findByOidProxy(db.getInteger(DBOtrasDireccionesProveedor.OID_TIPO_UNIDAD),getSesion()));
    otrasdireccionesproveedor.setTelefonos(db.getString(DBOtrasDireccionesProveedor.TELEFONOS));
    otrasdireccionesproveedor.setProvincia(Provincia.findByOidProxy(db.getInteger(DBOtrasDireccionesProveedor.OID_PROVINCIA),getSesion()));
    otrasdireccionesproveedor.setContacto(db.getString(DBOtrasDireccionesProveedor.CONTACTO));
    otrasdireccionesproveedor.setPais(Pais.findByOidProxy(db.getInteger(DBOtrasDireccionesProveedor.OID_PAIS),getSesion()));
    otrasdireccionesproveedor.setActivo(db.getBoolean(DBOtrasDireccionesProveedor.ACTIVO));
    otrasdireccionesproveedor.setDom_dev_mercaderia(db.getBoolean(DBOtrasDireccionesProveedor.DOM_DEV_MERCADERIA));

  }
}
