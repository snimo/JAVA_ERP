package com.srn.erp.ventas.op;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetPedParaRto extends Operation {

  public TraerDetPedParaRto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  int oid = 0;
	  int orden = 0;
	  
	  Integer oidRemitoCab = mapaDatos.getInteger("oid_remito_cab");
	  IDataSet dsDetPedPendEnt = mapaDatos.getDataSet("TPedPentEntDet");
	  IDataSet dsRemitosDet = this.getDataSetDetRto();
	  dsDetPedPendEnt.first();
	  while (!dsDetPedPendEnt.EOF()) {
		  
		  dsRemitosDet.append();
		  
		  --oid;
		  ++orden;
		  dsRemitosDet.fieldValue("oid_remito_det",oid);
		  dsRemitosDet.fieldValue("oid_remito_cab",oidRemitoCab);
		  dsRemitosDet.fieldValue("oid_producto", dsDetPedPendEnt.getInteger("oid_producto"));
		  dsRemitosDet.fieldValue("cod_producto", dsDetPedPendEnt.getString("cod_producto"));
		  dsRemitosDet.fieldValue("desc_producto",dsDetPedPendEnt.getString("desc_producto"));
		  if (ValorParametro.findByCodigoParametro("CARGAR_CANT_PEND_DESP", this.getSesion()).getBoolean()) {
			  dsRemitosDet.fieldValue("cant_pend_desp",dsDetPedPendEnt.getMoney("cant_pedido"));
			  dsRemitosDet.fieldValue("cant_desp",dsDetPedPendEnt.getMoney("cant_pedido"));
		  } else {
			  dsRemitosDet.fieldValue("cant_pend_desp",new Money(0));
			  dsRemitosDet.fieldValue("cant_desp",new Money(0));
		  }
		  
		  
		  dsRemitosDet.fieldValue("oid_um_desp",dsDetPedPendEnt.getInteger("oid_um_pedido"));
		  dsRemitosDet.fieldValue("comentario",dsDetPedPendEnt.getString("desc_adic"));
		  dsRemitosDet.fieldValue("activo", new Boolean(true));
		  dsRemitosDet.fieldValue("oid_depo", new Integer(0));
		  dsRemitosDet.fieldValue("fec_entrega",dsDetPedPendEnt.getDate("fec_entrega"));
		  dsRemitosDet.fieldValue("cant_pedida",dsDetPedPendEnt.getMoney("cant_pedido"));
		  dsRemitosDet.fieldValue("oid_um_ped",dsDetPedPendEnt.getInteger("oid_um_pedido"));
		  dsRemitosDet.fieldValue("cod_um_ped","");
		  dsRemitosDet.fieldValue("cod_um_desp","");
		  dsRemitosDet.fieldValue("oid_compo_stk_rto",new Integer(0));
		  dsRemitosDet.fieldValue("codigo_compo_stk_rto","");
		  dsRemitosDet.fieldValue("oid_ubi_depo",new Integer(0));
		  dsRemitosDet.fieldValue("cod_ubi_depo","");
		  dsRemitosDet.fieldValue("desc_ubi_depo","");
		  dsRemitosDet.fieldValue("lleva_partida",false);
		  dsRemitosDet.fieldValue("lleva_serie",false);
		  dsRemitosDet.fieldValue("oid_tipo_conf_mov",new Integer(0));
		  dsRemitosDet.fieldValue("oid_ped_det",dsDetPedPendEnt.getInteger("oid_ped_det"));
		  dsRemitosDet.fieldValue("oid_cc_det",new Integer(0));
		  dsRemitosDet.fieldValue("orden",orden);
		  
		  dsDetPedPendEnt.next();
	  }
	  
	  writeCliente(dsRemitosDet);
	  
	  
  }

  private IDataSet getDataSetDetRto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRemitoDet");
    dataset.fieldDef(new Field("oid_remito_det",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_remito_cab",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto",Field.STRING, 255));
    dataset.fieldDef(new Field("cant_pend_desp",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_desp",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_desp",Field.INTEGER, 0));
    dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_depo",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_entrega",Field.DATE, 0));
    dataset.fieldDef(new Field("cant_pedida",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um_ped",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_ped",Field.STRING, 50));
    dataset.fieldDef(new Field("cod_um_desp",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_compo_stk_rto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_compo_stk_rto",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_ubi_depo",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ubi_depo",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ubi_depo",Field.STRING, 100));
    dataset.fieldDef(new Field("lleva_partida",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("lleva_serie",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_tipo_conf_mov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ped_det",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cc_det",Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    return dataset;
  }


}
