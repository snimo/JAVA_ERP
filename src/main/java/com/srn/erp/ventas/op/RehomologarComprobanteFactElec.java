package com.srn.erp.ventas.op;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.ventas.bm.FactElectronicaCab;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaElectronicaCab;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class RehomologarComprobanteFactElec extends Operation {
	

  public RehomologarComprobanteFactElec() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidCCO = mapaDatos.getInteger("oid_cco");  
	intentarHomologar(oidCCO);
  }

  private void intentarHomologar(Integer oidCCO) throws BaseException {
	  
	  // Instanciar el comprobante
	  FacturaCab facturaCab = null;
	  facturaCab = FacturaCab.findByOid(oidCCO, getSesion());
	  
	  IDataSet ds =  getDataSetUltComproHomoFE();
	  
	  //Verificar en AFIP si ya se encuentra homologada
	  JSONObject comproYaFueHomologado = getFactHomoFromAFIP(facturaCab,ds); 
	  	  
	  if ((comproYaFueHomologado!=null) && (!comproYaFueHomologado.has("error"))) {
		  	// Ya se encuentra homologado en AFIP		  
		  	// Actualizar los datos de homologacion del comprobante Factura
		  	StringBuffer mensCpmproHomologado = new StringBuffer("");
		  	mensCpmproHomologado.append("El comprobante ya se encuentra HOMOLOGADO.");
		  	mensCpmproHomologado.append("Informacion de Homologacion en AFIP.");
		  	mensCpmproHomologado.append(comproYaFueHomologado.toString());
		 	grabarDatosHomologacionFactura(facturaCab,comproYaFueHomologado,ds,mensCpmproHomologado);
		 	cargarRegistroCobrador(ds,mensCpmproHomologado.toString());
	  } else {
		  
		  	StringBuffer mensCpmproHomologado = new StringBuffer("");
		  	// InTentar Homologarlo
		  	if (homologarContraAfip(facturaCab,ds)) {
		  
		  		   
				  JSONObject comproYaFueHomologado2 = getFactHomoFromAFIP(facturaCab , ds); 
				  if ((comproYaFueHomologado2!=null) && (!comproYaFueHomologado2.has("error"))) {
					  mensCpmproHomologado.append("Se acaba de homogar el comprobante contra la AFIP.");
					  grabarDatosHomologacionFactura(facturaCab,comproYaFueHomologado2,ds,mensCpmproHomologado);
				  }
				  else {
					  String error = "";
					  if (comproYaFueHomologado2!=null)
						  error = comproYaFueHomologado2.toString();
					  mensCpmproHomologado.append("No se puedo homologar el comprobante"+error+".");
				  }
				  
		  	} else {
		  		
		  	}
		  	
		  	cargarRegistroCobrador(ds,mensCpmproHomologado.toString());
	  }
	  
	  writeCliente(ds);
	  
		  
  }
  
  private boolean homologarContraAfip(FacturaCab facturaCab , IDataSet ds) throws ExceptionValidation {
	 
	  	try {
		  
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
		json.put("nro_comprobante",facturaCab.getNroExt());
		json.put("pto_venta",facturaCab.getTalonario().getLugar_emision().getLugemi());
		json.put("tipo_documento",facturaCab.getSujeto().getTipo_documento().getCodigoFE()); 
		String nroDocu = "0";
		
		if (facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIL) ||
			facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIT)) {
			nroDocu = facturaCab.getSujeto().getSujeto_impositivo().getCuit(); 
		} else
			nroDocu = facturaCab.getSujeto().getNro_documento();
		
		Long longNroDocu = Long.parseLong(nroDocu);
		
		json.put("nro_documento",longNroDocu);
		
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
	    String strDate = dateFormat.format(facturaCab.getEmision());  
	    json.put("fecha_comprobante",strDate);
		json.put("imp_total",new Double(facturaCab.getTotal().doubleValue(2)));
		json.put("imp_neto",new Double(facturaCab.getNeto().doubleValue(2)));
		json.put("imp_iva",new Double(facturaCab.getIva().doubleValue(2)));
			
		String jsonInputString = json.toString();
		
		String response = "";
		
		
		OutputStream os = conn.getOutputStream(); 
		byte[] input = jsonInputString.getBytes("utf-8");
		os.write(input, 0, input.length);           
		
		
		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;)
			sb.append((char) c);
		response = sb.toString();
		
		
		JSONObject myResponse = null;
		try {
		
			myResponse = new JSONObject(response.toString());
		
		} catch(Exception e) {
			if (response!=null)
				response = response.replaceAll("\n", "");
			cargarRegistroCobrador(ds,"Homologar contra la AFIP "+response);
			//cargarRegistroCobrador(ds,"Homologar contra la AFIP ");
			
		}
		
		String cae = "";
		if ((myResponse!=null) && (myResponse.has("CAE")))
			cae = myResponse.getString("CAE");		
		String stringFecVto = "";
		if ((myResponse!=null) && (myResponse.has("CAEFchVto")))
			stringFecVto = myResponse.getString("CAEFchVto");

		if (cae==null) {
			cargarRegistroCobrador(ds,"Homologar contra AFIP.No se pudo obtener el CAE "+myResponse.toString());
			return false;
		}
		
		if ((cae!=null) && (cae.length()==0)) {
		 	cargarRegistroCobrador(ds,"Homologar contra AFIP.No se pudo obtener el CAE "+myResponse.toString());
			return false;
		}
		
		if (stringFecVto==null) {
		 	cargarRegistroCobrador(ds,"Homologar contra AFIP.No se pudo obtener el vencimiento del CAE "+myResponse.toString());
			return false;
		}
			
		if (stringFecVto.length()!=10) {
		 	cargarRegistroCobrador(ds,"Homologar contra AFIP.No se pudo obtener el vencimiento del CAE "+stringFecVto+" "+myResponse.toString());
			return false;
		}
		
		} catch(Exception e) {
			cargarRegistroCobrador(ds,"Homologar contra AFIP.Homologar contra AFIP "+e.getMessage());
			return false;
		}
	  	
	  	return true;

	  
  }
  
  private boolean grabarDatosHomologacionFactura(FacturaCab facturaCab,JSONObject comproYaFueHomologado, IDataSet ds , StringBuffer mensaje)  {
	  
	  
	  
	  boolean devolver = false;
	  
	  try {
	  
	  if (comproYaFueHomologado==null) { 
		  mensaje.append("No se encontro informacion del comprobante.");
		  return false;
	  }
	  
	  String cae = comproYaFueHomologado.getString("cae");		
	  String stringFecVto = comproYaFueHomologado.getString("vencimiento_cae");
	  Date fecVtoCae=new SimpleDateFormat("yyyyMMdd").parse(stringFecVto);
	  Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
	  String cuit = empresa.getCuit().replaceAll("-", "");
	  String nroDocu = "0";

	  if (facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIL) ||
		facturaCab.getSujeto().getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIT)) {
				nroDocu = facturaCab.getSujeto().getSujeto_impositivo().getCuit(); 
			} else
				nroDocu = facturaCab.getSujeto().getNro_documento();

	  
	  // Grabar Datos Fact. Electronica OK
	  FactElectronicaCab factEleCab = (FactElectronicaCab) FactElectronicaCab.getNew(FactElectronicaCab.NICKNAME, this.getSesion());
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
	  factEleCab.setOid_cco_asignado_a(facturaCab.getOIDInteger());
	  factEleCab.setCae(cae);
	  factEleCab.setVto_cae(fecVtoCae);
	  factEleCab.setRespuesta_ws_homo(comproYaFueHomologado.toString());
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
	  
	  mensaje.append("Se graba un registro de LOG de factura electronica de los datos homogados en AFIP.");
	  
	  if (((facturaCab.getTalonario()!=null) && (facturaCab.getTalonario().isFactElec())) && (cae!=null) && (cae.length()>0) && (fecVtoCae!=null)) {
			
			FacturaElectronicaCab.actualizarFactElectronica(
					new Date(), 
					this.getSesion().getLogin().getUsuario().getCodigo(), 
					cae,
					fecVtoCae, 
					facturaCab.getOID(), 
					this.getSesion());
			
			mensaje.append("Se actualizo la FACTURA en el sistemas con los datos del CAE y VTO.");
			
	  }
	  
	  this.getSesion().commitTransaction();
	  return true;
	  }
	  catch(Exception e) {
		  
		  	mensaje.append("Error al quere reactualizar los datos HOMOLOGADOS en AFIP en la FACTURA del sistema: ");
		  	mensaje.append(e.getMessage());
		  
		  
		    return false;
	  }
	  
  }
  
  private JSONObject getFactHomoFromAFIP(FacturaCab facturaCab , IDataSet ds) throws BaseException {
	  
	  if (!facturaCab.getTalonario().isFactElec()) {
		  cargarRegistroCobrador(ds,"El talonario del comprobante no corresponde a Factura Electronica");
		  return null;
	  }
	  
		Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
		String cuit = empresa.getCuit().replaceAll("-", "");
		Integer tcFE = facturaCab.getTalonario().getCodigoTCFactEle();
		JSONObject myResponse = null;
		
		String url =  ValorParametro.findByCodigoParametro("URL_INFO_FACT_ELEC_HOMOLOG", this.getSesion()).getValorCadena();
		URL obj;
		try {
			url += "?cuit="+cuit+"&tipo_comprobante="+tcFE+"&nro_comprobante="+facturaCab.getNroExt()+"&pto_venta="+facturaCab.getLugarEmision().getLugemi();
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();			
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			
			if (responseCode!=200) {
				cargarRegistroCobrador(ds,"Código de error llamda WS:"+responseCode);
				return null;
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			//System.out.println(response.toString());
			
			try {
				myResponse = new JSONObject(response.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				cargarRegistroCobrador(ds,"Obtener info AFIP "+e.getMessage());
			}
			/*
			respuesta = respuesta + "concepto - " + myResponse.getString("concepto") + Util.ENTER();
			respuesta = respuesta + "tipo_documento - " + myResponse.getString("tipo_documento") + Util.ENTER();
			respuesta = respuesta + "fecha_comprobante - " + myResponse.getString("fecha_comprobante")+ Util.ENTER();
			respuesta = respuesta + "cae - " + myResponse.getString("cae")+ Util.ENTER();			
			respuesta = respuesta + "vencimiento_cae - " + myResponse.getString("vencimiento_cae")+ Util.ENTER();
			respuesta = respuesta + "fecha_proceso - " + myResponse.getString("fecha_proceso")+ Util.ENTER();
			respuesta = respuesta + "imp_total - " + myResponse.getString("imp_total")+ Util.ENTER();	
			respuesta = respuesta + "imp_tot_conc - " + myResponse.getString("imp_tot_conc")+ Util.ENTER();		
			respuesta = respuesta + "imp_neto - " + myResponse.getString("imp_neto")+ Util.ENTER();
			respuesta = respuesta + "imp_op_ex - " + myResponse.getString("imp_op_ex")+ Util.ENTER();			
			respuesta = respuesta + "imp_trib - " + myResponse.getString("imp_trib")+ Util.ENTER();	
			respuesta = respuesta + "imp_iva - " + myResponse.getString("imp_iva")+ Util.ENTER();
			*/
		} catch (MalformedURLException e) {
			cargarRegistroCobrador(ds,"Obtener info AFIP "+e.getMessage());
		} catch (IOException e) {
			cargarRegistroCobrador(ds,"Obtener info AFIP "+e.getMessage());
		}

	  
	  return myResponse;
	  
  }
  
  private IDataSet getDataSetUltComproHomoFE() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TInfoComproHomologado");
	    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
	    return dataset;
	  }

	  private void cargarRegistroCobrador(IDataSet dataset,
	                         String comentario) {
	    dataset.append();
	    dataset.fieldValue("comentario", comentario);
	  }
  
   

}
