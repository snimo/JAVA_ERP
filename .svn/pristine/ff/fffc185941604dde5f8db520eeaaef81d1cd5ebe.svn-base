package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.GenerarValorCompoCriImpu;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;
import com.srn.erp.contabilidad.da.DBGenerarValorCompoCriImpu;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGenerarValorCompoCriImpu extends FactoryObjetoLogico { 

  public FactoryGenerarValorCompoCriImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GenerarValorCompoCriImpu generarvalorcompocriimpu = (GenerarValorCompoCriImpu) objLog;
    generarvalorcompocriimpu.setOID(db.getInteger(DBGenerarValorCompoCriImpu.OID_GEN_VAL_COMPO));
    generarvalorcompocriimpu.setValoresatricriterioimputacion(ValoresAtriCriterioImpu.findByOidProxy(db.getInteger(DBGenerarValorCompoCriImpu.OID_VAL_ATRI_ENT),getSesion()));
    generarvalorcompocriimpu.setAtributo_entidad(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBGenerarValorCompoCriImpu.OID_ATRI_ENT),getSesion()));
    generarvalorcompocriimpu.setComponente(Componente.findByOidProxy(db.getInteger(DBGenerarValorCompoCriImpu.OID_COMPO),getSesion()));
  }
}
