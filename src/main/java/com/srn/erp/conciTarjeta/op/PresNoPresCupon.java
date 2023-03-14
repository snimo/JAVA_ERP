package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class PresNoPresCupon extends Operation {

	public PresNoPresCupon() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidArchLoteDet = mapaDatos.getInteger("oid_arch_lote_det");
		ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(oidArchLoteDet, this.getSesion());
		
		try {
			archLoteConciDet.invertirMarcaPresentado();
			this.getSesion().commitTransaction();
		} catch (Exception e) {
			this.getSesion().rollBackTransaction();
			throw new ExceptionValidation(null,"Se produjo un error y no se pudo marcar/desmarcar el registro."+e.getMessage());
		}
		
		ArchLoteConciDet refrescarArchLoteConciDet =
			ArchLoteConciDet.findByOid(oidArchLoteDet, this.getSesion());
		
		IDataSet ds = this.getDSCuponPresentado();
		cargarCuponPresentado(ds, oidArchLoteDet, refrescarArchLoteConciDet.isPresentado(), refrescarArchLoteConciDet.getFecPresenCupo());
		writeCliente(ds);

	}

	private IDataSet getDSCuponPresentado() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCuponPresentado");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("presentado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_presentado", Field.DATE, 0));
		return dataset;
	}

	private void cargarCuponPresentado(IDataSet dataset, Integer oidArchLoteDet, boolean presentado, java.util.Date fecha) {
		dataset.append();
		dataset.fieldValue("oid_arch_lote_det", oidArchLoteDet);
		dataset.fieldValue("presentado", presentado);
		dataset.fieldValue("fec_presentado", fecha);
	}

}
