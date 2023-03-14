package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbiDepoHabTalonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUbiDepoDefault extends Operation {

  public TraerUbiDepoDefault() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidTipoConfMov = mapaDatos.getInteger("oid_tipo_conf_mov");
    TipoConfMovStkTalonario tipoConfMovStockTal =
        TipoConfMovStkTalonario.findByOid(oidTipoConfMov,getSesion());
    IDataSet dsUbiDepoDefault = getDataSeUbiDepoDafult();

    Iterator iterMovStockTalonarios =
        tipoConfMovStockTal.getMoviStockTalonarios().iterator();
    while (iterMovStockTalonarios.hasNext()) {
      MovStockTalonarioDeposito movStockTalonarioDeposito =
         (MovStockTalonarioDeposito) iterMovStockTalonarios.next();
      cargarDataSetUbiDefault(dsUbiDepoDefault,
                              movStockTalonarioDeposito,
                              movStockTalonarioDeposito.getUbiDepoHabTalDefault());
    }

    writeCliente(dsUbiDepoDefault);
  }

  private IDataSet getDataSeUbiDepoDafult() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUbiDepoDefault");
    dataset.fieldDef(new Field("oid_mov_stk_tal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_deposito", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_estado_stock", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_estado_stock", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_movimiento", Field.STRING,20));
    dataset.fieldDef(new Field("afecta_stk_fisico",Field.BOOLEAN,0));
    dataset.fieldDef(new Field("oid_ubi_depo_tal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("incluye_hijos", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cod_ubi_depo",Field.STRING,50));
    dataset.fieldDef(new Field("desc_ubi_depo",Field.STRING,100));

    return dataset;
  }

  private void cargarDataSetUbiDefault(IDataSet dataset,
                                      MovStockTalonarioDeposito movStockTalonarioDeposito,
                                      UbiDepoHabTalonario ubiDepoHabTal) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_mov_stk_tal", movStockTalonarioDeposito.getOIDInteger());
    dataset.fieldValue("oid_tipo_conf_mov", movStockTalonarioDeposito.getTipo_conf_mov().getOIDInteger());
    dataset.fieldValue("secu", movStockTalonarioDeposito.getSecu());
    dataset.fieldValue("oid_deposito", movStockTalonarioDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("cod_deposito", movStockTalonarioDeposito.getDeposito().getCodigo());
    dataset.fieldValue("desc_deposito", movStockTalonarioDeposito.getDeposito().getDescripcion());
    dataset.fieldValue("oid_estado_stock", movStockTalonarioDeposito.getEstado_stock().getOIDInteger());
    dataset.fieldValue("cod_estado_stock", movStockTalonarioDeposito.getEstado_stock().getCodigo());
    dataset.fieldValue("desc_estado_stock", movStockTalonarioDeposito.getEstado_stock().getDescripcion());
    dataset.fieldValue("tipo_movimiento", movStockTalonarioDeposito.getTipo_movimiento());
    dataset.fieldValue("afecta_stk_fisico",movStockTalonarioDeposito.isAfectaStockFisico());
    if (ubiDepoHabTal!=null) {
      dataset.fieldValue("oid_ubi_depo_tal", ubiDepoHabTal.getOIDInteger());
      dataset.fieldValue("oid_ubi_depo",
                         ubiDepoHabTal.getUbicacion_deposito().getOIDInteger());
      dataset.fieldValue("habilitado", ubiDepoHabTal.isHabilitado());
      dataset.fieldValue("incluye_hijos", ubiDepoHabTal.isIncluye_hijos());
      dataset.fieldValue("usar_por_defecto", ubiDepoHabTal.isUsar_por_defecto());
      dataset.fieldValue("activo", ubiDepoHabTal.isActivo());
      dataset.fieldValue("cod_ubi_depo",ubiDepoHabTal.getUbicacion_deposito().getCodigo());
      dataset.fieldValue("desc_ubi_depo",ubiDepoHabTal.getUbicacion_deposito().getDescripcion());
    }
    else {
      dataset.fieldValue("oid_ubi_depo_tal", 0);
      dataset.fieldValue("oid_ubi_depo",0);
      dataset.fieldValue("habilitado", new Boolean(true));
      dataset.fieldValue("incluye_hijos", new Boolean(false));
      dataset.fieldValue("usar_por_defecto", new Boolean(true));
      dataset.fieldValue("activo", new Boolean(true));
      dataset.fieldValue("cod_ubi_depo","");
      dataset.fieldValue("desc_ubi_depo","");
    }
  }

}
