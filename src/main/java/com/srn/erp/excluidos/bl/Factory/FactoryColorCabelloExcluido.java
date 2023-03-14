package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.da.DBColorCabelloExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryColorCabelloExcluido extends FactoryObjetoLogico { 

  public FactoryColorCabelloExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ColorCabelloExcluido colorcabelloexcluido = (ColorCabelloExcluido) objLog;
    colorcabelloexcluido.setOID(db.getInteger(DBColorCabelloExcluido.OID_COLOR));
    colorcabelloexcluido.setCodigo(db.getString(DBColorCabelloExcluido.CODIGO));
    colorcabelloexcluido.setDescripcion(db.getString(DBColorCabelloExcluido.DESCRIPCION));
    colorcabelloexcluido.setActivo(db.getBoolean(DBColorCabelloExcluido.ACTIVO));

  }
}
