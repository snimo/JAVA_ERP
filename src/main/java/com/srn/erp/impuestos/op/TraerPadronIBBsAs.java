package com.srn.erp.impuestos.op;


import java.util.Iterator;

import com.srn.erp.ventas.bm.TablaPercIBBsAs;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPadronIBBsAs extends Operation {

  public TraerPadronIBBsAs() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = this.getDataTablaPercIB();
	
	String cuit = null;
	if (mapaDatos.containsKey("cuit"))
		cuit = mapaDatos.getString("cuit");
	
	java.util.Date fecVigDesde = null;
	if (mapaDatos.containsKey("fec_desde"))
		fecVigDesde = mapaDatos.getDate("fec_desde");
	
	java.util.Date fecVigHasta = null;
	if (mapaDatos.containsKey("fec_hasta"))
		fecVigHasta = mapaDatos.getDate("fec_hasta");
	
	Iterator iterTabla =
		TablaPercIBBsAs.getConsultaMasiva(cuit,fecVigDesde,fecVigHasta,this.getSesion()).iterator();
	while (iterTabla.hasNext()) {
		TablaPercIBBsAs tablaPerc = (TablaPercIBBsAs) iterTabla.next();
		cargarRegistro(ds,tablaPerc);
		tablaPerc = null;
		
	}
	
	writeCliente(ds);
	
	
  }

  private IDataSet getDataTablaPercIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TPadronPercIBBsAs");
    dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
    dataset.fieldDef(new Field("OID_PERC_IB", Field.INTEGER,0));
    dataset.fieldDef(new Field("FEC_PUBLIC", Field.DATE,0));
    dataset.fieldDef(new Field("FEC_VIG_DESDE", Field.DATE,0));
    dataset.fieldDef(new Field("FEC_VIG_HASTA", Field.DATE,0));
    dataset.fieldDef(new Field("CUIT", Field.STRING,50));
    dataset.fieldDef(new Field("TIPO", Field.STRING,50));
    dataset.fieldDef(new Field("MARCA_AB_SUJETO", Field.STRING,50));
    dataset.fieldDef(new Field("MARCA_CAMBIO_ALI", Field.STRING,50));
    dataset.fieldDef(new Field("ALI_PERCEPCION", Field.CURRENCY,0));
    dataset.fieldDef(new Field("ALI_RETENCION", Field.CURRENCY,0));
    dataset.fieldDef(new Field("NRO_GR_RET", Field.INTEGER,0));
    dataset.fieldDef(new Field("NRO_GR_PER", Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         TablaPercIBBsAs tablaPercIBBsAs) throws BaseException {
    dataset.append();
    dataset.fieldValue("activo", new Boolean(true));
    dataset.fieldValue("OID_PERC_IB", tablaPercIBBsAs.getOIDInteger());
    dataset.fieldValue("FEC_PUBLIC", tablaPercIBBsAs.getFec_public());
    dataset.fieldValue("FEC_VIG_DESDE", tablaPercIBBsAs.getFec_vig_desde());
    dataset.fieldValue("FEC_VIG_HASTA", tablaPercIBBsAs.getFec_vig_hasta());
    dataset.fieldValue("CUIT", tablaPercIBBsAs.getCuit());
    dataset.fieldValue("TIPO", tablaPercIBBsAs.getTipo());
    dataset.fieldValue("MARCA_AB_SUJETO", tablaPercIBBsAs.getMarca_ab_sujeto());
    dataset.fieldValue("MARCA_CAMBIO_ALI", tablaPercIBBsAs.getMarca_cambio_ali());
    dataset.fieldValue("ALI_PERCEPCION", tablaPercIBBsAs.getAli_percepcion());
    dataset.fieldValue("ALI_RETENCION", tablaPercIBBsAs.getAli_retencion());
    dataset.fieldValue("NRO_GR_RET", tablaPercIBBsAs.getNro_gr_ret());
    dataset.fieldValue("NRO_GR_PER", tablaPercIBBsAs.getNro_gr_per());
  }
}
