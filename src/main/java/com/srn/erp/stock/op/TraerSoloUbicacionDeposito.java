package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSoloUbicacionDeposito extends Operation {

  public TraerSoloUbicacionDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsUbiDepo = getDataSetUbicacionDeposito();

    Deposito deposito = Deposito.findByOid(mapaDatos.getInteger("oid"),getSesion());
    Iterator iterUbiDepo = deposito.getUbicaciones().iterator();
    while (iterUbiDepo.hasNext()) {
      UbicacionDeposito ubiDepo = (UbicacionDeposito) iterUbiDepo.next();
      cargarRegistroUbicacionDeposito(dsUbiDepo,
                                      ubiDepo.getOIDInteger(),
                                      ubiDepo.getCodigo(),
                                      ubiDepo.getOid(),
                                      ubiDepo.getDescripcion(),
                                      ubiDepo.getDeposito(),
                                      ubiDepo.getOid_padre(),
                                      ubiDepo.isSolo_sku_habi(),
                                      ubiDepo.getSujeto(),
                                      ubiDepo.getTransporte(),
                                      ubiDepo.getDeposito_destino(),
                                      ubiDepo.isAllow_almacenar(),
                                      ubiDepo.getTipo(),
                                      ubiDepo.getSecu(),
                                      ubiDepo.isActivo());
    }

    writeCliente(dsUbiDepo);

  }

  private IDataSet getDataSetUbicacionDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUbicacionesDelDeposito");
    dataset.fieldDef(new Field("oid_ubi_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("solo_sku_habi", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_sujeto", Field.STRING,50));
    dataset.fieldDef(new Field("rz_sujeto", Field.STRING,100));
    dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_transporte", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_depo_dest", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_depo_dest", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_depo_dest", Field.STRING, 100));
    dataset.fieldDef(new Field("allow_almacenar", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 20));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ocultar_registro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("valor_sku_hab",Field.INTEGER, 0));
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

  private void cargarRegistroUbicacionDeposito(IDataSet dataset,
                         Integer oid_ubi_depo,
                         String codigo,
                         Integer oid,
                         String descripcion,
                         Deposito deposito,
                         Integer oid_padre,
                         Boolean solo_sku_habi,
                         Sujeto sujeto,
                         Transporte transporte,
                         Deposito depositoDestino,
                         Boolean allow_almacenar,
                         String tipo,
                         Integer secu,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ubi_depo", oid_ubi_depo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_deposito", deposito.getOIDInteger());
    dataset.fieldValue("oid_padre", oid_padre);
    dataset.fieldValue("solo_sku_habi", solo_sku_habi);
    if (sujeto!=null) {
      dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
      dataset.fieldValue("codigo_sujeto", sujeto.getCodigo());
      dataset.fieldValue("rz_sujeto", sujeto.getRazon_social());
    }
    else {
      dataset.fieldValue("oid_sujeto", 0);
      dataset.fieldValue("codigo_sujeto", "");
      dataset.fieldValue("rz_sujeto", "");
    }

    if (transporte!=null) {
      dataset.fieldValue("oid_transporte", transporte.getOIDInteger());
      dataset.fieldValue("cod_transporte", transporte.getCodigo());
      dataset.fieldValue("desc_transporte", transporte.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_transporte", 0);
      dataset.fieldValue("cod_transporte", "");
      dataset.fieldValue("desc_transporte", "");
    }

    if (depositoDestino!=null) {
      dataset.fieldValue("oid_depo_dest", depositoDestino.getOIDInteger());
      dataset.fieldValue("codigo_depo_dest", depositoDestino.getCodigo());
      dataset.fieldValue("desc_depo_dest", depositoDestino.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_depo_dest", 0);
      dataset.fieldValue("codigo_depo_dest", "");
      dataset.fieldValue("desc_depo_dest", "");
    }
    dataset.fieldValue("allow_almacenar", allow_almacenar);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("ocultar_registro", new Integer(0));
    if (solo_sku_habi.booleanValue()==true)
      dataset.fieldValue("valor_sku_hab",1);
    else
      dataset.fieldValue("valor_sku_hab",0);

  }
}
