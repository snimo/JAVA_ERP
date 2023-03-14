package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.AudienciaJuicio;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.TipoAudiencia;
import com.srn.erp.legales.da.DBAudienciaJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAudienciaJuicio extends FactoryObjetoLogico {

	public FactoryAudienciaJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		AudienciaJuicio audienciajuicio = (AudienciaJuicio) objLog;
		audienciajuicio.setOID(db.getInteger(DBAudienciaJuicio.OID_AUD_JUICIO));
		audienciajuicio.setJuicio(Juicio.findByOidProxy(db.getInteger(DBAudienciaJuicio.OID_JUICIO), getSesion()));
		audienciajuicio.setFecha(db.getDate(DBAudienciaJuicio.FECHA));
		audienciajuicio.setHora(db.getString(DBAudienciaJuicio.HORA));
		audienciajuicio.setPersona(db.getString(DBAudienciaJuicio.PERSONA));
		audienciajuicio.setTipo_audiencia(TipoAudiencia.findByOidProxy(db.getInteger(DBAudienciaJuicio.OID_TIPO_AUD), getSesion()));
		audienciajuicio.setActivo(db.getBoolean(DBAudienciaJuicio.ACTIVO));

	}
}
