package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class AnuConfiIndMovPOSNET extends Operation {

	public AnuConfiIndMovPOSNET() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidArchLoteDet = mapaDatos.getInteger("oid_arch_lote_det");
		ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(oidArchLoteDet, this.getSesion());
		List cuponesPOSNETS  = new ArrayList();
		List cuponesTARJETAS = new ArrayList();
		archLoteConciDet.anularConfirmacion(cuponesPOSNETS,cuponesTARJETAS);
		
		IDataSet dsPOSNET = getDataSetAnulacionPOSNET();
		IDataSet dsTARJETA = getDataSetAnulacionTARJETA();
		
		Iterator iterCuponesPOSNETS = 
			cuponesPOSNETS.iterator();
		while (iterCuponesPOSNETS.hasNext()) {
			ArchLoteConciDet archLoteConciDetInf = (ArchLoteConciDet) iterCuponesPOSNETS.next(); 
			cargarRegistroPOSNET(dsPOSNET,archLoteConciDetInf);
		}
		
		Iterator iterCuponesTARJETAS = 
			cuponesTARJETAS.iterator();
		while (iterCuponesTARJETAS.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterCuponesTARJETAS.next(); 
			cargarRegistroTARJETA(dsTARJETA, detTarConciEnt);
		}		
		
		writeCliente(dsPOSNET);
		writeCliente(dsTARJETA);
		
		
	}
	
	  private IDataSet getDataSetAnulacionPOSNET() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TCuponAnuPOSNETConfi");
		    dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("preconci_dudoso", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("oid_cab_conci_aut", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_usu_preconci", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		    dataset.fieldDef(new Field("preconci", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }
	  
	  private IDataSet getDataSetAnulacionTARJETA() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TCuponAnuTARJETAConfi");
		    dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		    dataset.fieldDef(new Field("oid_usu_preconci", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("preconci", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_cab_conci_aut", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("preconci_dudoso", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    return dataset;
	  }	  
	  
	  private void cargarRegistroPOSNET(
			  IDataSet ds , 
			  ArchLoteConciDet archLoteConciDet) throws BaseException {
		  
		  ds.append();
		  ds.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
		  ds.fieldValue("preconci_dudoso", archLoteConciDet.isPreconciDudoso());
		  if (archLoteConciDet.getCabConciAut()!=null)
			  ds.fieldValue("oid_cab_conci_aut", archLoteConciDet.getCabConciAut().getOIDInteger());
		  else
			  ds.fieldValue("oid_cab_conci_aut", "");
		  ds.fieldValue("nro_conciliacion", archLoteConciDet.getNroConciliacion());
		  if (archLoteConciDet.getUsuarioPreconci()!=null)
			  ds.fieldValue("oid_usu_preconci", archLoteConciDet.getUsuarioPreconci().getOIDInteger());
		  else
			  ds.fieldValue("oid_usu_preconci", "");
		  ds.fieldValue("fec_preconci", archLoteConciDet.getFecPreconci());
		  ds.fieldValue("preconci", archLoteConciDet.isPreconci());
		  ds.fieldValue("activo", archLoteConciDet.isActivo());		  
	  }
	  
	  private void cargarRegistroTARJETA(
			  IDataSet ds , 
			  DetTarConciEnt detTarConciEnt) throws BaseException {
		  
		  ds.append();
		  ds.fieldValue("oid_tar_info_det", detTarConciEnt.getOIDInteger());
		  ds.fieldValue("fec_preconci", detTarConciEnt.getFecPreconci());
		  if (detTarConciEnt.getUsuPreConci()!=null)
			  ds.fieldValue("oid_usu_preconci", detTarConciEnt.getUsuPreConci().getOIDInteger());
		  else
			  ds.fieldValue("oid_usu_preconci", "");
		  ds.fieldValue("preconci", detTarConciEnt.isPreConciliado());
		  ds.fieldValue("nro_conciliacion", detTarConciEnt.getNroConciliacion());
		  if (detTarConciEnt.getCabConciAut()!=null)
			  ds.fieldValue("oid_cab_conci_aut", detTarConciEnt.getCabConciAut().getOIDInteger());
		  else
			  ds.fieldValue("oid_cab_conci_aut", "");
		  ds.fieldValue("preconci_dudoso", detTarConciEnt.isPreconciDudoso());
		  ds.fieldValue("activo", detTarConciEnt.isActivo());  
	  }	  

}
