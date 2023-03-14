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
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;
import com.srn.erp.ventas.bm.EstadoPresupuestoCliente;
import com.srn.erp.ventas.bm.FormaEntrega;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.MotivoEstadoPresuCliente;
import com.srn.erp.ventas.bm.ObsCodifPresuCab;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCotizacion extends Operation {

  CotizacionCab cotizacioncab = null;

  public SaveCotizacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TPresuCab");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        cotizacioncab = CotizacionCab.findByOid(dataset.getInteger("oid_cco_presu"),getSesion());
        Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
        cotizacioncab.setTalonario(talonario);
        cotizacioncab.setContabiliza(false);
        cotizacioncab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        cotizacioncab.setLetra(ComproCab.getLetraDefault(getSesion()));
        cotizacioncab.setOrdenDeCompra(dataset.getString("orden_compra"));
        if (talonario.getLugar_emision()!=null)
        	cotizacioncab.setLugarEmision(talonario.getLugar_emision());
        else
        	cotizacioncab.setLugarEmision(ComproCab.getLugEmiDafault(getSesion()));
        cotizacioncab.setEmision(dataset.getDate("fec_emision"));
        cotizacioncab.setComentario(dataset.getString("comentario"));
        cotizacioncab.setContactoSujeto(ContactoSujeto.findByOidProxy(dataset.getInteger("oid_contacto"),getSesion()));
        cotizacioncab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        cotizacioncab.setCotizacion(dataset.getCotizacion("cotizacion"));
        cotizacioncab.setSujeto(Sujeto.findByOidProxy(dataset.getInteger("oid_cliente"),getSesion()));
        cotizacioncab.setMercado(dataset.getString("mercado"));
        cotizacioncab.setPorc_bonif_cli(dataset.getDouble("porc_bonif_cli"));
        cotizacioncab.setPorc_reca_cli(dataset.getDouble("porc_reca_cli"));
        cotizacioncab.setBonif_cli_cascada(dataset.getBoolean("bonif_cli_cascada"));
        cotizacioncab.setReca_cli_cascada(dataset.getBoolean("reca_cli_cascada"));
        cotizacioncab.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_precio_cab"),getSesion()));
        cotizacioncab.setCondicionPago(CondicionPago.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
        cotizacioncab.setVendedor(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"),getSesion()));
        cotizacioncab.setDomicilio_entrega(UnidadEdilicia.findByOidProxy(dataset.getInteger("oid_uni_edi"),getSesion()));
        cotizacioncab.setPorc_bonif_cp(dataset.getDouble("porc_bonif_cp"));
        cotizacioncab.setPorc_reca_cp(dataset.getDouble("porc_reca_cp"));
        cotizacioncab.setBonif_cp_cascada(dataset.getBoolean("bonif_cp_cascada"));
        cotizacioncab.setReca_cp_cascada(dataset.getBoolean("reca_cp_cascada"));
        cotizacioncab.setObservado(dataset.getBoolean("observado"));
        
        if ((!cotizacioncab.isNew() && (cotizacioncab.isActivo().booleanValue() && dataset.getBoolean("activo").booleanValue()==false)))
        	cotizacioncab.delete();
        
        cotizacioncab.setActivo(dataset.getBoolean("activo"));
        
        cotizacioncab.setTransporte(Transporte.findByOidProxy(dataset.getInteger("oid_transporte"),getSesion()));
        cotizacioncab.setMonedaFact(Moneda.findByOidProxy(dataset.getInteger("oid_moneda_fact"),getSesion()));
        cotizacioncab.setFormaEntrega(FormaEntrega.findByOidProxy(dataset.getInteger("oid_forma_entrega"),getSesion()));
        
        // Totales
      	// En moneda Origen
        cotizacioncab.setBruto(dataset.getMoney("total_bruto"));
        cotizacioncab.setPorc_dto(dataset.getPorcentaje("porc_dto"));
        cotizacioncab.setDescuento(dataset.getMoney("descuento"));
        cotizacioncab.setPorc_recar(dataset.getPorcentaje("porc_recar"));
        cotizacioncab.setRecargo(dataset.getMoney("recargo"));
        cotizacioncab.setNeto(dataset.getMoney("total_neto"));
        cotizacioncab.setNetoGravado(dataset.getMoney("neto_gravado"));
        cotizacioncab.setNetoNoGravado(dataset.getMoney("neto_no_gravado"));
        cotizacioncab.setIva(dataset.getMoney("iva"));
        cotizacioncab.setIva2(dataset.getMoney("iva_2"));
        cotizacioncab.setPerc_iva(dataset.getMoney("perc_iva"));
        cotizacioncab.setImp_internos(dataset.getMoney("imp_internos"));
        cotizacioncab.setTotal(dataset.getMoney("total_total"));
      	
        cotizacioncab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva_2"),getSesion()));
        cotizacioncab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva"),getSesion()));
        cotizacioncab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_iva"),getSesion()));
        cotizacioncab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_ib"),getSesion()));
        cotizacioncab.setConcImpInt(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_int"),getSesion()));      	
      	
      	// Asignar los campos correspondientes a la Impresion o Visualizacion
        cotizacioncab.setImpre_bruto(dataset.getMoney("impre_bruto"));
        cotizacioncab.setImprePorcBonif(dataset.getMoney("impre_porc_dto"));
        cotizacioncab.setImpre_bonif(dataset.getMoney("impre_descuento"));
        cotizacioncab.setImprePorcRecar(dataset.getMoney("impre_porc_recar"));
        cotizacioncab.setImpre_recar(dataset.getMoney("impre_recargo"));
        cotizacioncab.setImpre_neto(dataset.getMoney("impre_neto"));
        cotizacioncab.setImpre_iva(dataset.getMoney("impre_iva"));
        cotizacioncab.setImpre_iva2(dataset.getMoney("impre_iva_2"));
        cotizacioncab.setImpre_perc_iva(dataset.getMoney("impre_perc_iva"));
        cotizacioncab.setImpre_imp_int(dataset.getMoney("impre_imp_internos"));
        cotizacioncab.setImpre_total(dataset.getMoney("impre_total"));
        cotizacioncab.setFecValidez(dataset.getDate("fec_validez"));
        cotizacioncab.setCotizMonFact(dataset.getCotizacion("cotiz_moneda_fact"));
        cotizacioncab.setComporCotizFact(dataset.getString("compor_cotiz_fact"));
        cotizacioncab.setEstadoPresupuesto(EstadoPresupuestoCliente.findByOidProxy(dataset.getInteger("oid_estado_presu"), this.getSesion()));
        cotizacioncab.setMotivoEstadoPresuCliente(MotivoEstadoPresuCliente.findByOidProxy(dataset.getInteger("oid_motivo_estado"), this.getSesion()));
        
        
        IDataSet dsObsCodif = dataset.getDataSet("TObsCodifPresuCab");
        dsObsCodif.first();
        while (!dsObsCodif.EOF()) {
        	ObsCodifPresuCab obsCodig =
        		ObsCodifPresuCab.findByOid(dsObsCodif.getInteger("oid_obs_codif"), this.getSesion());
        	obsCodig.setPresupuesto(cotizacioncab);
        	obsCodig.setOrden(dsObsCodif.getInteger("orden"));
        	obsCodig.setObs_codificada(ObsCodifVtas.findByOid(dsObsCodif.getInteger("oid_obs_cod"), this.getSesion()));
        	obsCodig.setActivo(dsObsCodif.getBoolean("activo"));
        	if (!obsCodig.isActivo())
        		obsCodig.delete();
        	
        	cotizacioncab.addObservacionCodificada(obsCodig);
        	dsObsCodif.next();
        }
        
        
        IDataSet dsDetABorrar = dataset.getDataSet("TItemsABorrar");
        dsDetABorrar.first();
        while (!dsDetABorrar.EOF()) {
        	CotizacionDet cotizacionDet = CotizacionDet.findByOid(dsDetABorrar.getInteger("oid_presu_det"),getSesion());
        	cotizacionDet.delete();      
        	cotizacioncab.addDetalle(cotizacionDet);
        	dsDetABorrar.next();
        }
        
        IDataSet dsDetalles = dataset.getDataSet("TPresuDet");
        dsDetalles.first();
        while (!dsDetalles.EOF()) {
          CotizacionDet cotizacionDet = CotizacionDet.findByOid(dsDetalles.getInteger("oid_presu_det"),getSesion());
          cotizacionDet.setCotizacion(cotizacioncab);
          cotizacionDet.setProducto(Producto.findByOidProxy(dsDetalles.getInteger("oid_art"),getSesion()));
          cotizacionDet.setUni_med_ori(UnidadMedida.findByOidProxy(dsDetalles.getInteger("oid_um_ori"),getSesion()));
          cotizacionDet.setCant_um_ori(dsDetalles.getDecimal("cantidad"));
          cotizacionDet.setPrecio(dsDetalles.getMoney("precio"));
          cotizacionDet.setPrecio_bonif(dsDetalles.getMoney("precio_bonif"));
          cotizacionDet.setPrecio_lista(dsDetalles.getMoney("precio_lista"));
          cotizacionDet.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
          cotizacionDet.setDiasEntrega(dsDetalles.getInteger("dias_entrega"));
          cotizacionDet.setBonif1(dsDetalles.getDecimal("bonif1"));
          cotizacionDet.setBonif2(dsDetalles.getDecimal("bonif2"));
          cotizacionDet.setBonif3(dsDetalles.getDecimal("bonif3"));
          cotizacionDet.setFecEntrega(dsDetalles.getDate("fec_entrega"));
          cotizacionDet.setComentario(dsDetalles.getString("comentario"));
          cotizacionDet.setAnulado(new Boolean(!dsDetalles.getBoolean("activo").booleanValue()));
          cotizacionDet.setNroRenglon(dsDetalles.getInteger("nro_renglon"));
          
          cotizacionDet.setImporte(dsDetalles.getMoney("importe"));
          cotizacionDet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_iva"),getSesion()));
          cotizacionDet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_perc_iva"),getSesion()));
          cotizacionDet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_perc_ib"),getSesion()));
          cotizacionDet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(dsDetalles.getInteger("oid_conc_imp_int"),getSesion()));
          
      		cotizacionDet.setNetoGravado(dsDetalles.getMoney("importe_neto_gravado"));
      		cotizacionDet.setNetoNoGravado(dsDetalles.getMoney("importe_neto_no_gravado"));
          
      		
          cotizacionDet.setAnulado(new Boolean(!dsDetalles.getBoolean("activo").booleanValue()));
      		if (cotizacionDet.isAnulado().booleanValue())
      			cotizacionDet.delete();
      			
          cotizacioncab.addDetalle(cotizacionDet);
          dsDetalles.next();
        }
        addTransaccion(cotizacioncab);
        dataset.next();
    }
  }

  protected void afterSave() throws BaseException {

  	  if (cotizacioncab!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
          cotizacioncab.getOIDInteger(),
          cotizacioncab.getDescripcion());

        writeCliente(infoCompro.getDataSetInfoCompro());
  	  }

  }


}
