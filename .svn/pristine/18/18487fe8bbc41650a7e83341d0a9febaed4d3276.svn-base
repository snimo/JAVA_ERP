package com.srn.erp.payroll.op;

import com.srn.erp.payroll.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPayPuesto extends Operation { 

  public TraerPayPuesto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PayPuesto paypuesto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       paypuesto = PayPuesto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       paypuesto = PayPuesto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPayPuesto = getDataSetPayPuesto();
    if (paypuesto != null) { 
        cargarRegistroPayPuesto(datasetPayPuesto, 
                         paypuesto.getCodigoActual(),
                         paypuesto.getDescripcion());
    }
    writeCliente(datasetPayPuesto);
  }

  private IDataSet getDataSetPayPuesto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPayPuesto");
    dataset.fieldDef(new Field("codigo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descrip", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroPayPuesto(IDataSet dataset, 
                         Integer codigo,
                         String descrip) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descrip", descrip);
  }
}
