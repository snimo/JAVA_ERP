package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class ProcesarAutorizacionOC extends Operation {

	public ProcesarAutorizacionOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		autorizarDetOC(mapaDatos);
	}

	private void autorizarDetOC(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TOCSel");
		dataset.first();
		while (!dataset.EOF()) {
			Integer oidOC = dataset.getInteger("oid_oc");
			OrdenDeCompraCab ocCab = OrdenDeCompraCab.findByOid(oidOC, this.getSesion());
			ocCab.realizarAutorizacionesOC();
			dataset.next();
		}
	}

}
