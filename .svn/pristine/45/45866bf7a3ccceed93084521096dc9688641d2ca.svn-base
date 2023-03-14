package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.SectorLegajoExcluido;
import com.srn.erp.excluidos.da.DBSectorLegajoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySectorLegajoExcluido extends FactoryObjetoLogico { 

  public FactorySectorLegajoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SectorLegajoExcluido sectorlegajoexcluido = (SectorLegajoExcluido) objLog;
    sectorlegajoexcluido.setOID(db.getInteger(DBSectorLegajoExcluido.OID_SECTOR));
    sectorlegajoexcluido.setCodigo(db.getString(DBSectorLegajoExcluido.CODIGO));
    sectorlegajoexcluido.setDescripcion(db.getString(DBSectorLegajoExcluido.DESCRIPCION));
    sectorlegajoexcluido.setActivo(db.getBoolean(DBSectorLegajoExcluido.ACTIVO));

  }
}
