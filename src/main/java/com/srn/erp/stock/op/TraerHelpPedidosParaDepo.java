package com.srn.erp.stock.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.SolicitarAPedMerc;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpPedidosParaDepo extends Operation {

  public TraerHelpPedidosParaDepo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSet();
    traer(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traer(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
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
    if (mapaDatos.containsKey("oid_solicitar_a"))
      solicitarA = SolicitarAPedMerc.findByOidProxy(mapaDatos.getInteger("oid_solicitar_a"),getSesion());
    if (mapaDatos.containsKey("oid_deposito"))
        deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"),getSesion());
    
    List listaPedidos =
        PedMercDep.getPedidosParaDeposito(nroExtDesde,nroExtHasta,fecDesde,fecHasta,solicitarA,deposito,getSesion());
    Iterator iterPedidos = listaPedidos.iterator();
    while (iterPedidos.hasNext()) {
      PedMercDep pedido = (PedMercDep) iterPedidos.next();
      cargarRegistro(dataSet,pedido);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpPedidosProductos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("solicitar_a", Field.STRING, 100));
    dataset.fieldDef(new Field("entregar_en", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER,0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  PedMercDep pedido) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", pedido.getOID());
    dataset.fieldValue("oid_cco", pedido.getOID());
    dataset.fieldValue("comprobante", pedido.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(pedido.getEmision()));
    dataset.fieldValue("solicitar_a", pedido.getSolicitar_a().getDescripcion());
    dataset.fieldValue("entregar_en", pedido.getDeposito_entrega().getDescripcion());
    dataset.fieldValue("nro_ext", pedido.getNroExt());     
    dataset.fieldValue("activo", pedido.isActivo());
  }

}
