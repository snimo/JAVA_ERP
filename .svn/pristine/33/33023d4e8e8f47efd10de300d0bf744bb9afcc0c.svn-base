package com.srn.erp.costos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.costos.bm.CentroCostos;
import com.srn.erp.costos.da.DBCentroCostos;
import com.srn.erp.ventas.da.DBSujeto;

public class FactoryCentroCostos extends FactoryObjetoLogico { 

  public FactoryCentroCostos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CentroCostos centrocostos = (CentroCostos) objLog;
    centrocostos.setOID(db.getInteger(DBCentroCostos.OID_CENTRO));
    centrocostos.setCodigo(db.getString(DBCentroCostos.CODIGO));
    centrocostos.setDescripcion(db.getString(DBCentroCostos.DESCRIPCION));
    centrocostos.setActivo(db.getBoolean(DBCentroCostos.ACTIVO));
    
    centrocostos.addOidValorClasif(new Integer(1),db.getInteger(DBSujeto.OID_CLASIF_01));
    centrocostos.addOidValorClasif(new Integer(2),db.getInteger(DBSujeto.OID_CLASIF_02));
    centrocostos.addOidValorClasif(new Integer(3),db.getInteger(DBSujeto.OID_CLASIF_03));
    centrocostos.addOidValorClasif(new Integer(4),db.getInteger(DBSujeto.OID_CLASIF_04));
    centrocostos.addOidValorClasif(new Integer(5),db.getInteger(DBSujeto.OID_CLASIF_05));
    centrocostos.addOidValorClasif(new Integer(6),db.getInteger(DBSujeto.OID_CLASIF_06));
    centrocostos.addOidValorClasif(new Integer(7),db.getInteger(DBSujeto.OID_CLASIF_07));
    centrocostos.addOidValorClasif(new Integer(8),db.getInteger(DBSujeto.OID_CLASIF_08));
    centrocostos.addOidValorClasif(new Integer(9),db.getInteger(DBSujeto.OID_CLASIF_09));
    centrocostos.addOidValorClasif(new Integer(10),db.getInteger(DBSujeto.OID_CLASIF_10));
    centrocostos.addOidValorClasif(new Integer(11),db.getInteger(DBSujeto.OID_CLASIF_11));
    centrocostos.addOidValorClasif(new Integer(12),db.getInteger(DBSujeto.OID_CLASIF_12));
    centrocostos.addOidValorClasif(new Integer(13),db.getInteger(DBSujeto.OID_CLASIF_13));
    centrocostos.addOidValorClasif(new Integer(14),db.getInteger(DBSujeto.OID_CLASIF_14));
    centrocostos.addOidValorClasif(new Integer(15),db.getInteger(DBSujeto.OID_CLASIF_15));
    centrocostos.addOidValorClasif(new Integer(16),db.getInteger(DBSujeto.OID_CLASIF_16));
    centrocostos.addOidValorClasif(new Integer(17),db.getInteger(DBSujeto.OID_CLASIF_17));
    centrocostos.addOidValorClasif(new Integer(18),db.getInteger(DBSujeto.OID_CLASIF_18));
    centrocostos.addOidValorClasif(new Integer(19),db.getInteger(DBSujeto.OID_CLASIF_19));
    centrocostos.addOidValorClasif(new Integer(20),db.getInteger(DBSujeto.OID_CLASIF_20));
    

  }
}
