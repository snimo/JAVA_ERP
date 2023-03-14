package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InicioCategAccesoCIP extends Operation {

	public InicioCategAccesoCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsPuertasEnPlanos = getDataSetPuertasEnPlanos();

		Integer oidCateg = mapaDatos.getInteger("oid_categ");

		int secu = 1;
		Iterator iterPlanos = PlanoCIP.getAllPlanos(this.getSesion()).iterator();
		while (iterPlanos.hasNext()) {
			PlanoCIP planoCIP = (PlanoCIP) iterPlanos.next();

			Iterator iterPuertasPlano = planoCIP.getPuertasPlano().iterator();

			while (iterPuertasPlano.hasNext()) {
				PuertaPlanoCIP puertaPlano = (PuertaPlanoCIP) iterPuertasPlano.next();

				++secu;

				cargarPuertasEnPlanos(dsPuertasEnPlanos, oidCateg, secu,
						planoCIP.getGrupo_plano().getDescripcion(), planoCIP,
						puertaPlano.getOrden(), puertaPlano.getPuerta(), false,
						false);

			}
		}

		writeCliente(dsPuertasEnPlanos);

	}


	private IDataSet getDataSetPuertasEnPlanos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuertasEnZonas");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("agrupador_plano", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_categ_acceso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_plano", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_plano", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_plano", Field.STRING, 100));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
		dataset.fieldDef(new Field("hab_entrada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_salida", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarPuertasEnPlanos(IDataSet dsCategAcceso,
			Integer oidCateg, Integer secu, String agrupadorPlano,
			PlanoCIP plano, Integer orden, Puerta puerta, boolean habEntrada,
			boolean habSalida) throws BaseException {

		dsCategAcceso.append();
		dsCategAcceso.fieldValue("secu", secu);
		dsCategAcceso.fieldValue("agrupador_plano", agrupadorPlano);
		dsCategAcceso.fieldValue("oid_categ_acceso", oidCateg);
		dsCategAcceso.fieldValue("oid_plano", plano.getOIDInteger());
		dsCategAcceso.fieldValue("cod_plano", plano.getCodigo());
		dsCategAcceso.fieldValue("desc_plano", plano.getDescripcion());
		dsCategAcceso.fieldValue("orden", orden);
		dsCategAcceso.fieldValue("oid_puerta", puerta.getOIDInteger());
		dsCategAcceso.fieldValue("cod_puerta", puerta.getCodigo());
		dsCategAcceso.fieldValue("desc_puerta", puerta.getDescripcion());
		dsCategAcceso.fieldValue("hab_entrada", habEntrada);
		dsCategAcceso.fieldValue("hab_salida", habSalida);

	}

}
