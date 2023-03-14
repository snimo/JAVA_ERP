package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.SectorDireccion;
import com.srn.erp.ventas.da.DBSectorDireccion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySectorDireccion extends FactoryObjetoLogico {

  public FactorySectorDireccion() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SectorDireccion sectordireccion = (SectorDireccion) objLog;
    sectordireccion.setOID(db.getInteger(DBSectorDireccion.OID_SECTOR_DIR));
    sectordireccion.setCodigo(db.getString(DBSectorDireccion.CODIGO));
    sectordireccion.setDescripcion(db.getString(DBSectorDireccion.DESCRIPCION));
    sectordireccion.setActivo(db.getBoolean(DBSectorDireccion.ACTIVO));
  }
}
