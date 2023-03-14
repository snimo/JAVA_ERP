package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.FactConvProdGral;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBFactConvProdGral;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFactConvProdGral extends FactoryObjetoLogico { 

  public FactoryFactConvProdGral() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	  
    FactConvProdGral factconvprodgral = (FactConvProdGral) objLog;
    factconvprodgral.setOID(db.getInteger(DBFactConvProdGral.OID_EQUIV_PG));
    factconvprodgral.setValClasifEnt(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBFactConvProdGral.OID_VAL_CLASIF_ENT),getSesion()));
    factconvprodgral.setUnidad_origen(UnidadMedida.findByOidProxy(db.getInteger(DBFactConvProdGral.OID_UM_ORI),getSesion()));
    factconvprodgral.setUnidad_destino(UnidadMedida.findByOidProxy(db.getInteger(DBFactConvProdGral.OID_UM_DEST),getSesion()));
    factconvprodgral.setFact_conv(db.getMoney(DBFactConvProdGral.FACT_CONV));

  }
}
