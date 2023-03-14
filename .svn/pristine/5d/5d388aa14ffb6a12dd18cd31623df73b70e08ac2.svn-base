package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBProyecto;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProyecto extends FactoryObjetoLogico { 

  public FactoryProyecto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Proyecto proyecto = (Proyecto) objLog;
    proyecto.setOID(db.getInteger(DBProyecto.OID_PROYECTO));
    proyecto.setCodigo(db.getString(DBProyecto.CODIGO));
    proyecto.setDescripcion(db.getString(DBProyecto.DESCRIPCION));
    proyecto.setCerrado(db.getBoolean(DBProyecto.CERRADO));
    proyecto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBProyecto.OID_SUJETO),getSesion()));
    proyecto.setActivo(db.getBoolean(DBProyecto.ACTIVO));
    
    proyecto.addOidValorClasif(new Integer(1),db.getInteger(DBSujeto.OID_CLASIF_01));
    proyecto.addOidValorClasif(new Integer(2),db.getInteger(DBSujeto.OID_CLASIF_02));
    proyecto.addOidValorClasif(new Integer(3),db.getInteger(DBSujeto.OID_CLASIF_03));
    proyecto.addOidValorClasif(new Integer(4),db.getInteger(DBSujeto.OID_CLASIF_04));
    proyecto.addOidValorClasif(new Integer(5),db.getInteger(DBSujeto.OID_CLASIF_05));
    proyecto.addOidValorClasif(new Integer(6),db.getInteger(DBSujeto.OID_CLASIF_06));
    proyecto.addOidValorClasif(new Integer(7),db.getInteger(DBSujeto.OID_CLASIF_07));
    proyecto.addOidValorClasif(new Integer(8),db.getInteger(DBSujeto.OID_CLASIF_08));
    proyecto.addOidValorClasif(new Integer(9),db.getInteger(DBSujeto.OID_CLASIF_09));
    proyecto.addOidValorClasif(new Integer(10),db.getInteger(DBSujeto.OID_CLASIF_10));
    proyecto.addOidValorClasif(new Integer(11),db.getInteger(DBSujeto.OID_CLASIF_11));
    proyecto.addOidValorClasif(new Integer(12),db.getInteger(DBSujeto.OID_CLASIF_12));
    proyecto.addOidValorClasif(new Integer(13),db.getInteger(DBSujeto.OID_CLASIF_13));
    proyecto.addOidValorClasif(new Integer(14),db.getInteger(DBSujeto.OID_CLASIF_14));
    proyecto.addOidValorClasif(new Integer(15),db.getInteger(DBSujeto.OID_CLASIF_15));
    proyecto.addOidValorClasif(new Integer(16),db.getInteger(DBSujeto.OID_CLASIF_16));
    proyecto.addOidValorClasif(new Integer(17),db.getInteger(DBSujeto.OID_CLASIF_17));
    proyecto.addOidValorClasif(new Integer(18),db.getInteger(DBSujeto.OID_CLASIF_18));
    proyecto.addOidValorClasif(new Integer(19),db.getInteger(DBSujeto.OID_CLASIF_19));
    proyecto.addOidValorClasif(new Integer(20),db.getInteger(DBSujeto.OID_CLASIF_20));
    

  }
}
