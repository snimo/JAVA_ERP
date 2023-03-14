package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCupoConciPorNroConci extends Operation {

	private int secu = 0;

	public TraerCupoConciPorNroConci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = getDSVistaVertConci();
		
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		if (empresa==null) throw new ExceptionValidation(null,"Debe seleccionar una empresa");
		
		List cuponesPOSNET = new ArrayList();
		List cuponesTARJ = new ArrayList();		
		
		Integer nroConciliado = mapaDatos.getInteger("nro_conciliacion");
		Iterator iterDetLote = 
			DetTarConciEnt.getPreconciliadosByNro(empresa, nroConciliado, this.getSesion()).iterator();
		while (iterDetLote.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterDetLote.next();
			cuponesTARJ.add(detTarConciEnt);
		}
		
		Iterator iterDetTarj = 
			ArchLoteConciDet.getPreconciliadosPorEmpresayNroConci(empresa, nroConciliado, this.getSesion()).iterator();
		while (iterDetTarj.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetTarj.next();
			cuponesPOSNET.add(archLoteConciDet);
		}
		
		if (cuponesPOSNET.size()>cuponesTARJ.size()) {
			Iterator iterCupPOSNET = 
				cuponesPOSNET.iterator();
			int i=0;
			while (iterCupPOSNET.hasNext()) {
				ArchLoteConciDet archLoteConciDet1  = (ArchLoteConciDet) iterCupPOSNET.next();
				DetTarConciEnt detTarConciEnt1 = null;
				if (i<=(cuponesTARJ.size()-1)) 
					detTarConciEnt1 = ((DetTarConciEnt) cuponesTARJ.get(i));
				cargarRegistro(ds, 
						archLoteConciDet1, 
						detTarConciEnt1, 
						archLoteConciDet1.isPreconci(), 
						archLoteConciDet1.getFecPreconci(), 
						archLoteConciDet1.isConciliado(), 
						archLoteConciDet1.getFecConciliado(), 
						archLoteConciDet1.getNroConciliacion(), true);
				++i;
			}
		} else {
			Iterator iterCupTARJ = 
				cuponesTARJ.iterator();
			int i=0;
			while (iterCupTARJ.hasNext()) {
				DetTarConciEnt detTarConciEnt1  = (DetTarConciEnt) iterCupTARJ.next();
				ArchLoteConciDet archLoteConciDet1 = null;
				if (i<=(cuponesPOSNET.size()-1)) 
					archLoteConciDet1 = ((ArchLoteConciDet) cuponesPOSNET.get(i));
				cargarRegistro(ds, 
						archLoteConciDet1, 
						detTarConciEnt1, 
						detTarConciEnt1.isPreConciliado(), 
						detTarConciEnt1.getFecPreconci(), 
						detTarConciEnt1.isConciliado(), 
						detTarConciEnt1.getFecConciliado(), 
						detTarConciEnt1.getNroConciliacion(), true);
				++i;
			}
			
		}		
		
		writeCliente(ds);
		
	}

	private IDataSet getDSVistaVertConci() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaVertPorNroConci");

		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tarjeta_posnet", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_tarj_posnet", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_posnet", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_cierre_posnet", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_ori_posnet", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_lote_posnet", Field.INTEGER, 0));

		dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tarjeta_entidad", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_tarj_entidad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("monto_entidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_cierre_entidad", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_ori_entidad", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_lote_entidad", Field.INTEGER, 0));

		dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_conciliado", Field.DATE, 0));
		dataset.fieldDef(new Field("confirmado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_confirmado", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_conciliacion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("marca", Field.BOOLEAN, 0));

		return dataset;
	}

	private void cargarRegistro(
			IDataSet dataset, 
			ArchLoteConciDet archLoteConciDet, 
			DetTarConciEnt detTarConciEnt, 
			Boolean conciliado,
			java.util.Date fecConciliado, 
			Boolean confirmado, 
			java.util.Date fecConfirmado, 
			Integer nroConciliacion, 
			Boolean activo)
			throws BaseException {

		dataset.append();

		dataset.fieldValue("secu", --secu);

		if (archLoteConciDet != null) {
			dataset.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
			dataset.fieldValue("tarjeta_posnet", archLoteConciDet.getTarjeta());
			dataset.fieldValue("nro_tarj_posnet", archLoteConciDet.getUltimosNrosTarjeta());
			dataset.fieldValue("monto_posnet", archLoteConciDet.getMonto());
			dataset.fieldValue("fec_cierre_posnet", archLoteConciDet.getFecCierre());
			dataset.fieldValue("fec_ori_posnet", archLoteConciDet.getFecOperDate());
			dataset.fieldValue("nro_lote_posnet", archLoteConciDet.getNro_lote());
		} else {
			dataset.fieldValue("oid_arch_lote_det", 0);
			dataset.fieldValue("tarjeta_posnet", " ");
			dataset.fieldValue("nro_tarj_posnet", 0);
			dataset.fieldValue("monto_posnet", 0);
			dataset.fieldValue("fec_cierre_posnet", Fecha.FECHA_NULA());
			dataset.fieldValue("fec_ori_posnet", Fecha.FECHA_NULA());
			dataset.fieldValue("nro_lote_posnet", 0);
		}

		if (detTarConciEnt != null) {
			dataset.fieldValue("oid_tar_info_det", detTarConciEnt.getOIDInteger());
			dataset.fieldValue("tarjeta_entidad", detTarConciEnt.getTarjeta());
			dataset.fieldValue("nro_tarj_entidad", detTarConciEnt.getNro_tarjeta());
			dataset.fieldValue("monto_entidad", detTarConciEnt.getImporte());
			dataset.fieldValue("fec_cierre_entidad", detTarConciEnt.getFec_present());
			dataset.fieldValue("fec_ori_entidad", detTarConciEnt.getFec_origen());
			dataset.fieldValue("nro_lote_entidad", detTarConciEnt.getLote());
		} else {
			dataset.fieldValue("oid_tar_info_det", 0);
			dataset.fieldValue("tarjeta_entidad", " ");
			dataset.fieldValue("nro_tarj_entidad", 0);
			dataset.fieldValue("monto_entidad", 0);
			dataset.fieldValue("fec_cierre_entidad", Fecha.FECHA_NULA());
			dataset.fieldValue("fec_ori_entidad", Fecha.FECHA_NULA());
			dataset.fieldValue("nro_lote_entidad", 0);
		}

		dataset.fieldValue("conciliado", conciliado);
		if (fecConciliado != null)
			dataset.fieldValue("fec_conciliado", fecConciliado);
		else
			dataset.fieldValue("fec_conciliado", Fecha.FECHA_NULA());
		dataset.fieldValue("confirmado", confirmado);
		if (fecConfirmado != null)
			dataset.fieldValue("fec_confirmado", fecConfirmado);
		else
			dataset.fieldValue("fec_confirmado", Fecha.FECHA_NULA());
		dataset.fieldValue("nro_conciliacion", nroConciliacion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("marca", true);
	}
}
