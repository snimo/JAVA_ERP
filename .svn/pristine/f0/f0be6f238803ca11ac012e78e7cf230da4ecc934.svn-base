package com.srn.erp.ctasAPagar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.SaldoCtaCteProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBSaldoCtaCteProv extends DBObjetoPersistente {

	public static final String OID_PROVEEDOR = "oid_proveedor";

	public static final String SALDO = "saldo";

	public static final String OID_MONEDA = "oid_moneda";

	public static final int SELECT_BY_PROVEEDOR_FEC_HASTA_TRAN_PROV = 100;

	public static final int SELECT_BY_PROVEEDOR_FEC_HASTA_APLIC = 101;

	public DBSaldoCtaCteProv() {
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
		case SELECT_BY_PROVEEDOR_FEC_HASTA_TRAN_PROV: {
			ps = this.selectByProvFecHastaTranProv(aCondiciones);
			break;
		}
		case SELECT_BY_PROVEEDOR_FEC_HASTA_APLIC: {
			ps = this.selectByProvFecHastaAplic(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpTranProv ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpTranProv ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpTranProv");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByProvFecHastaTranProv(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select a.oid_proveedor,a.oid_moneda,sum(a.importe) saldo ");
		textSQL
				.append(" from cpTranProv a , geComproCab b where b.activo=1 and a.oid_cco = b.oid_cco and a.oid_proveedor = ? and a.imputac<? ");
		textSQL.append(" group by a.oid_proveedor,a.oid_moneda ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, proveedor.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByProvFecHastaAplic(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select oid_proveedor,oid_moneda,sum(importe) saldo ");
		textSQL
				.append(" from cpAplProv where oid_proveedor = ? and imputac<? ");
		textSQL.append(" group by oid_proveedor,oid_moneda ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, proveedor.getOID());
		querySelect.setDate(2, new Date(fecha.getTime()));
		return querySelect;
	}

	public static List getSaldosInicialesTranProv(Proveedor proveedor,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(SaldoCtaCteProv.NICKNAME,
				DBSaldoCtaCteProv.SELECT_BY_PROVEEDOR_FEC_HASTA_TRAN_PROV,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getSaldosInicialesAplicProv(Proveedor proveedor,
			java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(SaldoCtaCteProv.NICKNAME,
				DBSaldoCtaCteProv.SELECT_BY_PROVEEDOR_FEC_HASTA_APLIC,
				condiciones, new ListObserver(), aSesion);
	}	

}
