package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotAccInterClasifLeg;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.da.DBMotAccInterClasifLeg;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotAccInterClasifLeg extends FactoryObjetoLogico {

	public FactoryMotAccInterClasifLeg() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db)
			throws BaseException {
		MotAccInterClasifLeg motaccinterclasifleg = (MotAccInterClasifLeg) objLog;
		motaccinterclasifleg.setOID(db
				.getInteger(DBMotAccInterClasifLeg.OID_MOT_INT_CLEG));
		motaccinterclasifleg.setMotivo(MotivoEntIntermedias.findByOidProxy(db
				.getInteger(DBMotAccInterClasifLeg.OID_MOTIVO), getSesion()));
		motaccinterclasifleg.setValorclasificador(ValorClasificadorEntidad
				.findByOidProxy(db
						.getInteger(DBMotAccInterClasifLeg.OID_VAL_CLASIF),
						getSesion()));
		motaccinterclasifleg.setActivo(db
				.getBoolean(DBMotAccInterClasifLeg.ACTIVO));

	}
}
