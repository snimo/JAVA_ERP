package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.ventas.bm.BonifRecarSujeto;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefaultCotizacion extends Operation {

  private int oid = 0;
  public TraerDefaultCotizacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Integer oidCliente = mapaDatos.getInteger("oid_cliente");
    java.util.Date fecha = mapaDatos.getDate("fecha");
    Sujeto sujeto = Sujeto.findByOid(oidCliente,getSesion());
    IDataSet datasetDefaultPedido = getDataSetDefaultPedido();
    if (sujeto!=null) {
    	 Moneda monedaCotizacion = sujeto.getMonedaCotizacion();
    	 if (monedaCotizacion == null) 
    		   monedaCotizacion = Moneda.getMonedaCursoLegal(this.getSesion());
    	 
       cargarRegistroDefaultPedido(datasetDefaultPedido,
      		 												 monedaCotizacion,
                                   PedidoCab.MERCADO_INTERNO,
                                   sujeto.getListasDePreciosVigente(fecha),
                                   sujeto.getCondicionPago(),
                                   sujeto.getVendedor_comercial(),
                                   sujeto.getDomicilioEntrega(),
                                   sujeto.getBonifRecar(fecha),
                                   sujeto.isBonifEnCascada(),
                                   sujeto.getTransporte(),
                                   sujeto.getMonedaPedido(),
                                   sujeto.getMonedaFactura());
    }
       else
         cargarRegistroDefaultPedido(datasetDefaultPedido,
             Moneda.getMonedaCursoLegal(getSesion()),
             PedidoCab.MERCADO_INTERNO,
             null,
             null,
             null,
             null,
             null,
             new Boolean(true),
             null,
             Moneda.getMonedaCursoLegal(getSesion()),
             Moneda.getMonedaCursoLegal(getSesion()));
      	 
   
    writeCliente(datasetDefaultPedido);
  }


  private IDataSet getDataSetDefaultPedido() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDefaultPedido");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("mercado", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_lp", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cond_pago", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_vend", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_vend", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_dom_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_dom_ent", Field.STRING, 30));
    dataset.fieldDef(new Field("porc_bonif_clie", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_recar_clie", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_bonif_cp", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_recar_cp", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("bonif_en_cascada", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_transporte", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda_pedido", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda_factura", Field.INTEGER, 0));
    return dataset;
  }


  private void cargarRegistroDefaultPedido(IDataSet dataset,
                         Moneda moneda,
                         String mercado,
                         ListaPrecios listaPrecios,
                         CondicionPago condicionPago,
                         Vendedor vendedor,
                         UnidadEdilicia domicilioEntrega,
                         BonifRecarSujeto bonifRecarSujeto,
                         Boolean bonifEnCascada,
                         Transporte transporte,
                         Moneda monedaPedido,
                         Moneda monedaFactura) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid",++oid);
    if (moneda!=null)
      dataset.fieldValue("oid_moneda", moneda.getOID());
    else
      dataset.fieldValue("oid_moneda", 0);
    dataset.fieldValue("mercado", mercado);
    if (listaPrecios!=null) {
      dataset.fieldValue("oid_lp", listaPrecios.getOID());
      dataset.fieldValue("cod_lp", listaPrecios.getCodigo());
    }
    else {
      dataset.fieldValue("oid_lp", 0);
      dataset.fieldValue("cod_lp", "");
    }
    if (condicionPago!=null) {
      dataset.fieldValue("oid_cond_pago", condicionPago.getOID());
      dataset.fieldValue("cod_cond_pago", condicionPago.getCodigo());
    }
    else {
      dataset.fieldValue("oid_cond_pago", 0);
      dataset.fieldValue("cod_cond_pago", "");
    }
    if (vendedor!=null) {
      dataset.fieldValue("oid_vend", vendedor.getOID());
      dataset.fieldValue("cod_vend", vendedor.getCodigo());
    }
    else {
      dataset.fieldValue("oid_vend", 0);
      dataset.fieldValue("cod_vend", "");
    }
    if (domicilioEntrega!=null) {
      dataset.fieldValue("oid_dom_ent", domicilioEntrega.getOID());
      dataset.fieldValue("cod_dom_ent", domicilioEntrega.getCodigo());
    }
    else {
      dataset.fieldValue("oid_dom_ent", 0);
      dataset.fieldValue("cod_dom_ent", "");
    }
    if (bonifRecarSujeto!=null) {
      dataset.fieldValue("porc_bonif_clie", bonifRecarSujeto.getPorcDto());
      dataset.fieldValue("porc_recar_clie", bonifRecarSujeto.getPorcRecar());
    }
    else {
      dataset.fieldValue("porc_bonif_clie", 0);
      dataset.fieldValue("porc_recar_clie", 0);
    }

    if (condicionPago!=null) {
      dataset.fieldValue("porc_bonif_cp", condicionPago.getPorc_desc());
      dataset.fieldValue("porc_recar_cp", condicionPago.getPorc_reca());
    }
    else {
      dataset.fieldValue("porc_bonif_cp", 0);
      dataset.fieldValue("porc_recar_cp", 0);
    }
    
    if (bonifEnCascada!=null)
    	dataset.fieldValue("bonif_en_cascada",bonifEnCascada);
    else
    	dataset.fieldValue("bonif_en_cascada",new Boolean(false));
    
    if (transporte!=null) {
    	dataset.fieldValue("oid_transporte",transporte.getOIDInteger());
    	dataset.fieldValue("cod_transporte",transporte.getCodigo());
    	dataset.fieldValue("desc_transporte",transporte.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_transporte",new Integer(0));
    	dataset.fieldValue("cod_transporte","");
    	dataset.fieldValue("desc_transporte","");
    }
    
    if (monedaPedido!=null)
    	dataset.fieldValue("oid_moneda_pedido",monedaPedido.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda_pedido",0);
    
    if (monedaFactura!=null)
    	dataset.fieldValue("oid_moneda_factura",monedaFactura.getOIDInteger());
    else
    	dataset.fieldValue("oid_moneda_factura",0);
    
  }
  

}
