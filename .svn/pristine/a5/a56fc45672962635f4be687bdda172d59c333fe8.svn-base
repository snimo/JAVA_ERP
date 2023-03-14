package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.da.DBRecluProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluProceso extends FactoryObjetoLogico { 

  public FactoryRecluProceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluProceso recluproceso = (RecluProceso) objLog;
    recluproceso.setOID(db.getInteger(DBRecluProceso.OID_PROCESO));
    recluproceso.setCodigo(db.getString(DBRecluProceso.CODIGO));
    recluproceso.setDescripcion(db.getString(DBRecluProceso.DESCRIPCION));
    recluproceso.setOrden(db.getInteger(DBRecluProceso.ORDEN));
    recluproceso.setCosto(db.getMoney(DBRecluProceso.COSTO));
    recluproceso.setActivo(db.getBoolean(DBRecluProceso.ACTIVO));
    recluproceso.setAltaSolapaPostulante(db.getBoolean(DBRecluProceso.ALTA_SOLAPA_POSTU));
    recluproceso.setVisuSolapaPostulante(db.getBoolean(DBRecluProceso.VISU_SOLAPA_POSTU));
    recluproceso.setVisuConsRecepcion(db.getBoolean(DBRecluProceso.VISU_CONS_RECEPCION));
    recluproceso.setAltaEnBusqueda(db.getBoolean(DBRecluProceso.ALTA_EN_BUSQUEDA));
  }
}
