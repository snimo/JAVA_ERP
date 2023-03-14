package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDeposito extends DBObjetoPersistente {

	public static final String OID_DEPOSITO = "oid_deposito";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String ACTIVO = "activo";

	public static final String COMPO_DEPO = "compo_depo";
	
	public static final String CALLE_Y_NRO = "calle_y_nro";
	
	public static final String LOCALIDAD = "localidad";
	
	public static final String CODIGO_POSTAL = "codigo_postal";
	
	public static final String OID_PROVINCIA = "oid_provincia";
	
	public static final String OID_PAIS = "oid_pais";

	public DBDeposito() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DEPOSITO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int COMPO_DEPO = 5;
		final int CALLE_Y_NRO = 6;
		final int LOCALIDAD = 7;
		final int CODIGO_POSTAL = 8;
		final int OID_PROVINCIA = 9;
		final int OID_PAIS = 10;

		Deposito pers = (Deposito) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into skDeposito " + " ( " + "OID_DEPOSITO,"
				+ "CODIGO," + "DESCRIPCION," + "ACTIVO," + "COMPO_DEPO , CALLE_Y_NRO,LOCALIDAD,CODIGO_POSTAL,OID_PROVINCIA,OID_PAIS)"
				+ " values " + "(" + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DEPOSITO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(COMPO_DEPO, pers.getCompoDepo());
		if (pers.getCalleyNro()!=null)
			qInsert.setString(CALLE_Y_NRO, pers.getCalleyNro());
		else
			qInsert.setString(CALLE_Y_NRO, "");
		if (pers.getLocalidad()!=null)
			qInsert.setString(LOCALIDAD, pers.getLocalidad());
		else
			qInsert.setString(LOCALIDAD, "");
		if (pers.getCodigoPostal()!=null)
			qInsert.setString(CODIGO_POSTAL,pers.getCodigoPostal());
		else
			qInsert.setString(CODIGO_POSTAL,"");
		if (pers.getProvincia()!=null)
			qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOIDInteger());
		else
			qInsert.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		if (pers.getPais()!=null)
			qInsert.setInt(OID_PAIS, pers.getPais().getOIDInteger());
		else
			qInsert.setNull(OID_PAIS, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int COMPO_DEPO = 4;
		final int CALLE_Y_NRO = 5;
		final int LOCALIDAD = 6;
		final int CODIGO_POSTAL = 7;
		final int OID_PROVINCIA = 8;
		final int OID_PAIS = 9;		
		final int OID_DEPOSITO = 10;

		Deposito pers = (Deposito) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update skDeposito set " + "codigo=?"
				+ ",descripcion=?" + ",activo=?" + ",compo_depo=? , calle_y_nro=? , localidad = ? , codigo_postal = ? , oid_provincia = ? , oid_pais= ? " + " where "
				+ " oid_deposito=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEPOSITO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(COMPO_DEPO, pers.getCompoDepo());
		if (pers.getCalleyNro()!=null)
			qUpdate.setString(CALLE_Y_NRO, pers.getCalleyNro());
		else
			qUpdate.setString(CALLE_Y_NRO, "");
		if (pers.getLocalidad()!=null)
			qUpdate.setString(LOCALIDAD, pers.getLocalidad());
		else
			qUpdate.setString(LOCALIDAD, "");
		if (pers.getCodigoPostal()!=null)
			qUpdate.setString(CODIGO_POSTAL,pers.getCodigoPostal());
		else
			qUpdate.setString(CODIGO_POSTAL,"");
		if (pers.getProvincia()!=null)
			qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOIDInteger());
		else
			qUpdate.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		if (pers.getPais()!=null)
			qUpdate.setInt(OID_PAIS, pers.getPais().getOIDInteger());
		else
			qUpdate.setNull(OID_PAIS, java.sql.Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DEPOSITO = 1;
		Deposito pers = (Deposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skDeposito " + " set activo=0 " + " where "
				+ " oid_deposito=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEPOSITO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DEPOSITO = 1;
		Deposito pers = (Deposito) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update skDeposito " + " set activo=1 " + " where "
				+ " oid_deposito=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DEPOSITO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_DEPOSITO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skDeposito ");
		textSQL.append(" WHERE oid_deposito = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DEPOSITO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skDeposito ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  skDeposito ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_deposito oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from skDeposito");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDepositos(ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(Deposito.NICKNAME,
				DBDeposito.SELECT_ALL,null,
				new ListObserver(), aSesion);
	}

}
