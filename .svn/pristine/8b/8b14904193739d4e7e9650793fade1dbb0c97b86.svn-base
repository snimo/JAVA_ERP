package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArchPOSNETImpUltDias extends Operation { 

  public TraerArchPOSNETImpUltDias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  int dias = mapaDatos.getInteger("dias");
	  EmpresaConciTar empresa = (EmpresaConciTar) EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	  
	  IDataSet ds = this.getDSArchPOSNETImpUltDias();
	  
	  Iterator iterArchImp = 
		  ArchLoteConciCab.getUltimosArchImportados(empresa,dias, this.getSesion()).iterator();
	  while (iterArchImp.hasNext()) {
		  ArchLoteConciCab archCab = (ArchLoteConciCab) iterArchImp.next();
		  cargarRegistro(ds, archCab);
	  }
	  
	  writeCliente(ds);
  }

  private IDataSet getDSArchPOSNETImpUltDias() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArchPOSNETImpUltDias");
    dataset.fieldDef(new Field("oid_arch_lot_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("estado",Field.INTEGER, 0));
    dataset.fieldDef(new Field("proveedor_host", Field.STRING, 2));
    dataset.fieldDef(new Field("nro_host", Field.STRING, 20));
    dataset.fieldDef(new Field("nom_host", Field.STRING, 12));
    dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_transac", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_terminal", Field.STRING, 20));
    dataset.fieldDef(new Field("anio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("mes", Field.INTEGER, 0));
    dataset.fieldDef(new Field("dia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("archivo", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_creacion", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_importacion", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_cierre", Field.DATE, 0));
    dataset.fieldDef(new Field("hora_importacion", Field.STRING, 5));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,ArchLoteConciCab archLoteConciCab) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_arch_lot_cab", archLoteConciCab.getOIDInteger());
    dataset.fieldValue("estado",archLoteConciCab.getEstado());
    dataset.fieldValue("proveedor_host", archLoteConciCab.getProveedor_host());
    dataset.fieldValue("nro_host", archLoteConciCab.getNro_host());
    dataset.fieldValue("nom_host", archLoteConciCab.getNom_host());
    dataset.fieldValue("nro_lote", archLoteConciCab.getNro_lote());
    dataset.fieldValue("cant_transac", archLoteConciCab.getCant_transac());
    dataset.fieldValue("nro_terminal", archLoteConciCab.getNro_terminal());
    dataset.fieldValue("anio", archLoteConciCab.getAnio());
    dataset.fieldValue("mes", archLoteConciCab.getMes());
    dataset.fieldValue("dia", archLoteConciCab.getDia());
    dataset.fieldValue("archivo", archLoteConciCab.getArchivo());
    dataset.fieldValue("fec_creacion", archLoteConciCab.getFec_creacion());
    dataset.fieldValue("fec_importacion", archLoteConciCab.getFec_importacion());
    dataset.fieldValue("fec_cierre", archLoteConciCab.getFec_cierre());
    dataset.fieldValue("hora_importacion", archLoteConciCab.getHora_importacion());
  }
}
