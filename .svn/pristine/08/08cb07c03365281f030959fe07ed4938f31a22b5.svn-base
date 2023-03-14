package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.ContactoProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.da.DBContactoProveedor;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryContactoProveedor extends FactoryObjetoLogico {

  public FactoryContactoProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ContactoProveedor contactoproveedor = (ContactoProveedor) objLog;
  contactoproveedor.setOID(db.getInteger(DBContactoProveedor.OID_CONTAC_PROV));
    contactoproveedor.setApellido(db.getString(DBContactoProveedor.APELLIDO));
    contactoproveedor.setNombre(db.getString(DBContactoProveedor.NOMBRE));
    contactoproveedor.setTelefonos(db.getString(DBContactoProveedor.TELEFONOS));
    contactoproveedor.setFax(db.getString(DBContactoProveedor.FAX));
    contactoproveedor.setDireccion(db.getString(DBContactoProveedor.DIRECCION));
    contactoproveedor.setLocalidad(db.getString(DBContactoProveedor.LOCALIDAD));
    contactoproveedor.setCodigopostal(db.getString(DBContactoProveedor.CODIGO_POSTAL));
    contactoproveedor.setProvincia(Provincia.findByOidProxy(db.getInteger(DBContactoProveedor.OID_PROVINCIA),getSesion()));
    contactoproveedor.setPais(Pais.findByOidProxy(db.getInteger(DBContactoProveedor.OID_PAIS),getSesion()));
    contactoproveedor.setMail(db.getString(DBContactoProveedor.MAIL));
    contactoproveedor.setEnviooc(db.getBoolean(DBContactoProveedor.ENVIO_OC));
    contactoproveedor.setEnviopedcotiz(db.getBoolean(DBContactoProveedor.ENVIO_PED_COTIZ));
    contactoproveedor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBContactoProveedor.OID_PROVEEDOR),getSesion()));
    contactoproveedor.setSector(db.getString(DBContactoProveedor.SECTOR));
    contactoproveedor.setCargo(db.getString(DBContactoProveedor.CARGO));

  }
}
