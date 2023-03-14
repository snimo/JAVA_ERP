package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerAgrupadorTarjConci extends Operation { 

  public TraerAgrupadorTarjConci() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
    AgrupadorTarjConci agrupadortarjconci = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       agrupadortarjconci = AgrupadorTarjConci.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       agrupadortarjconci = AgrupadorTarjConci.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetAgrupadorTarjConci = getDataSetAgrupadorTarjConci();
    if (agrupadortarjconci != null) { 
        cargarRegistroAgrupadorTarjConci(datasetAgrupadorTarjConci, 
                         agrupadortarjconci.getOIDInteger(),
                         agrupadortarjconci.getCodigo(),
                         agrupadortarjconci.getDescripcion(),
                         agrupadortarjconci.isActivo());
    }
    writeCliente(datasetAgrupadorTarjConci);
  }

  private IDataSet getDataSetAgrupadorTarjConci() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAgrupadorTarjetas");
    dataset.fieldDef(new Field("oid_agrup_tar", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroAgrupadorTarjConci(IDataSet dataset, 
                         Integer oid_agrup_tar,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_agrup_tar", oid_agrup_tar);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
