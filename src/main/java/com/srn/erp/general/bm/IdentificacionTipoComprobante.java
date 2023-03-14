package com.srn.erp.general.bm;

import java.util.Hashtable;

public class IdentificacionTipoComprobante  {

  private Hashtable listaTiposCompro = new Hashtable();
  public static String COMPRO_FACTURA_CLIENTE    = "FACLI";
  public static String COMPRO_FACTURA_PROVEEDOR  = "FAPRO";
  public static String COMPRO_ND_PROVEEDOR       = "NDPRO";
  public static String COMPRO_NC_PROVEEDOR       = "NCPRO";
  public static String COMPRO_ASIENTO_MANUAL     = "ASIMA";
  public static String COMPRO_ANU_ING_MAN        = "ANUIM";
  public static String APLIC_COMPRO_PROV         = "APLPR";
  public static String APLIC_COMPRO_CLIE         = "APLCL";
  public static String ORDEN_DE_PAGO             = "ORPAG";
  public static String CERT_RET_GAN              = "CERGA";
  public static String CERT_RET_IVA              = "CERIV";
  public static String CERT_RET_IB               = "CERIB";
  public static String PEDIDO_CLIENTE            = "PEDCL";  
  public static String RTO_CLIENTE               = "RTOCL"; 
  public static String AJU_STK                   = "AJUSK";
  public static String COMPRO_ND_CLIENTE         = "NDCLI";
  public static String COMPRO_NC_CLIENTE         = "NCCLI";
  public static String SOLICITUD_COMPRA          = "SOCPR"; 
  public static String SOLICITUD_COTIZ_PROV      = "SOCOP"; 
  public static String COTIZACION_PROVEEDOR      = "COTPR"; 
  public static String ALTA_VALOR_ORIGEN 		 = "AVAOR"; 
  public static String REVA_VALOR_ORIGEN_BU      = "REVVO";
  public static String AMORT_VO					 = "AMOVO";
  public static String REV_AMORT_VO              = "RAMVO";
  public static String AJU_AMORT_MESES_ANT       = "AJAMA";
  public static String AJU_AMORT_EJER_ANT        = "AJAEA";
  public static String ORDEN_DE_COMPRA           = "OCPRA"; 
  public static String INFORME_RECEPCION         = "INREC"; 
  public static String INFORME_CONTRO_CALIDAD    = "INFCC"; 
  public static String ANULADOR_INF_REC          = "ANUIR"; 
  public static String ANULADOR_INF_CC           = "ANUCC";
  public static String ANULADOR_PEDIDO           = "ANUPE";
  public static String REND_FONDO_FIJO           = "RENFF"; 
  public static String RECIBO					 = "RECIB";
  public static String BOLETA_DEPOSITO			 = "BOLDE";
  public static String NOTA_DEBITO_BANCARIA      = "NDBAN";
  public static String NOTA_CREDITO_BANCARIA     = "NCBAN";
  public static String ANULADOR_REMITO_CLI       = "ANRTO";
  public static String ANTICIPO_PROV             = "ANTPR";
  public static String MOTA_DEBITO_PROV_INT      = "NDPIN";
  public static String NOTA_CREDITO_PROV_INT     = "NCPIN";
  public static String COTIZACION_CLIENTE        = "COCLI";
  public static String ANULADOR_COT_CLIENTE      = "ANCOC";
  public static String PAGOS_VARIOS              = "PAGVA";
  public static String ANULADOR_RECIBOS          = "ANREC";
  public static String PAGOS_VARIOS_EFECTIVO     = "PAVAE";
  public static String ANULADOR_PAGOS_VAR_EFECT  = "ANPVE";
  public static String TRANSFERENCIA_VALORES     = "TRAVC";
  public static String ANULADOR_REND_FF          = "ANUFF";
  public static String SUBREPARTO                = "SUBRE";
  public static String ND_INT_CLIENTE						 = "NDICL";
  public static String NC_INT_CLIENTE						 = "NCICL";
  public static String ANULADOR_COMPRO_AJU_STK   = "ANCAS";
  public static String ANULADOR_ASIENTO_MANUAL   = "ANASM";
  public static String INVENTARIO_CAB   = "INVCA";
  public static String ANULADOR_FACTURA   = "ANFAC";
  public static String ANULADOR_SUBREPARTO   = "ANSRE";
  public static String CONCI_BANCO   = "CONBC";
  public static String ASIENTO_CONCI_BANCO   = "ASICB";
  public static String ANULADOR_APLICACION_CLIENTE   = "ANAPC";
  public static String ANULADOR_APLICACION_PROVEEDOR   = "ANAPP";
  public static String CIERRE_EJERCICIO_CONTABLE   = "CIECO";
  public static String ANU_CIERRE_EJERCICIO_CONTABLE   = "ACIEC";
  public static String APE_EJERCICIO_CONTABLE   = "APCCO";
  public static String ANU_APE_EJERCICIO_CONTABLE   = "AAPCC";
  public static String ANU_REQ_COMPRA   = "ANREQ";
  public static String DEVOLUCION_VENTA   = "DEVVT";
  public static String ANULADOR_COMPRO_PROV   = "ANCPR";
  public static String INGRESO_DEVOLUCION_STOCK   = "INDSK";
  public static String ANULADOR_DEVOLUCION_VTA   = "ANDVT";
  public static String ANULADOR_INGRESO_DEVOLUCION_STOCK   = "ANIDS";
  public static String TRANSFERENCIAS_INTERNAS_STOCK   = "TRISK";
  public static String PEDIDO_PRODUCTO_A_DEPOSITO   = "PPDEP";
  public static String ANULADOR_ORDEN_DE_PAGO   = "ANUOP";
  public static String ANULADOR_NC_CLIENTE   = "ANNCC";
  public static String ANULADOR_TRANSFERENCIAS_INTERNAS_STOCK   = "ATISK";
  public static String ORDEN_DE_FABRICACION   = "ORDFA";
  public static String LIQUIDACION_TAR_CREDITO   = "LIQTC";
  public static String LIQUIDACION_TAR_DEBITO   = "LIQTD";
  

