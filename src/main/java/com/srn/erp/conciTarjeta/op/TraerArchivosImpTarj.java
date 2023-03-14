package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.CabTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArchivosImpTarj extends Operation { 

  public TraerArchivosImpTarj() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	IDataSet ds = this.getDataSet();
	
	java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
	java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
	EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
	 
	Iterator iterCabTarConciEnt = 
		CabTarConciEnt.getCabTarConciEnt(empresa, fecDesde, fecHasta, this.getSesion()).iterator();
	while (iterCabTarConciEnt.hasNext()) {
		CabTarConciEnt cabTarConciEnt = (CabTarConciEnt) iterCabTarConciEnt.next();
		cargarRegistro(ds, cabTarConciEnt);
	}
	
	writeCliente(ds);
  }

  private IDataSet getDataSet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArchivosTarjetas");
    dataset.fieldDef(new Field("oid_tar_info_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_imp", Field.DATE, 0));
    dataset.fieldDef(new Field("hora_imp", Field.STRING, 5));
    dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nom_archivo", Field.STRING, 255));
    dataset.fieldDef(new Field("tipo_archivo", Field.STRING, 255));
    dataset.fieldDef(new Field("carpeta_archivo", Field.STRING, 255));
    dataset.fieldDef(new Field("fec_nom_arch", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_usu_alta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("arch_texto", Field.MEMO, 0)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
		  					  CabTarConciEnt cabTarConciEnt) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_tar_info_cab", cabTarConciEnt.getOIDInteger());
    dataset.fieldValue("fec_imp", cabTarConciEnt.getFec_imp());
    dataset.fieldValue("hora_imp", cabTarConciEnt.getHora_imp());
    dataset.fieldValue("oid_empresa", cabTarConciEnt.getEmpresa().getOIDInteger());
    dataset.fieldValue("nom_archivo", cabTarConciEnt.getNom_archivo());
    dataset.fieldValue("tipo_archivo", cabTarConciEnt.getTipoArchivo());
    dataset.fieldValue("carpeta_archivo", cabTarConciEnt.getCarpetaArchivo());
    dataset.fieldValue("fec_nom_arch", cabTarConciEnt.getFecNomArchivo());
    dataset.fieldValue("oid_usu_alta", cabTarConciEnt.getUsuarioAlta().getOIDInteger());
    dataset.fieldValue("activo", cabTarConciEnt.isActivo());   
    dataset.fieldValue("arch_texto", cabTarConciEnt.getArchivoTexto());
  }
}
