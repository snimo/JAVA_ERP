package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.ListaBlanca;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TelecomandoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class RegenerarListaBlanca extends Operation {

	public RegenerarListaBlanca() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		ListaBlanca.regenerarListaBlanca(getSesion());
	}

}