  public IdentificacionTipoComprobante() {
    listaTiposCompro.put(COMPRO_FACTURA_CLIENTE,"Factura Cliente");
    listaTiposCompro.put(COMPRO_FACTURA_PROVEEDOR,"Factura Proveedor");
    listaTiposCompro.put(COMPRO_ND_PROVEEDOR,"Nota de Débito Proveedor");
    listaTiposCompro.put(COMPRO_NC_PROVEEDOR,"Nota de Crédito Proveedor");
    listaTiposCompro.put(COMPRO_ASIENTO_MANUAL,"Asiento Manual");
    listaTiposCompro.put(COMPRO_ANU_ING_MAN,"Anulación Ingreso Manual");
    listaTiposCompro.put(APLIC_COMPRO_PROV,"Aplicación Comprobante Proveedor");
    listaTiposCompro.put(ORDEN_DE_PAGO,"Orden de Pago");
    listaTiposCompro.put(CERT_RET_GAN, "Certificado Retención Ganancias");
    listaTiposCompro.put(CERT_RET_IB, "Certificado Retención IB");
    listaTiposCompro.put(CERT_RET_IVA, "Certificado Retención IVA");
    listaTiposCompro.put(PEDIDO_CLIENTE,"Pedido Cliente");
    listaTiposCompro.put(RTO_CLIENTE,"Remito Cliente");
    listaTiposCompro.put(AJU_STK,"Ajuste Stock");
    listaTiposCompro.put(SOLICITUD_COMPRA,"Solicitud de Compra");
    listaTiposCompro.put(SOLICITUD_COTIZ_PROV,"Solicitud Cotización Proveedores");
    listaTiposCompro.put(COTIZACION_PROVEEDOR,"Cotización Proveedor");
    listaTiposCompro.put(ALTA_VALOR_ORIGEN,"Alta Valor Origen");
    listaTiposCompro.put(REVA_VALOR_ORIGEN_BU,"Revalúo Valor Origen Bien de Uso");    
    listaTiposCompro.put(AMORT_VO,"Amortización Valor Origen");
    listaTiposCompro.put(REV_AMORT_VO,"Revalúo Amortización Valor Origen");
    listaTiposCompro.put(AJU_AMORT_MESES_ANT,"Ajuste Amort. Meses Anteriores");
    listaTiposCompro.put(AJU_AMORT_EJER_ANT, "Ajuste Amort. Ejer. Ant");
    listaTiposCompro.put(INFORME_RECEPCION,"Informe de Recepción");
    listaTiposCompro.put(ORDEN_DE_COMPRA,"Orden de Compra");
    listaTiposCompro.put(ANTICIPO_PROV,"Anticipo Proveedor");
    listaTiposCompro.put(INFORME_CONTRO_CALIDAD,"Informe de Control de Calidad");
    listaTiposCompro.put(ANULADOR_INF_REC,"Anulador Informe de Recepción");
    listaTiposCompro.put(ANULADOR_INF_CC,"Anulador Informe Control de Calidad");
    listaTiposCompro.put(ANULADOR_PEDIDO,"Anulador Pedido");
    listaTiposCompro.put(REND_FONDO_FIJO,"Rendición de Fondo Fijo");
    listaTiposCompro.put(COMPRO_ND_CLIENTE,"Nota de Débito Cliente");
    listaTiposCompro.put(COMPRO_NC_CLIENTE,"Nota de Crédito Cliente");
    listaTiposCompro.put(APLIC_COMPRO_CLIE,"Aplicación Comprobante Cliente");
    listaTiposCompro.put(RECIBO, "Recibo Cliente");
    listaTiposCompro.put(BOLETA_DEPOSITO,"Boleta de Depósito");
    listaTiposCompro.put(NOTA_DEBITO_BANCARIA,"Nota Debito Bancaria");
    listaTiposCompro.put(NOTA_CREDITO_BANCARIA,"Nota Credito Bancaria");
    listaTiposCompro.put(ANULADOR_REMITO_CLI,"Anulador Remito");
    listaTiposCompro.put(ANTICIPO_PROV,"Anticipo Proveedor");
    listaTiposCompro.put(MOTA_DEBITO_PROV_INT,"Nota de Debito Proveedor Interna");
    listaTiposCompro.put(NOTA_CREDITO_PROV_INT,"Nota de Crédito Proveedor Interna");
    listaTiposCompro.put(COTIZACION_CLIENTE,"Cotización Cliente");
    listaTiposCompro.put(ANULADOR_COT_CLIENTE,"Anulador Cotización Cliente");
    listaTiposCompro.put(PAGOS_VARIOS,"Pagos Varios");
    listaTiposCompro.put(ANULADOR_RECIBOS,"Anulador Recibos");
    listaTiposCompro.put(PAGOS_VARIOS_EFECTIVO,"Pagos Varios Efectivo");
    listaTiposCompro.put(ANULADOR_PAGOS_VAR_EFECT,"Anulador Pagos Varios Efectivo");
    listaTiposCompro.put(TRANSFERENCIA_VALORES,"Transferencias de Valores Entre Cajas");
    listaTiposCompro.put(ANULADOR_REND_FF,"Anulador Rendición Fondo Fijo");
    listaTiposCompro.put(ND_INT_CLIENTE,"Nota Debito Interno Cliente");
    listaTiposCompro.put(NC_INT_CLIENTE,"Nota Credito Interno Cliente");
    listaTiposCompro.put(ANULADOR_COMPRO_AJU_STK,"Anulador Comprobante Ajuste de Stock");
    listaTiposCompro.put(ANULADOR_ASIENTO_MANUAL,"Anulador Asiento Manual");
    listaTiposCompro.put(INVENTARIO_CAB,"Inventario");
    listaTiposCompro.put(ANULADOR_FACTURA,"Anulador Factura");
    listaTiposCompro.put(SUBREPARTO,"Subreparto");
    listaTiposCompro.put(ANULADOR_SUBREPARTO,"Anulador SubReparto");
    listaTiposCompro.put(CONCI_BANCO,"Conciliación Banco");
    listaTiposCompro.put(ASIENTO_CONCI_BANCO,"Asiento Conciliación Banco");
    listaTiposCompro.put(ANULADOR_APLICACION_CLIENTE,"Anulador Aplicación Cliente");
    listaTiposCompro.put(ANULADOR_APLICACION_PROVEEDOR,"Anulador Aplicación Proveedor");
    listaTiposCompro.put(CIERRE_EJERCICIO_CONTABLE,"Cierre Ejercicio Contable");
    listaTiposCompro.put(ANU_CIERRE_EJERCICIO_CONTABLE,"Anulador Cierre Ejercicio Contable");
    listaTiposCompro.put(APE_EJERCICIO_CONTABLE,"Asiento Apertura Ejercicio ");
    listaTiposCompro.put(ANU_APE_EJERCICIO_CONTABLE , "Anulador Asiento Apertura Ejercicio");
    listaTiposCompro.put(ANU_REQ_COMPRA,"Anulador Requisición de Compras");
    listaTiposCompro.put(DEVOLUCION_VENTA,"Devolución Venta");
    listaTiposCompro.put(ANULADOR_COMPRO_PROV,"Anulador Comprobante Proveedor");
    listaTiposCompro.put(INGRESO_DEVOLUCION_STOCK,"Ingreso Devolución en Stock");
    listaTiposCompro.put(ANULADOR_DEVOLUCION_VTA,"Anulador Ingreso de Devolución");
    listaTiposCompro.put(ANULADOR_INGRESO_DEVOLUCION_STOCK,"Anulador Ingreso Devolución en Stock");
    listaTiposCompro.put(TRANSFERENCIAS_INTERNAS_STOCK,"Transferencias Internas Stock");
    listaTiposCompro.put(PEDIDO_PRODUCTO_A_DEPOSITO,"Pedido producto a Depósito");
    listaTiposCompro.put(ANULADOR_ORDEN_DE_PAGO,"Anulador Orden de Pago");
    listaTiposCompro.put(ANULADOR_NC_CLIENTE,"Anulador Nota de Crédito Cliente");
    listaTiposCompro.put(ANULADOR_TRANSFERENCIAS_INTERNAS_STOCK,"Anulador Transferencias Internas Stock");
    listaTiposCompro.put(ORDEN_DE_FABRICACION,"Orden de Fabricación");
    listaTiposCompro.put(LIQUIDACION_TAR_CREDITO,"Liquidación Tarjeta de Crédito");
    listaTiposCompro.put(LIQUIDACION_TAR_DEBITO,"Liquidación Tarjeta de Débito");
  }

