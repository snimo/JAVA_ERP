package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPreciosDeListas extends Operation {

  private int oid = 0;
  private int oid_precios_det = 0;

  public TraerPreciosDeListas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dataset = getDataSetPreciosDeLista();
    IDataSet dsCantDecProd = getDataSetCantDecArt();

    Producto producto =
        Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"),
                                getSesion());
    
    cargarCantDecProd(dsCantDecProd,producto);

    boolean soloVigentes = false;
    boolean soloHabilitadas = false;

    if (mapaDatos.containsKey("listas_vigentes"))
      soloVigentes = true;
    if (mapaDatos.containsKey("listas_habilitadas"))
      soloHabilitadas = true;

    Iterator iterListaPrecios =
      ListaPrecios.getListaPrecios(soloVigentes,
                                   soloHabilitadas,
                                   getSesion()).iterator();
    
    while (iterListaPrecios.hasNext()) {
      ListaPrecios listaPrecios = (ListaPrecios) iterListaPrecios.next();
      ListaPreciosDet listaPreciosDet = listaPrecios.getListaPreciosDet(producto);
      if (listaPreciosDet!=null)
      cargarRegistroPrecioDeLista(dataset,
                                  listaPreciosDet.getOIDInteger(),
                                  listaPrecios.getOIDInteger(),
                                  listaPrecios.getCodigo(),
                                  listaPrecios.getDescripcion(),
                                  listaPreciosDet.getUnidad_medida().getOIDInteger(),
                                  listaPreciosDet.getMoneda().getOIDInteger(),
                                  listaPreciosDet.getMoneda().getDescripcion(),
                                  new Money(listaPreciosDet.getCantidad().doubleValue()),
                                  listaPreciosDet.getPrecio(),
                                  listaPreciosDet.getUnidad_medida().getDescripcion(),
                                  listaPreciosDet.getFecUltAct());
      else
        cargarRegistroPrecioDeLista(dataset,
                                    new Integer(--oid_precios_det),
                                    listaPrecios.getOIDInteger(),
                                    listaPrecios.getCodigo(),
                                    listaPrecios.getDescripcion(),
                                    producto.getUm_vta().getOIDInteger(),
                                    Moneda.getMonedaCursoLegal(getSesion()).getOIDInteger(),
                                    Moneda.getMonedaCursoLegal(getSesion()).getDescripcion(),
                                    new Money(1.0),
                                    new Money(0.0),
                                    producto.getUm_vta().getDescripcion(),
                                    null);


    }



    writeCliente(dataset);
    writeCliente(dsCantDecProd);
  }

  private IDataSet getDataSetPreciosDeLista() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TPreciosLista");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_precio_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_lp", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_lp", Field.STRING, 80));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 30));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("desc_um", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_ult_act", Field.DATE, 0));
    return dataset;
  }
  
  private IDataSet getDataSetCantDecArt() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TCantDecPrecioArt");
    dataset.fieldDef(new Field("cant_dec_pv", Field.INTEGER, 0));
    return dataset;
  }  
  
  private void cargarCantDecProd(IDataSet ds,Producto producto) throws BaseException {
  	ds.append();
  	if (producto.getCantDecPrecioVta()!=null)
  		ds.fieldValue("cant_dec_pv", producto.getCantDecPrecioVta());
  	else
  		ds.fieldValue("cant_dec_pv", new Integer(0));
  }

  private void cargarRegistroPrecioDeLista(IDataSet dataset,
                                           Integer oidPrecioDet,
                                           Integer oidPrecioCab,
                                           String codigoLP,
                                           String descLP,
                                           Integer oidUM,
                                           Integer oidMoneda,
                                           String descMoneda,
                                           Money cantidad,
                                           Money precio,
                                           String descUM,
                                           java.util.Date fecha) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", ++oid);
    dataset.fieldValue("oid_precio_det", oidPrecioDet);
    dataset.fieldValue("oid_precio_cab", oidPrecioCab);
    dataset.fieldValue("codigo_lp", codigoLP);
    dataset.fieldValue("desc_lp", descLP);
    dataset.fieldValue("oid_um", oidUM);
    dataset.fieldValue("oid_moneda", oidMoneda);
    dataset.fieldValue("desc_moneda", descMoneda);
    dataset.fieldValue("cantidad", cantidad);
    dataset.fieldValue("precio", precio.doubleValue(4));
    dataset.fieldValue("desc_um", descUM);
    if (fecha == null)
    	dataset.fieldValue("fec_ult_act", Fecha.FECHA_NULA());
    else
    	dataset.fieldValue("fec_ult_act", fecha);
  }
}
