package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class MarcaDesCuponPOSNETPerdido extends Operation {

	public MarcaDesCuponPOSNETPerdido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidArchLoteDet = mapaDatos.getInteger("oid_arch_lote_det");
		ArchLoteConciDet archLoteConciDet = ArchLoteConciDet.findByOid(oidArchLoteDet, this.getSesion());
		if (archLoteConciDet == null)
			throw new ExceptionValidation(null,"No se encontró el cupon seleccionado");

		IDataSet ds = this.getDataSetCuponPerdido();
		
		if (archLoteConciDet.isCuponPerdido()) {
			archLoteConciDet.marcarComoNoPerdido();
			cargar(ds, archLoteConciDet.getOIDInteger(), false);
		}
		else {
			archLoteConciDet.marcarComoPerdido();
			cargar(ds, archLoteConciDet.getOIDInteger(), true);
		}
		
		writeCliente(ds);
	}
	
	private IDataSet getDataSetCuponPerdido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCuponPerdido");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cupon_perdido", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargar(IDataSet ds,Integer oidArchLoteConciDet , boolean cuponPerdido) throws BaseException {
		ds.append();
		ds.fieldValue("oid_arch_lote_det", oidArchLoteConciDet);
		ds.fieldValue("cupon_perdido", cuponPerdido);
	}
	
	

}
