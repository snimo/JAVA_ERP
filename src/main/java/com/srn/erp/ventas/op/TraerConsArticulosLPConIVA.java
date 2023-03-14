package com.srn.erp.ventas.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsArticulosLPConIVA extends Operation {

	private ClasificadorEntidad clasifEnt = null;
	
  public TraerConsArticulosLPConIVA() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet ds = getArticulosEnLP();
  	ListaPrecios listaPrecios = ListaPrecios.findByOidProxy(mapaDatos.getInteger("oid_lp"),this.getSesion());
  	if (mapaDatos.containsKey("oid_clasificador"))
  	  	clasifEnt = ClasificadorEntidad.findByOidProxy(mapaDatos.getInteger("oid_clasificador"),this.getSesion());
  	Iterator iterDetallesLista =  listaPrecios.getDetallesPreciosProductos().iterator();
  	while (iterDetallesLista.hasNext()) {
  		ListaPreciosDet listaPreciosDet = (ListaPreciosDet) iterDetallesLista.next();
  		cargarRegistro(ds,Fecha.getFechaActual(),listaPreciosDet);
  	}  	
    writeCliente(ds);
  }

  private IDataSet getArticulosEnLP() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProductosListaDePrecio");
    dataset.fieldDef(new Field("clasificador", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("iva", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impu_internos", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio_cons_final", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("simbolo", Field.STRING, 5));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              Date fecha,ListaPreciosDet listaPreciosDet) throws BaseException {
    dataset.append();
    if (clasifEnt == null)
    	dataset.fieldValue("clasificador", "");
    else {
    	IValorClasificadorEntidad valorClasif = listaPreciosDet.getProducto().getValorClasifEnt(clasifEnt);
    	if (valorClasif!=null)
    		dataset.fieldValue("clasificador", valorClasif.getDescripcion());
    	else
    		dataset.fieldValue("clasificador", "Sin Clasificar");
    }  
    dataset.fieldValue("oid_producto",  listaPreciosDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto",  listaPreciosDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", listaPreciosDet.getProducto().getDescripcion());
    dataset.fieldValue("precio_lista",  listaPreciosDet.getPrecio());
    dataset.fieldValue("iva",listaPreciosDet.getProducto().getCalcularIVA(Fecha.getFechaActual(),listaPreciosDet.getPrecio()));
    dataset.fieldValue("impu_internos",listaPreciosDet.getProducto().getCalcImpuInterno(Fecha.getFechaActual(),listaPreciosDet.getPrecio()));
    dataset.fieldValue("precio_cons_final",listaPreciosDet.getProducto().getPrecioConsumidorFinal(Fecha.getFechaActual(),listaPreciosDet.getPrecio()));
    dataset.fieldValue("simbolo",listaPreciosDet.getMoneda().getSimbolo());
  }
}
