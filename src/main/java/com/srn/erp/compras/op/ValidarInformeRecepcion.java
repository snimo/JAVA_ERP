package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.InformeRecepcion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarInformeRecepcion extends Operation { 

  public ValidarInformeRecepcion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    InformeRecepcion informeRecepcion = null;
    String identificador = mapaDatos.getString("identificador");
    informeRecepcion = InformeRecepcion.getInformeRecepcion(identificador,getSesion());
    IDataSet dsValInfRec = getDataSetInformeRecepcion();
    if (informeRecepcion != null)  
    	cargarRegistroInfRec(dsValInfRec,informeRecepcion);
    writeCliente(dsValInfRec);
  }

  private IDataSet getDataSetInformeRecepcion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValidadorInfRec");
    dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emi", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_prov", Field.STRING, 100));
    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroInfRec(IDataSet dataset, 
                         			InformeRecepcion informeRecepcion) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_inf_rec", informeRecepcion.getOIDInteger()); 
	    dataset.fieldValue("codigo", informeRecepcion.getCodigo());
	    dataset.fieldValue("oid_tc", informeRecepcion.getTipoCompro().getOIDInteger());
	    dataset.fieldValue("letra", informeRecepcion.getLetra());
	    dataset.fieldValue("oid_lug_emi", informeRecepcion.getLugarEmision().getOIDInteger());
	    dataset.fieldValue("nro_ext", informeRecepcion.getNroExt());
	    dataset.fieldValue("fec_emi", informeRecepcion.getEmision());
	    dataset.fieldValue("oid_prov", informeRecepcion.getProveedor().getOIDInteger());
	    dataset.fieldValue("cod_prov", informeRecepcion.getProveedor().getCodigo());
	    dataset.fieldValue("rs_prov", informeRecepcion.getProveedor().getRazonsocial());
	    dataset.fieldValue("anulado", new Boolean(!informeRecepcion.isActivo().booleanValue()));
  }
}
