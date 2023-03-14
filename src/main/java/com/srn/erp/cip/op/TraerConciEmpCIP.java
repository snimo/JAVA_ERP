package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.EmpresaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConciEmpCIP extends Operation {

	public TraerConciEmpCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsEmpresasLike = this.getDataSetEmpresasLike();
		String empresa = mapaDatos.getString("empresa");
		Iterator iterEmpresas = EmpresaCIP.getEmpresasCIP(empresa, this.getSesion()).iterator();
		while (iterEmpresas.hasNext()) {
			EmpresaCIP empresaCIP = (EmpresaCIP) iterEmpresas.next();
			cargarRegistro(dsEmpresasLike, empresaCIP.getOIDInteger() , empresaCIP.getRazon_social());
		}
		writeCliente(dsEmpresasLike);
	}

	private IDataSet getDataSetEmpresasLike() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresasLike");
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Integer oid, String empresa) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_empresa", oid);
		dataset.fieldValue("empresa", empresa);
	}

}
