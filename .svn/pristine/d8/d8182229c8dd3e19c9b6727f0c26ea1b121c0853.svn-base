package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;
import com.srn.erp.ventas.bm.TipoOperFacturacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigTalonarioFactClie extends Operation {

  public TraerConfigTalonarioFactClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid"),
                                              getSesion());
    ConfigTalonarioFactClie configTalonarioFactClie =
        ConfigTalonarioFactClie.getConfigTalonarioFactClie(talonario,getSesion());

    IDataSet datasetConfigTalonarioFactClie = getDataSetConfigTalonarioFactClie();
    IDataSet datasetOperHabilitadas         = getDataSetOperHabilitadas();
    IDataSet datasetCompoStock              = getDataSetComportamientosStock();

    if (configTalonarioFactClie != null) {
        cargarRegistroConfigTalonarioFactClie(datasetConfigTalonarioFactClie,
                         configTalonarioFactClie.getOIDInteger(),
                         configTalonarioFactClie.getTalonario(),
                         configTalonarioFactClie.isActivo());
        cargarOperaciones(datasetOperHabilitadas,configTalonarioFactClie,datasetCompoStock,talonario);
    }
    else {
      cargarRegistroConfigTalonarioFactClie(datasetConfigTalonarioFactClie,
                                       new Integer( -1), talonario, new Boolean(true));
      cargarOperaciones(datasetOperHabilitadas,datasetCompoStock,talonario);
    }
    writeCliente(datasetConfigTalonarioFactClie);
    writeCliente(datasetOperHabilitadas);
    writeCliente(datasetCompoStock);
  }

  private void cargarComportamientosStock(IDataSet datasetComportamientosStock,
                                          OperHabiTalonarioFactClie operHabiTalFactClie,
                                          Talonario talonario) throws BaseException {
    int oid = 0;
    ConfMovStkTalonario confMovStkTalonario =
        ConfMovStkTalonario.getConfMovStkByTalonario(talonario,getSesion());
    if (confMovStkTalonario == null) return;
    Iterator iterConfMovStkTalonario = confMovStkTalonario.getTiposConfMov().iterator();
    while (iterConfMovStkTalonario.hasNext()) {
      TipoConfMovStkTalonario tipoConfMovStk =  (TipoConfMovStkTalonario) iterConfMovStkTalonario.next();
      CompoStkTalonarioFactClie compoStk =
          CompoStkTalonarioFactClie.getCompoStkTalonarioFactClie(operHabiTalFactClie,tipoConfMovStk,getSesion());
      if (compoStk == null)
         cargarRegistroCompoStock(datasetComportamientosStock,
                                  new Integer(--oid),
                                  operHabiTalFactClie.getOIDInteger(),
                                  tipoConfMovStk,
                                  new Boolean(false),
                                  new Boolean(false));
      else
        cargarRegistroCompoStock(datasetComportamientosStock,
                                 compoStk.getOIDInteger(),
                                 operHabiTalFactClie.getOIDInteger(),
                                 tipoConfMovStk,
                                 new Boolean(true),
                                 compoStk.isUsar_por_defecto());

    }
  }

  private void cargarOperaciones(IDataSet datasetOperHabilitadas,IDataSet datasetCompoStock,Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposFactClie = TipoOperFacturacion.getTipos().keySet().iterator();
    while (iterTiposFactClie.hasNext()) {
      String codigo      = (String) iterTiposFactClie.next();
      String descripcion = (String) TipoOperFacturacion.getTipos().get(codigo);
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  new Integer(-1),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false));
        OperHabiTalonarioFactClie operHabiTalFactClie =
            (OperHabiTalonarioFactClie) OperHabiTalonarioFactClie.getNew(OperHabiTalonarioFactClie.NICKNAME,getSesion());
        operHabiTalFactClie.setOID(new Integer(oid));
        cargarComportamientosStock(datasetCompoStock,operHabiTalFactClie,talonario);
    }
  }



  private void cargarOperaciones(IDataSet datasetOperHabilitadas,
                                 ConfigTalonarioFactClie configtalonarioFactClie,
                                 IDataSet dsCompoStk,
                                 Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposFactClie = TipoOperFacturacion.getTipos().keySet().iterator();
    while (iterTiposFactClie.hasNext()) {
      String codigo      = (String) iterTiposFactClie.next();
      String descripcion = (String) TipoOperFacturacion.getTipos().get(codigo);
      OperHabiTalonarioFactClie operHabilitada =
        OperHabiTalonarioFactClie.getOperHabiTalonarioFactClie(configtalonarioFactClie,codigo,getSesion());
      if (operHabilitada == null) {
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  configtalonarioFactClie.getOIDInteger(),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false)
                                  );
        OperHabiTalonarioFactClie operHabiTalFactClie =
            (OperHabiTalonarioFactClie) OperHabiTalonarioFactClie.getNew(OperHabiTalonarioFactClie.NICKNAME,getSesion());
        operHabiTalFactClie.setOID(new Integer(oid));
        cargarComportamientosStock(dsCompoStk,operHabiTalFactClie,talonario);
      }
        else {
          cargarRegistroOperaciones(datasetOperHabilitadas,
                                    operHabilitada.getOIDInteger(),
                                    configtalonarioFactClie.getOIDInteger(),
                                    codigo,
                                    descripcion,
                                    new Boolean(true),
                                    operHabilitada.isUsar_por_defecto());
         cargarComportamientosStock(dsCompoStk,operHabilitada,talonario);
        }
    }
  }

  private IDataSet getDataSetConfigTalonarioFactClie() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConfigTalonarioFactClie");
    dataset.fieldDef(new Field("oid_conf_tal_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_talonario", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_talonario", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetOperHabilitadas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TOperHabilitadas");
    dataset.fieldDef(new Field("oid_oper_tal_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conf_tal_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_facturacion", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_tipo_facturacion", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetComportamientosStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosStock");
    dataset.fieldDef(new Field("oid_compo_stk_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oper_tal_fact", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_conf_mov", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_conf_mov", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCompoStock(IDataSet dataset,
                                        Integer oidCompoStkFactClie,
                                        Integer oidOperTalFactClie,
                                        TipoConfMovStkTalonario tipoConfMovStkTal,
                                        Boolean habilitado,
                                        Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_stk_fact", oidCompoStkFactClie);
    dataset.fieldValue("oid_oper_tal_fact", oidOperTalFactClie);
    dataset.fieldValue("oid_tipo_conf_mov", tipoConfMovStkTal.getOIDInteger());
    dataset.fieldValue("cod_tipo_conf_mov", tipoConfMovStkTal.getCodigo());
    dataset.fieldValue("desc_tipo_conf_mov", tipoConfMovStkTal.getDescripcion());
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);

  }


  private void cargarRegistroOperaciones(IDataSet dataset,
                                         Integer oidOperTalFactClie,
                                         Integer oidConfTalFactClie,
                                         String tipoFaturacion,
                                         String descTipoFacturacion,
                                         Boolean habilitado,
                                         Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_oper_tal_fact", oidOperTalFactClie);
    dataset.fieldValue("oid_conf_tal_fact", oidConfTalFactClie);
    dataset.fieldValue("tipo_facturacion", tipoFaturacion);
    dataset.fieldValue("desc_tipo_facturacion", descTipoFacturacion);
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);
  }



  private void cargarRegistroConfigTalonarioFactClie(IDataSet dataset,
                         Integer oid_conf_tal_fact_clie,
                         Talonario talonario,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conf_tal_fact", oid_conf_tal_fact_clie);
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("cod_talonario", talonario.getCodigo());
    dataset.fieldValue("desc_talonario", talonario.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
