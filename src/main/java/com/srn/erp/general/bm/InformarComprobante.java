package com.srn.erp.general.bm;

import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InformarComprobante {

  IDataSet dataset = null; 
	
  private Integer oidCCO;
  private String descComprobante;

  public InformarComprobante(Integer oidCCO,
  		                       String descComprobante
                             ) throws BaseException {
    this.oidCCO = oidCCO;
    this.descComprobante = descComprobante;
  }
  
  public InformarComprobante() {
	  dataset = getEstrucDataSetInfoCompro();
  }
  
  public IDataSet getDataSet() {
	  return dataset;
  }

  private IDataSet getEstrucDataSetInfoCompro() {
    dataset = new TDataSet();
    dataset.create("TInfoComprobante");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_comprobante", Field.STRING, 100));
    return dataset;
  }

  public void cargarInfoCompro(ComproCab aComproCab) throws BaseException {
	    dataset.append();
	    dataset.fieldValue("oid_cco", aComproCab.getOIDInteger());
	    dataset.fieldValue("desc_comprobante", aComproCab.getDescripcion());
  }
  
  public IDataSet getDataSetInfoCompro() throws BaseException {
    IDataSet dataset = getEstrucDataSetInfoCompro();
    dataset.append();
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("desc_comprobante", this.descComprobante);
    return dataset;
  }




}
