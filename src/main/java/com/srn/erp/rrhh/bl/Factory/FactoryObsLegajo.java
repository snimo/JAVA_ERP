package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.ObsLegajo;
import com.srn.erp.rrhh.bm.TipoObsLeg;
import com.srn.erp.rrhh.da.DBObsLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryObsLegajo extends FactoryObjetoLogico {

	public FactoryObsLegajo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		ObsLegajo obslegajo = (ObsLegajo) objLog;
		obslegajo.setOID(db.getInteger(DBObsLegajo.OID_OBS_LEG));
		obslegajo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBObsLegajo.OID_LEGAJO), getSesion()));
		obslegajo.setTipo_obs_leg(TipoObsLeg.findByOidProxy(db.getInteger(DBObsLegajo.OID_TIPO_OBS_LEG), getSesion()));
		obslegajo.setFecha(db.getDate(DBObsLegajo.FECHA));
		obslegajo.setFec_carga(db.getDate(DBObsLegajo.FEC_CARGA));
		obslegajo.setUsuario_carga(Usuario.findByOidProxy(db.getInteger(DBObsLegajo.OID_USU_CARGA), getSesion()));
		obslegajo.setObservacion(db.getString(DBObsLegajo.OBSERVACION));
		obslegajo.setActivo(db.getBoolean(DBObsLegajo.ACTIVO));
		obslegajo.setPosNegNeu(db.getString(DBObsLegajo.POS_NEG_NEU));
	}
}
