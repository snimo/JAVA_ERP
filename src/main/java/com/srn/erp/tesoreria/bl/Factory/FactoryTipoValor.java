package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.da.DBTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoValor extends FactoryObjetoLogico {

  public FactoryTipoValor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoValor tipovalor = (TipoValor) objLog;
    tipovalor.setOID(db.getInteger(DBTipoValor.OID_TIPO_VALOR));
    tipovalor.setCodigo(db.getString(DBTipoValor.CODIGO));
    tipovalor.setDescripcion(db.getString(DBTipoValor.DESCRIPCION));
    tipovalor.setCompo(db.getString(DBTipoValor.COMPO));
    tipovalor.setMoneda(Moneda.findByOidProxy(db.getInteger(DBTipoValor.OID_MONEDA),getSesion()));
    tipovalor.setCuentaImputable(CuentaImputable.findByOidProxy(db.getInteger(DBTipoValor.OID_AI),getSesion()));
    tipovalor.setActivo(db.getBoolean(DBTipoValor.ACTIVO));
    tipovalor.setSeguimientoCaja(db.getBoolean(DBTipoValor.SEGUI_CAJA));
    tipovalor.setDepositable(db.getBoolean(DBTipoValor.DEPOSITABLE));
    tipovalor.setDiscValBolDep(db.getBoolean(DBTipoValor.DISC_VAL_BOL_DEP));
    tipovalor.setUsarTipoValorEnOP(db.getBoolean(DBTipoValor.USAR_OP_TOMAR_CAJA));
    tipovalor.setEsDeudaFinanciera(db.getBoolean(DBTipoValor.ES_DEUDA_FINAN));
    tipovalor.setEsDeudaFinancieraProveedor(db.getBoolean(DBTipoValor.ES_DEUDA_FINAN_PROVEEDOR));
    tipovalor.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBTipoValor.OID_ANA_CON),getSesion()));
    tipovalor.setCajaFija(Caja.findByOidProxy(db.getInteger(DBTipoValor.OID_CAJA_FIJA),getSesion()));
  }
}
