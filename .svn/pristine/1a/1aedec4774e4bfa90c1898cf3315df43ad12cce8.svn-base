package com.srn.erp.conciTarjeta.op;

import java.io.File;
import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArchivosImpPosnets extends Operation { 

  public TraerArchivosImpPosnets() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	IDataSet ds = this.getDataSet();
	
	java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
	java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
	EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	 
	Iterator iterArchLoteConciCab = 
		ArchLoteConciCab.getArchLoteDet(empresa, fecDesde, fecHasta, this.getSesion()).iterator();
	while (iterArchLoteConciCab.hasNext()) {
		ArchLoteConciCab archLoteConciCab = (ArchLoteConciCab) iterArchLoteConciCab.next();
		cargarRegistro(ds, archLoteConciCab);
	}
	
	writeCliente(ds);
  }

  private IDataSet getDataSet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArchivosPOSNETS");
    
    dataset.fieldDef(new Field("oid_arch_lot_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("proveedor_host", Field.STRING, 5));
    dataset.fieldDef(new Field("nro_host" ,  Field.STRING, 20));
    dataset.fieldDef(new Field("nom_host" ,  Field.STRING, 12));
    dataset.fieldDef(new Field("nro_lote" ,  Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_transac" ,  Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_terminal" ,  Field.STRING, 20));
    dataset.fieldDef(new Field("anio" ,  Field.INTEGER, 0));
    dataset.fieldDef(new Field("mes" ,  Field.INTEGER, 0));
    dataset.fieldDef(new Field("dia" ,  Field.INTEGER, 0));
    dataset.fieldDef(new Field("archivo" ,  Field.STRING, 255));
    dataset.fieldDef(new Field("fec_creacion" ,  Field.DATE, 0));
    dataset.fieldDef(new Field("fec_importacion" ,  Field.DATE, 0));
    dataset.fieldDef(new Field("fec_cierre" ,  Field.DATE, 0));
    dataset.fieldDef(new Field("hora_importacion" ,  Field.STRING, 5));
    dataset.fieldDef(new Field("oid_empresa" ,  Field.INTEGER, 0));    
    dataset.fieldDef(new Field("arch_texto" ,  Field.MEMO, 0));
    dataset.fieldDef(new Field("tarjeta" ,  Field.STRING, 50));
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
		  					  ArchLoteConciCab archLoteConciCab) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_arch_lot_cab", archLoteConciCab.getOIDInteger());
    dataset.fieldValue("estado" , archLoteConciCab.getEstado());
    dataset.fieldValue("proveedor_host" , archLoteConciCab.getProveedor_host());
    dataset.fieldValue("nro_host" ,  archLoteConciCab.getNro_host());
    dataset.fieldValue("nom_host" ,  archLoteConciCab.getNom_host());
    dataset.fieldValue("nro_lote" ,  archLoteConciCab.getNro_lote());
    dataset.fieldValue("cant_transac" ,  archLoteConciCab.getCant_transac());
    dataset.fieldValue("nro_terminal" ,  archLoteConciCab.getNro_terminal());
    dataset.fieldValue("anio" ,  archLoteConciCab.getAnio());
    dataset.fieldValue("mes" ,  archLoteConciCab.getMes());
    dataset.fieldValue("dia" ,  archLoteConciCab.getDia());
    
    File tmpFile = null;
    try {
    	tmpFile = new File(archLoteConciCab.getArchivo());
    } catch (Exception e) {}
    
    if (tmpFile!=null)
    	dataset.fieldValue("archivo" ,  tmpFile.getName());
    else
    	dataset.fieldValue("archivo" ,  "");
    dataset.fieldValue("fec_creacion" ,  archLoteConciCab.getFec_creacion());
    dataset.fieldValue("fec_importacion" ,  archLoteConciCab.getFec_importacion());
    dataset.fieldValue("fec_cierre" ,  archLoteConciCab.getFec_cierre());
    dataset.fieldValue("hora_importacion" ,  archLoteConciCab.getHora_importacion());
    dataset.fieldValue("oid_empresa" ,  archLoteConciCab.getEmpresa().getOIDInteger());
    dataset.fieldValue("arch_texto" ,  archLoteConciCab.getArchivoTexto());
    if (tmpFile == null)
    	dataset.fieldValue("tarjeta" ,  "");
    else
    if (tmpFile.getName().startsWith("VI"))
    	dataset.fieldValue("tarjeta" ,  "VISA");
    else if (tmpFile.getName().startsWith("AM"))
    	dataset.fieldValue("tarjeta" ,  "AMERICAN");
    else if (tmpFile.getName().startsWith("PO"))
    	dataset.fieldValue("tarjeta" ,  "MASTER");
    else
    	dataset.fieldValue("tarjeta" ,  "");
  }
}
