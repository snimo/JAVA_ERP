package com.srn.erp.payroll.op;

import com.srn.erp.payroll.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPayTareaDesempenada extends Operation { 

  public TraerPayTareaDesempenada() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PayTareaDesempenada paytareadesempenada = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       paytareadesempenada = PayTareaDesempenada.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       paytareadesempenada = PayTareaDesempenada.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPayTareaDesempenada = getDataSetPayTareaDesempenada();
    if (paytareadesempenada != null) { 
        cargarRegistroPayTareaDesempenada(datasetPayTareaDesempenada, 
                         paytareadesempenada.getCodigoActual(),
                         paytareadesempenada.getDescripcion());
    }
    writeCliente(datasetPayTareaDesempenada);
  }

  private IDataSet getDataSetPayTareaDesempenada() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPayTareaDesempenada");
    dataset.fieldDef(new Field("codigo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descrip", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroPayTareaDesempenada(IDataSet dataset, 
                         Integer codigo,
                         String descrip) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descrip", descrip);
  }
}
