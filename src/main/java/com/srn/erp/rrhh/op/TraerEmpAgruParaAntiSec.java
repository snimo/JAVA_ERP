package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AgrupadorAntEmp;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEmpAgruParaAntiSec extends Operation {

	public TraerEmpAgruParaAntiSec() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSet();
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		Iterator iterValClasifEmp = clasifEmpresa.getValoresClasificador().iterator();
		while (iterValClasifEmp.hasNext()) {
			ValorClasificadorEntidad valorClasifEmp = (ValorClasificadorEntidad) iterValClasifEmp.next();
			AgrupadorAntEmp agrupadorAntEmp = 
				AgrupadorAntEmp.findByCodigo(valorClasifEmp.getOIDInteger().toString(), this.getSesion());
			if (agrupadorAntEmp!=null)
				cargarRegistro(ds, valorClasifEmp, agrupadorAntEmp.getCod_ant_emp());
			else
				cargarRegistro(ds, valorClasifEmp, null);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAgrupadoresEmpresas");
		dataset.fieldDef(new Field("OID_VAL_CLASIF_EMP", Field.INTEGER, 0));
		dataset.fieldDef(new Field("COD_ANT_EMP", Field.STRING, 50));
		dataset.fieldDef(new Field("DESC_EMPRESA", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, ValorClasificadorEntidad valorEmpresa, String codigoAgrupador) throws BaseException {
		dataset.append();
		dataset.fieldValue("OID_VAL_CLASIF_EMP", valorEmpresa.getOIDInteger());
		dataset.fieldValue("COD_ANT_EMP", codigoAgrupador);
		dataset.fieldValue("DESC_EMPRESA", valorEmpresa.getDescripcion());
	}

}
