package com.srn.erp.pagos.op;


import java.util.Iterator;

import com.srn.erp.pagos.bm.CtaHabMotivoPagosVarios;
import com.srn.erp.pagos.bm.MotivoPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoPago extends Operation {

  public TraerMotivoPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    MotivoPago motivopago = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       motivopago = MotivoPago.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       motivopago = MotivoPago.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetMotivoPago = getDataSetMotivoPago();
    IDataSet datasetCtasHab = getDataSetCtaHabMotivoPagosVarios();
    
    if (motivopago != null) {
        cargarRegistroMotivoPago(datasetMotivoPago,
                         motivopago.getOIDInteger(),
                         motivopago.getCodigo(),
                         motivopago.getDescripcion(),
                         motivopago.getCompo(),
                         motivopago.isActivo());
        
        Iterator iterCtasHabPagVarios = 
        	motivopago.getCtasHabPagosVarios().iterator();
        while (iterCtasHabPagVarios.hasNext()) {
        	 CtaHabMotivoPagosVarios ctaHabPagVar = (CtaHabMotivoPagosVarios) iterCtasHabPagVarios.next();
        	 cargarRegistroCtaHabMotivoPagosVarios(datasetCtasHab, ctaHabPagVar);
        }
        
    }
    
    writeCliente(datasetMotivoPago);
    writeCliente(datasetCtasHab);
    
  }

  private IDataSet getDataSetMotivoPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMotivoPago");
    dataset.fieldDef(new Field("oid_motivo_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("compo", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroMotivoPago(IDataSet dataset,
                         Integer oid_motivo_pago,
                         String codigo,
                         String descripcion,
                         String compo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_motivo_pago", oid_motivo_pago);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetCtaHabMotivoPagosVarios() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCtaHabMotivoPagosVarios");
	    dataset.fieldDef(new Field("oid_cta_hab", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_motivo_pago", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }

	  private void cargarRegistroCtaHabMotivoPagosVarios(IDataSet dataset, 
	                         CtaHabMotivoPagosVarios catHabMotPagVar) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_cta_hab", catHabMotPagVar.getOIDInteger());
	    dataset.fieldValue("oid_motivo_pago", catHabMotPagVar.getMotivo_pago().getOIDInteger());
	    dataset.fieldValue("oid_ana_con", catHabMotPagVar.getCuenta().getOIDInteger());
	    dataset.fieldValue("cod_ana_con", catHabMotPagVar.getCuenta().getCodigo());
	    dataset.fieldValue("desc_ana_con", catHabMotPagVar.getCuenta().getDescripcion());
	    dataset.fieldValue("activo", catHabMotPagVar.isActivo());
	  }  
  
}
