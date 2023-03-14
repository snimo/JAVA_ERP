package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.NovedadLegajo;
import com.srn.erp.rrhh.bm.TipoNovedad;
import com.srn.erp.rrhh.da.DBNovedadLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNovedadLegajo extends FactoryObjetoLogico {

	public FactoryNovedadLegajo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		NovedadLegajo novedadlegajo = (NovedadLegajo) objLog;
		novedadlegajo.setOID(db.getInteger(DBNovedadLegajo.OID_NOVEDAD));
		novedadlegajo.setNro_ext(db.getInteger(DBNovedadLegajo.NRO_EXT));
		novedadlegajo.setOid_tipo_novedad(TipoNovedad.findByOidProxy(db.getInteger(DBNovedadLegajo.OID_TIPO_NOVEDAD), getSesion()));
		novedadlegajo.setMotivo_tipo_nov(MotivoTipoNov.findByOidProxy(db.getInteger(DBNovedadLegajo.OID_MOT_TIPO_NOV), getSesion()));
		novedadlegajo.setFecha(db.getDate(DBNovedadLegajo.FECHA));
		novedadlegajo.setHora_desde(db.getString(DBNovedadLegajo.HORA_DESDE));
		novedadlegajo.setHora_hasta(db.getString(DBNovedadLegajo.HORA_HASTA));
		novedadlegajo.setActivo(db.getBoolean(DBNovedadLegajo.ACTIVO));
		novedadlegajo.setObservacion(db.getString(DBNovedadLegajo.OBSERVACION));
		novedadlegajo.setOid_legajo(Legajo.findByOidProxy(db.getInteger(DBNovedadLegajo.OID_LEGAJO), getSesion()));
		novedadlegajo.setNroOrden(db.getInteger(DBNovedadLegajo.NRO_ORDEN));
	}
}
