package com.srn.erp.ventas.op;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.Ticket;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.FactElectronicaCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.FacturaElectronicaCab;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveFactura extends Operation {
	
  FacturaCab facturaCab = null;	
  HashTableDatos listaCotiz = null;
  String cae = null;
  Date vtocae = null;
  FactElectronicaCab factEleCab = null;

  public SaveFactura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	if (mapaDatos.containsKey("TCotizaciones"))
		listaCotiz = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"));  
    IDataSet dataset = mapaDatos.getDataSet("TFacturaCab");
    procesarRegistros(dataset,mapaDatos);
  }

  private void procesarRegistros(IDataSet dataset,MapDatos mapaDatos) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	facturaCab = FacturaCab.findByOid(dataset.getInteger("oid_cco"),getSesion());
    	
    	// Analizar si se trata de una Anulacion
		if ((facturaCab.isNew()==false) && 
				(facturaCab.isActivo().booleanValue()) && 
				(dataset.getBoolean("activo").booleanValue()==false)) {
			facturaCab.delete();
			this.addTransaccion(facturaCab);
			return;
		}    	
    	
    	// Datos principales de la cabecera
    	Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion());
    	if (talonario==null)
    		throw new ExceptionValidation(null,"Debe seleccionar un talonario");
    	facturaCab.addCotizacionesMonedas(listaCotiz);
    	facturaCab.setTalonario(talonario);
    	facturaCab.setContabiliza(true);
    	facturaCab.setEmision(dataset.getDate("fec_emision"));
    	facturaCab.setImputac(dataset.getDate("fec_emision"));
    	facturaCab.setTipoCompro(talonario.getTipo_comprobante());
    	facturaCab.setLetra(talonario.getLetra());
    	facturaCab.setLugarEmision(talonario.getLugar_emision());
    	facturaCab.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	facturaCab.setComentario(dataset.getString("comentario"));
    	facturaCab.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
    	facturaCab.setCotizacion(dataset.getCotizacion("cotizacion"));
    	facturaCab.setNroInterno(dataset.getInteger("nro_interno"));
    	facturaCab.setTipoCtaCteClie(TipoCtaCteClie.getTipoCtaCteClie(getSesion()));
    	
    	Sujeto sujeto = Sujeto.findByOidProxy(dataset.getInteger("oid_cliente"),getSesion());
    	facturaCab.setSujeto(sujeto);
    	Sucursal sucursal = Sucursal.findByOid(getSesion().getLogin().getOidSucursal(),getSesion());
    	facturaCab.setSucursal(sucursal);
    	facturaCab.setOC(dataset.getString("oc"));
    	
    	
    	// Otros datos principales
    	facturaCab.setTipo_oper(dataset.getString("tipo_oper_factu"));
    	facturaCab.setTipo_cliente(dataset.getString("tipo_cliente"));
    	facturaCab.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),getSesion()));
    	facturaCab.setFec_caja(dataset.getDate("fec_caja"));
    	if (dataset.getPorcentaje("porc_bonif_cli")!=null)
    		facturaCab.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_bonif_cli").doubleValue()));
    	if (dataset.getPorcentaje("porc_reca_cli")!=null)
    		facturaCab.setPorc_bonif_cli(new Double(dataset.getPorcentaje("porc_reca_cli").doubleValue()));
    	facturaCab.setLista_precios(ListaPrecios.findByOidProxy(dataset.getInteger("oid_lp"),getSesion()));
    	facturaCab.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
    	facturaCab.setProyecto(Proyecto.findByOidProxy(dataset.getInteger("oid_proyecto"),getSesion()));
    	facturaCab.setVendedor(Vendedor.findByOidProxy(dataset.getInteger("oid_vendedor"),getSesion()));
    	facturaCab.setCond_pago(CondicionPago.findByOidProxy(dataset.getInteger("oid_cond_pago"),getSesion()));
    	facturaCab.setCompo_stk_fact(CompoStkTalonarioFactClie.findByOidProxy(dataset.getInteger("oid_compo_stk_fac"),getSesion()));
    	if (dataset.getPorcentaje("porc_bonif_fp")!=null)
    		facturaCab.setPorc_bonif_cp(new Double(dataset.getPorcentaje("porc_bonif_fp").doubleValue()));
    	else
    		facturaCab.setPorc_bonif_cp(new Double(0));
    	if (dataset.getPorcentaje("porc_recar_fp")!=null)
    		facturaCab.setPorc_recar_cp(new Double(dataset.getPorcentaje("porc_recar_fp").doubleValue()));
    	else
    		facturaCab.setPorc_recar_cp(new Double(0));
    	facturaCab.setFec_base(dataset.getDate("fec_emision"));
    	facturaCab.setSujeto_impositivo(sujeto.getSujeto_impositivo());
    	if (facturaCab.isFacturaNotaDebito())
    		facturaCab.setSigno(1);
    	else
    		facturaCab.setSigno(-1);
    	facturaCab.setOC(dataset.getString("oc"));
