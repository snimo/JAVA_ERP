package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadFijo;
import com.srn.erp.general.bm.TablasDeEntidades;
import com.srn.erp.stock.bm.AtributosProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoAtributoEntidadFijo extends DBObjetoPersistente {

	public static final String	OID_GRUPO_ATRI_FIJ	= "oid_grupo_atri_fij";

	public static final String	NICKNAME						= "nickname";

	public static final String	NOMBRE							= "nombre";

	public static final String	ORDEN								= "orden";

	public static final String	OID_GRUPOS_ATRI			= "oid_grupos_atri";

	public static final String	ACTIVO							= "activo";

	public static final int			SELECT_BY_NICKNAME	= 100;

	public DBGrupoAtributoEntidadFijo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_ATRI_FIJ = 1;
		final int NICKNAME = 2;
		final int NOMBRE = 3;
		final int ORDEN = 4;
		final int OID_GRUPOS_ATRI = 5;
		final int ACTIVO = 6;

		GrupoAtributoEntidadFijo pers = (GrupoAtributoEntidadFijo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geGrupoAtriEntFij " + " ( " + "OID_GRUPO_ATRI_FIJ," + "NICKNAME," + "NOMBRE,"
				+ "ORDEN," + "OID_GRUPOS_ATRI," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_ATRI_FIJ, pers.getOID());
		qInsert.setString(NICKNAME, pers.getNickname());
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setInt(OID_GRUPOS_ATRI, pers.getGrupo_atributo().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
		
		// Dar de alta los atriutos en la tabla AtributosProducto
		Iterator iterAtributosEnGrupo = pers.getGrupo_atributo().getAtributosEnGrupo().iterator();
		while (iterAtributosEnGrupo.hasNext()) {
			AtributoEnGrupo atriEnGrupo = (AtributoEnGrupo) iterAtributosEnGrupo.next();
			TablasDeEntidades tablasDeEntidades = new TablasDeEntidades();
			String tablaFisica = tablasDeEntidades.getTablaDeEntidad(AtributosProducto.NICKNAME).getNombreTablaFisica();
			atriEnGrupo.getAtributo().agregarAtributoA(tablaFisica);
		}
		
		
		
		
		
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NICKNAME = 1;
		final int NOMBRE = 2;
		final int ORDEN = 3;
		final int OID_GRUPOS_ATRI = 4;
		final int ACTIVO = 5;
		final int OID_GRUPO_ATRI_FIJ = 6;

		GrupoAtributoEntidadFijo pers = (GrupoAtributoEntidadFijo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geGrupoAtriEntFij set " + "nickname=?" + ",nombre=?" + ",orden=?" + ",oid_grupos_atri=?"
				+ ",activo=?" + " where " + " oid_grupo_atri_fij=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_FIJ, pers.getOID());
		qUpdate.setString(NICKNAME, pers.getNickname());
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setInt(OID_GRUPOS_ATRI, pers.getGrupo_atributo().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_ATRI_FIJ = 1;
		GrupoAtributoEntidadFijo pers = (GrupoAtributoEntidadFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from geGrupoAtriEntFij where oid_grupo_atri_fij=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_FIJ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_ATRI_FIJ = 1;
		GrupoAtributoEntidadFijo pers = (GrupoAtributoEntidadFijo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoAtriEntFij " + " set activo=1 " + " where " + " oid_grupo_atri_fij=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_ATRI_FIJ, pers.getOID());
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

		final int OID_GRUPO_ATRI_FIJ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoAtriEntFij ");
		textSQL.append(" WHERE oid_grupo_atri_fij = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_ATRI_FIJ, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoAtriEntFij ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_atri_fij oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geGrupoAtriEntFij");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByNickName(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		String nickName = (String) aCondiciones;
		textSQL.append("SELECT * ");
		textSQL.append(" from geGrupoAtriEntFij where nickname = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, nickName);
		return querySelect;

	}

	public static List getGruposAtriFijosByNickName(String nickname, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoAtributoEntidadFijo.NICKNAME,
				DBGrupoAtributoEntidadFijo.SELECT_BY_NICKNAME, nickname, new ListObserver(), aSesion);
	}

}
