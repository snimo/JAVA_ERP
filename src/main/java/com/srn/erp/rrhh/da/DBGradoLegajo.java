package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.GradoLegajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGradoLegajo extends DBObjetoPersistente {

	public static final String OID_GRADO_LEG = "oid_grado_leg";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	public static final String CANT_JUEGOS_A = "cant_juegos_a";
	public static final String CANT_JUEGOS_B = "cant_juegos_b";

	public DBGradoLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRADO_LEG = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int CANT_JUEGOS_A = 5;
		final int CANT_JUEGOS_B = 6;

		GradoLegajo pers = (GradoLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhGradosLeg " + " ( " + "OID_GRADO_LEG," + "CODIGO," + "DESCRIPCION," + "ACTIVO , CANT_JUEGOS_A , CANT_JUEGOS_B)" + " values " + "(" + "?," + "?,"+ "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRADO_LEG, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCantJuegosA()!=null)
			qInsert.setInt(CANT_JUEGOS_A , pers.getCantJuegosA().intValue());
		else
			qInsert.setNull(CANT_JUEGOS_A , Types.INTEGER);
		if (pers.getCantJuegosB()!=null)
			qInsert.setInt(CANT_JUEGOS_B , pers.getCantJuegosB().intValue());
		else
			qInsert.setNull(CANT_JUEGOS_B , Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int CANT_JUEGOS_A = 4;
		final int CANT_JUEGOS_B = 5;
		final int OID_GRADO_LEG = 6;

		GradoLegajo pers = (GradoLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhGradosLeg set " + "codigo=?" + ",descripcion=?" + ",activo=? , cant_juegos_a = ? , cant_juegos_b = ? " + " where " + " oid_grado_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRADO_LEG, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCantJuegosA()!=null)
			qUpdate.setInt(CANT_JUEGOS_A , pers.getCantJuegosA().intValue());
		else
			qUpdate.setNull(CANT_JUEGOS_A , Types.INTEGER);
		if (pers.getCantJuegosB()!=null)
			qUpdate.setInt(CANT_JUEGOS_B , pers.getCantJuegosB().intValue());
		else
			qUpdate.setNull(CANT_JUEGOS_B , Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRADO_LEG = 1;
		GradoLegajo pers = (GradoLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhGradosLeg " + " set activo=0 " + " where " + " oid_grado_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRADO_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRADO_LEG = 1;
		GradoLegajo pers = (GradoLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhGradosLeg " + " set activo=1 " + " where " + " oid_grado_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRADO_LEG, pers.getOID());
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
		case SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRADO_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhGradosLeg ");
		textSQL.append(" WHERE oid_grado_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRADO_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhGradosLeg ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhGradosLeg ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grado_leg oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from rhGradosLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getAll(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(GradoLegajo.NICKNAME,
                 DBGradoLegajo.SELECT_ALL,
                 null,
                 new ListObserver(),
                 aSesion);
	}
	

}
