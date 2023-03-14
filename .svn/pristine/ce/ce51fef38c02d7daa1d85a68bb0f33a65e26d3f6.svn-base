package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.DifImporteExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.MotDifPagoExc;
import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBDifImporteExcluido;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDifImporteExcluido extends FactoryObjetoLogico {

	public FactoryDifImporteExcluido() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		DifImporteExcluido difimporteexcluido = (DifImporteExcluido) objLog;
		difimporteexcluido.setOID(db.getInteger(DBDifImporteExcluido.OID_DIF_IMPORTE));
		difimporteexcluido.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBDifImporteExcluido.OID_INDIVIDUO), getSesion()));
		difimporteexcluido.setFecha(db.getDate(DBDifImporteExcluido.FECHA));
		difimporteexcluido.setMotivo(MotDifPagoExc.findByOidProxy(db.getInteger(DBDifImporteExcluido.OID_MOT_DIF_IMP), getSesion()));
		difimporteexcluido.setMoneda(Moneda.findByOidProxy(db.getInteger(DBDifImporteExcluido.OID_MONEDA), getSesion()));
		difimporteexcluido.setMonto(db.getDouble(DBDifImporteExcluido.MONTO));
		difimporteexcluido.setObservacion(db.getString(DBDifImporteExcluido.OBSERVACION));
		difimporteexcluido.setOrden(db.getInteger(DBDifImporteExcluido.ORDEN));
		difimporteexcluido.setActivo(db.getBoolean(DBDifImporteExcluido.ACTIVO));
		difimporteexcluido.setPredioExcluido(PredioExcluido.findByOidProxy(db.getInteger(DBDifImporteExcluido.OID_PREDIO), getSesion()));
	}
}
