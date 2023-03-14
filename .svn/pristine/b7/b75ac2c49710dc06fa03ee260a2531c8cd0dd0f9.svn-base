package com.srn.erp.legales.op;

import com.srn.erp.legales.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerConcPagoSeclo extends Operation { 

  public TraerConcPagoSeclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ConcPagoSeclo concpagoseclo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       concpagoseclo = ConcPagoSeclo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       concpagoseclo = ConcPagoSeclo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetConcPagoSeclo = getDataSetConcPagoSeclo();
    if (concpagoseclo != null) { 
        cargarRegistroConcPagoSeclo(datasetConcPagoSeclo, 
                         concpagoseclo.getOIDInteger(),
                         concpagoseclo.getDescripcion(),
                         concpagoseclo.isActivo());
    }
    writeCliente(datasetConcPagoSeclo);
  }

  private IDataSet getDataSetConcPagoSeclo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConcPagoSeclo");
    dataset.fieldDef(new Field("oid_conc_pago_seclo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroConcPagoSeclo(IDataSet dataset, 
                         Integer oid_conc_pago_seclo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_conc_pago_seclo", oid_conc_pago_seclo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
