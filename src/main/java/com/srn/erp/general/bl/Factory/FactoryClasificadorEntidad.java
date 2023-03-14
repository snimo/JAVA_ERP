package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.GrupoClasificadorEntidad;
import com.srn.erp.general.da.DBClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryClasificadorEntidad extends FactoryObjetoLogico {

  public FactoryClasificadorEntidad() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ClasificadorEntidad clasificadorentidad = (ClasificadorEntidad) objLog;
    clasificadorentidad.setOID(db.getInteger(DBClasificadorEntidad.OID_CLASIF_ENT));
    clasificadorentidad.setCodigo(db.getString(DBClasificadorEntidad.CODIGO));
    clasificadorentidad.setDescripcion(db.getString(DBClasificadorEntidad.DESCRIPCION));
    clasificadorentidad.setNickname(db.getString(DBClasificadorEntidad.NICKNAME));
    clasificadorentidad.setObligatorio(db.getBoolean(DBClasificadorEntidad.OBLIGATORIO));
    clasificadorentidad.setValor_default(db.getInteger(DBClasificadorEntidad.OID_VAL_DEFAULT));
    clasificadorentidad.setActivo(db.getBoolean(DBClasificadorEntidad.ACTIVO));
    clasificadorentidad.setNroClasif(db.getInteger(DBClasificadorEntidad.NRO_CLASIF));
    clasificadorentidad.setGrupoClasificadorEntidad(GrupoClasificadorEntidad.findByOidProxy(db.getInteger(DBClasificadorEntidad.OID_GRUPO_CLASIF),getSesion()));
  }
}
