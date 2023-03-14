package com.srn.erp.ventas.op;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 

import org.json.JSONException;
import org.json.JSONObject;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Empresa;

import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInfoComproHomoFE extends Operation {

  public TraerInfoComproHomoFE() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    ComproCab compro = null;
    Integer oid = mapaDatos.getInteger("oid_cco");
    compro = ComproCab.findByOidCompro(oid, getSesion());
    
    if (!compro.getTalonario().isFactElec())
    	throw new ExceptionValidation(null,"El talonario del comprobante no corresponde a Factura Electronica");
    
	Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
	String cuit = empresa.getCuit().replaceAll("-", "");
	
	Integer tcFE = compro.getTalonario().getCodigoTCFactEle();
	
	String respuesta = "";
	StringBuffer response = new StringBuffer();
	
	String url =  ValorParametro.findByCodigoParametro("URL_INFO_FACT_ELEC_HOMOLOG", this.getSesion()).getValorCadena();
	URL obj;
	try {
		url += "?cuit="+cuit+"&tipo_comprobante="+tcFE+"&nro_comprobante="+compro.getNroExt()+"&pto_venta="+compro.getLugarEmision().getLugemi();
		obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();			
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		
		
		respuesta = respuesta + "URL : " + url + Util.ENTER();
		respuesta = respuesta + "Respuesta : " + responseCode + Util.ENTER();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//System.out.println(response.toString());
		JSONObject myResponse = null;
		try {
			myResponse = new JSONObject(response.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			if (response!=null)
				respuesta = respuesta + response.toString() + Util.ENTER();
		}
		//respuesta = respuesta + "concepto - " + myResponse.getString("concepto") + Util.ENTER();
		
		if ((myResponse!=null) && myResponse.has("tipo_documento")) 
			respuesta = respuesta + "tipo_documento - " + myResponse.getString("tipo_documento") + Util.ENTER();
		if ((myResponse!=null) && myResponse.has("fecha_comprobante")) 
			respuesta = respuesta + "fecha_comprobante - " + myResponse.getString("fecha_comprobante")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("cae"))
			respuesta = respuesta + "cae - " + myResponse.getString("cae")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("vencimiento_cae"))
			respuesta = respuesta + "vencimiento_cae - " + myResponse.getString("vencimiento_cae")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("fecha_proceso"))
			respuesta = respuesta + "fecha_proceso - " + myResponse.getString("fecha_proceso")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("imp_total"))
			respuesta = respuesta + "imp_total - " + myResponse.getString("imp_total")+ Util.ENTER();	
		if ((myResponse!=null) && myResponse.has("imp_tot_conc"))
			respuesta = respuesta + "imp_tot_conc - " + myResponse.getString("imp_tot_conc")+ Util.ENTER();		
		if ((myResponse!=null) && myResponse.has("imp_neto"))
			respuesta = respuesta + "imp_neto - " + myResponse.getString("imp_neto")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("imp_op_ex"))
			respuesta = respuesta + "imp_op_ex - " + myResponse.getString("imp_op_ex")+ Util.ENTER();			
		if ((myResponse!=null) && myResponse.has("imp_trib"))
			respuesta = respuesta + "imp_trib - " + myResponse.getString("imp_trib")+ Util.ENTER();	
		if ((myResponse!=null) && myResponse.has("imp_iva"))
			respuesta = respuesta + "imp_iva - " + myResponse.getString("imp_iva")+ Util.ENTER();
		if ((myResponse!=null) && myResponse.has("error")) {
			respuesta = respuesta + myResponse.toString()	+ Util.ENTER();
			if (responseCode==200) 
				respuesta = respuesta + "No hay información para el comprobante seleccionado" + Util.ENTER();
			
		}
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	IDataSet datasetUltComproFE = getDataSetUltComproHomoFE();
    cargarRegistroCobrador(datasetUltComproFE,respuesta);
    writeCliente(datasetUltComproFE);
    
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
