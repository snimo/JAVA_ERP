package com.srn.erp.conciTarjeta.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVistaVerticalConci extends Operation {

	int secu = 0;
	
	public TraerVistaVerticalConci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsVistaVert = this.getDSVistaVertConci();
		
		HashTableDatos condiciones = new HashTableDatos();
		
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());		
		if (empresa==null) throw new ExceptionValidation(null,"Debe seleccionar una empresa");
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("ORDER_BY_NRO_CONCI","");
		
		IDataSet ds = mapaDatos.getDataSet("TInput");
		ds.first();
		while (!ds.EOF()) {
			
			java.util.Date fecOperDesde = ds.getDate("fec_oper_desde");
			if (fecOperDesde!=null)
				condiciones.put("FEC_OPER_DESDE", fecOperDesde);
			java.util.Date fecOperHasta = ds.getDate("fec_oper_hasta");
			if (fecOperHasta!=null)
				condiciones.put("FEC_OPER_HASTA", fecOperHasta);
			java.util.Date fecCierreDesde = ds.getDate("fec_cie_desde");
			if (fecCierreDesde!=null)
				condiciones.put("FEC_CIERRE_DESDE", fecCierreDesde);
			java.util.Date fecCierreHasta = ds.getDate("fec_cie_hasta");
			if (fecCierreHasta!=null)
				condiciones.put("FEC_CIERRE_HASTA", fecCierreHasta);
			String cupoPresentado = ds.getString("cupo_presentado");
			if (cupoPresentado!=null)
				condiciones.put("CUPO_PRESENTADO", cupoPresentado);
			
			java.util.Date fecPresenDesde = ds.getDate("fec_des_presen");
			if (fecPresenDesde!=null)
				condiciones.put("FEC_PRESEN_DESDE", fecPresenDesde);
				
			java.util.Date fecPresenHasta = ds.getDate("fec_has_presen");
			if (fecPresenHasta!=null)
				condiciones.put("FEC_PRESEN_HASTA", fecPresenHasta);
			
			TarjetaConciTar tarjeta = TarjetaConciTar.findByOidProxy(ds.getInteger("oid_tarjeta"), this.getSesion());
			if (tarjeta!=null)
				condiciones.put(TarjetaConciTar.NICKNAME, tarjeta);
			
			boolean pendConci = ds.getBoolean("pend_conci");
			if (pendConci == true)
				condiciones.put("PEND_CONCI", "");
			
			boolean conciSinConfirmar = ds.getBoolean("conci_sin_confirmar");
			if (conciSinConfirmar == true)
				condiciones.put("CONCI_SIN_CONF", "");			
			
			boolean conciConfirmado = ds.getBoolean("conci_confirmado");
			if (conciConfirmado == true)
				condiciones.put("CONCI_CONF", "");		
			
			java.util.Date fecDesdePendConci = ds.getDate("fec_desde_pend_conci");
			if (fecDesdePendConci!=null)
				condiciones.put("FEC_DESDE_PEND_CONCI", fecDesdePendConci);
			
			java.util.Date fecHastaPendConci = ds.getDate("fec_hasta_pend_conci");
			if (fecHastaPendConci!=null)
				condiciones.put("FEC_HASTA_PEND_CONCI", fecHastaPendConci);			
			
			java.util.Date fecDesdeConciSinConf = ds.getDate("fec_desde_conci_sin_conf");
			if (fecDesdeConciSinConf!=null)
				condiciones.put("FEC_DESDE_CONCI_SIN_CONF", fecDesdeConciSinConf);
			
			java.util.Date fecHastaConciSinConf = ds.getDate("fec_hasta_conci_sin_conf");
			if (fecHastaConciSinConf!=null)
				condiciones.put("FEC_HASTA_CONCI_SIN_CONF", fecHastaConciSinConf);
			
			java.util.Date fecDesdeConfirmado = ds.getDate("fec_desde_confirmado");
			if (fecDesdeConfirmado!=null)
				condiciones.put("FEC_DESDE_CONF", fecDesdeConfirmado);			
			
			java.util.Date fecHastaConfirmado = ds.getDate("fec_hasta_confirmado");
			if (fecHastaConfirmado!=null)
				condiciones.put("FEC_HASTA_CONF", fecHastaConfirmado);			
		
			Integer nroConci = new Integer(0);
			
			List cuponesPOSNET = new ArrayList();
			List cuponesTARJ = new ArrayList();
			
			
			Iterator iterDetCupo = 
				ArchLoteConciDet.getAllByCondiciones(condiciones, this.getSesion()).iterator();
			
			ArchLoteConciDet detCupon = null;
			
			while (iterDetCupo.hasNext()) {
				
				cuponesPOSNET.clear();
				detCupon = (ArchLoteConciDet) iterDetCupo.next();
				nroConci = detCupon.getNroConciliacion();
				cuponesPOSNET.add(detCupon);
				
				while ((detCupon.getNroConciliacion()!=null) && (detCupon.getNroConciliacion()!=0) && 
						(nroConci.intValue() == detCupon.getNroConciliacion().intValue()) && 
						(iterDetCupo.hasNext())) {
					
					detCupon = (ArchLoteConciDet) iterDetCupo.next();
					cuponesPOSNET.add(detCupon);
				}
				
				// Si tiene nro. de conciliacion obtener los conciliados
				cuponesTARJ.clear();
				if ((nroConci!=null) && (nroConci.intValue()>0)) {
					Iterator iterCupTarj =
						empresa.getTarjConciliadas(nroConci).iterator();
					while (iterCupTarj.hasNext()) {
						DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterCupTarj.next();
						cuponesTARJ.add(detTarConciEnt);
					}
				}
				
				// Detarminar quien tiene mas
				if (cuponesPOSNET.size()>cuponesTARJ.size()) {
					Iterator iterCupPOSNET = 
						cuponesPOSNET.iterator();
					int i=0;
					while (iterCupPOSNET.hasNext()) {
						ArchLoteConciDet archLoteConciDet1  = (ArchLoteConciDet) iterCupPOSNET.next();
						DetTarConciEnt detTarConciEnt1 = null;
						if (i<=(cuponesTARJ.size()-1)) 
							detTarConciEnt1 = ((DetTarConciEnt) cuponesTARJ.get(i));
						Integer nroConciAut = null;
						if (archLoteConciDet1.getCabConciAut()!=null)
							nroConciAut = archLoteConciDet1.getCabConciAut().getOIDInteger(); 
						cargarRegistro(dsVistaVert, 
								archLoteConciDet1, 
								detTarConciEnt1, 
								archLoteConciDet1.isPreconci(), 
								archLoteConciDet1.getFecPreconci(), 
								archLoteConciDet1.isConciliado(), 
								archLoteConciDet1.getFecConciliado(), 
								archLoteConciDet1.getNroConciliacion(), true ,
								nroConciAut
								);
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
						Integer nroConciAut = null;
						if (detTarConciEnt1.getCabConciAut()!=null)
							nroConciAut = detTarConciEnt1.getCabConciAut().getOIDInteger();						
						cargarRegistro(dsVistaVert, 
								archLoteConciDet1, 
								detTarConciEnt1, 
								detTarConciEnt1.isPreConciliado(), 
								detTarConciEnt1.getFecPreconci(), 
								detTarConciEnt1.isConciliado(), 
								detTarConciEnt1.getFecConciliado(), 
								detTarConciEnt1.getNroConciliacion(), 
								true,
								nroConciAut);
						++i;
					}
					
				}
				
				ds.next();
			}
			
			
			break;
			
		}
		
		//writeCliente(dsVistaVert);
	}

	private IDataSet getDSVistaVertConci() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaVertical");
		
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
		dataset.fieldDef(new Field("nro_conci_aut", Field.INTEGER, 0));
		
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
			Boolean activo,
			Integer nroConciAut) throws BaseException {
		
		dataset.append();
		
		dataset.fieldValue("secu", ++secu);
		
		if (archLoteConciDet!=null) {
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

		if (detTarConciEnt!=null) {
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
		if (fecConciliado!=null)
			dataset.fieldValue("fec_conciliado", fecConciliado);
		else
			dataset.fieldValue("fec_conciliado", Fecha.FECHA_NULA());
		dataset.fieldValue("confirmado", confirmado);
		if (fecConfirmado!=null)
			dataset.fieldValue("fec_confirmado", fecConfirmado);
		else
			dataset.fieldValue("fec_confirmado", Fecha.FECHA_NULA());
		dataset.fieldValue("nro_conciliacion", nroConciliacion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("nro_conci_aut" , nroConciAut);
	}
}
