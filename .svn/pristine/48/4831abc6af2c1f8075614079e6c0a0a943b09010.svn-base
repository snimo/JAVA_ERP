package com.srn.erp.stock.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigTalonarioAjuStk extends Operation {

  public SaveConfigTalonarioAjuStk() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfigTalonarioAjuStk");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConfigTalonarioAjuStk configtalonarioAjuStk = ConfigTalonarioAjuStk.findByOid(dataset.getInteger("oid_conf_tal_stk"),getSesion());
        configtalonarioAjuStk.setOID(dataset.getInteger("oid_conf_tal_stk"));
        configtalonarioAjuStk.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        setRefreshObjNeg(dataset.getInteger("oid_talonario"));
        configtalonarioAjuStk.setActivo(dataset.getBoolean("activo"));

        IDataSet dsOperHabilitadas = dataset.getDataSet("TOperHabilitadas");
        dsOperHabilitadas.first();
        while (!dsOperHabilitadas.EOF()) {
          OperHabiTalonarioAjuStk operHabiTalAjuStk =
              OperHabiTalonarioAjuStk.findByOid(dsOperHabilitadas.getInteger("oid_oper_aju_stk"),getSesion());
          operHabiTalAjuStk.setConf_tal_aju_stk(configtalonarioAjuStk);
          operHabiTalAjuStk.setTipo_aju_stk(dsOperHabilitadas.getString("tipo_aju_stk"));
          operHabiTalAjuStk.setUsar_por_defecto(dsOperHabilitadas.getBoolean("usar_por_defecto"));
          if (dsOperHabilitadas.getBoolean("habilitado").booleanValue()==false) operHabiTalAjuStk.delete();
          configtalonarioAjuStk.addOperacionHabilitada(operHabiTalAjuStk);

          IDataSet dsCompoStock = dsOperHabilitadas.getDataSet("TComportamientosStock");
          dsCompoStock.first();
          while (!dsCompoStock.EOF()) {
            CompoStkTalonarioAjuStk compoStkTalonarioAjuStk =
                CompoStkTalonarioAjuStk.findByOid(dsCompoStock.getInteger("oid_compo_stk_aju"),getSesion());
            compoStkTalonarioAjuStk.setOper_habi_tal_ajustk(operHabiTalAjuStk);
            compoStkTalonarioAjuStk.setTipo_conf_mov_tal(TipoConfMovStkTalonario.findByOidProxy(dsCompoStock.getInteger("oid_tipo_conf_mov"),getSesion()));
            compoStkTalonarioAjuStk.setUsar_por_defecto(dsCompoStock.getBoolean("usar_por_defecto"));
            if (dsCompoStock.getBoolean("habilitado").booleanValue()==false) compoStkTalonarioAjuStk.delete();
            operHabiTalAjuStk.addCompoStkTalAju(compoStkTalonarioAjuStk);
            dsCompoStock.next();
          }
          dsOperHabilitadas.next();
        }

        addTransaccion(configtalonarioAjuStk);
        dataset.next();
    }
  }

}
