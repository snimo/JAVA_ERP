package com.srn.erp.payroll.op;

import com.srn.erp.payroll.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerPayRotas extends Operation { 

  public TraerPayRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PayRotas payrotas = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       payrotas = PayRotas.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       payrotas = PayRotas.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPayRotas = getDataSetPayRotas();
    if (payrotas != null) { 
        cargarRegistroPayRotas(datasetPayRotas, 
                         payrotas.getTracodigo(),
                         payrotas.getTradescrip(),
                         payrotas.getTrahoraini(),
                         payrotas.getTrahorafin ());
    }
    writeCliente(datasetPayRotas);
  }

  private IDataSet getDataSetPayRotas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPayRotas");
    dataset.fieldDef(new Field("tracodigo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("tradescrip", Field.STRING, 100)); 
    dataset.fieldDef(new Field("trahoraini", Field.STRING, 20)); 
    dataset.fieldDef(new Field("trahorafin ", Field.STRING, 20)); 
    return dataset;
  }

  private void cargarRegistroPayRotas(IDataSet dataset, 
                         String tracodigo,
                         String tradescrip,
                         String trahoraini,
                         String trahorafin ) {
    dataset.append(); 
    dataset.fieldValue("tracodigo", tracodigo);
    dataset.fieldValue("tradescrip", tradescrip);
    dataset.fieldValue("trahoraini", trahoraini);
    dataset.fieldValue("trahorafin ", trahorafin );
  }
}
