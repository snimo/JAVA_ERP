package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBContactoSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryContactoSujeto extends FactoryObjetoLogico {

  public FactoryContactoSujeto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ContactoSujeto contactosujeto = (ContactoSujeto) objLog;
  contactosujeto.setOID(db.getInteger(DBContactoSujeto.OID_CONTAC_SUJ));
    contactosujeto.setDescripcion(db.getString(DBContactoSujeto.DESCRIPCION));
    contactosujeto.setProvincia(Provincia.findByOidProxy(db.getInteger(DBContactoSujeto.OID_PROVINCIA),getSesion()));
    contactosujeto.setPais(Pais.findByOidProxy(db.getInteger(DBContactoSujeto.OID_PAIS),getSesion()));
    contactosujeto.setApellido(db.getString(DBContactoSujeto.APELLIDO));
    contactosujeto.setNombre(db.getString(DBContactoSujeto.NOMBRE));
    contactosujeto.setTelefonos(db.getString(DBContactoSujeto.TELEFONOS));
    contactosujeto.setFax(db.getString(DBContactoSujeto.FAX));
    contactosujeto.setDireccion(db.getString(DBContactoSujeto.DIRECCION));
    contactosujeto.setLocalidad(db.getString(DBContactoSujeto.LOCALIDAD));
    contactosujeto.setCodigo_postal(db.getString(DBContactoSujeto.CODIGO_POSTAL));
    contactosujeto.setMail(db.getString(DBContactoSujeto.MAIL));
    contactosujeto.setSector(db.getString(DBContactoSujeto.SECTOR));
    contactosujeto.setCargo(db.getString(DBContactoSujeto.CARGO));
    contactosujeto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBContactoSujeto.SUJETO),getSesion()));
    contactosujeto.setActivo(db.getBoolean(DBContactoSujeto.ACTIVO));
    contactosujeto.setPasarACobrar(db.getBoolean(DBContactoSujeto.PASAR_A_COBRAR));
    contactosujeto.setReclamarPago(db.getBoolean(DBContactoSujeto.RECLAMAR_PAGO));
    
  }
}
