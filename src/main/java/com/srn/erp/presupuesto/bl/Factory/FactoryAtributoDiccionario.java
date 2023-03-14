package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.AtributoDiccionario;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.da.DBAtributoDiccionario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtributoDiccionario extends FactoryObjetoLogico { 

  public FactoryAtributoDiccionario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AtributoDiccionario atributodiccionario = (AtributoDiccionario) objLog;
    atributodiccionario.setOID(db.getInteger(DBAtributoDiccionario.OID_ATRI_DICC));
    atributodiccionario.setCodigo(db.getString(DBAtributoDiccionario.CODIGO));
    atributodiccionario.setDescripcion(db.getString(DBAtributoDiccionario.DESCRIPCION));
    atributodiccionario.setDesc_adic(db.getString(DBAtributoDiccionario.DESC_ADIC));
    atributodiccionario.setTipo_atributo(db.getString(DBAtributoDiccionario.TIPO_ATRIBUTO));
    atributodiccionario.setCampo_fecha(db.getDate(DBAtributoDiccionario.CAMPO_FECHA));
    atributodiccionario.setCampo_integer(db.getInteger(DBAtributoDiccionario.CAMPO_INTEGER));
    atributodiccionario.setCampo_decimal(db.getDouble(DBAtributoDiccionario.CAMPO_DECIMAL));
    atributodiccionario.setCampo_string(db.getString(DBAtributoDiccionario.CAMPO_STRING));
    atributodiccionario.setCampo_boolean(db.getBoolean(DBAtributoDiccionario.CAMPO_BOOLEAN));
    atributodiccionario.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBAtributoDiccionario.OID_COMPO_PRESU),getSesion()));
    atributodiccionario.setActivo(db.getBoolean(DBAtributoDiccionario.ACTIVO));
    atributodiccionario.setValorCompoPresu(ValorCompoPresu.findByOidProxy(db.getInteger(DBAtributoDiccionario.OID_VALOR_COMPO_PRESU),getSesion()));

  }
}
