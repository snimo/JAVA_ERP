package com.srn.erp.bienUso.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.AmortizacionAcumulada;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAmortizacionAcumulada extends DBObjetoPersistente {

	public static final String OID_BIEN_ALTA = "oid_bien_alta";

	public static final String OID_SIST_VAL = "oid_sist_val";

	public static final String AMORT_ACUM = "amort_acum";

	public static final int SELECT_BY_SUBBIEN_SISTEMAVALUACION_HASTA_PERI_ANT = 100;
    public static final int SELECT_BY_SUBBIEN_SV_HASTA_PERI_ANT_AJ_AMORT_EJ_ANT = 101;

	public DBAmortizacionAcumulada() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			break;
		}
		case SELECT_BY_SUBBIEN_SISTEMAVALUACION_HASTA_PERI_ANT: {
			ps = this.selectBySubBienSistemaValuacionHastaPeriAnt(aCondiciones);
			break;
		}
		case SELECT_BY_SUBBIEN_SV_HASTA_PERI_ANT_AJ_AMORT_EJ_ANT: {
			ps = this.selectBySubBienSistemaValuacionHastaPeriAntAjAmortEjerAnt(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	
	private PreparedStatement selectBySubBienSistemaValuacionHastaPeriAntAjAmortEjerAnt(
			Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		SubBien subBien = (SubBien) condiciones.get(SubBien.NICKNAME);
		SistemaValuacion sistemaValuacion = (SistemaValuacion) condiciones
				.get(SistemaValuacion.NICKNAME);
		Periodo periodo = (Periodo) condiciones.get(Periodo.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val, ");
		textSQL.append("   sum(b.importe) amort_acum ");
		textSQL.append(" from ");
		textSQL.append("   buComproCab a, ");
		textSQL.append("   buComproDet b, ");
		textSQL.append("   geComproCab c,  ");
		textSQL.append("   gePeriodos d ");
		textSQL.append(" where ");
		textSQL.append("   a.oid_cco_bu = b.oid_cco_bu and ");
		textSQL.append("   a.oid_cco_bu = c.oid_cco and ");
		textSQL.append("   c.activo = 1 and ");
		textSQL.append("   a.oid_bien_alta = ? and ");
		textSQL.append("   a.oid_sist_val = ? and ");
		textSQL.append("   tipo_mov ='AJ_EA' and ");
		textSQL.append("   d.oid_peri = a.oid_peri and c.fecha_desde<?");
		textSQL.append("   group by ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, subBien.getOID());
		querySelect.setInt(2, sistemaValuacion.getOID());
		querySelect.setDate(3, new Date(periodo.getFechadesde().getTime()));
		return querySelect;

	}	
	
	private PreparedStatement selectBySubBienSistemaValuacionHastaPeriAnt(
			Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		SubBien subBien = (SubBien) condiciones.get(SubBien.NICKNAME);
		SistemaValuacion sistemaValuacion = (SistemaValuacion) condiciones
				.get(SistemaValuacion.NICKNAME);
		Periodo periodo = (Periodo) condiciones.get(Periodo.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val, ");
		textSQL.append("   sum(b.importe) amort_acum ");
		textSQL.append(" from ");
		textSQL.append("   buComproCab a, ");
		textSQL.append("   buComproDet b, ");
		textSQL.append("   geComproCab c,  ");
		textSQL.append("   gePeriodos d ");
		textSQL.append(" where ");
		textSQL.append("   a.oid_cco_bu = b.oid_cco_bu and ");
		textSQL.append("   a.oid_cco_bu = c.oid_cco and ");
		textSQL.append("   c.activo = 1 and ");
		textSQL.append("   a.oid_bien_alta = ? and ");
		textSQL.append("   a.oid_sist_val = ? and ");
		textSQL.append("   tipo_mov in ('AM_VO','RAM_VO','AJ_MA','AJ_EA') and ");
		textSQL.append("   d.oid_peri = a.oid_peri and c.fecha_desde<?");
		textSQL.append("   group by ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, subBien.getOID());
		querySelect.setInt(2, sistemaValuacion.getOID());
		querySelect.setDate(3, new Date(periodo.getFechadesde().getTime()));
		return querySelect;

	}

	public static AmortizacionAcumulada getAmortizacionAcumuladaHastaPeriAnt(SubBien subBien,
			SistemaValuacion sistemaValuacion,Periodo periodo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(SubBien.NICKNAME,subBien);
		condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
		condiciones.put(Periodo.NICKNAME,periodo);
		return (AmortizacionAcumulada) ObjetoLogico.getObjects(AmortizacionAcumulada.NICKNAME,
				DBAmortizacionAcumulada.SELECT_BY_SUBBIEN_SISTEMAVALUACION_HASTA_PERI_ANT, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static AmortizacionAcumulada getAmortizacionAcumuladaHastaPeriAntAjAmortEjerAnt(SubBien subBien,
			SistemaValuacion sistemaValuacion,Periodo periodo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(SubBien.NICKNAME,subBien);
		condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
		condiciones.put(Periodo.NICKNAME,periodo.getPrimerPeriodoEjercicio());
		return (AmortizacionAcumulada) ObjetoLogico.getObjects(AmortizacionAcumulada.NICKNAME,
				DBAmortizacionAcumulada.SELECT_BY_SUBBIEN_SISTEMAVALUACION_HASTA_PERI_ANT, condiciones,
				new ObjetoObservado(), aSesion);
	}	
	
}
