package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.AtributoDiccionario;
import com.srn.erp.presupuesto.bm.DiccionarioPlanificacion;
import com.srn.erp.presupuesto.da.DBDiccionarioPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDiccionarioPlanificacion extends FactoryObjetoLogico { 

  public FactoryDiccionarioPlanificacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DiccionarioPlanificacion diccionarioplanificacion = (DiccionarioPlanificacion) objLog;
    diccionarioplanificacion.setOID(db.getInteger(DBDiccionarioPlanificacion.OID_DICCIONARIO));
    diccionarioplanificacion.setNro_relacion(db.getInteger(DBDiccionarioPlanificacion.NRO_RELACION));
    diccionarioplanificacion.setNro_relacion_padre(db.getInteger(DBDiccionarioPlanificacion.NRO_RELACION_PADRE));
    diccionarioplanificacion.setTipo_item(db.getString(DBDiccionarioPlanificacion.TIPO_ITEM));
    diccionarioplanificacion.setTitulo(db.getString(DBDiccionarioPlanificacion.TITULO));
    diccionarioplanificacion.setAtributo_diccionario(AtributoDiccionario.findByOidProxy(db.getInteger(DBDiccionarioPlanificacion.OID_ATRI_DICC),getSesion()));
    diccionarioplanificacion.setOrden(db.getInteger(DBDiccionarioPlanificacion.ORDEN));
    diccionarioplanificacion.setActivo(db.getBoolean(DBDiccionarioPlanificacion.ACTIVO));

  }
}
