package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoConfMovStk extends Operation {

  public TraerTipoConfMovStk() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsTipoConfMovStk = getDataSetTipoConfMovStk();
    IDataSet dsMovStkDepo     = getDataSetMovStkDepo();

    TipoConfMovStkTalonario tipoConfMovStk =
        TipoConfMovStkTalonario.findByOid(mapaDatos.getInteger("oid_tipo_conf_mov"),getSesion());

    cargarRegistroTipoConfMovStk(dsTipoConfMovStk,tipoConfMovStk);
    Iterator iterMovStkTal = tipoConfMovStk.getMoviStockTalonarios().iterator();
    while (iterMovStkTal.hasNext()) {
      MovStockTalonarioDeposito movStkTalDepo = (MovStockTalonarioDeposito) iterMovStkTal.next();
      if (movStkTalDepo.isActivo().booleanValue())
         cargarRegistroMovStkDepo(dsMovStkDepo,movStkTalDepo);
    }

    writeCliente(dsTipoConfMovStk);
    writeCliente(dsMovStkDepo);
  }

  private IDataSet getDataSetTipoConfMovStk() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoConfMovStk");
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conf_mov_stk", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetMovStkDepo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMovStkTal");
    dataset.fieldDef(new Field("oid_mov_stk_tal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_deposito", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_deposito", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_estado_stock",Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_movimiento", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("afecta_stk_fisico", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroTipoConfMovStk(IDataSet dataset,
                                            TipoConfMovStkTalonario tipoConfMovStkTalonario) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_conf_mov", tipoConfMovStkTalonario.getOID());
    dataset.fieldValue("oid_conf_mov_stk", tipoConfMovStkTalonario.getConf_mov_stk().getOID());
    dataset.fieldValue("codigo", tipoConfMovStkTalonario.getCodigo());
    dataset.fieldValue("descripcion", tipoConfMovStkTalonario.getDescripcion());
    dataset.fieldValue("activo", tipoConfMovStkTalonario.isActivo());
  }

  private void cargarRegistroMovStkDepo(IDataSet dataset,
                                        MovStockTalonarioDeposito movStockTalonarioDeposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_mov_stk_tal", movStockTalonarioDeposito.getOIDInteger());
    dataset.fieldValue("oid_tipo_conf_mov", movStockTalonarioDeposito.getTipo_conf_mov().getOIDInteger());
    dataset.fieldValue("secu", movStockTalonarioDeposito.getSecu());
    dataset.fieldValue("oid_deposito", movStockTalonarioDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("cod_deposito", movStockTalonarioDeposito.getDeposito().getCodigo());
    dataset.fieldValue("desc_deposito", movStockTalonarioDeposito.getDeposito().getDescripcion());
    dataset.fieldValue("oid_estado_stock", movStockTalonarioDeposito.getEstado_stock().getOIDInteger());
    dataset.fieldValue("desc_estado_stock",movStockTalonarioDeposito.getEstado_stock().getDescripcion());
    dataset.fieldValue("tipo_movimiento", movStockTalonarioDeposito.getTipo_movimiento().toLowerCase());
    dataset.fieldValue("activo", movStockTalonarioDeposito.isActivo());
    dataset.fieldValue("afecta_stk_fisico", movStockTalonarioDeposito.isAfectaStockFisico());
  }

}
