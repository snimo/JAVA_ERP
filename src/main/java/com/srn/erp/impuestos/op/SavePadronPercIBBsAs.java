package com.srn.erp.impuestos.op;

import com.srn.erp.ventas.bm.TablaPercIBBsAs;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePadronPercIBBsAs extends Operation {

  public SavePadronPercIBBsAs() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TInput");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
    	  
    	IDataSet dsPadron = dataset.getDataSet("TPadronPercIBBsAs");
    	dsPadron.first();
    	while (!dsPadron.EOF()) {
    		TablaPercIBBsAs padron = TablaPercIBBsAs.findByOid(dsPadron.getInteger("OID_PERC_IB"), this.getSesion());
    		padron.setFec_public(dsPadron.getDate("FEC_PUBLIC"));
    		padron.setFec_vig_desde(dsPadron.getDate("FEC_VIG_DESDE"));
    		padron.setFec_vig_hasta(dsPadron.getDate("FEC_VIG_HASTA"));
    		padron.setCuit(dsPadron.getString("CUIT"));
    		padron.setTipo(dsPadron.getString("TIPO"));
    		padron.setMarca_ab_sujeto(dsPadron.getString("MARCA_AB_SUJETO"));
    		padron.setMarca_cambio_ali(dsPadron.getString("MARCA_CAMBIO_ALI"));
    		padron.setAli_percepcion(dsPadron.getPorcentaje("ALI_PERCEPCION"));
    		padron.setAli_retencion(dsPadron.getPorcentaje("ALI_RETENCION"));
    		padron.setNro_gr_per(dsPadron.getInteger("NRO_GR_PER"));
    		padron.setNro_gr_ret(dsPadron.getInteger("NRO_GR_RET"));
    		
    		if (dsPadron.getBoolean("activo").booleanValue()==false)
    			padron.delete();
    			
    		
    		
    		
    		padron.save();
    		
    		padron = null;
    		
    		dsPadron.next();
    	}
    	
        dataset.next();
    }
  }

}
