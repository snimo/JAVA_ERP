package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoDeAtributos extends DBObjetoPersistente {

	public static final String	OID_GRUPOS_ATRI								= "oid_grupos_atri";

	public static final String	CODIGO												= "codigo";

	public static final String	DESCRIPCION										= "nombre";

	public static final String	ACTIVO												= "activo";

	public static final int			SELECT_HELP_BY_GRUPO_ATRI_VAR	= 100;

	public static final int			SELECT_BY_GRUPO_ATRI_VAR_COD	= 101;

	public DBGrupoDeAtributos() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPOS_ATRI = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		GrupoDeAtributos pers = (GrupoDeAtributos) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geGrupoDeAtri " + " ( " + "OID_GRUPOS_ATRI," + "CODIGO," + "NOMBRE," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPOS_ATRI, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_GRUPOS_ATRI = 4;

		GrupoDeAtributos pers = (GrupoDeAtributos) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geGrupoDeAtri set " + "codigo=?" + ",nombre=?" + ",activo=?" + " where "
				+ " oid_grupos_atri=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPOS_ATRI, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPOS_ATRI = 1;
		GrupoDeAtributos pers = (GrupoDeAtributos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoDeAtri " + " set activo=0 " + " where " + " oid_grupos_atri=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPOS_ATRI, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPOS_ATRI = 1;
		GrupoDeAtributos pers = (GrupoDeAtributos) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoDeAtri " + " set activo=1 " + " where " + " oid_grupos_atri=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPOS_ATRI, pers.getOID());
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
		case SELECT_HELP_BY_GRUPO_ATRI_VAR: {
			ps = this.selectHelGrupopAtriVar(aCondiciones);
			break;
		}
		case SELECT_BY_GRUPO_ATRI_VAR_COD: {
			ps = this.selectByGrupoAtriVarCod(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByGrupoAtriVarCod(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoDeAtri ");
		textSQL.append(" WHERE codigo = ? and oid_grupos_atri in (select oid_grupos_atri from geGruposHabEnt where oid_grupo_atri_var=?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		querySelect.setString(1, condiciones.getString("codigo"));
		GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar)
		      condiciones.get(GrupoAtributoEntidadVar.NICKNAME);
		querySelect.setInt(2,grupoAtriEntVar.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPOS_ATRI = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoDeAtri ");
		textSQL.append(" WHERE oid_grupos_atri = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPOS_ATRI, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoDeAtri ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectHelGrupopAtriVar(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		MapDatos mapaDatos = (MapDatos) aCondiciones;
		Integer oidGrupoAtriVar = mapaDatos.getInteger("oid_grupo_atri_var");

		textSQL.append("SELECT oid_grupos_atri oid,codigo codigo,  nombre descripcion ,activo ");
		textSQL
				.append(" from geGrupoDeAtri where activo=1 and oid_grupos_atri in (select oid_grupos_atri from geGruposHabEnt where oid_grupo_atri_var=?)");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, oidGrupoAtriVar.intValue());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupos_atri oid,codigo codigo,  nombre descripcion ,activo ");
		textSQL.append(" from geGrupoDeAtri");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
  public static GrupoDeAtributos getGrupoDeAtributos(String codigo, GrupoAtributoEntidadVar grupoAtriEntVar,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("codigo", codigo);
		condiciones.put(GrupoAtributoEntidadVar.NICKNAME, grupoAtriEntVar);
		return (GrupoDeAtributos) ObjetoLogico.getObjects(GrupoDeAtributos.NICKNAME,
				DBGrupoDeAtributos.SELECT_BY_GRUPO_ATRI_VAR_COD, condiciones, new ObjetoObservado(), aSesion);
	}
	

}