  public Hashtable getListaComportamientosCompro() {
    return listaTiposCompro;
  }

  public static boolean esFactProv(String identificador) {
    return identificador.equals(COMPRO_FACTURA_PROVEEDOR);
  }

  public static boolean esFactCliente(String identificador) {
  	return identificador.equals(COMPRO_FACTURA_CLIENTE);
  }
  
  public static boolean esRemitoCliente(String identificador) {
  	return identificador.equals(RTO_CLIENTE);
  }
  
  
  public static boolean esNDProv(String identificador) {
    return identificador.equals(COMPRO_ND_PROVEEDOR);
  }

  public static boolean esNCProv(String identificador) {
    return identificador.equals(COMPRO_NC_PROVEEDOR);
  }

  public static boolean esSolicitudCotizProv(String identificador) {
	    return identificador.equals(SOLICITUD_COTIZ_PROV);
  }
  
  public static boolean esReciboCliente(String identificador) {
	return identificador.equals(RECIBO);
  }
  
  public static boolean esCotizacionProveedor(String identificador) {
	  return identificador.equals(COTIZACION_PROVEEDOR);
  }	  
  
  public static boolean esRevaluoValorOrigenBienUso(String identificador) {
	  return identificador.equals(REVA_VALOR_ORIGEN_BU);
  }

