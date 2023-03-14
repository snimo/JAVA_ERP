package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.InformeControlCalidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarInformeControlCalidad extends Operation { 

  public ValidarInformeControlCalidad() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    InformeControlCalidad informeControlCalidad = null;
    String identificador = mapaDatos.getString("identificador");
    informeControlCalidad = InformeControlCalidad.getInformeCC(identificador,getSesion());
    IDataSet dsValInfCC = getDataSetInfCC();
    if (informeControlCalidad != null)  
    	cargarRegistroInfCC(dsValInfCC,informeControlCalidad);
    writeCliente(dsValInfCC);
  }

  private IDataSet getDataSetInfCC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValidadorInfCC");
    dataset.fieldDef(new Field("oid_cc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emi", Field.DATE, 0));
    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroInfCC(IDataSet dataset, 
                         		   InformeControlCalidad informeControlCalidad) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_cc", informeControlCalidad.getOIDInteger()); 
	    dataset.fieldValue("codigo", informeControlCalidad.getCodigo());
	    dataset.fieldValue("oid_tc", informeControlCalidad.getTipoCompro().getOIDInteger());
	    dataset.fieldValue("letra", informeControlCalidad.getLetra());
	    dataset.fieldValue("oid_lug_emi", informeControlCalidad.getLugarEmision().getOIDInteger());
	    dataset.fieldValue("nro_ext", informeControlCalidad.getNroExt());
	    dataset.fieldValue("fec_emi", informeControlCalidad.getEmision());
	    dataset.fieldValue("anulado", new Boolean(!informeControlCalidad.isActivo().booleanValue()));
  }
}
