package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.general.bm.TablasDeEntidades;
import com.srn.erp.stock.bm.AtributosProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoAtributoEntidadVar extends DBObjetoPersistente {

	public static final String	OID_GRUPO_ATRI_VAR	= "oid_grupo_atri_var";

	public static final String	NICKNAME						= "nickname";

	public static final String	NOMBRE							= "nombre";

	public static final String	ACTIVO							= "activo";

	public static final int			SELECT_BY_NICKNAME	= 100;

	public DBGrupoAtributoEntidadVar() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_ATRI_VAR = 1;
		final int NICKNAME = 2;
		final int NOMBRE = 3;
		final int ACTIVO = 4;

		GrupoAtributoEntidadVar pers = (GrupoAtributoEntidadVar) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geGrupoAtriEntVar " + " ( " + "OID_GRUPO_ATRI_VAR," + "NICKNAME," + "NOMBRE,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_ATRI_VAR, pers.getOID());
		qInsert.setString(NICKNAME, pers.getNickname());
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
		
		
		// Agregar atributo de grupo de atributos seleccionado
		TablasDeEntidades tablasDeEntidades = new TablasDeEntidades();
		String tablaFisica = tablasDeEntidades.getTablaDeEntidad(AtributosProducto.NICKNAME).getNombreTablaFisica();
		pers.agregarGrupoAtri(tablaFisica);
				
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NICKNAME = 1;
		final int NOMBRE = 2;
		final int ACTIVO = 3;
		final int OID_GRUPO_ATRI_VAR = 4;

		GrupoAtributoEntidadVar pers = (GrupoAtributoEntidadVar) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geGrupoAtriEntVar set " + "nickname=?" + ",nombre=?" + ",activo=?" + " where "
				+ " oid_grupo_atri_var=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_VAR, pers.getOID());
		qUpdate.setString(NICKNAME, pers.getNickname());
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_ATRI_VAR = 1;
		GrupoAtributoEntidadVar pers = (GrupoAtributoEntidadVar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from geGrupoAtriEntVar where " + " oid_grupo_atri_var=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_VAR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_ATRI_VAR = 1;
		GrupoAtributoEntidadVar pers = (GrupoAtributoEntidadVar) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoAtriEntVar " + " set activo=1 " + " where " + " oid_grupo_atri_var=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_VAR, pers.getOID());
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
		case SELECT_BY_NICKNAME: {
			ps = this.selectByNickName(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_ATRI_VAR = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoAtriEntVar ");
		textSQL.append(" WHERE oid_grupo_atri_var = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_ATRI_VAR, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoAtriEntVar ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_atri_var oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geGrupoAtriEntVar");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByNickName(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		String nickName = (String) aCondiciones;
		textSQL.append("SELECT * ");
		textSQL.append(" from geGrupoAtriEntVar where nickname = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, nickName);
		return querySelect;

	}

	public static List getGruposAtriEntVar(String nickname, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoAtributoEntidadVar.NICKNAME,
				DBGrupoAtributoEntidadVar.SELECT_BY_NICKNAME, nickname, new ListObserver(), aSesion);
	}

}
