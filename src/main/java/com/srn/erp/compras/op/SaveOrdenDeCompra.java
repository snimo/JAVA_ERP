package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveOrdenDeCompra extends Operation { 

  OrdenDeCompraCab ordendecompracab = null; 	
	
  public SaveOrdenDeCompra() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TOCCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ordendecompracab = OrdenDeCompraCab.findByOid(dataset.getInteger("oid_oc"),getSesion());
        ordendecompracab.setOID(dataset.getInteger("oid_oc"));
        
        if (!dataset.getBoolean("activo").booleanValue()) {
        	ordendecompracab.delete();
            addTransaccion(ordendecompracab);
            dataset.next();
            continue;
        }
        
        
        // Set datos del comprobante
        ordendecompracab.setContabiliza(false);
        ordendecompracab.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        ordendecompracab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        ordendecompracab.setLetra(dataset.getString("letra"));
        ordendecompracab.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        ordendecompracab.setNroext(dataset.getInteger("nro_ext"));
        ordendecompracab.setEmision(dataset.getDate("fec_emision"));
        ordendecompracab.setComentario(dataset.getString("comentario"));
        ordendecompracab.setActivo(dataset.getBoolean("activo"));
        ordendecompracab.setCotizacion(dataset.getCotizacion("cotizacion"));
        ordendecompracab.setSectorCompra(SectorCompra.findByOidProxy(dataset.getInteger("oid_sector_compra"),getSesion()));
        
        // Set Datos de la Orden de Compra
        Proveedor proveedor = Proveedor.findByOidProxy(dataset.getInteger("oid_prov"),getSesion());
        ordendecompracab.setProveedor(proveedor);
        ordendecompracab.setAgrupaItemsImpresion(dataset.getBoolean("agrupa_items_impre"));
        ordendecompracab.setVia_despacho(ViaDespacho.findByOidProxy(dataset.getInteger("oid_via_despacho"),getSesion()));
        ordendecompracab.setCond_compra_importacion(CondCompraImportacion.findByOidProxy(dataset.getInteger("oid_cond_compra"),getSesion()));
        ordendecompracab.setDto_1_1(dataset.getDouble("dto_1"));
        ordendecompracab.setDto_1_2(dataset.getDouble("dto_2"));
        ordendecompracab.setDto_1_3(dataset.getDouble("dto_3"));
        ordendecompracab.setCond_pago_1(CondicionCompra.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
        ordendecompracab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        ordendecompracab.setSectorCompra(SectorCompra.findByOidProxy(dataset.getInteger("oid_sector_compra"),getSesion()));
        ordendecompracab.setTipo(dataset.getString("tipo_oc"));
        ordendecompracab.setTomar_precio_de(dataset.getString("tomar_precios_de"));
        ordendecompracab.setDtoEnCasacada(dataset.getBoolean("en_cascada"));
        ordendecompracab.setPorcRecargo(dataset.getPorcentaje("porc_recargo"));
        ordendecompracab.setLugarEntrega(LugarEntrega.findByOidProxy(dataset.getInteger("oid_lugar_entrega"),getSesion()));

        
        IDataSet dsDetABorrar = dataset.getDataSet("TItemsABorrar");
        dsDetABorrar.first();
        while (!dsDetABorrar.EOF()) {
        	OrdenDeCompraDet ocDet = OrdenDeCompraDet.findByOid(dsDetABorrar.getInteger("oid_oc_det"),getSesion());
        	ocDet.delete();      
        	ordendecompracab.addDetalleOC(ocDet);
        	dsDetABorrar.next();
        }

        
        IDataSet dataOCDet = dataset.getDataSet("TOCDet");
        dataOCDet.first();
        while (!dataOCDet.EOF()) {
        	OrdenDeCompraDet ocDet = OrdenDeCompraDet.findByOid(dataOCDet.getInteger("oid_oc_det"),getSesion());
        	ocDet.setOrden_de_compra(ordendecompracab);
        	Producto producto = Producto.findByOidProxy(dataOCDet.getInteger("oid_producto"),getSesion());
        	ocDet.setProducto(producto);
        	ocDet.setDesc_adic_sku(dataOCDet.getString("desc_adic_producto"));
        	ocDet.setAnulado(new Boolean(!dataOCDet.getBoolean("activo").booleanValue()));
        	UnidadMedida uniMedCpra = UnidadMedida.findByOidProxy(dataOCDet.getInteger("oid_um_cpra"),getSesion());
        	ocDet.setUnidad_compra(uniMedCpra);
        	Double cantidad = dataOCDet.getDouble("cant_comprada");
        	ocDet.setCant_comprada_uc(cantidad);
        	ocDet.setMoneda(Moneda.findByOidProxy(dataOCDet.getInteger("oid_moneda"),getSesion()));
        	ocDet.setPrecio(dataOCDet.getDouble("precio"));
        	ocDet.setPrecio_neto_bonif(dataOCDet.getDouble("precio_neto"));
        	ocDet.setTotal(dataOCDet.getDouble("total"));
        	ocDet.setNro_item(dataOCDet.getInteger("nro_item"));
        	ocDet.setComentario(dataOCDet.getString("comentario"));
        	ocDet.setDto1(dataOCDet.getDouble("dto_1"));
        	ocDet.setDto2(dataOCDet.getDouble("dto_2"));
        	ocDet.setDto3(dataOCDet.getDouble("dto_3"));
        	ocDet.setEnCascada(dataOCDet.getBoolean("en_cascada"));
        	ocDet.setPorcRecar(dataOCDet.getPorcentaje("porc_recar"));
        	ocDet.setTipoRecarDto(dataOCDet.getString("tipo_recar_dto"));
        	ocDet.setPorcDtoRecar(dataOCDet.getPorcentaje("porc_dto_recar"));
        	ocDet.setFecRequerida(dataOCDet.getDate("fec_requerida"));
            ocDet.setPedidoCab(PedidoCab.findByOidProxy(dataOCDet.getInteger("oid_cco_ped"),getSesion()));
            ocDet.setPedidoDet(PedidoDet.findByOidProxy(dataOCDet.getInteger("oid_ped_det"),getSesion()));
            ocDet.setPendFact(new Boolean(true));
            ocDet.setFuente_precio_sug(dataOCDet.getString("fuente_origen"));
            
            
        	
        	if (producto == null)
        		throw new ExceptionValidation(null,"Debe ingresar el producto");
        	if (producto.isStockeable().booleanValue()) {
        		if (producto.getUm_stk()==null)
        			throw new ExceptionValidation(null,"El producto "+
        					producto.getCodigo()+" - "+
        					producto.getDescripcion()+ 
        					" no tiene definido una unidad de Stock Principal");
        	    ocDet.setUm_stock(producto.getUm_stk());
        	    ocDet.setCant_comprada_us(producto.getConvertirUM(proveedor,cantidad,uniMedCpra,producto.getUm_stk()).doubleValue());
        	}
        	
        	if (!dataOCDet.getBoolean("activo").booleanValue())
        		ocDet.delete();
        	
        	ordendecompracab.addDetalleOC(ocDet);
        	
        	// Generar aplicaciones para requisiciones
        	
        	if (!dataOCDet.getContains("TRequisicionesDet")) {
        	  IDataSet dsAplicParaRequi = dataOCDet.getDataSet("TRequisicionesDet");
        	  dsAplicParaRequi.first();
        	  while (!dsAplicParaRequi.EOF()) {
        		  RequisicionDet requiDet = RequisicionDet.findByOidProxy(dsAplicParaRequi.getInteger("oid_req_det"),getSesion());
        		  ocDet.addRequiDetParaAplicar(requiDet);
        		  dsAplicParaRequi.next();
        	  }
        	  ocDet.generarAplicParaRequi();
        	}
        	
        	dataOCDet.next();
        }
        
        addTransaccion(ordendecompracab);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {
	  if (ordendecompracab!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
        		ordendecompracab.getOIDInteger(),
        		ordendecompracab.getDescripcion()
        		);
        writeCliente(infoCompro.getDataSetInfoCompro());
	  }

  }  
  
  
}
