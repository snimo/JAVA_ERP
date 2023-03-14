package com.srn.erp.general.bm;

import java.util.Hashtable;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;
import com.srn.erp.costos.bm.CentroCostos;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Utils.BaseException;

public class TiposEntidades  {

  private Hashtable entidades = new Hashtable();
  private Hashtable entidadesComprobantes = new Hashtable();

  public TiposEntidades() {

	entidades.put(Sujeto.NICKNAME,"Cliente");
    entidades.put(Proveedor.NICKNAME,"Proveedor");
    entidades.put(Producto.NICKNAME,"Producto");
    entidades.put(CuentaBancaria.NICKNAME,"Cuenta Bancaria");
    entidades.put(ComproProveedor.NICKNAME,"Comprobante Proveedor");
    entidades.put(TipoCtaCteProv.NICKNAME,"Tipo de Cuenta Corriente Proveedor");
    entidades.put(FacturaCab.NICKNAME,"Factura Venta Cliente");
    entidades.put(FacturaDet.NICKNAME,"Factura Venta Cliente Detalle");
    entidades.put(Sucursal.NICKNAME,"Sucursal");
    entidades.put(PedidoCab.NICKNAME,"Pedido");
    entidades.put(RemitoCab.NICKNAME,"Remito");
    entidades.put(Recibo.NICKNAME,"Recibo");
    entidades.put(ValorClasificadorEntidad.NICKNAME,"Valor de Clasificador");
    entidades.put(OrdenDeCompraCab.NICKNAME, "Orden de compra");
    entidades.put(CotizacionCab.NICKNAME, "Presupuesto Clientes");
    entidades.put(ComproOrdenPagoCab.NICKNAME,"Orden de Pago");
    entidades.put(ExtensionProdGen.NICKNAME,"Extensión Producto General");
    entidades.put(CentroCostos.NICKNAME,"Centro de Costos");
    entidades.put(Proyecto.NICKNAME,"Proyectos");
    entidades.put(Legajo.NICKNAME,"Legajos");
    entidades.put(RequisicionCab.NICKNAME,"Requisición");
    entidades.put(SolicitudCotizProvCab.NICKNAME,"Sol. Cotiz. Proveedor");
    
    
    // Traer las Entidades correspondientes a comprobantes
    entidadesComprobantes.put(ComproProveedor.NICKNAME,"Comprobante Proveedor");
    entidadesComprobantes.put(FacturaCab.NICKNAME,"Factura Venta Cliente");
    entidadesComprobantes.put(Recibo.NICKNAME,"Recibo");
    entidadesComprobantes.put(FacturaDet.NICKNAME,"Factura Venta Cliente Detalle");
    entidadesComprobantes.put(ComproOrdenPagoCab.NICKNAME,"Orden de Pago");
    entidadesComprobantes.put(SolicitudCotizProvCab.NICKNAME,"Sol. Cotiz. Proveedor");
    
    
  }

  public Hashtable getEntidades() throws BaseException {
    return entidades;
  }
  
  public Hashtable getEntidadesComprobantes() throws BaseException {
	return entidadesComprobantes;
  }
  
  public String getDescripcion(String codigo) throws BaseException {
	  return (String)entidades.get(codigo);
  }

}
