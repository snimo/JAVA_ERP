	package com.srn.erp.ventas.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDatosCabFactImpFiscal extends Operation {

	PedidoCab pedido = null;
	String oc = null;
	
  public TraerDatosCabFactImpFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oidSujeto = mapaDatos.getInteger("oid_sujeto");
  	Integer oidTalonario = mapaDatos.getInteger("oid_talonario");
  	
  	Sujeto sujeto = null;
  	Proveedor proveedor = null;
  	Deposito deposito = null;
  	
  	if (mapaDatos.containsKey("es_proveedor"))
  		proveedor = Proveedor.findByOid(oidSujeto,this.getSesion());
  	else
  	  	if (mapaDatos.containsKey("es_deposito"))
  	  		deposito = Deposito.findByOid(oidSujeto,this.getSesion());
  	  	else
  	  		sujeto = Sujeto.findByOid(oidSujeto,this.getSesion());
  	
  	Talonario talonario = Talonario.findByOid(oidTalonario,this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_cco_ped")) {
  		Integer oidPedido = mapaDatos.getInteger("oid_cco_ped");
  		pedido = PedidoCab.findByOid(oidPedido,this.getSesion());
  	}
  	
  	if (pedido!=null) 
  		oc = pedido.getOrdenDeCompra();
  	
  	
    IDataSet ds = this.getDataSetCabFactImpFiscal();
    cargarRegistro(ds,sujeto,proveedor,deposito,talonario,pedido,oc);
    
    writeCliente(ds);
  }

  private IDataSet getDataSetCabFactImpFiscal() {
  	
    IDataSet dataset = new TDataSet();
    dataset.create("TDatosCabFactImpFiscal");
    
    dataset.fieldDef(new Field("linea_1_encabezado", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_2_encabezado", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_3_encabezado", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_4_encabezado", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_5_encabezado", Field.STRING, 100));
    
    dataset.fieldDef(new Field("linea_1_pie", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_2_pie", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_3_pie", Field.STRING, 100));
    dataset.fieldDef(new Field("linea_4_pie", Field.STRING, 100));
    
    dataset.fieldDef(new Field("driver", Field.STRING, 100));
    dataset.fieldDef(new Field("marca", Field.STRING, 100));
    dataset.fieldDef(new Field("modelo", Field.STRING, 100));
    dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("baudios", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("max_cant_carac_linea", Field.INTEGER, 0));
    dataset.fieldDef(new Field("max_cant_lineas_item", Field.INTEGER, 0));
    dataset.fieldDef(new Field("max_cant_tot_carac_item", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("tipo_comprobante", Field.STRING, 100));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_documento", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_docu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("categoria_iva", Field.STRING, 100));
    dataset.fieldDef(new Field("direccion", Field.STRING, 100));
    
    dataset.fieldDef(new Field("modo_impresion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("path_gen_arch_imp", Field.STRING, 255));
    dataset.fieldDef(new Field("activar_check_error", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activar_log_imp_fis", Field.BOOLEAN, 0));
    
    
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet ds, 
  		                      Sujeto sujeto,
  		                      Proveedor proveedor,
  		                      Deposito deposito,
                              Talonario talonario,
                              PedidoCab pedido,
                              String oc) throws BaseException {
    ds.append();

    ds.fieldValue("linea_1_encabezado", FacturaCab.getLinea1CabImpFact(this.getSesion(),pedido,oc));
    ds.fieldValue("linea_2_encabezado", FacturaCab.getLinea2CabImpFact(this.getSesion(),pedido,oc));
    ds.fieldValue("linea_3_encabezado", FacturaCab.getLinea3CabImpFact(this.getSesion(),pedido,oc));
    ds.fieldValue("linea_4_encabezado", FacturaCab.getLinea4CabImpFact(this.getSesion(),pedido,oc));
    ds.fieldValue("linea_5_encabezado", FacturaCab.getLinea5CabImpFact(this.getSesion(),pedido,oc));
    
    ds.fieldValue("linea_1_pie", "");
    ds.fieldValue("linea_2_pie", "");
    ds.fieldValue("linea_3_pie", "");
    ds.fieldValue("linea_4_pie", "");
    
    if ((talonario!=null) && (talonario.getImpresora_fiscal()!=null)) {
      ds.fieldValue("driver", talonario.getImpresora_fiscal().getDriver());
      ds.fieldValue("marca", talonario.getImpresora_fiscal().getModeloParaImpresor());
      ds.fieldValue("modelo", talonario.getImpresora_fiscal().getModeloParaImpresor());
      ds.fieldValue("puerto", talonario.getImpresora_fiscal().getPuerto());
      ds.fieldValue("baudios", talonario.getImpresora_fiscal().getBaudios());
    } else {
      ds.fieldValue("driver", "");
      ds.fieldValue("marca", "");
      ds.fieldValue("modelo", "");
      ds.fieldValue("puerto", 0);
      ds.fieldValue("baudios", 0);
    }
    
    ds.fieldValue("max_cant_carac_linea", new Integer(50));
    ds.fieldValue("max_cant_lineas_item", new Integer(4));
    ds.fieldValue("max_cant_tot_carac_item", new Integer(200));
    
    
    ds.fieldValue("tipo_comprobante", talonario.getTipoComproImpFiscal());
    if (sujeto!=null) {
      ds.fieldValue("razon_social", sujeto.getSujeto_impositivo().getRazon());
      ds.fieldValue("tipo_documento", sujeto.getTipoDocuImpFiscal());
      ds.fieldValue("nro_docu", sujeto.getNroDocuImpFiscal());
      if (sujeto.getSujeto_impositivo() == null)
      	throw new ExceptionValidation(null,"No se pudo encontrar sujeto impositivo para el cliente "+
    			       sujeto.getCodigo()+" - "+sujeto.getRazon_social());
      ds.fieldValue("categoria_iva", sujeto.getSujeto_impositivo().getCategiva().getCategIVAImpFiscal());
      String direccionCompleta = sujeto.getDireccionCompleta();
      if ((direccionCompleta!=null) && (direccionCompleta.length()>0))
    	  ds.fieldValue("direccion", direccionCompleta);
      else
    	  ds.fieldValue("direccion", "."); // Para la impresora fiscal
      
    } else
    	if (proveedor!=null) {
    	      ds.fieldValue("razon_social", proveedor.getSujetoimpositivo().getRazon());
    	      ds.fieldValue("tipo_documento", proveedor.getTipoDocuImpFiscal());
    	      ds.fieldValue("nro_docu", proveedor.getNroDocuImpFiscal());
    	      if (proveedor.getSujetoimpositivo() == null)
    	      	throw new ExceptionValidation(null,"No se pudo encontrar sujeto impositivo para el proveedor "+
    	    			       proveedor.getCodigo()+" - "+proveedor.getRazonsocial());
    	      ds.fieldValue("categoria_iva", proveedor.getSujetoimpositivo().getCategiva().getCategIVAImpFiscal());
    	      String direccionCompleta = proveedor.getDireccionCompleta();
    	      if ((direccionCompleta!=null) && (direccionCompleta.length()>0))
    	    	  ds.fieldValue("direccion", direccionCompleta);
    	      else
    	    	  ds.fieldValue("direccion", "."); // Para la impresora fiscal
    	      
    		
    	}
    else if (deposito!=null) {
    	
    	  Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
    	
	      ds.fieldValue("razon_social", empresa.getRazon_social());
	      ds.fieldValue("tipo_documento", TipoDocumento.getTipoDocuCUITImpFiscal());
	      ds.fieldValue("nro_docu", empresa.getCuit().replace("-", ""));
	      ds.fieldValue("categoria_iva", empresa.getCategoria_iva().getCategIVAImpFiscal());
	      String direccionCompleta = deposito.getDireccionCompleta();
	      if ((direccionCompleta!=null) && (direccionCompleta.length()>0))
	    	  ds.fieldValue("direccion", direccionCompleta);
	      else
	    	  ds.fieldValue("direccion", "."); // Para la impresora fiscal
	      
		
	} else
    {
      ds.fieldValue("razon_social", "");
      ds.fieldValue("tipo_documento", "");
      ds.fieldValue("nro_docu", 0);
      ds.fieldValue("categoria_iva", "");
      ds.fieldValue("direccion", "");
    }
    
    if (talonario.getImpresora_fiscal()!=null)
    	ds.fieldValue("modo_impresion", 
    		Talonario.getModoImpresionControladorFiscal(talonario.getImpresora_fiscal().getComportamiento()));
    else
    	ds.fieldValue("modo_impresion",0);
    if (talonario.getImpresora_fiscal()!=null)
    	ds.fieldValue("path_gen_arch_imp", talonario.getImpresora_fiscal().getPathGenArch());
    else
    	ds.fieldValue("path_gen_arch_imp", "");
    
    ds.fieldValue("activar_check_error", ImpresionFactura.isCheckErrorImpFiscal(this.getSesion()));
    ds.fieldValue("activar_log_imp_fis", ImpresionFactura.isActivarLogImpFiscal(this.getSesion()));
    
  }
}
