package com.srn.erp.ventas.op;

import java.util.Hashtable;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPrecioFactura extends Operation {

  private Hashtable listaCotizaciones = new Hashtable();

  public TraerPrecioFactura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer  oid = mapaDatos.getInteger("oid_producto");
    Integer  oidLP = mapaDatos.getInteger("oid_lp");
    java.util.Date fecEmision = mapaDatos.getDate("fec_emision");
    Integer oidMoneda = mapaDatos.getInteger("oid_moneda");
    
    cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));

    Producto     producto     = Producto.findByOid(oid,getSesion());
    ListaPrecios listaPrecios = ListaPrecios.findByOidProxy(oidLP,getSesion());
    Moneda moneda			  = Moneda.findByOid(oidMoneda,getSesion());

    if (!listaPrecios.isVigenteAFecha(fecEmision))
      throw new ExceptionValidation(null,"La lista de Precios no se encuentra vigente");

    ListaPreciosDet lpDet = producto.getListaPreciosDet(listaPrecios);
    
    IDataSet dsDefPedArt = getDataSetDefPedArt();

    cargarRegistroPrecioProducto(dsDefPedArt,listaPrecios,producto,moneda,lpDet);

    writeCliente(dsDefPedArt);
  }

  private IDataSet getDataSetDefPedArt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPrecioArticulo");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_vta",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_pl",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cantidad",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio_lista",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_bonif1",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio_sugerido",Field.CURRENCY, 0));
    
    return dataset;
  }


  private void cargarRegistroPrecioProducto(IDataSet dataset,
                         ListaPrecios lp,
                         Producto producto,
                         Moneda moneda,
                         ListaPreciosDet listaPreciosDet) throws BaseException {

    if (producto.getUm_vta()==null)
      throw new ExceptionValidation(null,"Falta Definir una unidad de Venta para el producto "+
                                    producto.getCodigo()+" - "+producto.getDescripcion());

    if (lp == null)
      throw new ExceptionValidation(null,"Falta ingresar una lista de Precios");

    if (listaPreciosDet == null)
      throw new ExceptionValidation(null,"Falta definir precio para el producto "+
                                    producto.getCodigo()+" - "+producto.getDescripcion()+
                                    " en la lista de Precios "+ lp.getDescripcion()+" en la unidad de venta "+producto.getUm_vta().getDescripcion());

    dataset.append();
    dataset.fieldValue("oid", 1);
    dataset.fieldValue("oid_um_vta",producto.getUm_vta().getOID());
    dataset.fieldValue("oid_um_pl",listaPreciosDet.getUnidad_medida().getOID());
    dataset.fieldValue("cantidad",listaPreciosDet.getCantidad());
    Money precioLista =
        listaPreciosDet.getPrecio(
           getValorCotizacion(listaPreciosDet.getMoneda()),
           getValorCotizacion(moneda));
    CalculadorMoney calcPrecioUnitario = new CalculadorMoney(precioLista);
    calcPrecioUnitario.dividirPor(new Money(listaPreciosDet.getCantidad().doubleValue()));
    dataset.fieldValue("precio_lista",calcPrecioUnitario.getResultMoney());
    dataset.fieldValue("porc_bonif1",0);
    dataset.fieldValue("precio_sugerido",precioLista);
  }

  private void cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
    dsCotizaciones.first();
    while (!dsCotizaciones.EOF()) {
      listaCotizaciones.put(
         dsCotizaciones.getInteger("oid_moneda"),
         dsCotizaciones.getCotizacion("cotizacion"));
      dsCotizaciones.next();
    }
  }

  private ValorCotizacion getValorCotizacion(Moneda moneda) throws BaseException {
    if (moneda.isMonedaCursoLegal())
      return new ValorCotizacion(1.0);
    ValorCotizacion valorCotizacion = (ValorCotizacion)
        listaCotizaciones.get(moneda.getOIDInteger());
    if (valorCotizacion == null)
      throw new ExceptionValidation(null,
                                    "No se pudo encontrar cotización para la moneda "+
                                    moneda.getDescripcion());
    return valorCotizacion;
  }



}
