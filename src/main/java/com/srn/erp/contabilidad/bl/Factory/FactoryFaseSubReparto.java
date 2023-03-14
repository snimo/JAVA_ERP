package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.da.DBFaseSubReparto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFaseSubReparto extends FactoryObjetoLogico { 

  public FactoryFaseSubReparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FaseSubReparto fasesubreparto = (FaseSubReparto) objLog;
    fasesubreparto.setOID(db.getInteger(DBFaseSubReparto.OID_FASE));
    fasesubreparto.setCodigo(db.getString(DBFaseSubReparto.CODIGO));
    fasesubreparto.setDescripcion(db.getString(DBFaseSubReparto.DESCRIPCION));
    fasesubreparto.setCompo_destino(Componente.findByOidProxy(db.getInteger(DBFaseSubReparto.OID_COMPO_DESTINO),getSesion()));
    fasesubreparto.setActivo(db.getBoolean(DBFaseSubReparto.ACTIVO));

  }
}
