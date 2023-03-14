package com.srn.erp.Ausentismo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralCodigo;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoRRHHGeneralCodigo extends DBObjetoPersistente {

	public static final String OID_GRUPO_GRAL_COD = "oid_grupo_gral_cod";
	public static final String OID_GRUPO_GRAL_DESC = "oid_grupo_gral_desc";
	public static final String TIPO_TABLA = "tipo_tabla";
	public static final String COD_EXT_ELEMENTO = "cod_ext_elemento";
	public static final String ACTIVO = "activo";
	
	private static final int SELECT_BY_GRUPO_GENERAL_DESC = 100;

	public DBGrupoRRHHGeneralCodigo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL_COD = 1;
		final int OID_GRUPO_GRAL_DESC = 2;
		final int TIPO_TABLA = 3;
		final int COD_EXT_ELEMENTO = 4;
		final int ACTIVO = 5;

		GrupoRRHHGeneralCodigo pers = (GrupoRRHHGeneralCodigo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhoGrupoGralCod " + " ( " + "OID_GRUPO_GRAL_COD," + "OID_GRUPO_GRAL_DESC," + "TIPO_TABLA," + "COD_EXT_ELEMENTO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_GRAL_COD, pers.getOID());
		qInsert.setInt(OID_GRUPO_GRAL_DESC, pers.getGrupogeneraldesc().getOID());
		qInsert.setString(TIPO_TABLA, pers.getTipotabla());
		qInsert.setString(COD_EXT_ELEMENTO, pers.getCodigoexternoelemento());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL_DESC = 1;
		final int TIPO_TABLA = 2;
		final int COD_EXT_ELEMENTO = 3;
		final int ACTIVO = 4;
		final int OID_GRUPO_GRAL_COD = 5;

		GrupoRRHHGeneralCodigo pers = (GrupoRRHHGeneralCodigo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhoGrupoGralCod set " + "oid_grupo_gral_desc=?" + ",tipo_tabla=?" + ",cod_ext_elemento=?" + ",activo=?" + " where " + " oid_grupo_gral_cod=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_COD, pers.getOID());
		qUpdate.setInt(OID_GRUPO_GRAL_DESC, pers.getGrupogeneraldesc().getOID());
		qUpdate.setString(TIPO_TABLA, pers.getTipotabla());
		qUpdate.setString(COD_EXT_ELEMENTO, pers.getCodigoexternoelemento());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_GRAL_COD = 1;
		GrupoRRHHGeneralCodigo pers = (GrupoRRHHGeneralCodigo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhoGrupoGralCod " + " set activo=0 " + " where " + " oid_grupo_gral_cod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_COD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_GRAL_COD = 1;
		GrupoRRHHGeneralCodigo pers = (GrupoRRHHGeneralCodigo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhoGrupoGralCod " + " set activo=1 " + " where " + " oid_grupo_gral_cod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_COD, pers.getOID());
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
			case DBGrupoRRHHGeneralCodigo.SELECT_BY_GRUPO_GENERAL_DESC: {
				ps = this.selectByOidGruGralDesc(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL_COD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralCod ");
		textSQL.append(" WHERE oid_grupo_gral_cod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_GRAL_COD, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralCod ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByOidGruGralDesc(Object aCondiciones) throws BaseException, SQLException {
		GrupoRRHHGeneralDesc grupoGralDesc = (GrupoRRHHGeneralDesc) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralCod ");
		textSQL.append(" WHERE  oid_grupo_gral_desc = " + grupoGralDesc.getOIDInteger());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_gral_cod oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhoGrupoGralCod");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List<GrupoRRHHGeneralCodigo> getByOidGruGralDesc(ISesion aSesion, GrupoRRHHGeneralDesc grupo) throws BaseException {
		return (List<GrupoRRHHGeneralCodigo>) ObjetoLogico.getObjects(GrupoRRHHGeneralCodigo.NICKNAME, DBGrupoRRHHGeneralCodigo.SELECT_BY_GRUPO_GENERAL_DESC, grupo, new ListObserver(), aSesion);
	}

}