package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AgrupadorPlano;
import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePlanoCIP extends Operation {

	public SavePlanoCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TPlanoCIP");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			PlanoCIP planocip = PlanoCIP.findByOid(dataset
					.getInteger("oid_plano"), getSesion());
			planocip.setOID(dataset.getInteger("oid_plano"));
			planocip.setCodigo(dataset.getString("codigo"));
			planocip.setDescripcion(dataset.getString("descripcion"));
			planocip.setGrupo_plano(AgrupadorPlano.findByOidProxy(dataset
					.getInteger("oid_agrup_plano"), this.getSesion()));
			planocip.setOrden(dataset.getInteger("orden"));
			planocip.setActivo(dataset.getBoolean("activo"));

			IDataSet dsPuertaPlano = dataset.getDataSet("TPuertaPlano");
			dsPuertaPlano.first();
			while (!dsPuertaPlano.EOF()) {

				if (dsPuertaPlano.getBoolean("activo")) {

					Puerta puerta = Puerta.findByOid(dsPuertaPlano.getInteger("oid_puerta"), this.getSesion());

					PuertaPlanoCIP puertaPlanoCIP = PuertaPlanoCIP.getPuertaPlanoCIP(puerta, planocip, this.getSesion());

					if (puertaPlanoCIP == null) {
						PuertaPlanoCIP puertaPlanoCIPNew = (PuertaPlanoCIP) PuertaPlanoCIP
								.getNew(PuertaPlanoCIP.NICKNAME, this
										.getSesion());
						puertaPlanoCIPNew.setOrden(dsPuertaPlano
								.getInteger("orden"));
						puertaPlanoCIPNew.setPlano(planocip);
						puertaPlanoCIPNew.setPuerta(puerta);
						puertaPlanoCIPNew.setHab_entrada(dsPuertaPlano.getBoolean("hab_entrada"));
						puertaPlanoCIPNew.setHab_salida(dsPuertaPlano.getBoolean("hab_salida"));
						puertaPlanoCIPNew.setActivo(true);
						planocip.addPuertaPlano(puertaPlanoCIPNew);
					} else {
						puertaPlanoCIP.setHab_entrada(dsPuertaPlano.getBoolean("hab_entrada"));
						puertaPlanoCIP.setHab_salida(dsPuertaPlano.getBoolean("hab_salida"));
						planocip.addPuertaPlano(puertaPlanoCIP);
					}

				} else {

					Puerta puerta = Puerta.findByOid(dsPuertaPlano
							.getInteger("oid_puerta"), this.getSesion());

					PuertaPlanoCIP puertaPlanoCIPBorrar = PuertaPlanoCIP
							.getPuertaPlanoCIP(puerta, planocip, this
									.getSesion());

					if (puertaPlanoCIPBorrar != null) {
						puertaPlanoCIPBorrar.delete();
						planocip.addPuertaPlano(puertaPlanoCIPBorrar);
					}

				}

				dsPuertaPlano.next();
			}

			addTransaccion(planocip);
			dataset.next();
		}
	}

}
