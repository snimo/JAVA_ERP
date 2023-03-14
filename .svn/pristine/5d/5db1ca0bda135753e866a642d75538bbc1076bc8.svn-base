package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.DetTarConciEnt;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuponTARJETAParaBaja extends Operation {

	public TraerCuponTARJETAParaBaja() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidTarInfoDet = mapaDatos.getInteger("oid_tar_info_det");
		DetTarConciEnt detTarConciEnt = 
			(DetTarConciEnt) DetTarConciEnt.findByOidProxy(oidTarInfoDet, this.getSesion());
		IDataSet ds = this.getDataSetDetCupon();
		cargarRegCupon(ds, detTarConciEnt);
		writeCliente(ds);
	}

	private void cargarRegCupon(IDataSet dsCupon, DetTarConciEnt detTarConciEnt) throws BaseException {
		dsCupon.append();
		dsCupon.fieldValue("oid_tar_info_det", detTarConciEnt.getOIDInteger());
		TarjetaConciTar tarjeta = 
			TarjetaConciTar.getTarjetaConciliacion(detTarConciEnt.getTarjeta(),this.getSesion());
		dsCupon.fieldValue("oid_terminal", "");
		dsCupon.fieldValue("fec_origen", detTarConciEnt.getFec_origen());
		dsCupon.fieldValue("fec_cierre", detTarConciEnt.getFec_present());
		dsCupon.fieldValue("tipo", detTarConciEnt.getTipoTarjeta());
		if (tarjeta!=null)
			dsCupon.fieldValue("oid_tarjeta", tarjeta.getOIDInteger());
		else
			dsCupon.fieldValue("oid_tarjeta", "");
		dsCupon.fieldValue("nro_tarjeta", detTarConciEnt.getNro_tarjeta());
		dsCupon.fieldValue("lote", detTarConciEnt.getLote());
		dsCupon.fieldValue("cupon", detTarConciEnt.getNro_cupon());
		dsCupon.fieldValue("importe", detTarConciEnt.getImporte());
		dsCupon.fieldValue("acepto", false);

	}

	private IDataSet getDataSetDetCupon() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInput");
		dataset.fieldDef(new Field("oid_tar_info_det", Field.INTEGER, 0));
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
