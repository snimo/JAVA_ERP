package com.srn.erp.rrhh.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AgrupadorAntEmp;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEmpAgruParaAnt extends Operation {

	public SaveEmpAgruParaAnt() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TAgrupadoresEmpresas");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			ValorClasificadorEntidad valorClasifEmp = ValorClasificadorEntidad.findByOid(dataset.getInteger("OID_VAL_CLASIF_EMP"), getSesion());

			AgrupadorAntEmp agrupadorAntEmp = AgrupadorAntEmp.findByCodigo(valorClasifEmp.getOIDInteger().toString(), this.getSesion());
			
			if (agrupadorAntEmp == null) {
				agrupadorAntEmp = (AgrupadorAntEmp) AgrupadorAntEmp.getNew(AgrupadorAntEmp.NICKNAME, this.getSesion());
				agrupadorAntEmp.setValorClasifEmp(valorClasifEmp);
			}

			agrupadorAntEmp.setCod_ant_emp(dataset.getString("COD_ANT_EMP"));
			addTransaccion(agrupadorAntEmp);

			dataset.next();
		}
	}

}
