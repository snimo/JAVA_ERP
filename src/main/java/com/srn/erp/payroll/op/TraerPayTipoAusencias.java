package com.srn.erp.payroll.op;

import com.srn.erp.payroll.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPayTipoAusencias extends Operation { 

  public TraerPayTipoAusencias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PayTipoAusencias paytipoausencias = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       paytipoausencias = PayTipoAusencias.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       paytipoausencias = PayTipoAusencias.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPayTipoAusencias = getDataSetPayTipoAusencias();
    if (paytipoausencias != null) { 
        cargarRegistroPayTipoAusencias(datasetPayTipoAusencias, 
                         paytipoausencias.getCodigoActual(),
                         paytipoausencias.getCotab(),
                         paytipoausencias.getDescrip());
    }
    writeCliente(datasetPayTipoAusencias);
  }

  private IDataSet getDataSetPayTipoAusencias() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPayTipoAusencias");
    dataset.fieldDef(new Field("CODIGO", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("COTAB", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("DESCRIP", Field.STRING, 200)); 
    return dataset;
  }

  private void cargarRegistroPayTipoAusencias(IDataSet dataset, 
                         Integer CODIGO,
                         Integer COTAB,
                         String DESCRIP) {
    dataset.append(); 
    dataset.fieldValue("CODIGO", CODIGO);
    dataset.fieldValue("COTAB", COTAB);
    dataset.fieldValue("DESCRIP", DESCRIP);
  }
}
