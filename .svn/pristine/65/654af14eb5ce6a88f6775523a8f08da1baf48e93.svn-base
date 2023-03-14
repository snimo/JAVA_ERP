package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerRelIndiExc extends Operation {

	public TraerRelIndiExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetRelIndi();
		IndividuoExcluido individuo =
			IndividuoExcluido.findByOidProxy(mapaDatos.getInteger("oid_individuo"), this.getSesion());
		if (individuo!=null)
			cargarRegistroRelIndi(ds, individuo);
		writeCliente(ds);
	}

	private IDataSet getDataSetRelIndi() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRelacionIndividuo");
		dataset.fieldDef(new Field("oid_individuo",Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom",Field.STRING, 100));
		dataset.fieldDef(new Field("estado",Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroRelIndi(IDataSet dataset, IndividuoExcluido individuo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_individuo", individuo.getOIDInteger());
		dataset.fieldValue("ape_y_nom", individuo.getApeyNom());
		if (individuo.getEstado()!=null)
			dataset.fieldValue("estado", individuo.getEstado().getDescripcion());
		else
			dataset.fieldValue("estado", "");
	}
}
