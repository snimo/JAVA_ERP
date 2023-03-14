package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValCompoDest;
import com.srn.erp.contabilidad.da.DBFaseValCompoDest;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFaseValCompoDest extends FactoryObjetoLogico { 

  public FactoryFaseValCompoDest() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FaseValCompoDest fasevalcompodest = (FaseValCompoDest) objLog;
    fasevalcompodest.setOID(db.getInteger(DBFaseValCompoDest.OID_FASE_VALOR_COMPO));
    fasevalcompodest.setFase(FaseSubReparto.findByOidProxy(db.getInteger(DBFaseValCompoDest.OID_FASE),getSesion()));
    Componente compoDest = fasevalcompodest.getFase().getCompo_destino();
    if (compoDest!=null)
    	fasevalcompodest.setValor_compo(compoDest.getValorCompo(db.getInteger(DBFaseValCompoDest.OID_VAL_COMPO)));
    fasevalcompodest.setDriver(DriverSubreparto.findByOidProxy(db.getInteger(DBFaseValCompoDest.OID_DRIVER),getSesion()));
    fasevalcompodest.setActivo(db.getBoolean(DBFaseValCompoDest.ACTIVO));
  }
}
