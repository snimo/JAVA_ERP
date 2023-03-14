package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuponesFiltrados extends Operation {

	public TraerCuponesFiltrados() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		if ((oidEmpresa == null) || (oidEmpresa.intValue()==0)) throw new ExceptionValidation(null,"Debe seleccionar una empresa");
		condiciones.put(EmpresaConciTar.NICKNAME, EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion()));
		
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
			
			String pendGenAsiCob = ds.getString("pend_gen_asi_cob");
			if (pendGenAsiCob!=null)
				condiciones.put("PEND_GEN_ASI_COB", pendGenAsiCob);
			
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
		if (archLoteConciDet.getArch_lot_cab()!=null)
			dsCupon.fieldValue("oid_arch_lote_cab", archLoteConciDet.getArch_lot_cab().getOIDInteger());
		else
			dsCupon.fieldValue("oid_arch_lote_cab", "");
		dsCupon.fieldValue("modo_transmision", archLoteConciDet.getModo_transmision());
		dsCupon.fieldValue("tipo_operacion", archLoteConciDet.getTipo_operacion());
		dsCupon.fieldValue("fecha_oper", archLoteConciDet.getFecha_oper());
		dsCupon.fieldValue("hora_oper", archLoteConciDet.getHora_oper());
		dsCupon.fieldValue("tipo_tarjeta", archLoteConciDet.getTipo_tarjeta());
		
		
		
		if (archLoteConciDet.getTarjeta().equals(archLoteConciDet.getTarjetaOri()))
			dsCupon.fieldValue("tarjeta", archLoteConciDet.getTarjeta());
		else
			dsCupon.fieldValue("tarjeta", archLoteConciDet.getTarjeta()+'-'+archLoteConciDet.getTarjetaOri());
				
		
		
		
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
		if (archLoteConciDet.getEmpresa()!=null)
			dsCupon.fieldValue("oid_empresa", archLoteConciDet.getEmpresa().getOIDInteger());
		else
			dsCupon.fieldValue("oid_empresa", "");
		if (archLoteConciDet.getUnidad_negocio()!=null)
			dsCupon.fieldValue("oid_uni_neg", archLoteConciDet.getUnidad_negocio().getOIDInteger());
		else
			dsCupon.fieldValue("oid_uni_neg", "");
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
		String agrupador = "";
		if ((archLoteConciDet.getTarjetaConciTar()!=null) && (archLoteConciDet.getTarjetaConciTar().getAgrupador()!=null))
			agrupador = archLoteConciDet.getTarjetaConciTar().getAgrupador().getDescripcion();
		dsCupon.fieldValue("agrupador",  agrupador);
		dsCupon.fieldValue("ult_nros_tarj", archLoteConciDet.getUltimosNrosTarjeta());
		dsCupon.fieldValue("marcar_preconci", archLoteConciDet.isMarcarPreconci());
		dsCupon.fieldValue("nro_conciliacion", archLoteConciDet.getNroConciliacion());
		dsCupon.fieldValue("pre_conci", archLoteConciDet.isPreconci());
		dsCupon.fieldValue("fec_preconci", archLoteConciDet.getFecPreconci());
		if (archLoteConciDet.getCabConciAut()!=null)
			dsCupon.fieldValue("nro_conci_aut", archLoteConciDet.getCabConciAut().getOIDInteger());
		else
			dsCupon.fieldValue("nro_conci_aut", "");
		if (archLoteConciDet.isPreconciDudoso())
			dsCupon.fieldValue("preconci_dudoso", "?");
		else
			dsCupon.fieldValue("preconci_dudoso", "");
		
		dsCupon.fieldValue("marca_asi_acob", archLoteConciDet.isMarcaAsiACobrar());
		dsCupon.fieldValue("cupon_perdido", archLoteConciDet.isCuponPerdido());
		dsCupon.fieldValue("est_asi_cob", archLoteConciDet.getEstadoAsientoCobranza()); 
		dsCupon.fieldValue("est_asi_liq", archLoteConciDet.getEstadoAsientoLiquidacion());
		if (archLoteConciDet.getAsientoACobrar()!=null)
			dsCupon.fieldValue("oid_cab_asi_acob", archLoteConciDet.getAsientoACobrar().getOIDInteger());
		else
			dsCupon.fieldValue("oid_cab_asi_acob", "");
		
		if (archLoteConciDet.getCabAsiLiquiTarj()!=null)
			dsCupon.fieldValue("oid_cab_asi_liq", archLoteConciDet.getCabAsiLiquiTarj().getOIDInteger());
		else
			dsCupon.fieldValue("oid_cab_asi_liq", "");
		
		dsCupon.fieldValue("ref_asi_cob", archLoteConciDet.getRefSistExt());
		dsCupon.fieldValue("ref_asi_liq", archLoteConciDet.getRefSistExt1());		
		
		
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
		dataset.fieldDef(new Field("agrupador",  Field.STRING, 50));
		dataset.fieldDef(new Field("ult_nros_tarj",  Field.INTEGER, 0));
		dataset.fieldDef(new Field("marcar_preconci",  Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_conciliacion",  Field.INTEGER, 0));
		dataset.fieldDef(new Field("pre_conci", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_preconci", Field.DATE, 0));
		dataset.fieldDef(new Field("nro_conci_aut", Field.INTEGER, 0));
		dataset.fieldDef(new Field("preconci_dudoso", Field.STRING, 1));
		dataset.fieldDef(new Field("marca_asi_acob", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cupon_perdido", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("est_asi_cob", Field.STRING, 50)); 
		dataset.fieldDef(new Field("est_asi_liq", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cab_asi_acob", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cab_asi_liq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ref_asi_cob", Field.STRING, 255));
		dataset.fieldDef(new Field("ref_asi_liq", Field.STRING, 255));
		return dataset;
	}

}
