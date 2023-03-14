package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.TerminalConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuponPOSNETParaBaja extends Operation {

	public TraerCuponPOSNETParaBaja() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidArchLoteDet = mapaDatos.getInteger("oid_arch_lote_det");
		ArchLoteConciDet archLoteDet = 
			(ArchLoteConciDet) ArchLoteConciDet.findByOidProxy(oidArchLoteDet, this.getSesion());
		IDataSet ds = this.getDataSetDetCupon();
		cargarRegCupon(ds, archLoteDet);
		writeCliente(ds);
	}

	private void cargarRegCupon(IDataSet dsCupon, ArchLoteConciDet archLoteConciDet) throws BaseException {
		dsCupon.append();
		dsCupon.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
		TerminalConciTar terminal = (TerminalConciTar) TerminalConciTar.findByCodigo(archLoteConciDet.getNro_terminal(), this.getSesion());
		if (terminal != null)
			dsCupon.fieldValue("oid_terminal", terminal.getOIDInteger());
		else
			dsCupon.fieldValue("oid_terminal", "");
		dsCupon.fieldValue("fec_origen", archLoteConciDet.getFecOperDate());
		dsCupon.fieldValue("fec_cierre", archLoteConciDet.getFecCierre());
		dsCupon.fieldValue("tipo", archLoteConciDet.getTipo_tarjeta());
		dsCupon.fieldValue("oid_tarjeta", archLoteConciDet.getTarjetaConciTar().getOIDInteger());
		dsCupon.fieldValue("nro_tarjeta", archLoteConciDet.getUltimosNrosTarjeta());
		dsCupon.fieldValue("lote", archLoteConciDet.getNro_lote());
		dsCupon.fieldValue("cupon", archLoteConciDet.getTicket());
		dsCupon.fieldValue("importe", archLoteConciDet.getMonto());
		dsCupon.fieldValue("acepto", false);

	}

	private IDataSet getDataSetDetCupon() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInput");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_terminal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_origen", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_cierre", Field.DATE, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cupon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("acepto", Field.BOOLEAN, 0));
		return dataset;
	}

}
