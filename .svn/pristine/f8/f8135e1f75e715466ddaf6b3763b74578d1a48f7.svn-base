package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBEsquemaHabilitacionProducto extends DBObjetoPersistente {

	public static final String	OID_ESQ_HAB_PROD	= "oid_esq_hab_prod";

	public static final String	CODIGO						= "codigo";

	public static final String	DESCRIPCION				= "descripcion";

	public static final String	AMBITO_ESQUEMA		= "ambito_esquema";

	public static final String	ACTIVO						= "activo";

	public static final String	OID_CLASIF_ENT		= "oid_clasif_ent";
	
	public static final int SELECT_BY_HELP_ESQ_HAB_PROD_REQ = 100;

	public DBEsquemaHabilitacionProducto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_HAB_PROD = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int AMBITO_ESQUEMA = 4;
		final int ACTIVO = 5;
		final int OID_CLASIF_ENT = 6;

		EsquemaHabilitacionProducto pers = (EsquemaHabilitacionProducto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpEsqHabProd " + " ( " + "OID_ESQ_HAB_PROD," + "CODIGO," + "DESCRIPCION,"
				+ "AMBITO_ESQUEMA," + "ACTIVO," + "OID_CLASIF_ENT)" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_HAB_PROD, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(AMBITO_ESQUEMA, pers.getAmbito_esquema());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_CLASIF_ENT, pers.getClasificador().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int AMBITO_ESQUEMA = 3;
		final int ACTIVO = 4;
		final int OID_CLASIF_ENT = 5;
		final int OID_ESQ_HAB_PROD = 6;

		EsquemaHabilitacionProducto pers = (EsquemaHabilitacionProducto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpEsqHabProd set " + "codigo=?" + ",descripcion=?" + ",ambito_esquema=?" + ",activo=?"
				+ ",oid_clasif_ent=?" + " where " + " oid_esq_hab_prod=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_PROD, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(AMBITO_ESQUEMA, pers.getAmbito_esquema());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getClasificador().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_HAB_PROD = 1;
		EsquemaHabilitacionProducto pers = (EsquemaHabilitacionProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqHabProd set activo = 0 " + " where " + " oid_esq_hab_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_PROD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_HAB_PROD = 1;
		EsquemaHabilitacionProducto pers = (EsquemaHabilitacionProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqHabProd " + " set activo=1 " + " where " + " oid_esq_hab_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_PROD, pers.getOID());
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
		case SELECT_BY_HELP_ESQ_HAB_PROD_REQ: {
			ps = this.selectByHelpEsqHabProdReq(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESQ_HAB_PROD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProd ");
		textSQL.append(" WHERE oid_esq_hab_prod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_HAB_PROD, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByHelpEsqHabProdReq(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_esq_hab_prod oid,codigo,descripcion,activo FROM  cpEsqHabProd ");
		textSQL.append(" WHERE ambito_esquema='PROD_REQUI' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProd ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_esq_hab_prod oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cpEsqHabProd");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
