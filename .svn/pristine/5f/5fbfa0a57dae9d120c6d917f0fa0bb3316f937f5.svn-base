package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.DefinicionAtributoEntidad;
import com.srn.erp.general.da.DBDefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDefinicionAtributoEntidad extends FactoryObjetoLogico { 

  public FactoryDefinicionAtributoEntidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DefinicionAtributoEntidad definicionatributoentidad = (DefinicionAtributoEntidad) objLog;
    definicionatributoentidad.setOID(db.getInteger(DBDefinicionAtributoEntidad.OID_ATRI_ENT));
    definicionatributoentidad.setEntidad(db.getString(DBDefinicionAtributoEntidad.ENTIDAD));
    definicionatributoentidad.setNombre_logico(db.getString(DBDefinicionAtributoEntidad.NOMBRE_LOGICO));
    definicionatributoentidad.setSignature(db.getString(DBDefinicionAtributoEntidad.SIGNATURE));
    definicionatributoentidad.setActivo(db.getBoolean(DBDefinicionAtributoEntidad.ACTIVO));
    definicionatributoentidad.setNombreNickName(db.getString(DBDefinicionAtributoEntidad.NOMBRE_NICKNAME));
  }
  
}
