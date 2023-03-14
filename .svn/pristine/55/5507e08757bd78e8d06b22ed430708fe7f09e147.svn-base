package com.srn.erp.general.op;

import com.srn.erp.general.bm.ComproCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientoCompro extends Operation {

  public TraerComportamientoCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidCCO = mapaDatos.getInteger("oid_cco");
	ComproCab comprobante = ComproCab.findByOidProxyCompro(oidCCO, this.getSesion());
	
	IDataSet ds = this.getDataSet();
	cargarRegistro(ds, comprobante);
	writeCliente(ds);
	  
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComporComprobante");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         ComproCab comprobante) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco", comprobante.getOIDInteger());
    dataset.fieldValue("oid_tc", comprobante.getTipoCompro().getOIDInteger());
    dataset.fieldValue("letra", comprobante.getLetra());
    dataset.fieldValue("oid_lug_emi", comprobante.getLugarEmision().getOIDInteger());
    dataset.fieldValue("nro_ext", comprobante.getNroExt());
    dataset.fieldValue("comportamiento", comprobante.getComportamiento());
    dataset.fieldValue("activo", comprobante.isActivo());
    
  }
}
