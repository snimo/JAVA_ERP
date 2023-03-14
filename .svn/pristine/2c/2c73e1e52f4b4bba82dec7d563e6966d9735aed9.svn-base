package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.ProdHabUbiDepo;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

 public class TraerUbiDepoHabi extends Operation {

  public TraerUbiDepoHabi() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsDeposito = getDataSetDeposito();
    IDataSet dsUbiDepo = getDataSetUbicacionesDeposito();
    IDataSet dsProdHab = getDataSetProductosHabilitados();

    Deposito deposito = Deposito.findByOid(mapaDatos.getInteger("oid_deposito"),
                                           getSesion());
    cargarDeposito(dsDeposito,deposito);
    TipoConfMovStkTalonario tipoConfMovStkTal = null;
    if (mapaDatos.containsKey("oid_tipo_conf_mov"))
      tipoConfMovStkTal =
          TipoConfMovStkTalonario.findByOid(mapaDatos.getInteger("oid_tipo_conf_mov"),
                                            getSesion());
    List ubicacionesHabilitadas = deposito.getUbicacionesHabilitadas(tipoConfMovStkTal);
    Iterator iterUbiDepo = ubicacionesHabilitadas.iterator();
    while (iterUbiDepo.hasNext()) {
      UbicacionDeposito ubiDepo = (UbicacionDeposito) iterUbiDepo.next();
      cargarRegistroUbicacionDeposito(dsUbiDepo,ubiDepo);
    }

    writeCliente(dsDeposito);
    writeCliente(dsUbiDepo);
    writeCliente(dsProdHab);

  }

  private MovStockTalonarioDeposito getMovStockTalonario(Deposito deposito,MapDatos mapaDatos) throws BaseException {
    MovStockTalonarioDeposito movStkTalDepo = null;
    if (mapaDatos.containsKey("oid_tipo_conf_mov")) {
      TipoConfMovStkTalonario tipoConfMovStkTal =
          TipoConfMovStkTalonario.findByOid(mapaDatos.getInteger("oid_tipo_conf_mov"),getSesion());
      movStkTalDepo = MovStockTalonarioDeposito.getMovStockTalonarioDeposito(tipoConfMovStkTal,deposito,getSesion());
      Integer oidTipoConfMov = mapaDatos.getInteger("oid_tipo_conf_mov");
    }
    return movStkTalDepo;
  }

  private IDataSet getDataSetUbicacionesDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUbicacionesDeposito");
    dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("solo_sku_habi", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("allow_almacenar", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 20));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_por_defecto", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDeposito");
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private IDataSet getDataSetProductosHabilitados() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProductosHabilitados");
    dataset.fieldDef(new Field("oid_um_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarDeposito(IDataSet dataset,
                              Deposito deposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_deposito", deposito.getOIDInteger());
    dataset.fieldValue("codigo", deposito.getCodigo());
    dataset.fieldValue("descripcion", deposito.getDescripcion());
  }

  private void cargarProductosHab(IDataSet dataset,
                                  UbicacionDeposito ubicacionDeposito,
                                  ProdHabUbiDepo prodHabUbiDepo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_um_ubi_depo", prodHabUbiDepo.getOIDInteger());
    dataset.fieldValue("oid_ubi_depo", ubicacionDeposito.getOIDInteger());
    dataset.fieldValue("oid_producto", prodHabUbiDepo.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", prodHabUbiDepo.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", prodHabUbiDepo.getProducto().getDescripcion());
  }


  private void cargarRegistroUbicacionDeposito(IDataSet dataset,
                                               UbicacionDeposito ubicacionDeposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ubi_depo", ubicacionDeposito.getOID());
    dataset.fieldValue("codigo", ubicacionDeposito.getCodigo());
    dataset.fieldValue("descripcion", ubicacionDeposito.getDescripcion());
    dataset.fieldValue("oid_deposito", ubicacionDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("oid", ubicacionDeposito.getOid());
    dataset.fieldValue("oid_padre", ubicacionDeposito.getOid_padre());
    dataset.fieldValue("solo_sku_habi", ubicacionDeposito.isSolo_sku_habi());
    dataset.fieldValue("allow_almacenar", ubicacionDeposito.isAllow_almacenar());
    dataset.fieldValue("tipo", ubicacionDeposito.getTipo());
    dataset.fieldValue("secu", ubicacionDeposito.getSecu());
    dataset.fieldValue("habilitado", new Boolean(ubicacionDeposito.getHabilitada()));
    dataset.fieldValue("usar_por_defecto", new Boolean(ubicacionDeposito.getUsarPorDefecto()));
  }

}
