package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.CtaBancoLiqTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCtasConciByEmp extends Operation {

	public TraerCtasConciByEmp() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());  
		IDataSet ds = this.getDataSet();
		Iterator iterCtasBanco = CtaBancoLiqTarj.getCtasByEmpresa(empresa, this.getSesion()).iterator();
		while (iterCtasBanco.hasNext()) {
			CtaBancoLiqTarj ctaBancoLiqTarj = (CtaBancoLiqTarj) iterCtasBanco.next();
			cargarRegistro(ds, ctaBancoLiqTarj);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCtasBancarias");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, CtaBancoLiqTarj aCtaBancoLiqTarj) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", aCtaBancoLiqTarj.getOIDInteger());
		dataset.fieldValue("codigo", aCtaBancoLiqTarj.getCodigo());
		dataset.fieldValue("descripcion", aCtaBancoLiqTarj.getDescripcion());
	}
}
