package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioDevVtas;
import com.srn.erp.ventas.bm.ConfigTalonarioDevVtas;
import com.srn.erp.ventas.bm.OperHabiTalonarioDevVtas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigTalonarioDevVtas extends Operation {

  public SaveConfigTalonarioDevVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfigTalonarioDevClie");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConfigTalonarioDevVtas configtalonario = ConfigTalonarioDevVtas.findByOid(dataset.getInteger("oid_conf_tal_dev"),getSesion());
        configtalonario.setOID(dataset.getInteger("oid_conf_tal_dev"));
        configtalonario.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        setRefreshObjNeg(dataset.getInteger("oid_talonario"));
        configtalonario.setActivo(dataset.getBoolean("activo"));

        IDataSet dsOperHabilitadas = dataset.getDataSet("TOperHabilitadas");
        dsOperHabilitadas.first();
        while (!dsOperHabilitadas.EOF()) {
          OperHabiTalonarioDevVtas operHabiTal =
        	  OperHabiTalonarioDevVtas.findByOid(dsOperHabilitadas.getInteger("oid_oper_tal_dev"),getSesion());
          operHabiTal.setConf_tal_dev(configtalonario);
          operHabiTal.setTipo_devolucion(dsOperHabilitadas.getString("tipo_dev"));
          operHabiTal.setUsar_por_defecto(dsOperHabilitadas.getBoolean("usar_por_defecto"));
          if (dsOperHabilitadas.getBoolean("habilitado").booleanValue()==false) operHabiTal.delete();
          configtalonario.addOperHabilitada(operHabiTal);

          IDataSet dsCompoStock = dsOperHabilitadas.getDataSet("TComportamientosStock");
          dsCompoStock.first();
          while (!dsCompoStock.EOF()) {
            CompoStkTalonarioDevVtas compoStkTalonario =
            	CompoStkTalonarioDevVtas.findByOid(dsCompoStock.getInteger("oid_compo_stk_dev"),getSesion());
            compoStkTalonario.setOper_hab_tal_dev(operHabiTal);
            compoStkTalonario.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(dsCompoStock.getInteger("oid_tipo_conf_mov"),getSesion()));
            compoStkTalonario.setUsar_por_defecto(dsCompoStock.getBoolean("usar_por_defecto"));
            if (dsCompoStock.getBoolean("habilitado").booleanValue()==false) compoStkTalonario.delete();
            operHabiTal.addCompoStockTalonario(compoStkTalonario);
            dsCompoStock.next();
          }
          dsOperHabilitadas.next();
        }

        addTransaccion(configtalonario);
        dataset.next();
    }
  }

}
