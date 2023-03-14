package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOPVariosEfectivo extends Operation {

	public TraerOPVariosEfectivo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid");
		ComproOrdenPagoCab comproOPCab = ComproOrdenPagoCab.findByOid(oid, getSesion());
		
		IDataSet dsOPCab = this.getDataSetOPCab();
		IDataSet dsConceptos = this.getDataSetConceptos();

		cargarRegistroOPCab(dsOPCab,comproOPCab);
		
		Iterator iterOrdPagoDet = 
			comproOPCab.getVencimientosPagados().iterator();
		while (iterOrdPagoDet.hasNext()) {
			ComproOrdenPagoDet comproOPDet = (ComproOrdenPagoDet) iterOrdPagoDet.next();
			cargarRegistroConcepto(dsConceptos,comproOPDet);
		}
		
		writeCliente(dsOPCab);
		writeCliente(dsConceptos);
		
	}

	private IDataSet getDataSetOPCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOrdPagoCab");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total_pago", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetConceptos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConceptosPagosVarios");
		dataset.fieldDef(new Field("oid_compro_det_op", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_op",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_pv",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_conc_pv",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_conc_pv",Field.STRING, 100));
		dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
		return dataset;
	}
	

	private void cargarRegistroOPCab(
			IDataSet dataset,
			ComproOrdenPagoCab comproOPCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", comproOPCab.getOIDInteger());
		dataset.fieldValue("oid_motivo_pago", comproOPCab.getMotivopago().getOIDInteger());
		dataset.fieldValue("fecha", comproOPCab.getEmision());
		dataset.fieldValue("oid_moneda", comproOPCab.getMoneda().getOIDInteger());
		dataset.fieldValue("cotizacion", comproOPCab.getCotizacion());
		dataset.fieldValue("oid_talonario", comproOPCab.getTalonario().getOIDInteger());
		dataset.fieldValue("total_pago", comproOPCab.getTotalPago());
		if (comproOPCab.getCaja()!=null)
			dataset.fieldValue("oid_caja", comproOPCab.getCaja().getOIDInteger());
		else
			dataset.fieldValue("oid_caja", new Integer(0));
		dataset.fieldValue("activo", comproOPCab.isActivo());
		dataset.fieldValue("nro_ext", comproOPCab.getNroExt());
	}
	
	private void cargarRegistroConcepto(
			IDataSet dataset,
			ComproOrdenPagoDet comproOrdenPagoDet) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_compro_det_op", comproOrdenPagoDet.getOIDInteger());
		dataset.fieldValue("oid_cco_op", comproOrdenPagoDet.getComproOrdenDePago().getOIDInteger());
		dataset.fieldValue("oid_conc_pv",comproOrdenPagoDet.getConceptoOPVarias().getOIDInteger());
		dataset.fieldValue("cod_conc_pv",comproOrdenPagoDet.getConceptoOPVarias().getCodigo());
		dataset.fieldValue("desc_conc_pv",comproOrdenPagoDet.getConceptoOPVarias().getDescripcion());
		dataset.fieldValue("importe",comproOrdenPagoDet.getNetopagomonori());
		dataset.fieldValue("comentario",comproOrdenPagoDet.getComentario());
		
	}
	

}
