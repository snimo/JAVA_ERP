package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigTalonarioFactClie extends Operation {

  public SaveConfigTalonarioFactClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfigTalonarioFactClie");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConfigTalonarioFactClie configtalonarioFactClie = ConfigTalonarioFactClie.findByOid(dataset.getInteger("oid_conf_tal_fact"),getSesion());
        configtalonarioFactClie.setOID(dataset.getInteger("oid_conf_tal_fact"));
        configtalonarioFactClie.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        setRefreshObjNeg(dataset.getInteger("oid_talonario"));
        configtalonarioFactClie.setActivo(dataset.getBoolean("activo"));

        IDataSet dsOperHabilitadas = dataset.getDataSet("TOperHabilitadas");
        dsOperHabilitadas.first();
        while (!dsOperHabilitadas.EOF()) {
          OperHabiTalonarioFactClie operHabiTalFactClie =
              OperHabiTalonarioFactClie.findByOid(dsOperHabilitadas.getInteger("oid_oper_tal_fact"),getSesion());
          operHabiTalFactClie.setConf_tal_fact_clie(configtalonarioFactClie);
          operHabiTalFactClie.setTipo_facturacion(dsOperHabilitadas.getString("tipo_facturacion"));
          operHabiTalFactClie.setUsar_por_defecto(dsOperHabilitadas.getBoolean("usar_por_defecto"));
          if (dsOperHabilitadas.getBoolean("habilitado").booleanValue()==false) operHabiTalFactClie.delete();
          configtalonarioFactClie.addOperacionHabilitada(operHabiTalFactClie);

          IDataSet dsCompoStock = dsOperHabilitadas.getDataSet("TComportamientosStock");
          dsCompoStock.first();
          while (!dsCompoStock.EOF()) {
            CompoStkTalonarioFactClie compoStkTalonarioFactClie =
                CompoStkTalonarioFactClie.findByOid(dsCompoStock.getInteger("oid_compo_stk_fact"),getSesion());
            compoStkTalonarioFactClie.setOper_tal_fact_clie(operHabiTalFactClie);
            compoStkTalonarioFactClie.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(dsCompoStock.getInteger("oid_tipo_conf_mov"),getSesion()));
            compoStkTalonarioFactClie.setUsar_por_defecto(dsCompoStock.getBoolean("usar_por_defecto"));
            if (dsCompoStock.getBoolean("habilitado").booleanValue()==false) compoStkTalonarioFactClie.delete();
            operHabiTalFactClie.addCompoStkTalFactClie(compoStkTalonarioFactClie);
            dsCompoStock.next();
          }
          dsOperHabilitadas.next();
        }

        addTransaccion(configtalonarioFactClie);
        dataset.next();
    }
  }

}
