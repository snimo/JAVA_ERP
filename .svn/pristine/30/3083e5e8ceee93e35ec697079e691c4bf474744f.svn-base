package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSistemaCuentaBanco extends Operation {

	public SaveSistemaCuentaBanco() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TUniOrg");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			UnidadOrganizativa uniOrg = UnidadOrganizativa
					.findByOid(dataset.getInteger("oid_uni_org"), this.getSesion());

			IDataSet dsCtas = dataset.getDataSet("TUniOrgCta");
			dsCtas.first();
			while (!dsCtas.EOF()) {
				CuentaSistemaBanco ctaSistBco = CuentaSistemaBanco.findByOid(dsCtas.getInteger("oid_cta_hab_bco"), this
						.getSesion());
				ctaSistBco.setUnidadOrganizativa(uniOrg);
				ctaSistBco.setCuenta(CuentaImputable.findByOidProxy(dsCtas.getInteger("oid_ai"), this.getSesion()));
				ctaSistBco.setActivo(dsCtas.getBoolean("activo"));
				
				if (ctaSistBco.isActivo().booleanValue()==false)
					ctaSistBco.delete();
				
				this.addTransaccion(ctaSistBco);
				dsCtas.next();
			}
			
			dataset.next();

		}
	}

}
