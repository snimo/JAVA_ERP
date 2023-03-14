package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.MotivoFaltaRRHH;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.rrhh.bm.SancionesRRHH;
import com.srn.erp.rrhh.da.DBSancionesLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySancionesLegajo extends FactoryObjetoLogico {

	public FactorySancionesLegajo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		SancionesLegajo sancioneslegajo = (SancionesLegajo) objLog;
		sancioneslegajo.setOID(db.getInteger(DBSancionesLegajo.OID_SANC_LEG));
		sancioneslegajo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBSancionesLegajo.OID_LEGAJO), getSesion()));
		sancioneslegajo.setMotivo_falta(MotivoFaltaRRHH.findByOidProxy(db.getInteger(DBSancionesLegajo.OID_MOT_FALTA), getSesion()));
		sancioneslegajo.setMotivo_sancion(SancionesRRHH.findByOidProxy(db.getInteger(DBSancionesLegajo.OID_MOT_SANCION), getSesion()));
		sancioneslegajo.setNro_sancion(db.getInteger(DBSancionesLegajo.NRO_SANCION));
		sancioneslegajo.setFecha(db.getDate(DBSancionesLegajo.FECHA));
		sancioneslegajo.setFec_susp_desde(db.getDate(DBSancionesLegajo.FEC_SUSP_DESDE));
		sancioneslegajo.setFec_reintegro(db.getDate(DBSancionesLegajo.FEC_REINTEGRO));
		sancioneslegajo.setActivo(db.getBoolean(DBSancionesLegajo.ACTIVO));
		

	}
}
