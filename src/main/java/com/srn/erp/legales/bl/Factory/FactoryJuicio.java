package com.srn.erp.legales.bl.Factory;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.legales.bm.Abogado;
import com.srn.erp.legales.bm.CompaniaSeguro;
import com.srn.erp.legales.bm.EstadoJuicio;
import com.srn.erp.legales.bm.EstadoProcesal;
import com.srn.erp.legales.bm.Fuero;
import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.Juzgado;
import com.srn.erp.legales.bm.ResultadoJuicio;
import com.srn.erp.legales.bm.TipoPericia;
import com.srn.erp.legales.bm.TipoReclamoLeg;
import com.srn.erp.legales.da.DBJuicio;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryJuicio extends FactoryObjetoLogico {

	public FactoryJuicio() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Juicio juicio = (Juicio) objLog;
		juicio.setOID(db.getInteger(DBJuicio.OID_JUICIO));
		juicio.setTipo_reclamo(TipoReclamoLeg.findByOidProxy(db.getInteger(DBJuicio.OID_TIPO_RECLAMO), getSesion()));
		juicio.setFec_rec_dem(db.getDate(DBJuicio.FEC_REC_DEM));
		juicio.setJuzgado(Juzgado.findByOidProxy(db.getInteger(DBJuicio.OID_JUZGADO), getSesion()));
		juicio.setNro_expediente(db.getString(DBJuicio.NRO_EXPEDIENTE));
		juicio.setMonto_reclamo(db.getMoney(DBJuicio.MONTO_RECLAMO));
		juicio.setProb_resultado(db.getString(DBJuicio.PROB_RESULTADO));
		juicio.setPorc_prevision(db.getMoney(DBJuicio.PORC_PREVISION));
		juicio.setEstado_procesal(EstadoProcesal.findByOidProxy(db.getInteger(DBJuicio.OID_EST_PROCESAL), getSesion()));
		juicio.setEstado_juicio(EstadoJuicio.findByOidProxy(db.getInteger(DBJuicio.OID_EST_JUICIO), getSesion()));
		juicio.setActivo(db.getBoolean(DBJuicio.ACTIVO));
		juicio.setObservaciones(db.getString(DBJuicio.OBSERVACIONES));
		juicio.setPeriodo_mensual(Periodo.findByOidProxy(db.getInteger(DBJuicio.OID_PERI_MENS_PREV), getSesion()));
		juicio.setPrevision(db.getMoney(DBJuicio.PREVISION));
		juicio.setAbogado(Abogado.findByOidProxy(db.getInteger(DBJuicio.OID_ABOGADO), getSesion()));
		juicio.setLegajo(Legajo.findByOidProxy(db.getInteger(DBJuicio.OID_LEGAJO), getSesion()));
		juicio.setCBU(db.getString(DBJuicio.CBU));
		juicio.setEmbargo(db.getMoney(DBJuicio.EMBARGO));
		juicio.setMontoIntereses(db.getMoney(DBJuicio.MONTO_INTERESES));
		juicio.setEstimado(db.getMoney(DBJuicio.ESTIMADO));
		juicio.setResultadoJuicio(ResultadoJuicio.findByOidProxy(db.getInteger(DBJuicio.OID_RESUL_JUICIO), getSesion()));
		juicio.setCodigoInterno(db.getString(DBJuicio.CODIGO_INTERNO));
		juicio.setFecNovedad(db.getDate(DBJuicio.FEC_NOVEDAD));
		juicio.setMontoAcuerdo(db.getMoney(DBJuicio.MONTO_ACUERDO));
		juicio.setMontoConciliado(db.getMoney(DBJuicio.MONTO_HONORARIO));
		juicio.setMontoPerito(db.getMoney(DBJuicio.MONTO_PERITO));
		juicio.setMontoTasaJusticia(db.getMoney(DBJuicio.TASA_JUSTICIA));
		juicio.setMontoLetrado(db.getMoney(DBJuicio.MONTO_LETRADO));
		juicio.setTipoPericia(TipoPericia.findByOidProxy(db.getInteger(DBJuicio.TIPO_PERICIA), getSesion()));
		juicio.setFuero(Fuero.findByOidProxy(db.getInteger(DBJuicio.OID_FUERO), getSesion()));
		juicio.setCaratula(db.getString(DBJuicio.CARATULA));
		juicio.setCompaniaSeguroCaucion(CompaniaSeguro.findByOidProxy(db.getInteger(DBJuicio.OID_COMP_SEG_CAU), getSesion()));
		juicio.setPorcIncapacidad(db.getMoney(DBJuicio.PORC_INCAPACIDAD));
		juicio.setPorcLetrado(db.getMoney(DBJuicio.PORC_LETRADO));
		juicio.setPorcPerito(db.getMoney(DBJuicio.PORC_PERITO));
		juicio.setPorcTasaJusticia(db.getMoney(DBJuicio.PORC_TASA_JUST));
		juicio.setPrimeraInstancia(db.getString(DBJuicio.PRIMERA_INSTANCIA));
		juicio.setSegundaInstancia(db.getString(DBJuicio.SEGUNDA_INSTANCIA));
		
	}
}
