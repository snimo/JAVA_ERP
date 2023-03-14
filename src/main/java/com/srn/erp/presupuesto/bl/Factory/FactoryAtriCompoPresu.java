package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.da.DBAtriCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtriCompoPresu extends FactoryObjetoLogico { 

  public FactoryAtriCompoPresu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AtriCompoPresu atricompopresu = (AtriCompoPresu) objLog;
    atricompopresu.setOID(db.getInteger(DBAtriCompoPresu.OID_ATRI_PRESU));
    atricompopresu.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBAtriCompoPresu.OID_COMPO_PRESU),getSesion()));
    atricompopresu.setTipo_atributo(db.getString(DBAtriCompoPresu.TIPO_ATRIBUTO));
    atricompopresu.setNombre_logico(db.getString(DBAtriCompoPresu.NOMBRE_LOGICO));
    atricompopresu.setNro_orden(db.getInteger(DBAtriCompoPresu.NRO_ORDEN));
    atricompopresu.setCompo_presu_atri(CompoPresupuestario.findByOidProxy(db.getInteger(DBAtriCompoPresu.OID_COMPO_ATRI),getSesion()));
    atricompopresu.setActivo(db.getBoolean(DBAtriCompoPresu.ACTIVO));
    atricompopresu.setObligatorio(db.getBoolean(DBAtriCompoPresu.OBLIGATORIO));
    atricompopresu.setNroInternoAtri(db.getInteger(DBAtriCompoPresu.NRO_INTERNO_ATRI));
    atricompopresu.setFormato(db.getString(DBAtriCompoPresu.FORMATO));
  }
}
