package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.da.DBComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComponente extends FactoryObjetoLogico {

  public FactoryComponente() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Componente componente = (Componente) objLog;
    componente.setOID(db.getInteger(DBComponente.OID_COMPO));
    componente.setCodigo(db.getString(DBComponente.CODIGO));
    componente.setDescripcion(db.getString(DBComponente.DESCRIPCION));
    componente.setTipo(db.getString(DBComponente.TIPO));
    componente.setActivo(db.getBoolean(DBComponente.ACTIVO));
    componente.setNroClasificador(db.getInteger(DBComponente.NRO_CLASIFICADOR));
    componente.setNombreNickName(db.getString(DBComponente.NOMBRE_NICKNAME));
    componente.setLongitud(db.getInteger(DBComponente.LONGITUD));
    componente.setPrecision(db.getInteger(DBComponente.PRECISION));
  }
}
