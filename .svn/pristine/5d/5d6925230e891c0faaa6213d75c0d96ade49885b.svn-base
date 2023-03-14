package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.bm.MotivoRechazoInfCC;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveInformeControlCalidad extends Operation { 

  InformeControlCalidad informeControlCalidad = null;
  ComproCab comprobante = null;
  
  public SaveInformeControlCalidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TInformeControlCalidad"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first(); 
    while (!dataset.EOF()) {
    	
    	informeControlCalidad = InformeControlCalidad.findByOid(dataset.getInteger("oid_inf_cc"),getSesion());
    	
    	
        if (dataset.getBoolean("activo").booleanValue()==false) {
        	anularInformeControlCalidad(informeControlCalidad);
        	dataset.next();
        	continue;
        }
        
        // Datos cabecera del Comprobante
        informeControlCalidad.setContabiliza(InformeControlCalidad.getContabilizarInformeCC(getSesion()));
        informeControlCalidad.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        informeControlCalidad.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        informeControlCalidad.setLetra(dataset.getString("letra"));
        informeControlCalidad.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        informeControlCalidad.setNroext(dataset.getInteger("nro_ext"));
        informeControlCalidad.setEmision(dataset.getDate("fec_emision"));
        informeControlCalidad.setImputac(dataset.getDate("fec_emision"));
        informeControlCalidad.setComentario(dataset.getString("comentario"));
        informeControlCalidad.setActuStock(true);
        comprobante = informeControlCalidad; 
        
        IDataSet dsInfCCDet = dataset.getDataSet("TInformeControlCalidadDet");
        dsInfCCDet.first();
        while (!dsInfCCDet.EOF()) {
        	
            // Obtener cantidades
            Double cantOKEnUS = new Double(0);
            if (dsInfCCDet.getDouble("ok_us")!=null)
            	cantOKEnUS = dsInfCCDet.getDouble("ok_us");
            Double cantMalEnUS = new Double(0);
            if (dsInfCCDet.getDouble("rechazos_us")!=null)
            	cantMalEnUS = dsInfCCDet.getDouble("rechazos_us");
        	
        	
        	if ((cantOKEnUS.doubleValue()==0) && (cantMalEnUS.doubleValue()==0))
        		continue;
        	
        	InformeControlCalidadDet infCCDet = InformeControlCalidadDet.findByOid(dsInfCCDet.getInteger("oid_cc_det"),getSesion());
        	infCCDet.setInforme_cc(informeControlCalidad);
        	infCCDet.setCant_ok_us(cantOKEnUS);
        	infCCDet.setCant_mal_us(cantMalEnUS);
        	infCCDet.setObservaciones(dsInfCCDet.getString("comentario"));
        	
        	// Detalle del Informe de Recepcion
        	InformeRecepcionDet infRecDet = InformeRecepcionDet.findByOidProxy(dsInfCCDet.getInteger("oid_inf_rec_det"),getSesion());
        	infCCDet.setInforme_recepcion_det(infRecDet);
        	Proveedor proveedor = infRecDet.getInforme_recepcion().getProveedor();
        	Money cantOKUC = infRecDet.getProducto().getConvertirUM(proveedor,
        												  cantOKEnUS,
        			                                      infRecDet.getUnidadMedidaStock(),
        			                                      infRecDet.getUnidadMedidaCompra());
        	Money cantMalUC = infRecDet.getProducto().getConvertirUM(proveedor,
        												   cantMalEnUS,
                    									   infRecDet.getUnidadMedidaStock(),
                    									   infRecDet.getUnidadMedidaCompra());
        	infCCDet.setCant_ok_uc(cantOKUC.doubleValue());
        	infCCDet.setCant_mal_uc(cantMalUC.doubleValue());
        	
        	if (infCCDet.getCant_mal_us().doubleValue()>0)
        		infCCDet.setPend_ret_prov(new Boolean(true));
        	
        	informeControlCalidad.addDetalleInfCC(infCCDet);
        	
        	// Guardar los motivos de rechados
        	IDataSet dsMotivosRechazo = dsInfCCDet.getDataSet("TMotivosRechazoInfCC");
        	dsMotivosRechazo.first();
        	while (!dsMotivosRechazo.EOF()) {
        		MotivoRechazoInfCC motivoRechazo = MotivoRechazoInfCC.findByOid(dsMotivosRechazo.getInteger("oid_mot_rech_cc"),getSesion());
        		motivoRechazo.setInf_cc_det(infCCDet);
        		motivoRechazo.setCant_mal_us(dsMotivosRechazo.getDouble("cant_mal_us"));
        		cantMalUC = infRecDet.getProducto().getConvertirUM(proveedor,
        				   dsMotivosRechazo.getDouble("cant_mal_us"),
						   infRecDet.getUnidadMedidaStock(),
						   infRecDet.getUnidadMedidaCompra());
        		motivoRechazo.setCant_mal_uc(cantMalUC.doubleValue());
        		motivoRechazo.setMotivoRechazoCC(MotivoRechazoCC.findByOidProxy(dsMotivosRechazo.getInteger("oid_motivo"),getSesion()));
        		motivoRechazo.setActivo(new Boolean(true));
        		
        		infCCDet.addMotivoRechazo(motivoRechazo);
        		
        		dsMotivosRechazo.next();
        	}
        	
        	
        	
        	dsInfCCDet.next();
        }
        addTransaccion(informeControlCalidad);
    	dataset.next();
    }
  }
  
  private void anularInformeControlCalidad(InformeControlCalidad informeControlCalidad) throws BaseException {
	  informeControlCalidad.delete();
	  addTransaccion(informeControlCalidad);
  }
  
  protected void afterSave() throws BaseException {
	  
	  if (informeControlCalidad.getAnuladorInfCC()!=null)
		  comprobante = informeControlCalidad.getAnuladorInfCC();
	  
	  if (comprobante!=null) {
        InformarComprobante infoCompro = new InformarComprobante(
        		comprobante.getOIDInteger(),
        		comprobante.getDescripcion());
        writeCliente(infoCompro.getDataSetInfoCompro());
	  }
	  else {
		  
	  }
  }
  
  
  
}
