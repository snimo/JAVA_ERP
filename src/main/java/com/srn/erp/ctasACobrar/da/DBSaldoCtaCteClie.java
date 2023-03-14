package com.srn.erp.ctasACobrar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasACobrar.bm.SaldoCtaCteClie;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBSaldoCtaCteClie extends DBObjetoPersistente {

	public static final String OID_SUJETO = "oid_sujeto";

	public static final String SALDO = "saldo";

	public static final String OID_MONEDA = "oid_moneda";

	public static final int SELECT_BY_SUJETO_FEC_HASTA_TRAN_CLIE = 100;

	public static final int SELECT_BY_SUJETO_FEC_HASTA_APLIC = 101;

	public DBSaldoCtaCteClie() {
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
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_SUJETO_FEC_HASTA_TRAN_CLIE: {
			ps = this.selectByClieFecHastaTranClie(aCondiciones);
			break;
		}
		case SELECT_BY_SUJETO_FEC_HASTA_APLIC: {
			ps = this.selectByClieFecHastaAplic(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {
		return null;
	}

	private PreparedStatement selectByClieFecHastaTranClie(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select oid_sujeto,oid_moneda,sum(importe) saldo ");
		textSQL
				.append(" from veTranClie where oid_sujeto = ? and imputac<? ");
		textSQL.append(" group by oid_sujeto,oid_moneda ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, sujeto.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByClieFecHastaAplic(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select oid_sujeto,oid_moneda,sum(importe) saldo ");
		textSQL
				.append(" from veAplClie where oid_sujeto = ? and imputac<? ");
		textSQL.append(" group by oid_sujeto,oid_moneda ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, sujeto.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}

	public static List getSaldosInicialesTranClie(Sujeto sujeto,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Sujeto.NICKNAME, sujeto);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(SaldoCtaCteClie.NICKNAME,
				DBSaldoCtaCteClie.SELECT_BY_SUJETO_FEC_HASTA_TRAN_CLIE,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getSaldosInicialesAplicClie(Sujeto sujeto,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Sujeto.NICKNAME, sujeto);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(SaldoCtaCteClie.NICKNAME,
				DBSaldoCtaCteClie.SELECT_BY_SUJETO_FEC_HASTA_APLIC,
				condiciones, new ListObserver(), aSesion);
	}	

}
