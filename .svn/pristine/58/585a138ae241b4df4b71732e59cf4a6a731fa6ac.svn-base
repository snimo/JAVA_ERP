package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoValor extends Operation {

  public SaveTipoValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTipoValor");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        TipoValor tipovalor = TipoValor.findByOid(dataset.getInteger("oid_tipo_valor"),getSesion());
        tipovalor.setOID(dataset.getInteger("oid_tipo_valor"));
        tipovalor.setCodigo(dataset.getString("codigo"));
        tipovalor.setDescripcion(dataset.getString("descripcion"));
        tipovalor.setCompo(dataset.getString("compo"));
        tipovalor.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        tipovalor.setCuentaImputable(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai"),getSesion()));
        tipovalor.setCuenta(Cuenta.findByOidProxy(dataset.getInteger("oid_ana_con"),getSesion()));
        tipovalor.setSeguimientoCaja(dataset.getBoolean("segui_caja"));
        tipovalor.setActivo(dataset.getBoolean("activo"));
        tipovalor.setDepositable(dataset.getBoolean("depositable"));
        tipovalor.setDiscValBolDep(dataset.getBoolean("disc_val_bol_dep"));
        tipovalor.setUsarTipoValorEnOP(dataset.getBoolean("usar_tv_en_op"));
        tipovalor.setEsDeudaFinanciera(dataset.getBoolean("es_deuda_finan"));
        tipovalor.setEsDeudaFinancieraProveedor(dataset.getBoolean("es_deuda_finan_prov"));
        tipovalor.setCajaFija(Caja.findByOidProxy(dataset.getInteger("oid_caja_fija"),getSesion()));
        addTransaccion(tipovalor);
        dataset.next();
    }
  }

}
