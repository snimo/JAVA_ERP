package com.srn.erp.payroll.op;

import com.srn.erp.payroll.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPayEstado extends Operation { 

  public TraerPayEstado() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PayEstado payestado = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       payestado = PayEstado.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       payestado = PayEstado.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPayEstado = getDataSetPayEstado();
    if (payestado != null) { 
        cargarRegistroPayEstado(datasetPayEstado, 
                         payestado.getEstado());
    }
    writeCliente(datasetPayEstado);
  }

  private IDataSet getDataSetPayEstado() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPayEstado");
    dataset.fieldDef(new Field("estado", Field.STRING, 10)); 
    return dataset;
  }

  private void cargarRegistroPayEstado(IDataSet dataset, 
                         String estado) {
    dataset.append(); 
    dataset.fieldValue("estado", estado);
  }
}