//    	
    	// En moneda Origen
    	facturaCab.setBruto(dataset.getMoney("total_bruto"));
    	facturaCab.setPorc_dto(dataset.getPorcentaje("porc_dto"));
    	facturaCab.setDescuento(dataset.getMoney("descuento"));
    	facturaCab.setPorc_recar(dataset.getPorcentaje("porc_recar"));
    	facturaCab.setRecargo(dataset.getMoney("recargo"));
    	facturaCab.setNeto(dataset.getMoney("total_neto"));
    	facturaCab.setNetoGravado(dataset.getMoney("neto_gravado"));
    	facturaCab.setNetoNoGravado(dataset.getMoney("neto_no_gravado"));
    	facturaCab.setIva(dataset.getMoney("iva"));
    	facturaCab.setIva2(dataset.getMoney("iva_2"));
    	
    	facturaCab.setPerc_iva(dataset.getMoney("perc_iva"));
    	facturaCab.setImp_internos(dataset.getMoney("imp_internos"));
    	facturaCab.setPercIBBsAs(dataset.getMoney("perc_ib_ba"));
    	facturaCab.setPercIBCapFed(dataset.getMoney("perc_ib_cf"));
    	facturaCab.setTotal(dataset.getMoney("total_total"));
    	facturaCab.setNroext(dataset.getInteger("nro_ext"));
    	facturaCab.setFactura(dataset.getString("factura"));
    	
    	facturaCab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva"),getSesion()));
    	facturaCab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_iva_2"),getSesion()));
    	facturaCab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_iva"),getSesion()));
    	facturaCab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_perc_ib"),getSesion()));
    	facturaCab.setConcImpInt(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_conc_impu_int"),getSesion()));
    	
    	
    	// Asignar los campos correspondientes a la Impresion o Visualizacion
    	facturaCab.setImpre_bruto(dataset.getMoney("impre_bruto"));
    	facturaCab.setImprePorcBonif(dataset.getMoney("impre_porc_dto"));
    	facturaCab.setImpre_bonif(dataset.getMoney("impre_descuento"));
    	facturaCab.setImprePorcRecar(dataset.getMoney("impre_porc_recar"));
    	facturaCab.setImpre_recar(dataset.getMoney("impre_recargo"));
    	facturaCab.setImpre_neto(dataset.getMoney("impre_neto"));
    	facturaCab.setImpre_iva(dataset.getMoney("impre_iva"));
    	facturaCab.setImpre_iva2(dataset.getMoney("impre_iva_2"));
    	facturaCab.setImpre_perc_iva(dataset.getMoney("impre_perc_iva"));
    	facturaCab.setImpre_imp_int(dataset.getMoney("impre_imp_internos"));
    	facturaCab.setImprePercIBBsAs(dataset.getMoney("impre_perc_ib_ba"));
    	facturaCab.setImprePercIBCapFed(dataset.getMoney("impre_perc_ib_cf"));
    	facturaCab.setImpre_total(dataset.getMoney("impre_total"));
    	
    	if (dataset.containstAttribute("oid_cco_fact_senia") && (dataset.getInteger("oid_cco_fact_senia")!=null))
    		if (dataset.getInteger("oid_cco_fact_senia").intValue()>0)
    			facturaCab.setFacturaSenia(ComproCab.findByOidProxyCompro(dataset.getInteger("oid_cco_fact_senia"),this.getSesion()));    	
    	
    	// Para el manejo de Stock
    	facturaCab.setTipoConfMovStkTalonario(TipoConfMovStkTalonario.findByOidProxy(dataset.getInteger("oid_tipo_conf_mov"),getSesion()));
    	
    	// Traer Detalles de las Facturas
    	IDataSet dsFacturaDet = dataset.getDataSet("TFacturaDet");
    	dsFacturaDet.first();
    	while (!dsFacturaDet.EOF()) {
    		
    		// Si el Item No esta activo no pasarlo
    		if (dsFacturaDet.getBoolean("activo").booleanValue() == false) {
    			dsFacturaDet.next();
    			continue;
    		}
    		
    		FacturaDet facturaDet = facturaCab.addDetalle();
    		facturaDet.setProducto(Producto.findByOidProxy(dsFacturaDet.getInteger("oid_art"),getSesion()));
    		facturaDet.setCantidad(dsFacturaDet.getDouble("cantidad"));
    		
    		if (dsFacturaDet.getDouble("cantidad").doubleValue() == 0) {
    			dsFacturaDet.next();
    			continue;
    		}
    		
    		facturaDet.setUnidad_medida(UnidadMedida.findByOidProxy(dsFacturaDet.getInteger("oid_uni_med"),getSesion()));
    		facturaDet.setPrecio_lista(dsFacturaDet.getMoney("precio_lista"));
    		facturaDet.setPrecio_sugerido(dsFacturaDet.getMoney("precio_lista_bonif"));
    		facturaDet.setPrecio_ingresado(dsFacturaDet.getMoney("precio_factura"));
    		facturaDet.setPorc_bonif_1(dsFacturaDet.getPorcentaje("porc_bonif_1"));
    		facturaDet.setPorc_bonif_2(dsFacturaDet.getPorcentaje("porc_bonif_2"));
    		facturaDet.setPorc_bonif_3(dsFacturaDet.getPorcentaje("porc_bonif_3"));
    		facturaDet.setPrecio_bonificado(dsFacturaDet.getMoney("precio_bonif"));
    		facturaDet.setImporte(dsFacturaDet.getMoney("importe"));
    		facturaDet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_iva"),getSesion()));
    		facturaDet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_iva"),getSesion()));
    		facturaDet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_perc_ib"),getSesion()));
    		facturaDet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(dsFacturaDet.getInteger("oid_conc_imp_int"),getSesion()));
    		facturaDet.setNetoGravado(dsFacturaDet.getMoney("importe_neto_gravado"));
    		facturaDet.setNetoNoGravado(dsFacturaDet.getMoney("importe_neto_no_gravado"));
    		facturaDet.setTasaIVA(dsFacturaDet.getPorcentaje("tasa_iva"));
    		facturaDet.setIVA(dsFacturaDet.getMoney("iva"));
    		facturaDet.setComentario(dsFacturaDet.getString("comentario"));    		
    		facturaDet.setPedidoDet(PedidoDet.findByOidProxy(dsFacturaDet.getInteger("oid_cco_ped_det"),getSesion()));
    		facturaDet.setRemitoDet(RemitoDet.findByOidProxy(dsFacturaDet.getInteger("oid_cco_rem_det"),getSesion()));
    		
    		// Si se carga un pedido a nivel cabecera asignarlo
    		if (facturaDet.getPedidoCab()==null) {
    			PedidoCab pedidoCabecera = PedidoCab.findByOid(dataset.getInteger("oid_cco_ped"), this.getSesion());
    			if (pedidoCabecera!=null)
    				facturaDet.setPedidoCab(pedidoCabecera);
    		}
    		
    		
    		dsFacturaDet.next();
    	}
    	
    	tratarValores(mapaDatos);
    	
    	
    	addTransaccion(facturaCab);
    	
    	try {
    		if ((facturaCab.getTalonario()!=null) && (facturaCab.getTalonario().isFactElec()))
    			this.homologarFacturaElectronica();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,e.getMessage());
		}
    	
    	//if (1==1)
    	//	throw new ExceptionValidation(null,"No se pudo Homologar la factura electronica");
    	
    	
    	//facturaCab.save();
    	//this.getSesion().commitTransaction();
    	
    	//setRefreshObjNeg(facturaCab.getOIDInteger());
    	
    	
    	/*
    	IDataSet datasetOidObjActu = getDataSetOidObjActualizados();
		datasetOidObjActu.append();
		datasetOidObjActu.fieldValue("oid", facturaCab.getOID());
		datasetOidObjActu.fieldValue("codigo", facturaCab.getCodigo());			
		writeCliente(datasetOidObjActu);*/
 	
    	
    		
    	
        dataset.next();
    }
  }
  
  private IDataSet getDataSetOidObjActualizados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOidObjSave");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		return dataset;
  }

  
  private void tratarValores(MapDatos mapaDatos) throws BaseException {
  	// Tratar los Medios de pago
  	if (!mapaDatos.containsKey("TValores")) return;
  	
  	IDataSet dsValores = mapaDatos.getDataSet("TValores");
  	dsValores.first();
  	while (!dsValores.EOF()) {
  	     MedioPago medioPago = facturaCab.addMedioPago();
  	       medioPago.setValor(Valor.findByOidProxy(dsValores.getInteger("oid_valor"),this.getSesion()));
           medioPago.setSujeto(this.facturaCab.getSujeto());
           medioPago.setOidOPMedioPago(dsValores.getInteger("secu"));
           medioPago.setFechaContable(facturaCab.getEmision());
           medioPago.setTipoValor(TipoValor.findByOid(dsValores.getInteger("oid_tipo_valor"),getSesion()));
           medioPago.setProvincia(Provincia.findByOid(dsValores.getInteger("oid_provincia"),getSesion()));
           medioPago.setOidEntidad(dsValores.getInteger("oid_entidad"));
           medioPago.setNro_cheque(dsValores.getInteger("nro"));
           medioPago.setFecEmision(dsValores.getDate("fec_emision"));
           medioPago.setFecVencimiento(dsValores.getDate("fec_vto"));
           medioPago.setCUIT(dsValores.getString("cuit_cuil"));
           medioPago.setImporteMonedaPago(dsValores.getMoney("impo_mon_fact"));
           medioPago.setImporteMonedaValor(dsValores.getMoney("importe"));
           medioPago.setLote(dsValores.getInteger("lote"));
           medioPago.setCupon(dsValores.getInteger("cupon"));
           medioPago.setCuotas(dsValores.getInteger("cuotas"));
           medioPago.setNroTarjeta(dsValores.getString("nro_tarjeta"));
           medioPago.setCotizMonedaValor(dsValores.getCotizacion("cotizacion"));
           medioPago.setTarjetaCredito(TarjetaCredito.findByOidProxy(dsValores.getInteger("oid_tarjeta_credito"),getSesion()));
           medioPago.setTicket(Ticket.findByOidProxy(dsValores.getInteger("oid_ticket"),getSesion()));
           medioPago.setNroCertificado(dsValores.getString("nro_certificado"));
           medioPago.setCodigoAutorizacion(dsValores.getString("codigo_autorizacion"));
           
           medioPago.setCaja(facturaCab.getCaja());
           medioPago.setImportesContables(
         		  facturaCab.getImportesContables(dsValores.getMoney("importe"),
         				  						  medioPago.getTipoValor().getMoneda(),
         				  						  facturaCab.getEmision()));    		
  		dsValores.next();
  	}
	
  }
  
 

