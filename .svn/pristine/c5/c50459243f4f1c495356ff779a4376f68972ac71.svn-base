package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

 public class ValidarUbiDepoHabi extends Operation {

  public ValidarUbiDepoHabi() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsValUbiDepo = getDataSetValidarUbiDepo();
    String cod_ubi_depo = mapaDatos.getString("cod_ubi_depo");
    Deposito deposito = Deposito.findByOid(mapaDatos.getInteger("oid_deposito"),
                                           getSesion());
    TipoConfMovStkTalonario tipoConfMovStkTal = null;
    if (mapaDatos.containsKey("oid_tipo_conf_mov"))
      tipoConfMovStkTal =
          TipoConfMovStkTalonario.findByOid(mapaDatos.getInteger("oid_tipo_conf_mov"),
                                            getSesion());
    List ubicacionesHabilitadas = deposito.getUbicacionesHabilitadas(tipoConfMovStkTal);
    Iterator iterUbiDepo = ubicacionesHabilitadas.iterator();
    while (iterUbiDepo.hasNext()) {
      UbicacionDeposito ubiDepo = (UbicacionDeposito) iterUbiDepo.next();
      if (ubiDepo.getCodigo().equals(cod_ubi_depo)) {
        if (ubiDepo.getHabilitada()==false)
          throw new ExceptionValidation(null,"La ubicación no se encuentra habilitada para su selección");
        if (ubiDepo.isAllow_almacenar().booleanValue() == false)
          throw new ExceptionValidation(null,"No se permite almacenar un producto es esta ubicación de Depósito");
      cargarUbicacionDeposito(dsValUbiDepo,ubiDepo);
      }
    }

    writeCliente(dsValUbiDepo);

  }

  private void cargarUbicacionDeposito(IDataSet ds,UbicacionDeposito ubicacionDeposito) throws BaseException {
    ds.append();
    ds.fieldValue("oid_ubi_depo", ubicacionDeposito.getOIDInteger());
    ds.fieldValue("codigo", ubicacionDeposito.getCodigo());
    ds.fieldValue("descripcion", ubicacionDeposito.getDescripcion());
  }

  private IDataSet getDataSetValidarUbiDepo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValUbiDepo");
    dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }


}
