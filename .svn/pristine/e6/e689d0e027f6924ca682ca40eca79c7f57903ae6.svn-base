package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.ConciliarCupon;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerarPreconciliacion extends Operation {

	public GenerarPreconciliacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidEmpresa 		= mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		
		List listaCuponesPOSNET  = new ArrayList();
		List listaCuponesEntTarj = new ArrayList();
		
		ConciliarCupon conciliarCupon = new ConciliarCupon();
		conciliarCupon.setSesion(this.getSesion());
		
		IDataSet dsPOSNET  = getDataSetPreconciPOSNET();
		IDataSet dsTARJCRE = getDataSetPreconciTARJCRE(); 
		
		boolean preConciliar = false;
		StringBuffer motivosNoConcilio = new StringBuffer("");
		
		try {
			
			preConciliar = conciliarCupon.preConcililiar(
					empresa, 
					usuario, 
					listaCuponesPOSNET, 
					listaCuponesEntTarj,
					motivosNoConcilio);
			
			if (preConciliar == false)
				throw new ExceptionValidation(null,motivosNoConcilio.toString());
			
			this.getSesion().commitTransaction();
		} catch(Exception e) {
			this.getSesion().rollBackTransaction();
			throw new ExceptionValidation(null,"No se pudo conciliar. Error:"+e.getMessage());
		}
		
		if (preConciliar) {
			
				Iterator iterListaCuponesPOSNET = 
					listaCuponesPOSNET.iterator();
				while (iterListaCuponesPOSNET.hasNext()) {
					ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterListaCuponesPOSNET.next();
					ArchLoteConciDet refreArchLoteConciDet =
						archLoteConciDet.findByOid(archLoteConciDet.getOIDInteger(), this.getSesion());
					cargarRegPOSNET(dsPOSNET, 
							refreArchLoteConciDet.getOIDInteger(), 
							refreArchLoteConciDet.getNroConciliacion(), 
							refreArchLoteConciDet.getFecPreconci());
				}
			
				Iterator iterListaCuponesTARJCRE = 
					listaCuponesEntTarj.iterator();
				while (iterListaCuponesTARJCRE.hasNext()) {
					DetTarConciEnt detTarjConciEnt = (DetTarConciEnt) iterListaCuponesTARJCRE.next();
					DetTarConciEnt refreshDetTarjConciEnt = DetTarConciEnt.findByOid(detTarjConciEnt.getOIDInteger(), this.getSesion());  
					cargarRegTARJCRE(
							dsTARJCRE, 
							refreshDetTarjConciEnt.getOIDInteger(), 
							refreshDetTarjConciEnt.getNroConciliacion(), 
							refreshDetTarjConciEnt.getFecPreconci());
				}			
			
		}
		
		writeCliente(dsPOSNET);
		writeCliente(dsTARJCRE);
		
	}
	
	private IDataSet getDataSetPreconciPOSNET() {
		 IDataSet dataset = new TDataSet();
		 dataset.create("TCupPreconciPOSNET");
		 dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		 return dataset;
	}	
	
	private IDataSet getDataSetPreconciTARJCRE() {
		 IDataSet dataset = new TDataSet();
		 dataset.create("TCupPreconciTARJCRE");
		 dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		 return dataset;
	}	
	
	private void cargarRegPOSNET(IDataSet ds,
								 Integer oidArchLoteDet,
								 Integer nroConciliacion,
								 java.util.Date fecha) throws BaseException {
		ds.append();
		ds.fieldValue("oid_arch_lote_det", oidArchLoteDet);
		ds.fieldValue("nro_conciliacion", nroConciliacion);
		ds.fieldValue("fec_preconci", fecha);
		
	}
	
	private void cargarRegTARJCRE(IDataSet ds,
			 Integer oidTarInfoDet,
			 Integer nroConciliacion,
			 java.util.Date fecha) throws BaseException {
		ds.append();
		ds.fieldValue("oid_tar_info_det", oidTarInfoDet);
		ds.fieldValue("nro_conciliacion", nroConciliacion);
		ds.fieldValue("fec_preconci", fecha);
	}	

}
