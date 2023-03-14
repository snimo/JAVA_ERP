package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.CargoLegajoExcluido;
import com.srn.erp.excluidos.da.DBCargoLegajoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCargoLegajoExcluido extends FactoryObjetoLogico { 

  public FactoryCargoLegajoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CargoLegajoExcluido cargolegajoexcluido = (CargoLegajoExcluido) objLog;
    cargolegajoexcluido.setOID(db.getInteger(DBCargoLegajoExcluido.OID_CARGO));
    cargolegajoexcluido.setCodigo(db.getString(DBCargoLegajoExcluido.CODIGO));
    cargolegajoexcluido.setDescripcion(db.getString(DBCargoLegajoExcluido.DESCRIPCION));
    cargolegajoexcluido.setActivo(db.getBoolean(DBCargoLegajoExcluido.ACTIVO));

  }
}