@Override
protected void afterSave() throws BaseException {
	// TODO Auto-generated method stub
	super.afterSave();
	
	if (((facturaCab.getTalonario()!=null) && (facturaCab.getTalonario().isFactElec())) && (this.cae!=null) && (this.cae.length()>0) && (this.vtocae!=null)) {
		
		FacturaElectronicaCab.actualizarFactElectronica(
				new Date(), 
				this.getSesion().getLogin().getUsuario().getCodigo(), 
				this.cae,
				this.vtocae, 
				facturaCab.getOID(), 
				this.getSesion());
		
		if ((factEleCab!=null) && (factEleCab.getOIDInteger()>0)  && (facturaCab!=null) && (facturaCab.getOIDInteger()>0)) {
			FactElectronicaCab.actualizarFactElectronica(factEleCab.getOIDInteger(), facturaCab.getOIDInteger(), this.getSesion());
		}
		
		this.getSesion().commitTransaction();
	}

	/*
	
	if ((facturaCab!=null) && (facturaCab.getOID()>0)) {	
		IDataSet datasetOidObjActu = getDataSetOidObjActualizados();
		datasetOidObjActu.append();
		datasetOidObjActu.fieldValue("oid", facturaCab.getOID());
		datasetOidObjActu.fieldValue("codigo", facturaCab.getCodigo());			
		writeCliente(datasetOidObjActu);
	}*/
	
	
	
}