  public static boolean esAmortValorOrigen(String identificador) {
	  return identificador.equals(AMORT_VO);
  }
  
  public static boolean esRevAmortValorOrigen(String identificador) {
	  return identificador.equals(REV_AMORT_VO);
  }  
  
  public static boolean esAjuAmortMesesAnt(String identificador) {
	  return identificador.equals(AJU_AMORT_MESES_ANT);
  }  
  
  public static boolean esAjuAmortEjerAnt(String identificador) {
	  return identificador.equals(AJU_AMORT_EJER_ANT);
  }  
  
  public static boolean esOrdenDeCompra(String identificador) {
	  return identificador.equals(ORDEN_DE_COMPRA);
  }
  
  public static boolean esNotaDebitoCliente(String identificador) {
	  return identificador.equals(COMPRO_ND_CLIENTE);
  }
  
  public static boolean esNotaCreditoCliente(String identificador) {
	  return identificador.equals(COMPRO_NC_CLIENTE);
  }
  
  public static boolean esRecibo(String identificador) {
	  return identificador.equals(RECIBO);
  }
  
  
  public static boolean esAplicacionComproCliente(String identificador) {
	  return identificador.equals(APLIC_COMPRO_CLIE);
  } 
  
  public static boolean esAnticipoProveedor(String identificador)  {
  	return identificador.equals(ANTICIPO_PROV);
  }
  
  public static boolean esNotaDebitoInternoProveedor(String identificador)  {
  	return identificador.equals(MOTA_DEBITO_PROV_INT);
  }
  
  public static boolean esNotaCreditoInternoProveedor(String identificador)  {
  	return identificador.equals(NOTA_CREDITO_PROV_INT);
  }
  
  public static boolean esPagosVarios(String identificador)  {
  	return identificador.equals(PAGOS_VARIOS);
  }
  
  public static boolean esOrdenDePago(String identificador)  {
  	return identificador.equals(ORDEN_DE_PAGO);
  }
  
  public static boolean esPagosVariosEfectivo(String identificador)  {
  	return identificador.equals(PAGOS_VARIOS_EFECTIVO);
  }
  
  public static boolean esNotaDebitoInternaCliente(String identificador)  {
  	return identificador.equals(ND_INT_CLIENTE);
  }
  
  public static boolean esAsientoDeApertura(String identificador)  {
	  	return identificador.equals(APE_EJERCICIO_CONTABLE);
  }
  
  public static boolean esInformeRecepcion(String identificador)  {
	  	return identificador.equals(INFORME_RECEPCION);
  }
  
  
  public static boolean esAsientoCierre(String identificador)  {
	  	return identificador.equals(CIERRE_EJERCICIO_CONTABLE);
}  
  
  
  public static boolean esNotaCreditoInternaCliente(String identificador)  {
  	return identificador.equals(NC_INT_CLIENTE);
  }
  
  public static boolean esPedidoCliente(String identificador)  {
	  	return identificador.equals(PEDIDO_CLIENTE);
  }
  
  
  
  
}
