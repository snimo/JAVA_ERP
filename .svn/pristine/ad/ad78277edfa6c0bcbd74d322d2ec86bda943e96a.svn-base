package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.cip.da.DBPersonalSeguridad;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPersonalSeguridad extends FactoryObjetoLogico { 

  public FactoryPersonalSeguridad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PersonalSeguridad personalseguridad = (PersonalSeguridad) objLog;
    personalseguridad.setOID(db.getInteger(DBPersonalSeguridad.OID_PERS_SECU));
    personalseguridad.setCodigo(db.getString(DBPersonalSeguridad.CODIGO));
    personalseguridad.setActivo(db.getBoolean(DBPersonalSeguridad.ACTIVO));
    personalseguridad.setApellido(db.getString(DBPersonalSeguridad.APELLIDO));
    personalseguridad.setNombre(db.getString(DBPersonalSeguridad.NOMBRE));
    personalseguridad.setTipo_documento(TipoDocumento.findByOidProxy(db.getInteger(DBPersonalSeguridad.OID_TIPO_DOCU),getSesion()));
    personalseguridad.setCacheo_seg(db.getBoolean(DBPersonalSeguridad.CACHEO_SEG));
    personalseguridad.setNro_docu(db.getString(DBPersonalSeguridad.NRO_DOCU));

  }
}
