package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ArticuloConceptoFactProv;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.da.DBArticuloConceptoFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryArticuloConceptoFactProv extends FactoryObjetoLogico { 

  public FactoryArticuloConceptoFactProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ArticuloConceptoFactProv articuloconceptofactprov = (ArticuloConceptoFactProv) objLog;
    articuloconceptofactprov.setOID(db.getInteger(DBArticuloConceptoFactProv.OID_ART_CONC_FACT));
    articuloconceptofactprov.setDetalle_infrecdet_ocdet(ComproProvInfRecOC.findByOidProxy(db.getInteger(DBArticuloConceptoFactProv.OID_DET_IR_OC),getSesion()));
    articuloconceptofactprov.setProveedor_det(ComproProveedorDet.findByOidProxy(db.getInteger(DBArticuloConceptoFactProv.OID_CCO_PROV_DET),getSesion()));
    articuloconceptofactprov.setImpo_mon_ori(db.getDouble(DBArticuloConceptoFactProv.IMPO_MON_ORI));
    articuloconceptofactprov.setActivo(db.getBoolean(DBArticuloConceptoFactProv.ACTIVO));

  }
}
