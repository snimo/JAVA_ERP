package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioDevVtas;
import com.srn.erp.ventas.bm.ConfigTalonarioDevVtas;
import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.OperHabiTalonarioDevVtas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigTalonarioDevVtas extends Operation {

  public TraerConfigTalonarioDevVtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid"),
                                              getSesion());
    ConfigTalonarioDevVtas configTalonarioDev =
    	ConfigTalonarioDevVtas.getConfigTalolario(talonario,getSesion());

    IDataSet datasetConfigTalonarioDev = getDataSetConfigTalonarioDev();
    IDataSet datasetOperHabilitadas    = getDataSetOperHabilitadas();
    IDataSet datasetCompoStock         = getDataSetComportamientosStock();

    if (configTalonarioDev != null) {
        cargarRegistroConfigTalonarioDev(datasetConfigTalonarioDev,
                         configTalonarioDev.getOIDInteger(),
                         configTalonarioDev.getTalonario(),
                         configTalonarioDev.isActivo());
        cargarOperaciones(datasetOperHabilitadas,configTalonarioDev,datasetCompoStock,talonario);
    }
    else {
      cargarRegistroConfigTalonarioDev(datasetConfigTalonarioDev,
                                       new Integer( -1), talonario, new Boolean(true));
      cargarOperaciones(datasetOperHabilitadas,datasetCompoStock,talonario);
    }
    writeCliente(datasetConfigTalonarioDev);
    writeCliente(datasetOperHabilitadas);
    writeCliente(datasetCompoStock);
  }

  private void cargarComportamientosStock(IDataSet datasetComportamientosStock,
                                          OperHabiTalonarioDevVtas operHabiTalDev,
                                          Talonario talonario) throws BaseException {
    int oid = 0;
    ConfMovStkTalonario confMovStkTalonario =
        ConfMovStkTalonario.getConfMovStkByTalonario(talonario,getSesion());
    if (confMovStkTalonario == null) return;
    Iterator iterConfMovStkTalonario = confMovStkTalonario.getTiposConfMov().iterator();
    while (iterConfMovStkTalonario.hasNext()) {
      TipoConfMovStkTalonario tipoConfMovStk =  (TipoConfMovStkTalonario) iterConfMovStkTalonario.next();
      CompoStkTalonarioDevVtas compoStk =
    	  CompoStkTalonarioDevVtas.getCompoStkTalDevVtas(operHabiTalDev,tipoConfMovStk,getSesion());
      if (compoStk == null)
         cargarRegistroCompoStock(datasetComportamientosStock,
                                  new Integer(--oid),
                                  operHabiTalDev.getOIDInteger(),
                                  tipoConfMovStk,
                                  new Boolean(false),
                                  new Boolean(false));
      else
        cargarRegistroCompoStock(datasetComportamientosStock,
                                 compoStk.getOIDInteger(),
                                 operHabiTalDev.getOIDInteger(),
                                 tipoConfMovStk,
                                 new Boolean(true),
                                 compoStk.isUsar_por_defecto());

    }
  }

  private void cargarOperaciones(IDataSet datasetOperHabilitadas,IDataSet datasetCompoStock,Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposDev = DevolucionVtasCab.getTiposDevoluciones().keySet().iterator();
    while (iterTiposDev.hasNext()) {
      String codigo      = (String) iterTiposDev.next();
      String descripcion = (String) DevolucionVtasCab.getTiposDevoluciones().get(codigo);
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  new Integer(-1),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false));
        OperHabiTalonarioDevVtas operHabiTalDev =
            (OperHabiTalonarioDevVtas) OperHabiTalonarioDevVtas.getNew(OperHabiTalonarioDevVtas.NICKNAME,getSesion());
        operHabiTalDev.setOID(new Integer(oid));
        cargarComportamientosStock(datasetCompoStock,operHabiTalDev,talonario);
    }
  }



  private void cargarOperaciones(IDataSet datasetOperHabilitadas,
                                 ConfigTalonarioDevVtas configtalonarioDev,
                                 IDataSet dsCompoStk,
                                 Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposDev = DevolucionVtasCab.getTiposDevoluciones().keySet().iterator();
    while (iterTiposDev.hasNext()) {
      String codigo      = (String) iterTiposDev.next();
      String descripcion = (String) DevolucionVtasCab.getTiposDevoluciones().get(codigo);
      OperHabiTalonarioDevVtas operHabilitada =
        OperHabiTalonarioDevVtas.getOperHabiTalonarioDevVtas(configtalonarioDev,codigo,getSesion());
      if (operHabilitada == null) {
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  configtalonarioDev.getOIDInteger(),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false)
                                  );
        OperHabiTalonarioDevVtas operHabiTalDev =
            (OperHabiTalonarioDevVtas) OperHabiTalonarioDevVtas.getNew(OperHabiTalonarioDevVtas.NICKNAME,getSesion());
        operHabiTalDev.setOID(new Integer(oid));
        cargarComportamientosStock(dsCompoStk,operHabiTalDev,talonario);
      }
        else {
          cargarRegistroOperaciones(datasetOperHabilitadas,
                                    operHabilitada.getOIDInteger(),
                                    configtalonarioDev.getOIDInteger(),
                                    codigo,
                                    descripcion,
                                    new Boolean(true),
                                    operHabilitada.isUsar_por_defecto());
         cargarComportamientosStock(dsCompoStk,operHabilitada,talonario);
        }
    }
  }

  private IDataSet getDataSetConfigTalonarioDev() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConfigTalonarioDevClie");
    dataset.fieldDef(new Field("oid_conf_tal_dev", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_talonario", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_talonario", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetOperHabilitadas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TOperHabilitadas");
    dataset.fieldDef(new Field("oid_oper_tal_dev", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conf_tal_dev", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_dev", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_tipo_dev", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetComportamientosStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosStock");
    dataset.fieldDef(new Field("oid_compo_stk_dev", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oper_tal_dev", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_conf_mov", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_conf_mov", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCompoStock(IDataSet dataset,
                                        Integer oidCompoStkDev,
                                        Integer oidOperTalDev,
                                        TipoConfMovStkTalonario tipoConfMovStkTal,
                                        Boolean habilitado,
                                        Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_stk_dev", oidCompoStkDev);
    dataset.fieldValue("oid_oper_tal_dev", oidOperTalDev);
    dataset.fieldValue("oid_tipo_conf_mov", tipoConfMovStkTal.getOIDInteger());
    dataset.fieldValue("cod_tipo_conf_mov", tipoConfMovStkTal.getCodigo());
    dataset.fieldValue("desc_tipo_conf_mov", tipoConfMovStkTal.getDescripcion());
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);

  }


  private void cargarRegistroOperaciones(IDataSet dataset,
                                         Integer oidOperTalDev,
                                         Integer oidConfTalDev,
                                         String tipoDev,
                                         String descTipoDev,
                                         Boolean habilitado,
                                         Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_oper_tal_dev", oidOperTalDev);
    dataset.fieldValue("oid_conf_tal_dev", oidConfTalDev);
    dataset.fieldValue("tipo_dev", tipoDev);
    dataset.fieldValue("desc_tipo_dev", descTipoDev);
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);
  }



  private void cargarRegistroConfigTalonarioDev(IDataSet dataset,
                         Integer oid_conf_tal_dev,
                         Talonario talonario,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conf_tal_dev", oid_conf_tal_dev);
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("cod_talonario", talonario.getCodigo());
    dataset.fieldValue("desc_talonario", talonario.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
