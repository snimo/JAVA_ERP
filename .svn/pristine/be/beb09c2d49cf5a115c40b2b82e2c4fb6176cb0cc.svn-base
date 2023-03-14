package com.srn.erp.legales.bl.Factory;

import com.srn.erp.legales.bm.EstadoSeclo;
import com.srn.erp.legales.bm.FormaExtincion;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.legales.da.DBSeclo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeclo extends FactoryObjetoLogico {

	public FactorySeclo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Seclo seclo = (Seclo) objLog;
		seclo.setOID(db.getInteger(DBSeclo.OID_SECLO));
		seclo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBSeclo.OID_LEGAJO), getSesion()));
		seclo.setFec_recepcion(db.getDate(DBSeclo.FEC_RECEPCION));
		seclo.setTipo_reclamo(TipoReclamoLeg.findByOidProxy(db.getInteger(DBSeclo.OID_TIPO_RECLAMO), getSesion()));
		seclo.setMonto_reclamo(db.getMoney(DBSeclo.MONTO_RECLAMO));
		seclo.setObservaciones(db.getString(DBSeclo.OBSERVACIONES));
		seclo.setActivo(db.getBoolean(DBSeclo.ACTIVO));
		seclo.setEstado_seclo(EstadoSeclo.findByOidProxy(db.getInteger(DBSeclo.OID_ESTADO_SECLO), getSesion()));
		seclo.setMonto_acuerdo(db.getMoney(DBSeclo.MONTO_ACUERDO));
		seclo.setHono_letrado(db.getMoney(DBSeclo.HONO_LETRADO));
		seclo.setHono_conciliado(db.getMoney(DBSeclo.HONO_CONCILIADO));
		seclo.setOtros_hono(db.getMoney(DBSeclo.OTROS_HONO));
		seclo.setPagado(db.getMoney(DBSeclo.PAGADO));
		seclo.setSaldado(db.getBoolean(DBSeclo.SALDADO));
		seclo.setcodigoInterno(db.getString(DBSeclo.CODIGO_INTERNO));
		seclo.setTipo(db.getString(DBSeclo.TIPO));
		seclo.setFormaExtincion(FormaExtincion.findByOidProxy(db.getInteger(DBSeclo.OID_FORMA_EXTINCION), getSesion()));
		seclo.setFecNovedad(db.getDate(DBSeclo.FEC_NOVEDAD));
		seclo.setCausaAcuerdo(db.getString(DBSeclo.CAUSAL_ACUERDO));
		
		
		
		
	}
}
