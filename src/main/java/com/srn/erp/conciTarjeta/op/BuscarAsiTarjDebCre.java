package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiTarjACobrar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class BuscarAsiTarjDebCre extends Operation { 

  public BuscarAsiTarjDebCre() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
	java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");
	String tipo = mapaDatos.getString("tipo");
	
	if (fecDesde == null)
		throw new ExceptionValidation(null,"Debe ingresar la fecha desde");
	
	if (fecHasta == null)
		throw new ExceptionValidation(null,"Debe ingresar la fecha hasta");
	
	if (tipo == null)
		throw new ExceptionValidation(null,"Debe ingresar el tipo de Asiento");
	
	if (tipo.equals("LIQ"))
		procesarAsientoLiq(fecDesde,fecHasta);
	else
		procesarAsientoCob(fecDesde,fecHasta);
	
  }
  
  private void procesarAsientoLiq(java.util.Date fecDesde,java.util.Date fecHasta) throws BaseException {
	  
	  IDataSet dsAsiLiqCab = getDataSetAsiLiqCab();
	  IDataSet dsAliLiqDet = getDataSetAsiLiqDet();
	  IDataSet dsDetCupones = getDataSetDetCuponesLiq();
	  
	  Iterator iterCabAsientos = 
		  CabAsiLiquiTarj.getAsientosByFechas(fecDesde, fecHasta, this.getSesion()).iterator();
	  while (iterCabAsientos.hasNext()) {
		  CabAsiLiquiTarj cabAsiLiquiTarj = (CabAsiLiquiTarj) iterCabAsientos.next();
		  cargarRegAsiLiq(dsAsiLiqCab,cabAsiLiquiTarj);
		  
		  Iterator iterDetAsiento = 
			  cabAsiLiquiTarj.getDetalles().iterator();
		  while (iterDetAsiento.hasNext()) {
			  DetAsiLiquiTarj detAsiLiquiTarj = (DetAsiLiquiTarj) iterDetAsiento.next();
			  cargarDetAsiLiq(dsAliLiqDet, detAsiLiquiTarj);
		  }
		  
		  Iterator iterDetCupones = 
			  ArchLoteConciDet.getArchLoteDetByAsiLiq(cabAsiLiquiTarj,this.getSesion()).iterator();
		  while (iterDetCupones.hasNext()) {
			  ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetCupones.next();
			  cargarRegCupon(dsDetCupones, archLoteConciDet);
		  }		  
		  
	  }
	  
	  writeCliente(dsAsiLiqCab);
	  writeCliente(dsAliLiqDet);
	  writeCliente(dsDetCupones);
	  
	  
  }
  
  private void procesarAsientoCob(java.util.Date fecDesde,java.util.Date fecHasta) throws BaseException {
	  
	  IDataSet dsAsiCobCab = getDataSetAsiCobCab();
	  IDataSet dsAsiCobDet = getDataSetAsiCobDet();
	  IDataSet dsCuponesCob = getDataSetDetCuponesCob();
	  
	  Iterator iterAsientos = 
		  CabAsiTarjACobrar.getAsientosByFechas(fecDesde, fecHasta, this.getSesion()).iterator();
	  while (iterAsientos.hasNext()) {
		  CabAsiTarjACobrar cabAsiTarjACobrar = (CabAsiTarjACobrar) iterAsientos.next();
		  cargarCabAsiCon(dsAsiCobCab, cabAsiTarjACobrar);
		  
		  Iterator iterDetAsientos = 
			  cabAsiTarjACobrar.getDetallesAsiento().iterator();
		  while (iterDetAsientos.hasNext()) {
			  DetAsiTarjACobrar detAsiTarjACobrar = (DetAsiTarjACobrar) iterDetAsientos.next();
			  cargarDetAsiCob(dsAsiCobDet, detAsiTarjACobrar);
		  }
		  
		  Iterator iterDetCupones = 
			  ArchLoteConciDet.getArchLoteDetByAsiCob(cabAsiTarjACobrar,this.getSesion()).iterator();
		  while (iterDetCupones.hasNext()) {
			  ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetCupones.next();
			  cargarRegCupon(dsCuponesCob, archLoteConciDet);
		  }
		  
		  
	  }
	  
	  writeCliente(dsAsiCobCab);
	  writeCliente(dsAsiCobDet);
	  writeCliente(dsCuponesCob);
	  
	  
  }  

  private IDataSet getDataSetAsiCobCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAsiCobCab");
    dataset.fieldDef(new Field("oid_cab_asi_acob", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_asiento", Field.DATE, 0));
    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
    dataset.fieldDef(new Field("nro_liquidacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("conta_sist_ext", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_conta_sist_ext", Field.DATE, 0));
    dataset.fieldDef(new Field("hor_conta_sist_ext", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetAsiLiqCab() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAsiLiqCab");
	    dataset.fieldDef(new Field("oid_cab_asi_liq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fec_asiento", Field.DATE, 0));
	    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
	    dataset.fieldDef(new Field("nro_liquidacion", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("conta_sist_ext", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_conta_sist_ext", Field.DATE, 0));
	    dataset.fieldDef(new Field("hor_conta_sist_ext", Field.STRING, 5));
	    dataset.fieldDef(new Field("cuenta_banco", Field.STRING, 100));
	    dataset.fieldDef(new Field("modelo_liquidacion", Field.STRING, 100));
	    return dataset;
  }
  
  private void cargarRegAsiLiq(
		  	IDataSet dataset, 
		  	CabAsiLiquiTarj cabAsiLiquiTarj) 
  	throws BaseException {  

	  dataset.append();
	  
	  dataset.fieldValue("oid_cab_asi_liq", cabAsiLiquiTarj.getOIDInteger());
	  dataset.fieldValue("fec_asiento", cabAsiLiquiTarj.getFec_asiento());
	  dataset.fieldValue("comentario", cabAsiLiquiTarj.getComentario());
	  dataset.fieldValue("nro_liquidacion", cabAsiLiquiTarj.getNro_liquidacion());
	  dataset.fieldValue("conta_sist_ext", cabAsiLiquiTarj.isConta_sist_ext());
	  dataset.fieldValue("fec_conta_sist_ext", cabAsiLiquiTarj.getFec_conta_sist_ext());
	  dataset.fieldValue("hor_conta_sist_ext", cabAsiLiquiTarj.getHor_conta_sist_ext());
	  if (cabAsiLiquiTarj.getCtaBancoLiqTarj()!=null)
		  dataset.fieldValue("cuenta_banco", cabAsiLiquiTarj.getCtaBancoLiqTarj().getDescripcion());
	  else
		  dataset.fieldValue("cuenta_banco", "");
	  if (cabAsiLiquiTarj.getCabModeloLiq()!=null)
		  dataset.fieldValue("modelo_liquidacion", cabAsiLiquiTarj.getCabModeloLiq().getDescripcion());
	  else
		  dataset.fieldValue("modelo_liquidacion", "");
  }
  
  
  
  
  private IDataSet getDataSetAsiCobDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAsiCobDet");
	    dataset.fieldDef(new Field("oid_det_asi_acob", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cab_asi_acob", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cuenta", Field.STRING, 50));
	    dataset.fieldDef(new Field("compo1", Field.STRING, 50));
	    dataset.fieldDef(new Field("compo2", Field.STRING, 50));
	    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }  
  
  private IDataSet getDataSetAsiLiqDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAsiLiqDet");
	    dataset.fieldDef(new Field("oid_det_asi_liq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cab_asi_liq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cuenta", Field.STRING, 50));
	    dataset.fieldDef(new Field("compo1", Field.STRING, 50));
	    dataset.fieldDef(new Field("compo2", Field.STRING, 50));
	    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("cod_impu", Field.STRING, 50));
	    dataset.fieldDef(new Field("porc_impu", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("base", Field.CURRENCY, 0));
	    return dataset;
  }
  
  private void cargarDetAsiLiq(IDataSet dataset, 
		  					   DetAsiLiquiTarj aDetAsiLiquiTarj) 
  	throws BaseException {  

	  dataset.append();
	  dataset.fieldValue("oid_det_asi_liq", aDetAsiLiquiTarj.getOIDInteger());
	  dataset.fieldValue("orden", aDetAsiLiquiTarj.getOrden());
	  dataset.fieldValue("oid_cab_asi_liq", aDetAsiLiquiTarj.getCabasiliqtarj().getOIDInteger());
	  dataset.fieldValue("cuenta", aDetAsiLiquiTarj.getCuenta());
	  dataset.fieldValue("compo1", aDetAsiLiquiTarj.getCompo1());
	  dataset.fieldValue("compo2", aDetAsiLiquiTarj.getCompo2());
	  dataset.fieldValue("debe", aDetAsiLiquiTarj.getDebe());
	  dataset.fieldValue("haber", aDetAsiLiquiTarj.getHaber());
	  dataset.fieldValue("activo", aDetAsiLiquiTarj.isActivo());
	  dataset.fieldValue("cod_impu", aDetAsiLiquiTarj.getCodImpuesto());
	  dataset.fieldValue("porc_impu", aDetAsiLiquiTarj.getPorcImpuesto());
	  dataset.fieldValue("base", aDetAsiLiquiTarj.getBaseImpuesto());	  
  }  
  
  private void cargarDetAsiCob(IDataSet dataset, 
		                 	   DetAsiTarjACobrar aDetAsiTarjACobrar) 
	   throws BaseException {  
	  
	    dataset.append();
	    dataset.fieldValue("oid_det_asi_acob", aDetAsiTarjACobrar.getOIDInteger());
	    dataset.fieldValue("orden", aDetAsiTarjACobrar.getOrden());
	    dataset.fieldValue("oid_cab_asi_acob", aDetAsiTarjACobrar.getCab_asi_acob().getOIDInteger());
	    dataset.fieldValue("cuenta", aDetAsiTarjACobrar.getCuenta());
	    dataset.fieldValue("compo1", aDetAsiTarjACobrar.getCompo1());
	    dataset.fieldValue("compo2", aDetAsiTarjACobrar.getCompo2());
	    dataset.fieldValue("debe", aDetAsiTarjACobrar.getDebe());
	    dataset.fieldValue("haber", aDetAsiTarjACobrar.getHaber());
	    dataset.fieldValue("activo", aDetAsiTarjACobrar.isActivo());
  }

  private void cargarCabAsiCon(IDataSet dataset, 
		  					  CabAsiTarjACobrar aCabAsiTarjACobrar) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_cab_asi_acob", aCabAsiTarjACobrar.getOIDInteger());
    dataset.fieldValue("fec_asiento", aCabAsiTarjACobrar.getFec_asiento());
    dataset.fieldValue("comentario", aCabAsiTarjACobrar.getComentario());
    dataset.fieldValue("nro_liquidacion", aCabAsiTarjACobrar.getNro_liquidacion());
    dataset.fieldValue("conta_sist_ext", aCabAsiTarjACobrar.isConta_sist_ext());
    dataset.fieldValue("fec_conta_sist_ext", aCabAsiTarjACobrar.getFec_conta_sist_ext());
    dataset.fieldValue("hor_conta_sist_ext", aCabAsiTarjACobrar.getHor_conta_sist_ext());
    dataset.fieldValue("activo", aCabAsiTarjACobrar.isActivo());    
  }
  
	private IDataSet getDataSetDetCuponesCob() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetCuponesCob");
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
	
	private IDataSet getDataSetDetCuponesLiq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetCuponesLiq");
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
  
}
