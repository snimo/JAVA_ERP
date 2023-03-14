package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComporTipoArchConci extends Operation {

	public TraerComporTipoArchConci() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
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
			
			IDataSet dsDetCupones = this.getDataSetDetCupones();
			Iterator iterDetCupo = 
				ArchLoteConciDet.getAllByCondiciones(condiciones, this.getSesion()).iterator();
			while (iterDetCupo.hasNext()) {
				ArchLoteConciDet detCupon = (ArchLoteConciDet) iterDetCupo.next();
				cargarRegCupon(dsDetCupones, detCupon);
				ds.next();
			}
			writeCliente(dsDetCupones);
			break;
			
		}
		
		
	}
	
	private void cargarRegCupon(IDataSet dsCupon,ArchLoteConciDet archLoteConciDet) throws BaseException {
		dsCupon.append();
		dsCupon.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
		dsCupon.fieldValue("oid_arch_lote_cab", archLoteConciDet.getArch_lot_cab().getOIDInteger());
		dsCupon.fieldValue("modo_transmision", archLoteConciDet.getModo_transmision());
		dsCupon.fieldValue("tipo_operacion", archLoteConciDet.getTipo_operacion());
		dsCupon.fieldValue("fecha_oper", archLoteConciDet.getFecha_oper());
		dsCupon.fieldValue("hora_oper", archLoteConciDet.getHora_oper());
		dsCupon.fieldValue("tipo_tarjeta", archLoteConciDet.getTipo_tarjeta());
		dsCupon.fieldValue("tarjeta", archLoteConciDet.getTarjeta());
		dsCupon.fieldValue("nro_tarjeta", archLoteConciDet.getNro_tarjeta());
		dsCupon.fieldValue("banda_manual", archLoteConciDet.getBanda_manual());
		dsCupon.fieldValue("cod_autoriz", archLoteConciDet.getCod_autoriz());
		dsCupon.fieldValue("ticket", archLoteConciDet.getTicket());
		dsCupon.fieldValue("moneda", archLoteConciDet.getMoneda());
		dsCupon.fieldValue("Monto", archLoteConciDet.getMonto());
		dsCupon.fieldValue("tipo_cta_deb", archLoteConciDet.getTipo_cta_deb());
		dsCupon.fieldValue("plan_y_cuota", archLoteConciDet.getPlan_y_cuota());
		dsCupon.fieldValue("cod_comercio", archLoteConciDet.getCod_comercio());
		dsCupon.fieldValue("nro_terminal", archLoteConciDet.getNro_terminal());
		dsCupon.fieldValue("ticket_sec", archLoteConciDet.getTicket_sec());
		dsCupon.fieldValue("codigo_lista", archLoteConciDet.getCodigo_lista());
		dsCupon.fieldValue("monto_sec", archLoteConciDet.getMonto_sec());
		dsCupon.fieldValue("fecha_sec", archLoteConciDet.getFecha_sec());
		dsCupon.fieldValue("factura", archLoteConciDet.getFactura());
		dsCupon.fieldValue("nro_host", archLoteConciDet.getNro_host());
		dsCupon.fieldValue("nro_lote", archLoteConciDet.getNro_lote());
		dsCupon.fieldValue("activo", archLoteConciDet.isActivo());
		dsCupon.fieldValue("presentado", archLoteConciDet.isPresentado());
		dsCupon.fieldValue("oid_empresa", archLoteConciDet.getEmpresa().getOIDInteger());
		dsCupon.fieldValue("oid_uni_neg", archLoteConciDet.getUnidad_negocio().getOIDInteger());
		dsCupon.fieldValue("fec_oper_date", archLoteConciDet.getFecOperDate());
		dsCupon.fieldValue("fec_cierre", archLoteConciDet.getFecCierre());		
		dsCupon.fieldValue("fec_presen_cupon", archLoteConciDet.getFecPresenCupo());
		dsCupon.fieldValue("conciliado", archLoteConciDet.isConciliado()); 
		dsCupon.fieldValue("fec_conciliado", archLoteConciDet.getFecConciliado());
		dsCupon.fieldValue("liquidado", archLoteConciDet.isLiquidado());
		dsCupon.fieldValue("fec_liquidado", archLoteConciDet.getFecLiquidado());
		dsCupon.fieldValue("preContabilizado", archLoteConciDet.isPreContabilizado());
		dsCupon.fieldValue("fecPreContabilizado", archLoteConciDet.getFecPreContabilizado());
		dsCupon.fieldValue("contabilizado" , archLoteConciDet.isContabilizado()); 
		dsCupon.fieldValue("fecContabilizado",  archLoteConciDet.getFecContabilizado());
		
	}
	
	private IDataSet getDataSetDetCupones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetCupones");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_arch_lote_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("modo_transmision", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_operacion", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha_oper", Field.STRING, 100));
		dataset.fieldDef(new Field("hora_oper", Field.STRING, 100));
		dataset.fieldDef(new Field("tipo_tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 100));
		dataset.fieldDef(new Field("banda_manual", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_autoriz", Field.STRING, 100));
		dataset.fieldDef(new Field("ticket", Field.STRING, 100));
		dataset.fieldDef(new Field("moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("Monto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tipo_cta_deb", Field.STRING, 100));
		dataset.fieldDef(new Field("plan_y_cuota", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_comercio", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_terminal", Field.STRING, 100));
		dataset.fieldDef(new Field("ticket_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("codigo_lista", Field.STRING, 100));
		dataset.fieldDef(new Field("monto_sec", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fecha_sec", Field.STRING, 100));
		dataset.fieldDef(new Field("factura", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_host", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_lote", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("presentado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_uni_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_oper_date", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_cierre", Field.DATE, 0));		
		dataset.fieldDef(new Field("fec_presen_cupon", Field.DATE, 0));
		dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0)); 
		dataset.fieldDef(new Field("fec_conciliado", Field.DATE, 0));
		dataset.fieldDef(new Field("liquidado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_liquidado", Field.DATE, 0));
		dataset.fieldDef(new Field("preContabilizado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fecPreContabilizado", Field.DATE, 0));
		dataset.fieldDef(new Field("contabilizado" , Field.BOOLEAN, 0)); 
		dataset.fieldDef(new Field("fecContabilizado",  Field.DATE, 0));		
		
		return dataset;
	}	

}
