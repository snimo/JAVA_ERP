package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.CostoProductoGral;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBCostoProductoGral;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCostoProductoGral extends FactoryObjetoLogico { 

  public FactoryCostoProductoGral() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CostoProductoGral costoproductogral = (CostoProductoGral) objLog;
    costoproductogral.setOID(db.getInteger(DBCostoProductoGral.OID_COSTO_PRODGRAL));
    costoproductogral.setVal_clasif_ent(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBCostoProductoGral.OID_VAL_CLASIF_ENT),getSesion()));
    costoproductogral.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBCostoProductoGral.OID_CLASIF_ENT),getSesion()));
    costoproductogral.setFec_ult_costo(db.getDate(DBCostoProductoGral.FEC_ULT_COSTO));
    costoproductogral.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCostoProductoGral.OID_MONEDA),getSesion()));
    costoproductogral.setCantidad(db.getMoney(DBCostoProductoGral.CANTIDAD));
    costoproductogral.setUm(UnidadMedida.findByOidProxy(db.getInteger(DBCostoProductoGral.OID_UM),getSesion()));
    costoproductogral.setCosto(db.getMoney(DBCostoProductoGral.COSTO));
    costoproductogral.setActivo(db.getBoolean(DBCostoProductoGral.ACTIVO));

  }
}
