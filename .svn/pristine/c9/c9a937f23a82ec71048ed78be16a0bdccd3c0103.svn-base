package com.srn.erp.mensajero.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.mensajero.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGrupoMaquinaDet extends DBObjetoPersistente {

	public static final String OID_GRUPO_MAQ_DET = "oid_grupo_maq_det";
	public static final String OID_GRUPO_MAQ = "oid_grupo_maq";
	public static final String OID_MAQUINA = "oid_maquina";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_GRUPO_MAQ = 100;

	public DBGrupoMaquinaDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_MAQ_DET = 1;
		final int OID_GRUPO_MAQ = 2;
		final int OID_MAQUINA = 3;
		final int ACTIVO = 4;

		GrupoMaquinaDet pers = (GrupoMaquinaDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geGrupoMaqDet " + " ( " + "OID_GRUPO_MAQ_DET," + "OID_GRUPO_MAQ," + "OID_MAQUINA," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_MAQ_DET, pers.getOID());
		qInsert.setInt(OID_GRUPO_MAQ, pers.getGrupo_maquina().getOID());
		qInsert.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_MAQ = 1;
		final int OID_MAQUINA = 2;
		final int ACTIVO = 3;
		final int OID_GRUPO_MAQ_DET = 4;

		GrupoMaquinaDet pers = (GrupoMaquinaDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geGrupoMaqDet set " + "oid_grupo_maq=?" + ",oid_maquina=?" + ",activo=?" + " where "
				+ " oid_grupo_maq_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_MAQ_DET, pers.getOID());
		qUpdate.setInt(OID_GRUPO_MAQ, pers.getGrupo_maquina().getOID());
		qUpdate.setInt(OID_MAQUINA, pers.getMaquina().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_MAQ_DET = 1;
		GrupoMaquinaDet pers = (GrupoMaquinaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoMaqDet " + " set activo=0 " + " where " + " oid_grupo_maq_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_MAQ_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_MAQ_DET = 1;
		GrupoMaquinaDet pers = (GrupoMaquinaDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geGrupoMaqDet " + " set activo=1 " + " where " + " oid_grupo_maq_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_MAQ_DET, pers.getOID());
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
		case SELECT_BY_GRUPO_MAQ: {
			ps = this.selectByGrupoMaquina(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_MAQ_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoMaqDet ");
		textSQL.append(" WHERE oid_grupo_maq_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_MAQ_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByGrupoMaquina(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoMaqDet ");
		textSQL.append(" WHERE oid_grupo_maq = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		GrupoMaquina grupoMaquina = (GrupoMaquina) aCondiciones;
		querySelect.setInt(1, grupoMaquina.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geGrupoMaqDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_maq_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geGrupoMaqDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getMaquinasDetalle(GrupoMaquina grupoMaquina, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoMaquinaDet.NICKNAME, DBGrupoMaquinaDet.SELECT_BY_GRUPO_MAQ, grupoMaquina,
				new ListObserver(), aSesion);
	}

}
