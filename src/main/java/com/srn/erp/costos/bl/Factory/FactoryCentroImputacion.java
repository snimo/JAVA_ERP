package com.srn.erp.costos.bl.Factory;

import com.srn.erp.costos.bm.CentroImputacion;
import com.srn.erp.costos.da.DBCentroCostos;
import com.srn.erp.costos.da.DBCentroImputacion;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCentroImputacion extends FactoryObjetoLogico { 

  public FactoryCentroImputacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CentroImputacion centroImputacion = (CentroImputacion) objLog;
    centroImputacion.setOID(db.getInteger(DBCentroImputacion.OID_CENTRO));
    centroImputacion.setCodigo(db.getString(DBCentroImputacion.CODIGO));
    centroImputacion.setDescripcion(db.getString(DBCentroImputacion.DESCRIPCION));
    centroImputacion.setActivo(db.getBoolean(DBCentroImputacion.ACTIVO));
    
    centroImputacion.addOidValorClasif(new Integer(1),db.getInteger(DBSujeto.OID_CLASIF_01));
    centroImputacion.addOidValorClasif(new Integer(2),db.getInteger(DBSujeto.OID_CLASIF_02));
    centroImputacion.addOidValorClasif(new Integer(3),db.getInteger(DBSujeto.OID_CLASIF_03));
    centroImputacion.addOidValorClasif(new Integer(4),db.getInteger(DBSujeto.OID_CLASIF_04));
    centroImputacion.addOidValorClasif(new Integer(5),db.getInteger(DBSujeto.OID_CLASIF_05));
    centroImputacion.addOidValorClasif(new Integer(6),db.getInteger(DBSujeto.OID_CLASIF_06));
    centroImputacion.addOidValorClasif(new Integer(7),db.getInteger(DBSujeto.OID_CLASIF_07));
    centroImputacion.addOidValorClasif(new Integer(8),db.getInteger(DBSujeto.OID_CLASIF_08));
    centroImputacion.addOidValorClasif(new Integer(9),db.getInteger(DBSujeto.OID_CLASIF_09));
    centroImputacion.addOidValorClasif(new Integer(10),db.getInteger(DBSujeto.OID_CLASIF_10));
    centroImputacion.addOidValorClasif(new Integer(11),db.getInteger(DBSujeto.OID_CLASIF_11));
    centroImputacion.addOidValorClasif(new Integer(12),db.getInteger(DBSujeto.OID_CLASIF_12));
    centroImputacion.addOidValorClasif(new Integer(13),db.getInteger(DBSujeto.OID_CLASIF_13));
    centroImputacion.addOidValorClasif(new Integer(14),db.getInteger(DBSujeto.OID_CLASIF_14));
    centroImputacion.addOidValorClasif(new Integer(15),db.getInteger(DBSujeto.OID_CLASIF_15));
    centroImputacion.addOidValorClasif(new Integer(16),db.getInteger(DBSujeto.OID_CLASIF_16));
    centroImputacion.addOidValorClasif(new Integer(17),db.getInteger(DBSujeto.OID_CLASIF_17));
    centroImputacion.addOidValorClasif(new Integer(18),db.getInteger(DBSujeto.OID_CLASIF_18));
    centroImputacion.addOidValorClasif(new Integer(19),db.getInteger(DBSujeto.OID_CLASIF_19));
    centroImputacion.addOidValorClasif(new Integer(20),db.getInteger(DBSujeto.OID_CLASIF_20));
    

  }
}
