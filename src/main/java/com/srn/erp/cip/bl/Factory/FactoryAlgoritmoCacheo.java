package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.da.DBAlgoritmoCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAlgoritmoCacheo extends FactoryObjetoLogico { 

  public FactoryAlgoritmoCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AlgoritmoCacheo algoritmocacheo = (AlgoritmoCacheo) objLog;
    algoritmocacheo.setOID(db.getInteger(DBAlgoritmoCacheo.OID_ALGO_CACHEO));
    algoritmocacheo.setFiltro_legajo(db.getString(DBAlgoritmoCacheo.FILTRO_LEGAJO));
    algoritmocacheo.setTipo_planif(db.getString(DBAlgoritmoCacheo.TIPO_PLANIF));
    algoritmocacheo.setPorc_ent(db.getDouble(DBAlgoritmoCacheo.PORC_ENT));
    algoritmocacheo.setActivo(db.getBoolean(DBAlgoritmoCacheo.ACTIVO));
    algoritmocacheo.setProb_cach_ent(db.getDouble(DBAlgoritmoCacheo.PROB_CACH_ENT));
    algoritmocacheo.setPorc_sal(db.getDouble(DBAlgoritmoCacheo.PORC_SAL));
    algoritmocacheo.setProb_cach_sal(db.getDouble(DBAlgoritmoCacheo.PROB_CACH_SAL));
    algoritmocacheo.setFiltro_estados(db.getString(DBAlgoritmoCacheo.FILTRO_ESTADOS));
    algoritmocacheo.setCodigo(db.getString(DBAlgoritmoCacheo.CODIGO));
    algoritmocacheo.setDescripcion(db.getString(DBAlgoritmoCacheo.DESCRIPCION));
    algoritmocacheo.setLunes(db.getBoolean(DBAlgoritmoCacheo.LUNES));
    algoritmocacheo.setMartes(db.getBoolean(DBAlgoritmoCacheo.MARTES));
    algoritmocacheo.setMiercoles(db.getBoolean(DBAlgoritmoCacheo.MIERCOLES));
    algoritmocacheo.setJueves(db.getBoolean(DBAlgoritmoCacheo.JUEVES));
    algoritmocacheo.setViernes(db.getBoolean(DBAlgoritmoCacheo.VIERNES));
    algoritmocacheo.setSabado(db.getBoolean(DBAlgoritmoCacheo.SABADO));
    algoritmocacheo.setDomingo(db.getBoolean(DBAlgoritmoCacheo.DOMINGO));
  }
}
