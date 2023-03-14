package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.ConfigTalonarioRto;
import com.srn.erp.ventas.bm.OperHabiTalonarioRto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfigTalonarioRto extends Operation {

  public SaveConfigTalonarioRto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfigTalonarioRto");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ConfigTalonarioRto configtalonariorto = ConfigTalonarioRto.findByOid(dataset.getInteger("oid_conf_tal_rto"),getSesion());
        configtalonariorto.setOID(dataset.getInteger("oid_conf_tal_rto"));
        configtalonariorto.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        setRefreshObjNeg(dataset.getInteger("oid_talonario"));
        configtalonariorto.setActivo(dataset.getBoolean("activo"));

        IDataSet dsOperHabilitadas = dataset.getDataSet("TOperHabilitadas");
        dsOperHabilitadas.first();
        while (!dsOperHabilitadas.EOF()) {
          OperHabiTalonarioRto operHabiTalRto =
              OperHabiTalonarioRto.findByOid(dsOperHabilitadas.getInteger("oid_oper_tal_rto"),getSesion());
          operHabiTalRto.setConfig_talonario_rto(configtalonariorto);
          operHabiTalRto.setTipo_rto(dsOperHabilitadas.getString("tipo_rto"));
          operHabiTalRto.setUsarPorDefecto(dsOperHabilitadas.getBoolean("usar_por_defecto"));
          if (dsOperHabilitadas.getBoolean("habilitado").booleanValue()==false) operHabiTalRto.delete();
          configtalonariorto.addOperacionHabilitada(operHabiTalRto);

          IDataSet dsCompoStock = dsOperHabilitadas.getDataSet("TComportamientosStock");
          dsCompoStock.first();
          while (!dsCompoStock.EOF()) {
            CompoStkTalonarioRto compoStkTalonarioRto =
                CompoStkTalonarioRto.findByOid(dsCompoStock.getInteger("oid_compo_stk_rto"),getSesion());
            compoStkTalonarioRto.setOper_tal_rto(operHabiTalRto);
            compoStkTalonarioRto.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(dsCompoStock.getInteger("oid_tipo_conf_mov"),getSesion()));
            compoStkTalonarioRto.setUsarPorDefecto(dsCompoStock.getBoolean("usar_por_defecto"));
            if (dsCompoStock.getBoolean("habilitado").booleanValue()==false) compoStkTalonarioRto.delete();
            operHabiTalRto.addComportamientoStock(compoStkTalonarioRto);
            dsCompoStock.next();
          }
          dsOperHabilitadas.next();
        }

        addTransaccion(configtalonariorto);
        dataset.next();
    }
  }

}
