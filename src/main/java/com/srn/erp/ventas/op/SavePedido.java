package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.FormaEntrega;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ObsCodifPedidoCab;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePedido extends Operation {

  PedidoCab pedidocab = null;

  public SavePedido() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPedidoCab");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        pedidocab = PedidoCab.findByOid(dataset.getInteger("oid_cco_ped"),getSesion());
        Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
        pedidocab.setTalonario(talonario);
        pedidocab.setContabiliza(false);
        pedidocab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        pedidocab.setLetra(ComproCab.getLetraDefault(getSesion()));
        pedidocab.setOrdenDeCompra(dataset.getString("orden_compra"));
        if (talonario.getLugar_emision()!=null)
        	pedidocab.setLugarEmision(talonario.getLugar_emision());
        else
        	pedidocab.setLugarEmision(ComproCab.getLugEmiDafault(getSesion()));
        pedidocab.setEmision(dataset.getDate("fec_emision"));
        pedidocab.setComentario(dataset.getString("comentario"));
        pedidocab.setContactoSujeto(ContactoSujeto.findByOidProxy(dataset.getInteger("oid_contacto"),getSesion()));
        pedidocab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        pedidocab.setCotizacion(dataset.getCotizacion("cotizacion"));
        pedidocab.setCotizMonFact(dataset.getCotizacion("cotiz_mon_fact"));
        pedidocab.setSujeto(Sujeto.findByOidProxy(dataset.getInteger("oid_cliente"),getSesion()));
        pedidocab.setMercado(dataset.getString("mercado"));
        pedidocab.setPorc_bonif_cli(dataset.getDouble("porc_bonif_cli"));
        pedidocab.setPorc_reca_cli(dataset.getDouble("porc_reca_cli"));
        pedidocab.setBonif_cli_cascada(dataset.getBoolean("bonif_cli_cascada"));
        pedidocab.setReca_cli_cascada(dataset.getBoolean("reca_cli_cascada"));
        pedidocab.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_precio_cab"),getSesion()));
        pedidocab.setCondicionPago(CondicionPago.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
        pedidocab.setVendedor(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"),getSesion()));
        pedidocab.setDomicilio_entrega(UnidadEdilicia.findByOidProxy(dataset.getInteger("oid_uni_edi"),getSesion()));
        pedidocab.setProyecto(Proyecto.findByOidProxy(dataset.getInteger("oid_proyecto"),getSesion()));
        pedidocab.setPorc_bonif_cp(dataset.getDouble("porc_bonif_cp"));
        pedidocab.setPorc_reca_cp(dataset.getDouble("porc_reca_cp"));
        pedidocab.setBonif_cp_cascada(dataset.getBoolean("bonif_cp_cascada"));
        pedidocab.setReca_cp_cascada(dataset.getBoolean("reca_cp_cascada"));
        pedidocab.setObservado(dataset.getBoolean("observado"));
        pedidocab.setComporCotizFact(dataset.getString("compor_cotiz_fact"));
        
        
        if ((!pedidocab.isNew() && (pedidocab.isActivo().booleanValue() && dataset.getBoolean("activo").booleanValue()==false)))
        	pedidocab.delete();
        
        pedidocab.setActivo(dataset.getBoolean("activo"));
        
        pedidocab.setTransporte(Transporte.findByOidProxy(dataset.getInteger("oid_transporte"),getSesion()));
        pedidocab.setMonedaFact(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_fact"),getSesion()));
        pedidocab.setFormaEntrega(FormaEntrega.findByOidProxy(dataset.getInteger("oid_forma_entrega"),getSesion()));
        
        // Totales
      	// En moneda Origen
      	pedidocab.setBruto(dataset.getMoney("total_bruto"));
      	pedidocab.setPorc_dto(dataset.getPorcentaje("porc_dto"));
      	pedidocab.setDescuento(dataset.getMoney("descuento"));
      	pedidocab.setPorc_recar(dataset.getPorcentaje("porc_recar"));
      	pedidocab.setRecargo(dataset.getMoney("recargo"));
      	pedidocab.setNeto(dataset.getMoney("total_neto"));
      	pedidocab.setNetoGravado(dataset.getMoney("neto_gravado"));
      	pedidocab.setNetoNoGravado(dataset.getMoney("neto_no_gravado"));
      	pedidocab.setIva(dataset.getMoney("iva"));
      	pedidocab.setIva2(dataset.getMoney("iva_2"));
      	pedidocab.setPerc_iva(dataset.getMoney("perc_iva"));
      	pedidocab.setImp_internos(dataset.getMoney("imp_internos"));
      	pedidocab.setTotal(dataset.getMoney("total_total"));
      	
      	pedidocab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva"),getSesion()));
      	pedidocab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva_2"),getSesion()));
      	pedidocab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_iva"),getSesion()));
      	pedidocab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_ib"),getSesion()));
      	pedidocab.setConcImpInt(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_int"),getSesion()));      	
      	
      	// Asignar los campos correspondientes a la Impresion o Visualizacion
      	pedidocab.setImpre_bruto(dataset.getMoney("impre_bruto"));
      	pedidocab.setImprePorcBonif(dataset.getMoney("impre_porc_dto"));
      	pedidocab.setImpre_bonif(dataset.getMoney("impre_descuento"));
      	pedidocab.setImprePorcRecar(dataset.getMoney("impre_porc_recar"));
      	pedidocab.setImpre_recar(dataset.getMoney("impre_recargo"));
      	pedidocab.setImpre_neto(dataset.getMoney("impre_neto"));
      	pedidocab.setImpre_iva(dataset.getMoney("impre_iva"));
      	pedidocab.setImpre_iva2(dataset.getMoney("impre_iva_2"));
      	pedidocab.setImpre_perc_iva(dataset.getMoney("impre_perc_iva"));
      	pedidocab.setImpre_imp_int(dataset.getMoney("impre_imp_internos"));
      	pedidocab.setImpre_total(dataset.getMoney("impre_total"));
        
        IDataSet dsObsCodif = dataset.getDataSet("TObsCodifPedidoCab");
        dsObsCodif.first();
        while (!dsObsCodif.EOF()) {
        	ObsCodifPedidoCab obsCodig =
        		ObsCodifPedidoCab.findByOid(dsObsCodif.getInteger("oid_obs_codif"), this.getSesion());
        	obsCodig.setPedido(pedidocab);
        	obsCodig.setOrden(dsObsCodif.getInteger("orden"));
        	obsCodig.setObs_codificada(ObsCodifVtas.findByOid(dsObsCodif.getInteger("oid_obs_cod"), this.getSesion()));
        	obsCodig.setActivo(dsObsCodif.getBoolean("activo"));
        	if (!obsCodig.isActivo())
        		obsCodig.delete();
        	
        	pedidocab.addObsCodificada(obsCodig);
        	dsObsCodif.next();
        }
        
        IDataSet dsDetABorrar = dataset.getDataSet("TItemsABorrar");
        dsDetABorrar.first();
        while (!dsDetABorrar.EOF()) {
        	PedidoDet pedidoDet = PedidoDet.findByOid(dsDetABorrar.getInteger("oid_ped_det"),getSesion());
        	pedidoDet.delete();      
        	pedidocab.addDetalle(pedidoDet);
        	dsDetABorrar.next();
        }
        
        IDataSet dsDetalles = dataset.getDataSet("TPedidoDet");
        dsDetalles.first();
        while (!dsDetalles.EOF()) {
          PedidoDet pedidoDet = PedidoDet.findByOid(dsDetalles.getInteger("oid_ped_det"),getSesion());
          pedidoDet.setPedido(pedidocab);
          pedidoDet.setProducto(Producto.findByOidProxy(dsDetalles.getInteger("oid_art"),getSesion()));
          pedidoDet.setUni_med_ori(UnidadMedida.findByOidProxy(dsDetalles.getInteger("oid_um_ori"),getSesion()));
          pedidoDet.setCant_um_ori(dsDetalles.getDecimal("cantidad"));
          pedidoDet.setPrecio(dsDetalles.getMoney("precio"));
          pedidoDet.setPrecio_bonif(dsDetalles.getMoney("precio_bonif"));
          pedidoDet.setPrecio_lista(dsDetalles.getMoney("precio_lista"));
          pedidoDet.setPrecioSugerido(dsDetalles.getMoney("precio_sugerido"));
          pedidoDet.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
          pedidoDet.setBonif1(dsDetalles.getDecimal("bonif1"));
          pedidoDet.setBonif2(dsDetalles.getDecimal("bonif2"));
          pedidoDet.setBonif3(dsDetalles.getDecimal("bonif3"));
          pedidoDet.setFecEntrega(dsDetalles.getDate("fec_entrega"));
          pedidoDet.setComentario(dsDetalles.getString("comentario"));
          pedidoDet.setAnulado(new Boolean(!dsDetalles.getBoolean("activo").booleanValue()));
          pedidoDet.setNroRenglon(dsDetalles.getInteger("nro_renglon"));
          
      		pedidoDet.setImporte(dsDetalles.getMoney("importe"));
      		pedidoDet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_iva"),getSesion()));
      		pedidoDet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_perc_iva"),getSesion()));
      		pedidoDet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_perc_ib"),getSesion()));
      		pedidoDet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_int"),getSesion()));
      		
      		pedidoDet.setNetoGravado(dsDetalles.getMoney("importe_neto_gravado"));
      		pedidoDet.setNetoNoGravado(dsDetalles.getMoney("importe_neto_no_gravado"));
      		
      		pedidoDet.setAnulado(new Boolean(!dsDetalles.getBoolean("activo").booleanValue()));
      		if (pedidoDet.isAnulado().booleanValue())
      			pedidoDet.delete();
      			
          pedidocab.addDetalle(pedidoDet);
          dsDetalles.next();
        }
        addTransaccion(pedidocab);
        dataset.next();
    }
  }

  protected void afterSave() throws BaseException {

  	  if (pedidocab!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
          pedidocab.getOIDInteger(),
          pedidocab.getDescripcion());

        writeCliente(infoCompro.getDataSetInfoCompro());
  	  }

  }


}
