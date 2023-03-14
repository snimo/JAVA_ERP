package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.RevaluoValorOrigenSubBien;
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

public class DBRevaluoValorOrigenSubBien extends DBObjetoPersistente {

	public static final String OID_BIEN_ALTA = "oid_bien_alta";

	public static final String OID_SIST_VAL = "oid_sist_val";

	public static final String REVALUO_VALOR_ORIGEN = "revaluo_valor_origen";

	public static final int SELECT_BY_SUBBIEN_SISTEMAVALUACION_NOT_PERIODO = 100;

	public DBRevaluoValorOrigenSubBien() {
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
		case SELECT_BY_SUBBIEN_SISTEMAVALUACION_NOT_PERIODO: {
			ps = this.selectBySubBienSistemaValuacionNotInPeriodo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectBySubBienSistemaValuacionNotInPeriodo(
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
		textSQL.append("   sum(b.importe) revaluo_valor_origen ");
		textSQL.append(" from ");
		textSQL.append("   buComproCab a, ");
		textSQL.append("   buComproDet b, ");
		textSQL.append("   geComproCab c  ");
		textSQL.append(" where ");
		textSQL.append("   a.oid_cco_bu = b.oid_cco_bu and ");
		textSQL.append("   a.oid_cco_bu = c.oid_cco and ");
		textSQL.append("   c.activo = 1 and ");
		textSQL.append("   a.oid_bien_alta = ? and ");
		textSQL.append("   a.oid_sist_val = ? and ");
		textSQL.append("   a.oid_peri <> ? and ");
		textSQL.append("   tipo_mov = 'RVO' ");
		textSQL.append("   group by ");
		textSQL.append("   a.oid_bien_alta, ");
		textSQL.append("   a.oid_sist_val ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setInt(1, subBien.getOID());
		querySelect.setInt(2, sistemaValuacion.getOID());
		querySelect.setInt(3, periodo.getOID());	
		return querySelect;

	}

	public static RevaluoValorOrigenSubBien getRevaluoValorOrigenSubBien(SubBien subBien,
			SistemaValuacion sistemaValuacion,
			Periodo periodoAExcluir,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(SubBien.NICKNAME,subBien);
		condiciones.put(SistemaValuacion.NICKNAME,sistemaValuacion);
		condiciones.put(Periodo.NICKNAME,periodoAExcluir);
		return (RevaluoValorOrigenSubBien) ObjetoLogico.getObjects(RevaluoValorOrigenSubBien.NICKNAME,
				DBRevaluoValorOrigenSubBien.SELECT_BY_SUBBIEN_SISTEMAVALUACION_NOT_PERIODO, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
