package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerArchLoteConciCab extends Operation { 

  public TraerArchLoteConciCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ArchLoteConciCab archloteconcicab = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       archloteconcicab = ArchLoteConciCab.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       archloteconcicab = ArchLoteConciCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetArchLoteConciCab = getDataSetArchLoteConciCab();
    if (archloteconcicab != null) { 
        cargarRegistroArchLoteConciCab(datasetArchLoteConciCab, archloteconcicab);
    }
    writeCliente(datasetArchLoteConciCab);
  }

  private IDataSet getDataSetArchLoteConciCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArchLoteConciCab");
    dataset.fieldDef(new Field("oid_arch_lot_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("estado", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("proveedor_host", Field.STRING, 2)); 
    dataset.fieldDef(new Field("nro_host", Field.STRING, 20)); 
    dataset.fieldDef(new Field("nom_host", Field.STRING, 12)); 
    dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cant_transac", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_terminal", Field.STRING, 20)); 
    dataset.fieldDef(new Field("anio", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("mes", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("archivo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("fec_creacion", Field.STRING, 0)); 
    dataset.fieldDef(new Field("dia", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("fec_importacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("hora_importacion", Field.STRING, 5)); 
    return dataset;
  }

  private void cargarRegistroArchLoteConciCab(IDataSet dataset, 
		  									  ArchLoteConciCab archLoteConciCab) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_arch_lot_cab", archLoteConciCab.getOIDInteger());
    dataset.fieldValue("estado", archLoteConciCab.getEstado());
    dataset.fieldValue("proveedor_host", archLoteConciCab.getProveedor_host());
    dataset.fieldValue("nro_host", archLoteConciCab.getNro_host());
    dataset.fieldValue("nom_host", archLoteConciCab.getNom_host());
    dataset.fieldValue("nro_lote", archLoteConciCab.getNro_lote());
    dataset.fieldValue("cant_transac", archLoteConciCab.getCant_transac());
    dataset.fieldValue("nro_terminal", archLoteConciCab.getNro_terminal());
    dataset.fieldValue("anio", archLoteConciCab.getAnio());
    dataset.fieldValue("activo", archLoteConciCab.isActivo());
    dataset.fieldValue("mes", archLoteConciCab.getMes());
    dataset.fieldValue("archivo", archLoteConciCab.getArchivo());
    dataset.fieldValue("fec_creacion", archLoteConciCab.getFec_creacion());
    dataset.fieldValue("dia", archLoteConciCab.getDia());
    dataset.fieldValue("fec_importacion", archLoteConciCab.getFec_importacion());
    dataset.fieldValue("hora_importacion", archLoteConciCab.getHora_importacion());
  }
}
