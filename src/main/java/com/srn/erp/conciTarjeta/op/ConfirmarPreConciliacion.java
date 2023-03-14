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

public class ConfirmarPreConciliacion extends Operation {

	public ConfirmarPreConciliacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidEmpresa 		= mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		
		List listaCuponesPOSNET  = new ArrayList();
		List listaCuponesEntTarj = new ArrayList();
		
		ConciliarCupon conciliarCupon = new ConciliarCupon();
		conciliarCupon.setSesion(this.getSesion());

		IDataSet dsPOSNET =  getDataSetConfirmadoPOSNET();
		IDataSet dsTARJCRE = getDataSetPreconciTARJCRE();
		
		boolean confirmaPreconci = false;
		
		try {
			confirmaPreconci = conciliarCupon.confirmarPreConci(empresa, usuario, listaCuponesPOSNET, listaCuponesEntTarj);
			this.getSesion().commitTransaction();
		} catch(Exception e) {
			this.getSesion().rollBackTransaction();
			throw new ExceptionValidation(null,"No se pudo confirmar la conciliación. Error:"+e.getMessage());
		}
		
		if (confirmaPreconci) {
			
			Iterator iterCuponesPOSNET = 
				listaCuponesPOSNET.iterator();
			while (iterCuponesPOSNET.hasNext()) {
				ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterCuponesPOSNET.next();
				ArchLoteConciDet refreshArchLoteConciDet = ArchLoteConciDet.findByOid(archLoteConciDet.getOIDInteger(), this.getSesion());
				cargarRegPOSNET(dsPOSNET, 
								refreshArchLoteConciDet.getOIDInteger(),
								refreshArchLoteConciDet.getFecConciliado());
			}
			
			Iterator iterCuponesTARJCRE = 
				listaCuponesEntTarj.iterator();
			while (iterCuponesTARJCRE.hasNext()) {
				DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterCuponesTARJCRE.next();
				DetTarConciEnt refreshDetTarConciEnt = DetTarConciEnt.findByOid(detTarConciEnt.getOIDInteger(), this.getSesion());
				cargarRegTARJCRE(dsTARJCRE, 
								 refreshDetTarConciEnt.getOIDInteger(),
								 refreshDetTarConciEnt.getFecConciliado());
			}		
			
		}
		
		writeCliente(dsPOSNET);
		writeCliente(dsTARJCRE);
		
	}
	
	private IDataSet getDataSetConfirmadoPOSNET() {
		 IDataSet dataset = new TDataSet();
		 dataset.create("TCupConfirmadoPOSNET");
		 dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("fec_confirmado", Field.DATE, 0));
		 return dataset;
	}	
	
	private IDataSet getDataSetPreconciTARJCRE() {
		 IDataSet dataset = new TDataSet();
		 dataset.create("TCupConfirmadoTARJCRE");
		 dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
		 dataset.fieldDef(new Field("fec_confirmado", Field.DATE, 0));
		 return dataset;
	}	
	
	private void cargarRegPOSNET(IDataSet ds,
								 Integer oidArchLoteDet,
								 java.util.Date fecha) throws BaseException {
		ds.append();
		ds.fieldValue("oid_arch_lote_det", oidArchLoteDet);
		ds.fieldValue("fec_confirmado", fecha);
		
	}
	
	private void cargarRegTARJCRE(IDataSet ds,
			 Integer oidTarInfoDet,
			 java.util.Date fecha) throws BaseException {
		ds.append();
		ds.fieldValue("oid_tar_info_det", oidTarInfoDet);
		ds.fieldValue("fec_confirmado", fecha);
	}	
	

}
