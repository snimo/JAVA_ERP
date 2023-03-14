package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.MotivoTipoNov;
import com.srn.erp.rrhh.bm.TipoNovedad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotivoTipoNov extends DBObjetoPersistente {

	public static final String OID_MOT_TIPO_NOV = "oid_mot_tipo_nov";
	public static final String OID_TIPO_NOV = "oid_tipo_nov";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_TIPO_NOV = 100;
	public static final int SELECT_BY_TIPOMOV_CODIGO = 101;

	public DBMotivoTipoNov() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MOT_TIPO_NOV = 1;
		final int OID_TIPO_NOV = 2;
		final int CODIGO = 3;
		final int DESCRIPCION = 4;
		final int ACTIVO = 5;

		MotivoTipoNov pers = (MotivoTipoNov) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legMotTipoNov " + " ( " + "OID_MOT_TIPO_NOV," + "OID_TIPO_NOV," + "CODIGO," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MOT_TIPO_NOV, pers.getOID());
		qInsert.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_NOV = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int OID_MOT_TIPO_NOV = 5;

		MotivoTipoNov pers = (MotivoTipoNov) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legMotTipoNov set " + "oid_tipo_nov=?" + ",codigo=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_mot_tipo_nov=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_TIPO_NOV, pers.getOID());
		qUpdate.setInt(OID_TIPO_NOV, pers.getTipo_novedad().getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOT_TIPO_NOV = 1;
		MotivoTipoNov pers = (MotivoTipoNov) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legMotTipoNov " + " set activo=0 " + " where " + " oid_mot_tipo_nov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_TIPO_NOV, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MOT_TIPO_NOV = 1;
		MotivoTipoNov pers = (MotivoTipoNov) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legMotTipoNov " + " set activo=1 " + " where " + " oid_mot_tipo_nov=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MOT_TIPO_NOV, pers.getOID());
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
		case SELECT_BY_TIPO_NOV: {
			ps = this.selectByTipoNovedad(aCondiciones);
			break;
		}
		case SELECT_BY_TIPOMOV_CODIGO: {
			ps = this.selectByTipoNovedadCodigo(aCondiciones);
			break;
		}
		case SELECT_ALL: {
			ps = this.selectByAll(aCondiciones);
			break;
		}
		case SELECT_ALL_ACTIVOS: {
			ps = this.selectByAllActivos(aCondiciones);
			break;
		}
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_MOT_TIPO_NOV = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov ");
		textSQL.append(" WHERE oid_mot_tipo_nov = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MOT_TIPO_NOV, oid);
		return querySelect;
	}

	private PreparedStatement selectByAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov where activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByTipoNovedad(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov ");
		textSQL.append(" WHERE oid_tipo_nov = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		TipoNovedad tipoNovedad = (TipoNovedad) aCondiciones;
		querySelect.setInt(1, tipoNovedad.getOID());
		return querySelect;
	}

	private PreparedStatement selectByTipoNovedadCodigo(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TipoNovedad tipoNovedad = (TipoNovedad) condiciones.get(TipoNovedad.NICKNAME);
		String codigo = (String) condiciones.get("CODIGO");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov ");
		textSQL.append(" WHERE oid_tipo_nov = ? and codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tipoNovedad.getOID());
		querySelect.setString(2, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legMotTipoNov ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_mot_tipo_nov oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from legMotTipoNov");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMotivosTipoMov(TipoNovedad aTipoNovedad, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivoTipoNov.NICKNAME, DBMotivoTipoNov.SELECT_BY_TIPO_NOV, aTipoNovedad, new ListObserver(), aSesion);
	}

	public static MotivoTipoNov getMotivoTipoNov(TipoNovedad tipoNovedad, String codigo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TipoNovedad.NICKNAME, tipoNovedad);
		condiciones.put("CODIGO", codigo);
		return (MotivoTipoNov) ObjetoLogico.getObjects(MotivoTipoNov.NICKNAME, DBMotivoTipoNov.SELECT_BY_TIPOMOV_CODIGO, condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivoTipoNov.NICKNAME, DBMotivoTipoNov.SELECT_ALL, null, new ListObserver(), aSesion);
	}
	
	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(MotivoTipoNov.NICKNAME, DBMotivoTipoNov.SELECT_ALL_ACTIVOS, null, new ListObserver(), aSesion);
	}
	

}
