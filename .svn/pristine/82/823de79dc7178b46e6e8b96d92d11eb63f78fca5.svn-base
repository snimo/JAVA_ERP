package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.ConfigTalonarioRto;
import com.srn.erp.ventas.bm.OperHabiTalonarioRto;
import com.srn.erp.ventas.bm.RemitoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConfigTalonarioRtoDevProv extends Operation {

  public TraerConfigTalonarioRtoDevProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Talonario talonario = Talonario.findByOid(mapaDatos.getInteger("oid"),
                                              getSesion());
    ConfigTalonarioRto configTalonarioRto =
        ConfigTalonarioRto.getConfigTalonarioRto(talonario,getSesion());

    IDataSet datasetConfigTalonarioRto = getDataSetConfigTalonarioRto();
    IDataSet datasetOperHabilitadas    = getDataSetOperHabilitadas();
    IDataSet datasetCompoStock         = getDataSetComportamientosStock();

    if (configTalonarioRto != null) {
        cargarRegistroConfigTalonarioRto(datasetConfigTalonarioRto,
                         configTalonarioRto.getOIDInteger(),
                         configTalonarioRto.getTalonario(),
                         configTalonarioRto.isActivo());
        cargarOperaciones(datasetOperHabilitadas,configTalonarioRto,datasetCompoStock,talonario);
    }
    else {
      cargarRegistroConfigTalonarioRto(datasetConfigTalonarioRto,
                                       new Integer( -1), talonario, new Boolean(true));
      cargarOperaciones(datasetOperHabilitadas,datasetCompoStock,talonario);
    }
    writeCliente(datasetConfigTalonarioRto);
    writeCliente(datasetOperHabilitadas);
    writeCliente(datasetCompoStock);
  }

  private void cargarComportamientosStock(IDataSet datasetComportamientosStock,
                                          OperHabiTalonarioRto operHabiTalRto,
                                          Talonario talonario) throws BaseException {
    int oid = 0;
    ConfMovStkTalonario confMovStkTalonario =
        ConfMovStkTalonario.getConfMovStkByTalonario(talonario,getSesion());
    if (confMovStkTalonario == null) return;
    Iterator iterConfMovStkTalonario = confMovStkTalonario.getTiposConfMov().iterator();
    while (iterConfMovStkTalonario.hasNext()) {
      TipoConfMovStkTalonario tipoConfMovStk =  (TipoConfMovStkTalonario) iterConfMovStkTalonario.next();
      CompoStkTalonarioRto compoStk =
          CompoStkTalonarioRto.getComportamientoStkTalonarioRto(operHabiTalRto,tipoConfMovStk,getSesion());
      if (!tipoConfMovStk.getTipoMovimiento().equals(TipoConfMovStkTalonario.DEVOLUCION_A_PROVEEDOR))
      	continue;
      if (compoStk == null)
         cargarRegistroCompoStock(datasetComportamientosStock,
                                  new Integer(--oid),
                                  operHabiTalRto.getOIDInteger(),
                                  tipoConfMovStk,
                                  new Boolean(false),
                                  new Boolean(false));
      else
        cargarRegistroCompoStock(datasetComportamientosStock,
                                 compoStk.getOIDInteger(),
                                 operHabiTalRto.getOIDInteger(),
                                 tipoConfMovStk,
                                 new Boolean(true),
                                 compoStk.isUsarPorDefecto());

    }
  }

  private void cargarOperaciones(IDataSet datasetOperHabilitadas,IDataSet datasetCompoStock,Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposRtos = RemitoCab.getTiposDespSinFactu().keySet().iterator();
    while (iterTiposRtos.hasNext()) {
      String codigo      = (String) iterTiposRtos.next();
      String descripcion = (String) RemitoCab.getTiposDespSinFactu().get(codigo);
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  new Integer(-1),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false));
        OperHabiTalonarioRto operHabiTalRto =
            (OperHabiTalonarioRto) OperHabiTalonarioRto.getNew(OperHabiTalonarioRto.NICKNAME,getSesion());
        operHabiTalRto.setOID(new Integer(oid));
        cargarComportamientosStock(datasetCompoStock,operHabiTalRto,talonario);
    }
  }



  private void cargarOperaciones(IDataSet datasetOperHabilitadas,
                                 ConfigTalonarioRto configtalonariorto,
                                 IDataSet dsCompoStk,
                                 Talonario talonario) throws BaseException {
    int oid = 0;
    Iterator iterTiposRtos = RemitoCab.getTiposDespSinFactu().keySet().iterator();
    while (iterTiposRtos.hasNext()) {
      String codigo      = (String) iterTiposRtos.next();
      String descripcion = (String) RemitoCab.getTiposDespSinFactu().get(codigo);
      OperHabiTalonarioRto operHabilitada =
        OperHabiTalonarioRto.getOperHabilitada(configtalonariorto,codigo,getSesion());
      if (operHabilitada == null) {
        cargarRegistroOperaciones(datasetOperHabilitadas,
                                  new Integer(--oid),
                                  configtalonariorto.getOIDInteger(),
                                  codigo,
                                  descripcion,
                                  new Boolean(false),
                                  new Boolean(false)
                                  );
        OperHabiTalonarioRto operHabiTalRto =
            (OperHabiTalonarioRto) OperHabiTalonarioRto.getNew(OperHabiTalonarioRto.NICKNAME,getSesion());
        operHabiTalRto.setOID(new Integer(oid));
        cargarComportamientosStock(dsCompoStk,operHabiTalRto,talonario);
      }
        else {
          cargarRegistroOperaciones(datasetOperHabilitadas,
                                    operHabilitada.getOIDInteger(),
                                    configtalonariorto.getOIDInteger(),
                                    codigo,
                                    descripcion,
                                    new Boolean(true),
                                    operHabilitada.isUsarPorDefecto());
         cargarComportamientosStock(dsCompoStk,operHabilitada,talonario);
        }
    }
  }

  private IDataSet getDataSetConfigTalonarioRto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConfigTalonarioRto");
    dataset.fieldDef(new Field("oid_conf_tal_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_talonario", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_talonario", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetOperHabilitadas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TOperHabilitadas");
    dataset.fieldDef(new Field("oid_oper_tal_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conf_tal_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_rto", Field.STRING, 20));
    dataset.fieldDef(new Field("desc_tipo_rto", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetComportamientosStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientosStock");
    dataset.fieldDef(new Field("oid_compo_stk_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oper_tal_rto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_conf_mov", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_conf_mov", Field.STRING, 100));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCompoStock(IDataSet dataset,
                                        Integer oidCompoStkRto,
                                        Integer oidOperTalRto,
                                        TipoConfMovStkTalonario tipoConfMovStkTal,
                                        Boolean habilitado,
                                        Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_compo_stk_rto", oidCompoStkRto);
    dataset.fieldValue("oid_oper_tal_rto", oidOperTalRto);
    dataset.fieldValue("oid_tipo_conf_mov", tipoConfMovStkTal.getOIDInteger());
    dataset.fieldValue("cod_tipo_conf_mov", tipoConfMovStkTal.getCodigo());
    dataset.fieldValue("desc_tipo_conf_mov", tipoConfMovStkTal.getDescripcion());
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);

  }


  private void cargarRegistroOperaciones(IDataSet dataset,
                                         Integer oidOperTalRto,
                                         Integer oidConfTalRto,
                                         String tipoRto,
                                         String descTipoRto,
                                         Boolean habilitado,
                                         Boolean usarPorDefecto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_oper_tal_rto", oidOperTalRto);
    dataset.fieldValue("oid_conf_tal_rto", oidConfTalRto);
    dataset.fieldValue("tipo_rto", tipoRto);
    dataset.fieldValue("desc_tipo_rto", descTipoRto);
    dataset.fieldValue("habilitado", habilitado);
    dataset.fieldValue("usar_por_defecto",usarPorDefecto);
  }



  private void cargarRegistroConfigTalonarioRto(IDataSet dataset,
                         Integer oid_conf_tal_rto,
                         Talonario talonario,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_conf_tal_rto", oid_conf_tal_rto);
    dataset.fieldValue("oid_talonario", talonario.getOIDInteger());
    dataset.fieldValue("cod_talonario", talonario.getCodigo());
    dataset.fieldValue("desc_talonario", talonario.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
