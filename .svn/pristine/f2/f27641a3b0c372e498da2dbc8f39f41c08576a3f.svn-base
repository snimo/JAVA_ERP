package com.srn.erp.tesoreria.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCuentaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoCuentaBanco extends DBObjetoPersistente {

	public static final String	OID															= "oid";

	public static final String	OID_MONEDA											= "oid_moneda";

	public static final String	OID_CTA_BANCARIA								= "oid_cta_bancaria";

	public static final String	SALDO														= "saldo";

	public static final int			SALDO_CONTANLE_INICIAL_A_FECHA	= 100;
	public static final int			SALDO_OPERATIVO_INICIAL_A_FECHA = 101;
	public static final int			SALDO_BY_CUENTA = 102;

	public DBSaldoCuentaBanco() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
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
		case SALDO_CONTANLE_INICIAL_A_FECHA: {
			ps = this.selectSaldoInicialContableAFecha(aCondiciones);
			break;
		}
		case SALDO_OPERATIVO_INICIAL_A_FECHA: {
			ps = this.selectSaldoInicialOperativoAFecha(aCondiciones);
			break;
		}
		case SALDO_BY_CUENTA: {
			ps = this.selectByCuenta(aCondiciones);
			break;
		}
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaSaldoBanco ");
		textSQL.append(" WHERE oid = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaSaldoBanco ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectSaldoInicialContableAFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("  a.oid_cta_bancaria oid, ");
		textSQL.append("  b.oid_moneda, ");
		textSQL.append("  a.oid_cta_bancaria, ");
		textSQL.append("  sum(a.importe*a.signo) saldo ");
		textSQL.append(" from ");
		textSQL.append("  vaMovimBanco a, ");
		textSQL.append("  vaCuentaBancaria b ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cta_bancaria = b.oid_cta_bancaria and ");
		textSQL.append("  a.oid_cta_bancaria = ? and ");
		textSQL.append("  a.fecha_contable<? ");
		textSQL.append(" group by ");
		textSQL.append("  a.oid_cta_bancaria,");
		textSQL.append("  b.oid_moneda,");
		textSQL.append("  a.oid_cta_bancaria ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, cuentaBancaria.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectSaldoInicialOperativoAFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("  a.oid_cta_bancaria oid, ");
		textSQL.append("  b.oid_moneda, ");
		textSQL.append("  a.oid_cta_bancaria, ");
		textSQL.append("  sum(a.importe*a.signo) saldo ");
		textSQL.append(" from ");
		textSQL.append("  vaMovimBanco a, ");
		textSQL.append("  vaCuentaBancaria b ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cta_bancaria = b.oid_cta_bancaria and ");
		textSQL.append("  a.oid_cta_bancaria = ? and a.conciliado = 1 and ");
		textSQL.append("  a.fecha_oper<? ");
		textSQL.append(" group by ");
		textSQL.append("  a.oid_cta_bancaria,");
		textSQL.append("  b.oid_moneda,");
		textSQL.append("  a.oid_cta_bancaria ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, cuentaBancaria.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByCuenta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("  a.oid_cta_bancaria oid, ");
		textSQL.append("  b.oid_moneda, ");
		textSQL.append("  a.oid_cta_bancaria, ");
		textSQL.append("  sum(a.importe*a.signo) saldo ");
		textSQL.append(" from ");
		textSQL.append("  vaMovimBanco a, ");
		textSQL.append("  vaCuentaBancaria b ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cta_bancaria = b.oid_cta_bancaria and ");
		textSQL.append("  a.oid_cta_bancaria = ? ");
		textSQL.append(" group by ");
		textSQL.append("  a.oid_cta_bancaria,");
		textSQL.append("  b.oid_moneda,");
		textSQL.append("  a.oid_cta_bancaria ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
		querySelect.setInt(1, cuentaBancaria.getOID());
		return querySelect;
	}
	
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vaSaldoBanco");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static SaldoCuentaBanco getSaldoInicialContableAFecha(java.util.Date fecha, CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put("FECHA", fecha);
		return (SaldoCuentaBanco) ObjetoLogico.getObjects(SaldoCuentaBanco.NICKNAME,
				DBSaldoCuentaBanco.SALDO_CONTANLE_INICIAL_A_FECHA, condiciones, new ObjetoObservado(), aSesion);
	}

	public static SaldoCuentaBanco getSaldoInicialOperativoAFecha(java.util.Date fecha, CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		condiciones.put("FECHA", fecha);
		return (SaldoCuentaBanco) ObjetoLogico.getObjects(SaldoCuentaBanco.NICKNAME,
				DBSaldoCuentaBanco.SALDO_OPERATIVO_INICIAL_A_FECHA, condiciones, new ObjetoObservado(), aSesion);
	}

	public static SaldoCuentaBanco getSaldo(CuentaBancaria cuentaBancaria,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(CuentaBancaria.NICKNAME, cuentaBancaria);
		return (SaldoCuentaBanco) ObjetoLogico.getObjects(SaldoCuentaBanco.NICKNAME,
				DBSaldoCuentaBanco.SALDO_BY_CUENTA, condiciones, new ObjetoObservado(), aSesion);
	}
	
	
}
