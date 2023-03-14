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
import com.srn.erp.ventas.bm.NotaDebitoClieCab;
import com.srn.erp.ventas.bm.NotaDebitoClieDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveNDFinanClie extends Operation {
	
  NotaDebitoClieCab ndClie = null;	
  HashTableDatos listaCotiz = null;

  public SaveNDFinanClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
    IDataSet dataset = mapaDatos.getDataSet("TFacturaCab");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
      dataset.first();
      while (!dataset.EOF()) {
    	ndClie = (NotaDebitoClieCab)NotaDebitoClieCab.findByOid(dataset.getInteger("oid_cco"),getSesion());
    	
    	// Datos principales de la cabecera
    	Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
    	ndClie.addCotizacionesMonedas(listaCotiz);
    	ndClie.setTalonario(talonario);
    	ndClie.setContabiliza(true);
    	ndClie.setEmision(dataset.getDate("fec_emision"));
    	ndClie.setImputac(dataset.getDate("fec_emision"));
    	ndClie.setTipoCompro(talonario.getTipo_comprobante());
    	ndClie.setLetra(talonario.getLetra());
    	ndClie.setLugarEmision(talonario.getLugar_emision());
    	ndClie.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	ndClie.setComentario(dataset.getString("comentario"));
    	ndClie.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
    	ndClie.setCotizacion(dataset.getCotizacion("cotizacion"));
    	ndClie.setTipoCtaCteClie(TipoCtaCteClie.getTipoCtaCteClie(getSesion()));
    	Sujeto sujeto = Sujeto.findByOidProxy(dataset.getInteger("oid_cliente"),getSesion());
    	ndClie.setSujeto(sujeto);
    	Sucursal sucursal = Sucursal.findByOid(getSesion().getLogin().getOidSucursal(),getSesion());
    	ndClie.setSucursal(sucursal);
    	ndClie.setMotivoComprobante(MotivoComprobante.findByOidProxy(dataset.getInteger("oid_motivo_compro"),getSesion()));
    	
    	// Otros datos principales
    	ndClie.setTipo_oper(dataset.getString("tipo_oper_factu"));
    	ndClie.setTipo_cliente(dataset.getString("tipo_cliente"));
    	ndClie.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),getSesion()));
    	ndClie.setFec_caja(dataset.getDate("fec_caja"));
    	ndClie.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_bonif_cli").doubleValue()));
    	ndClie.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_reca_cli").doubleValue()));
    	ndClie.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_lp"),getSesion()));
    	ndClie.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
    	ndClie.setVendedor(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"),getSesion()));
    	ndClie.setCond_pago(CondicionPago.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
    	ndClie.setCompo_stk_fact(CompoStkTalonarioFactClie.findByOidProxy(dataset.getInteger("oid_compo_stk_fac"),getSesion()));
    	if (dataset.getPorcentaje("porc_bonif_fp")!=null)
    		ndClie.setPorc_bonif_cp(new Double(dataset.getPorcentaje("porc_bonif_fp").doubleValue()));
    	else
    		ndClie.setPorc_bonif_cp(new Double(0));
    	if (dataset.getPorcentaje("porc_recar_fp")!=null)
    		ndClie.setPorc_recar_cp(new Double(dataset.getPorcentaje("porc_recar_fp").doubleValue()));
    	else
    		ndClie.setPorc_recar_cp(new Double(0));
    	ndClie.setFec_base(dataset.getDate("fec_emision"));
    	ndClie.setSujeto_impositivo(sujeto.getSujeto_impositivo());
    	ndClie.setSigno(new Integer(FacturaCab.SIGNO_NOTA_DEBITO));
    	
    	// En moneda Origen
    	ndClie.setBruto(dataset.getMoney("total_bruto"));
    	ndClie.setPorc_dto(dataset.getPorcentaje("porc_dto"));
    	ndClie.setDescuento(dataset.getMoney("descuento"));
    	ndClie.setPorc_recar(dataset.getPorcentaje("porc_recar"));
    	ndClie.setRecargo(dataset.getMoney("recargo"));
    	ndClie.setNeto(dataset.getMoney("total_neto"));
    	ndClie.setNetoGravado(dataset.getMoney("neto_gravado"));
    	ndClie.setNetoNoGravado(dataset.getMoney("neto_no_gravado"));
    	ndClie.setIva(dataset.getMoney("iva"));
    	ndClie.setPerc_iva(dataset.getMoney("perc_iva"));
    	ndClie.setImp_internos(dataset.getMoney("imp_internos"));
    	ndClie.setPerc_ib(dataset.getMoney("perc_ib"));
    	ndClie.setTotal(dataset.getMoney("total_total"));
    	
    	ndClie.setConcImpIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva"),getSesion()));
    	ndClie.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_iva"),getSesion()));
    	ndClie.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_ib"),getSesion()));
    	ndClie.setConcImpInt(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_int"),getSesion()));
    	
    	
    	// Asignar los campos correspondientes a la Impresion o Visualizacion
    	ndClie.setImpre_bruto(dataset.getMoney("impre_bruto"));
    	ndClie.setImprePorcBonif(dataset.getMoney("impre_porc_dto"));
    	ndClie.setImpre_bonif(dataset.getMoney("impre_descuento"));
    	ndClie.setImprePorcRecar(dataset.getMoney("impre_porc_recar"));
    	ndClie.setImpre_recar(dataset.getMoney("impre_recargo"));
    	ndClie.setImpre_neto(dataset.getMoney("impre_neto"));
    	ndClie.setImpre_iva(dataset.getMoney("impre_iva"));
    	ndClie.setImpre_perc_iva(dataset.getMoney("impre_perc_iva"));
    	ndClie.setImpre_imp_int(dataset.getMoney("impre_imp_internos"));
    	ndClie.setImpre_perc_ib(dataset.getMoney("impre_perc_ib"));
    	ndClie.setImpre_total(dataset.getMoney("impre_total"));
    	
    	// Traer Detalles de las Facturas
    	IDataSet dsFacturaDet = dataset.getDataSet("TFacturaDet");
    	dsFacturaDet.first();
    	while (!dsFacturaDet.EOF()) {
    		NotaDebitoClieDet ndClieDet = (NotaDebitoClieDet)ndClie.addDetalle();
    		ndClieDet.setProducto(Producto.findByOidProxy(dsFacturaDet.getInteger("oid_art"),getSesion()));
    		ndClieDet.setCantidad(dsFacturaDet.getDouble("cantidad"));
    		ndClieDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsFacturaDet.getInteger("oid_uni_med"),getSesion()));
    		ndClieDet.setPrecio_lista(dsFacturaDet.getMoney("precio_factura"));
    		ndClieDet.setPrecio_sugerido(dsFacturaDet.getMoney("precio_factura"));
    		ndClieDet.setPrecio_ingresado(dsFacturaDet.getMoney("precio_factura"));
    		ndClieDet.setPorc_bonif_1(dsFacturaDet.getPorcentaje("porc_bonif_1"));
    		ndClieDet.setPorc_bonif_2(dsFacturaDet.getPorcentaje("porc_bonif_2"));
    		ndClieDet.setPorc_bonif_3(dsFacturaDet.getPorcentaje("porc_bonif_3"));
    		ndClieDet.setPrecio_bonificado(dsFacturaDet.getMoney("precio_bonif"));
    		ndClieDet.setImporte(dsFacturaDet.getMoney("importe"));
    		ndClieDet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_iva"),getSesion()));
    		ndClieDet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_iva"),getSesion()));
    		ndClieDet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_ib"),getSesion()));
    		ndClieDet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_int"),getSesion()));
    		dsFacturaDet.next();
    	}
    	
    	addTransaccion(ndClie);
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
