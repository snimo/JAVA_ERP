package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValorCompoOriginal;
import com.srn.erp.contabilidad.da.DBFaseValorCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFaseValorCompoOriginal extends FactoryObjetoLogico { 

  public FactoryFaseValorCompoOriginal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FaseValorCompoOriginal fasevalorcompooriginal = (FaseValorCompoOriginal) objLog;
    fasevalorcompooriginal.setOID(db.getInteger(DBFaseValorCompoOriginal.OID_FASE_VALOR_COMPO));
    fasevalorcompooriginal.setFase(FaseSubReparto.findByOidProxy(db.getInteger(DBFaseValorCompoOriginal.OID_FASE),getSesion()));
    fasevalorcompooriginal.setComponente(Componente.findByOidProxy(db.getInteger(DBFaseValorCompoOriginal.OID_COMPO),getSesion()));
    IObjetoLogico objetoLogico =
    	fasevalorcompooriginal.getComponente().getValorCompo(db.getInteger(DBFaseValorCompoOriginal.OID_VAL_COMPO));
    fasevalorcompooriginal.setValor_componente(objetoLogico);
    fasevalorcompooriginal.setActivo(db.getBoolean(DBFaseValorCompoOriginal.ACTIVO));
  }
}
