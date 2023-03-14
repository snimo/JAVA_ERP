package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.SolicitarAPedMerc;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPedidosParaDepoPendEnvio extends Operation {

  public TraerPedidosParaDepoPendEnvio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsCompro = getDataSet();
    traerPedidosParaDepoPendEnvio(dsCompro,mapaDatos);
    writeCliente(dsCompro);
  }

  private void traerPedidosParaDepoPendEnvio(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    java.util.Date fecReqDesde = null;
    java.util.Date fecReqHasta = null;
    PedidoCab pedido = null;
    SolicitarAPedMerc solicitarA = null;
    Deposito deposito = null;
    
    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("fec_req_desde"))
        fecReqDesde = mapaDatos.getDate("fec_req_desde");
    if (mapaDatos.containsKey("fec_req_hasta"))
        fecReqHasta = mapaDatos.getDate("fec_req_hasta");
    if (mapaDatos.containsKey("oid_deposito")) 
    	deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"), this.getSesion());
    if (mapaDatos.containsKey("oid_cco_ped")) 
    	pedido = PedidoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_ped"), this.getSesion());
    if (mapaDatos.containsKey("oid_solicitar_a")) 
    	solicitarA = SolicitarAPedMerc.findByOidProxy(mapaDatos.getInteger("oid_solicitar_a"), this.getSesion());
    
    List listaCompro =
        PedMercDepoDet.getDetallesPendientesDeEnvio(nroExtDesde, nroExtHasta, fecDesde, fecHasta, fecReqDesde, fecReqHasta, pedido, deposito, solicitarA, null ,this.getSesion());
    Iterator iterCompro = listaCompro.iterator();
    while (iterCompro.hasNext()) {
      PedMercDepoDet pedMercDepoDet = (PedMercDepoDet) iterCompro.next();
      cargarRegistro(dataSet,pedMercDepoDet);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPedDepoPendEnv");
    dataset.fieldDef(new Field("oid_ped_merc_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ped_merc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_sol_ped_merc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_sol_ped_merc", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_depo_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_depo_ent", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 50));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("enviada", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_pend_envio", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
    dataset.fieldDef(new Field("fec_necesidad", Field.DATE, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              PedMercDepoDet pedMercDepoDet)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid_ped_merc_det", pedMercDepoDet.getOIDInteger());
    dataset.fieldValue("oid_ped_merc", pedMercDepoDet.getPedido_mercaderia().getOIDInteger());
    dataset.fieldValue("comprobante", pedMercDepoDet.getPedido_mercaderia().getCodigo());
    dataset.fieldValue("oid_sol_ped_merc", pedMercDepoDet.getPedido_mercaderia().getSolicitar_a().getOIDInteger());
    dataset.fieldValue("desc_sol_ped_merc", pedMercDepoDet.getPedido_mercaderia().getSolicitar_a().getDescripcion());
    dataset.fieldValue("oid_depo_ent", pedMercDepoDet.getPedido_mercaderia().getDeposito_entrega().getOIDInteger());
    dataset.fieldValue("desc_depo_ent", pedMercDepoDet.getPedido_mercaderia().getDeposito_entrega().getDescripcion());
    dataset.fieldValue("oid_producto", pedMercDepoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedMercDepoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedMercDepoDet.getProducto().getDescripcion());
    dataset.fieldValue("oid_um", pedMercDepoDet.getUnidad_medida().getOIDInteger());
    dataset.fieldValue("cod_um", pedMercDepoDet.getUnidad_medida().getCodigo());
    dataset.fieldValue("cantidad", pedMercDepoDet.getCantidad());
    dataset.fieldValue("enviada", pedMercDepoDet.getCantEnviada());
    dataset.fieldValue("cant_pend_envio", pedMercDepoDet.getCantPendEnvio());
    dataset.fieldValue("observacion", pedMercDepoDet.getObservacion());
    dataset.fieldValue("fec_necesidad", pedMercDepoDet.getFec_necesidad());
  }

}