private void homologarFacturaElectronica() throws Exception {
	
	
	// Verificar si ya esta 
	
	String url =  ValorParametro.findByCodigoParametro("URL_HOMOLOGAR_FACT_ELEC", this.getSesion()).getValorCadena();
	URL obj = new URL(url);
	HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	conn.setRequestMethod("POST");		
	conn.setRequestProperty("Content-Type", "application/json; utf-8");		
	conn.setDoOutput(true);
	
	Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
	String cuit = empresa.getCuit().replaceAll("-", "");
	
	JSONObject json = new JSONObject();
	json.put("cuit",cuit);
	json.put("tipo_comprobante",facturaCab.getTalonario().getCodigoTCFactEle());
	
	
	if ((facturaCab.getTipo_oper().equals("NC_MOST")) || (facturaCab.getTipo_oper().equals("NOTA_DEB"))) {
	
		
		String nroFactura = facturaCab.getFactura();;
		if (nroFactura == null)
			throw new ExceptionValidation(null,"Debe ingresar el Nro. de Factura");
		
		String nro = "";
		for(int i=0;i<nroFactura.length();++i) {
			String digito = nroFactura.substring(nroFactura.length()-i-1,nroFactura.length()-i+1-1);
			try {
			        int digitoNumerico = Integer.parseInt(digito);
			    } catch (NumberFormatException nfe) {
			        digito = "";
			    }
			if (digito.equals("")) break;
			nro = digito  + nro;		
			
		}
		
		json.put("asoc_nro_comprobante", new Integer(nro)); 
	}
	
	json.put("nro_comprobante",facturaCab.getNroExt());
	json.put("pto_venta",facturaCab.getTalonario().getLugar_emision().getLugemi());
	json.put("tipo_documento",facturaCab.getSujeto().getTipo_documento().getCodigoFE()); 
	String nroDocu = "0";
	
	if (facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIL) ||
		facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIT)) {
		nroDocu = facturaCab.getSujeto().getSujeto_impositivo().getCuit(); 
	} else
		nroDocu = facturaCab.getSujeto().getNro_documento();
	
	Long longNroDocu = Long.parseLong(nroDocu.trim());
	
	json.put("nro_documento",longNroDocu);
	
    Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
    String strDate = dateFormat.format(facturaCab.getEmision());  
    json.put("fecha_comprobante",strDate);
	json.put("imp_total",new Double(facturaCab.getTotal().doubleValue(2)));
	json.put("imp_neto",new Double(facturaCab.getNeto().doubleValue(2)));
	json.put("imp_iva",new Double(facturaCab.getIva().doubleValue(2)));
		
	String jsonInputString = json.toString();
	
	String response = "";
	try {
	
	OutputStream os = conn.getOutputStream(); 
	byte[] input = jsonInputString.getBytes("utf-8");
	os.write(input, 0, input.length);           
	
	
	Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	StringBuilder sb = new StringBuilder();
	for (int c; (c = in.read()) >= 0;)
		sb.append((char) c);
	response = sb.toString();
	
	
	JSONObject myResponse = new JSONObject(response.toString());	
	
	String cae = myResponse.getString("CAE");		
	String stringFecVto = myResponse.getString("CAEFchVto");

	if (cae==null)
		throw new ExceptionValidation(null,"No se pudo obtener el CAE");
	
	if ((cae!=null) && (cae.length()==0))
	    throw new ExceptionValidation(null,"No se pudo obtener el CAE");
	
	if (stringFecVto==null)
		throw new ExceptionValidation(null,"No se pudo obtener el vencimiento del CAE");
		
	if (stringFecVto.length()!=10)
		throw new ExceptionValidation(null,"No se pudo obtener el vencimiento del CAE. Formato "+stringFecVto);
	
	Date fecVtoCae=new SimpleDateFormat("yyyy-MM-dd").parse(stringFecVto);
	
	this.cae = cae;
	this.vtocae = fecVtoCae;
	
	if (fecVtoCae==null)
		throw new ExceptionValidation(null,"No se pudo obtener el vencimiento del CAE. Formato "+stringFecVto);
	
	
	// Grabar Datos Fact. Electronica OK
	factEleCab = (FactElectronicaCab) FactElectronicaCab.getNew(FactElectronicaCab.NICKNAME, this.getSesion());
	if (facturaCab.getTipoCompro()==null) throw new ExceptionValidation(null,"Debe seleccionar el tipo de comprobante");
	factEleCab.setOid_tc(facturaCab.getTipoCompro().getOIDInteger());
	factEleCab.setTc_ext(facturaCab.getTipoCompro().getCodigo());
	factEleCab.setLetra(facturaCab.getLetra());
	factEleCab.setNro_ext(facturaCab.getNroExt());
	if (facturaCab.getLugarEmision()==null) throw new ExceptionValidation(null,"Debe seleccionar el lugar de emision");
	factEleCab.setLug_emi(facturaCab.getLugarEmision().getLugemi());
	factEleCab.setFec_homologada(new Date());
	factEleCab.setUsu_homologo(this.getSesion().getLogin().getUsuario().getCodigo());
	factEleCab.setHomologado_ok(true);
	factEleCab.setOid_cco_asignado_a(null);
	factEleCab.setCae(cae);
	factEleCab.setVto_cae(fecVtoCae);
	factEleCab.setRespuesta_ws_homo(response);
	factEleCab.setCuit_empresa(cuit);
	if (facturaCab.getTalonario()==null) throw new ExceptionValidation(null,"Debe seleccionar el talonario");
	factEleCab.setTc_fe(facturaCab.getTalonario().getCodigoTCFactEle());
	if (facturaCab.getSujeto()==null) throw new ExceptionValidation(null,"Debe seleccionar el sujeto");
	if (facturaCab.getSujeto().getTipo_documento()==null) throw new ExceptionValidation(null,"El cliente no tiene asignado el tipo de documento");
	factEleCab.setTipo_docu_fe(facturaCab.getSujeto().getTipo_documento().getCodigoFE());
	factEleCab.setNro_docu_fe(nroDocu);
	factEleCab.setFec_fe(facturaCab.getEmision());
	factEleCab.setImp_total_fe(facturaCab.getTotal());
	factEleCab.setImp_neto_fe(facturaCab.getNeto());
	factEleCab.setImp_iva_fe(facturaCab.getIva());
	factEleCab.save();
	
	this.getSesion().commitTransaction();
	
	
	/*
	FacturaElectronicaCab.actualizarFactElectronica(
			new Date(), 
			this.getSesion().getLogin().getUsuario().getCodigo(), 
			myResponse.getString("CAE"),
			fecVtoCae, 
			facturaCab.getOID(), 
			this.getSesion());*/
	
	
	
	
	
	} catch(Exception e) {
		
		// Verificar por las dudas si no se puede obtener la fecha de vencimiento y el CAE
		
		// SEBASTIAN
		
		factEleCab = (FactElectronicaCab) FactElectronicaCab.getNew(FactElectronicaCab.NICKNAME, this.getSesion());
		if (facturaCab.getTipoCompro()==null) throw new ExceptionValidation(null,"Debe seleccionar el tipo de comprobante");
		factEleCab.setOid_tc(facturaCab.getTipoCompro().getOIDInteger());
		factEleCab.setTc_ext(facturaCab.getTipoCompro().getCodigo());
		factEleCab.setLetra(facturaCab.getLetra());
		factEleCab.setNro_ext(facturaCab.getNroExt());
		if (facturaCab.getLugarEmision()==null) throw new ExceptionValidation(null,"Debe seleccionar el lugar de emision");
		factEleCab.setLug_emi(facturaCab.getLugarEmision().getLugemi());
		factEleCab.setFec_homologada(new Date());
		factEleCab.setUsu_homologo(this.getSesion().getLogin().getUsuario().getCodigo());
		factEleCab.setHomologado_ok(false);
		factEleCab.setOid_cco_asignado_a(null);
		factEleCab.setCae("");
		factEleCab.setVto_cae(null);
		factEleCab.setRespuesta_ws_homo(response);
		factEleCab.setCuit_empresa(cuit);
		if (facturaCab.getTalonario()==null) throw new ExceptionValidation(null,"Debe seleccionar el talonario");
		factEleCab.setTc_fe(facturaCab.getTalonario().getCodigoTCFactEle());
		if (facturaCab.getSujeto()==null) throw new ExceptionValidation(null,"Debe seleccionar el sujeto");
		if (facturaCab.getSujeto().getTipo_documento()==null) throw new ExceptionValidation(null,"El cliente no tiene asignado el tipo de documento");
		factEleCab.setTipo_docu_fe(facturaCab.getSujeto().getTipo_documento().getCodigoFE());
		factEleCab.setNro_docu_fe(nroDocu);
		factEleCab.setFec_fe(facturaCab.getEmision());
		factEleCab.setImp_total_fe(facturaCab.getTotal());
		factEleCab.setImp_neto_fe(facturaCab.getNeto());
		factEleCab.setImp_iva_fe(facturaCab.getIva());
		factEleCab.save();
		
		this.getSesion().commitTransaction();
		
		
		throw new ExceptionValidation(null,response+" "+e.getMessage());
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
