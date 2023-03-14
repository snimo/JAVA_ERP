package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.MotivoPago;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBMotivoPago extends DBObjetoPersistente {

	public static final String	OID_MOTIVO_PAGO											= "oid_motivo_pago";

	public static final String	CODIGO															= "codigo";

	public static final String	DESCRIPCION													= "descripcion";

	public static final String	COMPO																= "compo";

	public static final String	ACTIVO															= "activo";

	public static final int			SELECT_BY_HELP_MOTIVOS_PAGOS_VARIOS	= 100;
	public static final int			SELECT_BY_HELP_MOTIVOS_PAGOS_PROV	= 101;

	public DBMotivoPago() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOTIVO_PAGO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int COMPO = 4;
		final int ACTIVO = 5;

		MotivoPago pers = (MotivoPago) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into opMotivosPago " + " ( " + "OID_MOTIVO_PAGO," + "CODIGO," + "DESCRIPCION," + "COMPO,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOTIVO_PAGO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(COMPO, pers.getCompo());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int COMPO = 3;
		final int ACTIVO = 4;
		final int OID_MOTIVO_PAGO = 5;

		MotivoPago pers = (MotivoPago) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update opMotivosPago set " + "codigo=?" + ",descripcion=?" + ",compo=?" + ",activo=?"
				+ " where " + " oid_motivo_pago=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO_PAGO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(COMPO, pers.getCompo());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO_PAGO = 1;
		MotivoPago pers = (MotivoPago) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opMotivosPago " + " set activo=0 " + " where " + " oid_motivo_pago=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO_PAGO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOTIVO_PAGO = 1;
		MotivoPago pers = (MotivoPago) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opMotivosPago " + " set activo=1 " + " where " + " oid_motivo_pago=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOTIVO_PAGO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
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
		case SELECT_BY_HELP_MOTIVOS_PAGOS_VARIOS: {
			ps = this.selectByMotivosVarios(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_MOTIVOS_PAGOS_PROV: {
			ps = this.selectByMotivosPagosProv(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOTIVO_PAGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opMotivosPago ");
		textSQL.append(" WHERE oid_motivo_pago = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOTIVO_PAGO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opMotivosPago ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByMotivosVarios(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo_pago oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from opMotivosPago where compo = 'VARIOS' and activo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByMotivosPagosProv(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo_pago oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from opMotivosPago where compo = 'PROV' and activo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_motivo_pago oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from opMotivosPago");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
