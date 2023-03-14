package com.srn.erp.ventas.op;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.NotaCreditoClieCab;
import com.srn.erp.ventas.bm.NotaCreditoClieDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveNCFinanClie extends Operation {
	
  NotaCreditoClieCab ncClie = null;	
  HashTableDatos listaCotiz = null;

  public SaveNCFinanClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
    IDataSet dataset = mapaDatos.getDataSet("TFacturaCab");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
      dataset.first();
      while (!dataset.EOF()) {
    	ncClie = (NotaCreditoClieCab)NotaCreditoClieCab.findByOid(dataset.getInteger("oid_cco"),getSesion());
    	
    	// Datos principales de la cabecera
    	Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
    	ncClie.addCotizacionesMonedas(listaCotiz);
    	ncClie.setTalonario(talonario);
    	ncClie.setContabiliza(true);
    	ncClie.setEmision(dataset.getDate("fec_emision"));
    	ncClie.setImputac(dataset.getDate("fec_emision"));
    	ncClie.setTipoCompro(talonario.getTipo_comprobante());
    	ncClie.setLetra(talonario.getLetra());
    	ncClie.setLugarEmision(talonario.getLugar_emision());
    	ncClie.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	ncClie.setComentario(dataset.getString("comentario"));
    	ncClie.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
    	ncClie.setCotizacion(dataset.getCotizacion("cotizacion"));
    	ncClie.setTipoCtaCteClie(TipoCtaCteClie.getTipoCtaCteClie(getSesion()));
    	Sujeto sujeto = Sujeto.findByOidProxy(dataset.getInteger("oid_cliente"),getSesion());
    	ncClie.setSujeto(sujeto);
    	Sucursal sucursal = Sucursal.findByOid(getSesion().getLogin().getOidSucursal(),getSesion());
    	ncClie.setSucursal(sucursal);
    	ncClie.setMotivoComprobante(MotivoComprobante.findByOidProxy(dataset.getInteger("oid_motivo_compro"),getSesion()));
    	
    	// Otros datos principales
    	ncClie.setTipo_oper(dataset.getString("tipo_oper_factu"));
    	ncClie.setTipo_cliente(dataset.getString("tipo_cliente"));
    	ncClie.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),getSesion()));
    	ncClie.setFec_caja(dataset.getDate("fec_caja"));
    	ncClie.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_bonif_cli").doubleValue()));
    	ncClie.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_reca_cli").doubleValue()));
    	ncClie.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_lp"),getSesion()));
    	ncClie.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
    	ncClie.setVendedor(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"),getSesion()));
    	ncClie.setCond_pago(CondicionPago.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
    	ncClie.setCompo_stk_fact(CompoStkTalonarioFactClie.findByOidProxy(dataset.getInteger("oid_compo_stk_fac"),getSesion()));
    	if (dataset.getPorcentaje("porc_bonif_fp")!=null)
    		ncClie.setPorc_bonif_cp(new Double(dataset.getPorcentaje("porc_bonif_fp").doubleValue()));
    	else
    		ncClie.setPorc_bonif_cp(new Double(0));
    	if (dataset.getPorcentaje("porc_recar_fp")!=null)
    		ncClie.setPorc_recar_cp(new Double(dataset.getPorcentaje("porc_recar_fp").doubleValue()));
    	else
    		ncClie.setPorc_recar_cp(new Double(0));
    	ncClie.setFec_base(dataset.getDate("fec_emision"));
    	ncClie.setSujeto_impositivo(sujeto.getSujeto_impositivo());
    	ncClie.setSigno(new Integer(FacturaCab.SIGNO_NOTA_DEBITO));
    	
    	// En moneda Origen
    	ncClie.setBruto(dataset.getMoney("total_bruto"));
    	ncClie.setPorc_dto(dataset.getPorcentaje("porc_dto"));
    	ncClie.setDescuento(dataset.getMoney("descuento"));
    	ncClie.setPorc_recar(dataset.getPorcentaje("porc_recar"));
    	ncClie.setRecargo(dataset.getMoney("recargo"));
    	ncClie.setNeto(dataset.getMoney("total_neto"));
    	ncClie.setNetoGravado(dataset.getMoney("neto_gravado"));
    	ncClie.setNetoNoGravado(dataset.getMoney("neto_no_gravado"));
    	ncClie.setIva(dataset.getMoney("iva"));
    	ncClie.setPerc_iva(dataset.getMoney("perc_iva"));
    	ncClie.setImp_internos(dataset.getMoney("imp_internos"));
    	ncClie.setPerc_ib(dataset.getMoney("perc_ib"));
    	ncClie.setTotal(dataset.getMoney("total_total"));
    	
    	ncClie.setConcImpIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva"),getSesion()));
    	ncClie.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_iva"),getSesion()));
    	ncClie.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_ib"),getSesion()));
    	ncClie.setConcImpInt(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_int"),getSesion()));
    	
    	
    	// Asignar los campos correspondientes a la Impresion o Visualizacion
    	ncClie.setImpre_bruto(dataset.getMoney("impre_bruto"));
    	ncClie.setImprePorcBonif(dataset.getMoney("impre_porc_dto"));
    	ncClie.setImpre_bonif(dataset.getMoney("impre_descuento"));
    	ncClie.setImprePorcRecar(dataset.getMoney("impre_porc_recar"));
    	ncClie.setImpre_recar(dataset.getMoney("impre_recargo"));
    	ncClie.setImpre_neto(dataset.getMoney("impre_neto"));
    	ncClie.setImpre_iva(dataset.getMoney("impre_iva"));
    	ncClie.setImpre_perc_iva(dataset.getMoney("impre_perc_iva"));
    	ncClie.setImpre_imp_int(dataset.getMoney("impre_imp_internos"));
    	ncClie.setImpre_perc_ib(dataset.getMoney("impre_perc_ib"));
    	ncClie.setImpre_total(dataset.getMoney("impre_total"));
    	
    	// Traer Detalles de las Facturas
    	IDataSet dsFacturaDet = dataset.getDataSet("TFacturaDet");
    	dsFacturaDet.first();
    	while (!dsFacturaDet.EOF()) {
    		NotaCreditoClieDet ncClieDet = (NotaCreditoClieDet)ncClie.addDetalle();
    		ncClieDet.setProducto(Producto.findByOidProxy(dsFacturaDet.getInteger("oid_art"),getSesion()));
    		ncClieDet.setCantidad(dsFacturaDet.getDouble("cantidad"));
    		ncClieDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsFacturaDet.getInteger("oid_uni_med"),getSesion()));
    		ncClieDet.setPrecio_lista(dsFacturaDet.getMoney("precio_factura"));
    		ncClieDet.setPrecio_sugerido(dsFacturaDet.getMoney("precio_factura"));
    		ncClieDet.setPrecio_ingresado(dsFacturaDet.getMoney("precio_factura"));
    		ncClieDet.setPorc_bonif_1(dsFacturaDet.getPorcentaje("porc_bonif_1"));
    		ncClieDet.setPorc_bonif_2(dsFacturaDet.getPorcentaje("porc_bonif_2"));
    		ncClieDet.setPorc_bonif_3(dsFacturaDet.getPorcentaje("porc_bonif_3"));
    		ncClieDet.setPrecio_bonificado(dsFacturaDet.getMoney("precio_bonif"));
    		ncClieDet.setImporte(dsFacturaDet.getMoney("importe"));
    		ncClieDet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_iva"),getSesion()));
    		ncClieDet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_iva"),getSesion()));
    		ncClieDet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_ib"),getSesion()));
    		ncClieDet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_int"),getSesion()));
    		dsFacturaDet.next();
    	}
    	
    	addTransaccion(ncClie);
        dataset.next();
    }
  }
  
  private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones) throws BaseException {
	  HashTableDatos listaCotizaciones = new HashTableDatos();
	  dsCotizaciones.first();
	  while (!dsCotizaciones.EOF()) {
		  Moneda moneda              = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"),getSesion());
		  ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
		  listaCotizaciones.put(moneda,valorCotiz);
		  dsCotizaciones.next();
	  }
	  return listaCotizaciones;
  }
  

}
