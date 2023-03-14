package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorEscenario;
import com.srn.erp.presupuesto.da.DBValorEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorEscenario extends FactoryObjetoLogico { 

  public FactoryValorEscenario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorEscenario valorEscenario = (ValorEscenario) objLog;
    valorEscenario.setOID(db.getInteger(DBValorEscenario.OID_VAL_ESCENARIO));
    valorEscenario.setEscenario(Escenario.findByOidProxy(db.getInteger(DBValorEscenario.OID_ESCENARIO),getSesion()));
    valorEscenario.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBValorEscenario.OID_COMPO_PRESU),getSesion()));
    valorEscenario.setValor_compo(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorEscenario.OID_VALOR_COMPO),getSesion()));
    valorEscenario.setNro_relacion(db.getString(DBValorEscenario.NRO_RELACION));
    valorEscenario.setNro_relacion_padre(db.getString(DBValorEscenario.NRO_RELACION_PADRE));
    valorEscenario.setActivo(db.getBoolean(DBValorEscenario.ACTIVO));
    valorEscenario.setUltimoNivel(db.getBoolean(DBValorEscenario.ULTIMO_NIVEL));
    valorEscenario.setDescripcion(db.getString(DBValorEscenario.DESCRIPCION));
  }
}
