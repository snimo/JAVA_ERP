package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBUbicacionDeposito extends DBObjetoPersistente {

	public static final String OID_UBI_DEPO = "oid_ubi_depo";

	public static final String CODIGO = "codigo";

	public static final String OID = "oid";

	public static final String DESCRIPCION = "descripcion";

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String OID_PADRE = "oid_padre";

	public static final String SOLO_SKU_HABI = "solo_sku_habi";

	public static final String OID_SUJETO = "oid_sujeto";

	public static final String OID_TRANSPORTE = "oid_transporte";

	public static final String OID_DEPO_DEST = "oid_depo_dest";

	public static final String ALLOW_ALMACENAR = "allow_almacenar";

	public static final String TIPO = "tipo";

	public static final String ACTIVO = "activo";

	public static final String SECU = "secu";
	
	public static final String UBI_DEFAULT = "ubi_default";

	public static final int SELECT_BY_DEPOSITO = 100;

	public static final int SELECT_BY_DEPO_CODUBI = 101;
	
	

	public DBUbicacionDeposito() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_UBI_DEPO = 1;
		final int CODIGO = 2;
		final int OID = 3;
		final int DESCRIPCION = 4;
		final int OID_DEPOSITO = 5;
		final int OID_PADRE = 6;
		final int SOLO_SKU_HABI = 7;
		final int OID_SUJETO = 8;
		final int OID_TRANSPORTE = 9;
		final int OID_DEPO_DEST = 10;
		final int ALLOW_ALMACENAR = 11;
		final int TIPO = 12;
		final int ACTIVO = 13;
		final int SECU = 14;
		final int UBI_DEFAULT = 15;

		UbicacionDeposito pers = (UbicacionDeposito) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skUbiDeposito " + " ( "
				+ "OID_UBI_DEPO," + "CODIGO," + "OID," + "DESCRIPCION,"
				+ "OID_DEPOSITO," + "OID_PADRE," + "SOLO_SKU_HABI,"
				+ "OID_SUJETO," + "OID_TRANSPORTE," + "OID_DEPO_DEST,"
				+ "ALLOW_ALMACENAR," + "TIPO," + "ACTIVO," + "SECU , UBI_DEFAULT)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"+ "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_UBI_DEPO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setInt(OID, pers.getOid().intValue());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qInsert.setInt(OID_PADRE, pers.getOid_padre().intValue());
		qInsert
				.setBoolean(SOLO_SKU_HABI, pers.isSolo_sku_habi()
						.booleanValue());
		if (pers.getSujeto() != null)
			qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qInsert.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		if (pers.getTransporte() != null)
			qInsert.setInt(OID_TRANSPORTE, pers.getTransporte().getOID());
		else
			qInsert.setNull(OID_TRANSPORTE, java.sql.Types.INTEGER);
		if (pers.getDeposito_destino() != null)
			qInsert.setInt(OID_DEPO_DEST, pers.getDeposito_destino().getOID());
		else
			qInsert.setNull(OID_DEPO_DEST, java.sql.Types.INTEGER);
		qInsert.setBoolean(ALLOW_ALMACENAR, pers.isAllow_almacenar()
				.booleanValue());
		qInsert.setString(TIPO, pers.getTipo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(SECU, pers.getSecu().intValue());
		qInsert.setBoolean(UBI_DEFAULT, pers.isUbicacionPorDefecto());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int OID = 2;
		final int DESCRIPCION = 3;
		final int OID_DEPOSITO = 4;
		final int OID_PADRE = 5;
		final int SOLO_SKU_HABI = 6;
		final int OID_SUJETO = 7;
		final int OID_TRANSPORTE = 8;
		final int OID_DEPO_DEST = 9;
		final int ALLOW_ALMACENAR = 10;
		final int TIPO = 11;
		final int ACTIVO = 12;
		final int SECU = 13;
		final int UBI_DEFAULT = 14;
		final int OID_UBI_DEPO = 15;

		UbicacionDeposito pers = (UbicacionDeposito) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skUbiDeposito set " + "codigo=?" + ",oid=?"
				+ ",descripcion=?" + ",oid_deposito=?" + ",oid_padre=?"
				+ ",solo_sku_habi=?" + ",oid_sujeto=?" + ",oid_transporte=?"
				+ ",oid_depo_dest=?" + ",allow_almacenar=?" + ",tipo=?"
				+ ",activo=?" + ",secu=? , ubi_default = ? " + " where " + " oid_ubi_depo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UBI_DEPO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setInt(OID, pers.getOid().intValue());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(OID_DEPOSITO, pers.getDeposito().getOID());
		qUpdate.setInt(OID_PADRE, pers.getOid_padre().intValue());
		qUpdate
				.setBoolean(SOLO_SKU_HABI, pers.isSolo_sku_habi()
						.booleanValue());
		if (pers.getSujeto() != null)
			qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qUpdate.setNull(OID_SUJETO, java.sql.Types.INTEGER);
		if (pers.getTransporte() != null)
			qUpdate.setInt(OID_TRANSPORTE, pers.getTransporte().getOID());
		else
			qUpdate.setNull(OID_TRANSPORTE, java.sql.Types.INTEGER);
		if (pers.getDeposito_destino() != null)
			qUpdate.setInt(OID_DEPO_DEST, pers.getDeposito_destino().getOID());
		else
			qUpdate.setNull(OID_DEPO_DEST, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ALLOW_ALMACENAR, pers.isAllow_almacenar()
				.booleanValue());
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(UBI_DEFAULT, pers.isUbicacionPorDefecto());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_UBI_DEPO = 1;
		UbicacionDeposito pers = (UbicacionDeposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skUbiDeposito " + " set activo=0 " + " where "
				+ " oid_ubi_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UBI_DEPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_UBI_DEPO = 1;
		UbicacionDeposito pers = (UbicacionDeposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skUbiDeposito " + " set activo=1 " + " where "
				+ " oid_ubi_depo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_UBI_DEPO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
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
		case SELECT_BY_DEPOSITO: {
			ps = this.selectByDeposito(aCondiciones);
			break;
		}
		case SELECT_BY_DEPO_CODUBI: {
			ps = this.selectByDepositoCodUbi(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_UBI_DEPO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skUbiDeposito ");
		textSQL.append(" WHERE oid_ubi_depo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_UBI_DEPO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skUbiDeposito ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_ubi_depo oid,codigo codigo,  descripcion ,activo ");
		textSQL.append(" from skUbiDeposito");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByDeposito(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skUbiDeposito ");
		textSQL.append(" WHERE oid_deposito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Deposito deposito = (Deposito) aCondiciones;
		querySelect.setInt(1, deposito.getOID());
		return querySelect;
	}

	private PreparedStatement selectByDepositoCodUbi(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skUbiDeposito ");
		textSQL.append(" WHERE oid_deposito = ? and codigo = ?  ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
		String codigo = (String) condiciones.get("codigo");
		querySelect.setInt(1, deposito.getOID());
		querySelect.setString(2, codigo);
		return querySelect;
	}

	public static List getUbicacionesDeposito(Deposito deposito, ISesion aSesion)
			throws BaseException {

		return (List) ObjetoLogico.getObjects(UbicacionDeposito.NICKNAME,
				DBUbicacionDeposito.SELECT_BY_DEPOSITO, deposito,
				new ListObserver(), aSesion);
	}

	public static UbicacionDeposito getUbicacionDeposito(Deposito deposito,String codigo,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Deposito.NICKNAME,deposito);
		condiciones.put("codigo",codigo);
		return (UbicacionDeposito) ObjetoLogico.getObjects(UbicacionDeposito.NICKNAME,
				DBUbicacionDeposito.SELECT_BY_DEPO_CODUBI, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
