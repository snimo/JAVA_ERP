package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.da.DBConceptoLiqTarjeta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoLiqTarjeta extends FactoryObjetoLogico { 

  public FactoryConceptoLiqTarjeta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoLiqTarjeta conceptoliqtarjeta = (ConceptoLiqTarjeta) objLog;
    conceptoliqtarjeta.setOID(db.getInteger(DBConceptoLiqTarjeta.OID_CONC_LIQ_TC));
    conceptoliqtarjeta.setCodigo(db.getString(DBConceptoLiqTarjeta.CODIGO));
    conceptoliqtarjeta.setDescripcion(db.getString(DBConceptoLiqTarjeta.DESCRIPCION));
    conceptoliqtarjeta.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBConceptoLiqTarjeta.OID_ANA_CON),getSesion()));
    conceptoliqtarjeta.setComportamiento(db.getString(DBConceptoLiqTarjeta.COMPORTAMIENTO));
    conceptoliqtarjeta.setActivo(db.getBoolean(DBConceptoLiqTarjeta.ACTIVO));
    conceptoliqtarjeta.setTipoValor(TipoValor.findByOidProxy(db.getInteger(DBConceptoLiqTarjeta.OID_TIPO_VALOR),getSesion()));
  }
}
